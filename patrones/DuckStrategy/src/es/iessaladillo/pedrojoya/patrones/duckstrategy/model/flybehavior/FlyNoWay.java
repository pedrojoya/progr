package es.iessaladillo.pedrojoya.patrones.duckstrategy.model.flybehavior;

import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.duck.Duck;

public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly(Duck duck) {
        System.out.printf("%s can't fly\n", duck.getName());
    }
}
