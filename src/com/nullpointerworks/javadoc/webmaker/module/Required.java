package com.nullpointerworks.javadoc.webmaker.module;

import java.util.List;

import com.nullpointerworks.javadoc.webmaker.LineBuilder;

public class Required extends LineBuilder
{
	private String fileName;
	private String packageName;
	
	public Required()
	{
		
	}
	
	public String getFileName() {return fileName;}
	public String getPackageName() {return packageName;}
	public void setFileName(String f) {fileName = f;}
	public void getPackageName(String p) {packageName = p;}
	
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
		addLine("    <div class=\"rTableCell\"><a href=\""+getFileName()+"\">"+getPackageName()+"</a></div>");
		addLine("</div>");
	}
}
