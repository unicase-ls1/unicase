/**
 * 
 */
package org.unicase.analyzer.dataanalyzer;

import java.util.List;

import org.unicase.analyzer.ProjectAnalysisData;

/**
 * @author liya
 *
 */
public interface DataAnalyzer {

	/**
	 * Returns the specified values of the given {@link ProjectAnalysisData} 
	 * 
	 * @param data the ProjectAnalysisData
	 * @return values per column
	 */
	public List<Object> getValue(ProjectAnalysisData data);

	/**
	 * Returns the names of the columns.
	 * 
	 * @return the names of the columns
	 */
	public List<String> getName();
}
