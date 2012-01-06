/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.urml;

import org.unicase.metamodel.NonDomainElement;

import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project Settings</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.urml.UrmlProjectSettings#getActivePhase <em>Active Phase</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.urml.UrmlPackage#getUrmlProjectSettings()
 * @model
 * @generated
 */
public interface UrmlProjectSettings extends UnicaseModelElement,
		NonDomainElement {

	/**
	 * Returns the value of the '<em><b>Active Phase</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Phase</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Phase</em>' reference.
	 * @see #setActivePhase(Phase)
	 * @see org.unicase.model.urml.UrmlPackage#getUrmlProjectSettings_ActivePhase()
	 * @model
	 * @generated
	 */
	Phase getActivePhase();

	/**
	 * Sets the value of the '{@link org.unicase.model.urml.UrmlProjectSettings#getActivePhase <em>Active Phase</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Active Phase</em>' reference.
	 * @see #getActivePhase()
	 * @generated
	 */
	void setActivePhase(Phase value);
} // UrmlProjectSettings
