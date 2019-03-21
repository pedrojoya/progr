package es.iessaladillo.pedrojoya.flujo.v6;

import es.iessaladillo.pedrojoya.flujo.v6.utils.NumeroUtils;

import java.util.Arrays;

// VERSIÓN USANDO PROGRAMACIÓN FUNCIONAL
// DEFINIENDO UNA CLASE FLUJO
// E IMPLEMENTANDO LAS INTERFACES FUNCIONALES ESTÁNDAR CON REFERENCIAS A MÉTODO

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
        Integer total = new Flujo<>(Arrays.asList(2, 3, 5, 8))
                .filtrar(NumeroUtils::esPar)
                .transformar(NumeroUtils::elevarAlCuadrado)
                .paraCada(this::imprimirNumero)
                .reducir(0, Integer::sum);
        System.out.printf("\nSuma de cuadrados de números pares: %d", total);

        // ESTO FUNCIONA, PERO...:
        // - Hemos tenido que definir la clase Flujo con todas las superfunciones

        // SOLUCIÓN:
        // - Usar la clase Stream existente en Java.
    }

    private void imprimirNumero(Integer valor) {
        System.out.printf("%d ", valor);
    }


}
