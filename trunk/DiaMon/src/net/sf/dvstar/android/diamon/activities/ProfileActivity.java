package net.sf.dvstar.android.diamon.activities;

import java.io.File;

import net.sf.dvstar.android.diamon.R;
import net.sf.dvstar.android.diamon.datastore.CommonData;
import net.sf.dvstar.android.diamon.widgets.filechooser.FileChooser;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ProfileActivity extends Activity {


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setMessage( getString(R.string.close_confirm))
    	       .setCancelable(false)
    	       .setNeutralButton(R.string.buttonOk, //"Ok", 
    	    		   new DialogInterface.OnClickListener() {
    	           public void onClick(DialogInterface dialog, int id) {
    	        	   dialog.cancel();
    	        	   ProfileActivity.this.finish();
    	           }
    	       });
    	AlertDialog alert = builder.create();
    	alert.show();
    	
    	Toast.makeText(getApplicationContext(), "profileActivity Pause",
   	    Toast.LENGTH_LONG).show();
    }
	
/*
@Override
public void onBackPressed() {
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setMessage("Are you sure you want to exit?")
           .setCancelable(false)
           .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int id) {
                    CustomTabActivity.this.finish();
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
 */    
    
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
        			this, R.array.array_sex, android.R.layout.simple_spinner_item );
        			adapter.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        Spinner s = (Spinner) findViewById( R.id.spinnerSex );
		s.setAdapter( adapter );	
	
		CommonData commonData = new CommonData(); 
		SimpleAdapter simpleAdapter = commonData.createProfilesSimpleAdapter(this);
		simpleAdapter.setDropDownViewResource(
				android.R.layout.simple_spinner_dropdown_item
				//R.layout.user_item // for this use only ArrayAdapter
				);

		Spinner spinner = (Spinner) findViewById(R.id.spinnerProfileList);
		spinner.setAdapter(simpleAdapter);
        
    }
	
	private static final int REQUEST_CODE = 11;
    
	public void addProfileAction(View v) {
	}
	public void saveProfileAction(View v) {
	}
	public void delProfileAction(View v) {
	}
	
	
	public void selProfileImageAction(View v) {
    	try {
    		final Intent intent = new Intent( this, net.sf.dvstar.android.diamon.widgets.filechooser.FileChooser.class  );
    		intent.putExtra(FileChooser.PARAMS_FC_ROOT_DIR,    "/mnt");
    		intent.putExtra(FileChooser.PARAMS_FC_WORK_MODE,   FileChooser.SELECT_MODE_ITEM);
    		/**
    		 * TODO  get dir for icon object
    		 */
       		intent.putExtra(FileChooser.PARAMS_FC_WORK_DIR,    "/mnt"); 
       		
    		startActivityForResult(intent, REQUEST_CODE);
    		
    	} catch (ActivityNotFoundException a) {
    		AlertDialog alertDialog = new AlertDialog.Builder( this ).create();
    		alertDialog.setTitle( "Create Dir Picker" );
    		alertDialog.setMessage( "ERROR : com.h3r3t1c.filechooser.FileChooser not found ! \n"+a.getMessage() );
    		alertDialog.setButton( "Yes", new DialogInterface.OnClickListener() {
    				public void onClick(DialogInterface dialog, int which) {
    					Log.d( "AlertDialog", "ERROR : ocom.h3r3t1c.filechooser.FileChooser not found !" );
    				}
    			} );
    		alertDialog.show();
    	}
    	
	}

    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
			if (data.hasExtra(FileChooser.RESULT_KEY_SELECTED_ITEM)) {
				
				TextView text = (TextView) findViewById(R.id.textViewProfileIconPath);
				if(text != null) {					
					text.setText( data.getExtras().getString(FileChooser.RESULT_KEY_SELECTED_DIR)+"/"+data.getExtras().getString(FileChooser.RESULT_KEY_SELECTED_ITEM));
				}
				
				Toast.makeText(this, 
						data.getExtras().getString(FileChooser.RESULT_KEY_SELECTED_DIR) +
						" -- " +
						data.getExtras().getString(FileChooser.RESULT_KEY_SELECTED_ITEM),
						Toast.LENGTH_SHORT).show();
			}
		}
	}
	
	
    
    
}
