package es.iessaladillo.pedrojoya.beverage.model.beveragecondiments;

import es.iessaladillo.pedrojoya.beverage.model.beverage.Beverage;

import java.math.BigDecimal;

public class Milk extends CondimentDecorator {

    public Milk(Beverage beverage) {
        super("Milk", beverage);
    }

    @Override
    public BigDecimal getCost() {
        return beverage.getCost().add(new BigDecimal(0.10));
    }

}
