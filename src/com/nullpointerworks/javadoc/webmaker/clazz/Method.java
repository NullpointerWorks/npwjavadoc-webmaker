package com.nullpointerworks.javadoc.webmaker.clazz;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.javadoc.webmaker.ItemInformation;
import com.nullpointerworks.javadoc.webmaker.LineBuilder;

public class Method extends ItemInformation
{
	protected String name = "";
	protected String type = "";
	protected String visibility = "";
	protected List<Parameter> params;
	private LineBuilder builder;
	
	public Method()
	{
		builder = new LineBuilder();
		params = new ArrayList<Parameter>();
	}

	public void setName(String n) {name=n;}
	public void setType(String n) {type=n;}
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
		makeDetail();
		return builder.getLines();
	}

	private void makeSummary()
	{
		builder.addLine("<div class=\"rTableRow\">");
		builder.addLine("    <div class=\"rTableCell\">"+visibility+"</div>");
		builder.addLine("    <div class=\"rTableCell\">"+type+"</div>");
		builder.addLine("    <div class=\"rTableCell\">"+getSimpleName()+"</div>");
		builder.addLine("</div>");
	}
	
	private void makeDetail() 
	{
		builder.addLine("<div class=\"header small blue\">"+visibility+" "+type+" "+getComplexName()+"</div>");
		builder.addLine("<div class=\"content midlight\">");
		
		if (getDescription()!=null)
		if (getDescription().length()>0)
		{
			builder.addLine("    <div class=\"desc\">");
			builder.addLine("        "+getDescription());
			builder.addLine("    </div>");
		}
		
		if (params!=null)
		if (params.size()>0)
		{
			builder.addLine("    <div class=\"desc mark\">Parameters:");
			
			for (int i=0,l=params.size(); i<l; i++)
			{
				Parameter p = params.get(i);
				builder.addLine("        <div class=\"marktext\">"+p.getName()+" - "+p.getComment()+"</div>");
			}
			
			builder.addLine("    </div>");
		}
		
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
			String t = p.getTemplate();
			String temp = ((t.length()>0)? "&lt;"+t+"&gt;": "");
			
			if (l==1 || i==(l-1))
			{
				name+=(p.getType() + temp + " " + p.getName());
			}
			else
			{
				name+=(p.getType() + temp + " " + p.getName() + ", ");
			}
		}
		return name+")";
	}
}
