/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import java.util.Set;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.task.util.TaxonomyAccess;

/**
 * . This is the ContentProvider for flat tab TableViewer.
 * 
 * @author Hodaie
 */
public class FlatTabContentProvider extends AdapterFactoryContentProvider {

	/**
	 * . Constructor
	 */
	public FlatTabContentProvider() {
		super(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

	}

	/**
	 * {@inheritDoc} I implemented the getEelemnts() based of my own imagination of what should be shown in flat tab and
	 * after talks with Helmut. The implementation might be changed later. This implementation return a (hierarchical)
	 * list of all Checkables/Assignables corresponding to input model element. For example, if a FunctionalRequirement
	 * has some child FRs as its refiningRequirements(), their Checkables and Assignables are also considered the
	 * parents Checkables and Assignables and shown in flat tab of parent. All direct Annotations of the model element
	 * are also shown beside its recursively gathered Checkables/Assignables.
	 */
	@Override
	public Object[] getElements(Object object) {
		if (object instanceof UnicaseModelElement) {
			UnicaseModelElement me = (UnicaseModelElement) object;
			Set<UnicaseModelElement> result = TaxonomyAccess.getInstance().getOpeningLinkTaxonomy().getLeafOpeners(me);
			return result.toArray(new Object[result.size()]);

		} else {
			return new Object[0];
		}

	}

}
