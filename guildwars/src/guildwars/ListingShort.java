package guildwars;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class ListingShort {
	private static String loadUrl(String url) throws Exception {
		URL urlObj = new URL(url);
		URLConnection urlConnection = urlObj.openConnection();							//opens connection on server in the background
		InputStream is = urlConnection.getInputStream();							
		try {
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			int numCharsRead;
			char[] content = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(content)) > 0) {						//StringBuffer continuously increases by data from web page
				sb.append(content, 0, numCharsRead);
			}
			return sb.toString();
		} 
		finally {
			is.close();						  										//closes connection
		}
	}
	
	public static int[] createList (String list){
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
	
	public static String outputList(int[] results){
		List<Listing> finalListing = new ArrayList<>();
		for (int a = 2; a < results.length; a = a+3){
			Listing listObject = new Listing(results[a], results[a-1]);
			finalListing.add(listObject);
		}
		for (int c = 0; c < finalListing.size(); c++){
			String object = finalListing.get(c).getQuantity() + "x " + (finalListing.get(c).getUnitPrice());
			System.out.println(object);;
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		String values = loadUrl("https://api.guildwars2.com/v2/commerce/listings/19684");
		String[] all = values.split("sells");
		String buy = all[0];
		String sell = all[1];
		
		System.out.println("Buy: " + "\n");
		outputList(createList(buy));
		System.out.println("\n" + "Sell: " + "\n");
		outputList(createList(sell));
		
	}
}