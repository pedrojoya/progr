package es.iessaladillo.pedrojoya.carvisitor;

import es.iessaladillo.pedrojoya.carvisitor.model.Car;
import es.iessaladillo.pedrojoya.carvisitor.model.part.Engine;
import es.iessaladillo.pedrojoya.carvisitor.model.part.HeadLight;
import es.iessaladillo.pedrojoya.carvisitor.model.part.Wheel;
import es.iessaladillo.pedrojoya.carvisitor.model.visitor.operations.Painter;
import es.iessaladillo.pedrojoya.carvisitor.model.visitor.operations.Printer;
import es.iessaladillo.pedrojoya.carvisitor.model.visitor.operations.Renderer;

class Main {

    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.addParts(
                new Engine("main engine"),
                new HeadLight("left headlight"),
                new HeadLight("right headlight"),
                new Wheel("left front wheel"),
                new Wheel("right front wheel"),
                new Wheel("left back wheel"),
                new Wheel("right back wheel"));
        myCar.accept(new Renderer());
        myCar.accept(new Printer());
        myCar.accept(new Painter());
    }

}
