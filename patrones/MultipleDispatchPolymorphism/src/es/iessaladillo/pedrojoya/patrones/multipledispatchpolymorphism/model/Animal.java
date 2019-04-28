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

    // Estamos obligados a definir este método, y de hecho será el método que
    // será llamado aunque se reciba como argumento una variable del tipo Animal
    // que contenga un objeto de la clase Dog o de la clase Cat.
    // El motivo es que Java NO implementa el multiple-dispatch polymorphism, es decir,
    // que NO tiene en cuenta el tipo real de los objetos pasados como argumento para
    // decidir qué método ejecutar, sólo tiene en cuenta el tipo real del objeto receptor
    // sobre el que se ejecuta el método.
    public abstract void interactsWith(Animal animal);
    public abstract void interactsWith(Dog dog);
    public abstract void interactsWith(Cat cat);

}
