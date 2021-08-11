package com.nullpointerworks.javadoc.webmaker.pack;

import java.util.List;

import com.nullpointerworks.javadoc.webmaker.LineBuilder;

public class PackageItem extends LineBuilder
{
	private String name;
	private String desc;
	
	public PackageItem() {}
	
	public PackageItem(String n, String d)
	{
		setName(n);
		setDescription(d);
	}
	
	public String getName(){return name;}
	public String getDescription(){return desc;}
	
	public void setName(String f) {name = f;}
	public void setDescription(String f) {desc = f;}
	
	public List<String> getWebText(String type)
	{
		clear();
		makeExported(type);
		return getLines();
	}
	
	// ============================================================
	//
	// ============================================================
	
	private void makeExported(String type)
	{
		String link = type + "-" + getName().toLowerCase() + ".html";
		
		addLine("<div class=\"rTableRow\">");
		addLine("    <div class=\"rTableCell\"><a href=\""+link+"\">"+getName()+"</a></div>");
		addLine("    <div class=\"rTableCell\">"+getDescription()+"</div>");
		addLine("</div>");
	}
}
