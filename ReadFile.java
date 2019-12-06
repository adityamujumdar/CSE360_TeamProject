package teamProject;

import java.awt.EventQueue;
import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ReadFile 
{
	private JFileChooser chooser = new JFileChooser();		//File chooser to open file explorer.
	StringBuilder builder = new StringBuilder();			//String accessed in main file.
	private File file;
	
	public void select() throws Exception
	{
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			file = chooser.getSelectedFile();				//Set the file to the user selected file from file explorer.
			Scanner input = new Scanner(file);
			
			while(input.hasNext())							//While there are lines to read, read the next line and add a line break in the string.
			{
				builder.append(input.nextLine());
				builder.append("\n");
			}
			input.close();
		}
		else
		{
			builder.append("No file was selected");			//If no file was selected.
		}
	}
	
	public File getCurrentSourceFile()						//Returns the file.
	{
		return file;
	}
}