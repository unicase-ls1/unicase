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
import org.unicase.model.task.TaskPackage;
import org.unicase.model.task.WorkItem;
import org.unicase.model.task.util.MEState;

/**
 * Count the open tasks for the current project state.
 * 
 * @author liya
 */
public class OpenTaskAnalyzer extends SimpleDataAnalyzer {

	private final EClass eclass = TaskPackage.eINSTANCE.getWorkItem();

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.analyzer.SimpleDataAnalyzer#getSimpleValues(org.unicase.analyzer.ProjectAnalysisData)
	 */
	@Override
	public List<Object> getSimpleValues(ProjectAnalysisData data) {
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
	 * @see org.unicase.analyzer.DataAnalyzer#getColumnNames()
	 */
	public List<String> getColumnNames() {
		List<String> names = new ArrayList<String>();
		names.add("Open Task #");
		return names;
	}

}
