package es.iessaladillo.pedrojoya.carfactory;

import es.iessaladillo.pedrojoya.carfactory.factory.CarFactory;
import es.iessaladillo.pedrojoya.carfactory.factory.SaverCarFactory;
import es.iessaladillo.pedrojoya.carfactory.factory.SpenderCarFactory;
import es.iessaladillo.pedrojoya.carfactory.product.Car;
import es.iessaladillo.pedrojoya.carfactory.utils.console.ConsoleInput;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    Main() {
        // We can change in runtime the car creation criteria (the factory
        // to use).
        CarFactory carFactory = requestCarFactory();
        Car car1 = carFactory.create(2000, 4);
        System.out.printf("Car1: %s\n", car1);
        Car car2 = carFactory.create(5000, 1);
        System.out.printf("Car2: %s\n", car2);
        Car car3 = carFactory.create(2000, 1);
        System.out.printf("Car3: %s\n", car3);
        Car car4 = carFactory.create(5000, 4);
        System.out.printf("Car4: %s\n", car4);
    }

    private CarFactory requestCarFactory() {
        System.out.print("¿Intentar que el usuario gaste lo mínimo? (s/n) ");
        boolean saverMode = ConsoleInput.readBoolean();
        if (saverMode) {
            return SaverCarFactory.getInstance();
        } else {
            return SpenderCarFactory.getInstance();
        }
    }

}
