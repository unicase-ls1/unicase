/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.observer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.common.ESObserver;

/**
 * . ({@inheritDoc})
 */
public interface StatusViewDropEventObserver extends ESObserver {
	/**
	 * . ({@inheritDoc})
	 */
	void onStatusViewDropEvent(EObject open, EObject dragged, String source,
			String tab);

}
