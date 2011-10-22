package net.sf.dvstar.android.diamon.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommonDescs {

	public static class InsulinItem{
		public double  time;
		public int     dose;
		public boolean compare(){
			boolean ret = true;
			
			return ret;
		}
	}

	public static class Insulin{
		public String  name;
		public int     dose;
		public double  start;
		public double  max;
		public double  min;
		public double  end;
		
		public ArrayList<InsulinItem> list;
		public Insulin(){
			list = new ArrayList<InsulinItem>();
		}
		
		/**
		 * 
		 * @param dose dose of injection
		 * @param begin time of injection
		 * @return prepared hash
		 */
		public Map getInsulinActivity(int dose, double begin){
			HashMap<?, ?> ret = new HashMap();
			//ret.put(key, value)
			return ret;
		}
		
		public boolean addItem(InsulinItem desc){
			boolean ret = false;
			if(!list.contains(desc)) {list.add(desc); ret = true;}
			return ret;
		} 
		
	}
	
	
}
