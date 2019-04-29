package es.iessaladillo.pedrojoya.carvisitor.model.visitor.operations;

import es.iessaladillo.pedrojoya.carvisitor.model.Car;
import es.iessaladillo.pedrojoya.carvisitor.model.part.Engine;
import es.iessaladillo.pedrojoya.carvisitor.model.part.HeadLight;
import es.iessaladillo.pedrojoya.carvisitor.model.part.Part;
import es.iessaladillo.pedrojoya.carvisitor.model.part.Wheel;
import es.iessaladillo.pedrojoya.carvisitor.model.visitor.Visitor;

public class Printer implements Visitor {

    @Override
    public void visit(Engine engine) {
        System.out.printf("Printing %s\n", engine.getDescription());
    }

    @Override
    public void visit(HeadLight headLight) {
        System.out.printf("Printing %s\n", headLight.getDescription());
    }

    @Override
    public void visit(Wheel wheel) {
        System.out.printf("Printing %s\n", wheel.getDescription());
    }

    @Override
    public void visit(Car car) {
        for (Part part : car.getParts()) {
            // Se visitan cada una de las partes.
            part.accept(this);
        }
        System.out.println("Printing car");
    }

}
