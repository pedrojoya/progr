package es.iessaladillo.pedrojoya.weatherstreams.ui;

import es.iessaladillo.pedrojoya.weatherstreams.data.entity.Forecast;
import es.iessaladillo.pedrojoya.weatherstreams.service.ForecastService;
import es.iessaladillo.pedrojoya.weatherstreams.service.entity.TempReading;

import java.text.Collator;
import java.time.format.DateTimeFormatter;
import java.util.*;

class MainScreenController {

    private final MainScreenView view;
    private final ForecastService forecastService;
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    private final Collator collator = Collator.getInstance(new Locale("es"));

    public MainScreenController(MainScreenView view, ForecastService forecastService) {
        this.view = view;
        this.forecastService = forecastService;
        collator.setStrength(Collator.PRIMARY);
    }

    public void onShowTotalMaxTemp() {
        forecastService.maxTemp()
                .ifPresentOrElse(this::showMaxTemp, this::showErrorTotalMaxTemp);
    }

    private void showMaxTemp(TempReading tempReading) {
        String message = String.format("La temperatura máxima fue de %.2fºC en la estación de %s (%s) a las %s",
                tempReading.getTemp(), tempReading.getStation(), tempReading.getProvince(), timeFormatter.format(tempReading.getTime()));
        view.showMessage(message);
    }

    private void showErrorTotalMaxTemp() {
        view.showMessage("No se encontró una temperatura máxima");
    }

    public void onShowTotalMinTemp() {
        forecastService.minTemp()
                .ifPresentOrElse(this::showMinTemp, this::showErrorTotalMinTemp);
    }

    private void showErrorTotalMinTemp() {
        view.showMessage("No se encontró una temperatura mínima");
    }

    private void showMinTemp(TempReading tempReading) {
        String message = String.format("La temperatura mínima fue de %.2fºC en la estación de %s (%s) a las %s",
                tempReading.getTemp(), tempReading.getStation(), tempReading.getProvince(), timeFormatter.format(tempReading.getTime()));
        view.showMessage(message);
    }

    public void onShowMaxTempByProvince() {
        showTempMap(forecastService.maxTempByProvince());
    }

    public void onShowMinTempByProvince() {
        showTempMap(forecastService.minTempByProvince());
    }

    private void showTempByProvince(Map<String, Optional<TempReading>> map) {
        StringBuilder sb = new StringBuilder();
        map.entrySet()
                .forEach(entry -> sb.append(buildProvinceTempDescription(entry)));
        view.showMessage(sb.toString());
    }

    private String buildProvinceTempDescription(Map.Entry<String, Optional<TempReading>> entry) {
        String description;
        Optional<TempReading> entryValue = entry.getValue();
        if (entryValue.isPresent()) {
            TempReading tempReading = entryValue.get();
            description = String.format("%6.2fºC | %-6s | %s", tempReading.getTemp(), timeFormatter.format(tempReading.getTime()), tempReading.getStation());
        } else {
            description = "<No disponible>";
        }
        return String.format("%-25s | %s\n", entry.getKey(), description);
    }

    private void showErrorTempByProvince() {
        view.showMessage("No hay datos que mostrar");
    }

    private void showTempMap(Map<String, Optional<TempReading>> map) {
        if (map.isEmpty()) {
            showErrorTempByProvince();
        } else {
            showTempByProvince(map);
        }
    }

    public void onShowAverTempByProvince() {
        Map<String, Double> map = forecastService.averageTempByProvince();
        if (map.isEmpty()) {
            showErrorAverageTempByProvince();
        } else {
            showAverageTempByProvince(map);
        }
    }

    private void showErrorAverageTempByProvince() {
        view.showMessage("No hay datos que mostrar");
    }

    private void showAverageTempByProvince(Map<String, Double> map) {
        StringBuilder sb = new StringBuilder();
        map.entrySet()
                .forEach(entry -> sb.append(buildProvinceAverageTempDescription(entry)));
        view.showMessage(sb.toString());
    }

    private String buildProvinceAverageTempDescription(Map.Entry<String, Double> entry) {
        return String.format("%-25s | %6.2fºC\n", entry.getKey(), entry.getValue());
    }

    public void onShowProvinceTempSummary(String province) {
        List<Forecast> list = forecastService.forecastsByProvince(province);
        if (list.isEmpty()) {
            showErrorProvinceTempSummary();
        } else {
            showProvinceTempSummary(list);
        }
    }

    private void showProvinceTempSummary(List<Forecast> list) {
        StringBuilder sb = new StringBuilder();
        list.stream()
                .sorted(Comparator.comparing(Forecast::getStation, collator))
                .forEachOrdered(forecast -> sb.append(buildForecastTempSummaryDescription(forecast)));
        view.showMessage(sb.toString());
    }

    private String buildForecastTempSummaryDescription(Forecast forecast) {
        return String.format("%-35s | %6.2fºC (%s) | %6.2fºC (%s) | %6.2fºC\n",
                forecast.getStation(), forecast.getMaxTemp().getTemp(), forecast.getMaxTemp().getTime(),
                forecast.getMinTemp().getTemp(), forecast.getMinTemp().getTime(), forecast.getAverageTemp());
    }

    private void showErrorProvinceTempSummary() {
        view.showMessage("No hay datos que mostrar");
    }

}
