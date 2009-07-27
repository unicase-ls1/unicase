/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.pmdashboard.burndown.views;

import java.awt.Color;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
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
import org.unicase.model.task.WorkPackage;
import org.unicase.pmdashboard.burndown.BurndownData;
import org.unicase.pmdashboard.burndown.BurndownDay;
import org.unicase.pmdashboard.burndown.util.BurndownDataGenerator;

/**
 * Composite with a burndown chart in it.
 * @author andy
 *
 */
public class BurndownChartComposite extends Composite {
	
	private static final String ESTIMATESERIES = "Remaining Estimate";
	private static final String OPENTASKSERIES = "Open Tasks";
	private static final String TITLEPREFIX = "Burndown chart for "; 
	private static final String XAXISTITLE = "Day";
	private static final String YAXISTITLE = "Work to do";

	/**
	 * Constructs a composite with the chart in it.
	 * @param sprint the chart should be generated for
	 * @param parent where this composite should be integrated
	 */
	BurndownChartComposite(WorkPackage sprint, Composite parent) {
		super(parent, 0);
		this.getParent().setLayout(new FillLayout());
		
		JFreeChart chart;
		try {
			chart = createChart(sprint);
			final ChartComposite frame = new ChartComposite(this.getParent(), SWT.NONE, chart,
					true);
					frame.pack();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IteratorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Creates and adds the chart to the composite.
	 * @param sprint for the burndown chart
	 * @throws IOException 
	 * @throws IteratorException 
	 */
	private JFreeChart createChart(WorkPackage sprint) throws IteratorException, IOException {

        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            TITLEPREFIX.concat(sprint.getName()),  // title
            XAXISTITLE,             // x-axis label
            YAXISTITLE,             // y-axis label
            this.createDataset(sprint), // data
            true,               // create legend?
            true,               // generate tooltips?
            false               // generate URLs?
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
	 * Creates the chart dataset from the model data. It consists of two time series.
	 * @param sprint
	 * @return
	 * @throws IOException 
	 * @throws IteratorException 
	 */
	private XYDataset createDataset(WorkPackage sprint) throws IteratorException, IOException {
		TimeSeries remainingEstimates = new TimeSeries(ESTIMATESERIES);
		TimeSeries openTasks = new TimeSeries(OPENTASKSERIES);
		TimeSeriesCollection result = new TimeSeriesCollection();
		
		BurndownDataGenerator generator = BurndownDataGenerator.getInstance();
		BurndownData data = generator.getBurndownData(sprint);
		
		for(BurndownDay day : data.getDays()) {
			Day chartDay = new Day(day.getDate());
			remainingEstimates.add(chartDay, day.getRemainingEstimate());
			openTasks.add(chartDay, day.getOpenTaskCount());
		}
		
		result.addSeries(remainingEstimates);
		result.addSeries(openTasks);
		
		return result;
	}

}
