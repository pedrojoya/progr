package es.iessaladillo.pedrojoya.beverage.model.beveragecondiments;

import es.iessaladillo.pedrojoya.beverage.model.beverage.Beverage;

import java.math.BigDecimal;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        super("Soy", beverage);
    }

    @Override
    public BigDecimal getCost() {
        return beverage.getCost().add(new BigDecimal(0.15));
    }

}
