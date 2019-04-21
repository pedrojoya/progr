package es.iessaladillo.pedrojoya.patrones.duckstrategy.model.duck;

import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.flybehavior.FlyBehavior;
import es.iessaladillo.pedrojoya.patrones.duckstrategy.model.quackbehavior.QuackBehavior;

@SuppressWarnings("unused")
public abstract class Duck {

    private final String name;
    private FlyBehavior flyBehavior;
    private QuackBehavior quackBehavior;

    public Duck(String name, FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.name = name;
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public String getName() {
        return name;
    }

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public abstract void display();

    public void swim() {
        System.out.printf("%s is swimming\n", name);
    }

    public void performFly() {
        // Delegates to behaviour
        flyBehavior.fly(this);
    }

    public void performQuack() {
        quackBehavior.quack(this);
    }

}
