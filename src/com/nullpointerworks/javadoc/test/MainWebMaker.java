package com.nullpointerworks.javadoc.test;

import com.nullpointerworks.javadoc.webmaker.ClassReader;
import com.nullpointerworks.javadoc.webmaker.EnumReader;
import com.nullpointerworks.javadoc.webmaker.FileIO;
import com.nullpointerworks.javadoc.webmaker.ModuleReader;

import exp.nullpointerworks.xml.Document;

public class MainWebMaker
{
	public static void main(String[] args) 
	{
		new MainWebMaker();
	}
	
	public MainWebMaker()
	{
		Document doc = FileIO.load("xml/module.xml");
		if (doc==null) return;
		
		
		
		
		ClassReader cmaker = new ClassReader();
		if (cmaker.isClass(doc))
		{
			cmaker.makeClass(doc, "web/class.html");
			return;
		}
		
		ModuleReader mmaker = new ModuleReader();
		if (mmaker.isModule(doc))
		{
			mmaker.makeModule(doc, "web/module.html");
			return;
		}
		
		EnumReader emaker = new EnumReader();
		if (emaker.isEnum(doc))
		{
			emaker.makeEnum(doc, "web/enum1.html");
			return;
		}
		
		
		
	}
	
}
