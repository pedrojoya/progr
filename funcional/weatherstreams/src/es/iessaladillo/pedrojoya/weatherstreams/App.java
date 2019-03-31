package es.iessaladillo.pedrojoya.weatherstreams;

import es.iessaladillo.pedrojoya.weatherstreams.di.Injector;

@SuppressWarnings("WeakerAccess")
public class App {

    public static void main(String[] args) {
        Injector.provideMainScreen().start();
    }

}
