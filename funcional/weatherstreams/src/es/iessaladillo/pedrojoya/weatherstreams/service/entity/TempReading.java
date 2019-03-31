package es.iessaladillo.pedrojoya.weatherstreams.service.entity;

import java.time.LocalDate;
import java.time.LocalTime;

public class TempReading {

    private final LocalDate date;
    private final String station;
    private final String province;
    private final float temp;
    private final LocalTime time;

    public TempReading(LocalDate date, String station, String province, float temp, LocalTime time) {
        this.date = date;
        this.station = station;
        this.province = province;
        this.temp = temp;
        this.time = time;
    }

    @SuppressWarnings("unused")
    public LocalDate getDate() {
        return date;
    }

    public String getStation() {
        return station;
    }

    public String getProvince() {
        return province;
    }

    public float getTemp() {
        return temp;
    }

    public LocalTime getTime() {
        return time;
    }

}
