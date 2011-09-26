/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.review.controlbuilder;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Text;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.ui.urml.stakeholders.review.ReviewUtil;

/**
 * The review view widget for multi line text fields.
 * 
 * @author kterzieva
 */

public class MultiLineControlBuilder extends AbstractControlBuilder {

	private static final int PRIORITY = 1;

	/**
	 * Creates the widget for multi line text fields.
	 * 
	 * @param parent the parent composite
	 * @param urmlElement the urml element
	 * @return text the text as control
	 */
	
	public Control doCreateControl(Composite parent, UrmlModelElement urmlElement) {
		Text text = new Text(parent, SWT.BORDER | SWT.MULTI | SWT.WRAP | SWT.V_SCROLL);
		Object feature = getItemPropertyDescriptor().getFeature(urmlElement);
		
		text.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		text.setEditable(false);
		text.setText(ReviewUtil.getValueOfString(urmlElement.eGet((EStructuralFeature) feature)));
		
		GridData spec = new GridData(SWT.FILL, SWT.FILL, true, false);
		spec.heightHint = 100;
		text.setLayoutData(spec);
		
		return (Control) text;
		
	}
	
	/**
	 * Gives the render value.
	 * 
	 * @param itemPropertyDescriptor the item descriptor
	 * @param urmlElement the urml element
	 * @return int the value
	 */
	
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor,
			UrmlModelElement urmlElement) {
		if(itemPropertyDescriptor.isMultiLine(urmlElement)){
			Object feature = itemPropertyDescriptor.getFeature(urmlElement);
			if (feature instanceof EAttribute
					&& ((EAttribute) feature).getEType().getInstanceClass()
							.equals(String.class)) {
				return PRIORITY;
			}
		}
		return AbstractControlBuilder.DO_NOT_RENDER;
	}

}
