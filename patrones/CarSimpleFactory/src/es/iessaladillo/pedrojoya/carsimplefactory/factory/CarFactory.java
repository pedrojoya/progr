package es.iessaladillo.pedrojoya.carsimplefactory.factory;

import es.iessaladillo.pedrojoya.carsimplefactory.product.Car;
import es.iessaladillo.pedrojoya.carsimplefactory.product.concretemodels.OpelCorsa;
import es.iessaladillo.pedrojoya.carsimplefactory.product.concretemodels.ToyotaRAF4;

public class CarFactory {

    // Static so it can only be one CarFactory created. It could be a singleton but
    // we don't need it because we don't save state.
    public static Car create(float salary, int familyMembers) {
        if (familyMembers > 2 || salary > 4000) {
            return new ToyotaRAF4();
        } else {
            return new OpelCorsa();
        }
    }

}
