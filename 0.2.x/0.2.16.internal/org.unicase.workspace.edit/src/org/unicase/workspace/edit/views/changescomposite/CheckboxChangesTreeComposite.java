/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.views.changescomposite;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * Composite for listing local/remote changes using a tree viewer with selectable checkboxes.
 * @author Shterev
 *
 */
public class CheckboxChangesTreeComposite extends ChangesTreeComposite implements ICheckStateListener{
	
	/**
	 * The {@link CheckboxTreeViewer}.
	 */
	private CheckboxTreeViewer checkBoxViewer;

	/**
	 * Default constructor.
	 * @param parent the parent compostie
	 * @param style the rendering style
	 * @param changePackages the initial input
	 */
	public CheckboxChangesTreeComposite(Composite parent, int style, List<ChangePackage> changePackages) {
		super(parent, style, changePackages);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected TreeViewer createTreeViewer(Composite parent){
		checkBoxViewer = new CheckboxTreeViewer(this, SWT.FULL_SELECTION);
		checkBoxViewer.addCheckStateListener(this);
		return checkBoxViewer;
	}

	/**
	 * {@inheritDoc}
	 */
	public void checkStateChanged(CheckStateChangedEvent event) {
		Object element = event.getElement();
		if (element instanceof ChangePackage) {
			Object[] elements = ((ChangesTreeContentProvider) checkBoxViewer
					.getContentProvider()).getChildren(element);
			for (Object op : elements) {
				checkBoxViewer.setChecked(op, event.getChecked());
			}
		}
		if (element instanceof AbstractOperation) {
			EObject container = ((AbstractOperation) element)
					.eContainer();
			if (event.getChecked()) {
				checkBoxViewer.setGrayChecked(container, true);
				return;
			}
			Object[] elements = ((ChangesTreeContentProvider) checkBoxViewer
					.getContentProvider()).getChildren(container);
			boolean empty = true;
			for (Object o : elements) {
				if (checkBoxViewer.getChecked(o)) {
					empty = false;
					break;
				}
			}
			checkBoxViewer.setGrayChecked(container, !empty);
		}		
	}

}
