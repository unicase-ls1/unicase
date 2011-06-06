/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.editor;

import java.util.Collection;
import java.util.HashMap;

import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecp.common.model.ECPModelelementContext;
import org.eclipse.emf.ecp.common.util.UiUtil;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

/**
 * This dialog represents the possibility to select an element from a list where the list is sorted and additional
 * information can be provided. In addition first a filter can be selected for the items displayed in the list.
 * 
 * @author Birgit Engelmann
 */
public class MEExtendedSuggestedSelectionDialog extends
		MESuggestedSelectionDialog {
	
	private Combo contextControl;
	private ECPModelelementContext currentContext;
	private HashMap<String, ECPModelelementContext> currentContextNeighbours;
	private EObject baseElement;
	private EReference eReference;
	private boolean isAssociationClass;

	/**
	 * The constructor.
	 * 
	 * @param title The title of the dialog
	 * @param message the message displayed
	 * @param blockOnOpen block
	 * @param elements The elements, which can be selected.
	 * @param baseElement The element, to which the selection is made and to which other elements are compared.
	 * @param reference the reference for which this is used
	 */
//	public MEExtendedSuggestedSelectionDialog(String title, String message,
//			boolean blockOnOpen, EObject baseElement, EReference reference,
//			Collection<EObject> elements) {
//		super(title, message, blockOnOpen, baseElement, reference, elements);
//	}

	public MEExtendedSuggestedSelectionDialog(String title, String message, 
			boolean blockOnOpen, EObject baseElement, EReference reference, 
			ECPModelelementContext context, boolean isAssociationClass) {
		super(title, message, blockOnOpen, baseElement, reference,
				context.getAllModelElements());
		this.baseElement = baseElement;
		this.eReference = reference;
		this.isAssociationClass = isAssociationClass;
		this.currentContext = context;
//		currentContextNeighbours = new HashMap<String, ECPModelelementContext>();
		updateModelElements();
	}
	
	private void updateModelElements() {
		setModelElements(createAllModelElementsList());
		currentContextNeighbours = new HashMap<String, ECPModelelementContext>();
		for (ECPModelelementContext tempContext : currentContext.getNeighbors()) {
			currentContextNeighbours.put(tempContext.toString(), tempContext);
		}		
	}

	private Collection<EObject> createAllModelElementsList() {
		if (isAssociationClass) {
			return currentContext.getAllModelElementsbyClass(baseElement.eClass(), false);
		} else {
			Collection<EObject> result = null;
			result = currentContext.getAllModelElementsbyClass(eReference.getEReferenceType(), true);
			return result;
		}
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		
		Label label = new Label(parent, SWT.WRAP);
		label.setText("Please select the context:");
		contextControl = new Combo(parent, SWT.DROP_DOWN | SWT.BORDER | SWT.HORIZONTAL | SWT.SINGLE);
		Control firstChild = parent.getChildren()[0];
		contextControl.moveAbove(firstChild);
		label.moveAbove(contextControl);
		
		for (String key : currentContextNeighbours.keySet()) {
			contextControl.add(key);
			if(key.equals(currentContext.toString())){
				contextControl.select(contextControl.getItemCount()-1);
			}
		}
		
		ISWTObservableValue obs = SWTObservables.observeSingleSelectionIndex(contextControl);
		obs.addValueChangeListener(new IValueChangeListener() {
			
			public void handleValueChange(ValueChangeEvent event) {
				currentContext = currentContextNeighbours.get(contextControl.getItem((Integer) event.getObservableValue().getValue()));
				updateModelElements();
			}
		});
		return null;
	}
	
	public Combo getContextControl() {
		return contextControl;
	}
}
