/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.statusview;

import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.commands.ActionHelper;
import org.unicase.ui.stem.views.TaskTableUtil;

/**
 * .
 * 
 * This class provides contents of users tab in Status view. It contains a
 * TreeViewer showing all OrgUnits participating in progress of input model
 * element. The TreeView has only two levels. At root level are the OrgUnits.
 * The children are Assignables corresponding the input element which are
 * assigned to this OrgUnit.
 * 
 * @author Hodaie
 * 
 */
public class UserTabComposite extends Composite {

	private TreeViewer treeViewer;

	// private ModelElement input;

	/**
	 * . Constructor
	 * 
	 * @param parent
	 *            parent
	 * @param style
	 *            style
	 */
	public UserTabComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTree();
	}

	private void createTree() {
		treeViewer = new TreeViewer(this, SWT.BORDER);
		treeViewer.getTree().setLayoutData(
				new GridData(SWT.FILL, SWT.FILL, true, true));

		UserTabContentProvider contentProvider = new UserTabContentProvider();
		treeViewer.setContentProvider(contentProvider);
		treeViewer.setLabelProvider(new UserTabLabelProvider());
		treeViewer.setComparator(new ViewerComparator());
		TaskTableUtil.addColumns(treeViewer);

		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			public void doubleClick(DoubleClickEvent event) {
				IStructuredSelection sel = (IStructuredSelection) event
						.getSelection();
				if (sel.getFirstElement() instanceof ModelElement) {
					ActionHelper
							.openModelElement((ModelElement) sel
									.getFirstElement(), treeViewer.getClass()
									.getName());
				}
			}

		});
	}

	/**
	 * . set input to TreeViewer
	 * 
	 * @param me
	 *            input model element
	 */
	public void setInput(ModelElement me) {
		// this.input = me;
		treeViewer.setInput(me);

	}

}
