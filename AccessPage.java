import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.table.*;
import java.util.*;

public class AccessPage
extends JFrame implements ActionListener
{
	EditInfo einfo = new EditInfo();
	EditDay eday = new EditDay();
	EditPeriod eperiod = new EditPeriod();
	MainMethod info = new MainMethod();
	Analysis ana = new Analysis();

	private Font theFont = new Font("American Type Writer" ,Font.BOLD|Font.ITALIC,80);
	private JFrame userFrame = new JFrame("View Tracker");
	private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	private Color frameColor = new Color(85, 87, 47);
	private Color frameForeground = Color.decode("#A9A402");

	private JLabel ebunLabel = new JLabel(" Welcome Dr. Ebun");
	
	private JButton infoButton = new JButton("Patient Information");
	private JButton dayButton = new JButton("Daily Information");
	private JButton periodButton = new JButton("Period Information");
	
	private ImageIcon imageP = new ImageIcon( new ImageIcon("period.png").getImage().getScaledInstance(
			250,250,Image.SCALE_DEFAULT));
	JLabel imageLabel = new JLabel(imageP);
	

	public void setWindow()
	{
		userFrame.setBounds(200,500,1000,500);
		userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userFrame.getContentPane().setBackground(Color.RED);
		
		userFrame.setLayout(new BorderLayout());
		infoButton.addActionListener(this);
		dayButton.addActionListener(this);
		periodButton.addActionListener(this);
		
		ebunLabel.setForeground(frameForeground);
		ebunLabel.setFont(theFont);
		
		labelPanel.add(ebunLabel);
		
		imagePanel.add(imageLabel);

		panel.add(infoButton);
		panel.add(dayButton);
		panel.add(periodButton);
		userFrame.add(panel, BorderLayout.CENTER);
		userFrame.add(labelPanel, BorderLayout.NORTH);
		userFrame.add(imagePanel, BorderLayout.SOUTH);
	
		userFrame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		String buttonCommand = e.getActionCommand();
		if(buttonCommand.equals("Patient Information"))
			{
			System.out.println("info pressed");
			einfo.frameInfo();
			userFrame.dispose();
		}
		
		else if(buttonCommand.equals("Daily Information"))
		{
			System.out.println("pressed");
			eday.frameDay();
			userFrame.dispose();
		}
		else if(buttonCommand.equals("Period Information"))
		{
			System.out.println("pressed");
			eperiod.framePeriod();
			userFrame.dispose();
		}
	}
}