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
	
}