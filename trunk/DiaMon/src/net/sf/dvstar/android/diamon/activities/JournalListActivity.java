package net.sf.dvstar.android.diamon.activities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class JournalListActivity extends ListActivity {

	private IJournalListItems[] mJournals;

	private String[] mMenuText;

	private String[] mMenuSummary;

	private Resources resources;	
	
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		resources = getResources();		
		
		mJournals = new IJournalListItems[] {
				new JournalDailyReport(resources), 
				new InsulinWeeklyReport(resources), 
				new BGWeeklyReport(resources)/*,
				new MedicationWeeklyReport(resources),
				new BPWeeklyReport(resources), 
				new WeightReport(resources), 
				new CarbsWeeklyReport(resources),
				new ExerciseWeeklyReport(resources), 
				new HbA1Report(resources)*/ };		
		
		
		int length = mJournals.length;
		mMenuText = new String[length];
		mMenuSummary = new String[length];
		for (int i = 0; i < length; i++) {
			mMenuText[i] 	= mJournals[i].getName();
			mMenuSummary[i] = mJournals[i].getDesc();
		}
		
		setListAdapter(new SimpleAdapter(this, getListValues(),
				android.R.layout.simple_list_item_2, new String[] {
						IJournalListItems.KEY_NAME, IJournalListItems.KEY_DESC }, new int[] {
						android.R.id.text1, android.R.id.text2 }));

	}

	private List<Map<String, String>> getListValues() {
		List<Map<String, String>> values = new ArrayList<Map<String, String>>();
		int length = mMenuText.length;
		for (int i = 0; i < length; i++) {
			Map<String, String> v = new HashMap<String, String>();
			v.put(IJournalListItems.KEY_NAME, mMenuText[i]);
			v.put(IJournalListItems.KEY_DESC, mMenuSummary[i]);
			values.add(v);
		}
		return values;
	}
	
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		
		Intent intent = null; 
		intent = mJournals[position].execute(this);
		if(intent!=null) startActivity(intent);
		
/*		
		final Intent dialog = new Intent(this, AboutActivity.class);
		this.startActivity(dialog);
*/
//		final Intent dialog = new Intent(this, JournalDailyReport.class);
//		this.startActivity(dialog);
		
//		final Intent intent = new Intent(activity, JournalDailyReport.class);
//		activity.startActivity(intent);
		
		
	}

}
