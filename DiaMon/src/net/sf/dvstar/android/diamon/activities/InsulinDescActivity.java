package net.sf.dvstar.android.diamon.activities;

import java.util.Map;

//import de.devmil.common.ui.color.ColorSelectorDialog;

import net.sf.dvstar.android.diamon.R;
import net.sf.dvstar.android.diamon.datastore.CommonData;
import net.sf.dvstar.android.diamon.datastore.DBHelper;
import net.sf.dvstar.android.diamon.widgets.color.ColorSelectorDialog;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class InsulinDescActivity extends Activity {

	DBHelper dbHelper;
	
	final String[] from = new String[] { "insulinName", "workFrom", "workTo",
			"maxFrom", "maxTo", "color" };
	final int[] to = new int[] { android.R.id.text1, android.R.id.text2,
			android.R.id.text2, android.R.id.text2, android.R.id.text2,
			android.R.id.text2, android.R.id.text2 };

	EditText editTextInsulinName, editTextInsulinFrom, editTextInsulinTo,
			editTextInsulinMaxFrom, editTextInsulinMaxTo, editTextInsulinColor;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.insulin_desc);

		editTextInsulinName = (EditText) findViewById(R.id.editTextInsulinName);
		editTextInsulinFrom = (EditText) findViewById(R.id.editTextInsulinFrom);
		editTextInsulinTo = (EditText) findViewById(R.id.editTextInsulinTo);
		editTextInsulinMaxFrom = (EditText) findViewById(R.id.editTextInsulinMaxFrom);
		editTextInsulinMaxTo = (EditText) findViewById(R.id.editTextInsulinMaxTo);
		editTextInsulinColor = (EditText) findViewById(R.id.editTextInsulinColor);

		CommonData commonData = new CommonData();
		dbHelper = new DBHelper(this);

		final CursorAdapter cursorAdapter = new CursorAdapter(this, dbHelper
				.getAlInsulins()) {

			/*
			 * public CursorAdapter(Context context, Cursor c){ super(context,
			 * c); View v = inflater.inflate(R.layout.insulin_desc, parent,
			 * false); }
			 */
			@Override
			public View newView(Context context, Cursor cursor, ViewGroup parent) {
				LayoutInflater inflater = LayoutInflater.from(context);
				View v = inflater.inflate(R.layout.insulin_desc, parent, false);
				bindView(v, context, cursor);
				return v;
			}

			@Override
			public void bindView(View view, Context context, Cursor cursor) {
				TextView summary = (TextView) view
						.findViewById(R.id.editTextInsulinName);
				summary.setText(cursor.getString(cursor
						.getColumnIndex(DBHelper.KEY_INSULIN_DESC)));
			}

			public View getView(int position, View convertView, ViewGroup parent) {
				final View view = super.getView(position, convertView, parent);
				Cursor cursor = getCursor();
				int count = cursor.getCount();
				
				LayoutInflater inflater = getLayoutInflater();
				View row = inflater.inflate(R.layout.insulin_item, parent,
						false);

				cursor.move(position);
				
				TextView label = (TextView) row.findViewById(R.id.InsulinName);
				String text = cursor.getString(  cursor.getColumnIndex(  DBHelper.KEY_INSULIN_DESC ) );
				label.setText( text );

				return row;
			}

			public View getDropDownView(int position, View convertView,
					ViewGroup parent) {
				View view = super
						.getDropDownView(position, convertView, parent);
				System.out.println(position + " -- " + view.toString());

				LayoutInflater inflater = getLayoutInflater();
				View row = inflater.inflate(R.layout.insulin_item, parent,
						false);

				final Map<String, String> data = (Map<String, String>) getItem(position);

				TextView label = (TextView) row.findViewById(R.id.InsulinName);
				label.setText(data.get("insulinName"));
				label = (TextView) row.findViewById(R.id.WorkFrom);
				label.setText(data.get("workFrom"));
				label = (TextView) row.findViewById(R.id.WorkTo);
				label.setText(data.get("workTo"));
				label = (TextView) row.findViewById(R.id.MaxFrom);
				label.setText(data.get("maxFrom"));
				label = (TextView) row.findViewById(R.id.MaxTo);
				label.setText(data.get("maxTo"));
				// label=(TextView)row.findViewById(R.id.Color);
				// label.setText( data.get("Color") );

				return row;
			}

		};

		final SimpleAdapter simpleAdapter = new SimpleAdapter(this, commonData
				.createInsulinList(), R.layout.insulin_item, from, to) {

			public View getView(int position, View convertView, ViewGroup parent) {
				final View view = super.getView(position, convertView, parent);

				LayoutInflater inflater = getLayoutInflater();
				View row = inflater.inflate(R.layout.insulin_item, parent,
						false);

				final Map<String, String> data = (Map<String, String>) getItem(position);

				TextView label = (TextView) row.findViewById(R.id.InsulinName);
				label.setText(data.get("insulinName"));
				label = (TextView) row.findViewById(R.id.WorkFrom);
				label.setText(data.get("workFrom"));
				label = (TextView) row.findViewById(R.id.WorkTo);
				label.setText(data.get("workTo"));
				label = (TextView) row.findViewById(R.id.MaxFrom);
				label.setText(data.get("maxFrom"));
				label = (TextView) row.findViewById(R.id.MaxTo);
				label.setText(data.get("maxTo"));
				// label=(TextView)row.findViewById(R.id.Color);
				// label.setText( data.get("Color") );

				return row;
			}

			public View getDropDownView(int position, View convertView,
					ViewGroup parent) {
				View view = super
						.getDropDownView(position, convertView, parent);
				System.out.println(position + " -- " + view.toString());

				LayoutInflater inflater = getLayoutInflater();
				View row = inflater.inflate(R.layout.insulin_item, parent,
						false);

				final Map<String, String> data = (Map<String, String>) getItem(position);

				TextView label = (TextView) row.findViewById(R.id.InsulinName);
				label.setText(data.get("insulinName"));
				label = (TextView) row.findViewById(R.id.WorkFrom);
				label.setText(data.get("workFrom"));
				label = (TextView) row.findViewById(R.id.WorkTo);
				label.setText(data.get("workTo"));
				label = (TextView) row.findViewById(R.id.MaxFrom);
				label.setText(data.get("maxFrom"));
				label = (TextView) row.findViewById(R.id.MaxTo);
				label.setText(data.get("maxTo"));
				// label=(TextView)row.findViewById(R.id.Color);
				// label.setText( data.get("Color") );

				return row;
			}

		};

		simpleAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item
				// R.layout.user_item // for this use only ArrayAdapter
				);

		Spinner spinner = (Spinner) findViewById(R.id.spinnerInsulins);

		//spinner.setAdapter(simpleAdapter);
		spinner.setAdapter(cursorAdapter);

		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			/*
			 * public OnItemSelectedListener(){ super(); }
			 */
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// Get the color name out of the Map
/*				
				final Map<String, String> data = (Map<String, String>) parent
						.getItemAtPosition(position);

				final String text = "Selected Insulin : "
						+ data.get("insulinName");

				Toast.makeText(parent.getContext(), text, Toast.LENGTH_LONG)
						.show();

				LayoutInflater inflater = getLayoutInflater();
				View row = inflater.inflate(R.layout.insulin_desc, parent,
						false);

				editTextInsulinName.setText(data.get("insulinName"));
				editTextInsulinFrom.setText(data.get("workFrom"));
				editTextInsulinTo.setText(data.get("workTo"));
				editTextInsulinMaxFrom.setText(data.get("maxFrom"));
				editTextInsulinMaxTo.setText(data.get("maxTo"));
				editTextInsulinColor.setText(data.get("color"));
*/
			}

			public void onNothingSelected(AdapterView<?> arg0) {
				// Do nothing
			}
		});

	}

	public void selectColor(View v) {
		// ColorSelectorDialog dialog = new ColorSelectorDialog(this,null,0);
		// dialog.show();
	}

	public void addInsulin(View v) {
		dbHelper.insertInsulin(editTextInsulinName.getText().toString());
	}
	
	public void delInsulin(View v) {
		//dbHelper.deleteInsulin(rowId);
	}
	
	
}
