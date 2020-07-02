/*My name is Diana Omomehin and the date is May 23rd 2017.
This program Creates a database, creates tables, delete tables
and is used to update and delete into tables*/
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Statement;
//class DBMethods
public class MainMethod
{
	//Declaring variables
	private String dBName = "Cycle";
	private String connectionURL = "jdbc:derby:" +dBName+ ";create=true";
	private Connection connect = null;
	private ResultSet res = null;
	
	private final int COLUMN_INFO = 9; 
	private final int COLUMN_DAY = 11;
	private final int COLUMN_PERIOD = 8;
	
	private final int PERIOD_TABLE = 3;
	private final int DAY_TABLE = 2;
	private final int INFO_TABLE = 1 ;
	
	//creating an object for the calculation
	private Analysis one = new Analysis();
	
	//Method to Create the DB
	public void  createDB()
	{
	  
		try
		{
			//connecting to Database
			connect = DriverManager.getConnection(connectionURL);
			System.out.println("Database connected");
		}
		catch(SQLException err)
		{
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			
		}
	}
	//Method to create basic information table
	public void createInfoTable()
	{
		try
		{
			Statement s = connect.createStatement();
			//SQL to create table for basic information
			s.execute("CREATE TABLE basicinformation" + 
				"(index int, firstname varchar(100), " +
				"lastname varchar(100), age int, height double, " +
				"weight double, allergies varchar(90), contraceptive varchar(90), system varchar(100))");
			System.out.println("Basic Information created");
		}
		catch(SQLException err)
		{
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			
		}
	}
	public void createDayTable()
	{
		//Using try and catch methods
		try
		{
			//finish adding the variables and add integer values
			Statement s = connect.createStatement();
			
			//Creating the day table by using SQL
			s.execute("CREATE TABLE day" + 
				"(index int, firstname varchar(100), " +
				"lastname varchar(100), date int, "+
				"exerciseType varchar(90),"+
				"exerciseMin int, water double, " +
				"energy varchar(90), sleep double, digestion varchar(90), system varchar(90) )");
			System.out.println("Day table created");
		}
		
		catch(SQLException err)
		{
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			
		}
	}
	public void createPeriodTable()
	{
		try
		{
			//add integer values for this table and add more variables
			Statement s = connect.createStatement();
			s.execute("CREATE TABLE period" +
				"(index int, firstname varchar(100), " +
				"lastname varchar(100), period varchar(90), date int," + 
				" flow varchar(90), pain int, mood varchar(90) )");
			System.out.println("Pain table created");
		}
		catch(SQLException err)
		{
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			
		}
	}

	public void basicDelete(int index)
	{
		try
		{
			connect = DriverManager.getConnection(connectionURL);
			if(connect != null)
			{
				Statement s = connect.createStatement();
				System.out.println("Deleting");
				s.execute("DELETE FROM basicinformation WHERE index = " + index);			
			}
		}
		catch(SQLException err)
		{
			System.err.println("SQL error");
			err.printStackTrace(System.err);	
		}	
	}
	public void dayDelete(int index)
	{
		try
		{
			connect = DriverManager.getConnection(connectionURL);
			if(connect != null)
			{
				Statement s = connect.createStatement();
				System.out.println("Deleting");
				s.execute("DELETE FROM day WHERE index = " 
					+ index);			
			}
		}
		catch(SQLException err)
		{
			System.err.println("SQL error");
			err.printStackTrace(System.err);	
		}	
	}
	public void periodDelete(int index)
	{
		try
		{
			connect = DriverManager.getConnection(connectionURL);
			if(connect != null)
			{
				Statement s = connect.createStatement();
				System.out.println("Delete");
				s.execute("DELETE FROM period WHERE index = " 
					+ index);			
			}
		}
		catch(SQLException err)
		{
			System.err.println("SQL error");
			err.printStackTrace(System.err);	
		}	
	}
	
	//To insert into the basic information table
	public void basicInsert(int index, String firstname, String lastname, int age, double height, double weight, String allergies, String contraceptive, String system)
	{
		try
		{
			connect = DriverManager.getConnection(connectionURL);
			//Inserting into Table
			if(connect != null)
			{
				Statement s = connect.createStatement();
				index = 0;
				
				res = s.executeQuery("SELECT * FROM basicinformation ");
				while(res.next())
				{
					if(res.getInt("index") > index)
						index = res.getInt("index");
				}
				index++;
				
				s.execute("INSERT INTO basicinformation VALUES ("+ index+", '"+firstname+ "', '"+ lastname
					+"' ," + age + ", "+ height + ", "+ weight+", '"+allergies+"', '"+contraceptive+"', '"+system+"')");
				System.out.println("Insert created");
			}
		}
		catch(SQLException err)
		{
			System.err.println("SQL error");
			err.printStackTrace(System.err);
		}
	}
	public void dayInsert(int index, String firstName, String lastName, int date, String exerciseType, int exerciseMin, double water, String energy, double sleep, String digestion, String system)
	{
		try
		{
			connect = DriverManager.getConnection(connectionURL);
			//Inserting into Table
			if(connect != null)
			{
				Statement s = connect.createStatement();
				index = 0;
				res = s.executeQuery("SELECT * FROM day ");
				while(res.next())
				{
					if(res.getInt("index") > index)
						index = res.getInt("index");
				}
				index++;
				
				s.execute("INSERT INTO day	VALUES("+ index+ ", '"+firstName+ "', '"+ lastName
					+"' , "+ date +", '" + exerciseType + "', "+ exerciseMin + ", "+ water
					+", '"+energy + "', "+ sleep + ", '"+ digestion+"', '"+system+"')");
				System.out.println("Insert created");
			}
		}
		catch(SQLException err)
		{
			System.err.println("SQL error");
			err.printStackTrace(System.err);
		}
	}
	public void periodInsert(int index, String firstName, String lastName, String period, int date, String flow, int pain, String mood)
	{
		try
		{
			connect = DriverManager.getConnection(connectionURL);
			//Inserting into Table
			if(connect != null)
			{

				index = 0;
				Statement s = connect.createStatement();
				
				res = s.executeQuery("SELECT * FROM period ");
				while(res.next())
				{
					if(res.getInt("index") > index)
						index = res.getInt("index");
				}
				index++;
				
				s.execute("INSERT INTO period VALUES("+ index+ ", '"+firstName+ "', '"+ lastName
					+"' ,'"+ period+"', " + date + ", '"+ flow + "', "+ pain+
					", '"+mood + "')");
				System.out.println("Insert created");
			}
		}
		
		catch(SQLException err)
		{
			System.err.println("SQL error");
			err.printStackTrace(System.err);
		}
	}

	public void basicUpdate(int index, String firstname, String lastname, int age, double height, double weight, String allergies, String contraceptive, String system)
	{
		try
		{
			connect = DriverManager.getConnection(connectionURL);
			//Inserting into Table
			if(connect != null)
			{
				index = 0;
				Statement s = connect.createStatement();
				
				s.execute("UPDATE basicinformation SET firstname = '"+firstname+"', lastname = '"+lastname+"', age = "+age+", height = "+height+", weight = "+weight+", allergies = '"+allergies+"', contraceptive = '"+contraceptive+"', system = '"+system+"' WHERE index = "+index);
				System.out.println("Update");
			}
		}
		
		catch(SQLException err)
		{
			System.err.println("SQL error");
			err.printStackTrace(System.err);
		}
	}
	public void dayUpdate(int index, String firstName, String lastName, int date, String exerciseType, int exerciseMin, double water, String energy, double sleep, String digestion, String system)
	{
		try
		{
			connect = DriverManager.getConnection(connectionURL);
			//Inserting into Table
			if(connect != null)
			{
				index = 0;
				Statement s = connect.createStatement();
				
				s.execute("UPDATE day SET firstname = '"+firstName+"', lastname = '"+lastName+"', date = "+date+", exerciseType = '"+exerciseType+"', exerciseMin = "+exerciseMin
					+", water = "+water+", energy = '"+energy+"', sleep = "+sleep+", digestion= '"+digestion+"', system = '"+system+"' WHERE index = "+index);
				System.out.println("Update");
			}
		}
		
		catch(SQLException err)
		{
			System.err.println("SQL error");
			err.printStackTrace(System.err);
		}
	}
	public void periodUpdate(int index, String firstName, String lastName, String period, int date, String flow, int pain, String mood)
	{
		try
		{
			connect = DriverManager.getConnection(connectionURL);
			//Inserting into Table
			if(connect != null)
			{
				
				Statement s = connect.createStatement();
				
				s.execute("UPDATE period SET firstname = '"+firstName+"', lastname = '"+lastName+"', period = '"+period+"', date = "+date+", flow = '"+flow+"', pain = "+pain+", mood = '"+mood
					+"' WHERE index = "+index);
				System.out.println("Update");
			}
		}
		
		catch(SQLException err)
		{
			System.err.println("SQL error");
			err.printStackTrace(System.err);
		}
	}
	public String grabFirstName()
	{
		String firstname = "";
		
		try
		{	
			
			connect = DriverManager.getConnection(connectionURL);
			
			if(connect != null)
			{	
				Statement s = connect.createStatement();
				res = s.executeQuery("SELECT firstname FROM basicinformation");
				
				if(res.next())
				{
					firstname = res.getString("firstname"); 				
				}	
				
			}
		}
		
		catch (SQLException err)
		{
			System.err.println("Sql error");
			err.printStackTrace(System.err);
		}	
		
		return firstname;
	}
	
	public String grabLastName()
	{
		String lastname = "";
		
		try
		{	
			
			connect = DriverManager.getConnection(connectionURL);
			
			if(connect != null)
			{	
				Statement s = connect.createStatement();
				res = s.executeQuery("SELECT lastname FROM basicinformation");
				
				if(res.next())
				{
					lastname = res.getString("lastname"); 				
				}	
				
			}
		}
		
		catch (SQLException err)
		{
			System.err.println("Sql error");
			err.printStackTrace(System.err);
		}	
		
		return lastname;
	}
	public String grabAllergies()
	{
		String allergies = "";
		
		try
		{	
			connect = DriverManager.getConnection(connectionURL);
			
			if(connect != null)
			{	
				Statement s = connect.createStatement();
				res = s.executeQuery("SELECT allergies FROM basicinformation");
				
				if(res.next())
				{
					allergies = res.getString("allergies"); 				
				}	
				
			}
		}
		
		catch (SQLException err)
		{
			System.err.println("Sql error");
			err.printStackTrace(System.err);
		}	
		
		return allergies;
	}
	public int grabAge()
	{
		int age = 0;
		
		try
		{	
			
			connect = DriverManager.getConnection(connectionURL);
			
			if(connect != null)
			{	
				Statement s = connect.createStatement();
				res = s.executeQuery("SELECT age FROM basicinformation");
				
				if(res.next())
				{
					age = res.getInt("age"); 				
				}	
				
			}
		}
		
		catch (SQLException err)
		{
			System.err.println("Sql error");
			err.printStackTrace(System.err);
		}	
		
		return age;
	}
		public int grabPain()
	{
		int pain = 0;
		
		try
		{	
			
			connect = DriverManager.getConnection(connectionURL);
			
			if(connect != null)
			{	
				Statement s = connect.createStatement();
				res = s.executeQuery("SELECT pain FROM period");
				
				if(res.next())
				{
					pain = res.getInt("pain"); 				
				}	
				
			}
		}
		
		catch (SQLException err)
		{
			System.err.println("Sql error");
			err.printStackTrace(System.err);
		}	
		
		return pain;
	}
	public double grabHeight()
	{
		double height = 0;
		
		try
		{	
			
			connect = DriverManager.getConnection(connectionURL);
			
			if(connect != null)
			{	
				Statement s = connect.createStatement();
				res = s.executeQuery("SELECT height FROM basicinformation");
				
				if(res.next())
				{
					height = res.getDouble("height"); 				
				}	
				
			}
		}
		
		catch (SQLException err)
		{
			System.err.println("Sql error");
			err.printStackTrace(System.err);
		}	
		
		return height;
	}
	public double grabWeight()
	{
		double weight = 0;
		
		try
		{	
			
			connect = DriverManager.getConnection(connectionURL);
			
			if(connect != null)
			{	
				Statement s = connect.createStatement();
				res = s.executeQuery("SELECT weight FROM basicinformation");
				
				if(res.next())
				{
					weight = res.getDouble("weight"); 				
				}	
				
			}
		}
		
		catch (SQLException err)
		{
			System.err.println("Sql error");
			err.printStackTrace(System.err);
		}	           
		
		return weight;
	}
	public String grabSystem()
	{
		String system = "";
		
		try
		{	
			
			connect = DriverManager.getConnection(connectionURL);
			
			if(connect != null)
			{	
				Statement s = connect.createStatement();
				res = s.executeQuery("SELECT system FROM basicinformation");
				
				if(res.next())
				{
					system = res.getString("system"); 				
				}	
				
			}
		}
		
		catch (SQLException err)
		{
			System.err.println("Sql error");
			err.printStackTrace(System.err);
		}	           
		
		return system;
	}
	public String grabSystem2()
	{
		String system = "";
		
		try
		{	
			
			connect = DriverManager.getConnection(connectionURL);
			
			if(connect != null)
			{	
				Statement s = connect.createStatement();
				res = s.executeQuery("SELECT system FROM day");
				
				if(res.next())
				{
					system = res.getString("system"); 				
				}	
				
			}
		}
		
		catch (SQLException err)
		{
			System.err.println("Sql error");
			err.printStackTrace(System.err);
		}	           
		
		return system;
	}
	
	public Object[][] readDB(int tableNo)
	{
		int rowSize;
		int colSize;
		Object[][] dataTable = null;
		int rowNo= 0;
		
		try
		{			
			connect = DriverManager.getConnection(connectionURL);
			
			Statement s = connect.createStatement();
			if (tableNo == 1)
			{
				rowSize = rowCount(INFO_TABLE);
				colSize = COLUMN_INFO;
				dataTable = new Object[rowSize][colSize];
				res = s.executeQuery("SELECT * FROM basicinformation");
				
				//Printing Query Result
				while (res.next())
				{
					dataTable[rowNo][0]= res.getInt("index");
					dataTable[rowNo][1]= res.getString("firstname");
					dataTable[rowNo][2]= res.getString("lastname");
					dataTable[rowNo][3]= res.getInt("age");
					dataTable[rowNo][4]= res.getDouble("height");
					dataTable[rowNo][5]= res.getDouble("weight");
					dataTable[rowNo][6]= res.getString("allergies");
					dataTable[rowNo][7]= res.getString("contraceptive");
					dataTable[rowNo][8]= res.getString("system");
					rowNo++;
				}
			}
			else if(tableNo==2)
			{
				rowSize = rowCount(DAY_TABLE);
				colSize = COLUMN_DAY;
				dataTable = new Object[rowSize][colSize];
				res = s.executeQuery("SELECT * FROM day");
				
				while(res.next())
				{
					dataTable[rowNo][0]= res.getInt("index");
					dataTable[rowNo][1]= res.getInt("firstname");
					dataTable[rowNo][2]= res.getString("lastname");
					dataTable[rowNo][3]= res.getInt("date");
					dataTable[rowNo][4]= res.getString("exerciseType");
					dataTable[rowNo][5]= res.getInt("exerciseMin");
					dataTable[rowNo][6]= res.getDouble("water");
					dataTable[rowNo][7]= res.getString("energy");
					dataTable[rowNo][8]= res.getDouble("sleep");
					dataTable[rowNo][9]= res.getString("digestion");
					dataTable[rowNo][10]= res.getString("system");
					rowNo++;
				}
			} 
			else
			{
				rowSize = rowCount(PERIOD_TABLE);
				colSize = COLUMN_PERIOD;
				dataTable = new Object[rowSize][colSize];
				res = s.executeQuery("SELECT * FROM period");
				
				while(res.next())
				{
					dataTable[rowNo][0]= res.getInt("index");
					dataTable[rowNo][1]= res.getInt("firstname");
					dataTable[rowNo][2]= res.getString("lastname");
					dataTable[rowNo][3]= res.getString("period");
					dataTable[rowNo][4]= res.getInt("date");
					dataTable[rowNo][5]= res.getString("flow");
					dataTable[rowNo][6]= res.getString("pain");
					dataTable[rowNo][7]= res.getString("mood");
					
					rowNo++;
				}
			}
			
			//close res, close connect
			res.close();
			
		}
		catch (SQLException err)
		{
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			
		}
		return dataTable;
	}
	
	public int rowCount(int tableName)
	{
		int rowSize = 0;
		
		try
		{
			Statement s = connect.createStatement();
			if (tableName == INFO_TABLE)
			{
				res = s.executeQuery("SELECT COUNT(*) AS rowCounter FROM basicinformation");
			}
			else if (tableName == DAY_TABLE)
			{
				res = s.executeQuery("SELECT COUNT(*) AS rowCounter FROM day");
			}
			else if(tableName == PERIOD_TABLE)
			{
				res = s.executeQuery("SELECT COUNT(*) AS rowCounter FROM period");
			}
			else 
			{
				System.out.println("ERROR!! No table found");
			}
			while (res.next())
			{
				rowSize =res.getInt("rowCounter");
			}
			res.close();
			System.out.println(" The number of rows is " + rowSize);
		}
		catch (SQLException err)
		{
			System.err.println("SQL error");
			err.printStackTrace(System.err);
			
		}
		return rowSize; 
	}
}
	
	
	
	
	
	
	
	
