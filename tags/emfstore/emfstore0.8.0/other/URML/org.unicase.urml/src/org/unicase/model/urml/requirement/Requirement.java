/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.requirement;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.urml.danger.Mitigation;
import org.unicase.model.urml.service.Service;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Requirement</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.model.urml.requirement.Requirement#getImplementingServices <em>Implementing Services</em>}</li>
 * <li>{@link org.unicase.model.urml.requirement.Requirement#isTerminal <em>Terminal</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.model.urml.requirement.RequirementPackage#getRequirement()
 * @model abstract="true"
 * @generated
 */
public interface Requirement extends Mitigation {
	/**
	 * Returns the value of the '<em><b>Implementing Services</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.urml.service.Service}. It is bidirectional and its opposite is '
	 * {@link org.unicase.model.urml.service.Service#getSatisfiedRequirements <em>Satisfied Requirements</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementing Services</em>' reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Implementing Services</em>' reference list.
	 * @see org.unicase.model.urml.requirement.RequirementPackage#getRequirement_ImplementingServices()
	 * @see org.unicase.model.urml.service.Service#getSatisfiedRequirements
	 * @model opposite="satisfiedRequirements" keys="identifier"
	 * @generated
	 */
	EList<Service> getImplementingServices();

	/**
	 * Returns the value of the '<em><b>Terminal</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Terminal</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Terminal</em>' attribute.
	 * @see #setTerminal(boolean)
	 * @see org.unicase.model.urml.requirement.RequirementPackage#getRequirement_Terminal()
	 * @model
	 * @generated
	 */
	boolean isTerminal();

	/**
	 * Sets the value of the '{@link org.unicase.model.urml.requirement.Requirement#isTerminal <em>Terminal</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Terminal</em>' attribute.
	 * @see #isTerminal()
	 * @generated
	 */
	void setTerminal(boolean value);

} // Requirement
