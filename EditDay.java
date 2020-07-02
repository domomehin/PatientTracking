import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;

public class EditDay
extends JFrame implements ActionListener, ItemListener
{
	private final int DAY_TABLE = 2;
	private Analysis comp = new Analysis();
	private MainMethod dbObj = new MainMethod();
	//private AccessPage main1 = new AccessPage();
	
	private Box box = Box.createVerticalBox();
	private Calendar calP = new GregorianCalendar();
	private Calendar cal = Calendar.getInstance();
	private JFrame dayFrame = new JFrame("Day");
	
	//combobox for type date digestion, energy
	private int years = cal.get(Calendar.YEAR);
	private int months = cal.get(Calendar.MONTH);
	private int days = cal.get(Calendar.DAY_OF_MONTH);
	private int date = 0;
	private String[] month = {"January","February","March","April","May","June","July","August","October","September","November","December"};
	
	private Integer[] day = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,17, 18, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
	
	private Integer[] year = {1910,1911,1912,1913,1914,1915,1916,1917,1918,1919,1920,1921,1922,1923,1924,1925,1926,1927,1928,1929,1930,1931,
		1932,1933,1934,1935,1936,1937,1938,1939,1940,1941,1942,1943,1944,1945,1946,1947,1948,1949,1950,1951,1952,1953,1954,1955,1956,1957,1958,
		1959,1960,1961,1962,1963,1964,1965,1966,1967,1968,1969,1970,1971,1972,1973,1974,1975,1976,1977,1978,1979,1980,1981,1982,1983,1984,1985,1986,
		1987,1988,1989, 1990, 1991,1992,1993,1994,1995,1996, 1997,1998,1999,2000,2001,2002,2003,2004,2005,2006,2007,2008,2009,2011,2012,2013,2014,2015,2016,2017,
	2018,2019,2020,2021,2022,2023,2024,2025,2026,2027,2028,2029,2030,2031,2032,2033,2034,2035,2036,2037,2038,2039,2040,2041,2042,2043,2044,2045,2046,2047,2048};
	
	private String[] digestionFeel = {"Constipated","Bloated","Stable"};
	private String[] energyLevels = {"Exhausted","Tired","Energized","Fatigued"};
	private String[] exercise = {"Cardio","Weight Training","Yoga","Circuit Training"};
	
	private JComboBox<Integer> boxYear = new JComboBox<>(year);
	private JComboBox<Integer> boxDay = new JComboBox<>(day);
	private JComboBox<String> boxMonth = new JComboBox<>(month);
	
	private JComboBox<String> digestion = new JComboBox(digestionFeel);
	private JComboBox<String> energy = new JComboBox(energyLevels);	
	private JComboBox<String> exerciseType = new JComboBox(exercise);	
	
	private JTextField exerciseMin = new JTextField(10);
	private JTextField water = new JTextField(10);
	private JTextField sleep = new JTextField(10);
	private JTextField indexD = new JTextField(3);
	private JTextField firstn = new JTextField(20);
	private JTextField lastn = new JTextField(20);
	
	private JLabel dateLabel = new JLabel("Date");
	private JLabel indexLabel = new JLabel("Index");
	private JLabel firstnLabel = new JLabel("First Name");
	private JLabel lastnLabel = new JLabel("Last Name");
	private JLabel exerciseTypeLabel = new JLabel("Exercise Type");
	private JLabel exerciseMinLabel = new JLabel("Exercise Minutes");
	private JLabel digestionLabel = new JLabel("Digestion");
	private JLabel energyLabel = new JLabel("Energy Level");
	private JLabel waterImperialLabel = new JLabel("Water in ounces");
	private JLabel waterMetricLabel = new JLabel("Water in liters");
	private JLabel sleepLabel = new JLabel("Sleep in hours");
	private JLabel systemLabel = new JLabel("System");
	
	private JRadioButton metric = new JRadioButton("Metric");
	private JRadioButton imperial = new JRadioButton("Imperial");
	
	private ButtonGroup group1 = new ButtonGroup();
	
	private JButton dayTable = new JButton("View Table");
	private JButton insert = new JButton("Insert");
	private JButton update = new JButton("Update");
	private JButton delete = new JButton("Delete");
	private JButton exit = new JButton("Back");
	private JButton back = new JButton("Back to Main Page");
	
	private JPanel dayPanel = new JPanel(new FlowLayout());
	private JPanel buttonPanel = new JPanel(new FlowLayout());
	private JPanel buttonDPanel = new JPanel(new FlowLayout());
	
	private JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel indexPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel firstnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel lastnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel exerciseTypePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel exerciseMinPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel systemPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel digestionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel sleepPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel waterPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel energyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	
	private JScrollPane dayScroll = new JScrollPane();
	String[] columnTitles2 = new String[11];
	Object[][] data2 = dbObj.readDB(DAY_TABLE);
	
	public EditDay()
	{
		this.arrayYear();
		metric.setSelected(true);
		
	}
	//method for the cycle frame
	public void frameDay()
	{
		columnTitles2[0] = "Index";
		columnTitles2[1] = "First Name";
		columnTitles2[2] = "Last Name";
		columnTitles2[3] = "Date";
		columnTitles2[4] = "Exercise Type";
		columnTitles2[5] = "Exercise Min";
		columnTitles2[6] = "Water";
		columnTitles2[7] = "Energy";
		columnTitles2[8] = "Sleep";	
		columnTitles2[9] = "Digestion";
		columnTitles2[10] = "System";
		
		dayFrame.setBounds(500, 500, 1500, 2000); 
		dayFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		datePanel.add(dateLabel);
		datePanel.add(boxDay);
		datePanel.add(boxMonth);
		datePanel.add(boxYear);
		
		firstnPanel.add(firstnLabel);
		firstnPanel.add(firstn);
		
		lastnPanel.add(lastnLabel);	
		lastnPanel.add(lastn);
		
		exerciseTypePanel.add(exerciseTypeLabel);	
		exerciseTypePanel.add(exerciseType);
		
		exerciseMinPanel.add(exerciseMinLabel);
		exerciseMinPanel.add(exerciseMin);
		
		systemPanel.add(systemLabel);
		systemPanel.add(metric);
		systemPanel.add(imperial);
		
		digestionPanel.add(digestionLabel);
		digestionPanel.add(digestion);
		
		sleepPanel.add(sleepLabel);
		sleepPanel.add(sleep);
		
		waterPanel.add(waterMetricLabel);
		waterPanel.add(water);
		
		energyPanel.add(energyLabel);
		energyPanel.add(energy);
		
		indexPanel.add(indexLabel);
		indexPanel.add(indexD);
		
		group1.add(metric);
		group1.add(imperial);
		
		box.add(waterPanel);
		box.add(datePanel);
		box.add(sleepPanel);
		box.add(exerciseMinPanel);
		box.add(systemPanel);
		box.add(exerciseTypePanel);
		box.add(firstnPanel);
		box.add(lastnPanel);
		box.add(indexPanel);
		box.add(energyPanel);
		box.add(digestionPanel);
		
		dayTable.addActionListener(this);		
		insert.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		metric.addActionListener(this);
		exit.addActionListener(this);
		imperial.addActionListener(this);
		back.addActionListener(this);
		
		buttonPanel.add(dayTable);	
		buttonPanel.add(insert);
		buttonPanel.add(update);
		buttonPanel.add(delete);
		buttonPanel.add(back);
		buttonDPanel.add(exit);
		
	  dayFrame.add(buttonPanel,BorderLayout.SOUTH);	
		dayFrame.add(box,BorderLayout.NORTH);
		dayFrame.setVisible(true);
		
	}

	public void dTable()
	{
		data2 = dbObj.readDB(DAY_TABLE);
		
		JTable dayTable = new JTable(data2, columnTitles2);
		
		JTableHeader header = dayTable.getTableHeader();
		header.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		dayFrame.add(dayScroll, BorderLayout.CENTER);
		dayTable.setGridColor(Color.BLACK);
		dayScroll.getViewport().add(dayTable);
		dayTable.setFillsViewportHeight(true);
		dayFrame.add(buttonDPanel,BorderLayout.SOUTH);
		
		dayFrame.validate();
		dayFrame.repaint();
		System.out.println("Table Displayed");
	}
	public void arrayYear()
	{
		int i;
		
		for(i = 0; i< 100; i++)
		{
			year[i] = Integer.valueOf(years-i);
		}
	}
	public void itemStateChanged(ItemEvent e)
	{
		Object source = e.getItem();
		boolean leap;
		int monthIndex;
		int yearIndex;
		
		monthIndex = boxMonth.getSelectedIndex();
		yearIndex = boxYear.getSelectedIndex();
		
		leap = comp.leapYear(year[yearIndex]);
		
		if(monthIndex == 3 )
		{
			boxDay.removeAllItems();
			
			for(int i = 1; i < 31; i++)
			{
				boxDay.addItem(i);
			}
			
		}
		if(monthIndex == 5 )
		{
			boxDay.removeAllItems();
			
			for(int i = 1; i < 31; i++)
			{
				boxDay.addItem(i);
			}
			
		}
		if(monthIndex == 7 )
		{
			boxDay.removeAllItems();
			
			for(int i = 1; i < 31; i++)
			{
				boxDay.addItem(i);
			}
			
		}
		if(monthIndex == 9 )
		{
			boxDay.removeAllItems();
			
			for(int i = 1; i < 31; i++)
			{
				boxDay.addItem(i);
			}
			
		}
		if(monthIndex == 11)
		{
			boxDay.removeAllItems();
			
			for(int i = 1; i < 31; i++)
			{
				boxDay.addItem(i);
			}
			
		}
		if(monthIndex == 0)
		{
			boxDay.removeAllItems();
			
			for(int i = 1; i < 32; i++)
			{
				boxDay.addItem(i);
			}
			
		}
		if(monthIndex == 2)
		{
			boxDay.removeAllItems();
			
			for(int i = 1; i < 32; i++)
			{
				boxDay.addItem(i);
			}
			
		}
		if(monthIndex == 4)
		{
			boxDay.removeAllItems();
			
			for(int i = 1; i < 32; i++)
			{
				boxDay.addItem(i);
			}
			
		}
		if(monthIndex == 6)
		{
			boxDay.removeAllItems();
			
			for(int i = 1; i < 32; i++)
			{
				boxDay.addItem(i);
			}
			
		}
		if(monthIndex == 8)
		{
			boxDay.removeAllItems();
			
			for(int i = 1; i < 32; i++)
			{
				boxDay.addItem(i);
			}
			
		}
		if(monthIndex == 10)
		{
			boxDay.removeAllItems();
			
			for(int i = 1; i < 32; i++)
			{
				boxDay.addItem(i);
			}
			
		}
		if(monthIndex == 1 && leap)
		{
			boxDay.removeAllItems();
			
			for(int i = 1; i < 30; i++)
			{
				boxDay.addItem(i);
			}
			
		}
		if(monthIndex == 1 && !leap)
		{
			boxDay.removeAllItems();
			
			for(int i = 1; i < 29; i++)
			{
				boxDay.addItem(i);
			}
			
		}
		
	}
	public void actionPerformed(ActionEvent e)
	{
		boxDay.setSelectedIndex(days-1);
		boxMonth.setSelectedIndex(months);
		boxYear.setSelectedIndex(years-1);
		
		String buttonCommand = e.getActionCommand();
		String system = "";
		
		int indexDay = 0;
		int indexMonth = 0;
		int indexYear = 0;
		
		if(imperial.isSelected())
		{
			system = "Imperial";
			waterPanel.removeAll();
			
			waterPanel.add(waterImperialLabel);
			waterPanel.add(water);
			
			dayFrame.validate();
			dayFrame.repaint();				
		}
		
		//when imperial button is selected the panels change to fit metric system
		if(metric.isSelected())
		{
			system = "Metric";
			waterPanel.removeAll();
			
			waterPanel.add(waterMetricLabel);
			waterPanel.add(water);
			
			dayFrame.validate();
			dayFrame.repaint();	
		}
	/*	if(buttonCommand.equals("Back to Main Page"))
		{
			
			main1.setWindow();
			dayFrame.dispose();
		}*/
		else if(buttonCommand.equals("Insert"))
		{
			indexDay = boxDay.getSelectedIndex();
			indexMonth = boxMonth.getSelectedIndex();
			indexYear = boxYear.getSelectedIndex();    
		
			String newFirstName ="";
			String newLastName = "";
			int newIndex = 0 ;
			Double newSleep = 0.0 ;
			int newExerciseMin = 0 ;
			double newWater = 0;
			
			newFirstName = firstn.getText();
			newLastName = lastn.getText();
			newIndex = Integer.parseInt(this.indexD.getText());
			newExerciseMin = Integer.parseInt(exerciseMin.getText());
			newWater = Double.parseDouble(water.getText());
			newSleep = Double.parseDouble(sleep.getText());
			
			date = ((year[indexDay])*10000)+(indexMonth+1)*100+(indexYear+1); 
			
			if(system.equals("Imperial"))
				{
					newWater = comp.waterIntake(newWater);
				}
				
			
			System.out.println("Insert Cycle Information Table pressed");
			dbObj.dayInsert(newIndex, newFirstName, newLastName, date, exerciseType.getSelectedItem().toString(),
					newExerciseMin, newWater, energy.getSelectedItem().toString(),
				newSleep, digestion.getSelectedItem().toString(), system);

			System.out.println("Confirmed");
		}
		else if(buttonCommand.equals(update.getActionCommand()))
		{
			
			indexDay = boxDay.getSelectedIndex();
			indexMonth = boxMonth.getSelectedIndex();
			indexYear = boxYear.getSelectedIndex();    
		
			date = ((year[indexDay])*10000)+(indexMonth+1)*100+(indexYear+1); 
			
			String newFirstName ="";
			String newLastName = "";
			int newIndex = 0 ;
			double newSleep = 0 ;
			int newExerciseMin = 0 ;
			
			newFirstName = firstn.getText();
			newLastName = lastn.getText();
			newIndex = Integer.parseInt(this.indexD.getText());
			newExerciseMin = Integer.parseInt(exerciseMin.getText());
			double newWater = Double.parseDouble(water.getText());
			newSleep = Double.parseDouble(sleep.getText());
			
			if(system.equals("Imperial"))
				{
					newWater = comp.waterIntake(newWater);
				}
				
			
			
			System.out.println("Update Cycle Information Table pressed");
			dbObj.dayUpdate(newIndex, newFirstName, newLastName, date, exerciseType.getSelectedItem().toString(),
					newExerciseMin, newWater, energy.getSelectedItem().toString(),
				newSleep, digestion.getSelectedItem().toString(), system);
			System.out.println("Confirmed");
		}
	
		else if(buttonCommand.equals("Delete"))
		{
			System.out.println("Delete Cycle Information Table pressed");
			int newIndex = 0;
			newIndex = Integer.parseInt(this.indexD.getText());
			dbObj.dayDelete(newIndex);
			
		}
		else if(buttonCommand.equals("Display Day Table"))
		{
			this.dTable();
		}
		else if(buttonCommand.equals("Back"))
		{
			System.out.println("Exit pressed");
			this.frameDay();
		}
		else
			System.out.println("Unexpected Error");	
	}
}