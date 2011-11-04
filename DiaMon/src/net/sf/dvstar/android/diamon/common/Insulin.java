package net.sf.dvstar.android.diamon.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Describe of insulin works
 * 
 * @author dstarzhynskyi
 * 
 */
public class Insulin {

	public static final String DESC_STRT_WRK = "STRT_WRK";
	public static final String DESC_STRT_MAX = "STRT_MAX";
	public static final String DESC_ENDS_MAX = "ENDS_MAX";
	public static final String DESC_ENDS_WRK = "ENDS_WRK";

	/**
	 * Name of insulin
	 */
	public String name;
	/**
	 * dose in IU
	 */
	public int dose;
	/**
	 * Injection time
	 */
	public double shift;

	public ArrayList<InsulinItemActivity> list;
	private HashMap<String, InsulinItemActivity> insulinItemActivityWork;

	public HashMap<String, InsulinItemActivity> getInsulinItemActivityWork() {
		return insulinItemActivityWork;
	}

	public HashMap<String, InsulinItemActivity> getInsulinItemActivityEtal() {
		return insulinItemActivityEtal;
	}

	private HashMap<String, InsulinItemActivity> insulinItemActivityEtal;
	private InsulinActivity activity;

	public Insulin(String name, InsulinActivity activity) {
		this(name, 0, 0.0, activity);
	}

	public Insulin(String name, int dose, double shift, InsulinActivity activity) {
		list = new ArrayList<InsulinItemActivity>();
		this.name = name;
		this.dose = dose;
		this.shift = shift;
		this.activity = activity;
		createInsulinActivityItems();
	}

	public void setParams(int dose, double shift) {
		this.dose = dose;
		this.shift = shift;
	}

	/**
	 * 
	 * @param dose
	 *            dose of injection
	 * @param shift
	 *            time of injection
	 * @return prepared hash
	 */
	public void createInsulinActivityItems() {
		InsulinItemActivity<Object> item;
		// HashMap<String, InsulinItemActivity>
		insulinItemActivityWork = new HashMap<String, InsulinItemActivity>();
		insulinItemActivityEtal = new HashMap<String, InsulinItemActivity>();

		item = new InsulinItemActivity<Object>(DESC_STRT_WRK, activity.start
				+ shift, 0);
		insulinItemActivityWork.put(item.getDesc(), item);
		item = new InsulinItemActivity<Object>(DESC_STRT_WRK, activity.start, 0);
		insulinItemActivityEtal.put(item.getDesc(), item);

		item = new InsulinItemActivity<Object>(DESC_STRT_MAX, activity.max
				+ shift, dose);
		insulinItemActivityWork.put(item.getDesc(), item);
		item = new InsulinItemActivity<Object>(DESC_STRT_MAX, activity.max,
				dose);
		insulinItemActivityEtal.put(item.getDesc(), item);

		item = new InsulinItemActivity<Object>(DESC_ENDS_MAX, activity.min
				+ shift, (int) (dose * activity.degree));
		insulinItemActivityWork.put(item.getDesc(), item);
		item = new InsulinItemActivity<Object>(DESC_ENDS_MAX, activity.min,
				(int) (dose * activity.degree));
		insulinItemActivityEtal.put(item.getDesc(), item);

		item = new InsulinItemActivity<Object>(DESC_ENDS_WRK, activity.end
				+ shift, 0);
		insulinItemActivityWork.put(item.getDesc(), item);
		item = new InsulinItemActivity<Object>(DESC_ENDS_WRK, activity.end, 0);
		insulinItemActivityEtal.put(item.getDesc(), item);
	}

	public Map<String, InsulinItemActivity> getInsulinActivityItems() {
		return insulinItemActivityWork;
	}

	public List<Double> getInsulinTimeList() {
		List<Double> ret = new ArrayList<Double>();
		ret.add(insulinItemActivityWork.get(DESC_STRT_WRK).time);
		ret.add(insulinItemActivityWork.get(DESC_STRT_MAX).time);
		ret.add(insulinItemActivityWork.get(DESC_ENDS_MAX).time);
		ret.add(insulinItemActivityWork.get(DESC_ENDS_WRK).time);
		return ret;
	}

	public List<Integer> getInsulinDoseList() {
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(insulinItemActivityWork.get(DESC_STRT_WRK).dose);
		ret.add(insulinItemActivityWork.get(DESC_STRT_MAX).dose);
		ret.add(insulinItemActivityWork.get(DESC_ENDS_MAX).dose);
		ret.add(insulinItemActivityWork.get(DESC_ENDS_WRK).dose);
		return ret;
	}

	public String toString() {
		String ret = String.format("{%s} (%2d)(%.02f)[%s][%s]", name, dose,
				shift, getInsulinTimeList(), getInsulinDoseList());
		return ret;
	}

	public static class InsulinActivity {
		/**
		 * Start activity
		 */
		public double start;
		/**
		 * Max activity
		 */
		public double max;
		/**
		 * End max activity
		 */
		public double min;
		/**
		 * End activity
		 */
		public double end;
		/**
		 * Degree of Max activity to End max activity
		 */
		public double degree;

		public InsulinActivity(double start, double max, double min,
				double end, double degree) {
			this.start = start;
			this.max = max;
			this.min = min;
			this.end = end;
			this.degree = degree;
		}

	}

	public static class InsulinItemActivity<T> implements Comparable<T> {
		private String desc;
		private double time;
		private int dose;

		public InsulinItemActivity(String desc, double time, int dose) {
			this.desc = desc;
			this.time = time;
			this.dose = dose;
		}

		public int compareTo(T another) {
			int ret = -1;
			if (this.time < ((InsulinItemActivity<?>) another).time)
				ret = -1;
			if (this.time > ((InsulinItemActivity<?>) another).time)
				ret = 1;
			if (this.time == ((InsulinItemActivity<?>) another).time
					&& this.dose == ((InsulinItemActivity<?>) another).dose)
				ret = 0;

			return ret;
		}

		public String getDesc() {
			// return String.format( "%02f-%02f", time, dose);
			return desc;
		}

		/*
		 * public boolean equals(T another) { boolean ret = false; if( this.time
		 * == ((InsulinItemActivity)another).time && this.dose ==
		 * ((InsulinItemActivity)another).dose ) ret = true; return false; }
		 */

	}

}
