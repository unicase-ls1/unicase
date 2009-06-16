/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.scm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.commands.ServerRequestCommandHandler;
import org.unicase.workspace.ui.views.changes.ChangePackageVisualizationHelper;

/**
 * Content provider for the scm views.
 * 
 * @author Shterev
 */
public abstract class SCMContentProvider implements ITreeContentProvider {

	private static TreeViewer viewer;
	private static ChangePackageVisualizationHelper changePackageVisualizationHelper;

	/**
	 * Default constructor.
	 * 
	 * @param treeViewer the tree viewer.
	 * @param activeProject the project.
	 */
	protected SCMContentProvider(TreeViewer treeViewer, Project activeProject) {
		viewer = treeViewer;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object[] getChildren(Object node) {
		TreeNode treeNode = (TreeNode) node;
		Object element = treeNode.getValue();
		if (element instanceof HistoryInfo) {
			HistoryInfo historyInfo = (HistoryInfo) element;
			return getChildren(historyInfo, treeNode);
		} else if (element instanceof ChangePackage) {
			ChangePackage changePackage = (ChangePackage) element;
			return getChildren(changePackage, treeNode);
		} else if (element instanceof AbstractOperation) {
			AbstractOperation op = (AbstractOperation) element;
			return getChildren(op, treeNode);
		} else if (element instanceof ModelElement) {
			ModelElement me = (ModelElement) element;
			return getChildren(me, treeNode);
		}
		return new Object[0];
	}

	/**
	 * @param visualizationHelper the visualizationHelper to set.
	 */
	public void setChangePackageVisualizationHelper(ChangePackageVisualizationHelper visualizationHelper) {
		changePackageVisualizationHelper = visualizationHelper;
	}

	/**
	 * @param historyInfo the history info
	 * @param treeNode the parent TreeNode
	 * @return the change packages for this history info
	 */
	@SuppressWarnings("unchecked")
	protected Object[] getChildren(HistoryInfo historyInfo, TreeNode treeNode) {
		final PrimaryVersionSpec currentVersionSpec = historyInfo.getPrimerySpec();
		int current = currentVersionSpec.getIdentifier();

		// skip the initial change package
		if (current != 0) {
			final int prev = current - 1;

			ServerRequestCommandHandler historyInfosHandler = new ServerRequestCommandHandler() {

				@Override
				protected Object run() throws EmfStoreException {
					ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace()
						.getActiveProjectSpace();
					PrimaryVersionSpec prevVersionSpec = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
					prevVersionSpec.setIdentifier(prev);
					List<ChangePackage> changes = activeProjectSpace.getChanges(prevVersionSpec, currentVersionSpec);
					return changes;
				}

			};

			try {
				Object object = historyInfosHandler.execute(new ExecutionEvent());
				List<ChangePackage> changes = (List<ChangePackage>) object;
				List<TreeNode> nodes = nodify(treeNode, changes);
				return nodes.toArray();
			} catch (ExecutionException e) {
				DialogHandler.showExceptionDialog(e);
			}

		}
		return new Object[0];
	}

	/**
	 * @param op the operation
	 * @param treeNode the parent TreeNode
	 * @return the subelements of the operation (if any)
	 */
	protected abstract Object[] getChildren(AbstractOperation op, TreeNode treeNode);

	/**
	 * @param changePackage the changePackage
	 * @param treeNode the parent TreeNode
	 * @return the subelements of the changePackage
	 */
	protected abstract Object[] getChildren(ChangePackage changePackage, TreeNode treeNode);

	/**
	 * @param modelElement the modelElement
	 * @param treeNode the parent TreeNode
	 * @return the subelements of the modelElement
	 */
	protected abstract Object[] getChildren(ModelElement modelElement, TreeNode treeNode);

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
	}

	/**
	 * {@inheritDoc}
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {

	}

	/**
	 * Creates a TreeNode wrapper list from the given object list.
	 * 
	 * @param treeNode the parent tree node
	 * @param list the list of childern objects.
	 * @return a new wrapped {@link ArrayList}.
	 */
	protected List<TreeNode> nodify(TreeNode treeNode, List<? extends Object> list) {
		ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
		for (Object o : list) {
			TreeNode meNode = new TreeNode(o);
			meNode.setParent(treeNode);
			nodes.add(meNode);
		}
		return nodes;
	}

	/**
	 * Content provider displaying the scm item in the following order: HistoryInfo > ChangePackage > Operation(s) >
	 * ModelElement(s).
	 * 
	 * @author Shterev
	 */
	public static class Detailed extends SCMContentProvider {

		/**
		 * Default constructor.
		 * 
		 * @param viewer the viewer.
		 * @param project the project.
		 */
		public Detailed(TreeViewer viewer, Project project) {
			super(viewer, project);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return an array of {@link ModelElement}s
		 */
		@Override
		protected Object[] getChildren(AbstractOperation op, TreeNode treeNode) {
			List<EObject> mes = new ArrayList<EObject>();
			mes.add(changePackageVisualizationHelper.getModelElement(op.getModelElementId()));
			mes.addAll(changePackageVisualizationHelper.getAffectedElements(op));
			List<TreeNode> nodes = nodify(treeNode, mes);
			return nodes.toArray();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return an array of {@link AbstractOperation}s
		 */
		@Override
		protected Object[] getChildren(ChangePackage changePackage, TreeNode treeNode) {
			EList<AbstractOperation> operations = changePackage.getOperations();
			List<TreeNode> nodes = nodify(treeNode, operations);
			return nodes.toArray();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return an empty array
		 */
		@Override
		protected Object[] getChildren(ModelElement modelElement, TreeNode treeNode) {
			return new Object[0];
		}

	}

	/**
	 * Content provider displaying the scm item in the following order: HistoryInfo > ChangePackage > ModelElement(s) >
	 * Operation(s).
	 * 
	 * @author Shterev
	 */
	public static class Compact extends SCMContentProvider {

		/**
		 * Default constructor.
		 * 
		 * @param viewer the viewer.
		 * @param project the project.
		 */
		public Compact(TreeViewer viewer, Project project) {
			super(viewer, project);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return an empty array
		 */
		@Override
		protected Object[] getChildren(AbstractOperation op, TreeNode treeNode) {
			Set<EObject> modelElements = changePackageVisualizationHelper.getAffectedElements(op);
			List<TreeNode> nodes = nodify(treeNode, new ArrayList<EObject>(modelElements));
			return nodes.toArray();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return an array of {@link ModelElement}s
		 */
		@Override
		protected Object[] getChildren(ChangePackage changePackage, TreeNode treeNode) {
			Set<EObject> modelElements = changePackageVisualizationHelper.getAllModelElements(changePackage);
			List<TreeNode> nodes = nodify(treeNode, new ArrayList<EObject>(modelElements));
			return nodes.toArray();

		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return an array of {@link AbstractOperation}s
		 */
		@Override
		protected Object[] getChildren(ModelElement modelElement, TreeNode treeNode) {
			ArrayList<EObject> operations = new ArrayList<EObject>(changePackageVisualizationHelper
				.getOperations(modelElement));
			List<TreeNode> nodes = nodify(treeNode, operations);
			return nodes.toArray();
		}

	}

}
