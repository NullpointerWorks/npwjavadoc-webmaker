package com.nullpointerworks.javadoc.webmaker.clazz;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.javadoc.webmaker.ItemInformation;
import com.nullpointerworks.javadoc.webmaker.LineBuilder;

public class ClassBuilder extends ItemInformation
{
	private LineBuilder builder;
	private List<Field> fields;
	private List<Method> methods;
	
	public ClassBuilder()
	{
		builder = new LineBuilder();
		fields = new ArrayList<Field>();
		methods = new ArrayList<Method>();
	}

	public void setField(Field e) {fields.add(e);}
	public void setMethod(Method e) {methods.add(e);}
	
	// ============================================================
	//
	// ============================================================
	
	public List<String> getWebText()
	{
		builder.clear();
		makeHead("Class", getName() );
		makeDescription();
		
		
		
		
		
		makeEnd();
		return builder.getLines();
	}
	
	// ============================================================
	//
	// ============================================================
	
	private void makeHead(String type, String name)
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
		builder.addLine("            <div class=\"header vdark petrol-font\">");
		builder.addLine("                "+type+" "+name);
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
