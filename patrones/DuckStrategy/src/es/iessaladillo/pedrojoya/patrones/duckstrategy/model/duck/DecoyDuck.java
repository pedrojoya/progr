package es.iessaladillo.pedrojoya.patrones.duckstrategy.model.duck;

import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.flybehavior.FlyNoWay;
import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.quackbehavior.MuteQuack;

public class DecoyDuck extends Duck {

    public DecoyDuck(String name) {
        super(name, new FlyNoWay(), new MuteQuack());
    }

    @Override
    public void display() {
        System.out.printf("%s is a decoy duck\n", getName());
    }

}
