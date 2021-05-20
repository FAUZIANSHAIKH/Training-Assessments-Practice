
package com.bawarchi.comparators;
import com.bawarchi.model.Dish;
import java.util.Comparator;
public class  PriceASC implements Comparator<Dish>
{
	

	

	@Override
	public int compare(Dish d1, Dish d2) {
		// TODO Auto-generated method stub
		return (int) (d1.getPrice()-d2.getPrice());
	}
}