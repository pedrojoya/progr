package es.iessaladillo.pedrojoya.flujo.v2.implementaciones;

import es.iessaladillo.pedrojoya.flujo.v2.functionalinterfaces.Consumidor;

public class Imprimir implements Consumidor<Integer> {
    @Override
    public void aceptar(Integer valor) {
        System.out.printf("%d ", valor);
    }
}
