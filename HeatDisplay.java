
public class HeatDisplay implements Observer, DisplayElement, ComputeHeatIndex{

		private Subject weatherData;
		private float humidity;
		private float temperature; 

		public HeatDisplay(WeatherData weatherData){
			this.weatherData = weatherData;
			weatherData.registerObserver(this);

		}
		
	private float compIndex (float temperature, float humidity){
	
		float t = 9*(temperature +32)/5;
		
		float index = (float)((16.923 + (0.185212 * t) + (5.37941 * humidity) - 
				(0.100254 * t * humidity) + (0.00941695 * (t * t)) + (0.00728898 * (humidity * humidity)) 
				+ (0.000345372 * (t * t * humidity)) - (0.000814971 * (t * humidity * humidity)) + 
				(0.0000102102 * (t * t * humidity * humidity)) - (0.000038646 * (t * t * t)) + 
				(0.0000291583 * (humidity * humidity * humidity)) + (0.00000142721 * (t * t * t * humidity)) + 
				(0.000000197483 * (t * humidity * humidity * humidity)) - (0.0000000218429 * (t * t * t * humidity * humidity)) 
				+ 0.000000000843296 * (t * t * humidity * humidity * humidity)) - 
				(0.0000000000481975 * (t * t * t * humidity * humidity * humidity))); 
		
				index = (index -32)*5/9; 
				
				return index;
}

		@Override
		public void update(float temp, float humidity, float pressure) {
			this.temperature = temp;
			this.humidity = humidity;
			display();
		}
		
		@Override
		public void display() {
			System.out.println("Heat index: "+ compIndex(temperature, humidity));
			
		}

}