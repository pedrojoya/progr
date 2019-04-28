package es.iessaladillo.pedrojoya.doubledispatchvisitor.model.animalvisitor;

import es.iessaladillo.pedrojoya.doubledispatchvisitor.model.animal.Cat;
import es.iessaladillo.pedrojoya.doubledispatchvisitor.model.animal.Dog;

public interface AnimalVisitor {

    // Representa la visita a un perro.
    void visit(Dog receiver);
    // Representa la visita a un gato.
    void visit(Cat receiver);

}
