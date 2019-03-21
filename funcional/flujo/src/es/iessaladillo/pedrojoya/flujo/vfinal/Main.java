package es.iessaladillo.pedrojoya.flujo.vfinal;

import es.iessaladillo.pedrojoya.flujo.vfinal.utils.NumeroUtils;

import java.util.stream.Stream;

// VERSIÓN FINAL USANDO PROGRAMACIÓN FUNCIONAL
// USANDO LA CLASE STREAM DE JAVA
// E IMPLEMENTANDO LAS INTERFACES FUNCIONALES ESTÁNDARD CON REFERENCIAS A MÉTODO

public class Main {

    // ¿QUE QUEREMOS HACER?
    // 1.- Crear lista de enteros.
    // 2.- Quedarme sólo con los pares
    // 3.- Pasar cada número al cuadrado.
    // 4.- Mostrar cada cuadrado por pantalla.
    // 5.- Obtener la suma de los cuadrados.

    public static void main(String[] args) {
        new Main();
    }

    private Main() {
        // 1.-, 2.-, 3.-, 4.- y 5.-
        System.out.print("Cuadrados de números pares: ");
        Integer total = Stream.of(2, 3, 5, 8)
                .filter(NumeroUtils::esPar)
                .map(NumeroUtils::elevarAlCuadrado)
                .peek(this::imprimirNumero)
                .reduce(0, Integer::sum);
        System.out.printf("\nSuma de cuadrados de números pares: %d", total);
    }

    private void imprimirNumero(Integer valor) {
        System.out.printf("%d ", valor);
    }


}
