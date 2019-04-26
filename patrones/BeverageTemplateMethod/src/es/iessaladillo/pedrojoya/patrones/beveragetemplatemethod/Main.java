package es.iessaladillo.pedrojoya.patrones.beveragetemplatemethod;

import es.iessaladillo.pedrojoya.patrones.beveragetemplatemethod.beverage.Coffee;
import es.iessaladillo.pedrojoya.patrones.beveragetemplatemethod.beverage.Tea;

public class Main {

    public static void main(String[] args) {
        Coffee coffee = new Coffee();
        coffee.prepareRecipe();
        Tea tea = new Tea();
        tea.prepareRecipe();
    }

}
