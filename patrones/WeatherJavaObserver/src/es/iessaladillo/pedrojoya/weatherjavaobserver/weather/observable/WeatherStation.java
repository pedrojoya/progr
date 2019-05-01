package es.iessaladillo.pedrojoya.weatherjavaobserver.weather.observable;

import java.util.Observable;

public class WeatherStation extends Observable {

    private float temperature;

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        setChanged();
        notifyObservers();
    }

}
