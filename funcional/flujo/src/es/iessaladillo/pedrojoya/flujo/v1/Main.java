package es.iessaladillo.pedrojoya.flujo.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// VERSIÓN USANDO PROGRAMACIÓN ESTRUCTURADA.

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
        // 1.- Crear lista de enteros.
        List<Integer> numeros = Arrays.asList(2, 3, 5, 8);
        // 2.- Quedarme sólo con los pares.
        List<Integer> pares = filtrarPares(numeros);
        // 3.- Pasar cada número al cuadrado.
        List<Integer> cuadrados = elevarAlCuadrado(pares);
        // 4.- Mostrar cada cuadrado por pantalla.
        System.out.print("Cuadrados de números pares: ");
        List<Integer> cuadradosImpresos = imprimirNumeros(cuadrados);
        // 5.- Obtener la suma de los cuadrados:
        Integer total = sumaNumeros(cuadradosImpresos);
        System.out.printf("\nSuma de cuadrados de números pares: %d", total);

        // ESTO FUNCIONA, PERO...:
        // - Da mucho pereza tener que crear todos esos métodos. ¿Y si quisiéramos
        //   filtrar los números mayores que 5? Tendríamos que crear otro método
        //   muy parecido que sólo variaría en la condición que pondríamos en el if.

        // SOLUCIÓN:
        // - Vamos a crear superfunciones genéricas, como filtrar a las que le pasemos
        //   el código que necesiten para cada caso. ¿Pasar código a las funciones?
        //   ¿Es eso posible?
    }

    private List<Integer> filtrarPares(List<Integer> numeros) {
        List<Integer> resultado = new ArrayList<>();
        for (Integer numero : numeros) {
            if (numero % 2 == 0) {
                resultado.add(numero);
            }
        }
        return resultado;
    }

    private List<Integer> elevarAlCuadrado(List<Integer> numeros) {
        List<Integer> resultado = new ArrayList<>();
        for (Integer numero : numeros) {
            resultado.add(numero * numero);
        }
        return resultado;
    }

    // Retorna una copia de la lista original para poder encadenar
    // llamadas.
    private List<Integer> imprimirNumeros(List<Integer> numeros) {
        for (Integer numero : numeros) {
            System.out.printf("%d ", numero);
        }
        return new ArrayList<>(numeros);
    }

    private Integer sumaNumeros(List<Integer> numeros) {
        Integer acumulador = 0;
        for (Integer numero : numeros) {
            acumulador = acumulador + numero;
        }
        return acumulador;
    }

}
