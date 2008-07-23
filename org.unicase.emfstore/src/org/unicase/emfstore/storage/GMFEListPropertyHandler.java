/**
 * <copyright>
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Springsite BV (The Netherlands) and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Martin Taal - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: GMFEListPropertyHandler.java,v 1.1 2008/03/17 16:13:35 mtaal Exp $
 */
package org.unicase.emfstore.storage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.teneo.hibernate.mapping.property.EListPropertyHandler;
import org.eclipse.gmf.runtime.notation.impl.NotationPackageImpl;

//FIXME: this is a copy from the teneo webpage!!!
/**
 * This specific EListPropertyHandler is required because of the specific
 * implementation of the GMF NotationPackageImpl. In the init method of this
 * EPackage the efeature for which a java member with the name persistedChildren
 * was generated is re-named to children. This confuses Teneo.
 * 
 * See also here: https://bugs.eclipse.org/bugs/show_bug.cgi?id=159226#c12
 * 
 * @author mtaal@elver.org
 */

public class GMFEListPropertyHandler extends EListPropertyHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected String getFieldName(Object owner) {
		if (!(owner instanceof EObject)) { // can this occur?
			return super.getFieldName(owner);
		}
		final EObject eObject = (EObject) owner;
		final EClass eClass = eObject.eClass();
		final String featureName = super.getFieldName(owner);
		if (NotationPackageImpl.eINSTANCE.getDiagram().isSuperTypeOf(eClass)
				&& featureName.compareTo("edges") == 0) {
			return "persistedEdges";
		}

		if (NotationPackageImpl.eINSTANCE.getView().isSuperTypeOf(eClass)
				&& featureName.compareTo("children") == 0) {
			return "persistedChildren";
		}
		return featureName;
	}
}
