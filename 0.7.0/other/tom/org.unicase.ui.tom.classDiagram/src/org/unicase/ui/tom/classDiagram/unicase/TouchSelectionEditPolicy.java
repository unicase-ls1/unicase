/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.tom.classDiagram.unicase;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gef.editpolicies.SelectionEditPolicy;

/**
 * @author schroech
 *
 */
public class TouchSelectionEditPolicy extends SelectionEditPolicy 
	implements IAdaptable{

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.gef.editpolicies.SelectionEditPolicy#hideSelection()
	 */
	@Override
	protected void hideSelection() {
		
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.gef.editpolicies.SelectionEditPolicy#showSelection()
	 */
	@Override
	protected void showSelection() {
		
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(Class adapter) {

		return null;
	}

}
