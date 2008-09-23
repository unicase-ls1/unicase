/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.taskview;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.model.ModelPackage;

public class EClassFilterItemProvider extends FilteredItemProvider {

	private EClass itemClass;

	public EClassFilterItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
		this.itemClass = ModelPackage.eINSTANCE.getIdentifiableElement();
	}

	public EClassFilterItemProvider(AdapterFactory adapterFactory,
			EClass itemClass) {
		super(adapterFactory);
		this.itemClass = itemClass;
	}

	@Override
	protected boolean permitsObject(Object objectToTest) {
		if (objectToTest instanceof EObject) {
			return itemClass.isSuperTypeOf(((EObject) objectToTest).eClass());
		} else {
			return false;
		}
	}

}
