/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.validation;

import org.eclipse.emf.validation.service.ValidationEvent;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

/**
 * @author pfeifferc
 */
public class ValidationEditorInput implements IEditorInput {

	private ValidationEvent validationEvent;
	
	/**
	 * Default constructor.
	 * 
	 * @param validationEvent the
	 */
	public ValidationEditorInput(ValidationEvent validationEvent) {
		this.validationEvent = validationEvent;
	}

	/**
	 * Get the adapter object.
	 * @param adapter the
	 * @return the adapter
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {
		return null;
	}
	
	/**
	 * @return the tooltip text
	 */
	public String getToolTipText() {
		return "This is the input for the validation editor";
	}
	
	/**
	 * @return the persistable element
	 */
	public IPersistableElement getPersistable() {
		return null;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return "Validation editor";
	}
	
	/**
	 * @return the image descriptor
	 */
	public ImageDescriptor getImageDescriptor() {
		return Activator.getImageDescriptor("icons/validation.png");
	}
	
	/**
	 * @return exists
	 */
	public boolean exists() {
		return false;
	}
	
	/**
	 * @return the validation event
	 */
	public ValidationEvent getValidationEvent() {
		return validationEvent;
	}
}
