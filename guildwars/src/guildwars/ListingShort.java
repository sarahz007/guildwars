package guildwars;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class ListingShort {
	public static void main(String[] args) throws Exception {
		/*URLContent values =	new URLContent(values);
		String list = values; 
		*/
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
		System.out.println(sell);
		
		buy = buy.replaceAll("[^0-9,]+", "");
		sell = sell.replaceAll("[^0-9,]+", "");
		System.out.println(buy);
		System.out.println(sell);
		String[] buyItems = buy.split(",");
		int[] buyResults = new int[buyItems.length];

		for (int i = 0; i < buyItems.length; i++) {
		    try {
		        buyResults[i] = Integer.parseInt(buyItems[i]);
		    }
		    catch (NumberFormatException nfe) {};
		}
		List buyList = new ArrayList();
		
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
		for (int z = 0; z < buyQuantity.length; z++){
			buyList.add(buyQuantity[z] + "x " + buyUnitPrice[z]);
		}
		
		
		
		/*
		List sellList = new ArrayList();
		List sellListings = new ArrayList();
		List sellUnitPrice = new ArrayList();
		List sellQuantity = new ArrayList();
		
	    String[] buySplit = buy.split("\\},\\{");
	    String[] sellSplit = sell.split("\\},\\{");
	    
	    String buyCorrect = "";   
	    for (int i =0; i < buySplit.length; i++){
			buyCorrect = buyCorrect + "\n" + buySplit[i];
		}
	    																					 	//splits strings buy and sell and appends content between {} to a new string 
	    String sellCorrect = "";
	    for (int i =0; i < sellSplit.length; i++){
			sellCorrect = sellCorrect + "\n" + sellSplit[i];
		}
		
		buyCorrect = buyCorrect.replace("[{", "");
		sellCorrect = sellCorrect.replace("[{", "");
		System.out.println(buyCorrect);
		System.out.println(sellCorrect);
		
		String buyUnitPrice = "";
		String buyQuantity = "";
		String[] getBuy = buyCorrect.split(",");
		for (int x =0; x < getBuy.length; x++) {
			x++;
			buyUnitPrice = buyUnitPrice + " " + getBuy[x];
			x++;
			buyQuantity = buyQuantity + " " + getBuy[x];
		}
		
		String sellUnitPrice = "";
		String sellQuantity = "";
		String[] getSell = sellCorrect.split(",");
		for (int x =0; x < getSell.length; x++) {
			x++;
			sellUnitPrice = sellUnitPrice + " " + getSell[x];
			x++;
			sellQuantity = sellQuantity + "\n" + getSell[x];
		}
		
		System.out.println(buyUnitPrice);
		System.out.println(buyQuantity);
		System.out.println(sellUnitPrice);
		System.out.println(sellQuantity);
		*/
	}
}