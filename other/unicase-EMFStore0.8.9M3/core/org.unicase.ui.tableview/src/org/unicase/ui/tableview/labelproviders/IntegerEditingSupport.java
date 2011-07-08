/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tableview.labelproviders;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.emfstore.client.model.util.EMFStoreCommand;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;

/**
 * This is editing support for columns showing integeral values.
 * 
 * @author zardosht
 */
public class IntegerEditingSupport extends EditingSupport {

	private EStructuralFeature feature;
	private TextCellEditor textCellEditor;

	/**
	 * Constructor.
	 * 
	 * @param viewer viewer
	 * @param feature structural feature being edited
	 */
	public IntegerEditingSupport(TableViewer viewer, EStructuralFeature feature) {
		super(viewer);
		this.feature = feature;
		this.textCellEditor = new TextCellEditor(viewer.getTable());
	}

	/**
	 * Constructor.
	 * 
	 * @param viewer viewer
	 * @param feature structural feature being edited
	 */
	public IntegerEditingSupport(TreeViewer viewer, EStructuralFeature feature) {
		super(viewer);
		this.feature = feature;
		this.textCellEditor = new TextCellEditor(viewer.getTree());
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#canEdit(java.lang.Object)
	 */
	@Override
	protected boolean canEdit(Object element) {
		if (element instanceof EObject) {
			EObject eObject = (EObject) element;
			return feature.getEType().equals(EcorePackage.Literals.EINT)
				&& eObject.eClass().getEAllStructuralFeatures().contains(feature);
		} else {
			return false;
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#getCellEditor(java.lang.Object)
	 */
	@Override
	protected CellEditor getCellEditor(Object element) {
		return textCellEditor;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#getValue(java.lang.Object)
	 */
	@Override
	protected Object getValue(Object element) {

		if (element instanceof EObject) {
			EObject eObject = (EObject) element;
			if (!eObject.eClass().getEAllStructuralFeatures().contains(feature)) {
				return "";
			}
			Object value = eObject.eGet(feature);
			if (value != null && value instanceof Integer) {
				return value.toString();
			}
		}
		return "";
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.EditingSupport#setValue(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected void setValue(Object element, Object value) {
		if (!(element instanceof EObject)) {
			return;
		}
		EObject eObject = (EObject) element;
		if (!eObject.eClass().getEAllStructuralFeatures().contains(feature)) {
			return;
		}
		if (value instanceof String) {
			String strValue = value.toString();
			if (strValue.matches("[0-9]*")) {
				doSetValue(eObject, Integer.parseInt(strValue));
				getViewer().refresh();
			}
		}

	}

	private void doSetValue(final EObject eObject, final Integer value) {
		new EMFStoreCommand() {
			@Override
			protected void doRun() {
				eObject.eSet(feature, value);
			}
		}.run();
	}

}
