package es.iessaladillo.pedrojoya.sanwichbuilder.product;

import es.iessaladillo.pedrojoya.sanwichbuilder.product.ingredients.Bread;
import es.iessaladillo.pedrojoya.sanwichbuilder.product.ingredients.Condiment;
import es.iessaladillo.pedrojoya.sanwichbuilder.product.ingredients.Meat;
import es.iessaladillo.pedrojoya.sanwichbuilder.product.ingredients.Sauce;

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

    public abstract static class Builder {

        protected final String style;
        protected String name;
        protected Bread bread;
        protected Meat meat;
        protected final List<Condiment> condiments = new ArrayList<>();
        protected Sauce sauce;

        protected Builder(String style) {
            this.style = style;
        }

        // These methods return the builder to allow fluid sintax
        public abstract Builder setName(String name);
        public abstract Builder setBread(Bread bread);
        public abstract Builder setMeat(Meat meat);
        public abstract Builder addCondiment(Condiment condiment);
        public abstract Builder setSauce(Sauce sauce);

        public Sandwich build() {
            validateMandatoryFields();
            return new Sandwich(this);
        }

        private void validateMandatoryFields() {
            if (name == null || name.isEmpty()) throw new IllegalStateException("Name is mandatory");
            if (bread == null) throw new IllegalStateException("Bread is mandatory");
        }

        public void reset() {
            name = null;
            meat = null;
            condiments.clear();
            sauce = null;
        }

    }

}