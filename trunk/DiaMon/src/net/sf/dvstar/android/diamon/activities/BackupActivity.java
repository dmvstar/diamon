package net.sf.dvstar.android.diamon.activities;

import java.io.File;

import net.sf.dvstar.android.diamon.R;
import net.sf.dvstar.android.diamon.R.id;
import net.sf.dvstar.android.diamon.R.layout;
import net.sf.dvstar.android.diamon.datastore.DBHelper;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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
