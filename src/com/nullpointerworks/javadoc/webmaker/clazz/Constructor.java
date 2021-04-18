package com.nullpointerworks.javadoc.webmaker.clazz;

import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.javadoc.webmaker.ItemInformation;
import com.nullpointerworks.javadoc.webmaker.LineBuilder;

public class Constructor extends ItemInformation
{
	private String name = "";
	private String visibility = "";
	private List<Parameter> params;
	private LineBuilder builder;
	
	public Constructor()
	{
		builder = new LineBuilder();
		params = new ArrayList<Parameter>();
	}

	public void setName(String n) {name=n;}
	public void setVisibility(String n) {visibility=n.toLowerCase();}
	public void setParameter(Parameter p) {params.add(p);}
	
	
	
	
	
	
	
	
}
