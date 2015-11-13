package guildwars;

public class Characteristics {
	
	private int minimum;
	private int maximum;
	private double average;
		
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
	public Characteristics(int min, int max, double avg) {
		minimum = min;
		maximum = max;
		average = avg;
	}
}
