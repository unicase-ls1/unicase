/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
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
import org.unicase.metamodel.ModelElement;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * The decorator to show dirty state of an element shown in viewers.
 * 
 * @author Helming
 */
public class ModelElementDirtyDecorator implements ILightweightLabelDecorator {

	private String dirtyPath = "icons/dirty.jpg";
	private ImageDescriptor descriptor;

	/**
	 * {@inheritDoc}
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
		boolean dirty = false;
		ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
		if (activeProjectSpace == null) {
			return;
		}
		if (element instanceof ModelElement) {

			ModelElement me = (ModelElement) element;

			// if ME is dirty show decoration
			if (activeProjectSpace.getModifiedModelElementsCache().isDirty(me.getModelElementId())) {
				dirty = true;

			}
			// if one of contained MEs within ME is dirty also show decoration
			for (ModelElement containedME : me.getAllContainedModelElements()) {
				if (activeProjectSpace.getModifiedModelElementsCache().isDirty(containedME.getModelElementId())) {
					dirty = true;
				}
			}

		}

		if (dirty) {
			url = FileLocator.find(Platform.getBundle("org.unicase.ui.common"), new Path(dirtyPath), null);
			descriptor = ImageDescriptor.createFromURL(url);
			decoration.addOverlay(descriptor, IDecoration.BOTTOM_LEFT);
		}

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse. jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
	}

	/**
	 * {@inheritDoc}
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