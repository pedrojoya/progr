package es.iessaladillo.pedrojoya.weatherstreams.data.entity;

import java.time.LocalDate;

public class Forecast {
	
	private final LocalDate date;
	private final String station;
	private final String province;
	private final TimeTemp maxTemp;
	private final TimeTemp minTemp;
	private final float rainfall;

	public Forecast(LocalDate date, String station, String province, TimeTemp maxTemp,
					TimeTemp minTemp, float rainfall) {
		this.date = date;
		this.station = station;
		this.province = province;
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
		this.rainfall = rainfall;
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

	public TimeTemp getMaxTemp() {
		return maxTemp;
	}

	public TimeTemp getMinTemp() {
		return minTemp;
	}

	@SuppressWarnings("unused")
	public float getRainfall() {
		return rainfall;
	}

	public double getAverageTemp() {
		return (getMaxTemp().getTemp() + getMinTemp().getTemp()) / 2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((station == null) ? 0 : station.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((maxTemp == null) ? 0 : maxTemp.hashCode());
		result = prime * result + ((minTemp == null) ? 0 : minTemp.hashCode());
		result = prime * result + Float.floatToIntBits(rainfall);
		result = prime * result + ((province == null) ? 0 : province.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Forecast other = (Forecast) obj;
		if (station == null) {
			if (other.station != null)
				return false;
		} else if (!station.equals(other.station))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (maxTemp == null) {
			if (other.maxTemp != null)
				return false;
		} else if (!maxTemp.equals(other.maxTemp))
			return false;
		if (minTemp == null) {
			if (other.minTemp != null)
				return false;
		} else if (!minTemp.equals(other.minTemp))
			return false;
		if (Float.floatToIntBits(rainfall) != Float.floatToIntBits(other.rainfall))
			return false;
		if (province == null) {
			return other.province == null;
		} else return province.equals(other.province);
	}

	@Override
	public String toString() {
		return "Forecast [date=" + date + ", station=" + station + ", province="
				+ province + ", maxTemp=" + maxTemp + ", minTemp=" + minTemp + ", rainfall=" + rainfall + "]";
	}
	
	
	

}
