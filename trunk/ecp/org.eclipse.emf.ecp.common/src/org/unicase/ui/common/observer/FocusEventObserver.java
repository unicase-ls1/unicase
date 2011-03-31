/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.unicase.ui.common.observer;

import org.eclipse.emf.emfstore.common.observer.IObserver;

public interface FocusEventObserver extends IObserver {

	void onFocusEvent(String viewId);

}
