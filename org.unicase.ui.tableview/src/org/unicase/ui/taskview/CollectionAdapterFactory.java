/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.taskview;

import java.util.Collection;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

/**
 * An adapter factory to handle lists containing arbitrary objects, but with
 * special focus on lists containing EMF objects, as it only provides item
 * provider implementations of provider interfaces specified in the package
 * {@link org.eclipse.emf.edit.provider}.
 * 
 * @author Florian Schneider
 * 
 */
public class CollectionAdapterFactory extends AdapterFactoryImpl {

	private CollectionItemProvider collectionItemProvider;

	/**
	 * Up to now, this CollectionAdapterFactory can only handle requests for
	 * ColloctionItemProviders.
	 * 
	 * @param type
	 *            type the key indicating the type of adapter in question.
	 * @return true if type is an instance of CollectionItemProvider
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return (type instanceof CollectionItemProvider);
	}

	/**
	 * This method is the first one being called during the search for an
	 * appropriate adapter.
	 * 
	 *@param target
	 *            arbitrary object to adapt.
	 * @param type
	 *            the key indicating the type of adapter required.
	 * @return an instance of CollectionItemProvider if target is a subclass of
	 *         {@link java.util.Collection}. Otherwise we delegate to the
	 *         superclass implementation
	 *         {@link AdapterFactoryImpl#adapt(Object, Object)}.
	 * 
	 */
	@Override
	public Object adapt(Object target, Object type) {
		if (target instanceof Collection) {
			if (collectionItemProvider == null) {
				collectionItemProvider = new CollectionItemProvider(this);
			}
			return collectionItemProvider;
		} else {
			return super.adapt(target, type);
		}
	}

}
