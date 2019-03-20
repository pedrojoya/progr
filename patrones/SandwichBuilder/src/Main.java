import es.iessaladillo.pedrojoya.sanwichbuilder.concretebuilder.GambrinusSandwichBuilder;
import es.iessaladillo.pedrojoya.sanwichbuilder.director.SandwichDirector;
import es.iessaladillo.pedrojoya.sanwichbuilder.product.Sandwich;
import es.iessaladillo.pedrojoya.sanwichbuilder.product.SandwichType;

public class Main {

    public static void main(String[] args) {
        SandwichDirector director = new SandwichDirector(new GambrinusSandwichBuilder());

        Sandwich serranito = director.buildSandwich(SandwichType.SERRANITO);
        Sandwich higado = director.buildSandwich(SandwichType.HIGADO);
        Sandwich catalan = director.buildSandwich(SandwichType.CATALAN);
        System.out.println("Sandwich Serranito - " + serranito);
        System.out.println("Sandwich Hígado - " + higado);
        System.out.println("Sandwich Catalán - " + catalan);
    }

}
