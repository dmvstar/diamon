package net.sf.dvstar.android.diamon.journal;

import net.sf.dvstar.android.diamon.R;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class InsulinWeeklyReport extends TabActivity 
		implements IJournalListItems 
		, TabHost.TabContentFactory 
		{

	private TabHost mTabHost;

	private String NAME;
	private String DESC;
	private Bitmap ICON = null;

	public InsulinWeeklyReport() {
		super();
	}	
	
	public InsulinWeeklyReport(Resources resources) {
		super();
		NAME = resources.getString(R.string.jrn_name_insulin_weekly_report);// "InsulinWeeklyReport";
		DESC = resources.getString(R.string.jrn_desc_insulin_weekly_report);// "InsulinWeeklyReport for usage";
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

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jrn_insulin_weekly);
		
		mTabHost = getTabHost();
		mTabHost.setup();

		mTabHost.addTab(mTabHost
				.newTabSpec("tab1")
				.setIndicator("tab1",
						getResources().getDrawable(R.drawable.star_big_on))
				.setContent(this));
		mTabHost.addTab(mTabHost.newTabSpec("tab2").setIndicator("tab2")
				.setContent(this));
		mTabHost.addTab(mTabHost.newTabSpec("tab3").setIndicator("tab3")
				.setContent(this));

		mTabHost.setCurrentTab(0);


		/*
		 * LayoutInflater inflater=getLayoutInflater(); View
		 * view=inflater.inflate(R.layout.journal, null);
		 * 
		 * myTabHost = (TabHost) view.findViewById(R.id.tabHostJournal);
		 * myTabHost.setup();
		 * 
		 * ls1 = new ListView(JournalActivity.this); TabSpec ts1 =
		 * myTabHost.newTabSpec("TAB_TAG_1"); ts1.setIndicator("Tab1");
		 * ts1.setContent(new TabHost.TabContentFactory() { public View
		 * createTabContent(String tag) { ArrayAdapter<String> adapter = new
		 * ArrayAdapter<String>( JournalActivity.this,
		 * android.R.layout.simple_list_item_1, new String[] { "item1", "item2",
		 * "item3" }); ls1.setAdapter(adapter); return ls1; } });
		 * myTabHost.addTab(ts1);
		 * 
		 * ls2 = new ListView(JournalActivity.this); TabSpec ts2 =
		 * myTabHost.newTabSpec("TAB_TAG_2"); ts2.setIndicator("Tab2");
		 * ts2.setContent(new TabHost.TabContentFactory() { public View
		 * createTabContent(String tag) { ArrayAdapter<String> adapter = new
		 * ArrayAdapter<String>( JournalActivity.this,
		 * android.R.layout.simple_list_item_1, new String[] { "item4", "item5",
		 * "item6" }); ls2.setAdapter(adapter); return ls2; } });
		 * myTabHost.addTab(ts2);
		 */

	}

	
	public View createTabContent(String tag) {
		final TextView tv = new TextView(this);
		tv.setText("Content for tab with tag " + tag);
		return tv;
	}


	public Intent execute(Context context) {
		return new Intent(context, this.getClass());
	}

}
