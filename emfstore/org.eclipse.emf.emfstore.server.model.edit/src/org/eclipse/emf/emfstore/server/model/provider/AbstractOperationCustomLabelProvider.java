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
package org.eclipse.emf.emfstore.server.model.provider;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

/**
 * Interface for a custom LabelProvider for {@link AbstractOperation}s.
 * 
 * @author Michael Kagel
 * @author emueller
 */
public abstract class AbstractOperationCustomLabelProvider {

	/**
	 * Constant for render priority meaning this provider does not want to render the given element.
	 */
	static int CANNOT_RENDER = 0;

	public AbstractOperationCustomLabelProvider() {
	}

	/**
	 * Returns the description of an operation.
	 * 
	 * @param operation for description
	 * @return The description of the operation
	 */
	public abstract String getDescription(AbstractOperation operation);

	/**
	 * Returns the image of an operation.
	 * 
	 * @param operation for image
	 * @return The image of the operation
	 */
	public abstract Object getImage(AbstractOperation operation);

	/**
	 * Checks if this provider can render the given operation.
	 * 
	 * @param operation which should be checked.
	 * @return a priority for rendering this element. The higher the priority the more likely this provider will render
	 *         the element. Returning 0 means this provider does not want to render this element.
	 */
	public abstract int canRender(AbstractOperation operation);

	/**
	 * Returns the name of the {@link EObject} with the given {@link ModelElementId}.
	 * 
	 * @param modelElementId a {@link ModelElementId}
	 * @return the name of the {@link EObject}
	 */
	public abstract String getModelElementName(Map<ModelElementId, EObject> modelElementMap,
		ModelElementId modelElementId);
}
