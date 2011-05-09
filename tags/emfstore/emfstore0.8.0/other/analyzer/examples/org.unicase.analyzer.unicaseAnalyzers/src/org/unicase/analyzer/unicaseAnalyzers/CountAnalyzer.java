/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.unicaseAnalyzers;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.analyzer.SimpleDataAnalyzer;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.TaskPackage;

/**
 * Count the instances of the given type of class.
 * 
 * @author liya
 */
public class CountAnalyzer extends SimpleDataAnalyzer {

	private final EClass eclass = TaskPackage.eINSTANCE.getActionItem(); // Change to the ME you want! By default is

	// ActionItem

	/**
	 * Constructor of CountAnalyzer. A analyzer which can count the number of modelElements of a given EClass.
	 */
	// public CountAnalyzer(EClass eclass) {
	// this.eclass = eclass;
	// }

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.SimpleDataAnalyzer#getSimpleValues(org.unicase.analyzer.ProjectAnalysisData)
	 */
	@Override
	public List<Object> getSimpleValues(ProjectAnalysisData data) {
		List<Object> values = new ArrayList<Object>();
		values
			.add(data.getProjectState().getModelElementsByClass(eclass, new BasicEList<UnicaseModelElement>()).size());
		return values;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.DataAnalyzer#getColumnNames()
	 */
	public List<String> getColumnNames() {
		List<String> names = new ArrayList<String>();
		names.add(eclass.getName() + '#');
		return names;
	}

}
