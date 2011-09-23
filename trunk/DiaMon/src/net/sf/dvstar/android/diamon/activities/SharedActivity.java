package net.sf.dvstar.android.diamon.activities;

import net.sf.dvstar.android.diamon.R;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.app.Activity;
import android.content.Intent;

public class SharedActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shared_val);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.array_measur,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(
					//R.layout.insulin_item
					android.R.layout.simple_spinner_dropdown_item
					);
		Spinner s = (Spinner) findViewById(R.id.spinnerMeasure);
		s.setAdapter(adapter);
	}

	
	public void insulinDescActivity(View v) {
		final Intent dialog = new Intent(this, InsulinDescActivity.class);
		this.startActivity(dialog);
	}
}
