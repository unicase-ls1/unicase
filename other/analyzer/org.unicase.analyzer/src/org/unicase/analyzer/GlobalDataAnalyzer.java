/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer;

import java.util.List;

import org.unicase.analyzer.iterator.VersionIterator;

/**
 * It is used for returning only a global result in the end.
 * 
 * @author liya
 */
public abstract class GlobalDataAnalyzer implements DataAnalyzer {

	/**
	 * @param data @see org.unicase.analyzer.DataAnalyzer#getValues(org.unicase.analyzer.ProjectAnalysisData,
	 *            org.unicase.analyzer.iterator.VersionIterator)
	 * @param it @see org.unicase.analyzer.DataAnalyzer#getValues(org.unicase.analyzer.ProjectAnalysisData,
	 *            org.unicase.analyzer.iterator.VersionIterator)
	 * @return @see org.unicase.analyzer.DataAnalyzer#getValues(org.unicase.analyzer.ProjectAnalysisData,
	 *         org.unicase.analyzer.iterator.VersionIterator)
	 */
	public final List<List<Object>> getValues(ProjectAnalysisData data, VersionIterator it) {
		if (it.hasNext()) {
			analyzeData(data, it);
			return null;
		} else {
			return getGlobalResults(data, it);
		}
	}

	/**
	 * Global results will only be returned in the end.
	 * 
	 * @param data project analysis data
	 * @param it version iterator
	 * @return global results
	 */
	public abstract List<List<Object>> getGlobalResults(ProjectAnalysisData data, VersionIterator it);

	/**
	 * Analyze data for each iteration.
	 * 
	 * @param data project analysis data
	 * @param it version iterator
	 */
	public abstract void analyzeData(ProjectAnalysisData data, VersionIterator it);

}
