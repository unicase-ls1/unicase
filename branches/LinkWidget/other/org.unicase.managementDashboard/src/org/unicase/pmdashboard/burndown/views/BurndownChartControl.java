/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.pmdashboard.burndown.views;

import java.awt.Color;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.experimental.chart.swt.ChartComposite;
import org.jfree.ui.RectangleInsets;
import org.unicase.analyzer.exceptions.IteratorException;
import org.unicase.model.ModelElement;
import org.unicase.pmdashboard.burndown.BurndownData;
import org.unicase.pmdashboard.burndown.BurndownDay;
import org.unicase.pmdashboard.burndown.util.BurndownDataGenerator;

/**
 * Composite with a burndown chart in it.
 * 
 * @author andy
 * 
 */
public class BurndownChartControl {

	private static final String ESTIMATESERIES = "Remaining Estimate";
	private static final String OPENTASKSERIES = "Open Tasks";
	private static final String TITLEPREFIX = "Burndown chart for ";
	private static final String XAXISTITLE = "Day";
	private static final String YAXISTITLE = "Work to do";
	private JFreeChart chart;
	private ModelElement modelElement;
	ChartComposite frame;
	private Composite parent;

	public ChartComposite createControl(Composite parent, int style,
			ModelElement modelElement) {
		this.parent = parent;
		this.modelElement = modelElement;
		Composite composite = new Composite(parent, style);
		composite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_BLACK));
//		try {
//			chart = createChart();
//			frame = new ChartComposite(parent, SWT.CENTER, chart, true);
//			return frame;
//		} catch (IteratorException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return null;

	}

	/**
	 * Creates and adds the chart to the composite.
	 * 
	 * @param sprint
	 *            for the burndown chart
	 * @throws IOException
	 * @throws IteratorException
	 */
	private JFreeChart createChart() throws IteratorException, IOException {
		String title = "";
		if (getModelElement() == null) {
			title = "No Modelelement selected";
		} else {
			title = TITLEPREFIX.concat(getModelElement().getName());
		}
		JFreeChart chart = ChartFactory.createTimeSeriesChart(title, // title
				XAXISTITLE, // x-axis label
				YAXISTITLE, // y-axis label
				this.createDataset(), // data
				true, // create legend?
				true, // generate tooltips?
				false // generate URLs?
				);
		chart.setBackgroundPaint(Color.WHITE);

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.LIGHT_GRAY);
		plot.setDomainGridlinePaint(Color.WHITE);
		plot.setRangeGridlinePaint(Color.WHITE);
		plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
		plot.setDomainCrosshairVisible(true);
		plot.setRangeCrosshairVisible(true);

		XYItemRenderer r = plot.getRenderer();
		if (r instanceof XYLineAndShapeRenderer) {
			XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
			renderer.setBaseShapesVisible(true);
			renderer.setBaseShapesFilled(true);
		}

		DateAxis axis = (DateAxis) plot.getDomainAxis();
		axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));

		return chart;
	}

	/**
	 * Creates the chart dataset from the model data. It consists of two time
	 * series.
	 * 
	 * @param sprint
	 * @return
	 * @throws IOException
	 * @throws IteratorException
	 */
	private XYDataset createDataset() throws IteratorException, IOException {
		TimeSeries remainingEstimates = new TimeSeries(ESTIMATESERIES);
		TimeSeries openTasks = new TimeSeries(OPENTASKSERIES);
		TimeSeriesCollection result = new TimeSeriesCollection();
		if (modelElement != null) {
			BurndownDataGenerator generator = BurndownDataGenerator
					.getInstance();
			BurndownData data = generator.getBurndownData(modelElement);

			for (BurndownDay day : data.getDays()) {
				Day chartDay = new Day(day.getDate());
				remainingEstimates.add(chartDay, day.getRemainingEstimate());
				openTasks.add(chartDay, day.getOpenTaskCount());
			}
		}

		result.addSeries(remainingEstimates);
		result.addSeries(openTasks);

		return result;
	}

	public void setModelElement(ModelElement modelElement) {
		this.modelElement = modelElement;
	}

	public ModelElement getModelElement() {
		return modelElement;
	}

}
