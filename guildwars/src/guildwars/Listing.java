package guildwars;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.io.*;


public class Listing {

	private int quantity;
	private int unitPrice;
		
	public int getUnitPrice(){
		return unitPrice;
	}
	public void setUnitPrice(int up){
		unitPrice = up; 
	}
	public int getQuantity(){
		return quantity;
	}
	public void setQuantity(int q){
		quantity = q; 
	}
	
	public Listing(int q, String t, int up, String br) {
		quantity = q;
		t = "x ";
		unitPrice = up;
		br = "\n";
	}
	
	public void main (){
		List finalListing = new ArrayList();
		Listing listobject = new Listing(quantity, "x ", unitPrice, "\n");
		finalListing.add(listobject);
		System.out.println(finalListing);
		
	}
}