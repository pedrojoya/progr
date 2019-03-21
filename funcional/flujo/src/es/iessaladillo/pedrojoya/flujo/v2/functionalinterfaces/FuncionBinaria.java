package es.iessaladillo.pedrojoya.flujo.v2.functionalinterfaces;

// T es el tipo del primer parámetro del método
// U es el tipo del segundo parámetro del método
// R es el tipo de retorno del método
public interface FuncionBinaria<T, U, R> {

    R aplicar(T valor1, U valor2);

}
