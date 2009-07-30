/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.linkrecommendationevaluation.views;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EReferenceImpl;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.unicase.linkrecommendation.RecommendationManager;
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
					
					evaluate(item);
				}
			}
			showMessage(text);
		}
		else{
			showMessage("Double-click detected on "+obj.toString());
		}
	}
	
	private void evaluate(ActionItem ae) {
		System.out.println("Evaluating "+ae.getName());
		System.out.println("Relevant: ");
		EList<ModelElement> relevantElements = ae.getAnnotatedModelElements();
		for (ModelElement el : relevantElements) {
			System.out.println(el.getName());
		}
		System.out.println("\nRecommendations: ");
		
//		Collection<ModelElement> posEl = getPossibleElements(ae);
		Map<ModelElement, Double>relevanceMap = RecommendationManager.getInstance().getMatchMap("words", ae, posEl);
		
		double foundAndRec =0, foundNotRec =0;
		for(ModelElement el : relevantElements) {
			if(relevanceMap.get(el)!=null) {
				foundAndRec++;
			}
			else {
				foundNotRec++;
			}	
		}
		double precision = foundAndRec/relevanceMap.size();
		double recall = foundAndRec/relevantElements.size();
		
		System.out.println("Precision:"+precision);
		System.out.println("Recall:"+recall);
	}
	
	private Collection<ModelElement> getPossibleElements(ModelElement modelElement,EReference eReference) {
		EClass clazz = eReference.getEReferenceType();
		Collection<ModelElement> allElements = modelElement.getProject().getAllModelElementsbyClass(clazz,
			new BasicEList<ModelElement>());

		Object object = modelElement.eGet(eReference);
		EList<EObject> eList = null;
		EObject eObject = null;
		
		if (object instanceof EList) {
			eList = (EList<EObject>) object;
			allElements.removeAll(eList);
		} else if (object instanceof EObject) {
			eObject = (EObject) object;
			allElements.remove(eObject);
		}

		// don't show contained elements for inverse containment references
		if (eReference.isContainer()) {
			allElements.removeAll(modelElement.eContents());
		}
		return allElements;
	}
	
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Evaluation View",
			message);
	}
	
}
