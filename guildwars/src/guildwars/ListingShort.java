package guildwars;

public class ListingShort {

	public static void main(String[] args) throws Exception {
		TradingPost tradingPost = new TradingPost("https://api.guildwars2.com/v2/commerce/listings/19684");
		ItemCharacteristics itemCharacteristics = tradingPost.getCharacteristics();
		
		System.out.println("Buy: " + "\n");
		System.out.println("min: " + itemCharacteristics.getBuyCharacteristics().getMinimum());
		System.out.println("max: " + itemCharacteristics.getBuyCharacteristics().getMaximum());
		System.out.println("avg: " + itemCharacteristics.getBuyCharacteristics().getAverage());
		
		System.out.println("\n" + "Sell: " + "\n");
		System.out.println("min: " + itemCharacteristics.getSellCharacteristics().getMinimum());
		System.out.println("max: " + itemCharacteristics.getSellCharacteristics().getMaximum());
		System.out.println("avg: " + itemCharacteristics.getSellCharacteristics().getAverage());
	}
}