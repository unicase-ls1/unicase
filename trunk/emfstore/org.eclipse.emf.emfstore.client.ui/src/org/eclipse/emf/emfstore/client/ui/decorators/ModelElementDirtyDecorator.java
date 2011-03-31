/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.client.ui.decorators;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.common.model.ModelElementId;
import org.eclipse.emf.emfstore.common.model.Project;
import org.eclipse.emf.emfstore.common.model.util.ModelUtil;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

/**
 * The decorator to show dirty state of an element shown in viewers.
 * 
 * @author Helming
 */
public class ModelElementDirtyDecorator implements ILightweightLabelDecorator {

	private String dirtyPath = "icons/dirty.png";
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
		URL url = null;
		boolean dirty = false;
		if (element instanceof EObject) {
			EObject modelElement = (EObject) element;
			Project project = ModelUtil.getProject(modelElement);
			if (project == null) {
				return;
			}
			ProjectSpace projectSpace = WorkspaceManager.getProjectSpace(modelElement);
			if (projectSpace == null) {
				return;
			}
			ModelElementId modelElementId = project.getModelElementId(modelElement);
			if (modelElementId == null) {
				return;
			}
			if (projectSpace.getModifiedModelElementsCache().isModelElementDirty(modelElementId)) {
				dirty = true;
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
