package com.nullpointerworks.javadoc.webmaker;

import java.util.ArrayList;
import java.util.List;

public class ModuleMaker 
{
	private String name = "";
	private String desc = "";
	private String vers = "";
	private String auth = "";
	private List<String> lines;
	private List<Exported> exports;
	private List<Required> required;
	
	public ModuleMaker()
	{
		lines = new ArrayList<String>();
		exports = new ArrayList<Exported>();
		required = new ArrayList<Required>();
	}
	
	public void setName(String n) {name=n;}
	public void setVersion(String v) {vers=v;}
	public void setAuthor(String a) {auth=a;}
	public void setDescription(String[] lines) 
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
	
	public List<String> getLines()
	{
		lines.clear();
		makeHead();
		makeDescription();
		
		
		
		makeEnd();
		return lines;
	}
	
	private void addLine(String txt)
	{
		addLine(txt,0);
	}
	
	private void addLine(String txt, int padding)
	{
		String pad = createPadding(padding);
		lines.add(pad+txt+"\r\n");
	}
	
	private String createPadding(int p) 
	{
		String res = "";
		for (int i=0,l=p; i<l; i++) res += "    ";
		return res;
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
		addLine("                <div class=\"desc mark\">Version:<div class=\"marktext\">"+vers+"</div></div>");
		addLine("                <div class=\"desc mark\">Author:<div class=\"marktext\">"+auth+"</div></div>");
		addLine("            </div>");
	}
	
	private void makeEnd()
	{
		addLine("        </div>");
		addLine("    </body>");
		addLine("</html>");
	}
}
