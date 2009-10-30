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
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.OperationGroup;
import org.unicase.emfstore.esmodel.versioning.operations.OperationsFactory;
import org.unicase.emfstore.esmodel.versioning.operations.ReferenceOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.workspace.ui.views.changes.ChangePackageVisualizationHelper;

/**
 * Content provider for the scm views.
 * 
 * @author Shterev
 */
public abstract class SCMContentProvider implements ITreeContentProvider {

	private static ChangePackageVisualizationHelper changePackageVisualizationHelper;
	private boolean showRootNodes = true;
	private boolean reverseNodes = true;
	private static Project project;

	/**
	 * Default constructor.
	 * 
	 * @param treeViewer
	 *            the tree viewer.
	 * @param activeProject
	 *            the project.
	 */
	protected SCMContentProvider(TreeViewer treeViewer, Project activeProject) {
		project = activeProject;
	}

	/**
	 * Sets the flag to reverse the order of the nodes. Default value is true -
	 * i.e. the more recent operations are on top.
	 * 
	 * @param reverseNodes
	 *            the new value
	 */
	public void setReverseNodes(boolean reverseNodes) {
		this.reverseNodes = reverseNodes;
	}

	/**
	 * Returns if the nodes should be reversed.
	 * 
	 * @return true if the nodes should be reversed in order
	 */
	public boolean isReverseNodes() {
		return reverseNodes;
	}

	/**
	 * @param group
	 *            the operation group
	 * @param treeNode
	 *            the node.
	 * @return The children of an OperationsGroup
	 */
	protected Object[] getChildren(OperationGroup group, TreeNode treeNode) {
		EList<AbstractOperation> ops = group.getOperations();
		List<TreeNode> ret = nodify(treeNode, ops);
		return ret.toArray();
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
		} else if (element instanceof ChangePackage) {
			ChangePackage cp = (ChangePackage) element;
			return getChildren(cp, treeNode);
		} else if (element instanceof OperationGroup) {
			OperationGroup og = (OperationGroup) element;
			return getChildren(og, treeNode);
		}
		return new Object[0];
	}

	/**
	 * @param visualizationHelper
	 *            the visualizationHelper to set.
	 */
	public void setChangePackageVisualizationHelper(
			ChangePackageVisualizationHelper visualizationHelper) {
		changePackageVisualizationHelper = visualizationHelper;
	}

	/**
	 * @param changePackage
	 *            the changePackage
	 * @param treeNode
	 *            the parent TreeNode
	 * @return the subelements for this change package
	 */
	protected abstract Object[] getChildren(ChangePackage changePackage,
			TreeNode treeNode);

	/**
	 * @param historyInfo
	 *            the history info
	 * @param treeNode
	 *            the parent TreeNode
	 * @return the subelements for this history info
	 */
	protected abstract Object[] getChildren(HistoryInfo historyInfo,
			TreeNode treeNode);

	/**
	 * @param op
	 *            the operation
	 * @param treeNode
	 *            the parent TreeNode
	 * @return the subelements of the operation (if any)
	 */
	protected abstract Object[] getChildren(AbstractOperation op,
			TreeNode treeNode);

	/**
	 * @param modelElement
	 *            the modelElement
	 * @param treeNode
	 *            the parent TreeNode
	 * @return the subelements of the modelElement
	 */
	protected abstract Object[] getChildren(ModelElement modelElement,
			TreeNode treeNode);

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
		if (inputElement instanceof ChangePackage) {
			return nodify(null, Arrays.asList((ChangePackage) inputElement))
					.toArray();
		}
		if (!(inputElement instanceof List) || ((List) inputElement).isEmpty()) {
			return new Object[0];
		}
		List inputList = (List) inputElement;
		Object firstElement = inputList.get(0);
		if (firstElement == null) {
			return new Object[0];
		}
		if (firstElement instanceof ChangePackage) {
			if (showRootNodes) {
				return nodify(null, inputList).toArray();
			} else {
				ArrayList<Object> elements = new ArrayList<Object>();
				List<ChangePackage> changePackages = inputList;
				for (ChangePackage cp : changePackages) {
					elements.addAll(Arrays.asList(getChildren(cp, new TreeNode(
							cp))));
				}
				return elements.toArray();
			}
		} else if (firstElement instanceof HistoryInfo) {
			List<HistoryInfo> historyInfos = (List<HistoryInfo>) inputElement;
			if (showRootNodes) {
				return nodify(null, historyInfos).toArray();
			} else {
				ArrayList<Object> elements = new ArrayList<Object>();
				for (HistoryInfo hi : historyInfos) {
					if (hi.getChangePackage() != null) {
						elements.addAll(Arrays.asList(getChildren(hi,
								new TreeNode(hi))));
					}
				}
				return elements.toArray();
			}
		}
		return new Object[0];
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
	 * @param treeNode
	 *            the parent tree node
	 * @param list
	 *            the list of childern objects.
	 * @return a new wrapped {@link ArrayList}.
	 */
	protected List<TreeNode> nodify(TreeNode treeNode,
			List<? extends Object> list) {
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
	public boolean showRootNodes() {
		return showRootNodes;
	}

	/**
	 * Sets if the root nodes should be shown.
	 * 
	 * @param show
	 *            the new value.
	 */
	public void setShowRootNodes(boolean show) {
		showRootNodes = show;
	}

	/**
	 * Content provider displaying the scm item in the following order:
	 * HistoryInfo > ChangePackage > Operation(s) > ModelElement(s).
	 * 
	 * @author Shterev
	 */
	public static class Detailed extends SCMContentProvider {

		private AdapterFactoryContentProvider unicaseContentProvider;

		/**
		 * Default constructor.
		 * 
		 * @param viewer
		 *            the viewer.
		 * @param project
		 *            the project.
		 */
		public Detailed(TreeViewer viewer, Project project) {
			super(viewer, project);
			unicaseContentProvider = new AdapterFactoryContentProvider(
					new ComposedAdapterFactory(
							ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return an array of {@link ModelElement}s
		 */
		@Override
		protected Object[] getChildren(AbstractOperation op, TreeNode treeNode) {

			if (op instanceof CompositeOperation) {
				ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
				CompositeOperation cop = (CompositeOperation) op;
				if (cop.getMainOperation() != null) {
					Object[] children = getChildren(cop.getMainOperation(),
							treeNode);
					for (Object o : children) {
						ret.add((TreeNode) o);
					}
					List<AbstractOperation> subOps = ModelUtil
							.flatCloneList(cop.getSubOperations());
					if (subOps.size() > 0) {
						subOps.remove(cop.getMainOperation());
						OperationGroup operationGroup = OperationsFactory.eINSTANCE
								.createOperationGroup();
						operationGroup.setName("Additional Details");
						operationGroup.getOperations().addAll(subOps);
						TreeNode subOpsNode = new TreeNode(operationGroup);
						subOpsNode.setParent(treeNode);
						ret.add(subOpsNode);
					}
				} else {
					if (cop.getModelElementId() != null) {
						ModelElement modelElement = changePackageVisualizationHelper
								.getModelElement(cop.getModelElementId());
						if (modelElement != null) {
							TreeNode meNode = new TreeNode(modelElement);
							meNode.setParent(treeNode);
							ret.add(meNode);
						}
					}
				}
				return ret.toArray();
			} else if (op instanceof CreateDeleteOperation) {
				ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
				CreateDeleteOperation cdo = (CreateDeleteOperation) op;

				if (cdo.getModelElementId() != null) {
					ModelElement modelElement = changePackageVisualizationHelper
							.getModelElement(cdo.getModelElementId());
					if (modelElement != null) {
						TreeNode meNode = new TreeNode(modelElement);
						meNode.setParent(treeNode);
						ret.add(meNode);
					}
				}
				List<ReferenceOperation> subOps = cdo.getSubOperations();
				if (subOps.size() > 0) {
					OperationGroup operationGroup = OperationsFactory.eINSTANCE
							.createOperationGroup();
					operationGroup.setName("Cross-Reference Details");
					operationGroup.getOperations().addAll(subOps);
					TreeNode subOpsNode = new TreeNode(operationGroup);
					subOpsNode.setParent(treeNode);
					ret.add(subOpsNode);
				}
				return ret.toArray();
			}

			List<EObject> mes = new ArrayList<EObject>();
			ModelElement modelElement = changePackageVisualizationHelper
					.getModelElement(op.getModelElementId());
			if (modelElement != null) {
				mes.add(modelElement);
			}
			mes
					.addAll(changePackageVisualizationHelper
							.getAffectedElements(op));

			// if (op instanceof CreateDeleteOperation) {
			// mes.addAll(((CreateDeleteOperation) op).getSubOperations());
			// }
			List<TreeNode> nodes = nodify(treeNode, mes);
			return nodes.toArray();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return an array of {@link AbstractOperation}s
		 */
		@Override
		protected Object[] getChildren(ChangePackage changePackage,
				TreeNode treeNode) {
			EList<AbstractOperation> operations = changePackage.getOperations();
			List<TreeNode> nodes = nodify(treeNode, operations);
			if (isReverseNodes()) {
				Collections.reverse(nodes);
			}
			return nodes.toArray();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return an array of {@link AbstractOperation}s
		 */
		@Override
		protected Object[] getChildren(HistoryInfo historyInfo,
				TreeNode treeNode) {
			if (historyInfo.getChangePackage() == null) {
				return new Object[0];
			}
			return getChildren(historyInfo.getChangePackage(), treeNode);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return an empty array
		 */
		@Override
		protected Object[] getChildren(ModelElement modelElement,
				TreeNode treeNode) {
			Object[] children = unicaseContentProvider
					.getChildren(modelElement);
			List<TreeNode> result = nodify(treeNode, Arrays.asList(children));
			return result.toArray();
		}

	}

	/**
	 * Content provider displaying the scm item in the following order:
	 * HistoryInfo > ChangePackage > ModelElement(s) > Operation(s).
	 * 
	 * @author Shterev
	 */
	public static class Compact extends SCMContentProvider {

		/**
		 * Default constructor.
		 * 
		 * @param viewer
		 *            the viewer.
		 * @param project
		 *            the project.
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
			if (op instanceof CompositeOperation) {
				CompositeOperation cop = (CompositeOperation) op;
				List<AbstractOperation> subOps = cop.getSubOperations();
				OperationGroup operationGroup = OperationsFactory.eINSTANCE
						.createOperationGroup();
				operationGroup.setName("Suboperations");
				operationGroup.getOperations().addAll(subOps);
				TreeNode subOpsNode = new TreeNode(operationGroup);
				subOpsNode.setParent(treeNode);
				return new Object[] { subOpsNode };
			} else if (op instanceof CreateDeleteOperation) {
				CreateDeleteOperation cdo = (CreateDeleteOperation) op;
				List<ReferenceOperation> subOps = cdo.getSubOperations();
				OperationGroup operationGroup = OperationsFactory.eINSTANCE
						.createOperationGroup();
				operationGroup.setName("Suboperations");
				operationGroup.getOperations().addAll(subOps);
				TreeNode subOpsNode = new TreeNode(operationGroup);
				subOpsNode.setParent(treeNode);
				return new Object[] { subOpsNode };
			}
			Set<EObject> modelElements = changePackageVisualizationHelper
					.getAffectedElements(op);
			List<TreeNode> nodes = nodify(treeNode, new ArrayList<EObject>(
					modelElements));
			return nodes.toArray();
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return an array of {@link ModelElement}s
		 */
		@Override
		protected Object[] getChildren(HistoryInfo historyInfo,
				TreeNode treeNode) {
			if (historyInfo.getChangePackage() == null) {
				return new Object[0];
			}
			return getChildren(historyInfo.getChangePackage(), treeNode);
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return an array of {@link ModelElement}s
		 */
		@Override
		protected Object[] getChildren(ChangePackage changePackage,
				TreeNode treeNode) {
			Set<EObject> modelElements = null;
			if (changePackage.getLogMessage() == null) {
				ChangePackageVisualizationHelper helper = new ChangePackageVisualizationHelper(
						Arrays.asList(changePackage), project);
				modelElements = helper.getAllModelElements(changePackage);
			} else {
				modelElements = changePackageVisualizationHelper
						.getAllModelElements(changePackage);
			}
			List<TreeNode> nodes = nodify(treeNode, new ArrayList<EObject>(
					modelElements));
			return nodes.toArray();

		}

		/**
		 * {@inheritDoc}
		 * 
		 * @return an array of {@link AbstractOperation}s
		 */
		@Override
		protected Object[] getChildren(ModelElement modelElement,
				TreeNode treeNode) {
			if (treeNode.getParent().getValue() instanceof HistoryInfo) {
				HistoryInfo historyInfo = (HistoryInfo) treeNode.getParent()
						.getValue();
				ChangePackageVisualizationHelper helper = changePackageVisualizationHelper;
				if (historyInfo.getChangePackage().getLogMessage() == null) {
					helper = new ChangePackageVisualizationHelper(Arrays
							.asList(historyInfo.getChangePackage()), project);
				}
				ArrayList<EObject> operations = new ArrayList<EObject>(helper
						.getOperations(modelElement, historyInfo
								.getChangePackage()));
				List<TreeNode> nodes = nodify(treeNode, operations);
				if (isReverseNodes()) {
					Collections.reverse(nodes);
				}
				return nodes.toArray();
			} else if (treeNode.getParent().getValue() instanceof ChangePackage) {
				ChangePackage changePackage = (ChangePackage) treeNode
						.getParent().getValue();
				ChangePackageVisualizationHelper helper = changePackageVisualizationHelper;
				if (changePackage.getLogMessage() == null) {
					helper = new ChangePackageVisualizationHelper(Arrays
							.asList(changePackage), project);
				}
				ArrayList<EObject> operations = new ArrayList<EObject>(helper
						.getOperations(modelElement, changePackage));
				List<TreeNode> nodes = nodify(treeNode, operations);
				if (isReverseNodes()) {
					Collections.reverse(nodes);
				}
				return nodes.toArray();
			}
			return new Object[0];
		}

	}

}
