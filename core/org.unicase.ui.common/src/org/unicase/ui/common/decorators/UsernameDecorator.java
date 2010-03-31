/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.common.decorators;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.unicase.workspace.ProjectSpace;

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
	public void decorate(Object element, IDecoration decoration) {
		if (element instanceof ProjectSpace) {
			ProjectSpace projectSpace = (ProjectSpace) element;
			if(projectSpace.getUsersession() != null){
				String string = " "+projectSpace.getUsersession().getUsername();
				decoration.addSuffix(string);
				decoration.setForegroundColor(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_YELLOW));
				
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
	 *  {@inheritDoc}
	 */
	public void dispose() {
		listeners.removeAll(listeners);

	}

	/**
	 *  {@inheritDoc}
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 *  {@inheritDoc}
	 */
	public void removeListener(ILabelProviderListener listener) {
		listeners.remove(listener);
	}

	/**
	 *  {@inheritDoc}
	 */
	public void decorationChanged() {
		LabelProviderChangedEvent event = new LabelProviderChangedEvent(this, element);
		for (ILabelProviderListener listener : listeners) {
			listener.labelProviderChanged(event);
		}
	}

	/**
	 *  {@inheritDoc}
	 */
	@Override
	public void notifyChanged(Notification msg) {
		decorationChanged();
	}

}
