package com.nullpointerworks.javadoc.webmaker;

import exp.nullpointerworks.xml.Document;
import exp.nullpointerworks.xml.Element;

public class EnumReader 
{
	public boolean isEnum(Document doc) 
	{
		Element root = doc.getRootElement();
		Element info = root.getChild("info");
		Element type = info.getChild("type");
		return type.getText().equalsIgnoreCase("enum");
	}
	
	public void makeEnum(Document doc, String path) 
	{
		
		
		Element root = doc.getRootElement();
		
		
	}
	
	
	
	
	
	
	
	
	
}
