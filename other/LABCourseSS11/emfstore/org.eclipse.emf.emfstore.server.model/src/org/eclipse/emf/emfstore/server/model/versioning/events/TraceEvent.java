/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering,
 * Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.server.model.versioning.events;

import org.eclipse.emf.emfstore.common.model.ModelElementId;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Trace Event</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.TraceEvent#getSourceElement <em>Source Element
 * </em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.TraceEvent#getTargetElement <em>Target Element
 * </em>}</li>
 * <li>{@link org.eclipse.emf.emfstore.server.model.versioning.events.TraceEvent#getFeatureName <em>Feature Name</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getTraceEvent()
 * @model
 * @generated
 */
public interface TraceEvent extends Event {
	/**
	 * Returns the value of the '<em><b>Source Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source Element</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Source Element</em>' containment reference.
	 * @see #setSourceElement(ModelElementId)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getTraceEvent_SourceElement()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getSourceElement();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.events.TraceEvent#getSourceElement
	 * <em>Source Element</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Source Element</em>' containment reference.
	 * @see #getSourceElement()
	 * @generated
	 */
	void setSourceElement(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Target Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Element</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target Element</em>' containment reference.
	 * @see #setTargetElement(ModelElementId)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getTraceEvent_TargetElement()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	ModelElementId getTargetElement();

	/**
	 * Sets the value of the '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.events.TraceEvent#getTargetElement
	 * <em>Target Element</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Target Element</em>' containment reference.
	 * @see #getTargetElement()
	 * @generated
	 */
	void setTargetElement(ModelElementId value);

	/**
	 * Returns the value of the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Name</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Feature Name</em>' attribute.
	 * @see #setFeatureName(String)
	 * @see org.eclipse.emf.emfstore.server.model.versioning.events.EventsPackage#getTraceEvent_FeatureName()
	 * @model
	 * @generated
	 */
	String getFeatureName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.emfstore.server.model.versioning.events.TraceEvent#getFeatureName
	 * <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Feature Name</em>' attribute.
	 * @see #getFeatureName()
	 * @generated
	 */
	void setFeatureName(String value);

} // TraceEvent
