/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.orga;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Team</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.orga.Team#getHasOrgUnit <em>Has Org Unit</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.orga.OrgaPackage#getTeam()
 * @model
 * @generated
 */
public interface Team extends OrgaUnit {
	/**
	 * Returns the value of the '<em><b>Has Org Unit</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.orga.OrgaUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Org Unit</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Org Unit</em>' reference list.
	 * @see org.unicase.model.orga.OrgaPackage#getTeam_HasOrgUnit()
	 * @model
	 * @generated
	 */
	EList<OrgaUnit> getHasOrgUnit();

} // Team
