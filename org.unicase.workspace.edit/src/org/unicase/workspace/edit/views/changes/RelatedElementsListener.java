/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.views.changes;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnViewerToolTipSupport;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;

/**
 * A listener to display the model elements related to the current selection in the changes tree. Supports
 * ChangePackages, ModelElements, AbstractOperations as input.
 * 
 * @author Shterev
 */
public class RelatedElementsListener implements ISelectionChangedListener {
	private ILabelProvider emfProvider;
	private Composite affectedTableComposite;
	private TableViewer affectedTable;
	private Composite parent;
	private ChangePackageVisualizationHelper visualizationHelper;
	private TableViewerColumn affectedTableColumn;

	/**
	 * Default constructor.
	 * 
	 * @param parent the composite where the table should be painted in
	 * @param emfProvider the emfprovider for the visualization of the affected elements table.
	 * @param visualizationHelper the visualizationHelper for collecting the affected elements.
	 */
	public RelatedElementsListener(Composite parent, ILabelProvider emfProvider,
		ChangePackageVisualizationHelper visualizationHelper) {
		this.emfProvider = emfProvider;
		this.visualizationHelper = visualizationHelper;
		this.parent = parent;
	}

	/**
	 * {@inheritDoc}
	 */
	public void selectionChanged(SelectionChangedEvent event) {
		Object selected = ((TreeSelection) event.getSelection()).getFirstElement();
		if (affectedTable != null && !affectedTable.getTable().isDisposed()) {
			affectedTable.getTable().dispose();
			affectedTableComposite.dispose();
		}

		ColumnLabelProvider columnLabelProvider = new ColumnLabelProvider() {
			@Override
			public Image getImage(Object element) {
				return emfProvider.getImage(element);
			}

			@Override
			public String getText(Object element) {
				String text = emfProvider.getText(element);
				if (element == null || element instanceof ModelElementId) {
					text = "(Deleted Element)";
				}
				return text;
			}
		};
		if (selected instanceof AbstractOperation) {
			AbstractOperation operation = (AbstractOperation) selected;
			Set<EObject> affectedList = visualizationHelper.getAffectedElements(operation);
			if (affectedList.size() > 0) {
				createTable(parent, columnLabelProvider, affectedList, "Affected Model Elements");
			}
		} else if (selected instanceof ChangePackage) {
			ChangePackage cPackage = (ChangePackage) selected;
			Set<EObject> affectedList = visualizationHelper.getAllModelElements(cPackage);
			if (affectedList.size() > 0) {
				createTable(parent, columnLabelProvider, affectedList, "Included Model Elements");
			}
		} else if (selected instanceof ModelElement) {
			ModelElement me = (ModelElement) selected;
			Set<EObject> affectedList = visualizationHelper.getOperations(me);
			if (affectedList.size() > 0) {
				createTable(parent, new OperationsDescLabelProvider(emfProvider, visualizationHelper), affectedList,
					"Related Operations");
				GridDataFactory.fillDefaults().hint(400, 100).grab(false, true).applyTo(affectedTableComposite);
				affectedTableColumn.getColumn().setWidth(370);

			}
		}
		parent.layout(true);
	}

	private void createTable(Composite parent, CellLabelProvider labelProvider, Set<EObject> affected, String title) {
		affectedTableComposite = new Composite(parent, SWT.NONE);
		GridDataFactory.fillDefaults().hint(200, 100).grab(false, true).applyTo(affectedTableComposite);
		affectedTableComposite.setLayout(new GridLayout());
		affectedTable = new TableViewer(affectedTableComposite, SWT.SINGLE);
		ColumnViewerToolTipSupport.enableFor(affectedTable);
		affectedTable.getTable().setHeaderVisible(true);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(affectedTable.getTable());
		affectedTableColumn = new TableViewerColumn(affectedTable, SWT.LEFT);
		affectedTableColumn.getColumn().setText(title);
		affectedTableColumn.getColumn().setWidth(170);
		affectedTableColumn.getColumn().setResizable(false);
		affectedTableComposite.layout(true);

		affectedTableColumn.setLabelProvider(labelProvider);
		affectedTable.setContentProvider(new RelatedElementsContentProvider(affected));
		affectedTable.setInput(new Object());
	}
}