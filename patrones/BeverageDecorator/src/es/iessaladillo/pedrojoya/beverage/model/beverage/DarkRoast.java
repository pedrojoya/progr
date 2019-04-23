package es.iessaladillo.pedrojoya.beverage.model.beverage;

import java.math.BigDecimal;

public class DarkRoast extends Beverage {

    public DarkRoast() {
        super("Dark roast coffee");
    }

    @Override
    public BigDecimal getCost() {
        return new BigDecimal(0.99);
    }

}
