package es.iessaladillo.pedrojoya.sanwichbuilder.director;

import es.iessaladillo.pedrojoya.sanwichbuilder.product.Sandwich;
import es.iessaladillo.pedrojoya.sanwichbuilder.product.ingredients.Bread;
import es.iessaladillo.pedrojoya.sanwichbuilder.product.SandwichType;
import es.iessaladillo.pedrojoya.sanwichbuilder.product.ingredients.Condiment;
import es.iessaladillo.pedrojoya.sanwichbuilder.product.ingredients.Meat;
import es.iessaladillo.pedrojoya.sanwichbuilder.product.ingredients.Sauce;

public class SandwichDirector {

    private final Sandwich.Builder builder;

    public SandwichDirector(Sandwich.Builder builder) {
        this.builder = builder;
    }

    public Sandwich buildSandwich(SandwichType sandwichType) {
        builder.reset();
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
                        .setName("Hígado")
                        .setBread(new Bread("pulguita"))
                        .setMeat(new Meat("hígado"))
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
