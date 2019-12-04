package teamProject;

import java.io.PrintStream;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;

public class FileProcessor
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//Change file paths to wherever your input/output files are.
		File inF = new File("C:\\Users\\pbcin\\eclipse-workspace\\Input.txt");
		File outF = new java.io.File("C:\\Users\\pbcin\\eclipse-workspace\\Output.txt");
		
		Scanner in = new Scanner(inF);
		PrintStream ps = new PrintStream(outF);
		
		//While the input file has a next line, retrieve that line,
		//print it, and write it to the new file.
		
		int charCountBetweenFlags = 0;
		String textBetweenFlags = "";
		
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
					
					flag = newLine.charAt(1);

					switch(flag)
					{
						case 'r': /*call r justif. method*/; break;
						case 'c': /*call c justif. method*/; break;
						case 'l': /*call l justif. method*/; break;
						case 't': /*call t justif. method*/; break;
						
						case 'd': /*call double space method*/; break;
						case 's': /*call double space method*/; break;
						
						case 'i': /*call normal indent method*/; break;
						case 'b': /*call block indent method*/; break;
						case 'n': /*call no indent method*/; break;
							
						case '2': /*call two columns method*/; break;
						case '1': /*call one columns method*/; break;
							
						case 'e': /*call blank line method*/; break;
						
						default: /*call error log with bad flag error*/; break;
					}
					
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
		
		//Close files
		in.close();
		ps.close();
	}
}
