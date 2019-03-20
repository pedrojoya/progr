package sandwich.concretebuilder;

import sandwich.product.Sandwich;
import sandwich.product.ingredients.Bread;
import sandwich.product.ingredients.Condiment;
import sandwich.product.ingredients.Meat;
import sandwich.product.ingredients.Sauce;

public class GambrinusSandwichBuilder extends Sandwich.Builder {

    private static final String STYLE = "Gambrinus";

    public GambrinusSandwichBuilder() {
        super(STYLE);
    }


    @Override
    public Sandwich.Builder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public Sandwich.Builder setBread(Bread bread) {
        this.bread = bread;
        condiments.add(new Condiment("semillas de sésamo"));
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
        return this;
    }

    @Override
    public Sandwich.Builder setSauce(Sauce sauce) {
        this.sauce = sauce;
        // This is Gambrinu's secret ingrendient.
        this.condiments.add(new Condiment("pimienta"));
        return this;
    }

}
