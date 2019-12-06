package teamProject;

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
	
	public String handleText(String inputLine)
	{
		return inputLine;
	}
   
   public String justifyString(String text, int lineLength){      //This method takes a string and a line length(i.e. 80) anf justifies it
      
      for(int i = 0; i< text.length(); i++){
         if(text.charAt(i) == ' ' && text.length() < lineLength){
            text = text.substring(0, i) + ' ' + text.substring(i); // adding extra spaces
            i++;
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
      
      public String twoColumns(String textBlock, int justification){

   int mid = textBlock.length() / 2; //get the middle of the String
   
   
   while (textBlock.charAt(mid) != ' ')
      mid--;
   
      
      
   String[] parts = {textBlock.substring(0, mid),textBlock.substring(mid)};
   
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
