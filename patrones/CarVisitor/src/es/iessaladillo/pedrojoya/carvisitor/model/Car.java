package es.iessaladillo.pedrojoya.carvisitor.model;

import es.iessaladillo.pedrojoya.carvisitor.model.part.Part;
import es.iessaladillo.pedrojoya.carvisitor.model.part.Visitable;
import es.iessaladillo.pedrojoya.carvisitor.model.visitor.Visitor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Car implements Visitable {

    private final List<Part> parts = new ArrayList<>();

    public void addParts(Part... part) {
        parts.addAll(Arrays.asList(part));
    }

    public List<Part> getParts() {
        return Collections.unmodifiableList(parts);
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
