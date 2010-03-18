/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.validation.filter;

import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.graphics.Image;

/**
 * Filter Validations to Team.
 * 
 * @author helming
 */
public abstract class ValidationFilter extends ViewerFilter {

	/**
	 * A description of the filter.
	 * 
	 * @return the description
	 */
	public abstract String getDescription();

	/**
	 * An id of the filter.
	 * 
	 * @return the id
	 */
	public abstract String getId();

	/**
	 * An icon for the filter.
	 * 
	 * @return the icon image
	 */
	public abstract Image getImage();

	/**
	 * Use description as toString string.
	 * 
	 * @return the description
	 */
	@Override
	public String toString() {
		return getDescription();
	}
}
