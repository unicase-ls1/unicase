/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.urml;

import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.unicase.metamodel.NonDomainElement;
import org.unicase.model.UnicaseModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Phase</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.urml.Phase#getAllowedAssociations <em>Allowed Associations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.urml.UrmlPackage#getPhase()
 * @model
 * @generated
 */
public interface Phase extends UnicaseModelElement, NonDomainElement {
	/**
	 * Returns the value of the '<em><b>Allowed Associations</b></em>' map.
	 * The key is of type {@link org.eclipse.emf.ecore.EClass},
	 * and the value is of type list of {@link org.eclipse.emf.ecore.EClass},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allowed Associations</em>' map isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allowed Associations</em>' map.
	 * @see org.unicase.model.urml.UrmlPackage#getPhase_AllowedAssociations()
	 * @model mapType="org.unicase.model.urml.PhaseSetEntry<org.eclipse.emf.ecore.EClass, org.eclipse.emf.ecore.EClass>"
	 * @generated
	 */
	EMap<EClass, EList<EClass>> getAllowedAssociations();

} // Phase
