/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.workspace.edit.views.changescomposite;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.ModelElement;

/**
 * 
 * @author Shterev
 *
 */
public class ChangesTreeSelectionListener implements
		ISelectionChangedListener {
	private ILabelProvider emfProvider;
	private Composite affectedTableComposite;
	private TableViewer affectedTable;
	private Composite parent;
	private ChangePackageVisualizationHelper visualizationHelper;
	
	/**
	 * Default constructor.
	 * @param treeViewer the treeviewer notifier. 
	 * @param emfProvider the emfprovider for the visualization of the affected elements table.
	 * @param visualizationHelper the visualizationHelper for collecting the affected elements.
	 */
	public ChangesTreeSelectionListener(TreeViewer treeViewer,
			ILabelProvider emfProvider, ChangePackageVisualizationHelper visualizationHelper) {
		this.emfProvider = emfProvider;
		this.visualizationHelper = visualizationHelper;
		parent = treeViewer.getControl().getParent();
	}

	/**
	 * {@inheritDoc}
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		Object selected = ((TreeSelection) event.getSelection())
				.getFirstElement();
		if (affectedTable != null
				&& !affectedTable.getTable().isDisposed()) {
			affectedTable.getTable().dispose();
			affectedTableComposite.dispose();
		}

		if (selected instanceof AbstractOperation) {
			AbstractOperation operation = (AbstractOperation) selected;
			Set<EObject> affectedList = visualizationHelper
					.getAffectedElements(operation);
			if (affectedList.size() > 0) {
				createAffectedElementsTable(parent,emfProvider, affectedList);
			}
		} else if (selected instanceof ChangePackage) {
			ChangePackage cPackage = (ChangePackage) selected;
			Set<EObject> affectedList = visualizationHelper
					.getAllModelElements(cPackage);
			if (affectedList.size() > 0) {
				createAffectedElementsTable(parent, emfProvider, affectedList);
			}
		} else if (selected instanceof ModelElement) {
			ModelElement me = (ModelElement) selected;
			Set<EObject> affectedList = visualizationHelper
					.getOperations(me);
			if (affectedList.size() > 0) {
				createAffectedElementsTable(parent, emfProvider, affectedList);
			}
		}
		parent.layout(true);
	}
	
	private void createAffectedElementsTable(Composite parent, final ILabelProvider emfProvider,
			Set<EObject> affected) {
		affectedTableComposite = new Composite(parent, SWT.NO_BACKGROUND);
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
		affectedTable.setContentProvider(new ChangesTreeAffectedProvider(
				affected));
		affectedTable.setInput(new Object());
	}
}