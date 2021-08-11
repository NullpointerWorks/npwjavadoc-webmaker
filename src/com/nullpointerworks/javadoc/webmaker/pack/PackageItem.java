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
		addLine("    <div class=\"rTableCell\">"+getDescription()+"</div>");
		addLine("</div>");
	}
}
