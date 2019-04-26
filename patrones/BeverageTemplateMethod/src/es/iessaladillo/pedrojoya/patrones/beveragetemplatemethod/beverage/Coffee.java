package es.iessaladillo.pedrojoya.patrones.beveragetemplatemethod.beverage;

public class Coffee extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("Brew coffee");
    }

    @Override
    void addCondiments() {
        System.out.println("Add sugar");
    }

    @Override
    void onWaterBoilded() {
        System.out.println("Smell the coffee");
    }

}
