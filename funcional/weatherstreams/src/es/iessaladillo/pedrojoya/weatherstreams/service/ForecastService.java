package es.iessaladillo.pedrojoya.weatherstreams.service;

import es.iessaladillo.pedrojoya.weatherstreams.data.entity.Forecast;
import es.iessaladillo.pedrojoya.weatherstreams.service.entity.TempReading;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ForecastService {

    Map<String, Optional<TempReading>> maxTempByProvince();

    Map<String, Optional<TempReading>> minTempByProvince();

    Map<String, Double> averageTempByProvince();

    List<Forecast> forecastsByProvince(String province);

    Optional<TempReading> maxTemp();

    Optional<TempReading> minTemp();

}
