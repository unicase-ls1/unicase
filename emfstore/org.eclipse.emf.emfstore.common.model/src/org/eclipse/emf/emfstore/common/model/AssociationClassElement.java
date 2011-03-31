/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.common.model;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc --> A model element which represents an association class. An association class corresponds to a
 * link between to elements which carries additional attributes, such as a label of the link.</b></em>'. <!--
 * end-user-doc -->
 *
 *
 * @see org.eclipse.emf.emfstore.common.model.ModelPackage#getAssociationClassElement()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface AssociationClassElement extends EObject {

	/**
	 * Return the feature in which the source element of this link is contained.
	 * 
	 * @return the source feature
	 * @generated NOT
	 */
	EReference getSourceFeature();

	/**
	 * Return the feature in which the target element of this link is contained.
	 * 
	 * @return the source feature
	 * @generated NOT
	 */
	EReference getTargetFeature();

	/**
	 * Return the features which constitute the features of this link that contain information about the link, other
	 * than source and target. The list should be ordered by priority of the ferature, important features first.
	 * 
	 * @return a list of features
	 * @generated NOT
	 */
	List<EStructuralFeature> getAssociationFeatures();

} // AssociationClassElement

