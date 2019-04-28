package es.iessaladillo.pedrojoya.doubledispatchvisitor.model.animal;

import es.iessaladillo.pedrojoya.doubledispatchvisitor.model.animalvisitor.AnimalVisitor;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void accept(AnimalVisitor visitor) {
        // El this hace referencia a un objeto Cat, por lo que se
        // ejecutará el método visit(Cat receiver) del visitor.
        visitor.visit(this);
    }

    // Cuando este gato visita a un perro.
    @Override
    public void visit(Dog receiver) {
        System.out.printf("1.- The dog %s is visited by the cat %s\n", receiver.getName(), getName());
    }

    // Cuando este gato visita a otro gato.
    @Override
    public void visit(Cat receiver) {
        System.out.printf("2.- The cat %s is visited by the cat %s\n", receiver.getName(), getName());
    }

}
