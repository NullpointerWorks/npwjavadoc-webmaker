package com.nullpointerworks.javadoc.webmaker.clazz;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.javadoc.webmaker.ItemInformation;
import com.nullpointerworks.javadoc.webmaker.LineBuilder;

public class Field extends ItemInformation
{
	private LineBuilder lineBuilder;
	private String name = "";
	private String value = "";
	private String visibility = "";
	private List<String> modifiers;
	
	public Field()
	{
		lineBuilder = new LineBuilder();
		modifiers = new ArrayList<String>();
		
	}
	
	public void setName(String n) {name=n;}
	public void setValue(String n) {value=n;}
	public void setVisibility(String n) {visibility=n;}
	public void setModifier(String e) {modifiers.add(e);}
	
	public List<String> getWebText()
	{
		lineBuilder.clear();
		
		return lineBuilder.getLines();
	}
	
	
	
	
	
	
	
	
}
