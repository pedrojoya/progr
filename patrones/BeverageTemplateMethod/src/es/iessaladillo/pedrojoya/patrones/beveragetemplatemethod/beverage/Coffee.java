package es.iessaladillo.pedrojoya.patrones.beveragetemplatemethod.beverage;

public class Coffee extends CaffeineBeverage {

    @Override
    protected void brew() {
        System.out.println("Brew coffee");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Add sugar");
    }

    @Override
    protected void onWaterBoilded() {
        System.out.println("Smell the coffee");;
    }

}
