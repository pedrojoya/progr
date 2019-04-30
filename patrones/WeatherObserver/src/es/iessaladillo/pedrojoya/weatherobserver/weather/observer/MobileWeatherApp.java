package es.iessaladillo.pedrojoya.weatherobserver.weather.observer;

import es.iessaladillo.pedrojoya.weatherobserver.base.Observer;
import es.iessaladillo.pedrojoya.weatherobserver.weather.observable.WeatherStation;

public class MobileWeatherApp implements Observer {

    private final WeatherStation weatherStation;

    public MobileWeatherApp(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
        weatherStation.subscribe(this);
        System.out.println("La aplicación del móvil ha comenzado a observar la estación de clima");
    }

    @Override
    public void update() {
        System.out.printf("La aplicación del móvil ha sido notificada de que la nueva temperatura es de %.2fºC\n", weatherStation.getTemperature());
    }

    public void close() {
        weatherStation.unsubscribe(this);
        System.out.println("La aplicación del móvil ha dejado de observar la estación de clima");
    }

}
