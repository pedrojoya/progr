package es.iessaladillo.pedrojoya.patrones.beveragetemplatemethod.beverage;

public class Tea extends CaffeineBeverage {

    @Override
    void brew() {
        System.out.println("Put tea bag on the water");
    }

    @Override
    void addCondiments() {
        System.out.println("Add a slice of lemmon");
    }

}
