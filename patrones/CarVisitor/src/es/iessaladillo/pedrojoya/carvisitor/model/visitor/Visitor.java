package es.iessaladillo.pedrojoya.carvisitor.model.visitor;

import es.iessaladillo.pedrojoya.carvisitor.model.Car;
import es.iessaladillo.pedrojoya.carvisitor.model.part.Engine;
import es.iessaladillo.pedrojoya.carvisitor.model.part.HeadLight;
import es.iessaladillo.pedrojoya.carvisitor.model.part.Wheel;

public interface Visitor {

    void visit(Engine engine);
    void visit(HeadLight headLight);
    void visit(Wheel light);
    void visit(Car car);

}
