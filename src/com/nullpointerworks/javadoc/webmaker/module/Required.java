package com.nullpointerworks.javadoc.webmaker.module;

import java.util.List;

import com.nullpointerworks.javadoc.webmaker.LineBuilder;

public class Required extends LineBuilder
{
	private String name;
	private String modifier;
	
	public Required()
	{
		
	}
	
	public String getName(){return name;}
	public String getModifier(){return modifier;}
	
	public void setName(String f) {name = f;}
	public void setModifier(String p) {modifier = p;}
	
	public List<String> getWebText()
	{
		clear();
		makeExported();
		return getLines();
	}

	// ============================================================
	//
	// ============================================================
	
	private void makeExported()
	{
		addLine("<div class=\"rTableRow\">");
		addLine("    <div class=\"rTableCell\">"+getModifier()+"</div>");
		addLine("    <div class=\"rTableCell\">"+getName()+"</div>");
		addLine("</div>");
	}
}
