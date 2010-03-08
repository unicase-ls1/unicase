/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer;

import java.util.ArrayList;
import java.util.List;

import org.unicase.analyzer.iterator.VersionIterator;

/**
 * It is used for only one list of data is output for a given projectAnalysisData.
 * 
 * @author liya
 */
public abstract class SimpleDataAnalyzer implements DataAnalyzer {

	/**
	 * It is used for only one row of data is output.
	 * 
	 * @param data project analysis data
	 * @return a list of values
	 */
	public abstract List<Object> getSimpleValues(ProjectAnalysisData data);

	/**
	 * @param data project analysis data
	 * @param it version iterator
	 * @return @see org.unicase.analyzer.DataAnalyzer#getValues(org.unicase.analyzer.ProjectAnalysisData)
	 */
	public final List<List<Object>> getValues(ProjectAnalysisData data, VersionIterator it) {
		List<List<Object>> values = new ArrayList<List<Object>>();
		values.add(getSimpleValues(data));
		return values;
	}

} // SimpleDataAnalyzer
