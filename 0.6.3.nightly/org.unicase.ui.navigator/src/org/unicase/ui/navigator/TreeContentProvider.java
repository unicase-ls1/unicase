/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider;

/**
 * Transactional and composed content provider with all registered label providers.
 * 
 * @author helming
 */
public class TreeContentProvider extends TransactionalAdapterFactoryContentProvider {

	private HashMap<String, ContentProvider> contentProviders = new HashMap<String, ContentProvider>();

	/**
	 * Directly Transfer to project. {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider#getChildren(java.lang.Object)
	 */
	@Override
	public Object[] getChildren(Object object) {
		String className = object.getClass().getCanonicalName();
		ContentProvider replaceContentProvider = contentProviders.get(className);
		if (replaceContentProvider != null) {
			return replaceContentProvider.getChildren((EObject) object).toArray();
		}
		return super.getChildren(object);
	}

	/**
	 * default constructor.
	 * 
	 * @param editingDomain the transactional editing domain
	 */
	public TreeContentProvider(TransactionalEditingDomain editingDomain) {
		super(editingDomain, new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		IConfigurationElement[] confs = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.navigator.replaceContentProvider");
		ArrayList<IConfigurationElement> list = new ArrayList<IConfigurationElement>();
		list.addAll(Arrays.asList(confs));
		for (IConfigurationElement element : list) {
			String attribute = element.getAttribute("type");
			if (contentProviders.get(attribute) != null) {
				Activator.logException(new IllegalStateException("Duplicate RootObjectContent Provider registered"));
				continue;
			}
			try {
				ContentProvider contentProvider = (ContentProvider) element.createExecutableExtension("class");
				contentProviders.put(attribute, contentProvider);

			} catch (CoreException e) {
				Activator.logException(e);
			}

		}

	}

	// /**
	// * {@inheritDoc}
	// *
	// * @see
	// org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider#getElements(java.lang.Object)
	// */
	// @Override
	// public Object[] getElements(Object object) {
	// ArrayList<EObject> ret = new ArrayList<EObject>();
	// if (object instanceof ECPWorkspace) {
	// ECPWorkspace ecpWorkspace = (ECPWorkspace) object;
	// EList<ECPProject> projects = ecpWorkspace.getProjects();
	// for (ECPProject project : projects) {
	// ret.add(project.getRootObject());
	// }
	// }
	// return ret.toArray();
	// }

}