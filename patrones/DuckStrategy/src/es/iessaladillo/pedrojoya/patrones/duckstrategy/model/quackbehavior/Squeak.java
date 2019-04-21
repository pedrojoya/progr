package es.iessaladillo.pedrojoya.patrones.duckstrategy.model.quackbehavior;

import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.duck.Duck;

public class Squeak implements QuackBehavior {
    @Override
    public void quack(Duck duck) {
        System.out.printf("%s squeaks\n", duck.getName());
    }
}
