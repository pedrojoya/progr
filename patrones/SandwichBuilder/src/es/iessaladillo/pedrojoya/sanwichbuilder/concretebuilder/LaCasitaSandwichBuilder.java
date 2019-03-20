package es.iessaladillo.pedrojoya.sanwichbuilder.concretebuilder;

import es.iessaladillo.pedrojoya.sanwichbuilder.product.Sandwich;
import es.iessaladillo.pedrojoya.sanwichbuilder.product.ingredients.Bread;
import es.iessaladillo.pedrojoya.sanwichbuilder.product.ingredients.Condiment;
import es.iessaladillo.pedrojoya.sanwichbuilder.product.ingredients.Meat;
import es.iessaladillo.pedrojoya.sanwichbuilder.product.ingredients.Sauce;

public class LaCasitaSandwichBuilder extends Sandwich.Builder {

    private static final String LA_CASITA_STYLE = "La Casita";

    public LaCasitaSandwichBuilder() {
        super(LA_CASITA_STYLE);
    }

    @Override
    public Sandwich.Builder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Sandwich.Builder setBread(Bread bread) {
        this.bread = bread;
        return this;
    }

    @Override
    public Sandwich.Builder setMeat(Meat meat) {
        this.meat = meat;
        return this;
    }

    @Override
    public Sandwich.Builder addCondiment(Condiment condiment) {
        this.condiments.add(condiment);
        // La Casita always adds double condiment
        this.condiments.add(condiment);
        return this;
    }

    @Override
    public Sandwich.Builder setSauce(Sauce sauce) {
        this.sauce = sauce;
        return this;
    }

}
