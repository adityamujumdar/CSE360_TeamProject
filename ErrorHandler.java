package teamProject;

import java.util.ArrayList;

public class ErrorHandler
{
	ArrayList<Integer> numError;
	ArrayList<Integer> lineError;
	StringBuilder errorString = new StringBuilder();
	
	public ErrorHandler(ArrayList<Integer> errorTracker, ArrayList<Integer> errorLines)
	{
		numError = errorTracker;
		lineError = errorLines;
	}
	
	public StringBuilder processErrors()
	{
		if(!numError.isEmpty())
		{
			for(int i = 0; i < numError.size(); i++)
			{
				if(numError.get(i) == 1)
				{
					errorString.append("ERROR 1 ON LINE " + lineError.get(i) + ": There can not be more than one flag on the same line.");
					errorString.append("\n");
				}
				else if(numError.get(i) == 2)
				{
					errorString.append("ERROR 2 ON LINE " + lineError.get(i) + ": The flag produced on line " + lineError.get(i) + " does not exist.");
					errorString.append("\n");
				}
				else if(numError.get(i) == 3)
				{
					errorString.append("ERROR 3 ON LINE " + lineError.get(i) + ": Indentation is not allowed for a column formatted text file.");
					errorString.append("\n");
				}
			}
		}
		else
		{
			errorString.append("");
		}
		
		return errorString;
	}
}