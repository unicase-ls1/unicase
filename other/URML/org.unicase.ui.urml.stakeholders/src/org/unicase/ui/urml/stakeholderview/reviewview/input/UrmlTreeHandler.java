/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholderview.reviewview.input;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.TreeNode;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.metamodel.Project;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.model.urml.requirement.Requirement;
import org.unicase.workspace.WorkspaceManager;

/**
 * Test tree handler.
 * 
 * @author kterzieva
 */

public final class UrmlTreeHandler {

	// TODO generic method - select some certain project
	// test with the first project

	private UrmlTreeHandler() {

	}

	/**
	 * Gets the test project.
	 * 
	 * @return the test project
	 * @throws NoWorkspaceException .
	 */
	public static Project getTestProject() throws NoWorkspaceException {
		return WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces().get(0).getProject();
	}

	/**
	 * Test method.
	 * @param project the project
	 * @return the basic list
	 */
	public static Collection<UrmlModelElement> getRequirementsFromProject(Project project) {
		Collection<EObject> basicListReq = project.getAllModelElementsbyClass(UrmlPackage.eINSTANCE
			.getUrmlModelElement(), new BasicEList<EObject>());
		Collection<UrmlModelElement> newList = new ArrayList<UrmlModelElement>();
		for (EObject a : basicListReq) {
			newList.add( (UrmlModelElement) a);
		}

		return newList;
	}
	
	/**
	 * Test method.
	 * @param project the project.
	 * @return newList the test list
	 */
	public static Collection<Requirement> getRolesFromProject(Project project) {
		Collection<EObject> basicListReq = project.getAllModelElementsbyClass(UrmlPackage.eINSTANCE
			.getStakeholderRole(), new BasicEList<EObject>());
		Collection<Requirement> newList = new ArrayList<Requirement>();
		for (EObject a : basicListReq) {
			newList.add((Requirement) a);
		}

		return newList;
	}


	/**
	 * Test method.
	 * @param project the project.
	 * @return the list
	 */
	public static Collection<UrmlModelElement> getUrmlElementsfromProjects(Project project) {
		// project.getAllModelElementsbyClass(UrmlPackage.eINSTANCE.getUrmlModelElement(), new BasicEList<EObject>());
		// return project.getAllModelElementsbyClass(GoalPackage.eINSTANCE.getGoal(), new BasicEList<EObject>());
		Collection<EObject> elementList= project.getAllModelElementsbyClass(UrmlPackage.eINSTANCE.getUrmlModelElement(),
			new BasicEList<EObject>());
		List<UrmlModelElement> list = new ArrayList<UrmlModelElement>();
		for (EObject urmlElment : elementList) {
			list.add((UrmlModelElement) urmlElment);
		}
		return list;
	}

	/**
	 * Creates the tree.
	 * 
	 * @param collection .
	 * @return the result tree
	 */
//	public static TreeNode[] createTree(Collection<UrmlModelElement> collection) {
//		TreeNode[] result = new TreeNode[collection.size()];
//		int i = 0;
//
//		for (EObject element : collection) {
//			result[i] = new UrmlTreeNode((UrmlModelElement) element);
//			i = i + 1;
//		}
//		return result;
//	}

	public static TreeNode[] createTree(Collection<UrmlModelElement> collection) {
		TreeNode[] result = new TreeNode[collection.size()];
		int i = 0;

		for (EObject element : collection) {
			result[i] = new UrmlTreeNode((UrmlModelElement) element);
			i = i + 1;
		}
		return result;
	}
}
