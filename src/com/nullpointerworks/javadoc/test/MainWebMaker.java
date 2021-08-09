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
		makeModule();
		
		//makeClass();
		
		
		
	}
	
	public void makeModule()
	{
		Document doc = FileIO.load("xml/module.xml");
		if (doc==null) return;
		
		ModuleReader mmaker = new ModuleReader();
		if (mmaker.isModule(doc))
		{
			mmaker.makeModule(doc, "web/module.html");
			return;
		}
	}
	
	public void makeClass()
	{
		Document doc = FileIO.load("xml/AbstractTestClass.xml");
		if (doc==null) return;
		
		ClassReader cmaker = new ClassReader();
		if (cmaker.isClass(doc))
		{
			cmaker.makeClass(doc, "web/class-abstracttestclass.html");
			return;
		}
	}
	
	public void makeEnum1()
	{
		Document doc = FileIO.load("xml/enum1.xml");
		if (doc==null) return;
		
		EnumReader emaker = new EnumReader();
		if (emaker.isEnum(doc))
		{
			emaker.makeEnum(doc, "web/enum1.html");
			return;
		}
	}
}
