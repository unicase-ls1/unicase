/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.esmodel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.unicase.esmodel.accesscontrol.OrgUnit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Administration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.esmodel.Administration#getOrgUnits <em>Org Units</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.esmodel.EsmodelPackage#getAdministration()
 * @model
 * @generated
 */
public interface Administration extends EObject {
	/**
	 * Returns the value of the '<em><b>Org Units</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.esmodel.accesscontrol.OrgUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Org Units</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Org Units</em>' containment reference list.
	 * @see org.unicase.esmodel.EsmodelPackage#getAdministration_OrgUnits()
	 * @model containment="true"
	 * @generated
	 */
	EList<OrgUnit> getOrgUnits();

} // Administration
