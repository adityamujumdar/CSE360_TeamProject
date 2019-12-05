package test;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class ErrorHandler 
{
	StringBuilder errorString = new StringBuilder();
	ArrayList<Integer> numError = getErrors();
	ArrayList<Integer> lineError = getErrorLines();
	
	if(!numError.isEmpty)
	{
		for(int i = 0; i < numError.size(); i++)
		{
			if(numError[i] == 1)
			{
				errorString.append("ERROR 1 ON LINE " + lineError[i] + ": There can not be more than one flag on the same line.");
				errorString.append("\n");
			}
			else if(numError[i] == 2)
			{
				errorString.append("ERROR 2 ON LINE " + lineError[i] + ": The flag produced on line " + lineError[i] + " does not exist.");
				errorString.append("\n");
			}
			else if(numError[i] == 3)
			{
				errorString.append("ERROR 3: Indentation is not allowed for a column formatted text file.");
				errorString.append("\n");
			}
		}
	}
	else
	{
		errorString.append("");
	}
}

