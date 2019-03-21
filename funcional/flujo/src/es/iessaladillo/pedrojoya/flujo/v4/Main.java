package es.iessaladillo.pedrojoya.flujo.v4;

import java.util.Arrays;

// VERSIÓN USANDO PROGRAMACIÓN FUNCIONAL
// DEFINIENDO UNA CLASE FLUJO
// E IMPLEMENTANDO LAS INTERFACES FUNCIONALES CON LAMBDAS

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
                .filtrar(valor -> valor % 2 == 0)
                .transformar(valor -> valor * valor)
                .paraCada(valor -> System.out.printf("%d ", valor))
                .reducir(0, (valor1, valor2) -> valor1 + valor2);
        System.out.printf("\nSuma de cuadrados de números pares: %d", total);

        // ESTO FUNCIONA, PERO...:
        // - Aún tenemos que definir las interfaces funcionales.
        // - Podemos hacer aún más legibles las lambdas.

        // SOLUCIÓN:
        // - Usar interfaces funcionales estándar ya definidas en Java.
        // - Extraer el cuerpo de las lambdas a funciones.
    }

}
