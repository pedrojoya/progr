package es.iessaladillo.pedrojoya.flujo.v3;

import es.iessaladillo.pedrojoya.flujo.v3.functionalinterfaces.Consumidor;
import es.iessaladillo.pedrojoya.flujo.v3.functionalinterfaces.Funcion;
import es.iessaladillo.pedrojoya.flujo.v3.functionalinterfaces.FuncionBinaria;
import es.iessaladillo.pedrojoya.flujo.v3.functionalinterfaces.Predicado;

import java.util.Arrays;

// VERSIÓN USANDO PROGRAMACIÓN FUNCIONAL
// DEFINIENDO UNA CLASE FLUJO
// E IMPLEMENTANDO LAS INTERFACES FUNCIONALES CON CLASES INLINE ANÓNIMAS

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
        Flujo<Integer> numeros = new Flujo<>(Arrays.asList(2, 3, 5, 8));
        // 2.- Quedarme sólo con los pares.
        Flujo<Integer> pares = numeros.filtrar(new Predicado<Integer>() {
            @Override
            public boolean test(Integer valor) {
                return valor % 2 == 0;
            }
        });
        // 3.- Pasar cada número al cuadrado.
        Flujo<Integer> cuadrados = pares.transformar(new Funcion<Integer, Integer>() {
            @Override
            public Integer aplicar(Integer valor) {
                return valor * valor;
            }
        });
        // 4.- Mostrar cada cuadrado por pantalla.
        System.out.print("Cuadrados de números pares: ");
        Flujo<Integer> cuadradosImpresos = cuadrados.paraCada(new Consumidor<Integer>() {
            @Override
            public void aceptar(Integer valor) {
                System.out.printf("%d ", valor);
            }
        });
        System.out.println();
        // 5.- Obtener la suma de los cuadrados:
        Integer total = cuadradosImpresos.reducir(0, new FuncionBinaria<Integer, Integer, Integer>() {
            @Override
            public Integer aplicar(Integer valor1, Integer valor2) {
                return valor1 + valor2;
            }
        });
        System.out.printf("\nSuma de cuadrados de números pares: %d", total);

        // ESTO FUNCIONA, PERO...:
        // - Sigue siendo bastante verboso, debido a las clases inline anónimas.
        // - Definimos demasiadas variables auxiliares.

        // SOLUCIÓN:
        // - Usar lambdas.
        // - Encadenar las llamadas.
    }

}
