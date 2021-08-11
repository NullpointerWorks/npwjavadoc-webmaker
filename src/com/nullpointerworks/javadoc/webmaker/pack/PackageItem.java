package com.nullpointerworks.javadoc.webmaker.pack;

import java.util.List;

import com.nullpointerworks.javadoc.webmaker.LineBuilder;

public class PackageItem extends LineBuilder
{
	private String name;
	
	public PackageItem() {}
	
	public PackageItem(String n)
	{
		setName(n);
	}
	
	public String getName(){return name;}
	
	public void setName(String f) {name = f;}
	
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
		addLine("    <div class=\"rTableCell\">"+getName()+"</div>");
		addLine("</div>");
	}
}
