/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.unicaseAnalyzers;

import java.util.ArrayList;
import java.util.List;

import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.ProjectAnalysisData;

/**
 * @author liya
 *
 */
public class ModelElementAnalyzer implements DataAnalyzer {

	private static final String MECOUNT = "ModelElement #";

	/**
	 * 
	 * @return @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getName()
	 * 
	 */
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add(MECOUNT);
		return names;
	}

	/** 
	 * @return @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 * @param data {@link ProjectAnalysisData}
	 * 
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		List<Object> values = new ArrayList<Object>();
		
		// Number of all ModelElements
		values.add(data.getProjectState().getModelElements().size());
		return values;
	}

	/** 
	 * {@inheritDoc}
	 * @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#isExportOnce()
	 */
	public boolean isExportOnce() {
		return false;
	}
}
