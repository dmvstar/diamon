package net.sf.dvstar.android.diamon.journal;

import net.sf.dvstar.android.diamon.R;
import android.app.Activity;
import android.app.ListActivity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;

public class JournalDailyReport extends Activity implements
		IJournalListItems {

	private String NAME;
	private String DESC;
	private Bitmap ICON = null;

	public JournalDailyReport() {
		super();
	}

	public JournalDailyReport(Resources resources) {
		super();
		NAME = resources.getString(R.string.jrn_name_jrn_daily_report);// "JournalDailyReport";
		DESC = resources.getString(R.string.jrn_desc_jrn_daily_report);// "JournalDailyReport for usage";
	}

	/*
	 * public JournalDailyReport(Activity parent) { this.parent = parent;
	 * Resources res = parent.getResources(); if(res != null){ NAME =
	 * getResources
	 * ().getString(R.string.jrn_name_jrn_daily_report);//"JournalDailyReport";
	 * DESC = getResources().getString(R.string.jrn_desc_jrn_daily_report);//
	 * "JournalDailyReport for usage"; } }
	 */

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jrn_daily_report);
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

	public Intent execute(Context context) {
		return new Intent(context, this.getClass());
	}

}
