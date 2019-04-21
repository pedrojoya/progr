package es.iessaladillo.pedrojoya.patrones.duckstrategy.model.quackbehavior;

import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.duck.Duck;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack(Duck duck) {
        System.out.printf("%s makes no sound\n", duck.getName());
    }
}
