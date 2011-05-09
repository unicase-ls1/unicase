/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor.mecontrols;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.unicase.ecp.model.ModelElementContext;

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
	private EObject modelElement;
	/**
	 * the editingDomain.
	 */
	private EditingDomain editingDomain;

	private boolean showLabel;

	private IItemPropertyDescriptor itemPropertyDescriptor;

	private ModelElementContext context;

	/**
	 * @return the toolkit
	 */
	public FormToolkit getToolkit() {
		return toolkit;
	}

	/**
	 * If a control can render a feature of a modelelement.
	 * 
	 * @param itemPropertyDescriptor the {@link IItemPropertyDescriptor}
	 * @param modelElement the modelelement
	 * @return the priority
	 */
	public abstract int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement);

	/**
	 * @param toolkit the toolkit to set
	 */
	public void setToolkit(FormToolkit toolkit) {
		this.toolkit = toolkit;
	}

	/**
	 * @return the modelElement
	 */
	public EObject getModelElement() {
		return modelElement;
	}

	/**
	 * @param modelElement the modelElement to set
	 */
	public void setModelElement(EObject modelElement) {
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
	 * @param parent the parent composite
	 * @param itemPropertyDescriptor the {@link IItemPropertyDescriptor}
	 * @param modelElement the modelelement
	 * @param context the context of the modelelement
	 * @param toolkit the {@link FormToolkit}
	 * @param style the style
	 * @return the widget
	 */
	public Control createControl(Composite parent, int style, IItemPropertyDescriptor itemPropertyDescriptor,
		EObject modelElement, ModelElementContext context, FormToolkit toolkit) {
		this.setContext(context);
		this.editingDomain = context.getEditingDomain();
		this.modelElement = modelElement;
		this.toolkit = toolkit;
		this.setItemPropertyDescriptor(itemPropertyDescriptor);
		return createControl(parent, style);

	}

	/**
	 * Shall be overriden to create the control.
	 * 
	 * @param parent the paren composite
	 * @param style the SWT style
	 * @return the create Control
	 */
	protected abstract Control createControl(Composite parent, int style);

	/**
	 * @return if the label for this control should be shown.
	 */
	public boolean getShowLabel() {
		return this.showLabel;
	}

	/**
	 * Sets if the label should be shown.
	 * 
	 * @param show if the Label should be shown
	 */
	public void setShowLabel(boolean show) {
		this.showLabel = show;
	}

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
	 * Setter for the {@link ModelElementContext}.
	 * 
	 * @param context the {@link ModelElementContext}
	 */
	public void setContext(ModelElementContext context) {
		this.context = context;
	}

	/**
	 * Getter for the {@link ModelElementContext}.
	 * 
	 * @return the {@link ModelElementContext}
	 */
	public ModelElementContext getContext() {
		return context;
	}

}
