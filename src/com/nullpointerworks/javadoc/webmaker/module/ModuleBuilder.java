package com.nullpointerworks.javadoc.webmaker.module;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.javadoc.webmaker.LineBuilder;

public class ModuleBuilder
{
	private LineBuilder builder;
	
	private String name = "";
	private String desc = "";
	private String vers = "";
	private String auth = "";
	private String since = "";
	private String see = "";
	private List<Exported> exports;
	private List<Required> required;
	
	public ModuleBuilder()
	{
		builder = new LineBuilder();
		exports = new ArrayList<Exported>();
		required = new ArrayList<Required>();
	}
	
	public void setName(String n) {name=n;}
	public void setVersion(String v) {vers=v;}
	public void setAuthor(String a) {auth=a;}
	public void setSince(String s) {since=s;}
	public void setSee(String s) {see=s;}
	public void setDescription(String... lines) 
	{
		String padding = builder.createPadding(5);
		desc = "";
		for (String l : lines)
		{
			if (l!=null)
			if (l.length()>0)
				desc += padding+l+"<br/>\r\n";
		}
	}
	public void setExport(Exported e) {exports.add(e);}
	public void setRequired(Required r) {required.add(r);}
	
	// ============================================================
	//
	// ============================================================
	
	public List<String> getWebText()
	{
		builder.clear();
		makeHead("Module", name);
		makeDescription();
		makeExported();
		makeModuleList();
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
		
		if (desc!=null)
		if (desc.length()>0)
		{
			builder.addLine("                <div class=\"desc\">");
			builder.addLine("                    "+desc);
			builder.addLine("                </div>");
		}

		if (vers!=null)
		if (vers.length()>0)
			builder.addLine("                <div class=\"desc mark\">Version:<div class=\"marktext\">"+vers+"</div></div>");

		if (auth!=null)
		if (auth.length()>0)
			builder.addLine("                <div class=\"desc mark\">Author:<div class=\"marktext\">"+auth+"</div></div>");

		if (since!=null)
		if (since.length()>0)
			builder.addLine("                <div class=\"desc mark\">Since:<div class=\"marktext\">"+since+"</div></div>");
		
		if (see!=null)
		if (see.length()>0)
			builder.addLine("                <div class=\"desc mark\">See Also:<div class=\"marktext\">"+see+"</div></div>");
		
		builder.addLine("            <br></div>");
	}
	
	private void makeExported()
	{
		if (exports.size()>0)
		{
			builder.addLine("            <div class=\"section dark\">\r\n");
			builder.addLine("                <div class=\"sectiontitle\">Packages</div>\r\n");
			builder.addLine("                <div class=\"header small yellow\">Exports</div>\r\n");
			
			builder.addLine("                <div class=\"rTable\">");
			builder.addLine("                    <div class=\"rTableRow\">");
			builder.addLine("                        <div class=\"rTableHead\"><strong>Package</strong></div>");
			builder.addLine("                    </div>");
			
			for (Exported e : exports)
			{
				builder.addLines( e.getWebText() , 5);
			}

			builder.addLine("                <br></div>");
			builder.addLine("            </div>");
		}
	}
	
	private void makeModuleList()
	{
		if (required.size()>0)
		{
			builder.addLine("            <div class=\"section dark\">\r\n");
			builder.addLine("                <div class=\"sectiontitle\">Packages</div>\r\n");
			builder.addLine("                <div class=\"header small yellow\">Requires</div>\r\n");
			
			builder.addLine("                <div class=\"rTable\">");
			builder.addLine("                    <div class=\"rTableRow\">");
			builder.addLine("                        <div class=\"rTableHead\" style=\"width:20%;\"><strong>Modifier</strong></div>");
			builder.addLine("                        <div class=\"rTableHead\"><strong>Module</strong></div>");
			builder.addLine("                    </div>");
			
			for (Required r : required)
			{
				builder.addLines( r.getWebText() , 5);
			}

			builder.addLine("                <br></div>");
			builder.addLine("            </div>");
		}
	}
	
	private void makeEnd()
	{
		builder.addLine("        </div>");
		builder.addLine("    </body>");
		builder.addLine("</html>");
	}
}
