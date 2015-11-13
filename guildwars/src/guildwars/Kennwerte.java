package guildwars;

public class Kennwerte {
	
	private static int minimum;
	private static int maximum;
	private static double average;
		
	public int getMinimum(){
		return minimum;
	}
	public static void setMinimum(int min){
		minimum = min; 
	}
	public int getMaximum(){
		return maximum;
	}
	public static void setMaximum(int max){
		maximum = max; 
	}
	public double getAverage(){
		return average;
	}
	public static void setAverage(double avg){
		average = avg;
	}
	public Kennwerte(int min, int max, double avg) {
		minimum = min;
		maximum = max;
		average = avg;
	}
}
