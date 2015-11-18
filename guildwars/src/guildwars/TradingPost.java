package guildwars;

import java.util.*;

public class TradingPost {
	private String url;

	public TradingPost(String url) {
		this.url = url;
	}
	public TradingPost () {
		
	}

	// returns array of all the numbers in the given String from the URL
	private int[] createList(String list) {
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
	private List<Listing> outputList(int[] results) {
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
	 * calculates minimum Unit Price of the List finalListing, maximum Unit
	 * Price of the List finalListing, average Unit Price and median
	 * 
	 * @param finalListing
	 * @return characteristics
	 */
	public static Characteristics getCharacteristics(List<Listing> finalListing) {
		int min = Integer.MAX_VALUE;
		int max = 0;
		int allUP = 0;
		int allQ = 0;
		double avg;
		double median;
		List<Integer> uP = new ArrayList<>();
		if (finalListing.isEmpty()) {
			min = 0;
			max = 0;
			avg = 0.0;
			median = 0.0;
		} else {
			for (Listing listing : finalListing) {
				min = Math.min(min, listing.getUnitPrice());
				max = Math.max(max, listing.getUnitPrice());
				allQ += listing.getQuantity();
				allUP += listing.getUnitPrice() * listing.getQuantity();
				for(int x = 0; x < listing.getQuantity(); x++) {
	  				uP.add(listing.getUnitPrice());
				}
			}
			avg = (double) allUP / (double) allQ;
			Collections.sort(uP); 
	  		if (uP.size() % 2 == 0) {
				median = (uP.get(uP.size()/2 - 1) + uP.get(uP.size()/2))/2; 
			}else {
			median = uP.get((uP.size()+1)/2); 
			}
		}
		Characteristics characteristics = new Characteristics(min, max, avg, median);
		return characteristics;
	}

	public ItemCharacteristics getCharacteristics() throws Exception {

		String values = UrlContent.loadUrl(url);
		String[] all = values.split("sells");
		String buy = all[0];
		String sell = all[1];
		ItemCharacteristics itemCharacteristics = new ItemCharacteristics(getCharacteristics(outputList(createList(buy))), getCharacteristics(outputList(createList(sell))));
		
		List<Listing> buyOutputList = outputList(createList(buy));
		//median(buyOutputList); 
		List<Characteristics> buyCharacteristics = new ArrayList<>();
		buyCharacteristics.add(getCharacteristics(buyOutputList));
		
		List<Listing> sellOutputList = outputList(createList(sell));
		//median(sellOutputList);
		List<Characteristics> sellCharacteristics = new ArrayList<>();
		sellCharacteristics.add(getCharacteristics(sellOutputList));
		
		return itemCharacteristics;
	}
}
