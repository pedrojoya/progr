package es.iessaladillo.pedrojoya.flujo.v6;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Flujo<T> {

    private final List<T> valores;

    public Flujo(List<T> valores) {
        this.valores = valores;
    }

    // Retorna un nuevo flujo en la que sólo se encuentren los elementos
    // del flujo original que cumplan con el test indicado en el predicado.
    public Flujo<T> filtrar(Predicate<T> predicado) {
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
    public Flujo<T> transformar(Function<T, T> funcion) {
        List<T> resultado = new ArrayList<>();
        for (T valor : valores) {
            resultado.add(funcion.apply(valor));
        }
        return new Flujo<>(resultado);
    }

    // Realiza para cada elemento del flujo original la acción representada por
    // el método aceptar del consumidor recibido. Retorna un nuevo flujo con los
    // mismos elementos que el original (para poder encadenar).
    public Flujo<T> paraCada(Consumer<T> consumidor) {
        for (T valor : valores) {
            consumidor.accept(valor);
        }
        return new Flujo<>(valores);
    }

    // Retorna el valor del acumulador resultante de aplicar una función binaria de acumulación con cada
    // elemento del flujo original.
    public T reducir(T valorInicialAcumulador, BiFunction<T, T, T> funcionBinaria) {
        T acumulador = valorInicialAcumulador;
        for (T valor : valores) {
            acumulador = funcionBinaria.apply(acumulador, valor);
        }
        return acumulador;
    }

}
