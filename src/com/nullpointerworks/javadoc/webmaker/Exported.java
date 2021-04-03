package com.nullpointerworks.javadoc.webmaker;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.javadoc.old.htmlmaker.generator.mod.Exported;

public class Exported 
{
	private String fileName;
	private String packageName;
	private List<String> lines;
	
	public Exported()
	{
		lines = new ArrayList<String>();
	}
	
	public String getFileName() {return fileName;}
	public String getPackageName() {return packageName;}
	public void setFileName(String f) {fileName = f;}
	public void getPackageName(String p) {packageName = p;}
	
	public List<String> getLines()
	{
		lines.clear();
		
		
		
		return lines;
	}

	// ============================================================
	//
	// ============================================================
	
	private String makePackageList()
	{
		if (exports.size() < 1) return "";
		
		String spackage = 
		"            <!-- package section -->\r\n" + 
		"            <div class=\"section dark\">\r\n" + 
		"                <div class=\"sectiontitle\">Packages</div>\r\n" + 
		"                <div class=\"header small yellow\">Exports</div>\r\n" + 
		makeExported() + 
		"            </div>\r\n";
		return spackage;
	}
	
	private String makeExported()
	{
		String exp = 
		"                <!-- exported -->\r\n" + 
		"                <div class=\"rTable\">\r\n" + 
		"                    <div class=\"rTableRow\">\r\n" + 
		"                        <div class=\"rTableHead\"><strong>Package</strong></div>\r\n" + 
		"                    </div>\r\n";
		
		for (Exported e : exports)
		{
			String export = 
			"                    <div class=\"rTableRow\">\r\n" + 
			"                        <div class=\"rTableCell\"><a href=\""+e.getFileName()+"\">"+e.getPackageName()+"</a></div>\r\n" + 
			"                    </div>\r\n";
			exp += export;
		}
		
		exp += 
		"                </div>\r\n";
		return exp;
	}
}
