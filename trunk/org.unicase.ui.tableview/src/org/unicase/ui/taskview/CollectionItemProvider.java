/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.taskview;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

@Deprecated
public class CollectionItemProvider extends ItemProviderAdapter implements
		IStructuredItemContentProvider {

	public CollectionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	public Collection<?> getElements(Object object) {
		if (object instanceof Collection) {
			return (Collection<?>) object;
		} else {
			return null;
		}
	}
}
