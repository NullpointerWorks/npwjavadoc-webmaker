package com.nullpointerworks.javadoc.test;

import java.io.IOException;
import java.util.List;

import com.nullpointerworks.javadoc.webmaker.ModuleMaker;
import com.nullpointerworks.javadoc.webmaker.module.Exported;
import com.nullpointerworks.javadoc.webmaker.module.Required;
import com.nullpointerworks.util.file.textfile.TextFile;
import com.nullpointerworks.util.file.textfile.TextFileParser;

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
		save("web/module.html", page);
	}
	
	public void save(String path, List<String> page)
	{
		TextFile tf = new TextFile();
		tf.setEncoding("UTF-8");
		for (String line : page)
		{
			tf.addLine(line);
		}
		
		try 
		{
			TextFileParser.write(path, tf);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
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
