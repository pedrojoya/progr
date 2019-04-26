package es.iessaladillo.pedrojoya.patrones.beveragetemplatemethod;

import es.iessaladillo.pedrojoya.patrones.beveragetemplatemethod.beverage.CaffeineBeverage;
import es.iessaladillo.pedrojoya.patrones.beveragetemplatemethod.beverage.Coffee;
import es.iessaladillo.pedrojoya.patrones.beveragetemplatemethod.beverage.Tea;

class Main {

    public static void main(String[] args) {
        CaffeineBeverage coffee = new Coffee();
        coffee.prepareRecipe();
        CaffeineBeverage tea = new Tea();
        tea.prepareRecipe();
    }

}
