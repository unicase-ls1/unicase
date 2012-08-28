/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.service;

import org.eclipse.emf.common.util.EList;
import org.unicase.model.urml.danger.Asset;
import org.unicase.model.urml.requirement.Requirement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Service</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.urml.service.Service#getSatisfiedRequirements <em>Satisfied Requirements</em>}</li>
 *   <li>{@link org.unicase.model.urml.service.Service#getParentService <em>Parent Service</em>}</li>
 *   <li>{@link org.unicase.model.urml.service.Service#getSubServices <em>Sub Services</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.urml.service.ServicePackage#getService()
 * @model
 * @generated
 */
public interface Service extends Asset {
	/**
	 * Returns the value of the '<em><b>Satisfied Requirements</b></em>' reference list.
	 * The list contents are of type {@link org.unicase.model.urml.requirement.Requirement}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.urml.requirement.Requirement#getImplementingServices <em>Implementing Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Satisfied Requirements</em>' reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Satisfied Requirements</em>' reference list.
	 * @see org.unicase.model.urml.service.ServicePackage#getService_SatisfiedRequirements()
	 * @see org.unicase.model.urml.requirement.Requirement#getImplementingServices
	 * @model opposite="implementingServices"
	 * @generated
	 */
	EList<Requirement> getSatisfiedRequirements();

	/**
	 * Returns the value of the '<em><b>Parent Service</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link org.unicase.model.urml.service.Service#getSubServices <em>Sub Services</em>}'. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Service</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent Service</em>' container reference.
	 * @see #setParentService(Service)
	 * @see org.unicase.model.urml.service.ServicePackage#getService_ParentService()
	 * @see org.unicase.model.urml.service.Service#getSubServices
	 * @model opposite="subServices" keys="identifier" transient="false"
	 * @generated
	 */
	Service getParentService();

	/**
	 * Sets the value of the '{@link org.unicase.model.urml.service.Service#getParentService <em>Parent Service</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Service</em>' container reference.
	 * @see #getParentService()
	 * @generated
	 */
	void setParentService(Service value);

	/**
	 * Returns the value of the '<em><b>Sub Services</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.urml.service.Service}.
	 * It is bidirectional and its opposite is '{@link org.unicase.model.urml.service.Service#getParentService <em>Parent Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Services</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Services</em>' containment reference list.
	 * @see org.unicase.model.urml.service.ServicePackage#getService_SubServices()
	 * @see org.unicase.model.urml.service.Service#getParentService
	 * @model opposite="parentService" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Service> getSubServices();

} // Service
