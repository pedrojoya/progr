package es.iessaladillo.pedrojoya.flujo.v3;

import es.iessaladillo.pedrojoya.flujo.v3.functionalinterfaces.Consumidor;
import es.iessaladillo.pedrojoya.flujo.v3.functionalinterfaces.Funcion;
import es.iessaladillo.pedrojoya.flujo.v3.functionalinterfaces.FuncionBinaria;
import es.iessaladillo.pedrojoya.flujo.v3.functionalinterfaces.Predicado;

import java.util.ArrayList;
import java.util.List;

public class Flujo<T> {

    private final List<T> valores;

    public Flujo(List<T> valores) {
        this.valores = valores;
    }

    // Retorna un nuevo flujo en la que sólo se encuentren los elementos
    // del flujo original que cumplan con el test indicado en el predicado.
    public Flujo<T> filtrar(Predicado<T> predicado) {
        List<T> resultado = new ArrayList<>();
        for (T valor : valores) {
            if (predicado.test(valor)) {
                resultado.add(valor);
            }
        }
        return new Flujo<>(resultado);
    }

    // Retorna un nuevo flujo resultado de aplicar la función recibida a cada
    // elemento del flujo original.
    public Flujo<T> transformar(Funcion<T, T> funcion) {
        List<T> resultado = new ArrayList<>();
        for (T valor : valores) {
            resultado.add(funcion.aplicar(valor));
        }
        return new Flujo<>(resultado);
    }

    // Realiza para cada elemento del flujo original la acción representada por
    // el método aceptar del consumidor recibido. Retorna un nuevo flujo con los
    // mismos elementos que el original (para poder encadenar).
    public Flujo<T> paraCada(Consumidor<T> consumidor) {
        for (T valor : valores) {
            consumidor.aceptar(valor);
        }
        return new Flujo<>(valores);
    }

    // Retorna el valor del acumulador resultante de aplicar una función binaria de acumulación con cada
    // elemento del flujo original.
    public T reducir(T valorInicialAcumulador, FuncionBinaria<T, T, T> funcionBinaria) {
        T acumulador = valorInicialAcumulador;
        for (T valor : valores) {
            acumulador = funcionBinaria.aplicar(acumulador, valor);
        }
        return acumulador;
    }

}
