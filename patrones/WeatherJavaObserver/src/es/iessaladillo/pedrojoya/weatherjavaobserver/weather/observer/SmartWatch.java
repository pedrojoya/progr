package es.iessaladillo.pedrojoya.weatherjavaobserver.weather.observer;

import es.iessaladillo.pedrojoya.weatherjavaobserver.weather.observable.WeatherStation;

import java.util.Observable;
import java.util.Observer;

public class SmartWatch implements Observer {

    private final WeatherStation weatherStation;

    public SmartWatch(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.addObserver(this);
        System.out.println("El smart watch ha comenzado a observar la estación de clima");
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.printf("El smart watch ha sido notificado de que la nueva temperatura es de %.2fºC\n", weatherStation.getTemperature());
    }

    public void turnOff() {
        weatherStation.deleteObserver(this);
        System.out.println("El smart watch ha dejado de observar la estación de clima");
    }

}
