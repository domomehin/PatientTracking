import java.util.*;
public class Analysis
{
	int day1;
	public boolean leapYear(int year)
	{
		int x;
		int leap = 0;
		
		x = year%4;
		
		if(x == leap)
			return true;
		else
			return false;
	}
	public double imperialH(double h1)
	{
		//declaring variable
		double h2;
		
		h2 = h1 * 2.54;
		
		return h2;
	}
	
	public double imperialW(double w1)
	{
		double w2;
		
		w2 = w1 * (1/2.20462) ;
		
		return w2;
	}
	public double imperialHeight(double heightInInches)
	{
		//declaring variable
		double convertedHeight;
		
		//converting the height
		convertedHeight = heightInInches* 2.54;
		
		//returning value
		return convertedHeight;
	}
	
	//formula to convert pounds into kg for db input
	public double imperialWeight(double weightInPounds)
	{
		//declare variable
		double convertedWeight;
		
		//converting weight
		convertedWeight = weightInPounds* (1/2.20462) ;
		
		//return value
		return convertedWeight;
	}
	
	//formula to convert water intake from liters to ounces
	public double waterIntake(double waterInOunces)
	{
		//declare variabel
		double convertedWater;
		
		//converting water
		convertedWater = waterInOunces* 0.0295735 ;
		
		//return value
		return convertedWater;
	}
	public Date nextPeriod(int day, int month, int year, int noOfDays)
	{
		Date output;
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_MONTH, day);
		cal.set(Calendar.MONTH, month); 
		cal.set(Calendar.YEAR, year);
		cal.add(Calendar.DAY_OF_MONTH, noOfDays);
		output = cal.getTime();
		return output;
	}
	
	
}
