package es.iessaladillo.pedrojoya.weatherobserver.weather.observer;

import es.iessaladillo.pedrojoya.weatherobserver.base.Observer;
import es.iessaladillo.pedrojoya.weatherobserver.weather.observable.WeatherStation;

public class SmartWatch implements Observer {

    private final WeatherStation weatherStation;

    public SmartWatch(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.subscribe(this);
        System.out.println("El smart watch ha comenzado a observar la estación de clima");
    }

    @Override
    public void update() {
        System.out.printf("El smart watch ha sido notificado de que la nueva temperatura es de %.2fºC\n", weatherStation.getTemperature());
    }

    public void turnOff() {
        weatherStation.unsubscribe(this);
        System.out.println("El smart watch ha dejado de observar la estación de clima");
    }

}
