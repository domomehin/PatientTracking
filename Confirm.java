import java.util.*;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

public class Confirm
extends JFrame implements ActionListener

{
	//declaring variables
	private JFrame confirmFrame;
	
	private JLabel confirm;
	
	private JButton ok;
	
	private JPanel confirmPanel;
	private JPanel returnToFrame;
	
	public Confirm()
	{
		//constructor
		confirmFrame = new JFrame();
		
		confirm = new JLabel("Confirmed");
		
		ok = new JButton("OK");
		
		confirmPanel = new JPanel(new FlowLayout());
		returnToFrame = new JPanel(new FlowLayout());
		
	}
	
	public void initSetWindow()
	{
		//adding actionListener
		ok.addActionListener(this);
		
		//setting up frame settings
		confirmFrame.setBounds(1000, 800, 200, 100); 
		confirmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		confirmFrame.setLayout(new BorderLayout());	
		
		//calling set window method
		setWindow();
		
	}
	public void setWindow()
	{
		//adding items to panels
		confirmPanel.add(confirm);
		returnToFrame.add(ok);
		
		//adding panels to frame
		confirmFrame.add(confirmPanel,BorderLayout.CENTER);
		confirmFrame.add(returnToFrame,BorderLayout.SOUTH);
		
		//setting frame visible
		confirmFrame.setVisible(true);	
	}
	
	//action listener
	public void actionPerformed(ActionEvent e)
	{			
		Object buttonCommand = e.getSource(); 
		
		//setting up command for button.
		if(buttonCommand == ok)
		{
			confirmFrame.dispose();
		}
	}
}