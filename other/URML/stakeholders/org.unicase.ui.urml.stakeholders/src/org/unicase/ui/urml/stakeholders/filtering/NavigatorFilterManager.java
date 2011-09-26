/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.filtering;

import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ViewerFilter;
import org.unicase.metamodel.Project;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.ui.navigator.TreeView;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * Filter manager for applying and removing of filter.
 * 
 * @author kterzieva
 */

public class NavigatorFilterManager {

	/**
	 * Applies the filter.
	 * 
	 * @param filter the filter
	 */
	public void applyFilter(ViewerFilter filter) {
		TreeView.getTreeViewer().setFilters(new ViewerFilter[] { filter });
//		new UnicaseCommand() {
//			@Override
//			protected void doRun() {
//				Project test = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces().get(0)
//					.getProject();
//				Set<EObject> elements = test.getAllModelElements();
//				for (EObject eo : elements) {
//					if (eo instanceof URMLDiagram) {
//						URMLDiagram u = (URMLDiagram) eo;
//						System.out.println(u.getName());
//						EList<UnicaseModelElement> test3 =  u.getElements();
//						for (UnicaseModelElement uni : test3) {
//							System.out.println(uni.getName());
//						}
//						//u.getElements().remove(1);
//					//	u.getElements().remove(u.getElements().get(1));
//						EList<UnicaseModelElement> refernceList = u.getReferringModelElements();
//						for (UnicaseModelElement u1 : refernceList) {
//							System.out.println(u1.getName());
//						}
//						refernceList.remove(0);
//					}
//				}
//			}
//		}.run();
	}

	/**
	 * Removes the filter.
	 */

	public void removeFilters() {
		TreeView.getTreeViewer().setFilters(new ViewerFilter[0]);
	}

}
