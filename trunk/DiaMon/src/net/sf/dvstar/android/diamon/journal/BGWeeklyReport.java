package net.sf.dvstar.android.diamon.journal;

import net.sf.dvstar.android.diamon.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;

public class BGWeeklyReport  extends JournalCommonActivity implements IJournalListItems {

	public BGWeeklyReport(){
		super();
	}
	
	public BGWeeklyReport(Resources resources){
		super();
		NAME = resources.getString(R.string.jrn_name_bg_weekly_report);
		DESC = resources.getString(R.string.jrn_desc_bg_weekly_report);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jrn_bg_weekly);
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
