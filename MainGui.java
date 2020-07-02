import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.table.*;

public class MainGui
extends JFrame implements ActionListener
{
	AccessPage acc = new AccessPage();
	private JFrame userFrame = new JFrame(" View Tracker");
	private JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	//button
	private JTextField loginText = new JTextField(25);
	private JButton loginButton = new JButton("Login");
	
	
	public void mainWindow()
	{	
		userFrame.setBounds(200,500,800,300);
		userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		userFrame.setLayout(new BorderLayout());
		
		//adding action listener
		loginButton.addActionListener(this);
		
		
		panel.add(loginText);
		panel.add(loginButton);
		
		userFrame.add(panel, BorderLayout.CENTER);
		
		userFrame.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		String textFieldValue = loginText.getText();
		String buttonCommand = e.getActionCommand();
		if(buttonCommand.equals("Login"))
		{
			if(textFieldValue.equals("Dr. Ebun Bangkok"))
			{
				acc.setWindow();
				System.out.println("Ebun");
				userFrame.dispose();
			}
			else if(textFieldValue.equals("Ebun"))
			{
				acc.setWindow();
				System.out.println("Ebun");
				userFrame.dispose();
			}
			else if(textFieldValue.equals("ebun"))
			{
				acc.setWindow();
				System.out.println("Ebun");
				userFrame.dispose();
			}
			else if(textFieldValue.equals("Bangkok"))
			{
				acc.setWindow();
				System.out.println("Ebun");
				userFrame.dispose();
			}
			else if(textFieldValue.equals("Dr Ebun Bangkok"))
			{
				acc.setWindow();
				System.out.println("Ebun");
				userFrame.dispose();
			}
			
			else
			{
				userFrame.dispose();
				System.out.println("Not ebun");
			}
			
		}
	}
}