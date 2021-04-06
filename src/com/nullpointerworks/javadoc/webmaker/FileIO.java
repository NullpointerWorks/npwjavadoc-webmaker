package com.nullpointerworks.javadoc.webmaker;

import java.io.IOException;
import java.util.List;

import com.nullpointerworks.util.file.textfile.TextFile;
import com.nullpointerworks.util.file.textfile.TextFileParser;

import exp.nullpointerworks.xml.Document;
import exp.nullpointerworks.xml.XMLParseException;
import exp.nullpointerworks.xml.io.DOMDocumentLoader;
import exp.nullpointerworks.xml.io.DOMLoader;

public class FileIO 
{
	public static Document load(String path)
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
	
	public static boolean save(String path, List<String> page)
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
			return false;
		}
		return true;
	}
}
