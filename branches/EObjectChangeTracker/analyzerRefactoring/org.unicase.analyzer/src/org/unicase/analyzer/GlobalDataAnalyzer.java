/**
 * 
 */
package org.unicase.analyzer;

import java.util.List;

import org.unicase.analyzer.iterator.VersionIterator;

/**
 * @author liya
 */
public abstract class GlobalDataAnalyzer implements DataAnalyzer {

	/**
	 * @see org.unicase.analyzer.DataAnalyzer#getValues(org.unicase.analyzer.ProjectAnalysisData,
	 *      org.unicase.analyzer.iterator.VersionIterator)
	 */
	public final List<List<Object>> getValues(ProjectAnalysisData data, VersionIterator it) {
		if (it.hasNext()) {
			analyzeData(data, it);
			return null;
		} else {
			return getGlobalResults(data, it);
		}
	}

	public abstract List<List<Object>> getGlobalResults(ProjectAnalysisData data, VersionIterator it);

	public abstract void analyzeData(ProjectAnalysisData data, VersionIterator it);

}
