package es.iessaladillo.pedrojoya.patrones.beveragetemplatemethod.beverage;

public class Tea extends CaffeineBeverage {

    @Override
    protected void brew() {
        System.out.println("Put tea bag on the water");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Add a slice of lemmon");
    }

}
