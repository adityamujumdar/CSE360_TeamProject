package teamProject;

public class TextProcessor
{
	private int justification;
	private int spacing;
	private int indentation;
	private int columns;
	
	public TextProcessor()
	{
		justification = 0; 	//Left justified
		spacing = 0;		//Single space
		indentation = 0;	//No indent
		columns = 0;		//1 column
	}
	
	public void setJustification(int just)
	{
		justification = just;
	}
	
	public void setSpacing(int space)
	{
		spacing = space;
	}
	
	public void setIndentation(int indent)
	{
		indentation = indent;
	}
	
	public void setColumns(int col)
	{
		columns = col;
	}
	
	public String handleText()
	{
		
		return null;
	}
	
}
