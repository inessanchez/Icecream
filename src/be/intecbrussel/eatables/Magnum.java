package be.intecbrussel.eatables;

public class Magnum implements Eatable{
	private MagnumType magnumType; 
	
	public Magnum() {
		this(null); 
	}
	
	public Magnum(MagnumType magnumTypeChoice) {
		this.magnumType = magnumTypeChoice; 
	}

	@Override
	public void eat() {
		System.out.println("I'm eating a "+ this.magnumType+" magnum");				
	}
	
	public MagnumType getType() {
		return this.magnumType; 
	}
	
	public enum MagnumType {
		
		MILKCHOCOLATE(1), WHITECHOCOLATE(1.2), BLACKCHOCOLATE(1.2), ALPINENUTS(2), ROMANTICSTRAWBERRIES(2); 
		
		private double price; 
		
		private MagnumType(double indicePriceType) {
			this.price = indicePriceType; 
		}
		
		public double getPriceMagnumType() {
			return price; 
		}
	}
	
}
