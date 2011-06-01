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
package org.eclipse.emf.emfstore.client.ui.decorators;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;

/**
 * Decorator to show the username for a ProjectSpace.
 * 
 * @author Shterev
 */
public class UsernameDecorator extends AdapterImpl implements ILightweightLabelDecorator {

	private ArrayList<ILabelProviderListener> listeners = new ArrayList<ILabelProviderListener>();
	private ProjectSpace element;

	/**
	 * {@inheritDoc}
	 */
	public void decorate(Object element, final IDecoration decoration) {
		if (element instanceof ProjectSpace) {
			ProjectSpace projectSpace = (ProjectSpace) element;
			if (projectSpace.getUsersession() != null) {
				String string = " " + projectSpace.getUsersession().getUsername();
				decoration.addSuffix(string);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void addListener(ILabelProviderListener listener) {
		listeners.add(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void dispose() {
		listeners.removeAll(listeners);

	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void removeListener(ILabelProviderListener listener) {
		listeners.remove(listener);
	}

	/**
	 * {@inheritDoc}
	 */
	public void decorationChanged() {
		LabelProviderChangedEvent event = new LabelProviderChangedEvent(this, element);
		for (ILabelProviderListener listener : listeners) {
			listener.labelProviderChanged(event);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void notifyChanged(Notification msg) {
		decorationChanged();
	}

}
