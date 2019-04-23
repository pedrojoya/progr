package es.iessaladillo.pedrojoya.beverage.model.beverage;

import java.math.BigDecimal;

public class Espresso extends Beverage {

    public Espresso() {
        super("Espresso");
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(1.99);
    }

}
