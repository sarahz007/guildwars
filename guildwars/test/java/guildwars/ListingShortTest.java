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
	public void minimumWithQuantity() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(1, 1));
		listings.add(new Listing(10, 10));
		
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
	public void averageSimple() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(1, 1));
		listings.add(new Listing(1, 10));
		
		double avg = ListingShort.average(listings);
		Assert.assertTrue(avg + " != " + 5.0, 5.0 == avg);
	}
	
	@Test
	public void average() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(1, 2));
		listings.add(new Listing(1, 2));
		listings.add(new Listing(1, 3));
		
		double avg = ListingShort.average(listings);
		Assert.assertTrue(avg + " != " + (7/3), (7/3) == avg);
	}
	
	@Test
	public void averageWithQuantity() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(10, 1));
		listings.add(new Listing(1, 2));
		listings.add(new Listing(1, 3));
		
		double avg = ListingShort.average(listings);
		Assert.assertTrue(avg + " != " + (15/12), (15/12) == avg);
	}
	
	@Test
	public void medianWithEmptyList() {
		List<Listing> listings = new ArrayList<>();
		
		double med = ListingShort.median(listings);
		Assert.assertTrue(med + " != " + 0, 0 == med);
	}
	
	@Test
	public void medianOddLength() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(1, 1));
		listings.add(new Listing(1, 10));
		listings.add(new Listing(1, 15));
		
		double med = ListingShort.median(listings);
		Assert.assertTrue(med + " != " + 15.0, 15.0 == med);
	}
	
	@Test
	public void medianEvenLength() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(1, 1));
		listings.add(new Listing(1, 10));
		
		double med = ListingShort.median(listings);
		Assert.assertTrue(med + " != " + 5.0, 5.0 == med);
	}
	
	@Test
	public void medianWithQuantity() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(10, 1));
		listings.add(new Listing(1, 10));
		
		double med = ListingShort.median(listings);
		Assert.assertTrue(med + " != " + 1, 1 == med);
	}
	
	@Test
	public void medianWithEvenQuantity() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(2, 1));
		listings.add(new Listing(2, 10));
		
		double med = ListingShort.median(listings);
		Assert.assertTrue(med + " != " + 5.0, 5.0 == med);
	}
	
}
