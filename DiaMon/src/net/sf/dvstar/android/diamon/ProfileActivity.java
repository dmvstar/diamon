package net.sf.dvstar.android.diamon;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class ProfileActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
        			this, R.array.array_sex, android.R.layout.simple_spinner_item );
        			adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        Spinner s = (Spinner) findViewById( R.id.spinnerSex );
		s.setAdapter( adapter );	
		
		adapter = ArrayAdapter.createFromResource(
    			this, R.array.array_measur, android.R.layout.simple_spinner_item );
    			adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
    	s = (Spinner) findViewById( R.id.spinnerMeasure );
    	s.setAdapter( adapter );	
		
        
    }
	
}
