package net.sf.dvstar.android.diamon.journal;

import android.app.ListActivity;
import android.app.TabActivity;
import android.graphics.Bitmap;

public class JournalDailyReport extends ListActivity implements IJournalListItems {

	private String NAME;
	private String DESC;
	private Bitmap ICON=null;

	public JournalDailyReport(){
		  NAME = "JournalDailyReport";
		  DESC = "JournalDailyReport for usage";
	}
	
	
	public String getName() {
		return NAME;
	}

	public String getDesc() {
		return DESC;
	}

	public Bitmap getIcon() {
		return ICON;
	}

}
