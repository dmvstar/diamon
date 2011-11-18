package net.sf.dvstar.android.diamon.activities;

import java.io.File;

import net.sf.dvstar.android.diamon.R;
import net.sf.dvstar.android.diamon.datastore.DBHelper;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BackupActivity extends Activity {
    private static final String PREFS_NAME = "DiaMonPrefs";
	/** Called when the activity is first created. */
	
	private Button closeButton;
	private final Activity activity = this;        
	
    @Override
    public void onBackPressed() {
    	super.onBackPressed();
    }
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.backup);
        EditText text = null;
        
        // Restore preferences
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String silent = settings.getString("lastStoragePath", "none");
        text = (EditText) findViewById(R.id.editTextLastStoragePath);
        text.setText( silent );
        
        File fb = Environment.getExternalStorageDirectory();
        text = (EditText) findViewById(R.id.editTextStoragePath);
        text.setText( fb.getPath() );

        text = (EditText) findViewById(R.id.editTextDataDirectory);
        text.setText( Environment.getDataDirectory().getPath() );
        
        DBHelper dbhelper = new DBHelper(this);
        
        text = (EditText) findViewById(R.id.editTextDBPath);
        text.setText( dbhelper.getReadableDatabase().getPath() );
        
        text = (EditText) findViewById(R.id.editTextAppName);
        text.setText( getPackageName() );

        String dbSDPath = Environment.getExternalStorageDirectory().getPath()+"/Android/data/"+getPackageName()+"/databases/"+"diamod.db";
        text = (EditText) findViewById(R.id.editTextDBSDPath);
        text.setText( dbSDPath );
        
    }    

    public void dirChooser(View view){
    	try {
    		//final Intent dialog = new Intent(activity, AndroidFileBrowser.class);
    		//activity.startActivity(dialog);
    		final Intent intent = new Intent("org.openintents.action.PICK_FILE");
    		startActivityForResult(intent, 1);
    	} catch (ActivityNotFoundException a) {
    		AlertDialog alertDialog = new AlertDialog.Builder( this ).create();
    		alertDialog.setTitle( "Create Dir Picker" );
    		alertDialog.setMessage( "ERROR : org.openintents.action.PICK_FILE not found, install then from market ! "+a.getMessage() );
    		alertDialog.setButton( "Yes", new DialogInterface.OnClickListener() {
    				public void onClick(DialogInterface dialog, int which) {
    					Log.d( "AlertDialog", "ERROR : org.openintents.action.PICK_FILE not found, install 'OI File Manager' from the market !" );
    				}
    			} );
    		alertDialog.show();
    	}

    	try {
    		final Intent intent = new Intent( this, com.h3r3t1c.filechooser.FileChooser.class  );
    		startActivityForResult(intent, 1);
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
    protected void onStop(){
      EditText text = null;
    
      // Save user preferences. We need an Editor object to
      // make changes. All objects are from android.context.Context
      SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
      SharedPreferences.Editor editor = settings.edit();
      text = (EditText) findViewById(R.id.editTextLastStoragePath);
      editor.putString("lastStoragePath", text.getText().toString());

      // Don't forget to commit your edits!!!
      editor.commit();
      super.onStop();
    }    
    
    
}
