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
import java.util.List;

import net.sf.dvstar.android.diamon.R;

import org.achartengine.ChartFactory;
import org.achartengine.chart.PointStyle;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

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

	private String insulinName;
	private Activity parent;
	private Resources resources;

	public SingleInsulinChart(Activity parent, String insulinName) {
		super();
		this.insulinName = insulinName;
		this.parent = parent;
		this.resources = parent.getResources();
	}

	/**
	 * Returns the chart name.
	 * 
	 * @return the chart name
	 */
	public String getName() {
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

	/**
	 * Executes the chart demo.
	 * 
	 * @param context
	 *            the context
	 * @return the built intent
	 */
	public Intent execute(Context context) {
		String[] titles = new String[] { insulinName, insulinName };
		double[] xRange = new double[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
				15, 16, 17, 18, 19, 20, 21, 22, 23, 24 }; 
		List<double[]> x = new ArrayList<double[]>();
		for (int i = 0; i < titles.length; i++) {
			x.add( xRange );
		}
		List<double[]> values = new ArrayList<double[]>();
		values.add(
				new double[] { 0, 0, 0, 16, 16, 16, 16, 16, 14, 13, 8, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }				
		);
/*		
		values.add( makeInsulinActivity(
						xRange, 
						new double[] { 3, 4,  8,  12 },
						new double[] { 0, 16, 16, 0 }
					)
				  );
*/
		int[] colors = new int[] { Color.BLUE, Color.YELLOW };
		PointStyle[] styles = new PointStyle[] { PointStyle.CIRCLE,
				PointStyle.DIAMOND, PointStyle.TRIANGLE, PointStyle.SQUARE };
		XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer(2);
		setRenderer(renderer, colors, styles);
		int length = renderer.getSeriesRendererCount();
		for (int i = 0; i < length; i++) {
			((XYSeriesRenderer) renderer.getSeriesRendererAt(i))
					.setFillPoints(true);
		}
		setChartSettings(renderer,
				resources.getString(R.string.chart_insulin_title), // "Average temperature",
																	// // title
				resources.getString(R.string.chart_insulin_xtitle),// "Month",
																	// // xTitle
				resources.getString(R.string.chart_insulin_ytitle),// "Temperature",
																	// // yTitle
				0.5, 12.5, 0, 32, Color.LTGRAY, Color.LTGRAY);
		renderer.setXLabels(24);
		renderer.setYLabels(16);
		renderer.setShowGrid(true);
		renderer.setXLabelsAlign(Align.RIGHT);
		renderer.setYLabelsAlign(Align.RIGHT);
		renderer.setZoomButtonsVisible(true);
		renderer.setPanLimits(new double[] { -10, 20, -10, 40 });
		renderer.setZoomLimits(new double[] { -10, 20, -10, 40 });

		renderer.setYTitle("Hours", 1);
		renderer.setYAxisAlign(Align.RIGHT, 1);
		renderer.setYLabelsAlign(Align.LEFT, 1);

		XYMultipleSeriesDataset dataset = buildDataset(titles, x, values);

		values.clear();
		values.add(
				new double[] { 0, 0, 8, 8, 8, 8, 8, 7, 6, 5, 4, 0, 0, 0,
						0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }				
				);
		addXYSeries(dataset, new String[] { "Sunshine hours" }, x, values, 1);

		Intent intent = ChartFactory.getLineChartIntent(context, dataset,
				renderer, getName()
		// "Average temperature"
				);
		return intent;
	}

	private double[] makeInsulinActivity(double xRange[], double[] xValue,
			double[] yValue) {
		double[] ret = new double[xRange.length];

		for(int i=0; i<xRange.length; i++) {
			ret[i] = calcValueAtPosition(i, xRange, xValue, yValue);
		}
		
		return ret;
	}

	/**
	 * 
	 * @param i
	 * @param xRange
	 * @param xValue
	 * @param yValue
	 * @return
	 * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24
	 *       3, 4,          8,            12
	 *       0, 16,         16,           0
	 */
	private double calcValueAtPosition(int pos, double xRange[], double[] xValue, double[] yValue) {
		double ret=0;
		for(int i=0; i<xValue.length; i++){
			
			if(xRange[pos]==xValue[i]){
				ret = yValue[i];
				break;
			} else {
				/*
				 y = k*x + b
				 b = 
				 k = i_max / t_2 - t_1
				 */
				
			}
			
		}
		return ret;
	}
	
	
}
