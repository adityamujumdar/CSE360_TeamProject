package teamProject;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class FileProcessor
{	
	private ArrayList<Integer> errorTracker;
	private ArrayList<Integer> errorLines;
	
	public File handleFile(File input) throws FileNotFoundException
	{
		//Change file paths to wherever your output file should go.
		File outF = new File("C:\\Users\\pbcin\\Documents\\Output.txt");
		
		Scanner in = new Scanner(input);
		PrintStream ps = new PrintStream(outF);
		int currentLineNum = 1;
		TextProcessor tp = new TextProcessor();
		
		ErrorHandler errors = new ErrorHandler();
		errorTracker = new ArrayList<Integer>();
		errorLines = new ArrayList<Integer>();
		
		int charCountBetweenFlags = 0;
		String textBetweenFlags = "";
		
		//While the input file has a next line, retrieve that line,
		//print it, and write it to the new file.
		while(in.hasNextLine())
		{
			String newLine = in.nextLine();
			
			
			System.out.print(newLine);
			
			char flag = 0;
			
			//If the new line is a flag
			if (newLine.startsWith("-"))
			{
				if(newLine.length() == 2)
				{
					System.out.println("");
					
					System.out.println("\nText being pushed to the modifier methods: " + textBetweenFlags + "\n");
					tp.handleText(textBetweenFlags);
					
					flag = newLine.charAt(1);

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
								tp.setIndentation(1);
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
				
				//Advance the line counter
				currentLineNum++;
				//Reset the two trackers of the text in between the flags.
				charCountBetweenFlags = 0;
				textBetweenFlags = "";
			}
			
			//If the new line is text to be modified
			else
			{
				charCountBetweenFlags += newLine.length();
				textBetweenFlags = textBetweenFlags + newLine + " ";
				
				System.out.println(" " + charCountBetweenFlags);
			}
			
			ps.println(newLine);
			ps.flush();
		}
		
		System.out.println("\nText being pushed to the modifier methods: " + textBetweenFlags + "\n");
		
		//Close files
		in.close();
		ps.close();
		
		return outF;
	}
	
	public ArrayList<Integer> getErrors()
	{
		return errorTracker;
	}
	
	public ArrayList<Integer> getErrorLines()
	{
		return errorLines;
	}
	
	public String printErrors()
	{
		//String of all errors produced by ErrorLog class
		return null;
	}
}