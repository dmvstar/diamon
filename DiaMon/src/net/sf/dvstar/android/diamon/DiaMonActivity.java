package net.sf.dvstar.android.diamon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class DiaMonActivity extends Activity {
    /** Called when the activity is first created. */
	
	private Button closeButton;
	private final Activity activity = this;        
	
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        selfDestruct( this.getCurrentFocus() );
    }
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        
        // The key to use for reading the color from the Map
        final String[] from = new String[] { "color" };
 
        // The type of View to use for displaying the color name.
        // android.R.id.text1 is a standard resource for displaying text.
        final int[] to = new int[] { android.R.id.text1  };
        
        // Create the List of strings for the spinner to display. Each string
        // is embedded within a Map, using "color" as the key.
        final List<Map<String, String>> data =
            new ArrayList<Map<String, String>>();      
    	String[] colors = new String[] { "One", "Two", "Three" };
    	
        for (int i = 0; i < colors.length; i++) {
            data.add(addData(colors[i]));
        }
        
        
        final SimpleAdapter simpleAdapter =
            new SimpleAdapter(this, data,
                    android.R.layout.simple_spinner_item, from, to);
        
        
        simpleAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);


        
     // Add a ViewBinder to display a color name in a TextView within the
        // Spinner. (This isn't needed in AndroidOS 2.2. In earlier releases,
        // when we're displaying text data within a Spinner, and no ViewBinder
        // is set in the SimpleAdapter, an IllegalStateException is thrown.)
/*        
        SimpleAdapter.ViewBinder viewBinder = new SimpleAdapter.ViewBinder() {
 
            public boolean setViewValue(View view, Object data,
                    String textRepresentation) {
                // We configured the SimpleAdapter to create TextViews (see
                // the 'to' array, above), so this cast should be safe:
                TextView textView = (TextView) view;
                textView.setText(textRepresentation);
                return true;
            }
        };
        simpleAdapter.setViewBinder(viewBinder);        
*/
        
/*        
        this.closeButton = (Button)this.findViewById(R.id.buttonClose);
        this.closeButton.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
            finish();
          }
        });
*/        
        Spinner spinner = (Spinner) findViewById(R.id.spinnerProfileList);
        
        spinner.setAdapter(simpleAdapter);
        
        
        // Add an OnItemSelectedListener to display the selected Color
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,
                    int position, long id) {
                // Get the color name out of the Map
                final Map<String, String> data =
                    (Map<String, String>) parent.getItemAtPosition(position);
                final String text = "Selected Color:-  " + data.get("color");
 
                Toast.makeText(parent.getContext(), text,
                        Toast.LENGTH_LONG).show();
            }
 
            public void onNothingSelected(AdapterView<?> arg0) {
                // Do nothing
            }
        });
        
    }

    public void selfDestruct(View v) {
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setMessage( getString(R.string.exit_confirm))
    	       .setCancelable(false)
    	       .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
    	           public void onClick(DialogInterface dialog, int id) {
    	                DiaMonActivity.this.finish();
    	           }
    	       })
    	       .setNegativeButton("No", new DialogInterface.OnClickListener() {
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
		final Intent about = new Intent(activity, AboutActivity.class);
		activity.startActivity( about );
    }
    
    public void configActivity(View v) {
		final Intent config = new Intent(activity, ConfigActivity.class);
		activity.startActivity( config );
    }

    public void helpActivity(View v) {
		final Intent config = new Intent(activity, HelpAllActivity.class);
		activity.startActivity( config );
    }
   
    
    public void profileActivity(View v) {
    	Toast.makeText(getApplicationContext(), "profileActivity Start",
        Toast.LENGTH_LONG).show();
		final Intent profile = new Intent(activity, ProfileActivity.class);
		activity.startActivity( profile );
    }
    
    /**
     * Convert the String that's passed in into a Map, with
     * "color" as the key, and the String as the value.
     * @param    colorName  The color to be inserted into a new Map
     * @return   the new Map
     */
    private Map<String, String> addData(String colorName) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("color", colorName);
        return map;
    }    
}