import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;

public class EditInfo
extends JFrame implements ActionListener, ItemListener
{
	private Analysis comp = new Analysis();
	
	private MainMethod dbObj = new MainMethod();
	//private AccessPage main1 = new AccessPage();
	
	private Box box = Box.createVerticalBox();
	private Calendar calP = new GregorianCalendar();
	private Calendar cal = Calendar.getInstance();
	
	private final int INFO_TABLE = 1;
	
	private JFrame infoFrame = new JFrame("Patient Information");
	
	private String[] month = {"January","February","March","April","May","June","July","August","October","September","November","December"};
	
	private Integer[] day = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,17, 18, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
	
	private Integer[] year = new Integer[100];
	
	private JComboBox<Integer> boxYear = new JComboBox<>(year);
	private JComboBox<Integer> boxDay = new JComboBox<>(day);
	private JComboBox<String> boxMonth = new JComboBox<>(month);
	
	private JTextField firstn = new JTextField(20);
	private JTextField lastn = new JTextField(20);
	private JTextField height = new JTextField(10);
	private JTextField weight = new JTextField(10);
	private JTextField index = new JTextField(10);
	
	private JLabel firstnLabel = new JLabel("First Name");
	private JLabel lastnLabel = new JLabel("Last Name");
	private JLabel heightLabelMetric = new JLabel("Height in cm");
	private JLabel heightLabelImperial = new JLabel("Height in inches");
	private JLabel weightLabelMetric = new JLabel("Weight in kg");
	private JLabel weightLabelImperial = new JLabel("Weight in lbs");
	private JLabel systemLabel = new JLabel("Type of System");
	private JLabel allergiesLabel = new JLabel("Allergies");
	private JLabel contraceptiveLabel = new JLabel("Type of Contraceptive");
	private JLabel birthLabel = new JLabel("Date of Birth");
	private JLabel indexLabel = new JLabel("Patient No");
	
	private JRadioButton metric = new JRadioButton("Metric");
	private JRadioButton imperial = new JRadioButton("Imperial");
	private JRadioButton tylenol = new JRadioButton("Tylenol");
	private JRadioButton aspirin = new JRadioButton("Aspirin");
	private JRadioButton motrin = new JRadioButton("Motrin");
	private JRadioButton none1 = new JRadioButton("None");
	private JRadioButton ibuprofen = new JRadioButton("Ibuprofen");
	private JRadioButton iud = new JRadioButton("IUD");
	private JRadioButton diaphragm = new JRadioButton("Diaphragm");
	private JRadioButton ring = new JRadioButton("Vaginal Ring");
	private JRadioButton sponge = new JRadioButton("Sponge");
	private JRadioButton implant = new JRadioButton("Contraceptive Implant");
	private JRadioButton none2 = new JRadioButton("None");
	
	private ButtonGroup group1 = new ButtonGroup();
	private ButtonGroup group2 = new ButtonGroup();
	private ButtonGroup group3 = new ButtonGroup();
	
	private JButton back = new JButton("Back to Main Page");
	private JButton infoTable = new JButton("Display Table");
	private JButton insertInfo = new JButton("Insert");
	private JButton updateInfo = new JButton("Update");
	private JButton deleteInfo = new JButton("Delete");
	private JButton exit = new JButton("Back");
	
	private String numericSystem;
	
	private int years = cal.get(Calendar.YEAR);
	private int months = cal.get(Calendar.MONTH);
	private int days = cal.get(Calendar.DAY_OF_MONTH);
	
	private JPanel infoIPanel = new JPanel(new FlowLayout());
	private JPanel buttonIPanel = new JPanel(new FlowLayout());
	private JPanel buttonPanel = new JPanel(new FlowLayout());
	
	private JPanel firstnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel lastnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel weightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel heightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel systemPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel allergiesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel contraceptivePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel birthPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel indexPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	
	private int age;
	private double heights;
	private double weights;
	
	private JScrollPane infoScroll = new JScrollPane();
	String[] columnTitles1 = new String[10];
	Object[][] data1 = dbObj.readDB(INFO_TABLE);
	
	
	public EditInfo()
	{
		this.arrayYear();
		metric.setSelected(true);
		aspirin.setSelected(true);
		iud.setSelected(true);
	}
	public void frameInfo()
	{
		columnTitles1[0] = "Index";
		columnTitles1[1] = "First Name";
		columnTitles1[2] = "Last Name";
		columnTitles1[3] = "Age";
		columnTitles1[4] = "Height";
		columnTitles1[5] = "Weight";
		columnTitles1[6] = "Allergies";
		columnTitles1[7] = "Contraceptive";
		columnTitles1[8] = "System";
		
		systemPanel.add(systemLabel);
		systemPanel.add(metric);
		systemPanel.add(imperial);
		
		firstnPanel.add(firstnLabel);
		firstnPanel.add(firstn);
		
		lastnPanel.add(lastnLabel);	
		lastnPanel.add(lastn);
		
		heightPanel.add(heightLabelMetric);
		heightPanel.add(height);
		
		weightPanel.add(weightLabelMetric);
		weightPanel.add(weight);
		
		birthPanel.add(birthLabel);
		birthPanel.add(boxDay);
		birthPanel.add(boxMonth);
		birthPanel.add(boxYear);
		
		
		contraceptivePanel.add(contraceptiveLabel);
		contraceptivePanel.add(diaphragm);
		contraceptivePanel.add(ring);
		contraceptivePanel.add(sponge);
		contraceptivePanel.add(implant);
		contraceptivePanel.add(none2);
		contraceptivePanel.add(iud);
		
		allergiesPanel.add(allergiesLabel);
		allergiesPanel.add(aspirin);
		allergiesPanel.add(tylenol);
		allergiesPanel.add(motrin);
		allergiesPanel.add(ibuprofen);
		allergiesPanel.add(none1);
		
		indexPanel.add(indexLabel);
		indexPanel.add(index);
		
		box.add(systemPanel);
		box.add(firstnPanel);
		box.add(lastnPanel);
		box.add(heightPanel);
		box.add(weightPanel);
		box.add(birthPanel);
		box.add(contraceptivePanel);
		box.add(allergiesPanel);
		box.add(indexPanel);
		
		buttonIPanel.add(infoTable);	
		buttonIPanel.add(insertInfo);
		buttonIPanel.add(updateInfo);
		buttonIPanel.add(deleteInfo);
		buttonIPanel.add(back);
		
		metric.addActionListener(this);
		imperial.addActionListener(this);
		tylenol.addActionListener(this);
		aspirin.addActionListener(this);		
		insertInfo.addActionListener(this);
		updateInfo.addActionListener(this);
		deleteInfo.addActionListener(this);
		tylenol.addActionListener(this);
		aspirin.addActionListener(this);
		motrin.addActionListener(this); 
		none1.addActionListener(this);
		ibuprofen.addActionListener(this);
		iud.addActionListener(this);
		diaphragm.addActionListener(this);
		ring.addActionListener(this);
		sponge.addActionListener(this);
		implant.addActionListener(this);
		none2.addActionListener(this);
		exit.addActionListener(this);
		back.addActionListener(this);
		infoTable.addActionListener(this);
		
		buttonPanel.add(exit);
		group2.add(imperial);
		group2.add(metric);
		
		group3.add(tylenol);
		group3.add(aspirin);
		group3.add(motrin);
		group3.add(ibuprofen);
		group3.add(none1);
		
		group1.add(iud);
		group1.add(diaphragm);
		group1.add(ring);
		group1.add(sponge);
		group1.add(implant);
		group1.add(none2);
		
		//frame information setup
		infoFrame.setBounds(500, 500, 1500, 2000);  
		infoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	
		infoFrame.setLayout(new BorderLayout());
		
		infoFrame.add(buttonIPanel,BorderLayout.SOUTH);
		infoFrame.add(box, BorderLayout.NORTH);
		
		infoFrame.setVisible(true);
		
	}

	public void iTable()
	{
		data1 = dbObj.readDB(INFO_TABLE);
		
		JTable infoTable = new JTable(data1, columnTitles1);
		
		JTableHeader header = infoTable.getTableHeader();
		header.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		infoFrame.add(infoScroll, BorderLayout.CENTER);
		infoTable.setGridColor(Color.BLACK);
		infoScroll.getViewport().add(infoTable);
		infoTable.setFillsViewportHeight(true);
		infoFrame.add(buttonPanel,BorderLayout.SOUTH);
		
		infoFrame.validate();
		infoFrame.repaint();
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
		if(monthIndex == 1 && leap == true)
		{
			boxDay.removeAllItems();
			
			for(int i = 1; i < 30; i++)
			{
				boxDay.addItem(i);
			}
			
		}
		if(monthIndex == 1 && leap == false)
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
		StringBuilder system = new StringBuilder("");
		StringBuilder allergies = new StringBuilder("");
		StringBuilder contraceptive = new StringBuilder("");
		
		int indexD = 0;
		int indexM = 0;
		int indexY = 0;
		int n1 = 0;
		int n2 = 0;
		
		if(imperial.isSelected())
		{
			heightPanel.removeAll();
			weightPanel.removeAll();
			
			heightPanel.add(heightLabelImperial);
			heightPanel.add(height);
			weightPanel.add(weightLabelImperial);
			weightPanel.add(weight);
			
			infoFrame.validate();
			infoFrame.repaint();				
		}
		
		//when imperial button is selected the panels change to fit metric system
		if(metric.isSelected())
		{
			heightPanel.removeAll();
			weightPanel.removeAll();
			
			heightPanel.add(heightLabelMetric);
			heightPanel.add(height);
			weightPanel.add(weightLabelMetric);
			weightPanel.add(weight);
			
			infoFrame.validate();
			infoFrame.repaint();	
		}
		/*if(buttonCommand.equals("Back to Main Page"))
		{
			
			main1.setWindow();
			infoFrame.dispose();
		}*/
		if(buttonCommand.equals("Insert"))
		{ 
			String newSystem = system.toString();
			String newAllergies = allergies.toString();
			String newContraceptive = contraceptive.toString();
			
			//selecting the given date
			indexD = boxDay.getSelectedIndex();
			indexM = boxMonth.getSelectedIndex();
			indexY = boxYear.getSelectedIndex();     
			
			//calculating the age of the user
			n1 = ((indexY+1)*10000)+(indexM+1)*100+(indexD+1);
			n2 = ((years*10000)+(months+1)*100+(days+1));
			
			age = ((n2 - n1)/10000);
			System.out.println("Insert into Info Information Table pressed");
			
			
			int newIndex = 0;
			newIndex = Integer.parseInt(index.getText());
			String newFirstName = firstn.getText();
			String newLastName = lastn.getText();
			//confirm.setWindow();
			dbObj.basicInsert(newIndex, newFirstName, newLastName, age, heights, weights, newAllergies, newContraceptive, newSystem);
			
			if(metric.isSelected())
			{
				heights = Double.parseDouble(height.getText());			
				weights = Double.parseDouble(weight.getText());	
			}
			
			else if(imperial.isSelected())
			{
				double hMetric = Double.parseDouble(height.getText());			
				double wMetric = Double.parseDouble(weight.getText());	
				
				heights = comp.imperialHeight(hMetric);
				weights = comp.imperialWeight(wMetric);
			}
			if(metric.isSelected())
			{
				system.setLength(0);
				system.append("Metric");
			}
			else if(imperial.isSelected())
			{
				system.setLength(0);
				system.append("Imperial");
			}
			
			//Allergies
			if(tylenol.isSelected())
			{
				allergies.setLength(0);
				allergies.append("Tylenol");
			}
			
			else if(aspirin.isSelected())
			{
				allergies.setLength(0);
				allergies.append("Aspirin");
			}
			
			else if(motrin.isSelected())
			{
				allergies.setLength(0);
				allergies.append("Motrin");
			}
			
			else if(ibuprofen.isSelected())
			{
				allergies.setLength(0);
				allergies.append("Ibuprofen");
			}
			
			else if(none1.isSelected())
			{
				allergies.setLength(0);
				allergies.append("None");
			}
			
			//Contraceptive
			if(iud.isSelected())
			{
				contraceptive.setLength(0);
				contraceptive.append("IUD");
			}
			
			else if(diaphragm.isSelected())
			{
				contraceptive.setLength(0);
				contraceptive.append("Diaphragm");
			}
			else if(ring.isSelected())
			{
				contraceptive.setLength(0);
				contraceptive.append("Ring");
			}
			else if(sponge.isSelected())
			{
				contraceptive.setLength(0);
				contraceptive.append("Sponge");
			}
			else if(implant.isSelected())
			{
				contraceptive.setLength(0);
				contraceptive.append("Implant");
			}
			else if(none2.isSelected())
			{
				contraceptive.setLength(0);
				contraceptive.append("None");
			}
			
		}
		
		
		
		else if(buttonCommand.equals("Update"))
		{ 
			String newSystem = system.toString();
			String newAllergies = allergies.toString();
			String newContraceptive = contraceptive.toString();
			
			//selecting the given date
			indexD = boxDay.getSelectedIndex();
			indexM = boxMonth.getSelectedIndex();
			indexY = boxYear.getSelectedIndex();     
			
			//calculating the age of the user
			n1 = ((indexY+1)*10000)+(indexM+1)*100+(indexD+1);
			n2 = ((years*10000)+(months+1)*100+(days+1));
			
			age = ((n2 - n1)/10000);
			System.out.println("Insert into Info Information Table pressed");
			
			
			int newIndex = 0;
			newIndex = Integer.parseInt(index.getText());
			String newFirstName = firstn.getText();
			String newLastName = lastn.getText();
			//confirm.setWindow();
			dbObj.basicUpdate(newIndex, newFirstName, newLastName, age, heights, weights, newAllergies, newContraceptive, newSystem);
			
			if(metric.isSelected())
			{
				heights = Double.parseDouble(height.getText());			
				weights = Double.parseDouble(weight.getText());	
			}
			
			else if(imperial.isSelected())
			{
				double hMetric = Double.parseDouble(height.getText());			
				double wMetric = Double.parseDouble(weight.getText());	
				
				heights = comp.imperialHeight(hMetric);
				weights = comp.imperialWeight(wMetric);
			}
			if(metric.isSelected())
			{
				system.setLength(0);
				system.append("Metric");
			}
			else if(imperial.isSelected())
			{
				system.setLength(0);
				system.append("Imperial");
			}
			
			//Allergies
			if(tylenol.isSelected())
			{
				allergies.setLength(0);
				allergies.append("Tylenol");
			}
			
			else if(aspirin.isSelected())
			{
				allergies.setLength(0);
				allergies.append("Aspirin");
			}
			
			else if(motrin.isSelected())
			{
				allergies.setLength(0);
				allergies.append("Motrin");
			}
			
			else if(ibuprofen.isSelected())
			{
				allergies.setLength(0);
				allergies.append("Ibuprofen");
			}
			
			else if(none1.isSelected())
			{
				allergies.setLength(0);
				allergies.append("None");
			}
			
			//Contraceptive
			if(iud.isSelected())
			{
				contraceptive.setLength(0);
				contraceptive.append("IUD");
			}
			
			else if(diaphragm.isSelected())
			{
				contraceptive.setLength(0);
				contraceptive.append("Diaphragm");
			}
			else if(ring.isSelected())
			{
				contraceptive.setLength(0);
				contraceptive.append("Ring");
			}
			else if(sponge.isSelected())
			{
				contraceptive.setLength(0);
				contraceptive.append("Sponge");
			}
			else if(implant.isSelected())
			{
				contraceptive.setLength(0);
				contraceptive.append("Implant");
			}
			else if(none2.isSelected())
			{
				contraceptive.setLength(0);
				contraceptive.append("None");
			}
			//this.clearInfo();
		}
		
		else if(buttonCommand.equals("Delete"))
		{
			System.out.println("Delete Info Information Table pressed");
			int newIndex = 0;
			newIndex = Integer.parseInt(index.getText());
			dbObj.basicDelete(newIndex);
			//confirm.setWindow();
		}
		else if(buttonCommand.equals("Display Info Table"))
		{
			this.iTable();
		}
		else if(buttonCommand.equals("Back"))
		{
			System.out.println("Exit pressed");
			this.frameInfo();
		}
		else
			System.out.println("Unexpected Error");	
	}
	
}
