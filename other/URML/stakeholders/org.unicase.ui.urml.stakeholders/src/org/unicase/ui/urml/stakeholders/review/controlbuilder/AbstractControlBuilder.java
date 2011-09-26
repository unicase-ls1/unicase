/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.urml.stakeholders.review.controlbuilder;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.unicase.ecp.model.ECPModelelementContext;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.ui.urml.stakeholders.review.IDisposable;

/**
 * Abstract class for displaying the review view controls.
 * 
 * @author kterzieva
 */

public abstract class AbstractControlBuilder implements IDisposable {

	/**
	 * The default constant in case the widgets decides it shouldn't render the attribute.
	 */
	public static final int DO_NOT_RENDER = -1;

	/**
	 * the modelElement.
	 */
	private UrmlModelElement urmlElement;

	private boolean showLabel;

	private IItemPropertyDescriptor itemPropertyDescriptor;

	private ECPModelelementContext context;
	
	private Control createdControl;

	/**
	 * Setter for the {@link IItemPropertyDescriptor}.
	 * 
	 * @param itemPropertyDescriptor the {@link IItemPropertyDescriptor}
	 */

	public void setItemPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
		this.itemPropertyDescriptor = itemPropertyDescriptor;
	}

	/**
	 * Getter for the {@link IItemPropertyDescriptor}.
	 * 
	 * @return the {@link IItemPropertyDescriptor}
	 */
	public IItemPropertyDescriptor getItemPropertyDescriptor() {
		return itemPropertyDescriptor;
	}

	/**
	 * Creates the widget for this control.
	 * 
	 * @param parent the parent composite
	 * @param itemPropertyDescriptor the {@link IItemPropertyDescriptor}
	 * @param urmlElement the model element
	 * @param context the context
	 * @return the widget
	 */
	public Control createControl(Composite parent, IItemPropertyDescriptor itemPropertyDescriptor,
		ECPModelelementContext context, UrmlModelElement urmlElement) {
		this.urmlElement = urmlElement;
		this.context = context;
		this.setItemPropertyDescriptor(itemPropertyDescriptor);
		createdControl = doCreateControl(parent, urmlElement);
		return createdControl;
	}

	/**
	 * Creates the control.
	 * @param parent the parent composite
	 * @param urmlElement the urml element
	 * @return the control which was created
	 */
	protected abstract Control doCreateControl(Composite parent, UrmlModelElement urmlElement);

	
	/**
	 * @param showLabel the showLabel to set
	 */
	public void setShowLabel(boolean showLabel) {
		this.showLabel = showLabel;
	}

	/**
	 * @return if the label for this control should be shown.
	 */
	public boolean getShowLabel() {
		return this.showLabel;
	}
	
	/**
	 * The render value of the controller.
	 * @param itemPropertyDescriptor the item descriptor
	 * @param urmlElement the urml element
	 * @return the value
	 */

	public abstract int canRender(IItemPropertyDescriptor itemPropertyDescriptor, UrmlModelElement urmlElement);

	/**
	 * @return the urmlElement
	 */
	public UrmlModelElement getModelElement() {
		return urmlElement;
	}

	/**
	 * @param urmlElement the urmlElement to set
	 */
	public void setModelElement(UrmlModelElement urmlElement) {
		this.urmlElement = urmlElement;
	}

	/**
	 * @return urmlElement the urmlElement to get
	 */

	public UrmlModelElement getUrmlElement() {
		return urmlElement;
	}

	/**
	 * @return context the model element context to get
	 */
	public ECPModelelementContext getContext() {
		return context;
	}
	
	
	/**
	 * 
	 * {@inheritDoc}
	 * @see org.unicase.ui.urml.stakeholders.review.IDisposable#dispose()
	 */
	public void dispose(){
		createdControl.dispose();
	}

}
