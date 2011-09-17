package net.sf.dvstar.android.diamon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

public class HelpBUActivity  extends Activity {
	
	
    @Override
    public void onBackPressed() {
    	super.onBackPressed();
    }
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_bu);
        setTitle( getString( R.string.bu_items_array_title) );

/*        
        SimpleAdapter adapter = new SimpleAdapter(this, createSensorsList(), android.R.layout.simple_list_item_2, 
                new String[] {"title", "count", "weight"}, 
                new int[] {android.R.id.text1, android.R.id.text2, android.R.id.text2});
            
        ListView lv = (ListView)findViewById(R.id.listviewBU);
        lv.setAdapter(adapter);
  */          
            
            
        SimpleAdapter adapter = new SimpleAdapter(this, createSensorsList(), R.layout.bu_item_layout,
                				new String[] {"title", "count", "weight"}, 
        						new int[] {R.id.title, R.id.count, R.id.weight});
        ListView lv = (ListView)findViewById(R.id.listviewBU);
        lv.setAdapter(adapter);            
/*            
        ListView list = (ListView) findViewById(R.id.listviewBU );
        
        String[] countries = getResources().getStringArray(R.array.bu_items_array);
        list.setAdapter(new ArrayAdapter<String>(this, R.layout.help, countries));
*/       
    }
    
    
    private List<Map<String, ?>> createSensorsList()
    {
        String[] countries = getResources().getStringArray(R.array.bu_items_array);
        
        List<Map<String, ?>> items = new ArrayList<Map<String, ?>>();
        
        for (int i=0; i<countries.length;i++ )
        {
            Map<String, Object> map = new HashMap<String, Object>();
            StringTokenizer tok = new StringTokenizer(countries[i],"|");
            map.put("title",  tok.nextElement());
            String count = tok.nextElement().toString();
            map.put("count",  count);
            map.put("weight", tok.nextElement());
            items.add(map);
        }
        
        return items;
    }    

}
