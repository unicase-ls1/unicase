/**
 * <copyright> </copyright> $Id$
 */
package urml.requirement;

import org.eclipse.emf.common.util.EList;

import urml.danger.Mitigation;

import urml.service.Service;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.requirement.Requirement#getImplementingServices <em>Implementing Services</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.requirement.RequirementPackage#getRequirement()
 * @model abstract="true"
 * @generated
 */
public interface Requirement extends Mitigation {
	/**
	 * Returns the value of the '<em><b>Implementing Services</b></em>' reference list.
	 * The list contents are of type {@link urml.service.Service}.
	 * It is bidirectional and its opposite is '{@link urml.service.Service#getSatisfiedRequirements <em>Satisfied Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementing Services</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implementing Services</em>' reference list.
	 * @see urml.requirement.RequirementPackage#getRequirement_ImplementingServices()
	 * @see urml.service.Service#getSatisfiedRequirements
	 * @model opposite="satisfiedRequirements" keys="identifier"
	 * @generated
	 */
	EList<Service> getImplementingServices();

} // Requirement
