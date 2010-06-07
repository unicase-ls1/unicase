/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package urml.service;

import org.eclipse.emf.common.util.EList;

import urml.danger.Asset;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link urml.service.ServiceProvider#getProvidedServices <em>Provided Services</em>}</li>
 * </ul>
 * </p>
 *
 * @see urml.service.ServicePackage#getServiceProvider()
 * @model
 * @generated
 */
public interface ServiceProvider extends Asset {
	/**
	 * Returns the value of the '<em><b>Provided Services</b></em>' containment reference list.
	 * The list contents are of type {@link urml.service.Service}.
	 * It is bidirectional and its opposite is '{@link urml.service.Service#getServiceProvider <em>Service Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Services</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Services</em>' containment reference list.
	 * @see urml.service.ServicePackage#getServiceProvider_ProvidedServices()
	 * @see urml.service.Service#getServiceProvider
	 * @model opposite="serviceProvider" containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<Service> getProvidedServices();

} // ServiceProvider
