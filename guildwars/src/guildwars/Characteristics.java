package guildwars;

public class Characteristics {
	
	private int minimum;
	private int maximum;
	private double average;
	private double median;
		
	public int getMinimum(){
		return minimum;
	}
	public void setMinimum(int min){
		minimum = min; 
	}
	public int getMaximum(){
		return maximum;
	}
	public void setMaximum(int max){
		maximum = max; 
	}
	public double getAverage(){
		return average;
	}
	public void setAverage(double avg){
		average = avg;
	}
	public double getMedian() {
		return median;
	}
	public void setMedian(double med) {
		median = med;
	}
	public Characteristics(int min, int max, double avg, double med) {
		minimum = min;
		maximum = max;
		average = avg;
		median = med;
	}
	
}
