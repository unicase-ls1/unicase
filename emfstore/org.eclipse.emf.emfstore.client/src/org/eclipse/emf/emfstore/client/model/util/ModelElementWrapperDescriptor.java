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
package org.eclipse.emf.emfstore.client.model.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * Uses all registered extensions to create a wrapper for the given element. <br>
 * The factories are processed in the following order:<br>
 * <li>Factories by nsURI</li><br>
 * <li>Default factories</li>
 */
public class ModelElementWrapperDescriptor {

	private static final String EP_ID = "org.eclipse.emf.emfstore.client.wrapperfactories";
	private static final String NON_URI = "NON_URI";
	private static final String ATT_CLASS = "class";
	private static final String ATT_URI = "nsURI";

	private static final ModelElementWrapperDescriptor INSTANCE = new ModelElementWrapperDescriptor();
	private static Map<String, List<IModelElementWrapperFactory>> factoriesMap;

	/**
	 * Returns the instance of this class.
	 * 
	 * @return the instance
	 */
	public static ModelElementWrapperDescriptor getInstance() {
		return INSTANCE;
	}

	/**
	 * Returns all currently registered provider. The implementation does not track extensions which are added after
	 * this snapshot.
	 * 
	 * @return the map from uri to factory
	 */
	public static synchronized Map<String, List<IModelElementWrapperFactory>> getFactories() {
		if (factoriesMap != null) {
			return factoriesMap;
		}

		factoriesMap = new HashMap<String, List<IModelElementWrapperFactory>>();
		IExtension[] extensions = Platform.getExtensionRegistry().getExtensionPoint(EP_ID).getExtensions();
		for (int i = 0; i < extensions.length; i++) {
			IConfigurationElement[] configElements = extensions[i].getConfigurationElements();
			for (int j = 0; j < configElements.length; j++) {
				IConfigurationElement configurationElement = configElements[j];
				try {
					IModelElementWrapperFactory factory = (IModelElementWrapperFactory) configurationElement
						.createExecutableExtension(ATT_CLASS);
					String nsURI = getNsURI(configurationElement);
					if (!factoriesMap.containsKey(nsURI)) {
						factoriesMap.put(nsURI, new ArrayList<IModelElementWrapperFactory>());
					}
					List<IModelElementWrapperFactory> list = factoriesMap.get(nsURI);
					list.add(factory);
				} catch (CoreException e) {
					WorkspaceUtil.logException("Creating the wrapperfactories ", e);
				}
			}
		}
		return factoriesMap;
	}

	/**
	 * Returns the nsURI from the {@link IConfigurationElement}.
	 * 
	 * @param configurationElement
	 * @return
	 */
	private static String getNsURI(IConfigurationElement configurationElement) {
		String nsURI = configurationElement.getAttribute(ATT_URI);
		return nsURI != null ? nsURI : NON_URI;
	}

	/**
	 * Wraps the given {@link EObject}.
	 * 
	 * @param container the container for which the toWrap should be wrapped or <code>null</code>.
	 * @param toWrap the {@link EObject} which should be wrapped.
	 * @return the wrapped element
	 */
	public EObject wrap(EObject container, EObject toWrap) {
		ensureFactories();
		return wrap(container, toWrap, new DefaultWrapHelper());
	}

	/**
	 * Wraps the given {@link EObject} for import purpose.
	 * 
	 * @param container the container for which the toWrap should be wrapped or <code>null</code>.
	 * @param toWrap the {@link EObject} which should be wrapped.
	 * @param resourceUri the {@link URI} of the resource to import.
	 * @param resourceIndex - the index of the element inside the eResource.
	 * @return the wrapped element
	 */
	public EObject wrapForImport(EObject container, EObject toWrap, URI resourceUri, int resourceIndex) {
		ensureFactories();
		return wrap(container, toWrap, new ImportWrapHelper(resourceUri, resourceIndex));
	}

	/**
	 * Loads the factories if not loaded yet.
	 */
	private void ensureFactories() {
		getFactories();
	}

	/**
	 * Wraps the toWrap using the wrapHelper.
	 * 
	 * @param container container the container for which the toWrap should be wrapped or <code>null</code>.
	 * @param toWrap the {@link EObject} which should be wrapped.
	 * @param helper a wrap helper
	 * @return
	 */
	private EObject wrap(EObject container, EObject toWrap, WrapHelper helper) {
		EObject wrapped;
		if (toWrap == null) {
			return null;
		}
		// use the nsURI of the toWrap to find a factory
		String nsURI = toWrap.eClass().getEPackage().getNsURI();
		if (factoriesMap.containsKey(nsURI)) {
			List<IModelElementWrapperFactory> factories = factoriesMap.get(nsURI);
			// iterate all the factories registered for the nsURI. The first matching wins.
			for (IModelElementWrapperFactory factory : factories) {
				if (factory.isFor(container, toWrap)) {
					wrapped = helper.wrap(factory, container, toWrap);
					if (wrapped != null) {
						return wrapped;
					}
				}
			}
		}

		// if the element could not be wrapped by its nsURI, try the default factories
		return wrapWithoutNsURI(container, toWrap, helper);
	}

	/**
	 * Uses the factories which did not specify a nsURI to create the wrapper.
	 * 
	 * @param container
	 * @param toWrap
	 * @param helper a wrap helper
	 * @return
	 */
	private EObject wrapWithoutNsURI(EObject container, EObject toWrap, WrapHelper helper) {
		EObject wrapped = null;
		if (factoriesMap.containsKey(NON_URI)) {
			List<IModelElementWrapperFactory> factories = factoriesMap.get(NON_URI);
			// iterate all the factories registered for the nsURI. The first matching wins.
			for (IModelElementWrapperFactory factory : factories) {
				if (factory.isFor(container, toWrap)) {
					wrapped = helper.wrap(factory, container, toWrap);
					if (wrapped != null) {
						break;
					}
				}
			}
		}
		return wrapped;
	}

	/**
	 * An abstraction for the different wrapping types.
	 */
	private interface WrapHelper {
		EObject wrap(IModelElementWrapperFactory factory, EObject container, EObject toWrap);
	}

	/**
	 * Is used to wrap imported elements.
	 */
	private final class ImportWrapHelper implements WrapHelper {

		private final URI uri;
		private final int resourceIndex;

		private ImportWrapHelper(URI uri, int resourceIndex) {
			this.uri = uri;
			this.resourceIndex = resourceIndex;
		}

		public EObject wrap(IModelElementWrapperFactory factory, EObject container, EObject toWrap) {
			return factory.wrapForImport(toWrap, uri, resourceIndex);
		}

	}

	/**
	 * To wrap default elements.
	 */
	private class DefaultWrapHelper implements WrapHelper {

		public EObject wrap(IModelElementWrapperFactory factory, EObject container, EObject toWrap) {
			return factory.wrap(toWrap);
		}

	}
}
