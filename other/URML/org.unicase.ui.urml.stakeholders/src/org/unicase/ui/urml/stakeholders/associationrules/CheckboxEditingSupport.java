/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.urml.stakeholders.associationrules;

import java.util.ArrayList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.unicase.ui.urml.stakeholders.stakeholdernavigation.Activator;

/**
 * Supports the editing of table cell content..
 * @author kterzieva
 *
 */
public class CheckboxEditingSupport extends EditingSupport {

	private final TableViewer viewer;
	private EClass columnClass;
	private AssociationRulesView rulesView;
	private TableViewerColumn tableViewerColumn;
	private static final Image CHECKED = Activator.getImageDescriptor("icons/checked.gif").createImage();

	/**
	 * The construct.
	 * @param rulesView the view which contains the table view
	 * @param viewer the table view
	 * @param columnClass 
	 * @param sortedElementNames 
	 * @param viewerColumn 
	 */
	public CheckboxEditingSupport( AssociationRulesView rulesView, TableViewer viewer,EClass columnClass, ArrayList<EClass> sortedElementNames, TableViewerColumn viewerColumn) {
		super(viewer);
		this.viewer = viewer;
		this.columnClass = columnClass;
		this.rulesView = rulesView;
		this.tableViewerColumn = viewerColumn;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		return new CheckboxCellEditor(null, SWT.CHECK| SWT.READ_ONLY);
	}

	@Override
	protected boolean canEdit(Object element) {
		return true;
	}

	@Override
	protected Object getValue(Object element) {		
		return rulesView.hasAssociation((EClass)element, columnClass);
	}

	@Override
	protected void setValue(final Object element, Object value) {
		//schreibt ins datenmodel TODO
		//refresh ruft der label provider noch mal auf, 
		//dieser muss für jede zelle die info aus dem model lesen TODO
		if(!rulesView.hasAssociation(columnClass, (EClass) element )&& ! rulesView.hasAssociation((EClass) element, columnClass )){		
			tableViewerColumn.setLabelProvider(new CellLabelProvider() {
				
				@Override
				public void update(ViewerCell cell) {
					if(cell.getElement().equals(element)){
						cell.setImage(CHECKED);
					}
				}
			});
		viewer.refresh();
	}
}
}