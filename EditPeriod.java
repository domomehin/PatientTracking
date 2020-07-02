import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;

public class EditPeriod
extends JFrame implements ActionListener, ItemListener
{
	private final int PERIOD_TABLE = 2;
	private Analysis comp = new Analysis();
	private MainMethod dbObj = new MainMethod();
	//private AccessPage main1 = new AccessPage();
	
	private Box box = Box.createVerticalBox();
	private Calendar calP = new GregorianCalendar();
	private Calendar cal = Calendar.getInstance();
	private JFrame periodFrame = new JFrame("Period");
	
	
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
	
	private String[] flowLevel = {"Light","Medium","Heavy","Spotting"};
	private Integer[] painLevel = {0,1,2,3,4,5};
	private String[] moodLevel = {"Happy","Sad","Sensitive","PMS"};
	
	private JComboBox<Integer> boxYear = new JComboBox<>(year);
	private JComboBox<Integer> boxDay = new JComboBox<>(day);
	private JComboBox<String> boxMonth = new JComboBox<>(month);
	
	private JComboBox<String> flow = new JComboBox(flowLevel);
	private JComboBox<Integer> pain = new JComboBox(painLevel);	
	private JComboBox<String> mood = new JComboBox(moodLevel);	
	
	private JTextField period = new JTextField(10);
	private JTextField indexP = new JTextField(3);
	private JTextField firstn = new JTextField(20);
	private JTextField lastn = new JTextField(20);
	
	private JLabel dateLabel = new JLabel("Date");
	private JLabel indexLabel = new JLabel("Index");
	private JLabel firstnLabel = new JLabel("First Name");
	private JLabel lastnLabel = new JLabel("Last Name");
	private JLabel periodLabel = new JLabel("Period Y/N");
	private JLabel flowLabel = new JLabel("Flow Level ");
	private JLabel painLabel = new JLabel("Pain Level");
	private JLabel moodLabel = new JLabel("Mood");
	
	private JButton periodTable = new JButton("View Table");
	private JButton insert = new JButton("Insert");
	private JButton update = new JButton("Update");
	private JButton delete = new JButton("Delete");
	private JButton exit = new JButton("Back");
	private JButton back = new JButton("Back to Main Page");
	
	private JPanel periodPanel = new JPanel(new FlowLayout());
	private JPanel buttonPanel = new JPanel(new FlowLayout());
	private JPanel buttonPPanel = new JPanel(new FlowLayout());
	
	private JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel indexPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel firstnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel lastnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel periodLabelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel flowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel painPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel moodPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	
	private JScrollPane periodScroll = new JScrollPane();
	String[] columnTitles3 = new String[8];
	Object[][] data3 = dbObj.readDB(PERIOD_TABLE);
	
	public EditPeriod()
	{
		this.arrayYear();
		
	}
	//method for the cycle frame
	public void framePeriod()
	{
		columnTitles3[0] = "Index";
		columnTitles3[1] = "First Name";
		columnTitles3[2] = "Last Name";
		columnTitles3[3] = "Period";
		columnTitles3[4] = "Date";
		columnTitles3[5] = "Flow";
		columnTitles3[6] = "Pain";
		columnTitles3[7] = "Mood";
		
		periodFrame.setBounds(500, 500, 1500, 2000); 
		periodFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		datePanel.add(dateLabel);
		datePanel.add(boxDay);
		datePanel.add(boxMonth);
		datePanel.add(boxYear);
		
		firstnPanel.add(firstnLabel);
		firstnPanel.add(firstn);
		
		lastnPanel.add(lastnLabel);	
		lastnPanel.add(lastn);
		
		periodLabelPanel.add(periodLabel);	
		periodLabelPanel.add(period);
		
		flowPanel.add(flowLabel);
		flowPanel.add(flow);
		
		painPanel.add(painLabel);
		painPanel.add(pain);
		
		moodPanel.add(moodLabel);
		moodPanel.add(mood);
		
		indexPanel.add(indexLabel);
		indexPanel.add(indexP);
		
		box.add(indexPanel);
		box.add(firstnPanel);
		box.add(lastnPanel);
		box.add(datePanel);
		box.add(periodLabelPanel);
		box.add(flowPanel);
		box.add(painPanel);
		box.add(moodPanel);
		
		periodTable.addActionListener(this);		
		insert.addActionListener(this);
		update.addActionListener(this);
		delete.addActionListener(this);
		exit.addActionListener(this);
		back.addActionListener(this);
		
		buttonPanel.add(periodTable);	
		buttonPanel.add(insert);
		buttonPanel.add(update);
		buttonPanel.add(delete);
		buttonPanel.add(back);
		buttonPPanel.add(exit);
		
	  periodFrame.add(buttonPanel,BorderLayout.SOUTH);	
		periodFrame.add(box,BorderLayout.NORTH);
		periodFrame.setVisible(true);
		
	}

	public void pTable()
	{
		data3 = dbObj.readDB(PERIOD_TABLE);
		
		JTable periodTable = new JTable(data3, columnTitles3);
		
		JTableHeader header = periodTable.getTableHeader();
		header.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		periodFrame.add(periodScroll, BorderLayout.CENTER);
		periodTable.setGridColor(Color.BLACK);
		periodScroll.getViewport().add(periodTable);
		periodTable.setFillsViewportHeight(true);
		periodFrame.add(buttonPPanel,BorderLayout.SOUTH);
		
		periodFrame.validate();
		periodFrame.repaint();
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
		
		int indexDay = 0;
		int indexMonth = 0;
		int indexYear = 0;
		
		/*if(buttonCommand.equals("Back to Main Page"))
		{
			
			main1.setWindow();
			periodFrame.dispose();
		}*/
		else if(buttonCommand.equals("Insert"))
		{
			indexDay = boxDay.getSelectedIndex();
			indexMonth = boxMonth.getSelectedIndex();
			indexYear = boxYear.getSelectedIndex();    
		
			String newFirstName ="";
			String newLastName = "";
			String newPeriod = "";
			int newIndex = 0 ;
			
			newFirstName = firstn.getText();
			newLastName = lastn.getText();
			newPeriod = period.getText();
			newIndex = Integer.parseInt(this.indexP.getText());
			
			date = ((year[indexDay])*10000)+(indexMonth+1)*100+(indexYear+1); 
			
			System.out.println("Insert Cycle Information Table pressed");
			dbObj.periodInsert(newIndex, newFirstName, newLastName, newPeriod, date,
			flow.getSelectedItem().toString(), pain.getSelectedIndex(), 
			mood.getSelectedItem().toString());

			System.out.println("Confirmed");
		}
		else if(buttonCommand.equals(update.getActionCommand()))
		{
			
			indexDay = boxDay.getSelectedIndex();
			indexMonth = boxMonth.getSelectedIndex();
			indexYear = boxYear.getSelectedIndex();    
		
			String newFirstName ="";
			String newLastName = "";
			String newPeriod = "";
			int newIndex = 0 ;
			
			newFirstName = firstn.getText();
			newLastName = lastn.getText();
			newPeriod = period.getText();
			newIndex = Integer.parseInt(this.indexP.getText());
			
			date = ((year[indexDay])*10000)+(indexMonth+1)*100+(indexYear+1); 
			
			System.out.println("Update Cycle Information Table pressed");
			dbObj.periodUpdate(newIndex, newFirstName, newLastName, newPeriod, date,
			flow.getSelectedItem().toString(), pain.getSelectedIndex(), 
			mood.getSelectedItem().toString());

			System.out.println("Confirmed");
		}
	
		else if(buttonCommand.equals("Delete"))
		{
			System.out.println("Delete Cycle Information Table pressed");
			int newIndex = 0;
			newIndex = Integer.parseInt(this.indexP.getText());
			dbObj.dayDelete(newIndex);
			
		}
		else if(buttonCommand.equals("Display Day Table"))
		{
			this.pTable();
		}
		else if(buttonCommand.equals("Back"))
		{
			System.out.println("Exit pressed");
			this.framePeriod();
		}
		else
			System.out.println("Unexpected Error");	
	}
}