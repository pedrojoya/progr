package es.iessaladillo.pedrojoya.flujo.v2;

import es.iessaladillo.pedrojoya.flujo.v2.implementaciones.ElevarAlCuadrado;
import es.iessaladillo.pedrojoya.flujo.v2.implementaciones.EsPar;
import es.iessaladillo.pedrojoya.flujo.v2.implementaciones.Imprimir;
import es.iessaladillo.pedrojoya.flujo.v2.implementaciones.Sumar;

import java.util.Arrays;
import java.util.List;

// VERSIÓN USANDO PROGRAMACIÓN FUNCIONAL
// DEFINIENDO INTERFACES FUNCIONALES
// USANDO IMPLEMENTACIÓN MEDIANTE CLASES.

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
        List<Integer> pares = SuperFunciones.filtrar(numeros, new EsPar());
        // 3.- Pasar cada número al cuadrado.
        List<Integer> cuadrados = SuperFunciones.transformar(pares, new ElevarAlCuadrado());
        // 4.- Mostrar cada cuadrado por pantalla.
        System.out.print("Cuadrados de números pares: ");
        List<Integer> cuadradosImpresos = SuperFunciones.paraCada(cuadrados, new Imprimir());
        // 5.- Obtener la suma de los cuadrados:
        Integer total = SuperFunciones.reducir(cuadradosImpresos, 0, new Sumar());
        System.out.printf("\nSuma de cuadrados de números pares: %d", total);

        // ESTO FUNCIONA, PERO...:
        // - Tenemos que andar creando clases que implementen las distintas interfaces funcionales
        //   y que normalmente sólo serán usadas una única vez.
        // - Es muy tedioso y poco legible enganchar la llamada a una superfunción con la siguiente
        //   al tratarse de métodos estáticos.

        // SOLUCIÓN:
        // - Usaremos clases inline anónimas.
        // - Vamos a crear una clase Flujo<T> que haga de wrapper (contenga) una List<T> y llevaremos
        //   las superfunciones a dicha clase.
    }

}
