package es.iessaladillo.pedrojoya.weatherobserver.weather.observable;

import es.iessaladillo.pedrojoya.weatherobserver.base.Observable;
import es.iessaladillo.pedrojoya.weatherobserver.base.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Observable {

    private final List<Observer> observers = new ArrayList<>();
    private float temperature;

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}
