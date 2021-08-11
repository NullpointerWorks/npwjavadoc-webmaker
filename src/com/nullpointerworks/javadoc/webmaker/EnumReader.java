package com.nullpointerworks.javadoc.webmaker;

import java.util.List;

import com.nullpointerworks.javadoc.webmaker.enums.EnumWebBuilder;
import com.nullpointerworks.javadoc.webmaker.pack.PackageItem;

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
		EnumWebBuilder builder = new EnumWebBuilder();
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
		
		Element enums = root.getChild("enums");
		if (enums!=null)
		{
			
			List<Element> l = enums.getChildren();
			for (Element r : l)
			{
				Element name = r.getChild("name");
				builder.addEnumField(name.getText());
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
}
