package net.sf.dvstar.android.diamon.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommonDescs {

	public static final String DESC_STRT_WRK = "STRT_WRK";
	public static final String DESC_STRT_MAX = "STRT_MAX";
	public static final String DESC_ENDS_MAX = "ENDS_MAX";
	public static final String DESC_ENDS_WRK = "ENDS_WRK";
	
	public static class InsulinItemActivity<T> implements Comparable<T>{
		private String desc;
		private double  time;
		private int     dose;
		
		public InsulinItemActivity(String desc, double time, int dose){
			this.desc = desc;
			this.time = time;
			this.dose = dose;
		}
		
		public int compareTo(T another) {
			int ret = -1;
			if(this.time < ((InsulinItemActivity<?>)another).time ) ret = -1;
			if(this.time > ((InsulinItemActivity<?>)another).time ) ret =  1;
			if(		this.time == ((InsulinItemActivity<?>)another).time && 
					this.dose == ((InsulinItemActivity<?>)another).dose
			   ) ret =  0;
			
			return ret;
		}
		
		public String getDesc(){
			//return String.format( "%02f-%02f", time, dose);
			return desc;
		}
		
/*
		public boolean equals(T another) {
			boolean ret = false;
			if(
					this.time == ((InsulinItemActivity)another).time && 
					this.dose == ((InsulinItemActivity)another).dose
			   ) ret =  true;
			return false;
		}
*/		
		
	}

	public static class Insulin{
		/**
		 * Name of insulin
		 */
		public String  name;
		/**
		 * dose in IU
		 */
		public int     dose;
		/**
		 * Injection time 
		 */
		public double  shift;
		/**
		 * Start activity
		 */
		public double  start;
		/**
		 * Max activity
		 */
		public double  max;
		/**
		 * End max activity
		 */
		public double  min;
		/**
		 * End activity
		 */
		public double  end;
		/**
		 * Degree of Max activity to End max activity 
		 */
		public double  degree;
		
		public ArrayList<InsulinItemActivity> list;
		
		public Insulin(){
			this(0, 0.0);
		}
		
		public Insulin(int dose, double shift){
			list = new ArrayList<InsulinItemActivity>();
		}
		/**
		 * 
		 * @param dose dose of injection
		 * @param shift time of injection
		 * @return prepared hash
		 */
		public Map<Double, Double> getInsulinActivityMap(int dose, double shift){
			HashMap<Double, Double> ret = new HashMap<Double, Double>();
			ret.put(new Double(start+shift), new Double(0.0));
			ret.put(new Double(max  +shift), new Double(dose));
			ret.put(new Double(min  +shift), new Double(dose*degree));
			ret.put(new Double(end  +shift), new Double(0.0));
			return ret;
		}

		public Map<String, InsulinItemActivity> getInsulinActivityItems(){
			InsulinItemActivity<Object> item;
			HashMap<String, InsulinItemActivity> ret = new HashMap<String, InsulinItemActivity>();
			item = new InsulinItemActivity<Object>(DESC_STRT_WRK, start+shift, 0);
			ret.put(item.getDesc(), item);
			item = new InsulinItemActivity<Object>(DESC_STRT_MAX,max  +shift, dose);
			ret.put(item.getDesc(), item);
			item = new InsulinItemActivity<Object>(DESC_ENDS_MAX,min  +shift, (int)(dose*degree));
			ret.put(item.getDesc(), item);
			item = new InsulinItemActivity<Object>(DESC_ENDS_WRK,end  +shift, 0);
			ret.put(item.getDesc(), item);
			return ret;
		}

/*		
		public boolean addItem(InsulinItemActivity<Object> desc){
			boolean ret = false;
			if(!list.contains(desc)) {list.add(desc); ret = true;}
			return ret;
		} 
*/		
	}
	
	
}
