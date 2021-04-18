package com.nullpointerworks.javadoc.webmaker;

import java.util.List;

import com.nullpointerworks.javadoc.webmaker.clazz.*;

import exp.nullpointerworks.xml.Document;
import exp.nullpointerworks.xml.Element;

public class ClassReader 
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
		ClassWebBuilder builder = new ClassWebBuilder();
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
				Element type = field.getChild("type");
				Element value = field.getChild("value");
				Element visibility = field.getChild("visibility");
				List<Element> modifiers = field.getChildren("modifier");
				
				if (name!=null) fieldBuilder.setName(name.getText());
				if (type!=null) fieldBuilder.setType(type.getText());
				if (value!=null) fieldBuilder.setValue(value.getText());
				if (visibility!=null) fieldBuilder.setVisibility(visibility.getText());
				for (Element mod : modifiers) fieldBuilder.setModifier(mod.getText());
				
				setInformation(field, fieldBuilder);
				builder.setField(fieldBuilder);
			}
		}
		
		Element constructors = root.getChild("constructors");
		if (constructors!=null)
		{
			List<Element> children = constructors.getChildren();
			for (Element constructor : children)
			{
				Constructor constructorBuilder = new Constructor();
				
				Element visibility 		= constructor.getChild("visibility");
				Element name 			= constructor.getChild("name");
				
				if (visibility!=null) 	constructorBuilder.setVisibility(visibility.getText());
				if (name!=null) 		constructorBuilder.setName(name.getText());
				
				setParameters(constructor, constructorBuilder);
				setInformation(constructor, constructorBuilder);
				builder.setConstructor(constructorBuilder);
			}
		}
		
		Element methods = root.getChild("methods");
		if (methods!=null)
		{
			List<Element> children = methods.getChildren();
			for (Element method : children)
			{
				
				
				
				
				
				
				
				
			}
		}
		
		List<String> page = builder.getWebText();
		FileIO.save(path, page);
	}

	private void setInformation(Element info, ItemInformation builder) 
	{
		Element i = info.getChild("info");
		Element author	= i.getChild("author");
		Element version	= i.getChild("version");
		Element since 	= i.getChild("since");
		Element see 	= i.getChild("see");
		Element comment	= i.getChild("comment");
		if (author!=null) builder.setAuthor(author.getText());
		if (version!=null) builder.setVersion(version.getText());
		if (since!=null) builder.setSince(since.getText());
		if (see!=null) builder.setSeeAlso(see.getText());
		if (comment!=null) builder.setDescription(comment.getText());
	}
	
	private void setParameters(Element constructor, Constructor builder) 
	{
		List<Element> list = constructor.getChildren("param");
		for (Element param : list)
		{
			Element modifier = param.getChild("modifier");
			Element type = param.getChild("type");
			Element name = param.getChild("name");
			Element comment = param.getChild("comment");
			List<Element> templates = param.getChildren("template");
			
			Parameter p = new Parameter();
			if (name!=null) p.setName( name.getText() );
			if (type!=null) p.setType( type.getText() );
			if (modifier!=null) p.setModifier( modifier.getText() );
			if (comment!=null) p.setComment( comment.getText() );
			
			for (Element temp : templates)
			{
				p.setTemplate( temp.getText() );
			}
			
			builder.setParameter(p);
		}
	}
}
