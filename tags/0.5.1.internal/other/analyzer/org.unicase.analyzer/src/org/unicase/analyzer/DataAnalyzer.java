/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer;

import java.util.List;

import org.unicase.analyzer.iterator.VersionIterator;

/**
 * Represents an Analyzer that is able to analyze a given project analysis data instance and return values for it.
 * 
 * @author koegel
 */
public interface DataAnalyzer {

	/**
	 * Returns the (header)names of the columns.
	 * 
	 * @return the names of the columns
	 */
	List<String> getColumnNames();

	/**
	 * Returns a number of rows containing values for each column for a given project analysis data.
	 * 
	 * @param data ProjectAnalysisData
	 * @param it version iterator
	 * @return values per column ( m rows * n columns)
	 */
	List<List<Object>> getValues(ProjectAnalysisData data, VersionIterator it);

} // DataAnalyzer
