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
import org.unicase.model.urml.goal.GoalPackage;
import org.unicase.model.urml.requirement.RequirementPackage;


//EList<ECPProject> projects = WorkspaceManager.getInstance().getWorkSpace().getProjects();
//this can be used to get a project, which schould be used as input for the getURMLElementsfromProject method 

public class UrmlTreeHandler {

	
	ECPProject project;
	
	//TODO generic method - select some certain project
	//test with the first project
	public static ECPProject getTestProject() throws NoWorkspaceException{
		return  ECPWorkspaceManager.getInstance().getWorkSpace().getProjects().get(0);
	}
	
	public static Collection<EObject> getRequirementsAndGoalsfromProject(ECPProject project){
		Collection<EObject> basicList = project.getAllModelElementsbyClass(GoalPackage.eINSTANCE.getGoal(), new BasicEList<EObject>());
		Collection<EObject> basicListReq = project.getAllModelElementsbyClass(RequirementPackage.eINSTANCE.getFunctionalRequirement(), new BasicEList<EObject>());
		basicList.addAll(basicListReq);
		return basicList;
	}
	
	public static Collection<UrmlModelElement> getRequirementsfromProjects(ECPProject project){
		//	project.getAllModelElementsbyClass(UrmlPackage.eINSTANCE.getUrmlModelElement(), new BasicEList<EObject>());
			//return project.getAllModelElementsbyClass(GoalPackage.eINSTANCE.getGoal(), new BasicEList<EObject>());

			Collection<EObject> basicListReq = project.getAllModelElementsbyClass(RequirementPackage.eINSTANCE.getFunctionalRequirement(), new BasicEList<EObject>());
			List<UrmlModelElement> list = new ArrayList<UrmlModelElement>();
			for(EObject u:basicListReq){
				list.add((UrmlModelElement) u);
			}
			return list;
		}
	
	public static TreeNode[] createTree(Collection<EObject> collection){
		TreeNode[] result = new TreeNode[collection.size()];
		int i = 0;
		
		for(EObject element:collection){
			result[i] = new UrmlTreeNode((UrmlModelElement) element);
			i = i + 1;
		}
		return result;			
	}
}
