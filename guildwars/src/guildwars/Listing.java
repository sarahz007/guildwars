package guildwars;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.io.*;


public class Listing {

	private static int quantity;
	private static int unitPrice;
		
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
	
	public static void main(String[] args){
		List finalListing = new ArrayList();
		Listing listobject = new Listing(quantity, "x ", unitPrice, "\n");
		finalListing.add(listobject);
		System.out.println(finalListing);
		System.out.println("finalListing test");
		
	}
}