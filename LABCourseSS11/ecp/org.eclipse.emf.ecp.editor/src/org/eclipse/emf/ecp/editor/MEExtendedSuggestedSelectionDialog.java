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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;

/**
 * This dialog represents the possibility to select an element from a list where the list is sorted and additional
 * information can be provided. In addition first a filter can be selected for the items displayed in the list.
 * 
 * @author Birgit Engelmann
 */
public class MEExtendedSuggestedSelectionDialog extends
		MESuggestedSelectionDialog {
	
	private Combo contexts;
	
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
	public MEExtendedSuggestedSelectionDialog(String title, String message,
			boolean blockOnOpen, EObject baseElement, EReference reference,
			Collection<EObject> elements) {
		super(title, message, blockOnOpen, baseElement, reference, elements);
	}

	@Override
	protected Control createExtendedContentArea(Composite parent) {
		
		Label label = new Label(parent, SWT.WRAP);
		label.setText("Please select the context:");
		contexts = new Combo(parent, SWT.DROP_DOWN | SWT.BORDER | SWT.HORIZONTAL | SWT.SINGLE);
		Control[] children = parent.getChildren();
		Control firstChild = children[0];
		contexts.moveAbove(firstChild);
		label.moveAbove(contexts);
		return null;
	}

}
