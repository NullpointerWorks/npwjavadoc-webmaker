package com.nullpointerworks.javadoc.webmaker.enums;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.javadoc.webmaker.ItemInformation;
import com.nullpointerworks.javadoc.webmaker.LineBuilder;
import com.nullpointerworks.javadoc.webmaker.clazz.Constructor;
import com.nullpointerworks.javadoc.webmaker.clazz.Field;
import com.nullpointerworks.javadoc.webmaker.clazz.Method;

import exp.nullpointerworks.xml.Element;

public class EnumWebBuilder extends ItemInformation 
{
	private LineBuilder builder;
	
	private String sName = "";
	private String sPackage = "";
	private String sModule = "";
	private List<String> modifiers;
	private List<String> templates;
	
	private List<EnumField> efields;
	private List<Field> fields;
	private List<Constructor> constructors;
	private List<Method> methods;
	
	public EnumWebBuilder()
	{
		builder = new LineBuilder();
		modifiers = new ArrayList<String>();
		templates = new ArrayList<String>();
		
		efields = new ArrayList<EnumField>();
		fields = new ArrayList<Field>();
		constructors = new ArrayList<Constructor>();
		methods = new ArrayList<Method>();
	}
	
	public void setName(String n) {sName=n;}
	public void setPackage(String n) {sPackage=n;}
	public void setModule(String n) {sModule=n;}
	public void setModifier(String e) {modifiers.add(e);}
	public void setTemplate(String e) {templates.add(e);}
	
	public void setField(Field e) {fields.add(e);}
	public void setConstructor(Constructor e) {constructors.add(e);}
	public void setMethod(Method e) {methods.add(e);}
	
	public void addEnumField(String name) 
	{
		EnumField ef = new EnumField();
		ef.setName(name);
		efields.add(ef);
	}
	
	// ============================================================
	//
	// ============================================================
	
	public List<String> getWebText()
	{
		builder.clear();
		makeHead(sModule, sPackage, "Enum", sName);
		makeDescription();
		
		
		makeEnd();
		return builder.getLines();
	}
	
	private void makeHead(String sModule, String sPackage, String type, String name)
	{
		builder.addLine("<!DOCTYPE html>");
		builder.addLine("<html>");
		builder.addLine("    <head>");
		builder.addLine("        <title>"+name+" - API Reference - Nullpointer Works</title>");
		builder.addLine("        <meta charset=\"utf-8\"/>");
		builder.addLine("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>");
		builder.addLine("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/style.css\"/>");
		builder.addLine("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/layout.css\"/>");
		builder.addLine("    </head>");
		builder.addLine("    <body>");
		builder.addLine("        <div class=\"container\">");
		
		if (sModule!=null)
		if (sModule.length()>0) 
		{
			String lModule = "module-" + sModule.replace(".", "-") + ".html";
			builder.addLine("            <div class=\"header small vdark petrol-font\">");
			builder.addLine("                Module <a href=\""+lModule+"\">"+sModule+"</a>");
			builder.addLine("            </div>");
		}
		
		if (sPackage!=null)
		if (sPackage.length()>0) 
		{
			String lPackage = "pack-" + sPackage.replace(".", "-") + ".html";
			builder.addLine("            <div class=\"header small vdark petrol-font\">");
			builder.addLine("                Package <a href=\""+lPackage+"\">"+sPackage+"</a>");
			builder.addLine("            </div>");
		}
		
		String temp = "";
		if (templates.size()>0)
		{
			temp = "&lt;"+templates.remove(0);
			for(String t : templates)
			{
				temp += (","+t);
			}
			temp += "&gt;";
		}
		
		builder.addLine("            <div class=\"header vdark petrol-font\">");
		builder.addLine("                "+type+" "+name+temp);
		builder.addLine("            </div>");
	}
	
	private void makeDescription()
	{
		builder.addLine("            <div class=\"content midlight\">");
		
		if (getDescription()!=null)
		if (getDescription().length()>0)
		{
			builder.addLine("                <div class=\"desc\">");
			builder.addLine("                    "+getDescription());
			builder.addLine("                </div>");
		}

		if (getVersion()!=null)
		if (getVersion().length()>0)
			builder.addLine("                <div class=\"desc mark\">Version:<div class=\"marktext\">"+getVersion()+"</div></div>");

		if (getAuthor()!=null)
		if (getAuthor().length()>0)
			builder.addLine("                <div class=\"desc mark\">Author:<div class=\"marktext\">"+getAuthor()+"</div></div>");

		if (getSince()!=null)
		if (getSince().length()>0)
			builder.addLine("                <div class=\"desc mark\">Since:<div class=\"marktext\">"+getSince()+"</div></div>");
		
		if (getSeeAlso()!=null)
		if (getSeeAlso().length()>0)
			builder.addLine("                <div class=\"desc mark\">See Also:<div class=\"marktext\">"+getSeeAlso()+"</div></div>");
		
		builder.addLine("            <br></div>");
	}
	
	private void makeEnd()
	{
		builder.addLine("        </div>");
		builder.addLine("    </body>");
		builder.addLine("</html>");
	}
	
	
	
	
	
	
	
	
	
	
	
}
