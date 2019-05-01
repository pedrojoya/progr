package es.iessaladillo.pedrojoya.weatherpropertychangelistenerobserver.weather.observer;

import es.iessaladillo.pedrojoya.weatherpropertychangelistenerobserver.weather.observable.WeatherStation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SmartWatch implements PropertyChangeListener {

    private final WeatherStation weatherStation;

    public SmartWatch(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.subscribe(this);
        System.out.println("El smart watch ha comenzado a observar la estación de clima");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.printf("El smart watch ha sido notificado de que la nueva temperatura es de %.2fºC\n", weatherStation.getTemperature());
    }

    public void turnOff() {
        weatherStation.unsubscribe(this);
        System.out.println("El smart watch ha dejado de observar la estación de clima");
    }

}
