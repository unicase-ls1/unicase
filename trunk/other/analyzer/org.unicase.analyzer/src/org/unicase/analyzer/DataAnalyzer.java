/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer;

import java.util.List;

import org.unicase.analyzer.iterator.VersionIterator;

/**
 */
public interface DataAnalyzer {
	/**
	 * Returns the specified values of the given ProjectAnalysisData.
	 * 
	 * @param data ProjectAnalysisData
	 * @param it version iterator
	 * @return values per column ( m rows * n columns)
	 */
	List<List<Object>> getValues(ProjectAnalysisData data, VersionIterator it);

	/**
	 * Returns the (header)names of the columns.
	 * 
	 * @return the names of the columns
	 */
	List<String> getColumnNames();

} // DataAnalyzer
