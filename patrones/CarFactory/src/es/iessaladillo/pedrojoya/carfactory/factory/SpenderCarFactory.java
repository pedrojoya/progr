package es.iessaladillo.pedrojoya.carfactory.factory;

import es.iessaladillo.pedrojoya.carfactory.product.Car;
import es.iessaladillo.pedrojoya.carfactory.product.concretemodels.OpelCorsa;
import es.iessaladillo.pedrojoya.carfactory.product.concretemodels.ToyotaRAF4;

public class SpenderCarFactory extends CarFactory {

    // Only one instance of SpenderCarFactory can be created (singleton)
    private static SpenderCarFactory instance;

    public static SpenderCarFactory getInstance() {
        if (instance == null) {
            synchronized (SpenderCarFactory.class) {
                if (instance == null) {
                    instance = new SpenderCarFactory();
                }
            }
        }
        return instance;
    }

    private SpenderCarFactory() {
    }

    @Override
    public Car create(float salary, int familyMembers) {
        if (familyMembers > 2 || salary > 4000) {
            return new ToyotaRAF4();
        } else {
            return new OpelCorsa();
        }
    }

}
