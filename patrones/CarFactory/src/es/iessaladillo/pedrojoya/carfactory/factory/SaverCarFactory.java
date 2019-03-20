package es.iessaladillo.pedrojoya.carfactory.factory;

import es.iessaladillo.pedrojoya.carfactory.product.Car;
import es.iessaladillo.pedrojoya.carfactory.product.concretemodels.OpelCorsa;
import es.iessaladillo.pedrojoya.carfactory.product.concretemodels.ToyotaRAF4;

public class SaverCarFactory extends CarFactory {

    // Only one instance of SpenderCarFactory can be created (singleton)
    private static SaverCarFactory instance;

    public static SaverCarFactory getInstance() {
        if (instance == null) {
            synchronized (SaverCarFactory.class) {
                if (instance == null) {
                    instance = new SaverCarFactory();
                }
            }
        }
        return instance;
    }

    private SaverCarFactory() {
    }

    @Override
    public Car create(float salary, int familyMembers) {
        if (familyMembers > 2 && salary > 4000) {
            return new ToyotaRAF4();
        } else {
            return new OpelCorsa();
        }
    }

}
