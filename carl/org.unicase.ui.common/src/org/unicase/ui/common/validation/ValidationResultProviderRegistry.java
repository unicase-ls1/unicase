/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */

package org.unicase.ui.common.validation;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.unicase.ui.common.validation.providers.ValidationResultProvider;
import org.unicase.ui.common.validation.providers.ValidationRootProvider;

/**
 * The {@link ValidationResultProviderRegistry} stores {@link ValidationResultProvider}s by mapping them to projects.
 * 
 * @author pfeifferc
 */
public final class ValidationResultProviderRegistry {

	/**
	 * The {@link ValidationResultProviderRegistry}.
	 */
	private static ValidationResultProviderRegistry validationResultProviderRegistry;

	/**
	 * The {@link ValidationRootProvider}.
	 */
	private static ValidationRootProvider validationRootProvider;

	/**
	 * Retrieves the singleton instance.
	 * 
	 * @return the singleton instance of the {@link ValidationResultProviderRegistry}
	 */
	public static synchronized ValidationResultProviderRegistry getInstance() {
		if (validationResultProviderRegistry == null) {
			validationResultProviderRegistry = new ValidationResultProviderRegistry();
		}
		return validationResultProviderRegistry;
	}

	/**
	 * Constructor.
	 */
	private ValidationResultProviderRegistry() {
		validationResultProviders = new HashMap<EObject, ValidationResultProvider>();
	}

	/**
	 * This method returns the {@link ValidationResultProvider} for the given {@link EObject}. If there is none, a new
	 * one is created. Changes in the root {@link EObject} automatically update the {@link ValidationResultProvider} .
	 * 
	 * @param containedEObject in the hierarchy of the root element.
	 * @return the {@link ValidationResultProvider} or null if root element null
	 */
	public synchronized ValidationResultProvider getValidationResultProvider(EObject containedEObject) {
		if (containedEObject == null) {
			return null;
		}
		EObject root = retrieveRoot(containedEObject);
		if (root == null) {
			return null;
		}
		// retrieve provider for the project, if null create a new validation result provider
		ValidationResultProvider validationResultProvider = retrieve(root);
		if (validationResultProvider == null) {
			validationResultProvider = getValidationResultProviderFromExtensionPoint();
			if (validationResultProvider == null) {
				return null;
			}
			validationResultProvider.init(root);
			register(root, validationResultProvider);
		}
		return validationResultProvider;
	}

	/**
	 * @param containedEObject to retrieve the root {@link EObject} for
	 * @return the root {@link EObject} or null if not found
	 */
	public EObject retrieveRoot(EObject containedEObject) {
		if (validationRootProvider != null) {
			return validationRootProvider.getRootFor(containedEObject);
		}
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.common.validationrootprovider");
		for (IConfigurationElement element : config) {
			try {
				String id = element.getAttribute("type");
				if (validationRootProvider == null || id.equals("specific")) {
					validationRootProvider = (ValidationRootProvider) element.createExecutableExtension("provider");
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return retrieveRoot(containedEObject);
	}

	/**
	 * This method tries to retrieve a validation result provider from the designated extension point.
	 * 
	 * @return the {@link ValidationResultProvider} if found or null
	 */
	private ValidationResultProvider getValidationResultProviderFromExtensionPoint() {
		ValidationResultProvider validationResultProvider = null;
		IConfigurationElement[] config = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.common.validationresultprovider");
		for (IConfigurationElement element : config) {
			try {
				String id = element.getAttribute("type");
				if (validationResultProvider == null || id.equals("specific")) {
					validationResultProvider = (ValidationResultProvider) element.createExecutableExtension("provider");
				}
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return validationResultProvider;
	}

	private Map<EObject, ValidationResultProvider> validationResultProviders;

	/**
	 * This method registers a {@link ValidationResultProvider} for a specific root {@link EObject}.
	 * 
	 * @param rootElement to register for
	 * @param validationResultProvider to register
	 */
	public void register(EObject rootElement, ValidationResultProvider validationResultProvider) {
		validationResultProviders.put(rootElement, validationResultProvider);
	}

	/**
	 * This method unregisters the {@link ValidationResultProvider} for a specific root {@link EObject}.
	 * 
	 * @param rootElement to unregister for
	 */
	public void unregister(EObject rootElement) {
		validationResultProviders.remove(rootElement);
	}

	/**
	 * This method returns the {@link ValidationResultProvider} for a specific root {@link EObject}.
	 * 
	 * @param rootElement to retrieve for
	 * @return the {@link ValidationResultProvider}
	 */
	public ValidationResultProvider retrieve(EObject rootElement) {
		return validationResultProviders.get(rootElement);
	}

	/**
	 * Thus method returns all {@link ValidationResultProvider}s registered.
	 * 
	 * @return the {@link ValidationResultProvider}s registered
	 */
	public Collection<ValidationResultProvider> getValidationResultProviders() {
		return validationResultProviders.values();
	}

	/**
	 * This method reinitializes all violation caches.
	 */
	public void reinitAll() {
		for (ValidationResultProvider validationResultProvider : getValidationResultProviders()) {
			validationResultProvider.reinit();
		}
	}
}