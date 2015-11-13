package guildwars;

public class ListingShort {

	public static void main(String[] args) throws Exception {
		TradingPost tradingPost = new TradingPost(args [0]);
		ItemCharacteristics itemCharacteristics = tradingPost.getCharacteristics();
		
		System.out.println("Buy: " + "\n");
		System.out.println("min: " + itemCharacteristics.getBuyCharacteristics().getMinimum());
		System.out.println("max: " + itemCharacteristics.getBuyCharacteristics().getMaximum());
		System.out.println("avg: " + itemCharacteristics.getBuyCharacteristics().getAverage());
		System.out.println("median: " + itemCharacteristics.getBuyCharacteristics().getMedian());
		
		
		System.out.println("\n" + "Sell: " + "\n");
		System.out.println("min: " + itemCharacteristics.getSellCharacteristics().getMinimum());
		System.out.println("max: " + itemCharacteristics.getSellCharacteristics().getMaximum());
		System.out.println("avg: " + itemCharacteristics.getSellCharacteristics().getAverage());
		System.out.println("median: " + itemCharacteristics.getSellCharacteristics().getMedian());
	}
}