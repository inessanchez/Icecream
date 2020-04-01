package be.intecbrussel.sellers;

import be.intecbrussel.eatables.*;
import be.intecbrussel.eatables.Cone.Flavor;
import be.intecbrussel.eatables.Magnum.MagnumType;

public interface IceCreamSeller extends Profitable {

	public abstract Cone orderCone(Flavor[] flavors); 
	public abstract IceRocket orderIceRocket(); 
	public abstract Magnum orderMagnum(MagnumType magnumtype); 
	
}
