package es.iessaladillo.pedrojoya.weatherobserver.base;

public interface Observable {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers();
}
