package net.sf.dvstar.android.diamon.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.dvstar.android.diamon.common.CommonDescs.InsulinActivity;
import net.sf.dvstar.android.diamon.common.CommonDescs.InsulinItemActivity;

public class CommonDescs {

	public static final String DESC_STRT_WRK = "STRT_WRK";
	public static final String DESC_STRT_MAX = "STRT_MAX";
	public static final String DESC_ENDS_MAX = "ENDS_MAX";
	public static final String DESC_ENDS_WRK = "ENDS_WRK";

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

	public static class Insulin {
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
		private HashMap<String, InsulinItemActivity> insulinItemActivityMapWork;
		private HashMap<String, InsulinItemActivity> insulinItemActivityMapEtalon;
		private InsulinActivity activity;

		public Insulin(String name, InsulinActivity activity) {
			this(name, 0, 0.0, activity);
		}

		public Insulin(String name, int dose, double shift,
				InsulinActivity activity) {
			list = new ArrayList<InsulinItemActivity>();
			this.name = name;
			this.dose = dose;
			this.shift = shift;
			this.activity = activity;
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
			insulinItemActivityMapWork = new HashMap<String, InsulinItemActivity>();
			insulinItemActivityMapEtalon = new HashMap<String, InsulinItemActivity>();

			item = new InsulinItemActivity<Object>(DESC_STRT_WRK,
					activity.start + shift, 0);
			insulinItemActivityMapWork.put(item.getDesc(), item);
			item = new InsulinItemActivity<Object>(DESC_STRT_WRK,
					activity.start, 0);
			insulinItemActivityMapEtalon.put(item.getDesc(), item);

			item = new InsulinItemActivity<Object>(DESC_STRT_MAX, activity.max
					+ shift, dose);
			insulinItemActivityMapWork.put(item.getDesc(), item);
			item = new InsulinItemActivity<Object>(DESC_STRT_MAX, activity.max,
					dose);
			insulinItemActivityMapEtalon.put(item.getDesc(), item);

			item = new InsulinItemActivity<Object>(DESC_ENDS_MAX, activity.min
					+ shift, (int) (dose * activity.degree));
			insulinItemActivityMapWork.put(item.getDesc(), item);
			item = new InsulinItemActivity<Object>(DESC_ENDS_MAX, activity.min,
					(int) (dose * activity.degree));
			insulinItemActivityMapEtalon.put(item.getDesc(), item);

			item = new InsulinItemActivity<Object>(DESC_ENDS_WRK, activity.end
					+ shift, 0);
			insulinItemActivityMapWork.put(item.getDesc(), item);
			item = new InsulinItemActivity<Object>(DESC_ENDS_WRK, activity.end,
					0);
			insulinItemActivityMapEtalon.put(item.getDesc(), item);
		}

		public Map<String, InsulinItemActivity> getInsulinActivityItems() {
			return insulinItemActivityMapWork;
		}

		public List<Double> getInsulinTimeList() {
			List<Double> ret = new ArrayList<Double>();
			ret.add(insulinItemActivityMapWork.get(DESC_STRT_WRK).time);
			ret.add(insulinItemActivityMapWork.get(DESC_STRT_MAX).time);
			ret.add(insulinItemActivityMapWork.get(DESC_ENDS_MAX).time);
			ret.add(insulinItemActivityMapWork.get(DESC_ENDS_WRK).time);
			return ret;
		}

		public List<Integer> getInsulinDoseList() {
			List<Integer> ret = new ArrayList<Integer>();
			ret.add(insulinItemActivityMapWork.get(DESC_STRT_WRK).dose);
			ret.add(insulinItemActivityMapWork.get(DESC_STRT_MAX).dose);
			ret.add(insulinItemActivityMapWork.get(DESC_ENDS_MAX).dose);
			ret.add(insulinItemActivityMapWork.get(DESC_ENDS_WRK).dose);
			return ret;
		}

	}

}
