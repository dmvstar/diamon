package net.sf.dvstar.android.diamon;

import java.io.File;

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