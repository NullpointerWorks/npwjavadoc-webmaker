package com.nullpointerworks.javadoc.test;

import com.nullpointerworks.javadoc.webmaker.ClassReader;
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
		Document doc = FileIO.load("xml/class.xml");
		if (doc==null) return;
		
		ModuleReader mmaker = new ModuleReader();
		if (mmaker.isModule(doc))
		{
			mmaker.makeModule(doc, "web/module.html");
			return;
		}
		
		ClassReader cmaker = new ClassReader();
		if (cmaker.isClass(doc))
		{
			cmaker.makeClass(doc, "web/class.html");
			return;
		}
		
		
		
		
	}
	
}
