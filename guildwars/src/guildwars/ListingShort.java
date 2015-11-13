package guildwars;

public class ListingShort {

	public static void main(String[] args) throws Exception {
		TradingPost tradingPost = new TradingPost();
		ItemCharacteristics itemCharacteristics = tradingPost.getCharacteristics();
		
		System.out.println("Buy: " + "\n");
		//for (int a = 0; a < buyCharacteristics.size(); a++){
			System.out.println("min: " + itemCharacteristics.getBuyCharacteristics().getMinimum());
			System.out.println("max: " + itemCharacteristics.getBuyCharacteristics().getMaximum());
			System.out.println("avg: " + itemCharacteristics.getBuyCharacteristics().getAverage());
		//}
		
		System.out.println("\n" + "Sell: " + "\n");
		//for (int a = 0; a < sellCharacteristics.size(); a++){
			System.out.println("min: " + itemCharacteristics.getSellCharacteristics().getMinimum());
			System.out.println("max: " + itemCharacteristics.getSellCharacteristics().getMaximum());
			System.out.println("avg: " + itemCharacteristics.getSellCharacteristics().getAverage());
		//}
	}
}