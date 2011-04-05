/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.trace;

import org.eclipse.emf.common.util.EList;

import org.unicase.metamodel.NonDomainElement;

import org.unicase.model.Attachment;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Code Location</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.model.trace.CodeLocation#getLineContent <em>Line Content</em>}</li>
 *   <li>{@link org.unicase.model.trace.CodeLocation#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.unicase.model.trace.CodeLocation#getPathInProject <em>Path In Project</em>}</li>
 *   <li>{@link org.unicase.model.trace.CodeLocation#getLinesBefore <em>Lines Before</em>}</li>
 *   <li>{@link org.unicase.model.trace.CodeLocation#getLinesAfter <em>Lines After</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.model.trace.TracePackage#getCodeLocation()
 * @model
 * @generated
 */
public interface CodeLocation extends Attachment, NonDomainElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>\r";

	/**
	 * Returns the value of the '<em><b>Line Content</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Line Content</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Line Content</em>' attribute.
	 * @see #setLineContent(String)
	 * @see org.unicase.model.trace.TracePackage#getCodeLocation_LineContent()
	 * @model
	 * @generated
	 */
	String getLineContent();

	/**
	 * Sets the value of the '{@link org.unicase.model.trace.CodeLocation#getLineContent <em>Line Content</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line Content</em>' attribute.
	 * @see #getLineContent()
	 * @generated
	 */
	void setLineContent(String value);

	/**
	 * Returns the value of the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Name</em>' attribute.
	 * @see #setProjectName(String)
	 * @see org.unicase.model.trace.TracePackage#getCodeLocation_ProjectName()
	 * @model
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link org.unicase.model.trace.CodeLocation#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

	/**
	 * Returns the value of the '<em><b>Path In Project</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path In Project</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path In Project</em>' attribute.
	 * @see #setPathInProject(String)
	 * @see org.unicase.model.trace.TracePackage#getCodeLocation_PathInProject()
	 * @model
	 * @generated
	 */
	String getPathInProject();

	/**
	 * Sets the value of the '{@link org.unicase.model.trace.CodeLocation#getPathInProject <em>Path In Project</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path In Project</em>' attribute.
	 * @see #getPathInProject()
	 * @generated
	 */
	void setPathInProject(String value);

	/**
	 * Returns the value of the '<em><b>Lines Before</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.trace.LineHash}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lines Before</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lines Before</em>' containment reference list.
	 * @see org.unicase.model.trace.TracePackage#getCodeLocation_LinesBefore()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<LineHash> getLinesBefore();

	/**
	 * Returns the value of the '<em><b>Lines After</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.model.trace.LineHash}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lines After</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lines After</em>' containment reference list.
	 * @see org.unicase.model.trace.TracePackage#getCodeLocation_LinesAfter()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<LineHash> getLinesAfter();

} // CodeLocation
