/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.scm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
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
public class SCMContentProvider implements ITreeContentProvider {

	/**
	 * group by model element.
	 */
	public static final String MODEL_ELEMENT = "modelElement";

	/**
	 * group by operation.
	 */
	public static final String OPERATION = "operation";

	private TreeViewer viewer;
	private Project project;
	private List<ChangePackage> changePackages;
	private String groupBy = MODEL_ELEMENT;

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
		changePackages = new ArrayList<ChangePackage>();
		groupBy = MODEL_ELEMENT;
	}

	/**
	 * Sets the tree item group criterion.
	 * 
	 * @param groupCriterion
	 *            {@link #MODEL_ELEMENT} or {@link #OPERATION}
	 */
	public void groupBy(String groupCriterion) {
		groupBy = groupCriterion;
	}

	private Object[] getChildren(AbstractOperation op) {
		ChangePackageVisualizationHelper helper = new ChangePackageVisualizationHelper(
				changePackages, project);
		List<EObject> mes = new ArrayList<EObject>();
		mes.add(helper.getModelElement(op.getModelElementId()));
		mes.addAll(helper.getAffectedElements(op));
		return mes.toArray();
	}

	private Object[] getChildren(ChangePackage changePackage) {
		if (groupBy.equals(OPERATION)) {
			EList<AbstractOperation> operations = changePackage.getOperations();
			return operations.toArray();
		}
		ChangePackageVisualizationHelper helper = new ChangePackageVisualizationHelper(
				changePackages, project);
		Set<EObject> modelElements = helper.getAllModelElements(changePackage);
		return modelElements.toArray();
	}

	private Object[] getChildren(HistoryInfo historyInfo) {
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
				changePackages.addAll(changes);
			} catch (EmfStoreException e) {
				DialogHandler.showExceptionDialog(e);
			}
		}
		return changes.toArray();
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object element) {
		if (element instanceof HistoryInfo) {
			HistoryInfo historyInfo = (HistoryInfo) element;
			return getChildren(historyInfo);
		} else if (element instanceof ChangePackage) {
			ChangePackage changePackage = (ChangePackage) element;
			return getChildren(changePackage);
		} else if (element instanceof AbstractOperation) {
			AbstractOperation op = (AbstractOperation) element;
			return getChildren(op);
		}
		return new Object[0];
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean hasChildren(Object element) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getElements(Object inputElement) {
		return (Object[]) viewer.getInput();
	}

	/**
	 * {@inheritDoc}
	 */
	public Object getParent(Object element) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		// TODO Auto-generated method stub
	}

	/**
	 * {@inheritDoc}
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		//
	}

}
