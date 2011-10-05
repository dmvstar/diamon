package net.sf.dvstar.android.diamon.activities;

import java.util.Map;

import net.sf.dvstar.android.diamon.R;
import net.sf.dvstar.android.diamon.datastore.CommonData;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class InsulinDescActivity extends Activity { 

	final String[] from = new String[] 	{ 	"InsulinName", 			
											"WorkFrom" ,	"WorkTo",	
											"MaxFrom",		"MaxTo",	
											"Color"	};
	final int[] to = new int[] 			{ 	android.R.id.text1, 	
											android.R.id.text2, 	android.R.id.text2, 	
											android.R.id.text2, 	android.R.id.text2, 	
											android.R.id.text2, 	android.R.id.text2 };
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.insulin_desc);
		
		CommonData commonData = new CommonData(); 
		
		final SimpleAdapter simpleAdapter = new SimpleAdapter(this,
				commonData.createInsulinList(),
				R.layout.insulin_item,
				from, to) {

			
			public View getView (int position, View convertView, ViewGroup  parent){ 
				final View view = super.getView(position, convertView, parent);
				
				LayoutInflater inflater=getLayoutInflater();
				View row=inflater.inflate(R.layout.insulin_item, parent, false);
				
				final Map<String, String> data = (Map<String, String>)getItem(position);
				
				TextView label=(TextView)row.findViewById(R.id.InsulinName);
				label.setText( data.get("InsulinName") );
				label=(TextView)row.findViewById(R.id.WorkFrom);
				label.setText( data.get("WorkFrom") );
				label=(TextView)row.findViewById(R.id.WorkTo);
				label.setText( data.get("WorkTo") );
				label=(TextView)row.findViewById(R.id.MaxFrom);
				label.setText( data.get("MaxFrom") );
				label=(TextView)row.findViewById(R.id.MaxTo);
				label.setText( data.get("MaxTo") );
				//label=(TextView)row.findViewById(R.id.Color);
				//label.setText( data.get("Color") );
				
				return row;
			}
			
			public View getDropDownView(int position, View convertView,
					ViewGroup parent) {
				View view = super
						.getDropDownView(position, convertView, parent);
				System.out.println( position + " -- "+ view.toString() );
				
				LayoutInflater inflater=getLayoutInflater();
				View row=inflater.inflate(R.layout.insulin_item, parent, false);
				
				
				final Map<String, String> data = (Map<String, String>)getItem(position);
				
				TextView label=(TextView)row.findViewById(R.id.InsulinName);
				label.setText( data.get("InsulinName") );
				label=(TextView)row.findViewById(R.id.WorkFrom);
				label.setText( data.get("WorkFrom") );
				label=(TextView)row.findViewById(R.id.WorkTo);
				label.setText( data.get("WorkTo") );
				label=(TextView)row.findViewById(R.id.MaxFrom);
				label.setText( data.get("MaxFrom") );
				label=(TextView)row.findViewById(R.id.MaxTo);
				label.setText( data.get("MaxTo") );
				//label=(TextView)row.findViewById(R.id.Color);
				//label.setText( data.get("Color") );
				
				return row;
			}
			
		};

		simpleAdapter.setDropDownViewResource(
				android.R.layout.simple_spinner_dropdown_item
				//R.layout.user_item // for this use only ArrayAdapter
				);

		Spinner spinner = (Spinner) findViewById(R.id.spinnerInsulins);

		spinner.setAdapter(simpleAdapter);

		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// Get the color name out of the Map
				final Map<String, String> data = (Map<String, String>) parent
						.getItemAtPosition(position);
				final String text = "Selected Insulin : " + data.get("InsulinName");

				Toast.makeText(parent.getContext(), text, Toast.LENGTH_LONG)
						.show();
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// Do nothing
			}
		});
		
	}	

}
