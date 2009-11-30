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
	 * @param data ProjectAnalysisData
	 * @return values per column
	 */
	List<Object> getValue(ProjectAnalysisData data);

	/**
	 * Returns the names of the columns.
	 * 
	 * @return the names of the columns
	 */
	List<String> getName();
}
