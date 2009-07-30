/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.dataanalyzer;

import java.util.List;

import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.VersionIterator;

/**
 * @author liya
 */
public interface TwoDDataAnalyzer extends DataAnalyzer {

	/**
	 * Returns the specified values of the given ProjectAnalysisData.
	 * 
	 * @param data {@link ProjectAnalysisData}
	 * @param it {@link VersionIterator}
	 * @return values 2D table of values
	 */
	List<List<Object>> get2DValue(ProjectAnalysisData data, VersionIterator it);
}
