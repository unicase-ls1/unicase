/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views;

import java.util.Random;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;

/**
 * Composite for the merge tree viewer.
 * 
 * @author Shterev
 * 
 */
public class MergeTreeComposite extends ChangesTreeComposite {

	/**
	 * Default constructor.
	 * @param parent the parent composite
	 * @param style the style
	 */
	public MergeTreeComposite(Composite parent, int style) {
		super(parent, style);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createOtherColumns() {
		
		
		// username column
		TreeViewerColumn tclmUsername = new TreeViewerColumn(getTreeViewer(),
				SWT.NONE);
		tclmUsername.getColumn().setText("Username");
		tclmUsername.getColumn().setWidth(100);
		tclmUsername.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if(element instanceof AbstractOperation){
					AbstractOperation operation = (AbstractOperation) element;
					return operation.getUsername();
				}
				return "";

			}
		});


		// status column
		TreeViewerColumn tclmStatus = new TreeViewerColumn(getTreeViewer(),
				SWT.NONE);
		tclmStatus.getColumn().setText("Status");
		tclmStatus.getColumn().setWidth(100);
		
		
		final Random rnd = new Random();
		// currently status column is set using a random boolean
		tclmStatus.setLabelProvider(new ColumnLabelProvider() {
			private boolean accepted;

			@Override
			public Color getForeground(Object element) {
				return (accepted?Display.getCurrent().getSystemColor(SWT.COLOR_GREEN):Display.getCurrent().getSystemColor(SWT.COLOR_RED));
			}

			@Override
			public String getText(Object element) {
				if(element instanceof AbstractOperation){
					AbstractOperation operation = (AbstractOperation) element;
					accepted = isAccepted(operation); 
					return (accepted?"Accepted":"Rejected");
				}
				return "";
			}

			// a dummy method.
			private boolean isAccepted(AbstractOperation operation) {
				return rnd.nextBoolean();
			}
		});

	}

}
