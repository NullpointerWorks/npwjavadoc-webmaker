package com.nullpointerworks.javadoc.webmaker.clazz;

import java.util.ArrayList;
import java.util.List;

public class Parameter 
{
	private String name = "";
	private String type = "";
	private String modifier = "";
	private String comment = "";
	private List<String> templates;
	
	public Parameter()
	{
		templates = new ArrayList<String>();
	}
	
	public void setName(String n) {name=n;}
	public void setType(String n) {type=n;}
	public void setModifier(String m) {modifier=m;}
	public void setComment(String c) {comment=c;}
	public void setTemplate(String t) {templates.add(t);}

	public String getName() {return name;}
	public String getType() {return type;}
	public String getModifier() {return modifier;}
	public String getComment() {return comment;}
	public List<String> getTemplates() {return templates;}
	public String getTemplate() 
	{
		if (templates.size() < 1) return "";
		String b = "";
		
		int i=0;
		int l=templates.size();
		for (; i<l; i++)
		{
			String t = templates.get(i);
			if (l==1 || i==(l-1))
			{
				b += t;
			}
			else
			{
				b += (t + " , ");
			}
		}
		return b;
	}
}
