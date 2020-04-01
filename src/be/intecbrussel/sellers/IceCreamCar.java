package be.intecbrussel.sellers;

import be.intecbrussel.application.NoMoreIceCreamException;
import be.intecbrussel.application.Stock;
import be.intecbrussel.eatables.*;

public class IceCreamCar implements IceCreamSeller{
	private PriceList pricelist; 
	private Stock stock; 
	private double profit;
	
	public IceCreamCar(Stock stock, PriceList pricelist) {
		this.pricelist = pricelist; 
		this.stock = stock; 
	}
	
	
	@Override
	public Cone orderCone(Cone.Flavor[] flavors) {
		try {
			return prepareCone(flavors); 
		}catch(NoMoreIceCreamException nice) {
			System.out.println(nice.getMessage());
		}
		return null;
		
	}
	private Cone prepareCone(Cone.Flavor[] flavors) throws NoMoreIceCreamException {
		Cone cone = new Cone(flavors);
		double priceCone=0;
		
		if (stock.getBalls() <= flavors.length || stock.getCones() <=0) {
			throw new NoMoreIceCreamException("You have no more balls or cones");
		}else {
		
		for(int i = 0; i < flavors.length; i++) {
			priceCone = priceCone + (flavors[i].getPriceFlavor()*pricelist.getBallPrice()); 
		}
		this.profit = this.profit + priceCone; 
		
		stock.setBalls(stock.getBalls()-flavors.length);
		stock.setCones(stock.getCones()-1);
		
		System.out.println("Here is your "+ cone.toString().toLowerCase()+" for " + priceCone+ " euros");
		
		return cone;
		}
	}
	
	@Override
	public IceRocket orderIceRocket() {

		try {
			return prepareRocket();
		}catch(NoMoreIceCreamException nice) {
			System.out.println(nice.getMessage());
		}
		return null;
	}

	
	private IceRocket prepareRocket() {
		IceRocket icerocket = new IceRocket();
		if (stock.getIceRockets() <= 0) {
			throw new NoMoreIceCreamException("You have no more IceRockets"); 
		} else {
		stock.setIceRockets(stock.getIceRockets()-1);
		this.profit = this.profit + pricelist.getRocketPrice();
		
		System.out.println("Here is your IceRocket for " + pricelist.getRocketPrice()+ " euros");
		return icerocket;
		}
	}
	
	@Override
	public Magnum orderMagnum(Magnum.MagnumType magnumtype)  {
		try {
			return prepareMagnum(magnumtype);
		}catch (NoMoreIceCreamException nice) {
			System.out.println(nice.getMessage()); 
		}
		return null;
	}
	
	private Magnum prepareMagnum(Magnum.MagnumType magnumtype) {
		Magnum magnum = new Magnum(magnumtype);

		if(stock.getMagni() <= 0 ) {
			throw new NoMoreIceCreamException("You have no more magni"); 
		}else {
		
		stock.setMagni(stock.getMagni()-1);
		this.profit = this.profit + pricelist.getMagnumPrice(magnum.getType()); 
		System.out.println("Here is your "+ magnum.getType()+" for " +pricelist.getMagnumPrice(magnum.getType()) + " euros");

		
		return magnum;	
		}
	}
	
	@Override
	public double getProfit() {
		return profit;
	}
	
}
