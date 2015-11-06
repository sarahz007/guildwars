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
							
			System.out.println(values);							//output on console -> String with content
				
		} 
		finally {
			is.close();						  										//closes connection
		}
		
		String[] all = values.split("sells");
		String buy = all[0];
		String sell = all[1];
		buy = buy.substring(buy.indexOf("["),buy.lastIndexOf( "]"));			//ignores text at the beginning and only displays content between []
		sell = sell.substring(sell.indexOf("["),sell.lastIndexOf( "]"));
		System.out.println(buy);
		System.out.println(sell);												//gets content of String between [] and has an output on console
		
		buy = buy.replaceAll("[^0-9,]+", "");									//extracts only numbers and commas from previous string
		System.out.println(buy);
		System.out.println(sell);
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
		//creates 3 int arrays and fills it with integers from previous int array "buyResults" and therefore only requires 1/3 in length than previous array
		int[] buyListings = new int [buyResults.length/3];
		int[] buyUnitPrice = new int [buyResults.length/3];
		int[] buyQuantity = new int [buyResults.length/3];
		int bl = 0;
		int bu = 0;
		int bq = 0;
		for (int y = 0; y < buyResults.length; y++) {
			buyListings[bl] = buyResults[y];
		    bl++;
			y++;
		    buyUnitPrice[bu] = buyResults[y];
		    y++;
		    bu++;
		    buyQuantity[bq] = buyResults[y];
		    bq++;
		    }
		
		List buyList = new ArrayList();											//creates new list which is finally displayed
		buyList.add("Buy:" + "\n");												//title for display
		//fills list with "quantity x unit price
		for (int z = 0; z < buyQuantity.length; z++){
			buyList.add(buyQuantity[z] + "x " + buyUnitPrice[z] + "\n");
		}
		System.out.println(buyList);
		
		/*the next block of code extracts numbers from the sell part of the initial string and puts it in a list like so: "quantity x unit price
		 * other than it applies for the sell part, it is the same as for the buy part*/
		sell = sell.replaceAll("[^0-9,]+", "");									
		System.out.println(sell);
		String[] sellItems = sell.split(",");
		int[] sellResults = new int[sellItems.length];

		for (int i = 0; i < sellItems.length; i++) {
		    try {
		        sellResults[i] = Integer.parseInt(sellItems[i]);
		    }
		    catch (NumberFormatException nfe) {};
		}
		
		int[] sellListings = new int [sellResults.length/3];
		int[] sellUnitPrice = new int [sellResults.length/3];
		int[] sellQuantity = new int [sellResults.length/3];
		int sl = 0;
		int su = 0;
		int sq = 0;
		for (int y = 0; y < sellResults.length; y++) {
			sellListings[sl] = sellResults[y];
		    sl++;
			y++;
		    sellUnitPrice[su] = sellResults[y];
		    y++;
		    su++;
		    sellQuantity[sq] = sellResults[y];
		    sq++;
		    }
		List sellList = new ArrayList();
		sellList.add("Sell:" + "\n");
		for (int z = 0; z < sellQuantity.length; z++){
			sellList.add(sellQuantity[z] + "x " + sellUnitPrice[z] + "\n");
		}
		System.out.println(sellList);
	
	}
}