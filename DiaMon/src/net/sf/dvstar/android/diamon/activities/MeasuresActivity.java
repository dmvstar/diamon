package net.sf.dvstar.android.diamon.activities;

import net.sf.dvstar.android.diamon.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MeasuresActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.measures);
    }    

    
	public void addMeasureGlucoseActivity(View v) {
		//final Intent dialog = new Intent(this, AddMeasureActivity.class);
		//this.startActivity(dialog);
	}
    
	public void addMeasureInsulinActivity(View v) {
		//final Intent dialog = new Intent(this, AddMeasureActivity.class);
		//this.startActivity(dialog);
	}
}
