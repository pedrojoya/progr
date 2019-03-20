import es.iessaladillo.pedrojoya.sandwichsimplebuilder.product.Sandwich;
import es.iessaladillo.pedrojoya.sandwichsimplebuilder.product.ingredients.Bread;
import es.iessaladillo.pedrojoya.sandwichsimplebuilder.product.ingredients.Condiment;
import es.iessaladillo.pedrojoya.sandwichsimplebuilder.product.ingredients.Meat;
import es.iessaladillo.pedrojoya.sandwichsimplebuilder.product.ingredients.Sauce;

public class Main {

    public static void main(String[] args) {
        // We use a diferent builder for each sandwich.
        Sandwich serranito = new Sandwich.Builder("Estilo propio", "Serranito", new Bread("pulguita"))
                .setMeat(new Meat("lomo"))
                .addCondiment(new Condiment("pimiento"))
                .addCondiment(new Condiment("jamón"))
                .build();
        Sandwich higado = new Sandwich.Builder("Estilo propio", "Higado", new Bread("pulguita"))
                .setMeat(new Meat("higado"))
                .addCondiment(new Condiment("tocino"))
                .build();
        Sandwich catalan = new Sandwich.Builder("Estilo propio", "Catalan", new Bread("tosta"))
                .addCondiment(new Condiment("jamón"))
                .addCondiment(new Condiment("tomate"))
                .setSauce(new Sauce("aceite"))
                .build();
        System.out.println("Sandwich Serranito - " + serranito);
        System.out.println("Sandwich Hígado - " + higado);
        System.out.println("Sandwich Catalán - " + catalan);
    }

}
