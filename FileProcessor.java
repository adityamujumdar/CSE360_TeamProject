package teamProject;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class FileProcessor
{
	public File handleFile(File input) throws FileNotFoundException
	{
		//Change file paths to wherever your output file should go.
		File outF = new File("C:\\Users\\pbcin\\Documents\\Output.txt");
		
		Scanner in = new Scanner(input);
		PrintStream ps = new PrintStream(outF);
		int currentLineNum = 1;
		TextProcessor tp = new TextProcessor();
		
		ArrayList<String> errorTracker = new ArrayList<String>();
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
						case 'l': tp.setJustification(0); break;
						case 'r': tp.setJustification(1); break;
						case 't': tp.setJustification(2); break;
						case 'c': tp.setJustification(3); break;
						
						case 's': tp.setSpacing(0); break;
						case 'd': tp.setSpacing(1); break;
						
						case 'n': tp.setIndentation(0); break;
						case 'i': tp.setIndentation(1); break;
						case 'b': tp.setIndentation(2); break;
						
						case '1': tp.setColumns(0); break;
						case '2': tp.setColumns(1); break;
							
						case 'e': /*call blank line method*/; break;
						
							/*call error log with bad flag error*/
						default: 
							/*currentLineNum describes where we are inside the given text file.*/
							errorTracker.add("Error! Incorred Flag entered at line" + currentLineNum + "."); break;
					}
					currentLineNum += 1;
					//Reset the two trackers of the text in between the flags.
					charCountBetweenFlags = 0;
					textBetweenFlags = "";
				}
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
}