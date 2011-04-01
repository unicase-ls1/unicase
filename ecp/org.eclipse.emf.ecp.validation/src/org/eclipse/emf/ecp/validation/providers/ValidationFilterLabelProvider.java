/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.validation.providers;

import org.eclipse.emf.ecp.validation.Activator;
import org.eclipse.emf.ecp.validation.filter.ValidationFilter;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * The label provider for the validation filter.
 * 
 * @author pfeifferc
 */
public class ValidationFilterLabelProvider extends LabelProvider {

	private static final String DESC_NA = "There is no description available for this specific filter.";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage(Object element) {
		if (element instanceof ValidationFilter) {
			ValidationFilter validationFilter = (ValidationFilter) element;
			Image image = validationFilter.getImage();
			if (image != null) {
				return image;
			}
		}
		return Activator.getImageDescriptor("icons/defaultfiltericon.png").createImage();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(Object element) {
		if (element instanceof ValidationFilter) {
			ValidationFilter validationFilter = (ValidationFilter) element;
			String description = validationFilter.getName();
			if (description != null && !description.equals("")) {
				return description;
			}
		}
		return DESC_NA;
	}
}
