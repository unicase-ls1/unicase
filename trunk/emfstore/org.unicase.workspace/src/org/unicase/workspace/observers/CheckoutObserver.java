/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.observers;

import org.unicase.util.observer.IObserver;
import org.unicase.workspace.ProjectSpace;

/**
 * Observer that notifies on new checkouts.
 * 
 * @author wesendon
 */
public interface CheckoutObserver extends IObserver {

	/**
	 * Called on checkout.
	 * 
	 * @param projectSpace updated projectspace
	 */
	void checkoutDone(ProjectSpace projectSpace);

}
