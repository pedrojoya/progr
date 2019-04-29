package es.iessaladillo.pedrojoya.carvisitor.model.part;

import es.iessaladillo.pedrojoya.carvisitor.model.visitor.Visitor;

public class Engine extends Part {

    public Engine(String description) {
        super(description);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
