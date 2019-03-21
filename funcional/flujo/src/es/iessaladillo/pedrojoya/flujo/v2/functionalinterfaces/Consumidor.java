package es.iessaladillo.pedrojoya.flujo.v2.functionalinterfaces;

// T es el tipo del parámetro del método
public interface Consumidor<T> {

    void aceptar(T valor);

}
