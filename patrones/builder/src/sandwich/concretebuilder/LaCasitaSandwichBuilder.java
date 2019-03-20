package sandwich.concretebuilder;

import sandwich.product.Sandwich;
import sandwich.product.ingredients.Bread;
import sandwich.product.ingredients.Condiment;
import sandwich.product.ingredients.Meat;
import sandwich.product.ingredients.Sauce;

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
