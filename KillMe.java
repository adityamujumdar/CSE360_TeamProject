public class KillMe{
   public static void main(String [] args){
   KillMe bleh = new KillMe();
   bleh.justifyString("Please find the individual words");
   
   //methodology

   }
   
   public void justifyString(String text){
   
   String[] array = text.split(" ");
   
   
  
   System.out.println("1. How long is the line? 35");
   System.out.println("2. How long is the string: " + text.length());
   System.out.println("3. spaces equal the line length: " + (35-text.length())); //How many spaces untill 35
   System.out.print("4. number of gaps: "); //Number of pre existing spaces
   System.out.println(findWhitespace(text));
   System.out.print("5. Calculate how many spaces to add to each gap in the string: ");
   System.out.println(addSpaces(text));
   System.out.print("6. Add result to each gap: ");
   System.out.println(modifyString(text));
   }
   
   
   public int findWhitespace(String text){
   int count = 0;
      for(int i =0; i < text.length(); i++){
         if(text.charAt(i) == ' ')
            count++;
      
      }
      return count;
      }

   public int addSpaces(String text){
      int noofgaps = findWhitespace(text);
      int noofspacestoadd = (35-text.length());
      
      return (noofgaps / noofspacestoadd);   
   }
   
   public String modifyString(String text){
      
      int lineLength = 35;
      
      for(int i = 0; i< text.length(); i++){
         if(text.charAt(i) == ' ' && text.length() < lineLength){
            text = text.substring(0, i) + ' ' + text.substring(i);
            i++;
         }
         
      }
      
      if (text.length() != lineLength) //recursive call
         modifyString(text);
      
      return text;
     } 
     
   public String twoColumns(String textBlock){

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
   
   for(int x = 1; x <= (column1.length() / 35)+1; x++){
   
   charLimit = 35*x;
   
   if (charLimit > column1.length()){
      while (charLimit > column1.length())
         charLimit--;
         
   
         }
   else
      while(column1.charAt(charLimit) != ' ')
         charLimit--;
         
   String tmp = column1.substring(count,charLimit);
   if (tmp.charAt(0) == ' '){
      tmp = tmp.substring(0, 0) + tmp.substring(1);
   }
   
   charLimit2 = 35*x;
   
  if (charLimit2 > column2.length())
      while (charLimit2 > column2.length())
         charLimit2--;
   else
      while(column2.charAt(charLimit2) != ' ')
         charLimit2--;
         
   String tmp1 = column2.substring(count2,charLimit2);
   if (tmp1.charAt(0) == ' '){
      tmp1 = tmp1.substring(0, 0) + tmp1.substring(1);
   }

   
   columns = columns + modifyString(tmp) + "          " + modifyString(tmp1) +"\n"; // center jusify
   //columns = columns + tmp + "          " + tmp1 + "\n";      //right justify
   count = charLimit;
   count2 = charLimit2;
   }   
   
   return columns;

}
     
     
     
     
}