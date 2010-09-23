/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.decorators;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.unicase.ui.common.util.PreferenceHelper;
import org.unicase.ui.common.validation.ValidationResultProviderRegistry;
import org.unicase.ui.common.validation.cache.InvalidEObjectsCache;
import org.unicase.ui.common.validation.providers.ValidationResultProvider;

/**
 * The decorator to show dirty state of an element shown in viewers.
 * 
 * @author Helming
 */
public class ModelElementInvalidDecorator implements ILightweightLabelDecorator {

	/**
	 * The warning {@link ImageDescriptor}.
	 */
	private ImageDescriptor warningDescriptor;

	/**
	 * Maps root {@link EObject}s to {@link InvalidEObjectsCache}s.
	 */
	private Map<EObject, InvalidEObjectsCache> invalidEObjectsCache;

	/**
	 * Constructor.
	 */
	public ModelElementInvalidDecorator() {
		invalidEObjectsCache = new HashMap<EObject, InvalidEObjectsCache>();
		URL warningUrl = FileLocator.find(Platform.getBundle("org.unicase.ui.common"), new Path(
			"icons/warning_decorate.png"), null);
		warningDescriptor = ImageDescriptor.createFromURL(warningUrl);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.viewers.ILightweightLabelDecorator#decorate(java.lang .Object,
	 *      org.eclipse.jface.viewers.IDecoration)
	 * @param element element
	 * @param decoration decoration
	 */
	public void decorate(Object element, final IDecoration decoration) {
		if (!PreferenceHelper.getPreference("org.unicase.validation.live.enabled", "true").equals("true")) {
			return;
		}
		if (element instanceof EObject) {
			EObject eObject = (EObject) element;
			ValidationResultProvider validationResultProvider = ValidationResultProviderRegistry.getInstance()
				.getValidationResultProvider(eObject);
			if (validationResultProvider == null) {
				return;
			}
			EObject rootElement = validationResultProvider.getRootElement();
			if (!invalidEObjectsCache.containsKey(rootElement)) {
				invalidEObjectsCache.put(rootElement, new InvalidEObjectsCache(rootElement));
			}
			if (invalidEObjectsCache.get(rootElement).isEObjectInvalid(eObject) == Status.WARNING) {
				decoration.addOverlay(warningDescriptor, IDecoration.BOTTOM_RIGHT);
			}
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