package es.iessaladillo.pedrojoya.flujo.v2.implementaciones;

import es.iessaladillo.pedrojoya.flujo.v2.functionalinterfaces.FuncionBinaria;

public class Sumar implements FuncionBinaria<Integer, Integer, Integer> {
    @Override
    public Integer aplicar(Integer valor1, Integer valor2) {
        return valor1 + valor2;
    }
}
