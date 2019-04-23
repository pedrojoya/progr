package es.iessaladillo.pedrojoya.beverage.model.beverage;

import java.math.BigDecimal;

// Abstracción para representar un bebida.
public abstract class Beverage {

    protected final String description;

    public Beverage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // El precio depende del tipo de bebida del que se trate, de ahí
    // que el método sea abstracto.
    public abstract BigDecimal getCost();

}

