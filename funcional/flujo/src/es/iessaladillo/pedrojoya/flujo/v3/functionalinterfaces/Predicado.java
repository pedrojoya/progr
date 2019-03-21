package es.iessaladillo.pedrojoya.flujo.v3.functionalinterfaces;

// T es el tipo del valor recibido por el método
public interface Predicado<T> {

    boolean test(T valor);

}
