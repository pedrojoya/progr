package es.iessaladillo.pedrojoya.weatherstreams.service;

import es.iessaladillo.pedrojoya.weatherstreams.data.Database;
import es.iessaladillo.pedrojoya.weatherstreams.data.entity.Forecast;
import es.iessaladillo.pedrojoya.weatherstreams.service.entity.TempReading;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ForecastServiceImp implements ForecastService {

    private final Database database;
    private final Collator collator;

    public ForecastServiceImp(Database database, Collator collator) {
        this.database = database;
        this.collator = collator;
    }

    @Override
    public Map<String, Optional<TempReading>> maxTempByProvince() {
        // El recolector crea un nuevo TempReading a partir de cada forecast con la temp máxima
        // y luego se queda con el TempReading que tenga la mayor temperatura.
        Collector<Forecast, ?, Optional<TempReading>> maxTempReading =
                Collectors.mapping(f ->
                                new TempReading(f.getDate(), f.getStation(), f.getProvince(), f.getMaxTemp().getTemp(), f.getMaxTemp().getTime()),
                        Collectors.maxBy(Comparator.comparing(TempReading::getTemp)));
        return database.queryAllForecasts().stream()
                .sorted(Comparator.comparing(Forecast::getProvince, collator))
                // Se usa la versión de groupingBy que recibe como segundo parámetro un MapFactory para que
                // se retorne un mapa ordenado, de ahí que pasemos TreeMap.
                .collect(Collectors.groupingBy(Forecast::getProvince, () -> new TreeMap<>(collator), maxTempReading));
    }

    @Override
    public Map<String, Optional<TempReading>> minTempByProvince() {
        // El recolector crea un nuevo TempReading a partir de cada forecast con la temp mínima
        // y luego se queda con el TempReading que tenga la menor temperatura.
        Collector<Forecast, ?, Optional<TempReading>> minTempReading =
                Collectors.mapping(f ->
                                new TempReading(f.getDate(), f.getStation(), f.getProvince(), f.getMinTemp().getTemp(), f.getMinTemp().getTime()),
                        Collectors.minBy(Comparator.comparing(TempReading::getTemp)));
        return database.queryAllForecasts().stream()
                .sorted(Comparator.comparing(Forecast::getProvince, collator))
                // Se usa la versión de groupingBy que recibe como segundo parámetro un MapFactory para que
                // se retorne un mapa ordenado, de ahí que pasemos TreeMap.
                .collect(Collectors.groupingBy(Forecast::getProvince, () -> new TreeMap<>(collator), minTempReading));
    }

    @Override
    public Map<String, Double> averageTempByProvince() {
        return database.queryAllForecasts().stream()
                .sorted(Comparator.comparing(Forecast::getProvince, collator))
                // Se usa la versión de groupingBy que recibe como segundo parámetro un MapFactory para que
                // se retorne un mapa ordenado, de ahí que pasemos TreeMap.
                .collect(Collectors.groupingBy(Forecast::getProvince, () -> new TreeMap<>(collator),
                        Collectors.averagingDouble(Forecast::getAverageTemp)));
    }

    @Override
    public List<Forecast> forecastsByProvince(String province) {
        return database.queryAllForecasts().stream()
                // Se queda solo con los de esa provincia
                .filter(forecast -> collator.equals(forecast.getProvince(), province))
                // Los ordena por estación
                .sorted(Comparator.comparing(Forecast::getStation, collator))
                // Los convierte en lista
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TempReading> maxTemp() {
        return database.queryAllForecasts().stream()
                // Nos quedamos sólo con los datos necesarios
                .map(f -> new TempReading(f.getDate(), f.getStation(), f.getProvince(), f.getMaxTemp().getTemp(), f.getMaxTemp().getTime()))
                // Se obtiene el de mayor temperatura
                .max(Comparator.comparing(TempReading::getTemp));
    }

    @Override
    public Optional<TempReading> minTemp() {
        return database.queryAllForecasts().stream()
                // Nos quedamos sólo con los datos necesarios
                .map(f -> new TempReading(f.getDate(), f.getStation(), f.getProvince(), f.getMinTemp().getTemp(), f.getMinTemp().getTime()))
                // Se obtiene el de menor temperatura
                .min(Comparator.comparing(TempReading::getTemp));
    }

}
