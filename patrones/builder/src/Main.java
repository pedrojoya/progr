import sandwich.concretebuilder.GambrinusSandwichBuilder;
import sandwich.concretebuilder.LaCasitaSandwichBuilder;
import sandwich.director.SandwichDirector;
import sandwich.product.Sandwich;
import sandwich.product.SandwichType;

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
