/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.provider;

import org.eclipse.emf.emfstore.server.model.versioning.operations.AbstractOperation;

/**
 * Interface for a custom LabelProvider for {@link AbstractOperation}s.
 * 
 * @author Michael Kagel
 */
public interface AbstractOperationCustomLabelProvider {

	/**
	 * Constant for render priority meaning this provider does not want to render the given element.
	 */
	int CANNOT_RENDER = 0;

	/**
	 * Returns the description of an operation.
	 * 
	 * @param operation for description
	 * @return The description of the operation
	 */
	String getDescription(AbstractOperation operation);

	/**
	 * Returns the image of an operation.
	 * 
	 * @param operation for image
	 * @return The image of the operation
	 */
	Object getImage(AbstractOperation operation);

	/**
	 * Checks if this provider can render the given operation.
	 * 
	 * @param operation which should be checked.
	 * @return a priority for rendering this element. The higher the priority the more likely this provider will render
	 *         the element. Returning 0 means this provider does not want to render this element.
	 */
	int canRender(AbstractOperation operation);
}
