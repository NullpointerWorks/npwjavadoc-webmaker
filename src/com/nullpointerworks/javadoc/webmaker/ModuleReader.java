package com.nullpointerworks.javadoc.webmaker;

import java.util.List;

import com.nullpointerworks.javadoc.webmaker.module.*;

import exp.nullpointerworks.xml.Document;
import exp.nullpointerworks.xml.Element;

public class ModuleReader 
{
	public boolean isModule(Document doc)
	{
		Element root = doc.getRootElement();
		Element info = root.getChild("info");
		Element type = info.getChild("type");
		return type.getText().equalsIgnoreCase("module");
	}
	
	public void makeModule(Document doc, String path)
	{
		ModuleWebBuilder maker = new ModuleWebBuilder();
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
		
		Element exports = root.getChild("exports");
		if (exports!=null)
		{
			List<Element> exps = exports.getChildren();
			for (Element e : exps)
			{
				String link = "pack-"+( e.getText().replace(".", "-") )+".html";
				maker.setExport( new Exported(link, e.getText()) );
			}
		}
		
		Element requires = root.getChild("requires");
		if (requires!=null)
		{
			List<Element> reqs = requires.getChildren();
			for (Element r : reqs)
			{
				maker.setRequired( new Required(r.getText(),"") );
			}
		}
		
		List<String> page = maker.getWebText();
		FileIO.save(path, page);
	}
}
