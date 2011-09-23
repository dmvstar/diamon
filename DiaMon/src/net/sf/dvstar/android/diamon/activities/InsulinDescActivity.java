package net.sf.dvstar.android.diamon.activities;

import net.sf.dvstar.android.diamon.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class InsulinDescActivity extends Activity { 

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.insulin_desc);

/*		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.array_measur,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(
					//R.layout.insulin_item
					android.R.layout.simple_spinner_dropdown_item
					);
		Spinner s = (Spinner) findViewById(R.id.spinnerInsulins);
		s.setAdapter(adapter);
*/
		
	}	

}
