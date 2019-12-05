package teamProject;

import java.awt.EventQueue;
import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ReadFile 
{
	private JFileChooser chooser = new JFileChooser();
	StringBuilder builder = new StringBuilder();
	private File file;
	
	public void select() throws Exception
	{
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			file = chooser.getSelectedFile();
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
	
	public File getCurrentSourceFile()
	{
		return file;
	}
}