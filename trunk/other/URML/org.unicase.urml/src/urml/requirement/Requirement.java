/**
 * <copyright> </copyright> $Id$
 */
package urml.requirement;

import org.eclipse.emf.common.util.EList;

import urml.danger.Mitigation;
import urml.service.Service;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Requirement</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link urml.requirement.Requirement#getImplementingServices <em>Implementing Services</em>}</li>
 * <li>{@link urml.requirement.Requirement#getSubRequirements <em>Sub Requirements</em>}</li>
 * <li>{@link urml.requirement.Requirement#getParentRequirement <em>Parent Requirement</em>}</li>
 * <li>{@link urml.requirement.Requirement#isTerminal <em>Terminal</em>}</li>
 * </ul>
 * </p>
 * 
 * @see urml.requirement.RequirementPackage#getRequirement()
 * @model abstract="true"
 * @generated
 */
public interface Requirement extends Mitigation {
	/**
	 * Returns the value of the '<em><b>Implementing Services</b></em>' reference list. The list contents are of type
	 * {@link urml.service.Service}. It is bidirectional and its opposite is '
	 * {@link urml.service.Service#getSatisfiedRequirements <em>Satisfied Requirements</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implementing Services</em>' reference list isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Implementing Services</em>' reference list.
	 * @see urml.requirement.RequirementPackage#getRequirement_ImplementingServices()
	 * @see urml.service.Service#getSatisfiedRequirements
	 * @model opposite="satisfiedRequirements" keys="identifier"
	 * @generated
	 */
	EList<Service> getImplementingServices();

	/**
	 * Returns the value of the '<em><b>Sub Requirements</b></em>' containment reference list. The list contents are of
	 * type {@link urml.requirement.Requirement}. It is bidirectional and its opposite is '
	 * {@link urml.requirement.Requirement#getParentRequirement <em>Parent Requirement</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Requirements</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sub Requirements</em>' containment reference list.
	 * @see urml.requirement.RequirementPackage#getRequirement_SubRequirements()
	 * @see urml.requirement.Requirement#getParentRequirement
	 * @model opposite="parentRequirement" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<Requirement> getSubRequirements();

	/**
	 * Returns the value of the '<em><b>Parent Requirement</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link urml.requirement.Requirement#getSubRequirements <em>Sub Requirements</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Requirement</em>' container reference isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent Requirement</em>' container reference.
	 * @see #setParentRequirement(Requirement)
	 * @see urml.requirement.RequirementPackage#getRequirement_ParentRequirement()
	 * @see urml.requirement.Requirement#getSubRequirements
	 * @model opposite="subRequirements" keys="identifier" transient="false"
	 * @generated
	 */
	Requirement getParentRequirement();

	/**
	 * Sets the value of the '{@link urml.requirement.Requirement#getParentRequirement <em>Parent Requirement</em>}'
	 * container reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Parent Requirement</em>' container reference.
	 * @see #getParentRequirement()
	 * @generated
	 */
	void setParentRequirement(Requirement value);

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
	 * @see urml.requirement.RequirementPackage#getRequirement_Terminal()
	 * @model
	 * @generated
	 */
	boolean isTerminal();

	/**
	 * Sets the value of the '{@link urml.requirement.Requirement#isTerminal <em>Terminal</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Terminal</em>' attribute.
	 * @see #isTerminal()
	 * @generated
	 */
	void setTerminal(boolean value);

} // Requirement
