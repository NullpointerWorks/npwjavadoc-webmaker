package com.nullpointerworks.javadoc.webmaker;

import java.util.List;

import com.nullpointerworks.javadoc.webmaker.pack.PackageItem;
import com.nullpointerworks.javadoc.webmaker.pack.PackageWebBuilder;

import exp.nullpointerworks.xml.Document;
import exp.nullpointerworks.xml.Element;

public class PackageReader 
{
	public boolean isPackage(Document doc)
	{
		Element root = doc.getRootElement();
		Element info = root.getChild("info");
		Element type = info.getChild("type");
		return type.getText().equalsIgnoreCase("package");
	}
	
	public void makePackage(Document doc, String path) 
	{
		PackageWebBuilder maker = new PackageWebBuilder();
		Element root = doc.getRootElement();
		
		Element info = root.getChild("info");
		if (info!=null)
		{
			Element name = info.getChild("name");
			Element module = info.getChild("module");
			if (name!=null) maker.setName(name.getText());
			if (module!=null) maker.setModule(module.getText());
		}
		
		Element interfaces = root.getChild("interfaces");
		if (interfaces!=null)
		{
			
			
			
		}
		
		Element classes = root.getChild("classes");
		if (classes!=null)
		{
			List<Element> l = classes.getChildren();
			for (Element r : l)
			{
				Element name = r.getChild("name");
				Element desc = r.getChild("desciption");
				
				maker.setPackageItemClass( new PackageItem(name.getText(), desc.getText()) );
			}
		}
		
		Element enumerations = root.getChild("enumerations");
		if (enumerations!=null)
		{
			
			
			
		}

		List<String> page = maker.getWebText();
		FileIO.save(path, page);
	}
}
