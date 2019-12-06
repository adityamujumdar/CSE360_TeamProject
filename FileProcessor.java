package teamProject;


import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor
{	
	private ArrayList<Integer> errorTracker;
	private ArrayList<Integer> errorLines;
	private StringBuilder errorString;
	
	public File handleFile(File input) throws IOException
	{
		//Change file paths to wherever your output file should go.
		File outF = new File("Test.txt");
		
		Scanner in = new Scanner(input);
		FileWriter outWrite = new FileWriter(outF); 
		BufferedWriter out = new BufferedWriter(outWrite);
		
		int currentLineNum = 1;
		TextProcessor tp = new TextProcessor();
		
		errorTracker = new ArrayList<Integer>();
		errorLines = new ArrayList<Integer>();
		
		int charCountBetweenFlags = 0;
		String textBetweenFlags = "";
		
		//While the input file has a next line, retrieve that line,
		//print it, and write it to the new file.
		while(in.hasNextLine())
		{
			String newLine = in.nextLine();
			
			char flag = 0;
			
			//If the new line is a flag
			if (newLine.startsWith("-"))
			{
				if(newLine.length() == 2)
				{
					flag = newLine.charAt(1);
					
					if(!textBetweenFlags.equals(""))
					{
						out.write(tp.handleText(textBetweenFlags) + "\n");
					}
					
					switch(flag)
					{
						//Justification flags
						case 'l': tp.setJustification(0); break;
						case 'r': tp.setJustification(1); break;
						case 't': tp.setJustification(2); break;
						case 'c': tp.setJustification(3); break;
						
						//Spacing flags
						case 's': tp.setSpacing(0); break;
						case 'd': tp.setSpacing(1); break;
						
						//Indentation flags
						case 'n': tp.setIndentation(0); break;
						case 'i': 
							if(tp.getColumns() == 0)
							{
								tp.setIndentation(1);
							}
							else
							{
								//Add column/indentation incompatibility error (#3) to error tracking arrays
								errorTracker.add(3);
								errorLines.add(currentLineNum);
							}
							break;
						case 'b':
							if(tp.getColumns() == 0)
							{
								tp.setIndentation(2);
							}
							else
							{
								//Add column/indentation incompatibility error (#3) to error tracking arrays
								errorTracker.add(3);
								errorLines.add(currentLineNum);
							}
							break;
						
						//Column flags
						case '1': tp.setColumns(0); break;
						case '2': 
							if(tp.getIndentation() == 0)
							{
								tp.setColumns(1);
							}
							else
							{
								//Add column/indentation incompatibility error (#3) to error tracking arrays
								errorTracker.add(3);
								errorLines.add(currentLineNum);
							}
							 break;
						
						//Blank line
						case 'e': /*call blank line method*/; break;
						
						default:
							//Add invalid flag error (#2) to error tracking arrays
							errorTracker.add(2);
							errorLines.add(currentLineNum); break;
					}
					
					//Reset the two trackers of the text in between the flags.
					charCountBetweenFlags = 0;
					textBetweenFlags = "";
				}
				
				else
				{
					if ((newLine.substring(2)).contains("-"))
					{
						//Add multiple flags on same line error (#1) to error tracking arrays
						errorTracker.add(1);
						errorLines.add(currentLineNum);
					}
				}
			}
			
			//If the new line is text to be modified
			else
			{
				charCountBetweenFlags += newLine.length();
				textBetweenFlags = textBetweenFlags + newLine + " ";
				
				//Prints out how many characters are between the end of the current line and the previous flag
				//FOR DEBUGGING ONLY
				//System.out.println(" " + charCountBetweenFlags);
			}
			
			
			
			//Advance the line counter
			currentLineNum++;
		}
		
		//Handle error retrieval
		ErrorHandler errors = new ErrorHandler(errorTracker, errorLines);
		errorString = errors.processErrors();
		
		//Close files
		in.close();
		out.close();
		
		return outF;
	}
	
	public StringBuilder getErrorString()
	{
		return errorString;
	}
}