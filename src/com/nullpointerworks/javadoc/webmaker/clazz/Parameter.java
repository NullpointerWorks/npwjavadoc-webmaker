package com.nullpointerworks.javadoc.webmaker.clazz;

import java.util.ArrayList;
import java.util.List;

public class Parameter 
{
	private String name = "";
	private String type = "";
	private String modifier = "";
	private List<String> templates;
	
	public Parameter()
	{
		templates = new ArrayList<String>();
	}
	
	public void setName(String n) {name=n;}
	public void setType(String n) {type=n;}
	public void setModifier(String m) {modifier=m;}
	public void setTemplate(String t) {templates.add(t);}

	public String getName() {return name;}
	public String getType() {return type;}
	public String getModifier() {return modifier;}
	public List<String> getTemplates() {return templates;}
}
