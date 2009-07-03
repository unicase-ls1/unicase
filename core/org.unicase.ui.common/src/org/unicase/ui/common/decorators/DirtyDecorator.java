/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.decorators;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.unicase.model.ModelElement;
import org.unicase.model.provider.ModelEditPlugin;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * . The decorator to show state of an element (blocked or open) shown in viewers
 * 
 * @author Helming
 */
public class DirtyDecorator implements ILightweightLabelDecorator {
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
	private String dirtyPath = "icons/dirty.jpg"; // NON-NLS-1

	/**
	 * . The image description used in <code>addOverlay(ImageDescriptor, int)</code>
	 */
	private ImageDescriptor descriptor;

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

		ProjectSpace ps;
		if (element instanceof ProjectSpace) {
			ps = (ProjectSpace) element;
			if (ps.isDirty()) {
				url = FileLocator.find(Platform.getBundle("org.unicase.ui.common"), new Path(dirtyPath), null);
			}
		} else if(element instanceof ModelEditPlugin){
			ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
			if(activeProjectSpace.getModifiedModelElementsCache().isDirty((ModelElement)element)){
				url = FileLocator.find(Platform.getBundle("org.unicase.ui.common"), new Path(dirtyPath), null);
				
			}
			return;
		}

		if (url == null) {
			return;
		}

		descriptor = ImageDescriptor.createFromURL(url);
		quadrant = IDecoration.BOTTOM_LEFT;
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