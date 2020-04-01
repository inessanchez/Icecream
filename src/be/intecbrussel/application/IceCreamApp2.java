package be.intecbrussel.application;

import be.intecbrussel.eatables.Cone;
import be.intecbrussel.eatables.Eatable;
import be.intecbrussel.eatables.Magnum.MagnumType;
import be.intecbrussel.sellers.IceCreamCar;
import be.intecbrussel.sellers.IceCreamSeller;
import be.intecbrussel.sellers.PriceList;

public class IceCreamApp2 {

	public static void main(String[] args) throws NoMoreIceCreamException {

		PriceList pricelist = new PriceList(1.5, 1.5, 1.5); 
		
		Cone.Flavor[] flavors1 = new Cone.Flavor[]{Cone.Flavor.CHOCOLATE, Cone.Flavor.MOKKA};
		Cone cone1 = new Cone(flavors1);
		
		cone1.eat();
		System.out.println(cone1.toString()); 
		
		Stock stock = new Stock(5,5,5,5); 
		
		IceCreamSeller salon1 = new IceCreamCar(stock, pricelist); 
		

		Eatable eatable1 = salon1.orderCone(flavors1); 
		Eatable eatable2 = salon1.orderIceRocket(); 
		Eatable eatable3 = salon1.orderMagnum(MagnumType.ALPINENUTS);
		
		Eatable[] icecreams = new Eatable[] { eatable1, eatable2, eatable3 };  
		
		for (Eatable icecream : icecreams) {
			icecream.eat(); 
		}
		
		salon1.orderCone(flavors1); 
		salon1.orderCone(flavors1); 
		salon1.orderIceRocket(); 
		salon1.orderIceRocket(); 
		salon1.orderIceRocket(); 
		salon1.orderIceRocket(); 
		salon1.orderIceRocket(); 

		salon1.orderMagnum(MagnumType.ALPINENUTS);
		salon1.orderMagnum(MagnumType.ALPINENUTS);
		salon1.orderMagnum(MagnumType.ALPINENUTS);
		salon1.orderMagnum(MagnumType.ALPINENUTS);
		salon1.orderMagnum(MagnumType.ALPINENUTS);
		
		
		System.out.println("Stock balls: "+stock.getBalls()); 
		System.out.println("Stock cones: "+stock.getCones()); 
		System.out.println("Stock icerockets: "+stock.getIceRockets()); 
		System.out.println("Stock magni: "+stock.getMagni()); 
		
		System.out.println("This is the profit: " +salon1.getProfit()); 

	}

}
