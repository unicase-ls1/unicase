package org.unicase.ui.urml.stakeholders.associationrules;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.unicase.ui.urml.stakeholders.stakeholdernavigation.Activator;


public class CheckboxEditingSupport extends EditingSupport {

	

	private final TableViewer viewer;
	private EClass columnClass;
	private AssociationRulesView rulesView;

	public CheckboxEditingSupport(TableViewer viewer,EClass columnClass, AssociationRulesView rulesView) {
		super(viewer);
		this.viewer = viewer;
		this.columnClass = columnClass;
		this.rulesView = rulesView;
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		//viewer.getTable()
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
	protected void setValue(Object element, Object value) {
		value = true;
		viewer.refresh();
	}

}
