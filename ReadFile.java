package teamProject;

import java.awt.EventQueue;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ReadFile 
{
	JFileChooser chooser = new JFileChooser();
	StringBuilder builder = new StringBuilder();
	
	public void select() throws Exception
	{
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			java.io.File file = chooser.getSelectedFile();
			Scanner input = new Scanner(file);
			
			while(input.hasNext())
			{
				builder.append(input.nextLine());
				builder.append("\n");
			}
			input.close();
		}
		else
		{
			builder.append("No file was selected");
		}
	}
}
