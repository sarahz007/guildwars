package guildwars;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ListingShortTest {

	@Test
	public void characteristicsWithEmptyList() {
		List<Listing> listings = new ArrayList<>();
		
	Characteristics charac = ListingShort.getCharacteristics(listings);
		Assert.assertEquals(0, charac.getMinimum());
		Assert.assertEquals(0, charac.getMaximum());
		Assert.assertTrue(charac.getAverage() + " != " + 0.0, 0.0 == charac.getAverage());
	}

	@Test
	public void characteristics() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(1, 1));
		listings.add(new Listing(1, 10));
		
		Characteristics charac = ListingShort.getCharacteristics(listings);
		Assert.assertEquals(1, charac.getMinimum());
		Assert.assertEquals(10, charac.getMaximum());
		Assert.assertTrue(charac.getAverage() + " != " + 5.5, 5.5 == charac.getAverage());
	}

	@Test
	public void characteristicsWithQuantity() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(10, 1));
		listings.add(new Listing(1, 2));
		listings.add(new Listing(1, 3));
		
		Characteristics charac = ListingShort.getCharacteristics(listings);
		Assert.assertEquals(1, charac.getMinimum());
		Assert.assertEquals(3, charac.getMaximum());
		Assert.assertTrue(charac.getAverage() + " != " + 15.0 / 12.0, 15.0 / 12.0 == charac.getAverage());
	}
	
	/*@Test
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
		listings.add(new Listing(3, 1));
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
		Assert.assertTrue(med + " != " + 10, 10 == med);
	}*/
	
}
