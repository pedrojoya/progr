package es.iessaladillo.pedrojoya.weatherstreams.ui;

import es.iessaladillo.pedrojoya.weatherstreams.service.ForecastService;
import es.iessaladillo.pedrojoya.weatherstreams.utils.console.input.ConsoleInput;

import java.util.Collections;

public class MainScreen implements MainScreenView {

    enum MenuItem {

        TOTAL_MAX_TEMP("Temperatura máxima global"),
        TOTAL_MIN_TEMP("Temperatura mínima global"),
        MAX_TEMP_BY_PROVINCE("Temperatura máxima por provincia"),
        MIN_TEMP_BY_PROVINCE("Temperatura mínima por provincia"),
        AVER_TEMP_BY_PROVINCE("Temperatura media por provincia"),
        PROVINCE_TEMP_SUMMARY("Resumen de temperatura en provincia"),
        EXIT("Salir");

        private final String title;

        MenuItem(String title) {
            this.title = title;
        }

    }

    private final MenuItem[] menuItems = MenuItem.values();
    private final MainScreenController controller;

    public MainScreen(ForecastService forecastService) {
        controller = new MainScreenController(this, forecastService);
    }

    public void start() {
        doScreenLoop();
    }

    private void doScreenLoop() {
        MenuItem selectedOption;
        do {
            showMenu();
            selectedOption = MenuItem.values()[requestOption() - 1];
            processSelection(selectedOption);
        } while (selectedOption != MenuItem.EXIT);
    }

    private void showMenu() {
        System.out.println("\nMENÚ PRINCIPAL");
        System.out.println("---------------");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.printf("%d.- %s\n", i + 1, menuItems[i].title);
        }
    }

    private int requestOption() {
        System.out.print("\nElija una opción: ");
        return ConsoleInput.readInt(n -> n >= 1 && n <= menuItems.length);
    }

    private void processSelection(MenuItem selectedOption) {
        switch (selectedOption) {
            case TOTAL_MAX_TEMP:
                showTotalMaxTempOption();
                break;
            case TOTAL_MIN_TEMP:
                showTotalMinTempOption();
                break;
            case MAX_TEMP_BY_PROVINCE:
                showMaxTempByProvinceOption();
                break;
            case MIN_TEMP_BY_PROVINCE:
                showMinTempByProvinceOption();
                break;
            case AVER_TEMP_BY_PROVINCE:
                showAverageTempByProvinceOption();
                break;
            case PROVINCE_TEMP_SUMMARY:
                showProvinceTempSummaryOption();
                break;
            default:
                exit();
        }
    }

    private void showTotalMaxTempOption() {
        System.out.println("\nTEMPERATURA MÁXIMA GLOBAL");
        System.out.println("--------------------------");
        controller.onShowTotalMaxTemp();
    }

    private void showTotalMinTempOption() {
        System.out.println("\nTEMPERATURA MÍNIMA GLOBAL");
        System.out.println("--------------------------");
        controller.onShowTotalMinTemp();
    }

    private void showMaxTempByProvinceOption() {
        System.out.printf("\n%-80s\n", "TEMPERATURA MÁXIMA POR PROVINCIA");
        printDivider(80);
        System.out.printf("%-25s | %7s | %-6s | %s\n", "Provincia", "  Temp. ", " Hora ", "Estación");
        printDivider(80);
        controller.onShowMaxTempByProvince();
    }

    private void showMinTempByProvinceOption() {
        System.out.printf("\n%-80s\n", "TEMPERATURA MINIMA POR PROVINCIA");
        printDivider(80);
        System.out.printf("%-25s | %7s | %-6s | %s\n", "Provincia", "  Temp. ", " Hora ", "Estación");
        printDivider(80);
        controller.onShowMinTempByProvince();
    }

    private void showAverageTempByProvinceOption() {
        System.out.printf("\n%-80s\n", "TEMPERATURA MEDIA POR PROVINCIA");
        printDivider(40);
        System.out.printf("%-25s | %6s\n", "Provincia", "  Temp.");
        printDivider(40);
        controller.onShowAverTempByProvince();
    }

    private void showProvinceTempSummaryOption() {
        System.out.print("Introduzca la provincia: ");
        String province = ConsoleInput.readString();
        System.out.printf("\n%-80s\n", "RESUMEN TEMPERATURAS DE " + province.toUpperCase());
        printDivider(90);
        System.out.printf("%-35s | %-16s | %-16s | %-7s\n", "Estación", "     Máxima", "    Mínima", "  Media");
        printDivider(90);
        controller.onShowProvinceTempSummary(province);
    }

    private void printDivider(int lenght) {
        System.out.println(String.join("", Collections.nCopies(lenght, "-")));
    }

    private void exit() {
        System.out.println("\nBye bye");
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

}
