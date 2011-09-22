package net.sf.dvstar.android.diamon.datastore;

import android.graphics.Bitmap;

public class CommonData {
	public static class UserDesc {
		public String id;
	    public String name;
	    public byte[] picture;
	    public Bitmap pictureBitmap;
	    
	} 
	public static class HelpBUItem {
		public int id;
		public int kind_of_item; 
		public String description; 
		public String measure_bu; 
		public String measure_wt;
	} 
}
