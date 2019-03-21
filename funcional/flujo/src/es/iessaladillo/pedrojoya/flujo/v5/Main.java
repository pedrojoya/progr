package es.iessaladillo.pedrojoya.flujo.v5;

import es.iessaladillo.pedrojoya.flujo.v5.utils.NumeroUtils;

import java.util.Arrays;

// VERSIÓN USANDO PROGRAMACIÓN FUNCIONAL
// DEFINIENDO UNA CLASE FLUJO
// E IMPLEMENTANDO LAS INTERFACES FUNCIONALES ESTÁNDAR CON LAMBDAS
// CUYO CUERPO ES UNA LLAMDA A UNA FUNCIÓN CUYOS PARÁMETROS
// SON LOS MISMOS QUE LOS DE LA LAMBDA.

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
                .filtrar(valor -> NumeroUtils.esPar(valor))
                .transformar(valor -> NumeroUtils.elevarAlCuadrado(valor))
                .paraCada(valor -> imprimirNumero(valor))
                .reducir(0, (valor1, valor2) -> Integer.sum(valor1, valor2));
        System.out.printf("\nSuma de cuadrados de números pares: %d", total);

        // ESTO FUNCIONA, PERO...:
        // - Podemos hacer aún más legible las lambdas.

        // SOLUCIÓN:
        // - Usar referencias a método.
    }

    private void imprimirNumero(Integer valor) {
        System.out.printf("%d ", valor);
    }

}
