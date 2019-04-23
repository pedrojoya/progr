package es.iessaladillo.pedrojoya.beverage.model.beveragecondiments;

import es.iessaladillo.pedrojoya.beverage.model.beverage.Beverage;

import java.math.BigDecimal;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        super("Mocha", beverage);
    }

    @Override
    public BigDecimal getCost() {
        return beverage.getCost().add(new BigDecimal(0.20));
    }

}
