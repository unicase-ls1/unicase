/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views;

import java.util.List;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;

/**
 * This is the content provider for TreeViewer on ChangesTreeComposite.
 * 
 * @author Hodaie
 * @author Shterev
 * 
 */
public class ChangesTreeContentProvider extends AdapterFactoryContentProvider
		implements IContentProvider {

	/**
	 * . Constructor
	 */
	public ChangesTreeContentProvider() {
		super(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	}

	/**
	 * .
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Object[] getElements(Object object) {
		List<ChangePackage> packages = (List<ChangePackage>) object;
		return packages.toArray(new Object[packages.size()]);
	}

	/**.
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof ChangePackage){
			return ((ChangePackage) object).getOperations().toArray();
		}
		if (object instanceof CompositeOperation) {
			return ((CompositeOperation) object)
					.getSubOperations().toArray();
		} else {
			return super.getChildren(object);
		}

	}

	
	/**.
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object object) {
		if (object instanceof CompositeOperation
				|| object instanceof ChangePackage) {
			return true;
		} else {
			return super.hasChildren(object);
		}
	}

}
