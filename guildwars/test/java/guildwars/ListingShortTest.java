package guildwars;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ListingShortTest {

	@Test
	public void minimumWithEmptyList() {
		List<Listing> listings = new ArrayList<>();
		
		int min = ListingShort.minimum(listings);
		Assert.assertEquals(0, min);
	}

	@Test
	public void minimum() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(1, 1));
		listings.add(new Listing(1, 10));
		
		int min = ListingShort.minimum(listings);
		Assert.assertEquals(1, min);
	}
	
	@Test
	public void maximumWithEmptyList() {
		List<Listing> listings = new ArrayList<>();
		
		int max = ListingShort.maximum(listings);
		Assert.assertEquals(0, max);
	}
	
	@Test
	public void maximum() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(1, 1));
		listings.add(new Listing(1, 10));
		
		int max = ListingShort.maximum(listings);
		Assert.assertEquals(10, max);
	}
	
	@Test
	public void averageWithEmptyList() {
		List<Listing> listings = new ArrayList<>();
		
		double avg = ListingShort.average(listings);
		Assert.assertTrue(avg + " != " + 0.0, 0.0 == avg);
	}
	
	@Test
	public void average() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(1, 1));
		listings.add(new Listing(1, 10));
		
		double avg = ListingShort.average(listings);
		Assert.assertTrue(avg + " != " + 5.0, 5.0 == avg);
	}
	
	@Test
	public void medianWithEmptyList() {
		List<Listing> listings = new ArrayList<>();
		
		int med = ListingShort.median(listings);
		Assert.assertEquals(0, med);
	}
	
	@Test
	public void medianOddLength() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(1, 1));
		listings.add(new Listing(1, 10));
		listings.add(new Listing(1, 15));
		
		int med = ListingShort.median(listings);
		Assert.assertEquals(10, med);
	}
	
	@Test
	public void medianEvenLength() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(1, 1));
		listings.add(new Listing(1, 10));
		
		int med = ListingShort.median(listings);
		Assert.assertEquals(5, med);
	}
	
	@Test
	public void median() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(1, 1));
		listings.add(new Listing(1, 10));
		
		int med = ListingShort.median(listings);
		Assert.assertEquals(5, med);
	}
	
}
