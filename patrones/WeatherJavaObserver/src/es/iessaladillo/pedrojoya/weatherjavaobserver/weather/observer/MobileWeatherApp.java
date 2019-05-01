package es.iessaladillo.pedrojoya.weatherjavaobserver.weather.observer;

import es.iessaladillo.pedrojoya.weatherjavaobserver.weather.observable.WeatherStation;

import java.util.Observable;
import java.util.Observer;

public class MobileWeatherApp implements Observer {

    private final WeatherStation weatherStation;

    public MobileWeatherApp(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.addObserver(this);
        System.out.println("La aplicación del móvil ha comenzado a observar la estación de clima");
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.printf("La aplicación del móvil ha sido notificada de que la nueva temperatura es de %.2fºC\n", weatherStation.getTemperature());
    }

    public void close() {
        weatherStation.deleteObserver(this);
        System.out.println("La aplicación del móvil ha dejado de observar la estación de clima");
    }

}
