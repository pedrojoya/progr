package es.iessaladillo.pedrojoya.patrones.multipledispatchpolymorphism;

import es.iessaladillo.pedrojoya.patrones.multipledispatchpolymorphism.model.Animal;
import es.iessaladillo.pedrojoya.patrones.multipledispatchpolymorphism.model.Cat;
import es.iessaladillo.pedrojoya.patrones.multipledispatchpolymorphism.model.Dog;

class Main {

    public static void main(String[] args) {
        Animal myDog1 = new Dog("Rufus");
        Animal myCat1 = new Cat("Tom");
        Animal myDog2 = new Dog("Anton");
        Animal myCat2 = new Cat("Baldo");
        myDog1.accept(myCat1);
        myDog1.accept(myCat2);
        myDog1.accept(myDog2);
        myCat1.accept(myCat2);
        myCat1.accept(myDog1);
        myCat1.accept(myDog2);
        myDog2.accept(myCat1);
        myDog2.accept(myCat2);
        myDog2.accept(myDog1);
        myCat2.accept(myCat1);
        myCat2.accept(myDog1);
        myCat2.accept(myDog2);
    }

}
