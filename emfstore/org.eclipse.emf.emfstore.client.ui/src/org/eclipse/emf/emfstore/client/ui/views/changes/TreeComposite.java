/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.views.changes;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

/**
 * This class is a composite containing a TreeViewer which shows the operations
 * of an input list of ChangePackages.
 * 
 * @author Shterev
 */
public class TreeComposite extends Composite {

	private TreeViewer treeViewer;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            parent
	 * @param style
	 *            style
	 */
	public TreeComposite(Composite parent, int style) {

		super(parent, style);
		setLayout(new GridLayout());
		this.treeViewer = createTreeViewer(this);
		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
	}

	/**
	 * Method for creating a {@link TreeViewer}.
	 * 
	 * @param parent
	 *            where the viewer should be created
	 * @return the {@link TreeViewer}
	 */
	protected TreeViewer createTreeViewer(Composite parent) {
		TreeViewer treeViewer = new TreeViewer(parent, SWT.FULL_SELECTION);
		return treeViewer;
	}

	/**
	 * Getter for this composite's active TreeViewer.
	 * 
	 * @return the TreeViewer.
	 */
	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

}
