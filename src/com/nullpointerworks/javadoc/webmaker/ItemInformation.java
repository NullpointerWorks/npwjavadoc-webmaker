package com.nullpointerworks.javadoc.webmaker;

public class ItemInformation 
{
	private String desc = "";
	private String vers = "";
	private String auth = "";
	private String since = "";
	private String see = "";
	
	public String getVersion() {return vers;}
	public String getAuthor() {return auth;}
	public String getSince() {return since;}
	public String getSeeAlso() {return see;}
	public String getDescription() {return desc;}
	
	public void setVersion(String v) {vers=v;}
	public void setAuthor(String a) {auth=a;}
	public void setSince(String s) {since=s;}
	public void setSeeAlso(String s) {see=s;}
	public void setDescription(String... lines) 
	{
		desc = "";
		for (String l : lines)
		{
			if (l!=null)
			if (l.length()>0)
				desc += l+"<br/>\r\n";
		}
	}
}
