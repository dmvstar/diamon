package net.sf.dvstar.android.diamon.activities;

import net.sf.dvstar.android.diamon.R;
import net.sf.dvstar.android.diamon.R.array;
import net.sf.dvstar.android.diamon.R.id;
import net.sf.dvstar.android.diamon.R.layout;
import net.sf.dvstar.android.diamon.R.string;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ProfileActivity extends Activity {


    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);
    	builder.setMessage( getString(R.string.exit_confirm))
    	       .setCancelable(false)
    	       .setNeutralButton("Ok", new DialogInterface.OnClickListener() {
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
	
        
    }
	
    
}
