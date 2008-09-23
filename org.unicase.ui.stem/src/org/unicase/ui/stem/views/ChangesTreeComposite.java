/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views;

import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.ModelElement;
import org.unicase.workspace.WorkspaceManager;

/**
 * This class is a composite containing a TreeViewer which shows operations of
 * an input list of ChangePackages. This composite will be shown on UpdateDialog,
 * CommitDialog and ChangeBrowserView's browser tab. TreeViewer has
 * columns for ModelElement, Name and Description of the Operation. 
 * 
 * @author Hodaie
 * @author Shterev
 * 
 */
public class ChangesTreeComposite extends Composite {

	private TreeViewer treeViewer;

	// input ChangePackages
	private List<ChangePackage> changePackages;

	/**
	 * . Constructor
	 * 
	 * @param parent
	 *            parent
	 * @param style
	 *            style
	 */
	public ChangesTreeComposite(Composite parent, int style) {
		super(parent, style);
		this.setLayout(new GridLayout());
		createTreeViewer();
	}

	private void createTreeViewer() {
		treeViewer = new TreeViewer(this, SWT.FULL_SELECTION);
		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		treeViewer.setContentProvider(new ChangesTreeContentProvider());

		// the changed model element
		TreeViewerColumn tclmME = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmME.getColumn().setWidth(250);
		tclmME.getColumn().setText("ModelElement");
		final ILabelProvider emfProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		tclmME.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public void update(ViewerCell cell) {
				Object element = cell.getElement();
				if(element instanceof AbstractOperation){
					AbstractOperation operation = (AbstractOperation) element;
					ModelElement me = WorkspaceManager.getInstance()
							.getCurrentWorkspace().getActiveProjectSpace()
							.getProject().getModelElement(
									operation.getModelElementId());
					cell.setText(me.getName());
					cell.setImage(emfProvider.getImage(me));
				}else{
					cell.setText("Change Package");
				}
			}
		});

		// operation column
		TreeViewerColumn tclmOp = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmOp.getColumn().setText("Operation");
		tclmOp.getColumn().setWidth(150);
		tclmOp.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if(element instanceof AbstractOperation){
					AbstractOperation operation = (AbstractOperation) element;
					return operation.getName();
				}
				return "";

			}
			@Override
			public String getToolTipText(Object element) {
				if(element instanceof AbstractOperation){
					AbstractOperation operation = (AbstractOperation) element;
					return operation.getDescription();
				}
				return "";
			}
		});

		// description column
		final TreeViewerColumn tclmDescription = new TreeViewerColumn(treeViewer,
				SWT.NONE);
		tclmDescription.getColumn().setText("Description");
		tclmDescription.getColumn().setWidth(100);
		tclmDescription.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				if(element instanceof AbstractOperation){
					AbstractOperation operation = (AbstractOperation) element;
					return operation.getDescription();
				}
				return "";
			}
		});

		createOtherColumns();

	}

	/**
	 * Subclasses must override this method to creates additional columns.
	 */
	protected void createOtherColumns() {}

	/**
	 * get number of operations to show at top of tree.
	 * 
	 * @return number of operations
	 */
	public int getNumOfChanges() {
		int sum = 0;
		if (changePackages != null) {
			for (ChangePackage cp : changePackages) {
				sum += cp.getOperations().size();
			}
		}
		return sum;
	}

	/**
	 * Set input ChangePackage whose operations will be shown in tree.
	 * 
	 * @param changePackages
	 *            the input ChangePackages
	 */
	public void setInput(List<ChangePackage> changePackages) {
		this.changePackages = changePackages;
		if (changePackages != null) {
			treeViewer.setInput(changePackages);
		}

	}

	/**
	 * Getter for the change packages.
	 * 
	 * @return input ChangePackages
	 */
	public List<ChangePackage> getChangePackages() {
		return changePackages;
	}

	/**
	 * @return the treeViewer
	 */
	public TreeViewer getTreeViewer() {
		return treeViewer;
	}

}
