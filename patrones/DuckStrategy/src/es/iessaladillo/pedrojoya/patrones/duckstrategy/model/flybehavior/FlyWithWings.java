package es.iessaladillo.pedrojoya.patrones.duckstrategy.model.flybehavior;

import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.duck.Duck;

public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly(Duck duck) {
        System.out.printf("%s flies with wings\n", duck.getName());
    }
}
