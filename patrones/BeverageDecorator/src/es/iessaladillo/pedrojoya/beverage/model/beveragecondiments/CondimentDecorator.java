package es.iessaladillo.pedrojoya.beverage.model.beveragecondiments;

import es.iessaladillo.pedrojoya.beverage.model.beverage.Beverage;

import java.math.BigDecimal;

// La clase se hace abstracta para que no se pueda instanciar directamente.
// Es importantísimo que los decoradores extiendan de la misma clase de los
// objetos que van a decorar, para podamos componer un ingrediente sobre otro.
// Usamos aquí la herencia simplemente para que sea del mismo tipo, no para
// agregar comportamiento. El comportamiento se consigue a través de la composición.
public abstract class CondimentDecorator extends Beverage {

    // Contiene una bebida, a la que decora
    protected final Beverage beverage;

    // Dado que los ingredientes reciben en el constructor la bebida que
    // deben decorar, es imposible que el cliente cree como una bebida algo que
    // no lleve una bebida base.
    public CondimentDecorator(String description, Beverage beverage) {
        super(description);
        this.beverage = beverage;
    }

    // Creamos la implementación por defecto que consiste en NO decorar
    // la bebida.
    // Esta implementación podrá ser sobrescrita por los distintos subtipos
    // de decorador.

    @Override
    public BigDecimal getCost() {
        // Por defecto los ingredientes son "gratis".
        return beverage.getCost();
    }

    @Override
    public String getDescription() {
        // Por defecto la descripción consiste en concatenarle a la descripción
        // de la bebida la descripción del ingrediente.
        return beverage.getDescription() + ", " + description;
    }

}
