/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.accesscontrol;

import org.eclipse.emf.ecore.EObject;
import org.unicase.emfstore.esmodel.ProjectId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Org Unit Properties</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty#getName <em>Name</em>}</li>
 * <li>{@link org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage#getOrgUnitProperties()
 * @model
 * @generated
 */
public interface OrgUnitProperty extends EObject {

	public final static String ARRAY_SEPARATOR = "§";

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage#getOrgUnitProperty_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty#getName <em>Name</em>}'
	 * attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage#getOrgUnitProperty_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty#getValue <em>Value</em>}
	 * ' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Project</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Project</em>' containment reference.
	 * @see #setProject(ProjectId)
	 * @see org.unicase.emfstore.esmodel.accesscontrol.AccesscontrolPackage#getOrgUnitProperty_Project()
	 * @model containment="true" resolveProxies="true" keys="id"
	 * @generated
	 */
	ProjectId getProject();

	/**
	 * Sets the value of the '{@link org.unicase.emfstore.esmodel.accesscontrol.OrgUnitProperty#getProject
	 * <em>Project</em>}' containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Project</em>' containment reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(ProjectId value);

} // OrgUnitProperties
