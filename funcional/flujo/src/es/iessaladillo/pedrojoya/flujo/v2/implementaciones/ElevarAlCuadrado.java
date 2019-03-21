package es.iessaladillo.pedrojoya.flujo.v2.implementaciones;

import es.iessaladillo.pedrojoya.flujo.v2.functionalinterfaces.Funcion;

public class ElevarAlCuadrado implements Funcion<Integer, Integer> {
    @Override
    public Integer aplicar(Integer valor) {
        return valor * valor;
    }
}
