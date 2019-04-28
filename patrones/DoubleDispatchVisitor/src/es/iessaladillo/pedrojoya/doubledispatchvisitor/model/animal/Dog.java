package es.iessaladillo.pedrojoya.doubledispatchvisitor.model.animal;

import es.iessaladillo.pedrojoya.doubledispatchvisitor.model.animalvisitor.AnimalVisitor;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void accept(AnimalVisitor visitor) {
        // El this hace referencia a un objeto Dog, por lo que se
        // ejecutará el método visit(Dog receiver) del visitor.
        visitor.visit(this);
    }

    // Cuando este perro visita a otro perro.
    @Override
    public void visit(Dog receiver) {
        System.out.printf("3.- The dog %s is visited by the dog %s\n", receiver.getName(), getName());
    }

    // Cuando este perro visita a un gato.
    @Override
    public void visit(Cat receiver) {
        System.out.printf("4.- The cat %s is visited by the dog %s\n", receiver.getName(), getName());
    }

}
