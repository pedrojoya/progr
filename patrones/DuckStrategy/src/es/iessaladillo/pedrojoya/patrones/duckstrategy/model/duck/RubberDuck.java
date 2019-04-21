package es.iessaladillo.pedrojoya.patrones.duckstrategy.model.duck;

import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.flybehavior.FlyNoWay;
import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.quackbehavior.Squeak;

public class RubberDuck extends Duck {

    public RubberDuck(String name) {
        super(name, new FlyNoWay(), new Squeak());
    }

    @Override
    public void display() {
        System.out.printf("%s is a rubber duck\n", getName());
    }

}
