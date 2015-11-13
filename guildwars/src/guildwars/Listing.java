package guildwars;

public class Listing {

	private int quantity;
	private int unitPrice;
		
	public int getUnitPrice(){
		return unitPrice;
	}
	public void setUnitPrice(int up){
		unitPrice = up; 
	}
	public int getQuantity(){
		return quantity;
	}
	public void setQuantity(int q){
		quantity = q; 
	}
	
	public Listing(int q, int up) {
		quantity = q;
		unitPrice = up;
	}
	
}