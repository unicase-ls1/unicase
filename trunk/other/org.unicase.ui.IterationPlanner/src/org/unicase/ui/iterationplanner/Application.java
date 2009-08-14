/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.iterationplanner;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

/**
 * @author Hodaie
 */
public class Application implements IApplication {

	// BEGIN SUPRESS CATCH EXCEPTION
	/**
	 * {@inheritDoc}
	 * 
	 * @throws Exception exception
	 */
	public Object start(IApplicationContext context) throws Exception {

		// * 1. Import your data into a Matrix, e.g. from CSV, Excel, JDBC (raw data -> matrix)
		// * 2. Analyze your data, e.g. classify, cluster, make predictions and get the results also as matices (matrix
		// -> matrix)
		// * 3. Export results to the format you need, e.g. JPG, Excel, Latex, GnuPlot (matrix -> desired format)

		// Create a DataSet.
		// Split into training and test set.
		// Data normalization.
		// Create a Classifier.
		// Training.
		// Prediction.
		// Evaluation.
		// Cross Validation.

		// ClassificationDataSet dataSet = new ClassificationDataSet();
		// dataSet.getAccuracyVariable();

		WorkItemsToCSV wiToCVS = new WorkItemsToCSV();
		wiToCVS.outputWorkItems();

		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void stop() {
	// TODO Auto-generated method stub

	}

	// END SUPRESS CATCH BLOCK
}
