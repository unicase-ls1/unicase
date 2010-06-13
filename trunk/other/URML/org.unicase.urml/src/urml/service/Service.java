/**
 * <copyright> </copyright> $Id$
 */
package urml.service;

import org.eclipse.emf.common.util.EList;

import urml.danger.Mitigation;

import urml.requirement.Requirement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.service.Service#getServiceProvider <em>Service Provider</em>}</li>
 *   <li>{@link urml.service.Service#getSatisfiedRequirements <em>Satisfied Requirements</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.service.ServicePackage#getService()
 * @model
 * @generated
 */
public interface Service extends Mitigation {
	/**
	 * Returns the value of the '<em><b>Service Provider</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link urml.service.ServiceProvider#getProvidedServices <em>Provided Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Provider</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Provider</em>' container reference.
	 * @see #setServiceProvider(ServiceProvider)
	 * @see urml.service.ServicePackage#getService_ServiceProvider()
	 * @see urml.service.ServiceProvider#getProvidedServices
	 * @model opposite="providedServices" keys="identifier" transient="false"
	 * @generated
	 */
	ServiceProvider getServiceProvider();

	/**
	 * Sets the value of the '{@link urml.service.Service#getServiceProvider <em>Service Provider</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Provider</em>' container reference.
	 * @see #getServiceProvider()
	 * @generated
	 */
	void setServiceProvider(ServiceProvider value);

	/**
	 * Returns the value of the '<em><b>Satisfied Requirements</b></em>' reference list.
	 * The list contents are of type {@link urml.requirement.Requirement}.
	 * It is bidirectional and its opposite is '{@link urml.requirement.Requirement#getImplementingServices <em>Implementing Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Satisfied Requirements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Satisfied Requirements</em>' reference list.
	 * @see urml.service.ServicePackage#getService_SatisfiedRequirements()
	 * @see urml.requirement.Requirement#getImplementingServices
	 * @model opposite="implementingServices" keys="identifier"
	 * @generated
	 */
	EList<Requirement> getSatisfiedRequirements();

} // Service
