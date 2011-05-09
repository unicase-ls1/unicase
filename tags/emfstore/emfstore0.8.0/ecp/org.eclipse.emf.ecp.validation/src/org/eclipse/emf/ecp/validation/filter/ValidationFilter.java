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
package org.eclipse.emf.ecp.validation.filter;

import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.graphics.Image;

/**
 * The validation filter.
 * 
 * @author helming
 */
public abstract class ValidationFilter extends ViewerFilter {

	/**
	 * Initialization method.
	 * 
	 * @return true if successful
	 */
	public abstract boolean init();
	
	/**
	 * A description of the filter.
	 * 
	 * @return the description
	 */
	public abstract String getDescription();

	/**
	 * A name of the filter.
	 * 
	 * @return the name
	 */
	public abstract String getName();

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
