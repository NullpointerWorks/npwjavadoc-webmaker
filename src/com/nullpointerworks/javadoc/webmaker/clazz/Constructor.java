package com.nullpointerworks.javadoc.webmaker.clazz;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.javadoc.webmaker.ItemInformation;
import com.nullpointerworks.javadoc.webmaker.LineBuilder;

public class Constructor extends ItemInformation
{
	private String name = "";
	private String visibility = "";
	private List<Parameter> params;
	private LineBuilder builder;
	
	public Constructor()
	{
		builder = new LineBuilder();
		params = new ArrayList<Parameter>();
	}

	public void setName(String n) {name=n;}
	public void setVisibility(String n) {visibility=n.toLowerCase();}
	public void setParameter(Parameter p) {params.add(p);}

	public List<String> getWebTextSummary() 
	{
		builder.clear();
		makeSummary();
		return builder.getLines();
	}

	public List<String> getWebText() 
	{
		builder.clear();
		makeConstructor();
		return builder.getLines();
	}

	private void makeSummary()
	{
		builder.addLine("<div class=\"rTableRow\">");
		builder.addLine("    <div class=\"rTableCell\">"+visibility+"</div>");
		builder.addLine("    <div class=\"rTableCell\">"+getSimpleName()+"</div>");
		builder.addLine("</div>");
	}
	
	private void makeConstructor() 
	{
		builder.addLine("<div class=\"header small blue\">"+name+"</div>");
		builder.addLine("<div class=\"content midlight\">");
		
		
		builder.addLine("</div>");
	}
	
	private String getSimpleName()
	{
		String name = this.name+"(";
		for (int i=0,l=params.size(); i<l; i++)
		{
			Parameter p = params.get(i);
			if (l==1 || i==(l-1))
			{
				name+=p.getType();
			}
			else
			{
				name+=p.getType()+", ";
			}
		}
		return name+")";
	}
	
	private String getComplexName()
	{
		String name = this.name+"(";
		for (int i=0,l=params.size(); i<l; i++)
		{
			Parameter p = params.get(i);
			if (l==1 || i==(l-1))
			{
				name+=p.getType() + " " + p.getName();
			}
			else
			{
				name+=p.getType() + " " + p.getName() + ", ";
			}
		}
		return name+")";
	}
}
