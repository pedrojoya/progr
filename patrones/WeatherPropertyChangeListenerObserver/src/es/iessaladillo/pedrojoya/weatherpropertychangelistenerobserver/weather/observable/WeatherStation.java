package es.iessaladillo.pedrojoya.weatherpropertychangelistenerobserver.weather.observable;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WeatherStation {

    // Se usa un observable.
    private final PropertyChangeSupport observable;

    private float temperature;

    public WeatherStation() {
        // Se asocia al Weather Station.
        this.observable = new PropertyChangeSupport(this);
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        // Se notifica a los observadores del valor nuevo y el valor antiguo.
        float oldValue = this.temperature;
        this.temperature = temperature;
        observable.firePropertyChange("temperature", oldValue, this.temperature);
    }

    public void subscribe(PropertyChangeListener observer) {
        observable.addPropertyChangeListener(observer);
    }

    public void unsubscribe(PropertyChangeListener observer) {
        observable.removePropertyChangeListener(observer);
    }

}
