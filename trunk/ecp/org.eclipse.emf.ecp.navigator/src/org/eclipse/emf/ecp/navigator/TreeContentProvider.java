/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.navigator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.model.ECPModelelementContext;
import org.eclipse.emf.ecp.common.model.ECPWorkspaceManager;
import org.eclipse.emf.ecp.common.model.NoWorkspaceException;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.DelegatingWrapperItemProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;

/**
 * Transactional and composed content provider with all registered label providers.
 * 
 * @author helming
 */
public class TreeContentProvider extends AdapterFactoryContentProvider {

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
		Object[] preResult;
		if (replaceContentProvider != null) {
			preResult = replaceContentProvider.getChildren((EObject) object).toArray();
		} else {
			preResult = super.getChildren(object);
		}
		ECPModelelementContext context;
		try {
			context = ECPWorkspaceManager.getInstance().getWorkSpace().getActiveProject();
			if (context == null) {
				return preResult;
			}
		} catch (NoWorkspaceException e) {
			Activator.getDefault().logException(e.getMessage(), e);
			return preResult;
		}

		// this removes all AssociationClass's from the result
		LinkedList<Object> result = new LinkedList<Object>();
		for (Object item : preResult) {
			if (!(item instanceof EObject && context.getMetaModelElementContext().isAssociationClassElement(
				(EObject) item))
				&& !(item instanceof DelegatingWrapperItemProvider && context.getMetaModelElementContext()
					.isAssociationClassElement((EObject) ((DelegatingWrapperItemProvider) item).getValue()))) {
				result.add(item);
			}
		}
		return result.toArray();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryContentProvider#hasChildren(java.lang.Object)
	 */
	@Override
	public boolean hasChildren(Object object) {
		ECPModelelementContext context;
		try {
			context = ECPWorkspaceManager.getInstance().getWorkSpace().getActiveProject();
			if (context == null) {
				return super.hasChildren(object);
			}
		} catch (NoWorkspaceException e) {
			Activator.getDefault().logException(e.getMessage(), e);
			// if an exception is caught return the not modified result
			return super.hasChildren(object);
		}
		EObject eObject = null;
		if (object instanceof DelegatingWrapperItemProvider) {
			eObject = (EObject) ((DelegatingWrapperItemProvider) object).getValue();
		} else if (object instanceof EObject) {
			eObject = (EObject) object;
		}
		if (eObject == null || eObject.eContents().isEmpty()) {
			return super.hasChildren(object);
		}
		for (EObject child : eObject.eContents()) {
			if (!context.getMetaModelElementContext().isAssociationClassElement(child)) {
				return super.hasChildren(object);
			}
		}
		return false;
	}

	/**
	 * Default constructor.
	 */
	public TreeContentProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		IConfigurationElement[] confs = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.eclipse.emf.ecp.navigator.replaceContentProvider");
		ArrayList<IConfigurationElement> list = new ArrayList<IConfigurationElement>();
		list.addAll(Arrays.asList(confs));
		for (IConfigurationElement element : list) {
			String attribute = element.getAttribute("type");
			if (contentProviders.get(attribute) != null) {
				Exception exception = new IllegalStateException("Duplicate RootObjectContent Provider registered");
				Activator.getDefault().logException(exception.getMessage(), exception);
				continue;
			}
			try {
				ContentProvider contentProvider = (ContentProvider) element.createExecutableExtension("class");
				contentProviders.put(attribute, contentProvider);

			} catch (CoreException e) {
				Activator.getDefault().logException(e.getMessage(), e);
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
