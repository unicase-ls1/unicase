/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.navigator.workSpaceModel;

import java.util.Collection;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.ui.common.ECPModelelementContext;
import org.unicase.ui.common.MetaModelElementContext;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>ECP Project</b></em>'. <!-- end-user-doc -->
 * 
 * @see org.unicase.ui.navigator.workSpaceModel.WorkSpaceModelPackage#getECPProject()
 * @model abstract="true"
 * @generated
 */
public interface ECPProject extends EObject, ECPModelelementContext {

	boolean contains(EObject eObject);

	Collection<EObject> getAllModelElement();

	Collection<EObject> getAllModelElementsbyClass(EClass clazz, BasicEList<EObject> basicEList);

	MetaModelElementContext getMetaModelElementContext();

	boolean isNonDomainElement(EObject eObject);

} // ECPProject
