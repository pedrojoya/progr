package es.iessaladillo.pedrojoya.weatherstreams.data.entity;

import java.time.LocalTime;

public class TimeTemp {
	
	private final float temp;
	private final LocalTime time;
	
	public TimeTemp(float temp, LocalTime time) {
		this.temp = temp;
		this.time = time;
	}

	public float getTemp() {
		return temp;
	}

	public LocalTime getTime() {
		return time;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		result = prime * result + Float.floatToIntBits(temp);
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
		TimeTemp other = (TimeTemp) obj;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return Float.floatToIntBits(temp) == Float.floatToIntBits(other.temp);
	}

	@Override
	public String toString() {
		return "TimeTemp [temp=" + temp + ", time=" + time + "]";
	}
	
	

}
