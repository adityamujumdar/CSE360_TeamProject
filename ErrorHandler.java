package teamProject;

import java.util.ArrayList;

public class ErrorHandler
{
	ArrayList<Integer> numError;
	ArrayList<Integer> lineError;
	StringBuilder errorString = new StringBuilder();	//String to be accessed in the main class.
	
	public ErrorHandler(ArrayList<Integer> errorTracker, ArrayList<Integer> errorLines)		//Arrays used to determine error type and line.
	{
		numError = errorTracker;
		lineError = errorLines;
	}
	
	public StringBuilder processErrors()
	{
		if(!numError.isEmpty())		//If there are existing errors ...
		{
			for(int i = 0; i < numError.size(); i++)		//For the amount of errors present
			{
				if(numError.get(i) == 1)	//If there are two or more flags on the same line.
				{
					errorString.append("ERROR 1 ON LINE " + lineError.get(i) + ": There can not be more than one flag on the same line.");
					errorString.append("\n");
				}
				else if(numError.get(i) == 2)				//If there is a flag that does not exist.
				{
					errorString.append("ERROR 2 ON LINE " + lineError.get(i) + ": The flag produced on line " + lineError.get(i) + " does not exist.");
					errorString.append("\n");
				}
				else if(numError.get(i) == 3)				//If someone tries to indent when the text file is column formatted.
				{
					errorString.append("ERROR 3 ON LINE " + lineError.get(i) + ": Indentation is not allowed for a column formatted text file.");
					errorString.append("\n");
				}
			}
		}
		else												//Else set string to "".
		{
			errorString.append("");
		}
		
		return errorString;
	}
}