package com.bawarchi.comparators;
import com.bawarchi.model.Dish;
import java.util.Comparator;
public class CaloriesLTComparator implements Comparator<Dish>
{

		public int compare(Dish d1, Dish d2) {
			// TODO Auto-generated method stub
			return (int) (d1.getCalories()-d2.getCalories());
		}
	
}
