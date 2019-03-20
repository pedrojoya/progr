package es.iessaladillo.pedrojoya.sandwichsimplebuilder.product;

import es.iessaladillo.pedrojoya.sandwichsimplebuilder.product.ingredients.Bread;
import es.iessaladillo.pedrojoya.sandwichsimplebuilder.product.ingredients.Condiment;
import es.iessaladillo.pedrojoya.sandwichsimplebuilder.product.ingredients.Meat;
import es.iessaladillo.pedrojoya.sandwichsimplebuilder.product.ingredients.Sauce;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sandwich {

    // Sandwich is inmutable
    private final String style;
    private final String name;
    private final Bread bread;
    private final Meat meat;
    private final List<Condiment> condiments;
    private final Sauce sauce;

    public String getStyle() {
        return style;
    }

    public String getName() {
        return name;
    }

    public Bread getBread() {
        return bread;
    }

    public Meat getMeat() {
        return meat;
    }

    public List<Condiment> getCondiments() {
        return new ArrayList<>(condiments);
    }

    public Sauce getSauce() {
        return sauce;
    }

    // Private, so it can only be used from the static inner builder.
    private Sandwich(Builder builder) {
        this.style = builder.style;
        this.name = builder.name;
        this.bread = builder.bread;
        this.meat = builder.meat;
        this.condiments = new ArrayList<>(builder.condiments);
        this.sauce = builder.sauce;
    }

    @Override
    public String toString() {
        List<String> ingredients = new ArrayList<>();
        if (bread != null) ingredients.add(bread.getName());
        if (meat != null) ingredients.add(meat.getName());
        ingredients.add(condiments.stream().map(Condiment::getName).collect(Collectors.joining(", ")));
        if (sauce != null) ingredients.add(sauce.getName());
        return style + " " + name + ": " + String.join(", ", ingredients);
    }

    public static class Builder {

        private final String style;
        private final String name;
        private final Bread bread;
        private Meat meat;
        private final List<Condiment> condiments = new ArrayList<>();
        private Sauce sauce;

        public Builder(String style, String name, Bread bread) {
            this.style = style;
            this.name = name;
            this.bread = bread;
        }

        public Builder setMeat(Meat meat) {
            this.meat = meat;
            return this;
        }

        public Builder addCondiment(Condiment condiment) {
            condiments.add(condiment);
            return this;
        }

        public Builder setSauce(Sauce sauce) {
            this.sauce = sauce;
            return this;
        }

        public Sandwich build() {
            return new Sandwich(this);
        }

    }

}