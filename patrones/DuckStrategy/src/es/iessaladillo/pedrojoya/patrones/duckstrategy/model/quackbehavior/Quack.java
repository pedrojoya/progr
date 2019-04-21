package es.iessaladillo.pedrojoya.patrones.duckstrategy.model.quackbehavior;

import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.duck.Duck;

public class Quack implements QuackBehavior {
    @Override
    public void quack(Duck duck) {
        System.out.printf("%s says quack quack\n", duck.getName());
    }
}
