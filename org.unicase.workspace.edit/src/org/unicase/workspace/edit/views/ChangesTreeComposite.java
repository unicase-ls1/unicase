/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.views;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeSelection;
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

	/**
	 * Label provider for the operation column in the viewer.
	 * 
	 * @author Shterev
	 * 
	 */
	private final class OperationColumnLabelProvider extends
			ColumnLabelProvider {
		private final ILabelProvider emfProvider;

		private OperationColumnLabelProvider(ILabelProvider emfProvider) {
			this.emfProvider = emfProvider;
		}

		@Override
		public void update(ViewerCell cell) {
			Object element = cell.getElement();
			if (element instanceof AbstractOperation) {
				AbstractOperation op = (AbstractOperation) element;
				cell.setText(op.getName());
				Image image = visualizationHelper.getImage(emfProvider, op);
				ImageDescriptor overlay = visualizationHelper
						.getOverlayImage(op);
				if (image != null && overlay != null) {
					OverlayImageDescriptor imageDescriptor = new OverlayImageDescriptor(
							image, overlay, OverlayImageDescriptor.LOWER_RIGHT);
					cell.setImage(imageDescriptor.createImage());
				}
			} else {
				cell.setText("Change Package");
			}

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
	}

	/**
	 * Content provider for the affected elements treeviewer. The class uses a
	 * helper class to gather the elements - @see
	 * {@link ChangePackageVisualizationHelper#getAffectedElements(AbstractOperation)}
	 * 
	 * @author Shterev
	 * 
	 */
	private final class AffectedElementsContentProvider extends
			AdapterFactoryContentProvider implements IContentProvider {

		private Set<ModelElement> affected;

		private AffectedElementsContentProvider(Set<ModelElement> affected) {
			super(new ComposedAdapterFactory(
					ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
			this.affected = affected;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public Object[] getElements(Object object) {
			return affected.toArray();
		}
	}

	private TreeViewer treeViewer;

	// input ChangePackages
	private List<ChangePackage> changePackages;
	private ChangePackageVisualizationHelper visualizationHelper;

	private Composite affectedTableComposite;

	private TableViewer affectedTable;

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
		this.setLayout(new GridLayout(2, false));
		createTreeViewer();
	}

	private void createAffectedTableComposite(final ILabelProvider emfProvider,
			Set<ModelElement> affected) {
		affectedTableComposite = new Composite(this, SWT.NO_BACKGROUND);
		GridDataFactory.fillDefaults().hint(200, 100).grab(false, true)
				.applyTo(affectedTableComposite);
		affectedTableComposite.setLayout(new GridLayout());
		affectedTable = new TableViewer(affectedTableComposite, SWT.SINGLE);
		affectedTable.getTable().setHeaderVisible(true);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(
				affectedTable.getTable());
		TableViewerColumn theList = new TableViewerColumn(affectedTable,
				SWT.LEFT);
		theList.getColumn().setText("Affected Model Elements");
		theList.getColumn().setWidth(170);
		theList.getColumn().setResizable(false);
		affectedTableComposite.layout(true);
		ChangesTreeComposite.this.layout(true);

		theList.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Image getImage(Object element) {
				return emfProvider.getImage(element);
			}

			@Override
			public String getText(Object element) {
				return emfProvider.getText(element);
			}
		});
		affectedTable.setContentProvider(new AffectedElementsContentProvider(
				affected));
		affectedTable.setInput(new Object());
	}

	private void createTreeViewer() {
		final ILabelProvider emfProvider = new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		treeViewer = new TreeViewer(this, SWT.FULL_SELECTION);
		Tree tree = treeViewer.getTree();
		tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tree.setHeaderVisible(true);
		tree.setLinesVisible(true);
		treeViewer.setContentProvider(new ChangesTreeContentProvider());
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			public void selectionChanged(SelectionChangedEvent event) {
				Object selected = ((TreeSelection) event.getSelection())
						.getFirstElement();
				if (affectedTable != null
						&& !affectedTable.getTable().isDisposed()) {
					affectedTable.getTable().dispose();
					affectedTableComposite.dispose();
					ChangesTreeComposite.this.layout(true);
				}
				if (selected instanceof AbstractOperation) {
					AbstractOperation operation = (AbstractOperation) selected;
					Set<ModelElement> affectedList = visualizationHelper
							.getAffectedElements(operation);
					if (affectedList.size() > 0) {
						createAffectedTableComposite(emfProvider, affectedList);
					}
				}
			}

		});

		// the changed model element
		TreeViewerColumn tclmME = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmME.getColumn().setWidth(200);
		tclmME.getColumn().setText("ModelElement");
		tclmME.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public void update(ViewerCell cell) {
				Object element = cell.getElement();
				if (element instanceof AbstractOperation) {
					AbstractOperation operation = (AbstractOperation) element;
					ModelElement me = visualizationHelper
							.getModelElement(operation.getModelElementId());
					// hack for missing model elements
					if (me != null) {
						cell.setText(me.getName());
						cell.setImage(emfProvider.getImage(me));
					} else {
						cell.setText("(Missing ELement)");
					}
				} else {
					cell.setText("Change Package");
				}
			}
		});

		// operation column
		TreeViewerColumn tclmOp = new TreeViewerColumn(treeViewer, SWT.NONE);
		tclmOp.getColumn().setText("Operation");
		tclmOp.getColumn().setWidth(150);// getShell().getSize().x - 350);
		tclmOp.setLabelProvider(new OperationColumnLabelProvider(emfProvider));
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
