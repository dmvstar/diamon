/**
 * Copyright (C) 2009, 2010 SC 4ViewSoft SRL
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.sf.dvstar.android.diamon.charts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import net.sf.dvstar.android.diamon.R;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.achartengine.util.MathHelper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint.Align;

/**
 * Multiple temperature demo chart.
 */
public class SingleInsulinChart extends AbstractDemoChart {

	  private static final long HOUR = 3600 * 1000;

	  private static final long DAY = HOUR * 24;

	  private static final int HOURS = 24*2;
	
	
	private String insulinName;
	private Resources resources;

	public SingleInsulinChart(Activity parent, String insulinName) {
		super();
		this.insulinName = insulinName;
		this.resources = parent.getResources();
	}

	/**
	 * Returns the chart name.
	 * 
	 * @return the chart name
	 */
	public String getName() {
		// return "Temperature and sunshine";
		return resources.getString(R.string.chart_insulin_name);
	}

	/**
	 * Returns the chart description.
	 * 
	 * @return the chart description
	 */
	public String getDesc() {
		// return
		// "The average temperature and hours of sunshine in Crete (line chart with multiple Y scales and axis)";
		return resources.getString(R.string.chart_insulin_desc);
	}

	public Intent execute(Context context) {
		String[] titles = new String[] { "NR", "LM", "NR", "LM", "SUM" };
		long now = Math.round(new Date().getTime() / DAY) * DAY;
		List<Date[]>   dateList = new ArrayList<Date[]>();
		for (int i = 0; i < titles.length; i++) {
			Date[] dates = new Date[HOURS];
			for (int j = 0; j < HOURS; j++) {
				dates[j] = new Date(now - (HOURS - j) * HOUR);
			}
			dateList.add(dates);
		}
		List<double[]> timeList = new ArrayList<double[]>();
		for (int i = 0; i < titles.length; i++) {
			double[] dates = new double[HOURS];
			for (int j = 0; j < HOURS; j++) {
				dates[j] = j;
			}
			timeList.add(dates);
		}
		double[] timeRangeBase = new double[HOURS];
		for (int j = 0; j < HOURS; j++) {
			timeRangeBase[j] = j;
		}
				
		List<double[]> values = new ArrayList<double[]>();
/*
		double timeRangeBase[] = new double[] {
			 	 1,  2,  3,  4,  5,  6,  7,  8, 9,  10, 11, 12, 
				13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24
		};
*/		
		double xValueL[] = new double[] {
				2,  4, 10.5, 14
		};
		double yValueL[] = new double[] {
				0, 16,   14,  0
		};
		double xValueLL[] = new double[] {
				2,  4, 10.5, 14
		};
		double yValueLL[] = new double[] {
				0, 12,   10,  0
		};
		double xValueN[] = new double[] {
				0.5,   2,  3,  6
		};
		double yValueN[] = new double[] {
				0,     6,  5,  0
		};
		double xValueNN[] = new double[] {
				0.5,   2,  3,  6
		};
		double yValueNN[] = new double[] {
				0,     4,  3,  0
		};

		
		
		double timeRange[] = null;
		timeRange = makeTimeRange(6, timeRangeBase,xValueN); 
		timeRange = makeTimeRange(7, timeRange,xValueL);
		
		shiftToRange(6, xValueN);
		shiftToRange(7, xValueL);
String sTemp;
		sTemp = Arrays.toString(timeRange);		
		sTemp = Arrays.toString(xValueN);		
		sTemp = Arrays.toString(xValueL);		
		
		shiftToRange(19, xValueNN);
		shiftToRange(23, xValueLL);
		timeRange = makeTimeRange(19, timeRangeBase,xValueN); 
		timeRange = makeTimeRange(23, timeRange,xValueL);
		
		double NR[]   = makeInsulinActivityRange(timeRange, xValueN, yValueN);
		double LN[]   = makeInsulinActivityRange(timeRange, xValueL, yValueL);
		double NRR[]  = makeInsulinActivityRange(timeRange, xValueNN, yValueNN);
		double LNN[]  = makeInsulinActivityRange(timeRange, xValueLL, yValueLL);
		
		ArrayList<double[]> valuesList = new ArrayList<double[]>();
		
		valuesList.add(NR);
		valuesList.add(LN);
		valuesList.add(NRR);
		valuesList.add(LNN);
		
		double SUM[]  = arrraySum( valuesList, timeRange.length );
sTemp = Arrays.toString(SUM);		
		
		values.add( NR ); 
		values.add( LN ); 
		values.add( NRR ); 
		values.add( LNN ); 
		values.add( SUM ); 
		
/*		
		values.add(new double[] { 
				MathHelper.NULL_VALUE, MathHelper.NULL_VALUE, 
				0, 8,  
				16, 16, 16,	16, 16, 16, 8, 6, 4, 2, 0, 
				MathHelper.NULL_VALUE, MathHelper.NULL_VALUE,	
				MathHelper.NULL_VALUE, MathHelper.NULL_VALUE, MathHelper.NULL_VALUE, MathHelper.NULL_VALUE, 
				MathHelper.NULL_VALUE, MathHelper.NULL_VALUE, MathHelper.NULL_VALUE });
		
		values.add(new double[] { 
				MathHelper.NULL_VALUE,  
				0, 4,  
				4, 4, 4,	2, 1, 0, 
				MathHelper.NULL_VALUE, MathHelper.NULL_VALUE, MathHelper.NULL_VALUE, MathHelper.NULL_VALUE, MathHelper.NULL_VALUE, 
				MathHelper.NULL_VALUE, MathHelper.NULL_VALUE, MathHelper.NULL_VALUE,	
				MathHelper.NULL_VALUE, MathHelper.NULL_VALUE, MathHelper.NULL_VALUE, 
				MathHelper.NULL_VALUE, 
				MathHelper.NULL_VALUE, MathHelper.NULL_VALUE, MathHelper.NULL_VALUE });
*/
		int[] colors = new int[] { Color.GREEN, Color.BLUE, Color.GREEN, Color.BLUE, Color.RED };
		PointStyle[] styles = new PointStyle[] { 
				PointStyle.CIRCLE,
				PointStyle.DIAMOND, 
				PointStyle.CIRCLE,
				PointStyle.DIAMOND, 
				PointStyle.TRIANGLE 
				};
		XYMultipleSeriesRenderer renderer = buildRenderer(colors, styles);
		int length = renderer.getSeriesRendererCount();
		for (int i = 0; i < length; i++) {
			((XYSeriesRenderer) renderer.getSeriesRendererAt(i))
					.setFillPoints(true);
		}
		setChartSettings(renderer, 
				resources.getString(R.string.chart_insulin_title), //"Sensor temperature", 
				resources.getString(R.string.chart_insulin_xtitle),//"Hour",
				resources.getString(R.string.chart_insulin_ytitle),//"Celsius degrees",
				timeList.get(0)[0],
				timeList.get(0)[HOURS - 1],
				/*
				x.get(0)[0].getTime(),
				x.get(0)[HOURS - 1].getTime(),
				*/
				-5, 30, Color.LTGRAY,
				Color.LTGRAY);
		renderer.setXLabels(10);
		renderer.setYLabels(10);
		renderer.setShowGrid(true);
		renderer.setXLabelsAlign(Align.CENTER);
		renderer.setYLabelsAlign(Align.RIGHT);
		
		Intent intent = ChartFactory.getTimeChartIntent(context,
				buildDateDataset(titles, dateList, values), renderer, "HH:mm" );// "h:mm a"
		
		/*
		 * x axis points is not correct for time
		 */
		intent = ChartFactory.getCubicLineChartIntent(context, 
				buildBarDataset(titles, values), renderer, 0.5f);

		return intent;
	}

	private void shiftToRange(double shift, double[] xValue) {
		for(int i=0;i<xValue.length;i++) xValue[i]+=shift;
	}

	private double[] makeTimeRange(double shift, double[] timeRangeBase, double[] xValue) {
		double[] ret = new double[timeRangeBase.length + xValue.length];
		System.arraycopy(timeRangeBase, 0, ret, 0, timeRangeBase.length);
		int pos = timeRangeBase.length;
		for(int i=0; i<xValue.length; i++){
			boolean existVal = false;
			double  addVal = xValue[i];
			if(shift>0)addVal+=shift;
			for(int j=0; j<timeRangeBase.length; j++){
				if(timeRangeBase[j] == xValue[i]) {
					existVal = true;
				}
			}
			if(!existVal){
				ret[pos++] = addVal; 
			}
		}
		if(pos>timeRangeBase.length){
			double[] tmp = new double[pos];
			System.arraycopy(ret, 0, tmp, 0, pos);
			ret = tmp;
			Arrays.sort(ret);
		}
		return ret;
	}

	private double[] arrraySum( ArrayList<double[]> valuesList, int maxLen) {
		double[] ret = new double[maxLen];
		for(int l=0;l<ret.length;l++) ret[l]  = MathHelper.NULL_VALUE;
		for(int l=0;l<valuesList.size();l++){
			double[] cur = valuesList.get(l);
			for(int i=0;i<cur.length;i++){
				if(cur[i] != MathHelper.NULL_VALUE && ret[i] != MathHelper.NULL_VALUE) {
					ret[i] += cur[i];
				} else {
					if(cur[i] != MathHelper.NULL_VALUE)
						ret[i]  = cur[i];
				}
			}
		} 
		return ret;
	}

	/**
	 * Make range for time period
	 * @param timeRange from 1-24
	 * @param xValue    time pick value 2  4 10 14
	 * @param yValue    activity value  0 16 16  0
	 * @return array of range by time
	 */
	
	/**
	 * Make range for time period
	 * @param timeRange from 1-24
	 * @param xValue    time pick value 2  4 10 14
	 * @param yValue    activity value  0 16 16  0
	 * @return array of range by time
	 */
	private double[] makeInsulinActivityRange(
			double[] timeRange, 
			double[] xValue,
			double[] yValue) {
			return makeInsulinActivityRange(0,
					timeRange, 
					xValue,
					yValue);
	}		
	private double[] makeInsulinActivityRange(
			double   shiftTime, 
			double[] timeRange, 
			double[] xValue,
			double[] yValue) {
		double[] ret = new double[timeRange.length];

		for (int i = 0; i < timeRange.length; i++) {
			ret[i] = calcValueAtPosition(i, timeRange, xValue, yValue);
		}
/*		
printArray(timeRange);
printArray(xValue);
printArray(yValue);
printArray(ret);
*/
		return ret;
	}

	private void printArray(double[] ret) {
		for(int i=0;i<ret.length;i++){
			System.out.print("["+ret[i]+"]");
		}
		System.out.println();
	}

	/**
	 * 
	 * @param i
	 * @param xRange
	 * @param xValue
	 * @param yValue
	 * @return x 
	 * 		t	1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 ... 24 
	 *      x         3,    5,             10,             14 
	 *      y         0,   16,             16,              0 
	 *                0     1               0               1
	 */
	private double calcValueAtPosition(int pos, double xRange[],
			double[] xValue, double[] yValue) {
		double ret = MathHelper.NULL_VALUE;
		for (int i = 0; i < xValue.length; i++) {

			
			if(xRange[pos] == xValue[i]){
				ret = yValue[i];
				break;
			}	
			
			if (xRange[pos] < xValue[i]) {
				
				if(i>0 && xRange[pos] > xValue[i-1]) {
					if(yValue[i]==yValue[i-1]) {
						ret = yValue[i-1];
						break;
					} else {
						ret = getValueAtPos(xRange[pos], xValue[i-1], yValue[i-1], xValue[i], yValue[i]);
						break;
					}
				}	
			}
		}
//System.out.println("pos["+pos+"] val["+ret+"]");		
		return ret;
	}
	
	/*
	 * y = k*x + b b = k = i_max / t_2 - t_1 y = y_0 + (x -
	 * x_0)/(x_1 - x_0)*(y_1 - y_0)
	 */
	private double getValueAtPos(double x, double x_0, double y_0, double x_1,
			double y_1) {
		double ret = 0;

		ret = y_0 + ((x - x_0) / (x_1 - x_0)) * (y_1 - y_0);

		return ret;
	}

}
