/**
 * 
 */
package org.unicase.analyzer.dataanalyzer;

import java.util.ArrayList;
import java.util.List;

import org.unicase.analyzer.ProjectAnalysisData;

/**
 * @author liya
 *
 */
public class VersionWriter implements DataAnalyzer {

	/* (non-Javadoc)
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getName()
	 */
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add("Version");
		return names;
	}

	/* (non-Javadoc)
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		List<Object> values = new ArrayList<Object>();
		values.add(data.getPrimaryVersionSpec().getIdentifier());
		return values;
	}

}
