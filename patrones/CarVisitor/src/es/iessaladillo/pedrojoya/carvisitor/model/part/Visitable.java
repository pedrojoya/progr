package es.iessaladillo.pedrojoya.carvisitor.model.part;

import es.iessaladillo.pedrojoya.carvisitor.model.visitor.Visitor;

public interface Visitable {

    void accept(Visitor visitor);

}
