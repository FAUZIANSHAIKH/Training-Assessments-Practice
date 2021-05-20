package com.bawarchi.comparators;
import java.util.Comparator;

import com.bawarchi.model.Dish;
public class Comp {
	public enum CompType
		{
			PRICE_ASC,PRICE_DESC,CALORIES_ASC,CALORIES_DESC;
		}
		public static Comparator<Dish> getComparator(CompType ct)
		{
			switch(ct)
			{
			case PRICE_ASC:
				return new PriceASC();
		
			case PRICE_DESC:
				return new PriceGTComparator();
			case CALORIES_ASC:
				return new CaloriesGTComparator();
			case CALORIES_DESC:
				return new CaloriesLTComparator();
		
			}
			return null; 
			
		}
}
