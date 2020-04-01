package be.intecbrussel.eatables;

import java.util.Arrays;

public class Cone implements Eatable{

	Flavor[] balls; 
	
	public Cone(){}
	
	public Cone(Flavor[] flavors) {
		this.balls = flavors; 
	}
	
	@Override
	public void eat() {
		System.out.println("I'm eating a cone"+ Arrays.toString(balls));		
	}

	public enum Flavor {
		STRAWBERRY(1), BANANA(1.2), CHOCOLATE(1), VANILLA(1), LEMON(1.2), STRACIATELLA(1.2), MOKKA(1.2), PISTACHE(1.2);
		
		private double price; 
		private Flavor(double indiceFlavorPrice) {
			this.price = indiceFlavorPrice; 
		}
		
		public double getPriceFlavor() {
			return price; 
		}
		
		@Override
		public String toString() {
			return name(); 
		}
	}

	@Override
	public String toString() {
		return "Cone [balls=" + Arrays.toString(balls) + "]";
	}
}
