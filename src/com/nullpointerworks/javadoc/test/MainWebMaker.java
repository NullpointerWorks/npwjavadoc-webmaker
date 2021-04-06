package com.nullpointerworks.javadoc.test;

import com.nullpointerworks.javadoc.webmaker.ClassMaker;
import com.nullpointerworks.javadoc.webmaker.FileIO;
import com.nullpointerworks.javadoc.webmaker.ModuleMaker;

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
		
		ModuleMaker mmaker = new ModuleMaker();
		if (mmaker.isModule(doc))
		{
			mmaker.makeModule(doc, "web/module.html");
			return;
		}
		
		ClassMaker cmaker = new ClassMaker();
		if (cmaker.isClass(doc))
		{
			cmaker.makeClass(doc, "web/class.html");
			return;
		}
		
		
		
		
	}
	
}
