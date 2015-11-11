package guildwars;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class ListingShort {
	
	// opens Connection on server in the background, reads data from web page into a StringBuffer and closes connection
	private static String loadUrl(String url) throws Exception {
		URL urlObj = new URL(url);
		URLConnection urlConnection = urlObj.openConnection();							
		InputStream is = urlConnection.getInputStream();							
		try {
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			int numCharsRead;
			char[] content = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(content)) > 0) {						
				sb.append(content, 0, numCharsRead);
			}
			return sb.toString();
		} 
		finally {
			is.close();						  										
		}
	}
	
	//returns array of all the numbers in the given String from the URL 
	private static int[] createList (String list){
		list = list.substring(list.indexOf("["),list.lastIndexOf( "]"));
		list = list.replaceAll("[^0-9,]+", "");									//extracts only numbers and commas from previous string
		String[] items = list.split(",");										//splits new string at commas and fills an array w/ numbers in string
		int[] results = new int[items.length];
		for (int i = 0; i < items.length; i++) {
		    try {
		        results[i] = Integer.parseInt(items[i]);
		    }
		    catch (NumberFormatException nfe) {};
		}
		return results;
	}
	
	// returns list with objects containing quantity and Unit Price, the value for "listing" is being ignored 
	private static List<Listing> outputList(int[] results){
		List<Listing> finalListing = new ArrayList<>();
		for (int a = 2; a < results.length; a = a+3){
			Listing listObject = new Listing(results[a], results[a-1]);
			finalListing.add(listObject);
		}
		/*
		for (int c = 0; c < finalListing.size(); c++){
			String object = finalListing.get(c).getQuantity() + "x " + finalListing.get(c).getUnitPrice();
			System.out.println(object);;
		}
		*/
		return finalListing;
	}
	
	//return minimum Unit Price of the List finalListing
	public static int minimum(List<Listing> finalListing){
		int min = Integer.MAX_VALUE;
		if (finalListing.isEmpty()){
			min = 0;
		} else {
			for (int i = 0; i < finalListing.size(); i++){
				min = Math.min(min, finalListing.get(i).getUnitPrice());
			}
		}
		System.out.println("min: " + min);
		return min;	
	}
	
	//returns maximum Unit Price of the List finalListing
	public static int maximum(List<Listing> finalListing){
		int max = 0;
		if (finalListing.isEmpty()){
			max = 0;
		} else{
			for (int i = 0; i < finalListing.size(); i++){
				max = Math.max(max, finalListing.get(i).getUnitPrice());
				}
			}
		System.out.println("max: " + max);
		return max;
	}
	
	/**
	 * puts all Unit Prices in a sorted array
	 * scenario 1: length of the array is an odd number: returns value in the middle of the array
	 * scenario 2: length of the array is an even number: returns average of the two values in the middle 
	 * @param finalListing
	 * @return
	 */
	public static double median (List<Listing> finalListing){
		List<Integer> uP = new ArrayList<>();
		double median;
		int allQ = 0;
		if (finalListing.isEmpty()){
			median = 0;
		} else {
			for (int i = 0; i < finalListing.size(); i++){
				allQ += finalListing.get(i).getQuantity();
				for(int x = 0; x < finalListing.get(i).getQuantity(); x++) {
					uP.add(finalListing.get(i).getUnitPrice());
				}
			}
			Collections.sort(uP);
			if (uP.size() % 2 == 0) {
				median = (uP.get(uP.size()/2) + uP.get(uP.size()/2 + 1))/2;
			} else {
				median = uP.get((uP.size()+1)/2);
			}
		}
		System.out.println("median: " + median);
		return median;
	}
	
	/**
	 * calculates total sum of all Unit Prices in finalListing and divides total by number of Unit Prices
	 * @param finalListing
	 * @return average
	 */
	public static double average (List<Listing> finalListing){
		int allUP = 0;
		int allQ = 0;
		double avg;
		if (finalListing.isEmpty()){
			avg = 0;
		} else{
			for (int i = 0; i < finalListing.size(); i++){
				allQ += finalListing.get(i).getQuantity();
				allUP += finalListing.get(i).getUnitPrice()*finalListing.get(i).getQuantity();
			}
			avg = (double) allUP/ (double) allQ;
		}
		System.out.println("average: " + avg);
		return avg;
	}
	
	public static void main(String[] args) throws Exception {
		String values = loadUrl("https://api.guildwars2.com/v2/commerce/listings/19684");
		String[] all = values.split("sells");
		String buy = all[0];
		String sell = all[1];
		
		System.out.println("Buy: " + "\n");
		List<Listing> buyOutputList = outputList(createList(buy));
		List<Listing> sellOutputList = outputList(createList(sell));
		outputList(createList(buy));
		minimum(buyOutputList);
		maximum(buyOutputList);
		median(buyOutputList);
		average(buyOutputList);
		System.out.println("\n" + "Sell: " + "\n");
		outputList(createList(sell));
		minimum(sellOutputList);
		maximum(sellOutputList);
		median(sellOutputList);
		average(sellOutputList);
	}
	
}