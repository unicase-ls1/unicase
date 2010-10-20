/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.metamodel.ModelElement;

/**
 * Abstract class for the ME controls.
 * 
 * @author helming
 */
public abstract class AbstractMEControl {

	/**
	 * The default constant in case the widgets decides it shouldn't render the attribute.
	 */
	public static final int DO_NOT_RENDER = -1;

	/**
	 * gui toolkit used for rendering.
	 */
	private FormToolkit toolkit;
	/**
	 * the modelElement.
	 */
	private ModelElement modelElement;
	/**
	 * the editingDomain.
	 */
	private EditingDomain editingDomain;

	private boolean showLabel;

	private IItemPropertyDescriptor itemPropertyDescriptor;

	/**
	 * @return the toolkit
	 */
	public FormToolkit getToolkit() {
		return toolkit;
	}

	public abstract int canRender(IItemPropertyDescriptor itemPropertyDescriptor, ModelElement modelElement);

	/**
	 * @param toolkit the toolkit to set
	 */
	public void setToolkit(FormToolkit toolkit) {
		this.toolkit = toolkit;
	}

	/**
	 * @return the modelElement
	 */
	public ModelElement getModelElement() {
		return modelElement;
	}

	/**
	 * @param modelElement the modelElement to set
	 */
	public void setModelElement(ModelElement modelElement) {
		this.modelElement = modelElement;
	}

	/**
	 * @return the editingDomain
	 */
	public EditingDomain getEditingDomain() {
		return editingDomain;
	}

	/**
	 * @param editingDomain the editingDomain to set
	 */
	public void setEditingDomain(EditingDomain editingDomain) {
		this.editingDomain = editingDomain;
	}

	/**
	 * Default constructor.
	 */
	public AbstractMEControl() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {

	}

	/**
	 * Method for applying a custom layout data to widgets, as for {@link MERichTextControl}.
	 */
	public void applyCustomLayoutData() {
		// by default none. must me implemented by the subclass.
	}

	/**
	 * Creates the widget for this control.
	 * 
	 * @param attributeComposite the parent composite
	 * @param style the style
	 * @return the widget
	 */
	public Control createControl(Composite parent, int style, IItemPropertyDescriptor itemPropertyDescriptor,
		ModelElement modelElement, EditingDomain editingDomain, FormToolkit toolkit) {
		this.editingDomain = editingDomain;
		this.modelElement = modelElement;
		this.toolkit = toolkit;
		this.setItemPropertyDescriptor(itemPropertyDescriptor);
		return createControl(parent, style);

	}

	protected abstract Control createControl(Composite parent, int style);

	/**
	 * @return if the label for this control should be shown.
	 */
	public boolean getShowLabel() {
		return this.showLabel;
	}

	/**
	 * Sets if the label should be shown.
	 */
	public void setShowLabel(boolean show) {
		this.showLabel = show;
	}

	public void setItemPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
		this.itemPropertyDescriptor = itemPropertyDescriptor;
	}

	public IItemPropertyDescriptor getItemPropertyDescriptor() {
		return itemPropertyDescriptor;
	}

}
