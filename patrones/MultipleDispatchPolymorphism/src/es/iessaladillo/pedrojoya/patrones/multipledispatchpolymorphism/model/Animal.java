package es.iessaladillo.pedrojoya.patrones.multipledispatchpolymorphism.model;

@SuppressWarnings("unused")
public abstract class Animal {

    final String name;

    Animal(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    // Estamos obligados a definir este método, dado que el cliente pasa como
    // argumento Animal, de manera que el compilador nos obliga a tener un método que reciba
    // un Animal.
    public abstract void accept(Animal animal);
    public abstract void accept(Dog dog);
    public abstract void accept(Cat cat);

}
