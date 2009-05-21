/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright> $Id$
 */
package org.unicase.model.requirement;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Feature</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.requirement.Feature#getDescribingUseCases <em>Describing Use Cases</em>}</li>
 *   <li>{@link org.unicase.model.requirement.Feature#getRefiningFeatures <em>Refining Features</em>}</li>
 *   <li>{@link org.unicase.model.requirement.Feature#getDetailingRequirements <em>Detailing Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.requirement.RequirementPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends ModelElement {
	/**
	 * Returns the value of the '<em><b>Describing Use Cases</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.requirement.UseCase}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.requirement.UseCase#getDescribedFeatures <em>Described Features</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Describing Use Cases</em>' reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Describing Use Cases</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getFeature_DescribingUseCases()
	 * @see org.unicase.model.requirement.UseCase#getDescribedFeatures
	 * @model opposite="describedFeatures" keys="identifier"
	 * @generated
	 */
	EList<UseCase> getDescribingUseCases();

	/**
	 * Returns the value of the '<em><b>Refining Features</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.requirement.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refining Features</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Refining Features</em>' containment reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getFeature_RefiningFeatures()
	 * @model containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<Feature> getRefiningFeatures();

	/**
	 * Returns the value of the '<em><b>Detailing Requirements</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.requirement.FunctionalRequirement}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.requirement.FunctionalRequirement#getDetailedFeatures <em>Detailed Features</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Detailing Requirements</em>' reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Detailing Requirements</em>' reference list.
	 * @see org.unicase.model.requirement.RequirementPackage#getFeature_DetailingRequirements()
	 * @see org.unicase.model.requirement.FunctionalRequirement#getDetailedFeatures
	 * @model opposite="detailedFeatures" keys="identifier"
	 * @generated
	 */
	EList<FunctionalRequirement> getDetailingRequirements();

} // Feature
