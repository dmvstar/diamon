package net.sf.dvstar.android.diamon.activities;

import net.sf.dvstar.android.diamon.R;
import net.sf.dvstar.android.diamon.R.layout;
import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TextView;

public class AboutActivity extends TabActivity implements TabHost.TabContentFactory{

    private TabHost mTabHost;

	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        
        
    	mTabHost = getTabHost();
		mTabHost.setup();

		mTabHost.addTab(mTabHost
				.newTabSpec("About")
				.setIndicator("About",
						getResources().getDrawable(R.drawable.star_big_on))
				.setContent(this));
		mTabHost.addTab(mTabHost.newTabSpec("Authors").setIndicator("Authors")
				.setContent(this));
		mTabHost.addTab(mTabHost.newTabSpec("Thanks").setIndicator("Thanks")
				.setContent(this));
		mTabHost.addTab(mTabHost.newTabSpec("License").setIndicator("License")
				.setContent(this));
		mTabHost.addTab(mTabHost.newTabSpec("Translate").setIndicator("Translate")
				.setContent(this));

		mTabHost.setCurrentTab(0);
        
    }
	
	
	public View createTabContent(String tag) {
		final TextView tv = new TextView(this);
		tv.setText("Content for tab with tag " + tag);
		return tv;
	}
	
	
	
}
