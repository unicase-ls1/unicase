/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.decorators;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.emfstore.internal.client.model.util.EMFStoreCommand;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.util.CircularDependencyException;
import org.unicase.model.task.util.MEState;

/**
 * . The decorator to show state of an element (blocked or open) shown in viewers
 * 
 * @author Helming
 */
public class StateDecorator implements ILightweightLabelDecorator {
	/**
	 * String constants for the various icon placement options from the template wizard.
	 */
	public static final String TOP_RIGHT = "TOP_RIGHT";
	/**
	 * String constants for the various icon placement options from the template wizard.
	 */
	public static final String TOP_LEFT = "TOP_LEFT";
	/**
	 * String constants for the various icon placement options from the template wizard.
	 */
	public static final String BOTTOM_RIGHT = "BOTTOM_RIGHT";
	/**
	 * String constants for the various icon placement options from the template wizard.
	 */
	public static final String BOTTOM_LEFT = "BOTTOM_LEFT";
	/**
	 * String constants for the various icon placement options from the template wizard.
	 */
	public static final String UNDERLAY = "UNDERLAY";

	/**
	 * . The integer value representing the placement options
	 */
	private int quadrant;

	/**
	 * . The icon image location in the project folder
	 */
	private String openPath = "icons/open.png"; // NON-NLS-1

	/**
	 * . The icon image location in the project folder
	 */
	private String blockedPath = "icons/blocked.png"; // NON-NLS-1

	/**
	 * . The image description used in <code>addOverlay(ImageDescriptor, int)</code>
	 */
	private ImageDescriptor descriptor;
	/**
	 * String for the current status.
	 */
	private String status = MEState.CLOSED;

	/**
	 * . {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ILightweightLabelDecorator#decorate(java.lang .Object,
	 *      org.eclipse.jface.viewers.IDecoration)
	 * @param element element
	 * @param decoration decoration
	 */
	public void decorate(Object element, IDecoration decoration) {
		/**
		 * Checks that the element is an IResource with the 'Read-only' attribute and adds the decorator based on the
		 * specified image description and the integer representation of the placement option.
		 */
		URL url = null;

		final UnicaseModelElement me;
		if (element instanceof UnicaseModelElement) {
			me = (UnicaseModelElement) element;
		} else {
			return;
		}

		new EMFStoreCommand() {

			@Override
			protected void doRun() {
				try {
					status = me.getMEState().getStatus();
				} catch (CircularDependencyException e) {
					return;

				}
			}
		}.run();

		if (status.equals(MEState.OPEN)) {
			url = FileLocator.find(Platform.getBundle("org.unicase.ui.unicasecommon"), new Path(openPath), null);

		}
		if (status.equals(MEState.BLOCKED)) {
			url = FileLocator.find(Platform.getBundle("org.unicase.ui.unicasecommon"), new Path(blockedPath), null);
		}

		if (url == null) {
			return;
		}

		descriptor = ImageDescriptor.createFromURL(url);
		quadrant = IDecoration.TOP_RIGHT;
		decoration.addOverlay(descriptor, quadrant);
	}

	/**
	 * . {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse. jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
	}

	/**
	 * . {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
	}

	/**
	 * . {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang .Object, java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	/**
	 * . {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse
	 *      .jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {
	}
}
