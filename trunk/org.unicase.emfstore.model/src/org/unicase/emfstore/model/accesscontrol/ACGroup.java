/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.model.accesscontrol;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>AC Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.emfstore.model.accesscontrol.ACGroup#getMembers <em>Members</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.emfstore.model.accesscontrol.AccesscontrolPackage#getACGroup()
 * @model
 * @generated
 */
public interface ACGroup extends ACOrgUnit {
	/**
	 * Returns the value of the '<em><b>Members</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.emfstore.model.accesscontrol.ACOrgUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' reference list.
	 * @see org.unicase.emfstore.model.accesscontrol.AccesscontrolPackage#getACGroup_Members()
	 * @model
	 * @generated
	 */
	EList<ACOrgUnit> getMembers();

} // ACGroup
