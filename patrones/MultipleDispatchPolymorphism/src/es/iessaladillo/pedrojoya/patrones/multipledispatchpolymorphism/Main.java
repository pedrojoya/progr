package es.iessaladillo.pedrojoya.patrones.multipledispatchpolymorphism;

import es.iessaladillo.pedrojoya.patrones.multipledispatchpolymorphism.model.Animal;
import es.iessaladillo.pedrojoya.patrones.multipledispatchpolymorphism.model.Cat;
import es.iessaladillo.pedrojoya.patrones.multipledispatchpolymorphism.model.Dog;

class Main {

    public static void main(String[] args) {
        Animal myDog = new Dog("Rufus");
        Animal myCat = new Cat("Tom");
        myDog.interactsWith(myCat);
        myCat.interactsWith(myDog);
    }

}
