package net.sf.dvstar.android.diamon.widgets.filechooser;

import android.graphics.drawable.Drawable;

/**
 * Element for directory view structure
 * @author sdv
 */
public class FileChooserElement implements Comparable<FileChooserElement> {
	private String name;
	private String data;
	private String path;
	private Drawable icon;
	
	/**
	 * Default constructor
	 * @param name element
	 * @param data element data 
	 * @param path full path
	 * @param icon icon for element
	 */
	public FileChooserElement(String name, String data, String path, Drawable icon) {
		this.name = name;
		this.data = data;
		this.path = path;
		this.icon = icon;
	}

	/**
	 * Constructor without icon
	 * @param name element
	 * @param data element data 
	 * @param path full path
	 */
	public FileChooserElement(String name, String data, String path) {
		this(name, data, path, null);
	}

	public String getName() {
		return name;
	}

	public String getData() {
		return data;
	}

	public String getPath() {
		return path;
	}

	public Drawable getIcon() {
		return icon;
	}

	public void setIcon(Drawable icon) {
		this.icon = icon;
	}

	/**
	 * Sorter for directory elements 
	 */
	public int compareTo(FileChooserElement another) {
		if (this.name != null)
			return this.name.toLowerCase().compareTo(
					another.getName().toLowerCase());
		else
			throw new IllegalArgumentException();
	}

}
