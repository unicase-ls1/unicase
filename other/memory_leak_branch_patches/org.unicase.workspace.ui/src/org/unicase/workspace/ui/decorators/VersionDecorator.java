/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.workspace.ui.decorators;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.unicase.workspace.ProjectSpace;

/**
 * . The decorator to show version of a ProjectSpace
 * 
 * @author Helming
 */
public class VersionDecorator extends AdapterImpl implements ILightweightLabelDecorator {

	private ArrayList<ILabelProviderListener> listeners = new ArrayList<ILabelProviderListener>();
	private ProjectSpace element;

	/**
	 * . {@inheritDoc}
	 */
	public void decorate(Object element, IDecoration decoration) {
		if (element instanceof ProjectSpace) {
			ProjectSpace projectSpace = (ProjectSpace) element;
			StringBuilder stringBuilder = new StringBuilder();
			if (projectSpace.getBaseVersion() != null) {
				stringBuilder.append("@");
				stringBuilder.append(projectSpace.getBaseVersion().getIdentifier());
			} else {
				stringBuilder.append("(Not shared)");
			}
			String string = stringBuilder.toString();
			decoration.addSuffix(string);
		}
		// //ZH Check this
		// if(this.element==null){
		// this.element=(ProjectSpace) element;
		// this.element.eAdapters().add(this);
		// }
	}

	/**
	 * . {@inheritDoc}
	 */
	public void addListener(ILabelProviderListener listener) {
		listeners.add(listener);
	}

	/**
	 * . {@inheritDoc}
	 */
	public void dispose() {
		listeners.removeAll(listeners);

	}

	/**
	 * . {@inheritDoc}
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * . {@inheritDoc}
	 */
	public void removeListener(ILabelProviderListener listener) {
		listeners.remove(listener);
	}

	/**
	 * . {@inheritDoc}
	 */
	public void decorationChanged() {
		LabelProviderChangedEvent event = new LabelProviderChangedEvent(this, element);
		for (ILabelProviderListener listener : listeners) {
			listener.labelProviderChanged(event);
		}
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void notifyChanged(Notification msg) {
		decorationChanged();
	}

}
