package com.nullpointerworks.javadoc.webmaker;

import java.util.ArrayList;
import java.util.List;

public abstract class LineBuilder 
{
	private List<String> lines;
	
	public LineBuilder()
	{
		lines = new ArrayList<String>();
	}
	
	protected void clear() 
	{
		lines.clear();
	}
	
	protected final List<String> getLines()
	{
		return lines;
	}
	
	protected void addLine(String txt)
	{
		addLine(txt,0);
	}
	
	protected void addLines(List<String> text)
	{
		addLines(text,0);
	}
	
	protected void addLine(String txt, int padding)
	{
		String pad = createPadding(padding);
		lines.add(pad+txt+"\r\n");
	}
	
	protected void addLines(List<String> text, int padding)
	{
		String pad = createPadding(padding);
		for (String txt : text)
		{
			lines.add(pad+txt+"\r\n");
		}
	}
	
	protected String createPadding(int p) 
	{
		String res = "";
		for (int i=0,l=p; i<l; i++) res += "    ";
		return res;
	}
}
