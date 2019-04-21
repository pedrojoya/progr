package es.iessaladillo.pedrojoya.patrones.duckstrategy;

import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.duck.*;
import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.flybehavior.FlyNoWay;
import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.quackbehavior.Quack;

class Main {

    public static void main(String[] args) {

        Duck mallardDuck = new MallardDuck("Duck 1");
        mallardDuck.display();
        mallardDuck.performQuack();
        mallardDuck.performFly();

        Duck redheadDuck = new RedheadDuck("Duck 2");
        redheadDuck.display();
        redheadDuck.performQuack();
        redheadDuck.performFly();

        Duck rubberDuck = new RubberDuck("Duck 3");
        rubberDuck.display();
        rubberDuck.performQuack();
        rubberDuck.performFly();

        Duck decoyDuck = new DecoyDuck("Duck 4");
        decoyDuck.display();
        decoyDuck.performQuack();
        decoyDuck.performFly();

        // En este caso creamos un tipo de pato sobre la marcha
        // y le configuramos su estrategia de vuelo y su estrategia de granznido.
        Duck robotDuck = new Duck("Duck 5", new FlyNoWay(), new Quack()) {
            @Override
            public void display() {
                System.out.printf("%s is a robot duck\n", getName());
            }
        };
        robotDuck.display();
        robotDuck.performQuack();
        robotDuck.performFly();

        // En este caso creamos un tipo de pato sobre la marcha
        // y le configuramos su estrategia de vuelo y su estrategia de graznido
        // mediante lambdas.
        Duck jetPackDuck = new Duck("Duck 6",
                duck -> System.out.printf("%s vuela en un jetpack\n", duck.getName()),
                duck -> System.out.printf("%s hace flushhhhhhh\n", duck.getName())) {
            @Override
            public void display() {
                System.out.printf("%s es un jetPack duck\n", getName());
            }
        };
        jetPackDuck.display();
        jetPackDuck.performQuack();
        jetPackDuck.performFly();
    }

}
