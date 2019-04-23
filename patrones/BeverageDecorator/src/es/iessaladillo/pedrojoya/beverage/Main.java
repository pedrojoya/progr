package es.iessaladillo.pedrojoya.beverage;

import es.iessaladillo.pedrojoya.beverage.model.beverage.Beverage;
import es.iessaladillo.pedrojoya.beverage.model.beverage.DarkRoast;
import es.iessaladillo.pedrojoya.beverage.model.beverage.Espresso;
import es.iessaladillo.pedrojoya.beverage.model.beveragecondiments.Milk;
import es.iessaladillo.pedrojoya.beverage.model.beveragecondiments.Mocha;
import es.iessaladillo.pedrojoya.beverage.model.beveragecondiments.Soy;
import es.iessaladillo.pedrojoya.beverage.model.beveragecondiments.Whip;

import java.text.NumberFormat;

public class Main {

    public static void main(String[] args) {
        // Dark roast with mocka
        Beverage darkRoastMockaWhip = new Whip(new Mocha(new DarkRoast()));
        printOrder(darkRoastMockaWhip);
        // Espresso with milk, mocka, soy and whip
        Beverage espressoWithMilkMockaSoyAndWhip =
                new Whip(new Soy(new Mocha(new Milk(new Espresso()))));
        printOrder(espressoWithMilkMockaSoyAndWhip);
    }

    private static void printOrder(Beverage beverage) {
        System.out.printf("%s -> %s\n", beverage.getDescription(),
                NumberFormat.getCurrencyInstance().format(beverage.getCost()));
    }

}
