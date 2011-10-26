package net.sf.dvstar.android.diamon.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CommonDescs {

	public static class InsulinItemActivity<T> implements Comparable<T>{
		public double  time;
		public int     dose;
		
		public int compareTo(T another) {
			int ret = -1;
			if(this.time < ((InsulinItemActivity)another).time ) ret = -1;
			if(this.time > ((InsulinItemActivity)another).time ) ret =  1;
			if(		this.time == ((InsulinItemActivity)another).time && 
					this.dose == ((InsulinItemActivity)another).dose
			   ) ret =  0;
			
			return ret;
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
		public Map getInsulinActivity(int dose, double shift){
			HashMap<Double, Double> ret = new HashMap();
			ret.put(new Double(start+shift), new Double(0.0));
			ret.put(new Double(max  +shift), new Double(dose));
			ret.put(new Double(min  +shift), new Double(dose*degree));
			ret.put(new Double(end  +shift), new Double(0.0));
			return ret;
		}

		public Map getInsulinActivity(){
			return getInsulinActivity(0, 0.0);
		}
		
		
		public boolean addItem(InsulinItemActivity desc){
			boolean ret = false;
			if(!list.contains(desc)) {list.add(desc); ret = true;}
			return ret;
		} 
		
	}
	
	
}
