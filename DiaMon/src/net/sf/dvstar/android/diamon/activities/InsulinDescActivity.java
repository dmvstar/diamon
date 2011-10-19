package net.sf.dvstar.android.diamon.activities;

import java.util.Map;

//import de.devmil.common.ui.color.ColorSelectorDialog;

import net.sf.dvstar.android.diamon.R;
import net.sf.dvstar.android.diamon.charts.SingleInsulinChart;
import net.sf.dvstar.android.diamon.datastore.CommonData;
import net.sf.dvstar.android.diamon.datastore.DBConst;
import net.sf.dvstar.android.diamon.datastore.DBHelper;
import net.sf.dvstar.android.diamon.widgets.color.ColorSelectorDialog;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class InsulinDescActivity extends Activity implements DBConst {

	DBHelper dbHelper;

	final String[] from = new String[] { "insulinName", "workFrom", "workTo",
			"maxFrom", "maxTo", "color" };
	final String[] from_cur = new String[] { KEY_INSULIN_DESC,
			KEY_INSULIN_TSTRT, KEY_INSULIN_TEND, KEY_INSULIN_TMAX,
			KEY_INSULIN_TWRK, KEY_INSULIN_COLOR };
	final int[] to = new int[] { android.R.id.text1, android.R.id.text2,
			android.R.id.text2, android.R.id.text2, android.R.id.text2,
			android.R.id.text2, android.R.id.text2 };

	EditText editTextInsulinName, editTextInsulinFrom, editTextInsulinTo,
			editTextInsulinMaxFrom, editTextInsulinMaxTo, editTextInsulinColor;

	private Cursor insulinCursor;

	private Spinner spinner;

	private SimpleCursorAdapter cursorAdapter;
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		//if(insulinCursor!=null)	insulinCursor.close();
	}
	
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
		
		insulinCursor = dbHelper.getAlInsulins();
		startManagingCursor(insulinCursor);
		
		cursorAdapter = new SimpleCursorAdapter(this,
				R.layout.insulin_item, insulinCursor, from_cur, to) {

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
				String text = cursor.getString(cursor
						.getColumnIndex(DBHelper.KEY_INSULIN_DESC));
				//summary.setText( text );
				//Log.d("DB", "bindView(["+text+"]["+summary.getId()+"])");
			}

			public View getView(int position, View convertView, ViewGroup parent) {
				final View view = super.getView(position, convertView, parent);
				Cursor cursor = getCursor();
				int count = cursor.getCount();

				Log.d("DB", "cursor(["+cursor.getCount()+"]["+cursor.getColumnCount()+"]) to ("+position+")");
				
				LayoutInflater inflater = getLayoutInflater();
				View row = inflater.inflate(R.layout.insulin_item, parent,
						false);

				//cursor.move(position);

				TextView label = (TextView) row.findViewById(R.id.InsulinName);
				String text = cursor.getString(cursor
						.getColumnIndex(KEY_INSULIN_DESC));
				label.setText(text);
				Log.d("DB", "text ["+text+"]");

				text = cursor.getString(cursor.getColumnIndex(KEY_INSULIN_TSTRT));
				label = (TextView) row.findViewById(R.id.WorkFrom);
				label.setText(text);
				text = cursor.getString(cursor.getColumnIndex(KEY_INSULIN_TEND));
				label = (TextView) row.findViewById(R.id.WorkTo);
				label.setText(text);
				text = cursor.getString(cursor.getColumnIndex(KEY_INSULIN_TMAX));
				label = (TextView) row.findViewById(R.id.MaxFrom);
				label.setText(text);
				text = cursor.getString(cursor.getColumnIndex(KEY_INSULIN_TWRK));
				label = (TextView) row.findViewById(R.id.MaxTo);
				label.setText(text);
				
				return row;
			}

			public View getDropDownView(int position, View convertView,
					ViewGroup parent) {
				View view = super
						.getDropDownView(position, convertView, parent);
				System.out.println(position + " -- " + view.toString());
				Cursor cursor = getCursor();

				LayoutInflater inflater = getLayoutInflater();
				View row = inflater.inflate(R.layout.insulin_item, parent,
						false);

				Log.d("DB", "cursor(["+cursor.getCount()+"]["+cursor.getColumnCount()+"]) to ("+position+")");
				
				TextView label = (TextView) row.findViewById(R.id.InsulinName);
				
				String text = cursor.getString(cursor
						.getColumnIndex(KEY_INSULIN_DESC));
				label.setText(text);

				text = cursor.getString(cursor.getColumnIndex(KEY_INSULIN_TSTRT));
				label = (TextView) row.findViewById(R.id.WorkFrom);
				label.setText(text);
				text = cursor.getString(cursor.getColumnIndex(KEY_INSULIN_TEND));
				label = (TextView) row.findViewById(R.id.WorkTo);
				label.setText(text);
				text = cursor.getString(cursor.getColumnIndex(KEY_INSULIN_TMAX));
				label = (TextView) row.findViewById(R.id.MaxFrom);
				label.setText(text);
				text = cursor.getString(cursor.getColumnIndex(KEY_INSULIN_TWRK));
				label = (TextView) row.findViewById(R.id.MaxTo);
				label.setText(text);
				
				// label=(TextView)row.findViewById(R.id.Color);
				// label.setText( data.get("Color") );

				return row;
			}

		};

		final SimpleAdapter simpleAdapter = new SimpleAdapter(this,
				commonData.createInsulinList(), R.layout.insulin_item, from, to) {

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
		cursorAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item
				// R.layout.user_item // for this use only ArrayAdapter
				);

		spinner = (Spinner) findViewById(R.id.spinnerInsulins);

		// spinner.setAdapter(simpleAdapter);
		spinner.setAdapter(cursorAdapter);

		spinner.setOnItemSelectedListener(new InsulinOnItemSelectedListener() );
		//spinner.setOnItemSelectedListener(new DataOnItemSelectedListener());

	}

	public void addInsulin(View v) {
		dbHelper.insertInsulin(
				editTextInsulinName.getText().toString(),
				editTextInsulinFrom.getText().toString(),
				editTextInsulinTo.getText().toString(),
				editTextInsulinMaxFrom.getText().toString(),
				editTextInsulinMaxTo.getText().toString(),
				editTextInsulinColor.getText().toString()
				);
		cursorAdapter.notifyDataSetChanged();
		insulinCursor = dbHelper.getAlInsulins(); 
		cursorAdapter.changeCursor( insulinCursor );
	}

	public void delInsulin(View v) {
		int rowId = insulinCursor.getInt(0);
		Log.d("DB", "cursor ["+insulinCursor.getPosition()+"]["+rowId+"]");
		dbHelper.deleteInsulin( rowId );
		cursorAdapter.notifyDataSetChanged();
		insulinCursor = dbHelper.getAlInsulins(); 
		cursorAdapter.changeCursor( insulinCursor );
	}

	public void saveInsulin(View v) {
		int rowId = insulinCursor.getInt(0);
		dbHelper.updateInsulin(
				rowId,
				editTextInsulinName.getText().toString(),
				editTextInsulinFrom.getText().toString(),
				editTextInsulinTo.getText().toString(),
				editTextInsulinMaxFrom.getText().toString(),
				editTextInsulinMaxTo.getText().toString(),
				editTextInsulinColor.getText().toString()
				);
		cursorAdapter.notifyDataSetChanged();
		spinner.invalidate();
		insulinCursor.requery();
	}

	/**
	 * View line diagram of selected insulin 
	 * @param v
	 * Resources res = getResources();
	 * String text = String.format(res.getString(R.string.welcome_messages), username, mailCount);
	 */
	public void viewDiagram(View v) {
		
		Object o = spinner.getSelectedItem();
		if(o!=null){
			
		}
		
		SingleInsulinChart chart = new SingleInsulinChart(this, "insulin name");
	    Intent intent = null;
	    intent = chart.execute(this);
	    startActivity(intent);
	}
	
	public void selectColor(View v) {
		ColorSelectorDialog dialog = new ColorSelectorDialog(this,null,0);
		dialog.show();
	}

	
	class InsulinOnItemSelectedListener implements OnItemSelectedListener {

		public InsulinOnItemSelectedListener(){
		}
		
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			
			Log.d("DB", "cursor(["+insulinCursor.getCount()+"]["+insulinCursor.getColumnCount()+"]) to ("+position+")("+insulinCursor.getPosition()+")");

			TextView label = (TextView) findViewById(R.id.InsulinName);
			String text = insulinCursor.getString(insulinCursor
					.getColumnIndex(KEY_INSULIN_DESC));
			label.setText(text);
			editTextInsulinName.setText( text );
			
			text = insulinCursor.getString(insulinCursor.getColumnIndex(KEY_INSULIN_TSTRT));
			editTextInsulinFrom.setText( text );
			text = insulinCursor.getString(insulinCursor.getColumnIndex(KEY_INSULIN_TEND));
			editTextInsulinTo.setText( text );
			text = insulinCursor.getString(insulinCursor.getColumnIndex(KEY_INSULIN_TMAX));
			editTextInsulinMaxFrom.setText( text );
			text = insulinCursor.getString(insulinCursor.getColumnIndex(KEY_INSULIN_TWRK));
			editTextInsulinMaxTo.setText( text );
			text = insulinCursor.getString(insulinCursor.getColumnIndex(KEY_INSULIN_COLOR));
			editTextInsulinColor.setText( text );
			
		}

		public void onNothingSelected(AdapterView<?> parent) {
		}
		
	}
	
	
	class DataOnItemSelectedListener implements OnItemSelectedListener {
		/*
		 * public OnItemSelectedListener(){ super(); }
		 */
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			  // Get the color name out of the Map
			
			  final Map<String, String> data = (Map<String, String>) parent
			 .getItemAtPosition(position);
			  
			  final String text = "Selected Insulin : " +
			  data.get("insulinName");
			  
			  Toast.makeText(parent.getContext(), text, Toast.LENGTH_LONG)
			  .show();
			  
			  LayoutInflater inflater = getLayoutInflater(); View row =
			  inflater.inflate(R.layout.insulin_desc, parent, false);
			  
			  editTextInsulinName.setText(data.get("insulinName"));
			  editTextInsulinFrom.setText(data.get("workFrom"));
			  editTextInsulinTo.setText(data.get("workTo"));
			  editTextInsulinMaxFrom.setText(data.get("maxFrom"));
			  editTextInsulinMaxTo.setText(data.get("maxTo"));
			  editTextInsulinColor.setText(data.get("color"));
			 
			
		}

		public void onNothingSelected(AdapterView<?> arg0) {
			// Do nothing
		}
	}

	
}
