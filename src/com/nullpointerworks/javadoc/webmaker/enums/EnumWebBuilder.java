package com.nullpointerworks.javadoc.webmaker.enums;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.javadoc.webmaker.ItemInformation;
import com.nullpointerworks.javadoc.webmaker.LineBuilder;
import com.nullpointerworks.javadoc.webmaker.clazz.Constructor;
import com.nullpointerworks.javadoc.webmaker.clazz.Field;
import com.nullpointerworks.javadoc.webmaker.clazz.Method;

public class EnumWebBuilder extends ItemInformation 
{
private LineBuilder builder;
	
	private String sName = "";
	private String sPackage = "";
	private String sModule = "";
	private List<String> modifiers;
	private List<String> templates;
	
	private List<Field> fields;
	private List<Constructor> constructors;
	private List<Method> methods;
	
	public EnumWebBuilder()
	{
		builder = new LineBuilder();
		modifiers = new ArrayList<String>();
		templates = new ArrayList<String>();
		fields = new ArrayList<Field>();
		constructors = new ArrayList<Constructor>();
		methods = new ArrayList<Method>();
	}
	
	public void setName(String n) {sName=n;}
	public void setPackage(String n) {sPackage=n;}
	public void setModule(String n) {sModule=n;}
	public void setModifier(String e) {modifiers.add(e);}
	public void setTemplate(String e) {templates.add(e);}
	
	public void setField(Field e) {fields.add(e);}
	public void setConstructor(Constructor e) {constructors.add(e);}
	public void setMethod(Method e) {methods.add(e);}
	
	// ============================================================
	//
	// ============================================================
	
	public List<String> getWebText()
	{
		builder.clear();
		
		
		
		
		
		
		
		return builder.getLines();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
