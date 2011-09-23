package net.sf.dvstar.android.diamon.activities;

import net.sf.dvstar.android.diamon.R;
import net.sf.dvstar.android.diamon.R.array;
import net.sf.dvstar.android.diamon.R.layout;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ConfigActivity extends Activity {

	private final Activity activity = this;        
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config);
    }

    public void foodButtonActivity(View v) {
    	final CharSequence[] items = {"Red", "Green", "Blue"};

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
    			this, R.array.array_food_types, android.R.layout.simple_spinner_item );
    	
    	
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setTitle("Select an item");
    	builder.setSingleChoiceItems(adapter, -1, new DialogInterface.OnClickListener() {
    	    public void onClick(DialogInterface dialog, int item) {
    	        Toast.makeText(getApplicationContext(), adapter.getItem( item ), Toast.LENGTH_SHORT).show();
    	    }
    	});
    	AlertDialog alert = builder.create();
    	alert.show();
    }
    
    public void backupActivity(View v) {
		final Intent about = new Intent(this, BackupActivity.class);
		this.startActivity( about );
    }

    public void sharedValActivity(View v) {
		final Intent about = new Intent(this, SharedActivity.class);
		this.startActivity( about );
    }
    
    
}
