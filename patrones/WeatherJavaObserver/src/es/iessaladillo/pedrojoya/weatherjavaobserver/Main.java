package es.iessaladillo.pedrojoya.weatherjavaobserver;

import es.iessaladillo.pedrojoya.weatherjavaobserver.weather.observable.WeatherStation;
import es.iessaladillo.pedrojoya.weatherjavaobserver.weather.observer.MobileWeatherApp;
import es.iessaladillo.pedrojoya.weatherjavaobserver.weather.observer.SmartWatch;

class Main {

    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        MobileWeatherApp mobileWeatherApp = new MobileWeatherApp(weatherStation);
        SmartWatch smartWatch = new SmartWatch(weatherStation);

        weatherStation.setTemperature(25.06f);
        weatherStation.setTemperature(24.08f);
        weatherStation.setTemperature(23.21f);

        mobileWeatherApp.close();
        smartWatch.turnOff();
    }

}
