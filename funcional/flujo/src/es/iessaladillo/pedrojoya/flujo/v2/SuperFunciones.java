package es.iessaladillo.pedrojoya.flujo.v2;

import es.iessaladillo.pedrojoya.flujo.v2.functionalinterfaces.Consumidor;
import es.iessaladillo.pedrojoya.flujo.v2.functionalinterfaces.Funcion;
import es.iessaladillo.pedrojoya.flujo.v2.functionalinterfaces.FuncionBinaria;
import es.iessaladillo.pedrojoya.flujo.v2.functionalinterfaces.Predicado;

import java.util.ArrayList;
import java.util.List;

// Clase de utilidad con funciones genéricas que reciben una lista de valores
// y hacen algo con cada una de ellas.
public class SuperFunciones {

    private SuperFunciones() {
    }

    // Retorna una nueva lista en la que sólo se encuentren los elementos
    // de la lista original que cumplan con el test indicado en el predicado.
    public static <T> List<T> filtrar(List<T> valores, Predicado<T> predicado) {
        List<T> resultado = new ArrayList<>();
        for (T valor : valores) {
            if (predicado.test(valor)) {
                resultado.add(valor);
            }
        }
        return resultado;
    }

    // Retorna una nueva lista resultado de aplicar la función recibida a cada
    // elemento de la lista recibida.
    public static <T> List<T> transformar(List<T> valores, Funcion<T, T> funcion) {
        List<T> resultado = new ArrayList<>();
        for (T valor : valores) {
            resultado.add(funcion.aplicar(valor));
        }
        return resultado;
    }

    // Realiza para cada elemento de la lista recibida la acción representada por
    // el método aceptar del consumidor. Retorna una copia de la lista original
    // para poder encadenar llamadas.
    public static <T> List<T> paraCada(List<T> valores, Consumidor<T> consumidor) {
        for (T valor : valores) {
            consumidor.aceptar(valor);
        }
        return new ArrayList<>(valores);
    }

    // Retorna el valor del acumulador resultante de aplicar una función binaria de acumulación con cada
    // elemento de la lista recibida.
    public static <T> T reducir(List<T> valores, T valorInicialAcumulador, FuncionBinaria<T, T, T> funcionBinaria) {
        T acumulador = valorInicialAcumulador;
        for (T valor : valores) {
            acumulador = funcionBinaria.aplicar(acumulador, valor);
        }
        return acumulador;
    }

}
