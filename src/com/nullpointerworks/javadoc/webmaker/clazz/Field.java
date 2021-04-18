package com.nullpointerworks.javadoc.webmaker.clazz;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.javadoc.webmaker.ItemInformation;
import com.nullpointerworks.javadoc.webmaker.LineBuilder;

public class Field extends ItemInformation
{
	private LineBuilder builder;
	private String name = "";
	private String type = "";
	private String value = "";
	private String visibility = "";
	private List<String> modifiers;
	
	public Field()
	{
		builder = new LineBuilder();
		modifiers = new ArrayList<String>();
	}
	
	public void setName(String n) {name=n;}
	public void setType(String n) {type=n;}
	public void setValue(String n) {value=n;}
	public void setVisibility(String n) {visibility=n.toLowerCase();}
	public void setModifier(String e) {modifiers.add(e.toLowerCase());}
	
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
		String mods = "";
		if (modifiers.size()>0)
		{
			for (String m : modifiers)
			{
				if (m!=null)
				if (m.length()>0) 
					mods += (" "+m);
			}
		}
		
		builder.addLine("<div class=\"rTableRow\">");
		builder.addLine("    <div class=\"rTableCell\">"+visibility+mods+"</div>");
		builder.addLine("    <div class=\"rTableCell\">"+type+"</div>");
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
		String mods = "";
		if (modifiers.size()>0)
		{
			for (String m : modifiers)
			{
				if (m!=null)
				if (m.length()>0) 
					mods += (" "+m);
			}
		}
		
		builder.addLine("    <div class=\"desc\">");
		builder.addLine("        <i>"+visibility+mods+" "+type+" "+name+"</i><br><br>");
		
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
