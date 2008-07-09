/**
 * Copyright (c) 2008 Jonas Helming, Maximilian Kšgel
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment.changepackage;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>ES Change Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESChangePackage#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage#getESChangePackage()
 * @model
 * @generated
 */
public interface ESChangePackage extends EObject {
	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.emfstore.esmodel.changemanagment.changepackage.ESAbstractOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see org.unicase.emfstore.esmodel.changemanagment.changepackage.ChangepackagePackage#getESChangePackage_Operations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ESAbstractOperation> getOperations();

} // ESChangePackage
