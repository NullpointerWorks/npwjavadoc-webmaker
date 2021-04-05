package com.nullpointerworks.javadoc.webmaker;

import java.util.List;

import com.nullpointerworks.javadoc.webmaker.module.Exported;
import com.nullpointerworks.javadoc.webmaker.module.ModuleBuilder;
import com.nullpointerworks.javadoc.webmaker.module.Required;

import exp.nullpointerworks.xml.Document;
import exp.nullpointerworks.xml.Element;

public class ModuleMaker 
{
	public boolean isModule(Document doc)
	{
		Element root = doc.getRootElement();
		Element info = root.getChild("info");
		Element type = info.getChild("type");
		return type.getText().equalsIgnoreCase("module");
	}
	
	public void makeModule(Document doc)
	{
		ModuleBuilder mmaker = new ModuleBuilder();
		
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
			
			if (name!=null) mmaker.setName(name.getText());
			if (author!=null) mmaker.setAuthor(author.getText());
			if (version!=null) mmaker.setVersion(version.getText());
			if (since!=null) mmaker.setSince(since.getText());
			if (see!=null) mmaker.setSee(see.getText());
			if (comment!=null) mmaker.setDescription(comment.getText());
		}
		
		Element exports = root.getChild("exports");
		if (exports!=null)
		{
			List<Element> exps = exports.getChildren();
			for (Element e : exps)
			{
				mmaker.setExport( new Exported("",e.getText()) );
			}
		}
		
		Element requires = root.getChild("requires");
		if (requires!=null)
		{
			List<Element> reqs = requires.getChildren();
			for (Element r : reqs)
			{
				mmaker.setRequired( new Required(r.getText(),"") );
			}
		}
		
		List<String> page = mmaker.getWebText();
		FileIO.save("web/module.html", page);
	}
}
