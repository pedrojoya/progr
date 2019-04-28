package es.iessaladillo.pedrojoya.patrones.multipledispatchpolymorphism.model;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void interactsWith(Animal animal) {
        System.out.printf("The cat %s interacts with the animal %s\n", name, animal.getName());
    }

    @Override
    public void interactsWith(Dog dog) {
        System.out.printf("The cat %s interacts with the dog %s\n", name, dog.getName());
    }

    @Override
    public void interactsWith(Cat cat) {
        System.out.printf("The cat %s interacts with the cat %s\n", name, cat.getName());
    }

}
