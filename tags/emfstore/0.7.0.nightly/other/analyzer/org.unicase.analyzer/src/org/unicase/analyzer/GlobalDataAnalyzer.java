/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer;

import java.util.List;

import org.unicase.analyzer.iterator.VersionIterator;

/**
 * Represents an analyzer that only returns one global result at the end.
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
			analyzeData(data, it);
			return getGlobalResults();
		}
	}

	/**
	 * Return the global results. Will only be called at the end of the analysis.
	 * 
	 * @return global results
	 */
	public abstract List<List<Object>> getGlobalResults();

	/**
	 * Called on each iteration. Analyze data for each iteration. Build up a global result internally.
	 * 
	 * @param data project analysis data
	 * @param it version iterator
	 */
	public abstract void analyzeData(ProjectAnalysisData data, VersionIterator it);

}
