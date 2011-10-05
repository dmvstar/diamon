package net.sf.dvstar.android.diamon.datastore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.dvstar.android.diamon.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class CommonData {
	public static class UserDesc {
		public String id;
	    public String name;
	    public byte[] picture;
	    public Bitmap pictureBitmap;
	    
	} 
	public static class HelpBUItem {
		public int id;
		public int kind_of_item; 
		public String description; 
		public String measure_bu; 
		public String measure_wt;
	}
	
	
	public List<Map<String, ?>> createProfileList() {
		String[] profiles = new String[] { "dmvstar@gmail.com",
				"nstarzhynska@gmail.com", "dmvstar@mail.ru" };
		String[] names = new String[] { "Старжинский Дмитрий",
				"Старжинская Наталия", "Старжинский Дмитрий" };

		List<Map<String, ?>> items = new ArrayList<Map<String, ?>>();

		for (int i = 0; i < profiles.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("user_id", profiles[i]);
			map.put("user_name", names[i]);
			items.add(map);
		}

		return items;
	}


	public SimpleAdapter createProfilesSimpleAdapter(final Activity context) {

		final String[] from = new String[] 	{ "user_id", 			"user_name" };
		final int[] to = new int[] 			{ android.R.id.text1, 	android.R.id.text2 };
		
		final SimpleAdapter simpleAdapter = new SimpleAdapter(context,
				createProfileList(),
				R.layout.user_item,
				//android.R.layout.simple_spinner_item,
				// android.R.layout.simple_list_item_1,
				from, to) {

			
			public View getView (int position, View convertView, ViewGroup  parent){ 
				final View view = super.getView(position, convertView, parent);
				
				LayoutInflater inflater=context.getLayoutInflater();
				View row=inflater.inflate(R.layout.user_item, parent, false);
				
				final Map<String, String> data = (Map<String, String>)getItem(position);
				
				TextView label=(TextView)row.findViewById(R.id.user_id);
				label.setText( data.get("user_id") );
				label=(TextView)row.findViewById(R.id.user_name);
				label.setText( data.get("user_name") );
				
				return row;
			}
			
			public View getDropDownView(int position, View convertView,
					ViewGroup parent) {
				View view = super
						.getDropDownView(position, convertView, parent);
				System.out.println( position + " -- "+ view.toString() );
				
				LayoutInflater inflater=context.getLayoutInflater();
				View row=inflater.inflate(R.layout.user_item, parent, false);
				
				final Map<String, String> data = (Map<String, String>)getItem(position);
				
				TextView label=(TextView)row.findViewById(R.id.user_id);
				label.setText( data.get("user_id") );
				label=(TextView)row.findViewById(R.id.user_name);
				label.setText( data.get("user_name") );
				return row;
			}
			
		};
		
		
		return simpleAdapter;
		
	}


	public List<? extends Map<String, ?>> createInsulinList() {
		String[] names 		= new String[] { "Левемир", 	"Новорапид" };
		String[] workFrom 	= new String[] { "1.5", 		"0.5" };
		String[] workTo   	= new String[] { "20", 			"5" };
		String[] maxFrom   	= new String[] { "3", 			"1" };
		String[] maxTo  	= new String[] { "12", 			"4" };
		String[] color 		= new String[] { "#FF00TT", 	"#EE55AA" };

		List<Map<String, ?>> items = new ArrayList<Map<String, ?>>();

		for (int i = 0; i < names.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("InsulinName", 	names[i]);
			map.put("WorkFrom", 	workFrom[i]);
			map.put("WorkTo", 		workTo[i]);
			map.put("MaxFrom", 		maxFrom[i]);
			map.put("MaxTo", 		maxTo[i]);
			map.put("Color", 		color[i]);
			items.add(map);
		}

		return items;
	}

}
