package guildwars;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class ListingShort {
	public static void main(String[] args) throws Exception {
		String values; 
		String webPage = "https://api.guildwars2.com/v2/commerce/listings/19684";	//gets web address
		URL url = new URL(webPage);						
		URLConnection urlConnection = url.openConnection();							//opens connection on server in the background
		InputStream is = urlConnection.getInputStream();							//streams content
		try {
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			int numCharsRead;
			char[] content = new char[1024];
			StringBuffer sb = new StringBuffer();
			while ((numCharsRead = isr.read(content)) > 0) {						//StringBuffer continuously increases by data from web page
				sb.append(content, 0, numCharsRead);
			}
			values = sb.toString();													//creates String with content of page
							
			//System.out.println(values);							//output on console -> String with content
				
		} 
		finally {
			is.close();						  										//closes connection
		}
		
		String[] all = values.split("sells");
		String buy = all[0];
		String sell = all[1];
		buy = buy.substring(buy.indexOf("["),buy.lastIndexOf( "]"));			//ignores text at the beginning and only displays content between []
		sell = sell.substring(sell.indexOf("["),sell.lastIndexOf( "]"));
		//System.out.println(buy);
		//System.out.println(sell);												//gets content of String between [] and has an output on console
		
		buy = buy.replaceAll("[^0-9,]+", "");									//extracts only numbers and commas from previous string
		//System.out.println(buy);
		//System.out.println(sell);
		String[] buyItems = buy.split(",");										//splits new string at commas and fills an array w/ numbers in string
		int[] buyResults = new int[buyItems.length];
		//fills int array with numbers from string array using Integer.parseInt
		for (int i = 0; i < buyItems.length; i++) {
		    try {
		        buyResults[i] = Integer.parseInt(buyItems[i]);
		    }
		    catch (NumberFormatException nfe) {};
		}
		//the next block of code extracts numbers from the buy part of the initial string and puts it in a list like so: "quantity x unit price
		List finalBuyListing = new ArrayList();
		for (int a = 2; a < buyResults.length; a = a+3){
			Listing buyListObject = new Listing(buyResults[a], buyResults[a-1]);
			finalBuyListing.add(buyListObject);
		}
		System.out.println("Buy: " + "\n");
		for (int c = 0; c < finalBuyListing.size(); c++){
			System.out.println(((Listing) finalBuyListing.get(c)).getQuantity() + "x " + ((Listing) finalBuyListing.get(c)).getUnitPrice());
		}
		
		/*the next block of code extracts numbers from the sell part of the initial string and puts it in a list like so: "quantity x unit price
		 * other than it applies for the sell part, it is the same as for the buy part*/
		sell = sell.replaceAll("[^0-9,]+", "");									
		//System.out.println(sell);
		String[] sellItems = sell.split(",");
		int[] sellResults = new int[sellItems.length];

		for (int i = 0; i < sellItems.length; i++) {
		    try {
		        sellResults[i] = Integer.parseInt(sellItems[i]);
		    }
		    catch (NumberFormatException nfe) {};
		}
		List finalSellListing = new ArrayList();
		for (int a = 2; a < buyResults.length; a = a+3){
			Listing sellListObject = new Listing(sellResults[a], sellResults[a-1]);
			finalSellListing.add(sellListObject);
		}
		System.out.println("");
		System.out.println("Sell: " + "\n");
		for (int c = 0; c < finalSellListing.size(); c++){
			System.out.println(((Listing) finalSellListing.get(c)).getQuantity() + "x " + ((Listing) finalSellListing.get(c)).getUnitPrice());
		}
	}
}