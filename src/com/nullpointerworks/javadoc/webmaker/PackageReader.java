package com.nullpointerworks.javadoc.webmaker;

import exp.nullpointerworks.xml.Document;
import exp.nullpointerworks.xml.Element;

public class PackageReader 
{
	
	
	public PackageReader()
	{
		
		
	}
	
	
	public boolean isPackage(Document doc)
	{
		Element root = doc.getRootElement();
		Element info = root.getChild("info");
		Element type = info.getChild("type");
		return type.getText().equalsIgnoreCase("package");
	}


	public void makePackage(Document doc, String fname) 
	{
		
		
		
		
		
	}
	
}
