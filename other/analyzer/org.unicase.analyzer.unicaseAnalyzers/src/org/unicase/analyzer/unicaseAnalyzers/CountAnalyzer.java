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
import org.unicase.analyzer.DataAnalyzer;
import org.unicase.analyzer.ProjectAnalysisData;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.task.TaskPackage;

/**
 * Count the instances of the given type of class.
 * 
 * @author liya
 */
public class CountAnalyzer implements DataAnalyzer {

	private final EClass eclass = TaskPackage.eINSTANCE.getActionItem(); // Change to the ME you want! By default is

	// ActionItem

	/**
	 * Constructor of CountAnalyzer. A analyzer which can count the number of modelElements of a given EClass.
	 * 
	 * @param eclass EClass
	 */
	// public CountAnalyzer(EClass eclass) {
	// this.eclass = eclass;
	// }

	/**
	 * @return @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getName()
	 */
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add(eclass.getName() + '#');
		return names;
	}

	/**
	 * @param data {@link ProjectAnalysisData}
	 * @return @see org.unicase.analyzer.dataanalyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		List<Object> values = new ArrayList<Object>();
		values.add(data.getProjectState().getModelElementsByClass(eclass, new BasicEList<ModelElement>()).size());
		return values;
	}

	/**
	 * @return @see org.unicase.analyzer.DataAnalyzer#isGlobal()
	 */
	public boolean isGlobal() {
		// TODO Auto-generated method stub
		return false;
	}

}
