package guildwars;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class TradingPost {
	private String url;

	public TradingPost(String url) {
		this.url = url;
	}

	// opens Connection on server in the background, reads data from web page
	// into a StringBuffer and closes connection
	public String loadUrl(String url) throws Exception {
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
		} finally {
			is.close();
		}
	}

	// returns array of all the numbers in the given String from the URL
	public int[] createList(String list) {
		list = list.substring(list.indexOf("["), list.lastIndexOf("]"));
		list = list.replaceAll("[^0-9,]+", ""); // extracts only numbers and
												// commas from previous string
		String[] items = list.split(","); // splits new string at commas and
											// fills an array w/ numbers in
											// string
		int[] results = new int[items.length];
		for (int i = 0; i < items.length; i++) {
			try {
				results[i] = Integer.parseInt(items[i]);
			} catch (NumberFormatException nfe) {
			}
			;
		}
		return results;
	}

	// returns list with objects containing quantity and Unit Price, the value
	// for "listing" is being ignored
	public List<Listing> outputList(int[] results) {
		List<Listing> finalListing = new ArrayList<>();
		for (int a = 2; a < results.length; a = a + 3) {
			Listing listObject = new Listing(results[a], results[a - 1]);
			finalListing.add(listObject);
		}
		/*
		 * for (int c = 0; c < finalListing.size(); c++){ String object =
		 * finalListing.get(c).getQuantity() + "x " +
		 * finalListing.get(c).getUnitPrice(); System.out.println(object);; }
		 */
		return finalListing;
	}

	/**
	 * puts all Unit Prices in a sorted array scenario 1: length of the array is
	 * an odd number: returns value in the middle of the array scenario 2:
	 * length of the array is an even number: returns average of the two values
	 * in the middle
	 * 
	 * @param finalListing
	 * @return
	 */
	/*
	 * private static double median (List<Listing> finalListing){ List<Integer>
	 * uP = new ArrayList<>(); double median; if (finalListing.isEmpty()){
	 * median = 0; } else { for (int i = 0; i < finalListing.size(); i++){
	 * for(int x = 0; x < finalListing.get(i).getQuantity(); x++) {
	 * uP.add(finalListing.get(i).getUnitPrice()); } } Collections.sort(uP); if
	 * (uP.size() % 2 == 0) { median = (uP.get(uP.size()/2) + uP.get(uP.size()/2
	 * + 1))/2; } else { median = uP.get((uP.size()+1)/2); } }
	 * System.out.println("median: " + median); return median;
	 */

	/**
	 * calculates minimum Unit Price of the List finalListing, maximum Unit
	 * Price of the List finalListing and average Unit Price
	 * 
	 * @param finalListing
	 * @return characteristics
	 */
	public Characteristics getCharacteristics(List<Listing> finalListing) {
		int min = Integer.MAX_VALUE;
		int max = 0;
		int allUP = 0;
		int allQ = 0;
		double avg;
		if (finalListing.isEmpty()) {
			min = 0;
			max = 0;
			avg = 0.0;
		} else {
			for (Listing listing : finalListing) {
				min = Math.min(min, listing.getUnitPrice());
				max = Math.max(max, listing.getUnitPrice());
				allQ += listing.getQuantity();
				allUP += listing.getUnitPrice() * listing.getQuantity();
			}
			avg = (double) allUP / (double) allQ;
		}

		Characteristics characteristics = new Characteristics(min, max, avg);
		return characteristics;
	}

	public ItemCharacteristics getCharacteristics() throws Exception {

		String values = loadUrl(url);
		String[] all = values.split("sells");
		String buy = all[0];
		String sell = all[1];
		ItemCharacteristics itemCharacteristics = new ItemCharacteristics(
				getCharacteristics(outputList(createList(buy))), getCharacteristics(outputList(createList(sell))));
		// itemCharacteristics.setBuyCharacteristics(getCharacteristics(outputList(createList(buy))));
		// itemCharacteristics.setSellCharacteristics(getCharacteristics(outputList(createList(sell))));

		return itemCharacteristics;

		/*
		 * Buy List<Listing> buyOutputList = outputList(createList(buy));
		 * median(buyOutputList); List<Characteristics> buyCharacteristics = new
		 * ArrayList<>();
		 * buyCharacteristics.add(getCharacteristics(buyOutputList));
		 * 
		 * Sell List<Listing> sellOutputList = outputList(createList(sell));
		 * median(sellOutputList);
		 * sellCharacteristics.add(getCharacteristics(sellOutputList));
		 */
	}
}
