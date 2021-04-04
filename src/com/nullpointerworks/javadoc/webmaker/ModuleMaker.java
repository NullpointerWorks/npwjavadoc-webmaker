package com.nullpointerworks.javadoc.webmaker;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.javadoc.webmaker.module.Exported;
import com.nullpointerworks.javadoc.webmaker.module.Required;

public class ModuleMaker extends LineBuilder
{
	private String name = "";
	private String desc = "";
	private String vers = "";
	private String auth = "";
	private String since = "";
	private String see = "";
	private List<Exported> exports;
	private List<Required> required;
	
	public ModuleMaker()
	{
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
		String padding = createPadding(5);
		desc = "";
		for (String l : lines)
		{
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
		clear();
		makeHead();
		makeDescription();
		makeExported();
		makeModuleList();
		makeEnd();
		return getLines();
	}
	
	// ============================================================
	//
	// ============================================================
	
	private void makeHead()
	{
		addLine("<!DOCTYPE html>");
		addLine("<html>");
		addLine("    <head>");
		addLine("        <title>"+name+" - API Reference - Nullpointer Works</title>");
		addLine("        <meta charset=\"utf-8\"/>");
		addLine("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>");
		addLine("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/style.css\"/>");
		addLine("        <link rel=\"stylesheet\" type=\"text/css\" href=\"../css/layout.css\"/>");
		addLine("    </head>");
		addLine("    <body>");
		addLine("        <div class=\"container\">");
		addLine("            <div class=\"header vdark petrol-font\">");
		addLine("                Module "+name);
		addLine("            </div>");
	}
	
	private void makeDescription()
	{
		addLine("            <div class=\"content midlight\">");
		addLine("                <div class=\"desc\">");
		addLine("                    "+desc);
		addLine("                </div>");
		
		if (vers.length()>0)
		addLine("                <div class=\"desc mark\">Version:<div class=\"marktext\">"+vers+"</div></div>");
		
		if (auth.length()>0)
		addLine("                <div class=\"desc mark\">Author:<div class=\"marktext\">"+auth+"</div></div>");
		
		if (since.length()>0)
		addLine("                <div class=\"desc mark\">Since:<div class=\"marktext\">"+since+"</div></div>");
		
		if (see.length()>0)
		addLine("                <div class=\"desc mark\">See Also:<div class=\"marktext\">"+see+"</div></div>");
		
		addLine("            </div>");
	}
	
	private void makeExported()
	{
		addLine("            <div class=\"section dark\">\r\n");
		addLine("                <div class=\"sectiontitle\">Packages</div>\r\n");
		addLine("                <div class=\"header small yellow\">Exports</div>\r\n");
		
		addLine("                <div class=\"rTable\">");
		addLine("                    <div class=\"rTableRow\">");
		addLine("                        <div class=\"rTableHead\"><strong>Package</strong></div>");
		addLine("                    </div>");
		
		for (Exported e : exports)
		{
			addLines( e.getWebText() , 5);
		}

		addLine("                </div>");
		addLine("            </div>");
	}
	
	private void makeModuleList()
	{
		addLine("            <div class=\"section dark\">\r\n");
		addLine("                <div class=\"sectiontitle\">Packages</div>\r\n");
		addLine("                <div class=\"header small yellow\">Requires</div>\r\n");
		
		addLine("                <div class=\"rTable\">");
		addLine("                    <div class=\"rTableRow\">");
		addLine("                        <div class=\"rTableHead\" style=\"width:20%;\"><strong>Modifier</strong></div>");
		addLine("                        <div class=\"rTableHead\"><strong>Module</strong></div>");
		addLine("                    </div>");
		
		for (Required r : required)
		{
			addLines( r.getWebText() , 5);
		}

		addLine("                </div>");
		addLine("            </div>");
	}
	
	private void makeEnd()
	{
		addLine("        </div>");
		addLine("    </body>");
		addLine("</html>");
	}
}
