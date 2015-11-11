package guildwars;

public class Kennwerte {
	
	private int minimum;
	private int maximum;
	private int average;
		
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
	public int getAverage(){
		return average;
	}
	public void setAverage(int avg){
		average = avg;
	}
	public Kennwerte(int min, int max, int avg) {
		minimum = min;
		maximum = max;
		average = avg;
	}
}
