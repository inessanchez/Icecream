package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;

public class IceCreamSalon implements IceCreamSeller{
	private PriceList priceList; 
	private double totalProfit; 
	
	 public IceCreamSalon(PriceList priceList) {
		 this.priceList = priceList; 
	 }
	
	@Override
	public double getProfit() {
		return totalProfit;
	}

	@Override
	public Cone orderCone(Cone.Flavor[] flavors) {
		Cone cone = new Cone(flavors);
		double priceCone=0;
		
		for(int i = 0; i < flavors.length; i++) {
			priceCone = priceCone + flavors[i].getPriceFlavor(); 
		}; 
	
		this.totalProfit = this.totalProfit + flavors.length*priceList.getBallPrice() + priceCone; 
		return cone;
	}

	@Override
	public IceRocket orderIceRocket() {
		IceRocket icerocket = new IceRocket();
		this.totalProfit = this.totalProfit + priceList.getRocketPrice(); 
		return icerocket;
	}

	@Override
	public Magnum orderMagnum(Magnum.MagnumType magnumtype) {
		Magnum magnum = new Magnum(magnumtype);
		this.totalProfit = this.totalProfit + priceList.getMagnumPrice(magnum.getType()); 
		return magnum;
	}

	@Override
	public String toString() {
		return "IceCreamSalon [priceList=" + priceList + ", totalProfit=" + totalProfit + "]";
	}

}
