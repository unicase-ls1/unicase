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
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.emfstore.esmodel.versioning.operations.AttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.CreateDeleteOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiAttributeOperation;
import org.unicase.emfstore.esmodel.versioning.operations.MultiReferenceOperation;
import org.unicase.emfstore.esmodel.versioning.operations.SingleReferenceOperation;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.decorators.OverlayImageDescriptor;
import org.unicase.workspace.WorkspaceManager;

/**
 * This class is a composite containing a TreeViewer which shows operations of
 * an input list of ChangePackages. This composite will be shown on
 * UpdateDialog, CommitDialog and ChangeBrowserView's browser tab. TreeViewer
 * has columns for ModelElement, Name and Description of the Operation.
 * 
 * @author Hodaie
 * @author Shterev
 * 
 */
public class ChangesTreeComposite extends Composite {

	private TreeViewer treeViewer;

	// input ChangePackages
	private List<ChangePackage> changePackages;
	private ChangePackageVisualizationHelper visualizationHelper;

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
				if (element instanceof AbstractOperation) {
					AbstractOperation operation = (AbstractOperation) element;
					ModelElement me = visualizationHelper
							.getModelElement(operation.getModelElementId());
					cell.setText(me.getName());
					cell.setImage(emfProvider.getImage(me));
				} else {
					cell.setText("Change Package");
				}
			}
		});

		// operation column
		TreeViewerColumn tclmOp = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmOp.getColumn().setText("Operation");
		tclmOp.getColumn().setWidth(getShell().getSize().x - 350);
		tclmOp.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public void update(ViewerCell cell) {
				Object element = cell.getElement();
				if (element instanceof AbstractOperation) {
					AbstractOperation op = (AbstractOperation) element;
					cell.setText(op.getName());
				} else {
					cell.setText("Change Package");
				}
				Image image = null;
				String overlay = null;
				if (element instanceof CreateDeleteOperation) {
					CreateDeleteOperation op = (CreateDeleteOperation) element;
					image = emfProvider.getImage(op.getModelElement());
					if (op.isDelete()) {
						overlay = "icons/delete_overlay.png";
					} else {
						overlay = "icons/add_overlay.png";
					}
				} else if (element instanceof AttributeOperation) {
					AttributeOperation op = (AttributeOperation) element;
					image = emfProvider.getImage(null);
					if (op.getNewValue() == null) {
						overlay = "icons/delete_overlay.png";
					} else if (op.getOldValue() == null) {
						overlay = "icons/add_overlay.png";
					} else {
						overlay = "icons/modify_overlay.png";
					}
				} else if (element instanceof SingleReferenceOperation) {
					SingleReferenceOperation op = (SingleReferenceOperation) element;
					if (op.getNewValue() == null) {
						overlay = "icons/delete_overlay.png";
						image = emfProvider.getImage(op.getOldValue());
					} else if (op.getOldValue() == null) {
						overlay = "icons/add_overlay.png";
						image = emfProvider.getImage(op.getNewValue());
					} else {
						overlay = "icons/modify_overlay.png";
						image = emfProvider.getImage(op.getNewValue());
					}
				} else if (element instanceof MultiAttributeOperation) {
					image = emfProvider.getImage(null);
					overlay = "icons/modify_overlay.png";
				} else if (element instanceof MultiReferenceOperation) {
					MultiReferenceOperation op = (MultiReferenceOperation) element;
					if (op.getReferencedModelElements().size() > 0) {
						image = emfProvider.getImage(op
								.getReferencedModelElements().get(0));
						overlay = "icons/link_overlay.png";
					}
				}
				if (image != null && overlay != null) {
					ImageDescriptor overlayDescriptor = org.unicase.ui.common.Activator
							.getImageDescriptor(overlay);
					OverlayImageDescriptor imageDescriptor = new OverlayImageDescriptor(
							image, overlayDescriptor,
							OverlayImageDescriptor.LOWER_RIGHT);
					cell.setImage(imageDescriptor.createImage());
				}

			}

			@Override
			public String getText(Object element) {
				if (element instanceof AbstractOperation) {
					AbstractOperation operation = (AbstractOperation) element;
					return operation.getName();
				}
				return "";

			}

			@Override
			public String getToolTipText(Object element) {
				if (element instanceof AbstractOperation) {
					AbstractOperation operation = (AbstractOperation) element;
					String desc = operation.getDescription();
					return (desc != null ? desc : "No description");
				}
				return "";
			}

			@Override
			public int getToolTipDisplayDelayTime(Object element) {
				return 0;
			}
		});
		ColumnViewerToolTipSupport.enableFor(treeViewer);

		createAdditionalColumns();
		treeViewer.expandAll();

	}

	/**
	 * Subclasses must override this method to creates additional columns.
	 */
	protected void createAdditionalColumns() {
	}

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
		this.visualizationHelper = new ChangePackageVisualizationHelper(
				changePackages, WorkspaceManager.getInstance()
						.getCurrentWorkspace().getActiveProjectSpace()
						.getProject());
		if (changePackages != null) {
			treeViewer.setInput(changePackages);
			treeViewer.expandAll();
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
