

import java.util.ArrayList;

public class WeatherData implements Subject {

	private ArrayList<Observer> observers;

	public WeatherData() {
		observers = new ArrayList<Observer>();
	}

	public void registerObserver(Observer o) {
		observers.add(o);
	}

	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i > 0) {
			observers.remove(i);
		}
	}

	public void notifyObservers() {
		for (int i=0; i < observers.size();i++){
			Observer observer = (Observer)observers.get(i);
			observer.update(temperature, humidity, pressure);			
		}
	}
	
	public void measurementsChanged(){
		notifyObservers();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure){
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}


	private float temperature;

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	private float humidity;

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	private float pressure;

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	
}
