/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor.mecontrols;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.forms.widgets.FormToolkit;

/**
 * Abstract class for the ME controls.
 * 
 * @author helming
 */
public abstract class AbstractMEControl implements MEControl {

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

	/**
	 * @return the toolkit
	 */
	public FormToolkit getToolkit() {
		return toolkit;
	}

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
	 * 
	 * @param editingDomain the editing domain
	 * @param modelElement the ME
	 * @param toolkit gui toolkit used for rendering
	 */
	public AbstractMEControl(EditingDomain editingDomain, EObject modelElement, FormToolkit toolkit) {
		super();
		this.editingDomain = editingDomain;
		this.modelElement = modelElement;
		this.toolkit = toolkit;
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

}
