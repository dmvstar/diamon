package net.sf.dvstar.android.diamon.activities;

import net.sf.dvstar.android.diamon.R;
import android.app.Activity;
import android.os.Bundle;

public class AddMeasureActivity extends Activity {

	private int mode;

	public AddMeasureActivity(int mode){
		super();
		this.mode = mode;
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_measure);
        setContentValues();
    }

	private void setContentValues() {
		
	}    
	
}
