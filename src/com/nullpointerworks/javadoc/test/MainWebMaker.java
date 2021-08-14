package com.nullpointerworks.javadoc.test;

import com.nullpointerworks.javadoc.webmaker.ClassReader;
import com.nullpointerworks.javadoc.webmaker.EnumReader;
import com.nullpointerworks.javadoc.webmaker.FileIO;
import com.nullpointerworks.javadoc.webmaker.ModuleReader;
import com.nullpointerworks.javadoc.webmaker.PackageReader;

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
		makePackage();
		makeClass();
		makeEnum1();
	}
	
	public void makeModule()
	{
		Document doc = FileIO.load("xml/module-npw-webmaker.xml");
		if (doc==null) return;
		
		ModuleReader mmaker = new ModuleReader();
		if (mmaker.isModule(doc))
		{
			mmaker.makeModule(doc, "web/module-npw-webmaker.html");
		}
	}
	
	public void makePackage()
	{
		Document doc = FileIO.load("xml/pack-com-nullpointerworks-test.xml");
		if (doc==null) return;
		
		PackageReader preader = new PackageReader();
		if (preader.isPackage(doc))
		{
			preader.makePackage(doc,"web/pack-com-nullpointerworks-test.html");
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
		}
	}
	
	public void makeEnum1()
	{
		Document doc = FileIO.load("xml/DayOfTheWeek.xml");
		if (doc==null) return;
		
		EnumReader emaker = new EnumReader();
		emaker.setIgnorePrivate(false);
		if (emaker.isEnum(doc))
		{
			emaker.makeEnum(doc, "web/enum-dayoftheweek.html");
		}
	}
}
