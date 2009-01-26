/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.taskview;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelPackage;
import org.unicase.model.Project;
import org.unicase.model.provider.IdentifiableElementItemProvider;

/**
 * Provider which can be restricted to a certain class of modelelements.
 * 
 * @author helming
 */
public class EClassFilterItemProvider extends IdentifiableElementItemProvider {

	private EClass itemClass;

	/**
	 * Default constructor.
	 * 
	 * @param adapterFactory The adapter factory that creates this content provider.
	 */

	public EClassFilterItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		this.itemClass = ModelPackage.eINSTANCE.getIdentifiableElement();
	}

	/**
	 * Default constructor.
	 * 
	 * @param adapterFactory The adapter factory that creates this content provider.
	 * @param itemClass The class which should be shown
	 */
	public EClassFilterItemProvider(AdapterFactory adapterFactory, EClass itemClass) {
		super(adapterFactory);
		this.itemClass = itemClass;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<?> getElements(Object object) {
		return this.getChildren(object);
	}

	/**
	 * Modified getChildren method that test every child object whether it shall be included in the returned collection
	 * or not. The test is performed by {@link #permitsObject(Object)}.
	 * 
	 * @param object the object whose children shall be determined
	 * @return the filtered children
	 */
	@Override
	public Collection<?> getChildren(Object object) {

		EList<ModelElement> allChildren = new BasicEList<ModelElement>();
		if (object instanceof Project) {
			allChildren = ((Project) object).getAllModelElementsbyClass(itemClass, allChildren);
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

	/**
	 * The method that tests whether an object is valid for this provider or not. This is intended to be overridden by
	 * subclasses.
	 * 
	 * @param objectToTest the object in question
	 * @return true if the object is valid, false otherwise.
	 */
	protected boolean permitsObject(Object objectToTest) {
		return true;
	}
}
