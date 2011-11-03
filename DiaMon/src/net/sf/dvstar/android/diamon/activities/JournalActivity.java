package net.sf.dvstar.android.diamon.activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.dvstar.android.diamon.R;
import net.sf.dvstar.android.diamon.charts.IDemoChart;
import net.sf.dvstar.android.diamon.journal.BGWeeklyReport;
import net.sf.dvstar.android.diamon.journal.BPWeeklyReport;
import net.sf.dvstar.android.diamon.journal.CarbsWeeklyReport;
import net.sf.dvstar.android.diamon.journal.ExerciseWeeklyReport;
import net.sf.dvstar.android.diamon.journal.HbA1Report;
import net.sf.dvstar.android.diamon.journal.IJournalListItems;
import net.sf.dvstar.android.diamon.journal.InsulinWeeklyReport;
import net.sf.dvstar.android.diamon.journal.JournalDailyReport;
import net.sf.dvstar.android.diamon.journal.MedicationWeeklyReport;
import net.sf.dvstar.android.diamon.journal.WeightReport;
import android.app.ListActivity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

public class JournalActivity extends TabActivity implements TabHost.TabContentFactory  {

	private ListView ls1;
	private ListView ls2;
	private TabHost myTabHost;
	private TabHost mTabHost;

	private IJournalListItems[] mJournals = new IJournalListItems[] {
			new JournalDailyReport(), new BGWeeklyReport(),
			new InsulinWeeklyReport(), new MedicationWeeklyReport(),
			new BPWeeklyReport(), new WeightReport(), new CarbsWeeklyReport(),
			new ExerciseWeeklyReport(), new HbA1Report() };

	private String[] mMenuText;

	private String[] mMenuSummary;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.journal);

		mTabHost = getTabHost();
		mTabHost.setup();
	   
		
		mTabHost.addTab(mTabHost.newTabSpec("tab1")
                .setIndicator("tab1", getResources().getDrawable(R.drawable.star_big_on))
                .setContent(this));
		mTabHost.addTab(mTabHost.newTabSpec("tab2")
                .setIndicator("tab2")
                .setContent(this));
		mTabHost.addTab(mTabHost.newTabSpec("tab3")
                .setIndicator("tab3")
                .setContent(this));
	    
	    mTabHost.setCurrentTab(0);

		
		
/*		
		LayoutInflater inflater=getLayoutInflater();
		View view=inflater.inflate(R.layout.journal, null);
		
		myTabHost = (TabHost) view.findViewById(R.id.tabHostJournal);
		myTabHost.setup();

		ls1 = new ListView(JournalActivity.this);
		TabSpec ts1 = myTabHost.newTabSpec("TAB_TAG_1");
		ts1.setIndicator("Tab1");
		ts1.setContent(new TabHost.TabContentFactory() {
			public View createTabContent(String tag) {
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(
						JournalActivity.this, android.R.layout.simple_list_item_1,
						new String[] { "item1", "item2", "item3" });
				ls1.setAdapter(adapter);
				return ls1;
			}
		});
		myTabHost.addTab(ts1);

		ls2 = new ListView(JournalActivity.this);
		TabSpec ts2 = myTabHost.newTabSpec("TAB_TAG_2");
		ts2.setIndicator("Tab2");
		ts2.setContent(new TabHost.TabContentFactory() {
			public View createTabContent(String tag) {
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(
						JournalActivity.this, android.R.layout.simple_list_item_1,
						new String[] { "item4", "item5", "item6" });
				ls2.setAdapter(adapter);
				return ls2;
			}
		});
		myTabHost.addTab(ts2);
*/
		
		
		/*
		 * 
		 * int length = mJournals.length; mMenuText = new String[length];
		 * mMenuSummary = new String[length]; for (int i = 0; i < length; i++) {
		 * mMenuText[i] = mJournals[i].getName(); mMenuSummary[i] =
		 * mJournals[i].getDesc(); } setListAdapter(new SimpleAdapter(this,
		 * getListValues(), android.R.layout.simple_list_item_2, new String[] {
		 * IDemoChart.NAME, IDemoChart.DESC }, new int[] { android.R.id.text1,
		 * android.R.id.text2 }));
		 */
	}

	private List<Map<String, String>> getListValues() {
		List<Map<String, String>> values = new ArrayList<Map<String, String>>();
		int length = mMenuText.length;
		for (int i = 0; i < length; i++) {
			Map<String, String> v = new HashMap<String, String>();
			v.put(IDemoChart.NAME, mMenuText[i]);
			v.put(IDemoChart.DESC, mMenuSummary[i]);
			values.add(v);
		}
		return values;
	}

	public View createTabContent(String tag) {
        final TextView tv = new TextView(this);
        tv.setText("Content for tab with tag " + tag);
        return tv;
	}

	
//	@Override
//	protected void onListItemClick(ListView l, View v, int position, long id) {
//		super.onListItemClick(l, v, position, id);
//		/*
//		 * Intent intent = null; intent = mCharts[position].execute(this);
//		 * startActivity(intent);
//		 */
//	}
	

}
