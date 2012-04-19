/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.observer;

import org.eclipse.emf.ecore.EObject;

/**
 * . ({@inheritDoc})
 */
public interface StatusViewDropEventObserver extends org.eclipse.emf.emfstore.common.observer.IObserver {
	/**
	 * . ({@inheritDoc})
	 */
	void onStatusViewDropEvent(EObject open, EObject dragged, String source, String tab);

}
