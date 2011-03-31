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

import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * Composite for listing local/remote changes using a tree viewer with
 * selectable checkboxes.
 * 
 * @author Shterev
 */
public class CheckboxTreeComposite extends TreeComposite {

	/**
	 * The {@link CheckboxTreeViewer}.
	 */
	private CheckboxTreeViewer checkBoxViewer;

	/**
	 * Default constructor.
	 * 
	 * @param parent
	 *            the parent compostie
	 * @param style
	 *            the rendering style
	 */
	public CheckboxTreeComposite(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected TreeViewer createTreeViewer(Composite parent) {
		checkBoxViewer = new CheckboxTreeViewer(parent, SWT.FULL_SELECTION);
		return checkBoxViewer;
	}

}
