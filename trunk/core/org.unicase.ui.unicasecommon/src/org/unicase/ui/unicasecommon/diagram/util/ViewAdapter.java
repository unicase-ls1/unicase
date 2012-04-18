/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.util;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.notation.View;

/**
 * An Identity Adapter for View objects.
 * 
 * @author schroech
 */
public class ViewAdapter implements IAdaptable {

	private final View object;

	/**
	 * @param object The adaptable object
	 */
	public ViewAdapter(View object) {
		this.object = object;
	}

	/**
	 * @see org.eclipse.core.runtime.IAdaptable#getAdapter(java.lang.Class)
	 * @param adapter The classType to adapt to
	 * @return The adapted object
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(java.lang.Class adapter) {
		if (adapter.isInstance(object)) {
			return object;
		}
		return null;
	}

}
