package net.sf.dvstar.android.diamon.journal;

import android.graphics.Bitmap;

public interface IJournalListItems {
	
	  /** A constant for the name field in a list activity. */
	  public String KEY_NAME = "name";
	  /** A constant for the description field in a list activity. */
	  public String KEY_DESC = "desc";

	  /**
	   * Returns the chart name.
	   * 
	   * @return the chart name
	   */
	  String getName();

	  /**
	   * Returns the chart description.
	   * 
	   * @return the chart description
	   */
	  String getDesc();

	  
	  /*
      image = BitmapFactory.decodeStream(GraphicalView.class
          .getResourceAsStream("image/zoom_out.png"));
      */
	  Bitmap getIcon();
	  
	  
}
