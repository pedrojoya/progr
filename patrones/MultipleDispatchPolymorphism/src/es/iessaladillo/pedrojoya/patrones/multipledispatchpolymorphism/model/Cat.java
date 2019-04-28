package es.iessaladillo.pedrojoya.patrones.multipledispatchpolymorphism.model;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    // Este método será llamado incluso aunque el animal pasado como argumento sea
    // un perro o un gato.
    // El motivo es que Java NO implementa el multiple-dispatch polymorphism, es decir,
    // que NO tiene en cuenta el tipo real de los objetos pasados como argumento para
    // decidir qué método ejecutar, sólo tiene en cuenta el tipo real del objeto receptor,
    // esto es, aquel sobre el que se ejecuta el método.
    @Override
    public void accept(Animal animal) {
        System.out.printf("1.- The cat %s is visited by the animal %s\n", name, animal.getName());
    }

    @Override
    public void accept(Dog dog) {
        System.out.printf("2.- The cat %s is visited by the dog %s\n", name, dog.getName());
    }

    @Override
    public void accept(Cat cat) {
        System.out.printf("3.- The cat %s is visited by the cat %s\n", name, cat.getName());
    }

}
