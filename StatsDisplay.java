

public class StatsDisplay implements Observer, DisplayElement{
	
	private float minTemp =200f;
	private float tempSum =0.0f;
	private float maxTemp =0.0f;
	private int numReadings;
	private WeatherData weatherData; 

	public StatsDisplay(WeatherData weatherData){
		this.weatherData = weatherData;
		weatherData.registerObserver(this);

	}

	
	@Override	
	public void update(float temp, float humidity, float pressure){
		tempSum += temp;
		numReadings++;
		
		if (temp>maxTemp){
			maxTemp = temp;
		}
		if (temp<minTemp){
			minTemp = temp;
		}
		
		display();
	}

	@Override
	public void display() {
		System.out.println("Avg/Max/Min temperature = " + (tempSum / numReadings)
				+ "/" + maxTemp + "/" + minTemp);		
	}	
}
