package com.nullpointerworks.javadoc.webmaker;

import com.nullpointerworks.javadoc.webmaker.clazz.ClassBuilder;

import exp.nullpointerworks.xml.Document;
import exp.nullpointerworks.xml.Element;

public class ClassMaker 
{
	public boolean isClass(Document doc) 
	{
		Element root = doc.getRootElement();
		Element info = root.getChild("info");
		Element type = info.getChild("type");
		return type.getText().equalsIgnoreCase("class");
	}

	public void makeClass(Document doc) 
	{
		ClassBuilder maker = new ClassBuilder();
		Element root = doc.getRootElement();
		
		Element info = root.getChild("info");
		if (info!=null)
		{
			Element name = info.getChild("name");
			Element author = info.getChild("author");
			Element version = info.getChild("version");
			Element since = info.getChild("since");
			Element see = info.getChild("see");
			Element comment = info.getChild("comment");
			
			if (name!=null) maker.setName(name.getText());
			if (author!=null) maker.setAuthor(author.getText());
			if (version!=null) maker.setVersion(version.getText());
			if (since!=null) maker.setSince(since.getText());
			if (see!=null) maker.setSeeAlso(see.getText());
			if (comment!=null) maker.setDescription(comment.getText());
		}
		
		
		
		
		
		
		
		
		
	}
	
}
