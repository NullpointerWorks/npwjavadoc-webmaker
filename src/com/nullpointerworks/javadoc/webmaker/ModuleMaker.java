package com.nullpointerworks.javadoc.webmaker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.nullpointerworks.util.file.textfile.TextFile;
import com.nullpointerworks.util.file.textfile.TextFileParser;

public class ModuleMaker 
{
	private String name = "";
	private String desc = "";
	private String vers = "";
	private String auth = "";
	private List<Exported> exports;
	private List<Required> required;
	
	public ModuleMaker()
	{
		exports = new ArrayList<Exported>();
		required = new ArrayList<Required>();
	}
	
	public void setName(String n) {name=n;}
	public void setVersion(String v) {vers=v;}
	public void setAuthor(String a) {auth=a;}
	public void setDescription(String[] lines) 
	{
		String padding = createPadding(5);
		desc = "";
		for (String l : lines)
		{
			desc += padding+l+"<br/>\r\n";
		}
	}
	public void setExport(Exported e) {exports.add(e);}
	public void setRequired(Required r) {required.add(r);}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void save(String path) throws IOException
	{
		TextFile tf = new TextFile();
		
		
		
		tf.setEncoding("UTF-8");
		TextFileParser.write(path, tf);
	}
	
	private String createPadding(int p) 
	{
		String res = "";
		for (int i=0,l=p; i<l; i++) res += "    ";
		return res;
	}
}
