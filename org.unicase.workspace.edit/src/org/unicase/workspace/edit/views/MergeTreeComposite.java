/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.views;

import java.util.List;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.workspace.edit.views.changescomposite.CheckboxChangesTreeComposite;

/**
 * Composite for the merge tree viewer.
 * 
 * @author Shterev
 * 
 */
public class MergeTreeComposite extends CheckboxChangesTreeComposite {

	private TreeViewerColumn statusColumn;

	/**
	 * Default constructor.
	 * @param parent the parent composite
	 * @param style the style
	 * @param changes the initial input
	 */
	public MergeTreeComposite(Composite parent, int style, List<ChangePackage> changes) {
		super(parent, style, changes);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createAdditionalColumns(TreeViewer treeViewer) {
		
		
		// username column
		TreeViewerColumn tclmUsername = new TreeViewerColumn(treeViewer,
				SWT.NONE);
		tclmUsername.getColumn().setText("Username");
		tclmUsername.getColumn().setWidth(75);
		tclmUsername.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				return "";
			}
		});


		statusColumn = new TreeViewerColumn(treeViewer,
				SWT.NONE);
		statusColumn.getColumn().setText("Status");
		statusColumn.getColumn().setWidth(75);
		
		
		// currently status column is set using a random boolean
		statusColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Color getForeground(Object element) {
				if(element instanceof AbstractOperation){
					AbstractOperation op = (AbstractOperation)element;
					return (op.isAccepted()?Display.getCurrent().getSystemColor(SWT.COLOR_GREEN):Display.getCurrent().getSystemColor(SWT.COLOR_RED));
				}else{
					return super.getForeground(element);
				}
				
			}

			@Override
			public String getText(Object element) {
				if(element instanceof AbstractOperation){
					AbstractOperation op = (AbstractOperation) element;
					return (op.isAccepted()?"Accepted":"Rejected");
				}
				return "";
			}
			
		});
		
		

	}
	
	/**
	 * Get the status column.
	 * @return a tree viewer column
	 */
	public TreeViewerColumn getStatusColumn(){
		return this.statusColumn;
	}

}
