/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.scm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ILazyTreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.Project;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.views.changes.ChangePackageVisualizationHelper;

/**
 * Content provider for all scm views / dialogs.
 * 
 * @author Shterev
 * 
 */
public class SCMContentProvider implements ILazyTreeContentProvider {

	private HashMap<ChangePackage, HistoryInfo> changePackageToHistoryMap;
	private HashMap<AbstractOperation, ChangePackage> operationToChangePackageMap;
	private TreeViewer viewer;
	private HistoryInfo[] rootNodes;
	private Project project;

	/**
	 * Default constructor.
	 * 
	 * @param viewer
	 *            the tree viewer.
	 * @param project
	 *            the project.
	 */
	public SCMContentProvider(TreeViewer viewer, Project project) {
		this.viewer = viewer;
		this.project = project;
	}

	/**
	 * {@inheritDoc}
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		this.rootNodes = (HistoryInfo[]) newInput;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getParent(Object element) {
		if (element instanceof ChangePackage) {
			return changePackageToHistoryMap.get(element);
		} else if (element instanceof AbstractOperation) {
			return operationToChangePackageMap.get(element);
		}
		return rootNodes;
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateChildCount(Object element, int currentChildCount) {
		int length = 0;
		if (element instanceof HistoryInfo) {
			HistoryInfo historyInfo = (HistoryInfo) element;
			length = getChildren(historyInfo).size();
		} else if (element instanceof ChangePackage) {
			ChangePackage changePackage = (ChangePackage) element;
			length = getChildren(changePackage).size();
		} else if (element instanceof AbstractOperation) {
			AbstractOperation op = (AbstractOperation) element;
			length= getChildren(op).size();
		}
		viewer.setChildCount(element, length);
	}

	private List<EObject> getChildren(AbstractOperation op) {
		ChangePackageVisualizationHelper helper = new ChangePackageVisualizationHelper(
				new ArrayList<ChangePackage>(operationToChangePackageMap
						.values()), project);
		List<EObject> mes = new ArrayList<EObject>();
		mes.add(helper.getModelElement(op.getModelElementId()));
		mes.addAll(helper.getAffectedElements(op));
		return mes;
	}

	private List<AbstractOperation> getChildren(ChangePackage changePackage) {
		EList<AbstractOperation> operations = changePackage.getOperations();
		for (AbstractOperation op : operations) {
			operationToChangePackageMap.put(op, changePackage);
		}
		return operations;
	}

	private List<ChangePackage> getChildren(HistoryInfo historyInfo) {
		PrimaryVersionSpec currentVersionSpec = historyInfo.getPrimerySpec();
		int current = currentVersionSpec.getIdentifier();

		// skip the initial change package
		List<ChangePackage> changes = null;
		if (current != 0) {
			int prev = current - 1;
			PrimaryVersionSpec prevVersionSpec = VersioningFactory.eINSTANCE
					.createPrimaryVersionSpec();
			prevVersionSpec.setIdentifier(prev);
			try {
				ProjectSpace activeProjectSpace = WorkspaceManager
						.getInstance().getCurrentWorkspace()
						.getActiveProjectSpace();
				changes = activeProjectSpace.getChanges(prevVersionSpec,
						currentVersionSpec);
				for (ChangePackage cp : changes) {
					changePackageToHistoryMap.put(cp, historyInfo);
				}
			} catch (EmfStoreException e) {
				DialogHandler.showExceptionDialog(e);
			}
		}
		return changes;
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateElement(Object parent, int index) {
		 Object element = null;
		 if(parent instanceof HistoryInfo){
			 // ??
		 }else if (parent instanceof ChangePackage){
			 element = ((ChangePackage)parent).getOperations().get(index);
		 }else{
			 element = rootNodes[index];
		 }
		 viewer.replace(parent, index, element);
		 updateChildCount(element, -1);

	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
