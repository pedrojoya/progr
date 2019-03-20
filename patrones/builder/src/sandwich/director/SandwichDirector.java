package sandwich.director;

import sandwich.product.Sandwich;
import sandwich.product.SandwichType;
import sandwich.product.ingredients.Bread;
import sandwich.product.ingredients.Condiment;
import sandwich.product.ingredients.Meat;
import sandwich.product.ingredients.Sauce;

public class SandwichDirector {

    private final Sandwich.Builder builder;

    public SandwichDirector(Sandwich.Builder builder) {
        this.builder = builder;
    }

    public Sandwich buildSandwich(SandwichType sandwichType) {
        switch (sandwichType) {
            case SERRANITO:
                return builder
                        .setName("Serranito")
                        .setBread(new Bread("pulguita"))
                        .setMeat(new Meat("lomo"))
                        .addCondiment(new Condiment("pimiento"))
                        .addCondiment(new Condiment("jamón"))
                        .build();
            case HIGADO:
                return builder
                        .setName("Higado")
                        .setBread(new Bread("pulguita"))
                        .setMeat(new Meat("higado"))
                        .addCondiment(new Condiment("tocino"))
                        .build();
            case CATALAN:
                return builder
                        .setName("Catalan")
                        .setBread(new Bread("tosta"))
                        .addCondiment(new Condiment("jamón"))
                        .addCondiment(new Condiment("tomate"))
                        .setSauce(new Sauce("aceite"))
                        .build();
            default:
                throw new RuntimeException("Tipo de sandwich desconocido");
        }
    }

}
