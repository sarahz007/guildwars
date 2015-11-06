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
		buy = buy.substring(buy.indexOf("["),buy.lastIndexOf( "]"));			//ignores text at the beginning and only displays content between []
		sell = sell.substring(sell.indexOf("["),sell.lastIndexOf( "]"));
		
		buy = buy.replaceAll("[^0-9,]+", "");									//extracts only numbers and commas from previous string
		String[] buyItems = buy.split(",");										//splits new string at commas and fills an array w/ numbers in string
		int[] buyResults = new int[buyItems.length];
		for (int i = 0; i < buyItems.length; i++) {
		    try {
		        buyResults[i] = Integer.parseInt(buyItems[i]);
		    }
		    catch (NumberFormatException nfe) {};
		}
		System.out.println("Buy: " + "\n");
		outputList(buyResults);
		
		sell = sell.replaceAll("[^0-9,]+", "");									
		String[] sellItems = sell.split(",");
		int[] sellResults = new int[sellItems.length];

		for (int i = 0; i < sellItems.length; i++) {
		    try {
		        sellResults[i] = Integer.parseInt(sellItems[i]);
		    }
		    catch (NumberFormatException nfe) {};
		}
		System.out.println("\n" + "Sell: " + "\n");
		outputList(sellResults);
		
	}
}