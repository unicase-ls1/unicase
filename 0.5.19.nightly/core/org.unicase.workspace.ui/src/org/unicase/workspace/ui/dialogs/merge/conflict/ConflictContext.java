/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.dialogs.merge.conflict;

import org.unicase.metamodel.ModelElement;

/**
 * Holding the data for the context of an conflict.
 * 
 * @author wesendon
 */
public class ConflictContext {

	private final ModelElement modelElement;
	private final String attribute;
	private final String opponent;

	/**
	 * Default constructor.
	 * 
	 * @param modelElement
	 *            element
	 * @param attribute
	 *            attribute
	 * @param opponent
	 *            opponent
	 */
	public ConflictContext(ModelElement modelElement, String attribute,
			String opponent) {
		this.modelElement = modelElement;
		this.attribute = attribute;
		this.opponent = opponent;
	}

	/**
	 * Alternative constructor.
	 * 
	 * @param modelElement
	 *            element
	 * @param opponent
	 *            opponent
	 */
	public ConflictContext(ModelElement modelElement, String opponent) {
		this.modelElement = modelElement;
		this.attribute = null;
		this.opponent = opponent;
	}

	/**
	 * Get ModelELement.
	 * 
	 * @return element
	 */
	public ModelElement getModelElement() {
		return modelElement;
	}

	/**
	 * Get Attribute.
	 * 
	 * @return attribute
	 */
	public String getAttribute() {
		return attribute;
	}

	/**
	 * Get Opponent.
	 * 
	 * @return opponent
	 */
	public String getOpponent() {
		return opponent;
	}

	/**
	 * Get label for Modelelement.
	 * 
	 * @return label
	 */
	public String getModelElementTitleLabel() {
		return "ModelElement";
	}

	/**
	 * Get label of attribute.
	 * 
	 * @return label
	 */
	public String getAttributeTitleLabel() {
		return "Attribute";
	}

	/**
	 * Get label of opponent.
	 * 
	 * @return label
	 */
	public String getOpponentTitleLabel() {
		return "Opponent";
	}
}
