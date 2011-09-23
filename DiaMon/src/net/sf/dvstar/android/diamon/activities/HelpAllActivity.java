package net.sf.dvstar.android.diamon.activities;

import net.sf.dvstar.android.diamon.R;
import net.sf.dvstar.android.diamon.R.layout;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HelpAllActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.help_all);
    }	

    
    public void aboutActivity(View v) {
		final Intent about = new Intent(this, AboutActivity.class);
		this.startActivity( about );
    }
    
    public void aboutHelpBUActivity(View v) {
		final Intent helpBU = new Intent(this, HelpBUActivity.class);
		this.startActivity( helpBU );
    }
    
}
