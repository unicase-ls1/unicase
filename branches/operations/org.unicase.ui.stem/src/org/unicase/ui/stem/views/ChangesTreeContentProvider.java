/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views;

import java.util.List;

import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.unicase.emfstore.esmodel.versioning.operations.CompositeOperation;

/**
 * . This is the content provider for TreeViewer on ChangesTreeComposite.
 * 
 * @author Hodaie
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
	@Override
	public Object[] getElements(Object object) {
		List<AbstractOperation> ops = (List<AbstractOperation>) object;

		return ops.toArray(new Object[ops.size()]);
	}

	/**.
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getChildren(Object object) {

		if (object instanceof CompositeOperation) {
			return getElements(((CompositeOperation) object)
					.getSubOperations());
		} else {
			return super.getChildren(object);
		}

	}

	/**.
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object object) {
		if (object instanceof CompositeOperation) {
			return true;
		} else {
			return super.hasChildren(object);
		}
	}

}
