/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.validation.filter.impl;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.graphics.Image;
import org.unicase.ui.validation.Activator;
import org.unicase.ui.validation.filter.ValidationFilter;

/**
 * A filter to filter workitems lists to a certain ACUser.
 * 
 * @author helming
 */
public class ACUserFilter extends ValidationFilter {

//	private ACUser acUser;

	/**
	 * default constructor.
	 */
	public ACUserFilter() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDescription() {
		return "The access control user filter";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Image getImage() {
		return Activator.getImageDescriptor("icons/validation.png").createImage();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getName() {
		return "The access control user filter";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean init() {
		return true;
	}

}
