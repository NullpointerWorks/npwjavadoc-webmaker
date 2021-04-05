package com.nullpointerworks.javadoc.webmaker;

import java.util.ArrayList;
import java.util.List;

public class LineBuilder 
{
	private List<String> lines;
	
	public LineBuilder()
	{
		lines = new ArrayList<String>();
	}
	
	public void clear() 
	{
		lines.clear();
	}
	
	public final List<String> getLines()
	{
		return lines;
	}
	
	public void addLine(String txt)
	{
		addLine(txt,0);
	}
	
	public void addLines(List<String> text)
	{
		addLines(text,0);
	}
	
	public void addLine(String txt, int padding)
	{
		String pad = createPadding(padding);
		lines.add(pad+txt+"\r\n");
	}
	
	public void addLines(List<String> text, int padding)
	{
		String pad = createPadding(padding);
		for (String txt : text)
		{
			lines.add(pad+txt+"\r\n");
		}
	}
	
	public String createPadding(int p) 
	{
		String res = "";
		for (int i=0,l=p; i<l; i++) res += "    ";
		return res;
	}
}
