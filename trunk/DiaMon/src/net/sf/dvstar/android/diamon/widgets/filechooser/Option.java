package net.sf.dvstar.android.diamon.widgets.filechooser;

import android.graphics.drawable.Drawable;

public class Option implements Comparable<Option>{
	private String name;
	private String data;
	private String path;
	private Drawable icon;
	
	public Option(String n,String d,String p)
	{
		this(n, d,p, null);
	}
	
	public Option(String n,String d,String p,Drawable icon)
	{
		this.name = n;
		this.data = d;
		this.path = p;
		this.icon = icon;
	}
	
	public String getName()
	{
		return name;
	}
	public String getData()
	{
		return data;
	}
	public String getPath()
	{
		return path;
	}
	public Drawable getIcon()
	{
		return icon;
	}
	public void setIcon(Drawable icon)
	{
		this.icon = icon;
	}

	
	public int compareTo(Option another) {
		if(this.name != null)
			return this.name.toLowerCase().compareTo(another.getName().toLowerCase()); 
		else 
			throw new IllegalArgumentException();
	}
	
}
