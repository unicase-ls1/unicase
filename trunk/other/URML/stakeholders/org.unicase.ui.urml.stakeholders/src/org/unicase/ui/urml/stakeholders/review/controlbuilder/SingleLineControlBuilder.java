/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.review.controlbuilder;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;
import org.unicase.ui.urml.stakeholders.review.ReviewUtil;

/**
 * The widgets to show a single line text attribute.
 * 
 * @author kterzieva
 * 
 */
public class SingleLineControlBuilder extends AbstractControlBuilder {

	private static final int PRIORITY = 1;
	//private EAttribute attribute;

	/**
	 * Gives the render value of this control.
	 * 
	 * @param itemPropertyDescriptor the item descriptor
	 * @param urmlElement the urml element
	 * @return int the value
	 */

	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor,
			UrmlModelElement urmlElement) {
		if(!itemPropertyDescriptor.isMultiLine(urmlElement)){
			Object feature = itemPropertyDescriptor.getFeature(urmlElement);
			if (feature instanceof EAttribute
					&& ((EAttribute) feature).getEType().getInstanceClass()
							.equals(String.class)) {
				return PRIORITY;
			}
		}
		return AbstractControlBuilder.DO_NOT_RENDER;
	}
	
	
	/**
	 * Creates the widget for reviewed fields.
	 * 
	 * @param parent the parent composite
	 * @param urmlElement the urml element
	 * @return check the check button
	 */
	
	protected Control doCreateControl(Composite parent, UrmlModelElement urmlElement) {
		EStructuralFeature feature = (EStructuralFeature) getItemPropertyDescriptor().getFeature(urmlElement);
		Label labelText = new Label(parent, SWT.BORDER);
	
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.horizontalAlignment = SWT.FILL;
		
		labelText.setLayoutData(gridData);
		
		DataBindingContext bindingContext = new DataBindingContext();
		bindingContext.bindValue(
				WidgetProperties.text().observe(labelText),
				EMFProperties.value(feature)
						.observe(urmlElement));
		
		return labelText;
	}

}
