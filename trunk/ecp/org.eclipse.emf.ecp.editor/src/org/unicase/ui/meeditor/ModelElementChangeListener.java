/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.unicase.ui.meeditor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;

/**
 * Listens to the changes of one modelelement.
 * 
 * @author helming
 */
public abstract class ModelElementChangeListener extends AdapterImpl {

	private final EObject modelelement;

	/**
	 * Default constructor.
	 * 
	 * @param modelelement the modelelement to listen on
	 */
	public ModelElementChangeListener(EObject modelelement) {
		this.modelelement = modelelement;
		modelelement.eAdapters().add(this);
	}

	/**
	 * Handle changes to the model element.
	 * 
	 * @param notification the EMF notification, providing details on the change
	 * @return
	 */
	public abstract void onChange(Notification notification);

	/**
	 * Handle a runtime exception that occured in this listeners methods. NOTE: runtime exceptions of this method will
	 * be logged and silently dropped.
	 * 
	 * @param exception the exception
	 */
	void onRuntimeExceptionInListener(RuntimeException exception) {
		remove();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.notify.impl.AdapterImpl#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {
		// BEGIN SUPRESS CATCH EXCEPTION
		try {
			onChange(notification);
		} catch (RuntimeException e) {
			onRuntimeExceptionInListener(e);
		}
		// END SUPRESS CATCH EXCEPTION
	}

	/**
	 * Removes the {@link ModelElementChangeListener}.
	 */
	public void remove() {
		modelelement.eAdapters().remove(this);
	}

}
