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
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.ecp.model.workSpaceModel.ECPProject;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.danger.DangerPackage;
import org.unicase.model.urml.requirement.Requirement;
import org.unicase.model.urml.requirement.RequirementPackage;

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
	public static ECPProject getTestProject() throws NoWorkspaceException {
		return ECPWorkspaceManager.getInstance().getWorkSpace().getProjects().get(0);
	}

	/**
	 * Test method.
	 * @param project the project
	 * @return the basic list
	 */
	public static Collection<Requirement> getRequirementsFromProject(ECPProject project) {
		Collection<EObject> basicListReq = project.getAllModelElementsbyClass(RequirementPackage.eINSTANCE
			.getRequirement(), new BasicEList<EObject>());
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
	public static Collection<UrmlModelElement> getStakeholderSetfromProjects(ECPProject project) {
		// project.getAllModelElementsbyClass(UrmlPackage.eINSTANCE.getUrmlModelElement(), new BasicEList<EObject>());
		// return project.getAllModelElementsbyClass(GoalPackage.eINSTANCE.getGoal(), new BasicEList<EObject>());
		Collection<EObject> dangerListReq = project.getAllModelElementsbyClass(DangerPackage.eINSTANCE.getDanger(),
			new BasicEList<EObject>());
		Collection<EObject> basicListReq = project.getAllModelElementsbyClass(RequirementPackage.eINSTANCE
			.getFunctionalRequirement(), new BasicEList<EObject>());
		basicListReq.addAll(dangerListReq);
		List<UrmlModelElement> list = new ArrayList<UrmlModelElement>();
		for (EObject urmlElment : basicListReq) {
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
	public static TreeNode[] createTree(Collection<Requirement> collection) {
		TreeNode[] result = new TreeNode[collection.size()];
		int i = 0;

		for (EObject element : collection) {
			result[i] = new UrmlTreeNode((UrmlModelElement) element);
			i = i + 1;
		}
		return result;
	}
}
