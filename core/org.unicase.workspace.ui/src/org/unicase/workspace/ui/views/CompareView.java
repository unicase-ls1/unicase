/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views;

import java.util.Arrays;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.part.ViewPart;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ui.views.changes.ChangePackageVisualizationHelper;
import org.unicase.workspace.ui.views.scm.SCMContentProvider;
import org.unicase.workspace.ui.views.scm.SCMLabelProvider;

/**
 * A View displaying the model changes in a single ChangePackage.
 */

/**
 * @author t61
 */
public class CompareView extends ViewPart {

	/**
	 * The ID.
	 */
	public static final String ID = "org.unicase.model.compare.views.CompareView";

	private TreeViewer viewer;

	/**
	 * The constructor.
	 */
	public CompareView() {
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
					TreeNode node = (TreeNode) ((IStructuredSelection) event.getSelection()).getFirstElement();
					if (node.getValue() instanceof ModelElement) {
						ActionHelper.openModelElement((ModelElement) node.getValue(), ID);
					}
				}

			}
		});
		GridDataFactory.fillDefaults().grab(true, true).applyTo(viewer.getControl());
		parent.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_CYAN));
	}

	/**
	 * Sets the input.
	 * 
	 * @param project the project
	 * @param changePackage the change package
	 */
	public void setInput(Project project, ChangePackage changePackage) {
		SCMContentProvider.Detailed contentProvider = new SCMContentProvider.Detailed(viewer, project);
		contentProvider.setShowRootNodes(false);
		SCMLabelProvider labelProvider = new SCMLabelProvider(project);
		labelProvider.setChangePackageVisualizationHelper(new ChangePackageVisualizationHelper(Arrays
			.asList(changePackage), project));
		contentProvider.setChangePackageVisualizationHelper(new ChangePackageVisualizationHelper(Arrays
			.asList(changePackage), project));
		viewer.setContentProvider(contentProvider);
		viewer.setLabelProvider(labelProvider);
		viewer.setInput(changePackage);
		viewer.refresh();
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}