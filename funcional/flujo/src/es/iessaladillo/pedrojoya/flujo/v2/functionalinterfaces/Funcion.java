package es.iessaladillo.pedrojoya.flujo.v2.functionalinterfaces;

// T es el tipo del parámetro del método
// R es el tipo de retorno del método
public interface Funcion<T, R> {

    R aplicar(T valor);

}
