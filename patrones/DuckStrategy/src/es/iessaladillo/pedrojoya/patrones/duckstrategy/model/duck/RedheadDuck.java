package es.iessaladillo.pedrojoya.patrones.duckstrategy.model.duck;

import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.flybehavior.FlyNoWay;
import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.quackbehavior.Quack;

public class RedheadDuck extends Duck {

    public RedheadDuck(String name) {
        super(name, new FlyNoWay(), new Quack());
    }

    @Override
    public void display() {
        System.out.printf("%s is a red head duck\n", getName());
    }

}
