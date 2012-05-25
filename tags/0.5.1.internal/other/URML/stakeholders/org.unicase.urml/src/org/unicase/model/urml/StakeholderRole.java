/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.urml;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.unicase.metamodel.NonDomainElement;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stakeholder Role</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.urml.StakeholderRole#getReviewSet <em>Review Set</em>}</li>
 *   <li>{@link org.unicase.model.urml.StakeholderRole#getFilterSet <em>Filter Set</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.urml.UrmlPackage#getStakeholderRole()
 * @model
 * @generated
 */
public interface StakeholderRole extends UnicaseModelElement, NonDomainElement {
	/**
	 * Returns the value of the '<em><b>Review Set</b></em>' map.
	 * The key is of type {@link org.eclipse.emf.ecore.EClass},
	 * and the value is of type list of {@link org.eclipse.emf.ecore.EStructuralFeature},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Review Set</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Review Set</em>' map.
	 * @see org.unicase.model.urml.UrmlPackage#getStakeholderRole_ReviewSet()
	 * @model mapType="org.unicase.model.urml.SetEntry<org.eclipse.emf.ecore.EClass, org.eclipse.emf.ecore.EStructuralFeature>"
	 * @generated
	 */
	EMap<EClass, EList<EStructuralFeature>> getReviewSet();

	/**
	 * Returns the value of the '<em><b>Filter Set</b></em>' map.
	 * The key is of type {@link org.eclipse.emf.ecore.EClass},
	 * and the value is of type list of {@link org.eclipse.emf.ecore.EStructuralFeature},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter Set</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter Set</em>' map.
	 * @see org.unicase.model.urml.UrmlPackage#getStakeholderRole_FilterSet()
	 * @model mapType="org.unicase.model.urml.SetEntry<org.eclipse.emf.ecore.EClass, org.eclipse.emf.ecore.EStructuralFeature>"
	 * @generated
	 */
	EMap<EClass, EList<EStructuralFeature>> getFilterSet();

} // StakeholderRole
