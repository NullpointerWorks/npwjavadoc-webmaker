package com.nullpointerworks.javadoc.webmaker.clazz;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.javadoc.webmaker.ItemInformation;
import com.nullpointerworks.javadoc.webmaker.LineBuilder;

public class ClassWebBuilder extends ItemInformation
{
	private LineBuilder builder;
	
	private String name = "";
	private String sPackage = "";
	private String sModule = "";
	private List<String> modifiers;
	private List<String> templates;
	
	private List<Field> fields;
	private List<Constructor> constructors;
	private List<Method> methods;
	
	public ClassWebBuilder()
	{
		builder = new LineBuilder();
		modifiers = new ArrayList<String>();
		templates = new ArrayList<String>();
		fields = new ArrayList<Field>();
		constructors = new ArrayList<Constructor>();
		methods = new ArrayList<Method>();
	}
	
	public void setName(String n) {name=n;}
	public void setPackage(String n) {sPackage=n;}
	public void setModule(String n) {sModule=n;}
	public void setModifier(String e) {modifiers.add(e);}
	public void setTemplate(String e) {templates.add(e);}
	
	public void setField(Field e) {fields.add(e);}
	public void setConstructor(Constructor e) {constructors.add(e);}
	public void setMethod(Method e) {methods.add(e);}
	
	// ============================================================
	//
	// ============================================================
	
	public List<String> getWebText()
	{
		builder.clear();
		makeHead(sModule, sPackage, "Class", name);
		makeDescription();
		
		makeFieldsSummary();
		makeFields();
		
		makeConstructorsSummary();
		makeConstructors();
		
		makeMethodsSummary();
		makeMethods();
		
		makeEnd();
		return builder.getLines();
	}
	
	// ============================================================
	//
	// ============================================================
	
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
			builder.addLine("            <div class=\"header small vdark petrol-font\">");
			builder.addLine("                Module <a href=\"\">"+sModule+"</a>");
			builder.addLine("            </div>");
		}
		
		if (sPackage!=null)
		if (sPackage.length()>0) 
		{
			builder.addLine("            <div class=\"header small vdark petrol-font\">");
			builder.addLine("                Package <a href=\"\">"+sPackage+"</a>");
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
	
	private void makeFieldsSummary()
	{
		if (fields.size() < 1) return;
		builder.addLine("            <div class=\"section dark\">");
		builder.addLine("                <div class=\"sectiontitle\">Field Summary</div>");
		builder.addLine("                <div class=\"header small yellow\">Summary</div>");
		builder.addLine("                <div class=\"rTable\">");
		builder.addLine("                    <div class=\"rTableRow\">");
		builder.addLine("                        <div class=\"rTableHead\" style=\"width:25%;\"><strong>Modifier</strong></div>");
		builder.addLine("                        <div class=\"rTableHead\" style=\"width:25%;\"><strong>Type</strong></div>");
		builder.addLine("                        <div class=\"rTableHead\" style=\"width:50%;\"><strong>Name</strong></div>");
		builder.addLine("                    </div>");
		
		for (Field f : fields)
		{
			builder.addLines( f.getWebTextSummary() , 5);
		}
		
		builder.addLine("                <br></div>");
		builder.addLine("            </div>");
	}
	
	private void makeFields()
	{
		if (fields.size() < 1) return;
		builder.addLine("            <div class=\"section dark\">");
		builder.addLine("                <div class=\"sectiontitle\">Field Detail</div>");
		
		for (Field f : fields)
		{
			builder.addLines( f.getWebText() , 4);
		}
		
		builder.addLine("            <br></div>");
	}
	
	private void makeConstructorsSummary()
	{
		if (constructors.size() < 1) return;
		
		builder.addLine("            <div class=\"section dark\">");
		builder.addLine("                <div class=\"sectiontitle\">Constructor Summary</div>");
		builder.addLine("                <div class=\"header small yellow\">Summary</div>");
		builder.addLine("                <div class=\"rTable\">");
		builder.addLine("                    <div class=\"rTableRow\">");
		builder.addLine("                        <div class=\"rTableHead\" style=\"width:25%;\"><strong>Modifier</strong></div>");
		builder.addLine("                        <div class=\"rTableHead\" style=\"width:75%;\"><strong>Constructor</strong></div>");
		builder.addLine("                    </div>");
		
		for (Constructor c : constructors)
		{
			builder.addLines( c.getWebTextSummary() , 5);
		}
		
		builder.addLine("                <br></div>");
		builder.addLine("            </div>");
	}
	
	private void makeConstructors()
	{
		if (constructors.size() < 1) return;
		
		builder.addLine("            <div class=\"section dark\">");
		builder.addLine("                <div class=\"sectiontitle\">Constructor Detail</div>");
		
		for (Constructor c : constructors)
		{
			builder.addLines( c.getWebText() , 4);
		}
		
		builder.addLine("            <br></div>");
	}
	
	private void makeMethodsSummary()
	{
		
	}
	
	private void makeMethods()
	{
		
	}
	
	private void makeEnd()
	{
		builder.addLine("        </div>");
		builder.addLine("    </body>");
		builder.addLine("</html>");
	}
}
