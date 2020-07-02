import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

public class Installation
{
	public static void main(String[] args)
	{
		MainMethod call = new MainMethod();
		call.createDB();
		call.createInfoTable();
		call.createDayTable();
		call.createPeriodTable();
	}
	
}