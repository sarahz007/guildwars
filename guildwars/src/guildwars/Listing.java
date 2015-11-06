package guildwars;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.io.*;


public class Listing {

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
							
			System.out.println("All: " + "\n" + values);							//output on console -> String with content
				
		} 
		finally {
			is.close();						  										//closes connection
		}
		
		String[] all = values.split("sells");
		String buy = all[0];
		String sell = all[1];
		buy = "Buy:" + "\n" + buy.substring(buy.indexOf("["),buy.lastIndexOf( "]"));			//ignores text at the beginning and only displays content between []
		sell = "Sell:" + "\n" + sell.substring(sell.indexOf("["),sell.lastIndexOf( "]"));
		System.out.println(buy);
		System.out.println(sell);
		
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
			buyQuantity = buyQuantity + "\n" + getBuy[x];
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
		
	}
}


/*String[] buys = buy.split(",");
String buyListing = buys[0];
String buyUP = buys[1];
String buyQuantity = buys[2];
String[] sells = sell.split(",");
String sellListing = sells[0];
String sellUP = sells[1];
String sellQuantity = sells[2];
double latitudes=Double.parseDouble(ar[0]);
double longitudes=Double.parseDouble(ar[1]);*/
