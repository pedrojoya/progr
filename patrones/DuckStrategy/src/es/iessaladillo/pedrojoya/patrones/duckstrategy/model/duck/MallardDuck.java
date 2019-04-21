package es.iessaladillo.pedrojoya.patrones.duckstrategy.model.duck;

import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.flybehavior.FlyWithWings;
import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.quackbehavior.Quack;

public class MallardDuck extends Duck {

    public MallardDuck(String name) {
        super(name, new FlyWithWings(), new Quack());
    }

    @Override
    public void display() {
        System.out.printf("%s is a mallard duck\n", getName());
    }

}
