/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.versioning;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.unicase.metamodel.ModelElementId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>History Query</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery#getSource <em>Source</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery#getTarget <em>Target</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery#getModelElements <em>Model Elements</em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery#isIncludeChangePackage <em>Include Change Package
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.server.model.versioning.VersioningPackage#getHistoryQuery()
 * @model
 * @generated
 */
public interface HistoryQuery extends EObject {
	/**
	 * Returns the value of the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source</em>' containment reference.
	 * @see #setSource(PrimaryVersionSpec)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.VersioningPackage#getHistoryQuery_Source()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	PrimaryVersionSpec getSource();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery#getSource <em>Source</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Source</em>' containment reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(PrimaryVersionSpec)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.VersioningPackage#getHistoryQuery_Target()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	PrimaryVersionSpec getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery#getTarget <em>Target</em>}'
	 * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(PrimaryVersionSpec value);

	/**
	 * Returns the value of the '<em><b>Model Elements</b></em>' containment reference list. The list contents are of
	 * type {@link org.unicase.metamodel.ModelElementId}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Elements</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Elements</em>' containment reference list.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.VersioningPackage#getHistoryQuery_ModelElements()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ModelElementId> getModelElements();

	/**
	 * Returns the value of the '<em><b>Include Change Package</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Include Change Package</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Include Change Package</em>' attribute.
	 * @see #setIncludeChangePackage(boolean)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.VersioningPackage#getHistoryQuery_IncludeChangePackage()
	 * @model
	 * @generated
	 */
	boolean isIncludeChangePackage();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery#isIncludeChangePackage
	 * <em>Include Change Package</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Include Change Package</em>' attribute.
	 * @see #isIncludeChangePackage()
	 * @generated
	 */
	void setIncludeChangePackage(boolean value);

} // HistoryQuery
