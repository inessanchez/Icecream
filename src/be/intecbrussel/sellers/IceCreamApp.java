package be.intecbrussel.sellers;

import be.intecbrussel.application.NoMoreIceCreamException;
import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum.MagnumType;

public class IceCreamApp {
	public static void main(String[] args) throws NoMoreIceCreamException {
		
		PriceList pricelist = new PriceList(1.5, 1.5, 1.5); 
				
		Cone.Flavor[] flavors1 = new Cone.Flavor[]{Cone.Flavor.CHOCOLATE, Cone.Flavor.MOKKA};
		
		Cone cone1 = new Cone(flavors1);
		
		cone1.eat();
		
		System.out.println(cone1.toString()); 
		
		IceCreamSeller salon1 = new IceCreamSalon(pricelist); 
		System.out.println("This is the profit: " +salon1.getProfit()); 
		Eatable eatable1 = salon1.orderCone(flavors1); 
		System.out.println(salon1.toString());
		System.out.println("This is the profit: " +salon1.getProfit()); 
		Eatable eatable2 = salon1.orderIceRocket(); 
		System.out.println(salon1.toString());
		System.out.println("This is the profit: " +salon1.getProfit()); 
		Eatable eatable3 = salon1.orderMagnum(MagnumType.ALPINENUTS); 
		System.out.println("This is the profit: " +salon1.getProfit()); 
		
		Eatable[] icecreams = new Eatable[] { eatable1, eatable2, eatable3 };  
		
		for (Eatable icecream : icecreams) {
			icecream.eat(); 
		}
		
		System.out.println("This is the profit: " +salon1.getProfit()); 

	}
}
