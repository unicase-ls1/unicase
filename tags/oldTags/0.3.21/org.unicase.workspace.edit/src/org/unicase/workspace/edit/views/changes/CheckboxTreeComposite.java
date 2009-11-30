/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.views.changes;

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
 * 
 * @author Shterev
 */
public class CheckboxTreeComposite extends TreeComposite implements ICheckStateListener {

	/**
	 * The {@link CheckboxTreeViewer}.
	 */
	private CheckboxTreeViewer checkBoxViewer;

	/**
	 * Default constructor.
	 * 
	 * @param parent the parent compostie
	 * @param style the rendering style
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
		checkBoxViewer.addCheckStateListener(this);
		return checkBoxViewer;
	}

	/**
	 * {@inheritDoc}
	 */
	public void checkStateChanged(CheckStateChangedEvent event) {
		Object element = event.getElement();
		if (element instanceof ChangePackage) {
			Object[] elements = ((DetailedChangesContentProvider) checkBoxViewer.getContentProvider())
				.getChildren(element);
			for (Object op : elements) {
				checkBoxViewer.setChecked(op, event.getChecked());
			}
		}
		if (element instanceof AbstractOperation) {
			EObject container = ((AbstractOperation) element).eContainer();
			Object[] elements = ((DetailedChangesContentProvider) checkBoxViewer.getContentProvider())
				.getChildren(container);
			int checked = 0;
			for (Object o : elements) {
				if (checkBoxViewer.getChecked(o)) {
					checked++;
				}
			}
			if (checked == elements.length) {
				checkBoxViewer.setGrayChecked(container, false);
				checkBoxViewer.setChecked(container, true);
			} else if (checked > 0) {
				checkBoxViewer.setChecked(container, false);
				checkBoxViewer.setGrayChecked(container, true);
			} else {
				checkBoxViewer.setGrayChecked(container, false);
				checkBoxViewer.setChecked(container, false);
			}
		}
	}
}
