package com.bawarchi.comparators;
import com.bawarchi.model.Dish;

import com.sapient.pe.model.Comparators.*;
import java.util.Comparator;

public class Comp implements Comparator<Dish>{
	public enum CompType
		{
			PRICE_ASC,PRICE_DESC,CALORIES_ASC,CALORIES_DESC;
		}
		public static Comparator<Dish> getComparator(CompType ct)
		{
			switch(ct)
			{
			case PRICE_ASC:
				return new Idsorterasc();
		
			case PRICE_DESC:
				return new Idsorterdesc();
			case CALORIES_ASC:
				return new Idsorterasc();
			case CALORIES_DESC:
				return new Idsorterasc();
			default:
				return  new Idsorterasc();
			
			}
			
		}
		@Override
		public int compare(com.sapient.pe.model.Dish o1, com.sapient.pe.model.Dish o2) {
			// TODO Auto-generated method stub
			return 0;
		}
}
