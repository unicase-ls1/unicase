/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;

/**
 * A View displaying the model changes in a single ChangePackage.
 */

/**
 * @author koegel
 */
public class StructuralView extends ViewPart implements ISelectionListener {

	/**
	 * The ID.
	 */
	public static final String ID = "org.unicase.model.compare.views.StructuralView";

	private TreeViewer viewer;

	private Project project;

	/**
	 * The constructor.
	 */
	public StructuralView() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		GridLayoutFactory.fillDefaults().applyTo(parent);
		viewer = new TreeViewer(parent, SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				if (event.getSelection() instanceof IStructuredSelection) {
					Object firstElement = ((IStructuredSelection) event
							.getSelection()).getFirstElement();
					if (firstElement instanceof ModelElement) {
						ActionHelper.openModelElement(
								(ModelElement) firstElement, ID);
					}
				}

			}
		});
		GridDataFactory.fillDefaults().grab(true, true).applyTo(
				viewer.getControl());
		parent.setBackground(Display.getCurrent()
				.getSystemColor(SWT.COLOR_CYAN));
	}

	/**
	 * Sets the input.
	 * 
	 * @param projectSpace
	 *            the project space
	 */
	public void setInput(ProjectSpace projectSpace) {
		project = projectSpace.getProject();
		AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		AdapterFactoryContentProvider adapterFactoryContentProvider = new AdapterFactoryContentProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getSelectionService().addSelectionListener(this);
		viewer.setContentProvider(adapterFactoryContentProvider);
		viewer.setLabelProvider(adapterFactoryLabelProvider);
		viewer.setInput(projectSpace);
		viewer.refresh();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	// BEGIN COMPLEX CODE
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1) {
				Object node = structuredSelection.getFirstElement();
				if (node instanceof TreeNode) {
					Object element = ((TreeNode) node).getValue();
					if (element instanceof ModelElement) {
						ModelElementId modelElementId = ((ModelElement) element)
								.getModelElementId();
						revealME(project.getModelElement(modelElementId));
					} else if (element instanceof CompositeOperation) {
						CompositeOperation comop = (CompositeOperation) element;
						AbstractOperation mainOperation = comop
								.getMainOperation();
						if (mainOperation != null) {
							ModelElementId modelElementId = mainOperation
									.getModelElementId();
							revealME(project.getModelElement(modelElementId));
						}
					} else if (element instanceof AbstractOperation) {
						ModelElementId modelElementId = ((AbstractOperation) element)
								.getModelElementId();
						revealME(project.getModelElement(modelElementId));
					}
				}
			}
		}
	}

	// END COMPLEX CODE

	private void revealME(ModelElement me) {

		if (me == null) {
			return;
		}
		viewer.collapseAll();

		// hack
		// if (!viewer.getExpandedState(me)) {
		// viewer.expandToLevel(2);
		// }

		// we could easily use the following method.
		// but it has the problem that it shows the first occurrence of and
		// element.
		// for example if we have the same element somewhere else linked, and
		// shown as a child (e.g. in
		// ActionItemMeetingSection),
		// it just show the first one that it finds. We want only the real
		// containment to be shown.
		// // TreeView.getTreeViewer().setSelection(new StructuredSelection(me),
		// true);

		EObject container = me.eContainer();
		viewer.setSelection(new StructuredSelection(container), true);

		TreeSelection treeSelection = (TreeSelection) viewer.getSelection();
		if (treeSelection.getPaths().length > 0) {
			TreePath treePath = treeSelection.getPaths()[0].createChildPath(me);

			TreeSelection newTreeSeleciton = new TreeSelection(treePath);
			viewer.setSelection(newTreeSeleciton, true);
		}
	}
}