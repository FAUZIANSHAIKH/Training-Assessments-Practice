
package com.bawarchi.comparators;
import com.bawarchi.model.Dish;
import java.util.Comparator;
public class PriceGTComparator implements Comparator<Dish>
{
	
	@Override
	public int compare(Dish d1, Dish d2) {
		// TODO Auto-generated method stub
		return (int) (d2.getPrice()-d1.getPrice());
	}
}