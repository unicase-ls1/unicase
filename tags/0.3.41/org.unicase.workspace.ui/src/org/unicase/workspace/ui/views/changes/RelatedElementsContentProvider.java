/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.changes;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.IContentProvider;

/**
 * Content provider for the affected elements treeviewer. The class uses an already computed list with children - see
 * the ChangesTreeComposite for more info.
 * 
 * @author Shterev
 */
public class RelatedElementsContentProvider extends AdapterFactoryContentProvider implements IContentProvider {

	private Set<EObject> affected;

	/**
	 * Default constructor.
	 * 
	 * @param affected the affected elements
	 */
	public RelatedElementsContentProvider(Set<EObject> affected) {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		this.affected = affected;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getElements(Object object) {
		return affected.toArray();
	}
}