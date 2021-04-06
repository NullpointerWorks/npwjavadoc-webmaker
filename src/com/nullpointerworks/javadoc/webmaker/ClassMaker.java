package com.nullpointerworks.javadoc.webmaker;

import java.util.List;

import com.nullpointerworks.javadoc.webmaker.clazz.ClassBuilder;
import com.nullpointerworks.javadoc.webmaker.clazz.Field;

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
	
	public void makeClass(Document doc, String path) 
	{
		ClassBuilder builder = new ClassBuilder();
		Element root = doc.getRootElement();
		
		Element info = root.getChild("info");
		if (info!=null)
		{
			Element name = info.getChild("name");
			Element modulename = info.getChild("module");
			Element packagename = info.getChild("package");
			List<Element> templates = info.getChildren("template");
			List<Element> modifiers = info.getChildren("modifier");

			if (name!=null) builder.setName(name.getText());
			if (modulename!=null) builder.setModule(modulename.getText());
			if (packagename!=null) builder.setPackage(packagename.getText());
			for (Element temp : templates) builder.setTemplate(temp.getText());
			for (Element mod : modifiers) builder.setModifier(mod.getText());
			
			setInformation(info, builder);
		}
		
		Element fields = root.getChild("fields");
		if (fields!=null)
		{
			List<Element> children = fields.getChildren();
			for (Element field : children)
			{
				Field fieldBuilder = new Field();
				
				Element name = field.getChild("name");
				Element value = field.getChild("value");
				Element visibility = field.getChild("visibility");
				List<Element> modifiers = field.getChildren("modifier");
				
				if (name!=null) fieldBuilder.setName(name.getText());
				if (value!=null) fieldBuilder.setName(value.getText());
				if (visibility!=null) fieldBuilder.setVisibility(visibility.getText());
				for (Element mod : modifiers) fieldBuilder.setModifier(mod.getText());
				
				setInformation(info, builder);
			}
		}
		
		
		List<String> page = builder.getWebText();
		FileIO.save(path, page);
	}

	private void setInformation(Element info, ClassBuilder builder) 
	{
		Element author = info.getChild("author");
		Element version = info.getChild("version");
		Element since = info.getChild("since");
		Element see = info.getChild("see");
		Element comment = info.getChild("comment");
		if (author!=null) builder.setAuthor(author.getText());
		if (version!=null) builder.setVersion(version.getText());
		if (since!=null) builder.setSince(since.getText());
		if (see!=null) builder.setSeeAlso(see.getText());
		if (comment!=null) builder.setDescription(comment.getText());
	}
}
