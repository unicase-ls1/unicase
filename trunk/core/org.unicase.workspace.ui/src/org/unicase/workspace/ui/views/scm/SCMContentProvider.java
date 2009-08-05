/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.scm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.workspace.ui.views.changes.ChangePackageVisualizationHelper;

/**
 * Content provider for the scm views.
 * 
 * @author Shterev
 */
public abstract class SCMContentProvider implements ITreeContentProvider {

	private static ChangePackageVisualizationHelper changePackageVisualizationHelper;
	private boolean showRootNodes = true;
	private static Project project;

	/**
	 * Default constructor.
	 * 
	 * @param treeViewer the tree viewer.
	 * @param activeProject the project.
	 */
	protected SCMContentProvider(TreeViewer treeViewer, Project activeProject) {
		project = activeProject;
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
	 * @return the subelements for this history info
	 */
	protected abstract Object[] getChildren(HistoryInfo historyInfo, TreeNode treeNode);

	/**
	 * @param op the operation
	 * @param treeNode the parent TreeNode
	 * @return the subelements of the operation (if any)
	 */
	protected abstract Object[] getChildren(AbstractOperation op, TreeNode treeNode);

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
	@SuppressWarnings("unchecked")
	public Object[] getElements(Object inputElement) {
		if(!(inputElement instanceof List)){
			return new Object[0];
		}
		List<HistoryInfo> historyInfos = (List<HistoryInfo>) inputElement;
		if(showRootNodes){
			return nodify(null, historyInfos).toArray();
		}else {
			ArrayList<Object> elements = new ArrayList<Object>();
			for(HistoryInfo hi : historyInfos){
				if(hi.getChangePackage()!=null){
					elements.addAll(Arrays.asList(getChildren(hi, new TreeNode(hi))));
				}
			}
			return elements.toArray();
		}
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
	 * @return if the root nodes should be shown.
	 */
	public boolean showRootNodes(){
		return showRootNodes;
	}

	/**
	 * Sets if the root nodes should be shown.
	 * @param show the new value.
	 */
	public void setShowRootNodes(boolean show ){
		showRootNodes = show;
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
			
			if(op instanceof CompositeOperation){
				CompositeOperation cop = (CompositeOperation) op;
				List<TreeNode> nodes = nodify(treeNode, cop.getSubOperations());
				return nodes.toArray();
			}
			
			List<EObject> mes = new ArrayList<EObject>();
			ModelElement modelElement = changePackageVisualizationHelper.getModelElement(op.getModelElementId());
			if(modelElement!=null){
				mes.add(modelElement);
			}
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
		protected Object[] getChildren(HistoryInfo historyInfo, TreeNode treeNode) {
			if(historyInfo.getChangePackage()==null){
				return new Object[0];
			}
			EList<AbstractOperation> operations = historyInfo.getChangePackage().getOperations();
			List<TreeNode> nodes = nodify(treeNode, operations);
			Collections.reverse(nodes);
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
			if(op instanceof CompositeOperation){
				CompositeOperation cop = (CompositeOperation) op;
				List<TreeNode> nodes = nodify(treeNode, cop.getSubOperations());
				return nodes.toArray();
			}
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
		protected Object[] getChildren(HistoryInfo historyInfo, TreeNode treeNode) {
			if(historyInfo.getChangePackage()==null){
				return new Object[0];
			}
			Set<EObject> modelElements = null;
			if(historyInfo.getChangePackage().getLogMessage()==null){
				ChangePackageVisualizationHelper helper = new ChangePackageVisualizationHelper(Arrays.asList(historyInfo.getChangePackage()), project);
				modelElements = helper.getAllModelElements(historyInfo.getChangePackage());
			}else{
				modelElements = changePackageVisualizationHelper.getAllModelElements(historyInfo.getChangePackage());
			}
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
			if (treeNode.getParent().getValue() instanceof HistoryInfo) {
				HistoryInfo historyInfo = (HistoryInfo) treeNode.getParent().getValue() ;
				ChangePackageVisualizationHelper helper = changePackageVisualizationHelper;
				if(historyInfo.getChangePackage().getLogMessage()==null){
					helper = new ChangePackageVisualizationHelper(Arrays.asList(historyInfo.getChangePackage()), project);
				}
				ArrayList<EObject> operations = new ArrayList<EObject>(helper
					.getOperations(modelElement,historyInfo.getChangePackage()));
				List<TreeNode> nodes = nodify(treeNode, operations);
				Collections.reverse(nodes);
				return nodes.toArray();
			}
			return new Object[0];
		}

	}

}
