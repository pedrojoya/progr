package es.iessaladillo.pedrojoya.beverage.model.beveragecondiments;

import es.iessaladillo.pedrojoya.beverage.model.beverage.Beverage;

import java.math.BigDecimal;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        super("Whip", beverage);
    }

    @Override
    public BigDecimal getCost() {
        return beverage.getCost().add(new BigDecimal(0.10));
    }

}
