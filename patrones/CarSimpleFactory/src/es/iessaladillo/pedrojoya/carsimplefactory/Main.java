package es.iessaladillo.pedrojoya.carsimplefactory;

import es.iessaladillo.pedrojoya.carsimplefactory.factory.CarFactory;
import es.iessaladillo.pedrojoya.carsimplefactory.product.Car;

public class Main {

    public static void main(String[] args) {
        // We can't change the logic associated with car creation at
        // runtime. We should change CarFactory.create code.
        Car car1 = CarFactory.create(2000, 4);
        System.out.printf("Car1: %s\n", car1);
        Car car2 = CarFactory.create(5000, 1);
        System.out.printf("Car2: %s\n", car2);
        Car car3 = CarFactory.create(2000, 1);
        System.out.printf("Car3: %s\n", car3);
        Car car4 = CarFactory.create(5000, 4);
        System.out.printf("Car4: %s\n", car4);
    }

}
