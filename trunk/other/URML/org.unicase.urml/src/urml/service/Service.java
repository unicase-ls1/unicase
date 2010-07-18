/**
 * <copyright> </copyright> $Id$
 */
package urml.service;

import org.eclipse.emf.common.util.EList;

import urml.danger.Asset;
import urml.requirement.Requirement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Service</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link urml.service.Service#getSatisfiedRequirements <em>Satisfied Requirements</em>}</li>
 * <li>{@link urml.service.Service#getUsedClasses <em>Used Classes</em>}</li>
 * <li>{@link urml.service.Service#getParentService <em>Parent Service</em>}</li>
 * <li>{@link urml.service.Service#getSubServices <em>Sub Services</em>}</li>
 * </ul>
 * </p>
 * 
 * @see urml.service.ServicePackage#getService()
 * @model
 * @generated
 */
public interface Service extends Asset {
	/**
	 * Returns the value of the '<em><b>Satisfied Requirements</b></em>' reference list. The list contents are of type
	 * {@link urml.requirement.Requirement}. It is bidirectional and its opposite is '
	 * {@link urml.requirement.Requirement#getImplementingServices <em>Implementing Services</em>}'. <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Satisfied Requirements</em>' reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Satisfied Requirements</em>' reference list.
	 * @see urml.service.ServicePackage#getService_SatisfiedRequirements()
	 * @see urml.requirement.Requirement#getImplementingServices
	 * @model opposite="implementingServices" keys="identifier"
	 * @generated
	 */
	EList<Requirement> getSatisfiedRequirements();

	/**
	 * Returns the value of the '<em><b>Used Classes</b></em>' reference list. The list contents are of type
	 * {@link org.unicase.model.classes.Class}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Classes</em>' reference list isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Used Classes</em>' reference list.
	 * @see urml.service.ServicePackage#getService_UsedClasses()
	 * @model
	 * @generated
	 */
	EList<org.unicase.model.classes.Class> getUsedClasses();

	/**
	 * Returns the value of the '<em><b>Parent Service</b></em>' container reference. It is bidirectional and its
	 * opposite is '{@link urml.service.Service#getSubServices <em>Sub Services</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Service</em>' container reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parent Service</em>' container reference.
	 * @see #setParentService(Service)
	 * @see urml.service.ServicePackage#getService_ParentService()
	 * @see urml.service.Service#getSubServices
	 * @model opposite="subServices" keys="identifier" transient="false"
	 * @generated
	 */
	Service getParentService();

	/**
	 * Sets the value of the '{@link urml.service.Service#getParentService <em>Parent Service</em>}' container
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Parent Service</em>' container reference.
	 * @see #getParentService()
	 * @generated
	 */
	void setParentService(Service value);

	/**
	 * Returns the value of the '<em><b>Sub Services</b></em>' containment reference list. The list contents are of type
	 * {@link urml.service.Service}. It is bidirectional and its opposite is '
	 * {@link urml.service.Service#getParentService <em>Parent Service</em>}'. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Services</em>' containment reference list isn't clear, there really should be more
	 * of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Sub Services</em>' containment reference list.
	 * @see urml.service.ServicePackage#getService_SubServices()
	 * @see urml.service.Service#getParentService
	 * @model opposite="parentService" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<Service> getSubServices();

} // Service
