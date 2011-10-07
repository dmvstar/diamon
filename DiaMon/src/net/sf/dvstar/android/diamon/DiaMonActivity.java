package net.sf.dvstar.android.diamon;

import java.util.Map;

import net.sf.dvstar.android.diamon.activities.AboutActivity;
import net.sf.dvstar.android.diamon.activities.ConfigActivity;
import net.sf.dvstar.android.diamon.activities.HelpAllActivity;
import net.sf.dvstar.android.diamon.activities.JournalActivity;
import net.sf.dvstar.android.diamon.activities.MeasuresActivity;
import net.sf.dvstar.android.diamon.activities.ProfileActivity;
import net.sf.dvstar.android.diamon.activities.StatsActivity;
import net.sf.dvstar.android.diamon.datastore.CommonData;
import net.sf.dvstar.android.diamon.datastore.DBHelper;
import net.sf.dvstar.android.diamon.datastore.HelpBUItemsFiller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class DiaMonActivity extends Activity {
	/** Called when the activity is first created. */

	private Button closeButton;
	
	private final Activity activity = this;
	private DBHelper dbHelper;

	@Override
	public void onBackPressed() {
		// super.onBackPressed();
		selfDestruct(this.getCurrentFocus());
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);

		final String[] from = new String[] 	{ "user_id", 			"user_name" };
		final int[] to = new int[] 			{ android.R.id.text1, 	android.R.id.text2 };

		CommonData commonData = new CommonData(); 

		//commonData.createProfilesSimpleAdapter( this );
		
		final SimpleAdapter simpleAdapter = new SimpleAdapter(this,
				commonData.createProfileList(),
				R.layout.user_item,
				//android.R.layout.simple_spinner_item,
				// android.R.layout.simple_list_item_1,
				from, to) {

			
			public View getView (int position, View convertView, ViewGroup  parent){ 
				final View view = super.getView(position, convertView, parent);
				
				LayoutInflater inflater=getLayoutInflater();
				View row=inflater.inflate(R.layout.user_item, parent, false);
				
				final Map<String, String> data = (Map<String, String>)getItem(position);
				
				TextView label=(TextView)row.findViewById(R.id.user_id);
				label.setText( data.get("user_id") );
				label=(TextView)row.findViewById(R.id.user_name);
				label.setText( data.get("user_name") );
				
/*
				ImageView icon=(ImageView)row.findViewById(R.id.icon);

				if (DayOfWeek[position]=="Sunday"){
				icon.setImageResource(R.drawable.icon);
				}
				else{
				icon.setImageResource(R.drawable.icongray);
				}
*/
				return row;
			}
			
			public View getDropDownView(int position, View convertView,
					ViewGroup parent) {
				View view = super
						.getDropDownView(position, convertView, parent);
				System.out.println( position + " -- "+ view.toString() );
				
				LayoutInflater inflater=getLayoutInflater();
				View row=inflater.inflate(R.layout.user_item, parent, false);
				
				final Map<String, String> data = (Map<String, String>)getItem(position);
				
				TextView label=(TextView)row.findViewById(R.id.user_id);
				label.setText( data.get("user_id") );
				label=(TextView)row.findViewById(R.id.user_name);
				label.setText( data.get("user_name") );
				return row;
			}
			
		};

		simpleAdapter.setDropDownViewResource(
				android.R.layout.simple_spinner_dropdown_item
				//R.layout.user_item // for this use only ArrayAdapter
				);

		/*
		 * simpleAdapter.setViewBinder(new SimpleAdapter.ViewBinder() { public
		 * boolean setViewValue(View view, Object data, String
		 * textRepresentation) { //TextView textView = (TextView)
		 * view.findViewById(R.id.user_id); ((TextView)view).setText((String)
		 * data); return true; } });
		 */

		// Add a ViewBinder to display a color name in a TextView within the
		// Spinner. (This isn't needed in AndroidOS 2.2. In earlier releases,
		// when we're displaying text data within a Spinner, and no ViewBinder
		// is set in the SimpleAdapter, an IllegalStateException is thrown.)

/*		
		SimpleAdapter.ViewBinder viewBinder = new SimpleAdapter.ViewBinder() {

			public boolean setViewValue(View view, Object data,
					String textRepresentation) {
				int vid = view.getId();
				if (vid == R.id.user_id) {
					// We configured the SimpleAdapter to create TextViews (see
					// the 'to' array, above), so this cast should be safe:
					TextView textView = (TextView) view;
					textView.setText(textRepresentation);
					return true;
				}

				return false;
			}
		};
		simpleAdapter.setViewBinder(viewBinder);
*/
		/*
		 * this.closeButton = (Button)this.findViewById(R.id.buttonClose);
		 * this.closeButton.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { finish(); } });
		 */
		Spinner spinner = (Spinner) findViewById(R.id.spinnerProfileList);

		spinner.setAdapter(simpleAdapter);

		// Add an OnItemSelectedListener to display the selected Color
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// Get the color name out of the Map
				final Map<String, String> data = (Map<String, String>) parent
						.getItemAtPosition(position);
				final String text = "Selected Profile: " + data.get("user_name");

				Toast.makeText(parent.getContext(), text, Toast.LENGTH_LONG)
						.show();
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// Do nothing
			}
		});
		
		dbHelper = new DBHelper(this);
		dbHelper.openDataBase();
		
		HelpBUItemsFiller buItems = new HelpBUItemsFiller( dbHelper.getDb() );
		buItems.fillBUItems();

	} // onCreate

	public void selfDestruct(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(getString(R.string.exit_confirm))
				.setCancelable(false)
				.setPositiveButton(R.string.buttonYes, //  "Yes",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								dbHelper.close();
								DiaMonActivity.this.finish();
							}
						})
				.setNegativeButton(R.string.buttonNo, //"No", 
						new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						dialog.cancel();
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}

	public void saveData(View v) {

	}

	public void aboutActivity(View v) {
		final Intent dialog = new Intent(activity, AboutActivity.class);
		activity.startActivity(dialog);
	}

	public void measureActivity(View v) {
		final Intent dialog = new Intent(activity, MeasuresActivity.class);
		activity.startActivity(dialog);
	}

	public void configActivity(View v) {
		final Intent dialog = new Intent(activity, ConfigActivity.class);
		activity.startActivity(dialog);
	}

	public void helpActivity(View v) {
		final Intent dialog = new Intent(activity, HelpAllActivity.class);
		activity.startActivity(dialog);
	}

	public void journalActivity(View v) {
		final Intent intent = new Intent(activity, JournalActivity.class);
		activity.startActivity(intent);
	}

	public void statsActivity(View v) {
		final Intent intent = new Intent(activity, StatsActivity.class);
		activity.startActivity(intent);
	}
	
	
	public void profileActivity(View v) {
		Toast.makeText(getApplicationContext(), "profileActivity Start",
				Toast.LENGTH_LONG).show();
		final Intent profile = new Intent(activity, ProfileActivity.class);
		activity.startActivity(profile);
	}

}