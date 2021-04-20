package com.nullpointerworks.javadoc.webmaker.enums;

import java.util.List;

import com.nullpointerworks.javadoc.webmaker.ItemInformation;
import com.nullpointerworks.javadoc.webmaker.LineBuilder;

public class EnumField extends ItemInformation
{
	private LineBuilder builder;
	private String name = "";
	
	public EnumField()
	{
		builder = new LineBuilder();
	}
	
	public void setName(String n) {name=n;}
	
	public List<String> getWebTextSummary()
	{
		builder.clear();
		makeFieldSummary();
		return builder.getLines();
	}
	
	public List<String> getWebText()
	{
		builder.clear();
		makeField();
		return builder.getLines();
	}
	
	private void makeFieldSummary()
	{
		builder.addLine("<div class=\"rTableRow\">");
		builder.addLine("    <div class=\"rTableCell\">"+name+"</div>");
		builder.addLine("</div>");
	}
	
	private void makeField()
	{
		builder.addLine("<div class=\"header small blue\">"+name+"</div>");
		builder.addLine("<div class=\"content midlight\">");
		makeDescription();
		builder.addLine("</div>");
	}

	private void makeDescription()
	{
		builder.addLine("    <div class=\"desc\">");
		builder.addLine("        <i>"+name+"</i><br><br>");
		
		if (getDescription()!=null)
		if (getDescription().length()>0)
		{
			builder.addLine("        "+getDescription());
		}
		
		builder.addLine("    </div>");
		

		if (getVersion()!=null)
		if (getVersion().length()>0)
			builder.addLine("    <div class=\"desc mark\">Version:<div class=\"marktext\">"+getVersion()+"</div></div>");

		if (getAuthor()!=null)
		if (getAuthor().length()>0)
			builder.addLine("    <div class=\"desc mark\">Author:<div class=\"marktext\">"+getAuthor()+"</div></div>");

		if (getSince()!=null)
		if (getSince().length()>0)
			builder.addLine("    <div class=\"desc mark\">Since:<div class=\"marktext\">"+getSince()+"</div></div>");
		
		if (getSeeAlso()!=null)
		if (getSeeAlso().length()>0)
			builder.addLine("    <div class=\"desc mark\">See Also:<div class=\"marktext\">"+getSeeAlso()+"</div></div>");
	}
}
