package es.iessaladillo.pedrojoya.weatherpropertychangelistenerobserver.weather.observer;

import es.iessaladillo.pedrojoya.weatherpropertychangelistenerobserver.weather.observable.WeatherStation;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MobileWeatherApp implements PropertyChangeListener {

    private final WeatherStation weatherStation;

    public MobileWeatherApp(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.subscribe(this);
        System.out.println("La aplicación del móvil ha comenzado a observar la estación de clima");
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        System.out.printf("La aplicación del móvil ha sido notificada de que la nueva temperatura es de %.2fºC\n", weatherStation.getTemperature());
    }

    public void close() {
        weatherStation.unsubscribe(this);
        System.out.println("La aplicación del móvil ha dejado de observar la estación de clima");
    }

}
