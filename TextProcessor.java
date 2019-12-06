package teamProject;

import java.util.ArrayList;

public class TextProcessor
{
	private int justification;
	private int spacing;
	private int indentation;
	private int columns;
	
	//default conditions
	public TextProcessor()
	{
		justification = 0; 	//Left justified
		spacing = 0;		//Single space
		indentation = 0;	//No indent
		columns = 0;		//1 column
	}
	
	public void setJustification(int justification)
	{
		this.justification = justification;
	}
	
	public void setSpacing(int spacing)
	{
		this.spacing = spacing;
	}
	
	public void setIndentation(int indentation)
	{
		this.indentation = indentation;
	}
	
	public void setColumns(int columns)
	{
		this.columns = columns;
	}
	
	public int getIndentation()
	{
		return indentation;
	}
	
	public int getColumns()
	{
		return columns;
	}
	
	public String handleText(String inputText)
	{
		System.out.println(inputText);
		String outputText = "";
		
		//ONE COLUMN
		if (columns == 0)
		{
			outputText = oneColumn(inputText);
		}
		//TWO COLUMNS
		else
		{
			outputText = twoColumns(inputText);
		}
		System.out.println(outputText);
		return outputText;
	}
	
	public String justifyLine(String input, int maxCharacters)
	{
		String justifiedString = "ERROR IN JUSTIFYING";
		String buffer = "";
		
		for (int i = input.length(); i < maxCharacters; i++)
		{
			buffer += " ";
		}
		int l = buffer.length();
		
		//LEFT
		if (justification == 0)
		{
			justifiedString = input + buffer;
		}
		//RIGHT
		else if (justification == 1)
		{
			justifiedString = buffer + input;
		}
		//TITLE
		else if (justification == 2)
		{
			justifiedString = buffer.substring(0, l/2) + input + buffer.substring(l/2);
		}
		else
		{
			justifiedString = "CENTER JUSTIFICATION";
		}
		
		return justifiedString;
	}
	
	public String oneColumn(String inputText)
	{
		String outputText = "";
		String[] splitInput;
		splitInput = inputText.split(" ");
		ArrayList<String> lines = new ArrayList<String>();
		
		int charCounter = 0;
		String temp = "";
		
		//SINGLE SPACE
		if(spacing == 0)
		{
			//NO INDENT
			if (indentation == 0)
			{
				for (String word : splitInput) 
				{
					if(charCounter < 80 - word.length())
					{
						temp = temp + word + " ";
						charCounter = charCounter + word.length() + 1;
					}
					
					else
					{
						lines.add(temp);
						charCounter = word.length();
						temp = word + " ";
					}
				}
				
				lines.add(temp);
				
				for (String line : lines)
				{
					String tempLine = line.substring(0, line.length() - 1);
					outputText += justifyLine(tempLine, 80) + "\n";
				}
			}
			//NORMAL INDENT
			else if (indentation == 1)
			{
				String firstLine = "     ";
				charCounter = 0;
				int wordCounter = 0;
				
				for (String word : splitInput) 
				{
					if (charCounter < 75 - word.length())
					{
						temp = temp + word + " ";
						charCounter = charCounter + word.length() + 1;
						wordCounter++;
					}
					
					else
					{
						firstLine += temp;
						charCounter = word.length();
						temp = word + " ";
						break;
					}
				}
				
				for (int i = wordCounter + 1; i < splitInput.length; i++)
				{
					String wordy = splitInput[i];
					if(charCounter < 80 - wordy.length())
					{
						temp = temp + wordy + " ";
						charCounter = charCounter + wordy.length() + 1;
					}
					
					else
					{
						lines.add(temp);
						charCounter = wordy.length();
						temp = wordy + " ";
					}
				}
				
				lines.add(temp);
				
				String tempLine1 = firstLine.substring(0, firstLine.length() - 1);
				outputText = justifyLine(tempLine1, 75) + "\n";
				
				for (String line : lines)
				{
					String tempLine = line.substring(0, line.length() - 1);
					outputText += justifyLine(tempLine, 80) + "\n";
				}
			}
			//BLOCK INDENT
			else
			{
				for (String word : splitInput) 
				{
					if(charCounter < 70 - word.length())
					{
						temp = temp + word + " ";
						charCounter = charCounter + word.length() + 1;
					}
					
					else
					{
						lines.add("          " + temp);
						charCounter = word.length();
						temp = word + " ";
					}
				}
				
				lines.add("          " + temp);
				
				for (String line : lines)
				{
					String tempLine = line.substring(0, line.length() - 1);
					outputText += justifyLine(tempLine, 70) + "\n";
				}
			}
		}
		//DOUBLE SPACE
		else
		{
			//NO INDENT
			if (indentation == 0)
			{
				for (String word : splitInput) 
				{
					if(charCounter < 80 - word.length())
					{
						temp = temp + word + " ";
						charCounter = charCounter + word.length() + 1;
					}
					
					else
					{
						lines.add(temp);
						lines.add("");
						charCounter = word.length();
						temp = word + " ";
					}
				}
				
				lines.add(temp);
				
				for (String line : lines)
				{
					String tempLine = "";
					if (line.compareTo("") != 0)
					{
						tempLine = line.substring(0, line.length() - 1);
					}
					
					outputText += justifyLine(tempLine, 80) + "\n";
				}
			}
			//NORMAL INDENT
			else if (indentation == 1)
			{
				String firstLine = "     ";
				charCounter = 0;
				int wordCounter = 0;
				
				for (String word : splitInput) 
				{
					if (charCounter < 75 - word.length())
					{
						temp = temp + word + " ";
						charCounter = charCounter + word.length() + 1;
						wordCounter++;
					}
					
					else
					{
						firstLine += temp;
						charCounter = word.length();
						temp = word + " ";
						break;
					}
				}
				
				for (int i = wordCounter + 1; i < splitInput.length; i++)
				{
					String wordy = splitInput[i];
					if(charCounter < 80 - wordy.length())
					{
						temp = temp + wordy + " ";
						charCounter = charCounter + wordy.length() + 1;
					}
					
					else
					{
						lines.add(temp);
						lines.add("");
						charCounter = wordy.length();
						temp = wordy + " ";
					}
				}
				
				lines.add(temp);
				
				String tempLine1 = firstLine.substring(0, firstLine.length() - 1);
				outputText = justifyLine(tempLine1, 75) + "\n\n";
				
				for (String line : lines)
				{
					String tempLine = "";
					if (line.compareTo("") != 0)
					{
						tempLine = line.substring(0, line.length() - 1);
					}
					outputText += justifyLine(tempLine, 80) + "\n";
				}
			}
			//BLOCK INDENT
			else
			{
				for (String word : splitInput) 
				{
					if(charCounter < 70 - word.length())
					{
						temp = temp + word + " ";
						charCounter = charCounter + word.length() + 1;
					}
					
					else
					{
						lines.add("          " + temp);
						lines.add("");
						charCounter = word.length();
						temp = word + " ";
					}
				}
				
				lines.add("          " + temp);
				
				for (String line : lines)
				{
					String tempLine = "";
					if (line.compareTo("") != 0)
					{
						tempLine = line.substring(0, line.length() - 1);
					}
					outputText += justifyLine(tempLine, 70) + "\n";
				}
			}
		}
		return outputText;
	}
	
   public String justifyString(String text, int lineLength){      //This method takes a string and a line length(i.e. 80) and justifies it
      
	  if (text.length() != lineLength){ //recursive call
	      for(int i = 0; i < text.length(); i++)
	      {
	         if(text.charAt(i) == ' ' && text.length() < lineLength)
	         {
	            text = text.substring(0, i) + ' ' + text.substring(i); // adding extra spaces
	            i++;
	         }
	         
	      }
	  }
	  
      if (text.length() != lineLength){ //recursive call
         for(int i = 0; i< text.length(); i++){
         if(text.charAt(i) == ' ' && text.length() < lineLength){
            text = text.substring(0, i) + ' ' + text.substring(i); // adding extra spaces
            i++;
         }
         
      }      
      }
	   
	  if (text.length() != lineLength){ //recursive call
         for(int i = 0; i< text.length(); i++){
         if(text.charAt(i) == ' ' && text.length() < lineLength){
            text = text.substring(0, i) + ' ' + text.substring(i); // adding extra spaces
            i++;
         }
         
      }      
      }
	   
	      if (text.length() != lineLength){ //recursive call
         for(int i = 0; i< text.length(); i++){
         if(text.charAt(i) == ' ' && text.length() < lineLength){
            text = text.substring(0, i) + ' ' + text.substring(i); // adding extra spaces
            i++;
         }
         
      }      
      }
	         if (text.length() != lineLength){ //recursive call
         for(int i = 0; i< text.length(); i++){
         if(text.charAt(i) == ' ' && text.length() < lineLength){
            text = text.substring(0, i) + ' ' + text.substring(i); // adding extra spaces
            i++;
         }
         
      }      
      }
	   
      return text;
      }
      
   public String twoColumns(String textBlock)
   {

  	int mid = textBlock.length() / 2; //get the middle of the String
   
   
  	while (textBlock.charAt(mid) != ' ')
  		mid--;
   
  	String column1 = textBlock.substring(0, mid);
  	String column2 = textBlock.substring(mid);
   
  	int count = 0;
  	int count2 = 0;
  	int charLimit = 35;
  	int charLimit2 = 35;
  	String columns = "";
   
  	for(int x = 1; x <= (column1.length() / 35)+1; x++){    //run through string 35 times
  		charLimit = 35*x;		//updating uperlimit
   
  		if (charLimit > column1.length()){		//running through the string
  			while (charLimit > column1.length())
  				charLimit--;
         }
	   else
	      while(column1.charAt(charLimit) != ' ')		//not cutting a word in half
	         charLimit--;
	         
	   String tmp = column1.substring(count,charLimit);	//new column line
	   if (tmp.charAt(0) == ' '){				//removing extra whitespace
	      tmp = tmp.substring(0, 0) + tmp.substring(1);
	   }
	   
	   charLimit2 = 35*x;
	   
	  if (charLimit2 > column2.length())		//running through the string
	      while (charLimit2 > column2.length())
	         charLimit2--;
	   else
	      while(column2.charAt(charLimit2) != ' ')		//not cutting a word in half
	         charLimit2--;
	         
	   String tmp1 = column2.substring(count2,charLimit2);	//new column line
	   if (tmp1.charAt(0) == ' '){				//removing extra whitespace
	      tmp1 = tmp1.substring(0, 0) + tmp1.substring(1);
	   }
	
	   if(justification == 0){columns = columns + justifyString(tmp,35) + "          " + justifyString(tmp1,35) +"\n";}      //right justify
	   else if (justification == 1){columns = columns + justifyString(tmp,35) + "          " + justifyString(tmp1,35) +"\n";}//center
	   else if (justification == 2){columns = columns + justifyString(tmp,35) + "          " + justifyString(tmp1,35) +"\n";}//left
	   else if (justification == 3){columns = columns + tmp + "          " + tmp1 + "\n";}                           //title
	
	   count = charLimit;   //editing the counters
	   count2 = charLimit2;
	   }   
	   
	   return columns;
      }  
}