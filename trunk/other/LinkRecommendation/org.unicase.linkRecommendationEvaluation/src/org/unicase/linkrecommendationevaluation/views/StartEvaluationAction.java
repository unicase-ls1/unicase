/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendationevaluation.views;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.unicase.model.ModelElement;
import org.unicase.model.task.ActionItem;
import org.unicase.model.task.TaskPackage;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * This class represents the actions for evaluation.
 * @author Henning Femmer
 */
public class StartEvaluationAction extends Action{
	private TableViewer viewer;
	private String[] elements;
	
	/**
	 * Constructor.
	 * @param v the tableView
	 * @param el the possible elements in the tv
	 */
	public StartEvaluationAction(TableViewer v, String[] el){
		this.viewer = v;
		this.elements = el;
	}
	
	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		ISelection selection = viewer.getSelection();
		Object obj = ((IStructuredSelection)selection).getFirstElement();
		
		if(obj == elements[0]) {
			EList<ProjectSpace> all = WorkspaceManager.getInstance().getCurrentWorkspace()
				.getProjectSpaces();
			
			String text = "";
			for(ProjectSpace project : all) {
				//if(element.eClass())
				text += project.getProjectName()+" <-> ";
				
				EList<ActionItem> myList = 	project.getProject()
				.getAllModelElementsbyClass(TaskPackage.eINSTANCE.getActionItem(), new BasicEList<ActionItem>());
			
				for(ActionItem item : myList){
					text += "\n"+item.getName();
					
					for (ModelElement el : item.getAnnotatedModelElements()) {
						text += "("+el.getName()+")";
					}
				}
			}
			showMessage(text);
		}else{
			showMessage("Double-click detected on "+obj.toString());
		}
	}
	
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Evaluation View",
			message);
	}
}
