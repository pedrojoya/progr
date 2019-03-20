package es.iessaladillo.pedrojoya.carfactory.factory;

import es.iessaladillo.pedrojoya.carfactory.product.Car;

public abstract class CarFactory {

    public abstract Car create(float salary, int familyMembers);

}
