public class Guidelines
{
	MainMethod info = new MainMethod();
	StringBuilder prescription = new StringBuilder(""); 
	StringBuilder exercise = new StringBuilder(""); 
	StringBuilder water = new StringBuilder("");
	StringBuilder sleep = new StringBuilder("");
	
	//declairng necesary variables
	private int age;
	private int pain;
	private double height;
	private double weight;
	private String system;
	private String system2;
	private String allergies;
	//class construtor
	public Guidelines()
	{	
		//setting up the variables
		system = info.grabSystem();
		height = info.grabHeight();
		age = info.grabAge();
		pain = info.grabPain();
		weight = info.grabWeight();
		allergies = info.grabAllergies();
		system2 = info.grabSystem2();
	}
	
	//method to check sleep
	public String sleepGuide()
	{
		
		if(age >= 13 && age <= 18)
		{
			sleep.setLength(0);
			sleep.append("8 to 10 hours of sleep every 24 hours");
		}
		
		else if(age >= 19 && age <= 64)
		{
			sleep.setLength(0);
			sleep.append("7 to 9 hours of sleep every 24 hours");
		}
		else if(age >= 64)
		{
			sleep.setLength(0);
			sleep.append("7 to 8 hours of sleep every 24 hours");
		}
		else
		{
			sleep.setLength(0);
			sleep.append("Sleep guideline is unknown");
		}
		
		//return value
		return sleep.toString();
	}
	
	public String waterGuide()
	{
		if(system2.equals("Metric"))
		{
			if(weight < 45)
			{ 
				water.setLength(0);
				water.append("Drink 1.48 to 2.1 litres of water per day");
			}
			if(weight>=45 && weight <= 68.4)
			{
				water.setLength(0);
				water.append("Drink 2.1 to 2.96 litres of water per day");
			}
			if(weight>=68.5 && weight <= 90.7)
			{
				water.setLength(0);
				water.append("Drink 2.96 to 4.14 litres of water per day");
			}
			if(weight>=90.8 && weight <= 136.1)
			{
				water.setLength(0);
				water.append("Drink 4.14 to 6 litres of water per day");
			}
			if(weight>136.1)
			{
				water.setLength(0);
				water.append("Drink at least 7 litres of water per day");
			}
			
		}
		
		//checking if system is imperial
		else if(system2.equals("Imperial"))
		{
			if(weight< 100)
			{ 
				water.setLength(0);
				water.append("Drink 50 to 70 ounces of water per day");
			}
			if(weight>=100 && weight <= 150)
			{
				water.setLength(0);
				water.append("Drink 70 to 100 ounces of water per day");
			}
			if(weight>=151 && weight <= 200)
			{
				water.setLength(0);
				water.append("Drink 100 to 140 ounces of water per day");
			}
			if(weight>=201 && weight <= 300)
			{
				water.setLength(0);
				water.append("Drink 140 to 200 ounces of water per day");
			}
			if(weight>300)
			{
				water.setLength(0);
				water.append("Drink at least 250 ounces of water per day");
			}
			
			
		}
		//return value
		return water.toString();	
	}
	public String prescriptionGuide()
	{
		
		if(pain == 0)
		{
			prescription.setLength(0);
			prescription.append("Do not take ibuprofen");
		}
		
		else if(pain >=1)  
		{ 
			if(system.equals("Metric"))
				{
					if( allergies.equals("Ibuprofen"))
						{
							prescription.setLength(0);
							prescription.append("Take 500mg of tylenol every 4 to 6 hours");
						}
						else 
						{
							prescription.setLength(0);
							prescription.append("Take 400mg of ibuprofen every 4 to 6 hours");
						}
				}
				else if(system.equals("Imperial"))
					{
						if(allergies.equals("Ibuprofen"))
							{
								prescription.setLength(0);
								prescription.append("Take 0.018 ounces of tylenol every 4 to 6 hours");
							}
							else 
							{
								prescription.setLength(0);
								prescription.append("Take 0.014 ounces of ibuprofen every 4 to 6 hours");
							}
					}
		}
		return prescription.toString();
	}
	public String exerciseGuide()
	{
		if(system.equals("Imperial"))
			{
				if(height >= 58 && height <= 60)
				{
					if(weight>=91 && weight <= 123)
					{
						exercise.setLength(0);
						exercise.append("Do 150 minutes of moderate-intensity exercise per week");
					}
					else if (weight>=124 && weight <= 148)
					{
						exercise.setLength(0);
						exercise.append("Do 200 minutes of moderate-intensity exercise per week");
					}
					else if (weight>=149 && weight <= 199)
					{
						exercise.setLength(0);
						exercise.append("Do 250 minutes of moderate-intensity exercise per week");
					}
					else if (weight>=200 && weight <= 276)
					{
						exercise.setLength(0);
						exercise.append("Do at least 300 minutes of moderate-intensity exercise per week");
					}
					else 
					{
						exercise.setLength(0);
						exercise.append("exercise guideline is unknown");
					}
				}
				else if (height >60 && height <= 65)
				{
					if(weight>=100 && weight <= 144)
					{
						exercise.setLength(0);
						exercise.append("Do 150 minutes of moderate-intensity exercise per week");
					}
					else if (weight>=145 && weight <= 174)
					{
						exercise.setLength(0);
						exercise.append("Do 200 minutes of moderate-intensity exercise per week");
					}
					else if (weight>=175 && weight <= 234)
					{
						exercise.setLength(0);
						exercise.append("Do 250 minutes of moderate-intensity exercise per week");
					}
					else if (weight>=235 && weight <= 324)
					{
						exercise.setLength(0);
						exercise.append("Do at least 300 minutes of moderate-intensity exercise per week");
					}
					else 
					{
						exercise.setLength(0);
						exercise.append("exercise guideline is unknown");
					}
				}
				else if(height >65 && height <= 70)
				{
					if(weight>=118 && weight <= 167)
					{
						exercise.setLength(0);
						exercise.append("Do 150 minutes of moderate-intensity exercise per week");
					}
					else if (weight>=168 && weight <= 202)
					{
						exercise.setLength(0);
						exercise.append("Do 200 minutes of moderate-intensity exercise per week");
					}
					else if (weight>=203 && weight <= 271)
					{
						exercise.setLength(0);
						exercise.append("Do 250 minutes of moderate-intensity exercise per week");
					}
					else if (weight>=272 && weight <= 376)
					{
						exercise.setLength(0);
						exercise.append("Do at least 300 minutes of moderate-intensity exercise per week");
					}
					else 
					{
						exercise.setLength(0);
						exercise.append("exercise guideline is unknown");
					}
				}
				else if(height >70 && height <= 76)
				{
					if(weight>=132 && weight <= 197)
					{
						exercise.setLength(0);
						exercise.append("Do 150 minutes of moderate-intensity exercise per week");
					}
					
					else if (weight>=198 && weight <= 238)
					{
						exercise.setLength(0);
						exercise.append("Do 200 minutes of moderate-intensity exercise per week");
					}
					
					else if (weight>=239 && weight <= 320)
					{
						exercise.setLength(0);
						exercise.append("Do 250 minutes of moderate-intensity exercise per week");
					}
					
					else if (weight>=321 && weight <= 443)
					{
						exercise.setLength(0);
						exercise.append("Do at least 300 minutes of moderate-intensity exercise per week");
					}
					
					else 
					{
						exercise.setLength(0);
						exercise.append("exercise guideline is unknown");
					}
					
				}
			}
			else if(system.equals("Metric"))
				{
					if(height >= 147.32 && height <= 152.4)
					{
						if(weight>=41.3 && weight <= 55.8)
						{
							exercise.setLength(0);
							exercise.append("Do 150 minutes of moderate-intensity exercise per week");
						}
						else if (weight>=55.9 && weight <= 67.13)
						{
							exercise.setLength(0);
							exercise.append("Do 200 minutes of moderate-intensity exercise per week");
						}
						else if (weight>=67.14 && weight <= 90.26)
						{
							exercise.setLength(0);
							exercise.append("Do 250 minutes of moderate-intensity exercise per week");
						}
						else if (weight>=90.27 && weight <= 124.74)
						{
							exercise.setLength(0);
							exercise.append("Do at least 300 minutes of moderate-intensity exercise per week");
						}
						else 
						{
							exercise.setLength(0);
							exercise.append("exercise guideline is unknown");
						}
					}
					else if (height >152.4 && height <= 165.1)
					{
						if(weight>=45.36 && weight <= 65.32)
						{
							exercise.setLength(0);
							exercise.append("Do 150 minutes of moderate-intensity exercise per week");
						}
						else if (weight>=65.33 && weight <= 78.93)
						{
							exercise.setLength(0);
							exercise.append("Do 200 minutes of moderate-intensity exercise per week");
						}
						else if (weight>=78.94 && weight <= 106.14)
						{
							exercise.setLength(0);
							exercise.append("Do 250 minutes of moderate-intensity exercise per week");
						}
						else if (weight>=106.15 && weight <= 150)
						{
							exercise.setLength(0);
							exercise.append("Do at least 300 minutes of moderate-intensity exercise per week");
						}
						else 
						{
							exercise.setLength(0);
							exercise.append("exercise guideline is unknown");
						}
					}
					else if(height >165.1 && height <= 177.8)
					{
						if(weight>=53.5 && weight <=75.74)
						{
							exercise.setLength(0);
							exercise.append("Do 150 minutes of moderate-intensity exercise per week");
						}
						else if (weight>=75.75 && weight <= 91.63)
						{
							exercise.setLength(0);
							exercise.append("Do 200 minutes of moderate-intensity exercise per week");
						}
						else if (weight>=91.64 && weight <= 122.9)
						{
							exercise.setLength(0);
							exercise.append("Do 250 minutes of moderate-intensity exercise per week");
						}
						else if (weight>=123 && weight <= 172.36)
						{
							exercise.setLength(0);
							exercise.append("Do at least 300 minutes of moderate-intensity exercise per week");
						}
						else 
						{
							exercise.setLength(0);
							exercise.append("exercise guideline is unknown");
						}
					}
					else if(height >177.8 && height <= 193.04)
					{
						if(weight>=59.87 && weight <= 89.36)
						{
							exercise.setLength(0);
							exercise.append("Do 150 minutes of moderate-intensity exercise per week");
						}
						
						else if (weight>=89.37 && weight <= 107.96)
						{
							exercise.setLength(0);
							exercise.append("Do 200 minutes of moderate-intensity exercise per week");
						}
						
						else if (weight>=107.97 && weight <= 145.2)
						{
							exercise.setLength(0);
							exercise.append("Do 250 minutes of moderate-intensity exercise per week");
						}
						
						else if (weight>=145.3 && weight <= 200.9)
						{
							exercise.setLength(0);
							exercise.append("Do at least 300 minutes of moderate-intensity exercise per week");
						}
						
						else 
						{
							exercise.setLength(0);
							exercise.append("exercise guideline is unknown");
						}
						
					}
				}
				return exercise.toString();
	}
}


