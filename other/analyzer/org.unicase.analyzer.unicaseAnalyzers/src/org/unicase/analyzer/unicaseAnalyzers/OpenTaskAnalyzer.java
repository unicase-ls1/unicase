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
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.util.MEState;

/**
 * @author liya
 */
public class OpenTaskAnalyzer implements DataAnalyzer {

	private final EClass eclass = TaskPackage.eINSTANCE.getWorkItem();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.DataAnalyzer#getName()
	 */
	public List<String> getName() {
		List<String> names = new ArrayList<String>();
		names.add("Open Task #");
		return names;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.DataAnalyzer#getValue(org.unicase.analyzer.ProjectAnalysisData)
	 */
	public List<Object> getValue(ProjectAnalysisData data) {
		List<Object> values = new ArrayList<Object>();
		List<WorkItem> workItemList = data.getProjectState()
			.getModelElementsByClass(eclass, new BasicEList<WorkItem>());
		List<WorkItem> openTaskList = new ArrayList<WorkItem>();
		for (WorkItem wi : workItemList) {
			if (wi.getState().equals(MEState.OPEN)) {
				openTaskList.add(wi);
			}
		}
		values.add(openTaskList.size());
		return values;

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.DataAnalyzer#isGlobal()
	 */
	public boolean isGlobal() {
		// TODO Auto-generated method stub
		return false;
	}

}
