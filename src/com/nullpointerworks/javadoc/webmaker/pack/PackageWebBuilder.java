package com.nullpointerworks.javadoc.webmaker.pack;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.javadoc.webmaker.LineBuilder;

public class PackageWebBuilder 
{
	private LineBuilder builder;
	private String name = "";
	private String sModule = "";

	private List<PackageItem> interfaces;
	private List<PackageItem> classes;
	private List<PackageItem> enumerations;
	
	public PackageWebBuilder()
	{
		builder = new LineBuilder();
		interfaces = new ArrayList<PackageItem>();
		classes = new ArrayList<PackageItem>();
		enumerations = new ArrayList<PackageItem>();
	}
	
	public void setName(String n) {name=n;}
	public void setModule(String n) {sModule=n;}
	
	public List<String> getWebText() 
	{
		builder.clear();
		makeHead(sModule, "Package", name);
		makeInterfaceList();
		makeClassList();
		makeEnumList();
		makeEnd();
		return builder.getLines();
	}
	
	private void makeHead(String sModule, String type, String name)
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
		
		builder.addLine("            <div class=\"header vdark petrol-font\">");
		builder.addLine("                "+type+" "+name);
		builder.addLine("            </div>");
	}
	
	private void makeInterfaceList()
	{
		
		
	}
	
	private void makeClassList()
	{
		
		
	}
	
	private void makeEnumList()
	{
		
		
	}
	
	private void makeEnd()
	{
		builder.addLine("        </div>");
		builder.addLine("    </body>");
		builder.addLine("</html>");
	}

	public void setPackageItemInterface(PackageItem item) {interfaces.add(item);}
	public void setPackageItemClass(PackageItem item) {classes.add(item);}
	public void setPackageItemEnum(PackageItem item) {enumerations.add(item);}
}
