/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.actions;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.unicase.model.ModelElement;
import org.unicase.model.task.TaskPackage;
import org.unicase.ui.common.TableViewerColumnSorter;
import org.unicase.ui.sorters.StatusSorter;
import org.unicase.ui.tableview.labelproviders.DateColumnLabelProvider;
import org.unicase.ui.tableview.labelproviders.MEAttributeLabelProvider;
import org.unicase.ui.tableview.labelproviders.StatusLabelProvider;
import org.unicase.ui.tableview.util.UnicaseTableViewUtil;

/**
 * An Action for adding UnicaseTableView Columns.
 * 
 * @author Abdelhamid Barzali.
 */
public class SetColumnAction extends Action {

	private String menuitem;
	private IItemPropertyDescriptor propertydescriptor;
	private ModelElement modelelement;
	private TableViewer tableViewer;

	/**
	 * @return TableViewer.
	 */
	public TableViewer getTableViewer() {
		return tableViewer;
	}

	/**
	 * @param tableViewer TableViewer.
	 */
	public void setTableViewer(TableViewer tableViewer) {
		this.tableViewer = tableViewer;
	}

	/**
	 * @param tableViewer TableViewer.
	 * @param modelelement {@link ModelElement}.
	 * @param propertydescriptor {@link IItemPropertyDescriptor}.
	 */
	public SetColumnAction(TableViewer tableViewer, ModelElement modelelement,
		IItemPropertyDescriptor propertydescriptor) {
		super(null, SWT.TOGGLE);
		setTableViewer(tableViewer);
		this.modelelement = modelelement;
		this.propertydescriptor = propertydescriptor;
		this.menuitem = propertydescriptor.getDisplayName(this.modelelement);
		setMenuitem(menuitem);
		// Sets the text for this action.
		setText(menuitem);
		// Sets the unique identifier for this action.
		setId(menuitem);

	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {

		Table table = getTableViewer().getTable();
		setColumns(table);

	}

	/**
	 * @param table
	 * @see {@link Table}.
	 */
	private void setColumns(Table table) {
		if (table != null) {
			ColumnLabelProvider attributeLabelProvider = null;
			ViewerComparator comp = null;
			TableColumn[] columns = table.getColumns();

			for (int i = 0; i < columns.length; i++) {

				if (columns[i].getText() == getMenuitem() || columns[i].getText().equals(getMenuitem())) {

					if (columns[i].getText().equalsIgnoreCase("Name") || columns[i].getText() == "Name") {
						setChecked(true);
						return;
					}

					columns[i].setWidth(0);
					// UnicaseTableViewUtil.resizeColumns(tableViewer);

					this.setChecked(false);
					return;
				}

			}

			EStructuralFeature estructuralfeature = (EStructuralFeature) propertydescriptor.getFeature(modelelement);

			if (estructuralfeature.getEType().getInstanceClass().equals(boolean.class)) {

				estructuralfeature = TaskPackage.Literals.CHECKABLE__CHECKED;

			}
			if (estructuralfeature.getEType().equals(EcorePackage.Literals.EDATE)) {
				attributeLabelProvider = new DateColumnLabelProvider(estructuralfeature);

			} else

			if (menuitem.equalsIgnoreCase("status")) {
				attributeLabelProvider = new StatusLabelProvider();
			}

			else {
				attributeLabelProvider = new MEAttributeLabelProvider(propertydescriptor, estructuralfeature);

			}
			// create Columns.
			this.setChecked(true);
			TableViewerColumn column = new TableViewerColumn(getTableViewer(), SWT.CENTER);

			column.getColumn().setText(getMenuitem());
			column.getColumn().setWidth(100 + getMenuitem().length() * 10);
			column.getColumn().setMoveable(true);
			column.getColumn().setResizable(true);
			column.getColumn().setAlignment(SWT.CENTER);
			column.setLabelProvider(attributeLabelProvider);

			// set Column sorters

			if (getMenuitem().equalsIgnoreCase("status")) {
				comp = new StatusSorter(getTableViewer(), column, attributeLabelProvider);

			} else {
				comp = new TableViewerColumnSorter(getTableViewer(), column, attributeLabelProvider);
			}

			getTableViewer().setComparator(comp);
			column.getViewer().refresh();

			UnicaseTableViewUtil.resizeColumns(tableViewer);

			// }
		}
	}

	/**
	 * @return String.
	 */
	public String getMenuitem() {
		return menuitem;
	}

	/**
	 * @param menuitem String.
	 */
	public void setMenuitem(String menuitem) {
		this.menuitem = menuitem;
	}
}
