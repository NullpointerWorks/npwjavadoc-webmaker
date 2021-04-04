package com.nullpointerworks.javadoc.test;

import java.io.IOException;

import com.nullpointerworks.javadoc.webmaker.ModuleMaker;

import exp.nullpointerworks.xml.Document;
import exp.nullpointerworks.xml.Element;
import exp.nullpointerworks.xml.XMLParseException;
import exp.nullpointerworks.xml.io.DOMDocumentLoader;
import exp.nullpointerworks.xml.io.DOMLoader;

public class MainWebMaker 
{
	public static void main(String[] args) 
	{
		new MainWebMaker();
	}
	
	public MainWebMaker()
	{
		Document doc = load("xml/module.xml");
		if (doc==null) return;
		
		if (isModule(doc))
		{
			makeModule(doc);
		}
		
	}
	
	public boolean isModule(Document doc)
	{
		Element root = doc.getRootElement();
		Element info = root.getChild("info");
		Element type = info.getChild("type");
		return type.getText().equalsIgnoreCase("module");
	}
	
	public void makeModule(Document doc)
	{
		ModuleMaker mmaker = new ModuleMaker();
		
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
		
		
		
		
	}
	
	public Document load(String path)
	{
		DOMLoader loader = new DOMDocumentLoader();
		Document doc = null;
		try 
		{
			doc = loader.parse(path);
		} 
		catch (XMLParseException | IOException ex) 
		{
			ex.printStackTrace();
		}
		return doc;
	}
}
