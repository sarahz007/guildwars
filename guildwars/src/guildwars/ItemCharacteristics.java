package guildwars;

public class ItemCharacteristics {
	
	private Characteristics buyCharacteristics;
	private Characteristics sellCharacteristics;
	
	public Characteristics getBuyCharacteristics() {
		return buyCharacteristics;
	}
	public void setBuyCharacteristics(Characteristics buyChar) {
		buyCharacteristics = buyChar;
	}
	public Characteristics getSellCharacteristics() {
		return sellCharacteristics;
	}
	public void setSellCharacteristics(Characteristics sellChar) {
		sellCharacteristics = sellChar;
	}
	public ItemCharacteristics(Characteristics buyChar, Characteristics sellChar){
		buyCharacteristics = buyChar;
		sellCharacteristics = sellChar;
	}
	public ItemCharacteristics(){
		
	}

}
