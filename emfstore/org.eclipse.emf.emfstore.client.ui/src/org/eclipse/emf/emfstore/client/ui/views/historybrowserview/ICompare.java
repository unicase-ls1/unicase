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
package org.eclipse.emf.emfstore.client.ui.views.historybrowserview;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.ui.views.historybrowserview.exceptions.InvalidCompareException;
import org.eclipse.emf.emfstore.client.ui.views.historybrowserview.exceptions.NoComparisonException;

/**
 * Interface for extension point. This is used to register new comparators for
 * the history browser.
 * 
 * @author groeber
 */
public interface ICompare {
	/**
	 * Compares two EObjects to each other
	 * 
	 * @param e1
	 *            EObject one
	 * @param e2
	 *            EObject two
	 * @throws InvalidCompareException
	 *             is thrown if it is impossible to compare the two EObjects
	 */
	public void compare(EObject e1, EObject e2) throws InvalidCompareException;

	/**
	 * Displays the compare result. This method is called if
	 * {@link #compare(EObject e1, EObject e2)} has been called before and only
	 * then.
	 * 
	 * @throws NoComparisonException
	 *             is thrown if display is invoked before compare
	 */
	public void display() throws NoComparisonException;
}
