/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.unicaseAnalyzers;

import java.util.ArrayList;
import java.util.List;

import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.SimpleDataAnalyzer;

/**
 * Write the version number of the current project state.
 * 
 * @author liya
 */
public class VersionWriter extends SimpleDataAnalyzer {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.SimpleDataAnalyzer#getSimpleValues(org.unicase.analyzer.ProjectAnalysisData)
	 */
	@Override
	public List<Object> getSimpleValues(ProjectAnalysisData data) {
		List<Object> values = new ArrayList<Object>();
		values.add(data.getPrimaryVersionSpec().getIdentifier());
		return values;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.DataAnalyzer#getColumnNames()
	 */
	public List<String> getColumnNames() {
		List<String> names = new ArrayList<String>();
		names.add("Version");
		return names;
	}

}
