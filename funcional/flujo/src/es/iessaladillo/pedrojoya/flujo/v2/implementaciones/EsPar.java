package es.iessaladillo.pedrojoya.flujo.v2.implementaciones;

import es.iessaladillo.pedrojoya.flujo.v2.functionalinterfaces.Predicado;

public class EsPar implements Predicado<Integer> {
    @Override
    public boolean test(Integer valor) {
        return valor % 2 == 0;
    }
}
