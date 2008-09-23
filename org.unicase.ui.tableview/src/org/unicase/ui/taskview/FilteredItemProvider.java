/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.taskview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.unicase.model.Project;
import org.unicase.model.provider.IdentifiableElementItemProvider;

/**
 * 
 * A provider that only returns values for objects that match certain criteria
 * specified in its {@link #permitsObject(Object)} method.
 * 
 * @author Florian Schneider
 * 
 */
public class FilteredItemProvider extends IdentifiableElementItemProvider {

	/**
	 * Default constructor.
	 * 
	 * @param adapterFactory
	 *            The adapter factory that creates this content provider.
	 */
	public FilteredItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Collection<?> getElements(Object object) {
		return this.getChildren(object);
	}

	/**
	 * Modified getChildren method that test every child object whether it shall
	 * be included in the returned collection or not. The test is performed by
	 * {@link #permitsObject(Object)}.
	 * 
	 * @param object
	 *            the object whose children shall be determined
	 * @return the filtered children
	 */
	@Override
	public Collection<?> getChildren(Object object) {

		Collection<?> allChildren = null;
		if (object instanceof Project) {
			allChildren = ((Project) object).getAllModelElements();
		} else {
			// FS navigate the containment hierarchy of the element (or do
			// something similar)
		}
		ArrayList<Object> filteredChildren = new ArrayList<Object>();

		for (Object currentObject : allChildren) {
			if (permitsObject(currentObject)) {
				filteredChildren.add(currentObject);
			}
		}
		return filteredChildren;
	}

	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		// TODO Auto-generated method stub
		return super.getPropertyDescriptors(object);
	}

	/**
	 * The method that tests whether an object is valid for this provider or
	 * not. This is intended to be overridden by subclasses.
	 * 
	 * @param objectToTest
	 *            the object in question
	 * @return true if the object is valid, false otherwise.
	 */
	protected boolean permitsObject(Object objectToTest) {
		return true;
	}
}
