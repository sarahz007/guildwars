package guildwars;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class ListingShortTest {

	@Test
	public void characteristicsWithEmptyList() {
		List<Listing> listings = new ArrayList<>();
		
		Characteristics charac = TradingPost.getCharacteristics(listings);
		Assert.assertEquals(0, charac.getMinimum());
		Assert.assertEquals(0, charac.getMaximum());
		Assert.assertTrue(charac.getAverage() + " != " + 0.0, 0.0 == charac.getAverage());
		Assert.assertTrue(charac.getMedian() + " != " + 0.0, 0.0 == charac.getMedian());
	}

	@Test
	public void characteristics() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(1, 1));
		listings.add(new Listing(1, 10));
		
		Characteristics charac = TradingPost.getCharacteristics(listings);
		Assert.assertEquals(1, charac.getMinimum());
		Assert.assertEquals(10, charac.getMaximum());
		Assert.assertTrue(charac.getAverage() + " != " + 5.5, 5.5 == charac.getAverage());
		Assert.assertTrue(charac.getMedian() + " != " + 5.0, 5.5 == charac.getMedian());
	}

	@Test
	public void characteristicsWithQuantity() {
		List<Listing> listings = new ArrayList<>();
		listings.add(new Listing(10, 1));
		listings.add(new Listing(1, 2));
		listings.add(new Listing(1, 3));
		
		Characteristics charac = TradingPost.getCharacteristics(listings);
		Assert.assertEquals(1, charac.getMinimum());
		Assert.assertEquals(3, charac.getMaximum());
		Assert.assertTrue(charac.getAverage() + " != " + 15.0 / 12.0, 15.0 / 12.0 == charac.getAverage());
		Assert.assertTrue(charac.getMedian() + " != " + 1.0, 1.0 == charac.getMedian());
	}
	
}
