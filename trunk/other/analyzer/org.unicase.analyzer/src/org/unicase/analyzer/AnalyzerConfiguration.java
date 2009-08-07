/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer;

import org.eclipse.emf.ecore.EObject;
import org.unicase.analyzer.exporters.Exporter;
import org.unicase.analyzer.iterator.VersionIterator;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Configuration</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.analyzer.AnalyzerConfiguration#getIterator <em>Iterator</em>}</li>
 *   <li>{@link org.unicase.analyzer.AnalyzerConfiguration#getAnalyzerName <em>Analyzer Name</em>}</li>
 *   <li>{@link org.unicase.analyzer.AnalyzerConfiguration#getExporter <em>Exporter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.analyzer.AnalyzerPackage#getAnalyzerConfiguration()
 * @model
 * @generated
 */
public interface AnalyzerConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Iterator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterator</em>' containment reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterator</em>' containment reference.
	 * @see #setIterator(VersionIterator)
	 * @see org.unicase.analyzer.AnalyzerPackage#getAnalyzerConfiguration_Iterator()
	 * @model containment="true"
	 * @generated
	 */
	VersionIterator getIterator();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.AnalyzerConfiguration#getIterator <em>Iterator</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iterator</em>' containment reference.
	 * @see #getIterator()
	 * @generated
	 */
	void setIterator(VersionIterator value);

	/**
	 * Returns the value of the '<em><b>Analyzer Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Analyzer Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Analyzer Name</em>' attribute.
	 * @see #setAnalyzerName(String)
	 * @see org.unicase.analyzer.AnalyzerPackage#getAnalyzerConfiguration_AnalyzerName()
	 * @model
	 * @generated
	 */
	String getAnalyzerName();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.AnalyzerConfiguration#getAnalyzerName <em>Analyzer Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Analyzer Name</em>' attribute.
	 * @see #getAnalyzerName()
	 * @generated
	 */
	void setAnalyzerName(String value);

	/**
	 * Returns the value of the '<em><b>Exporter</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exporter</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exporter</em>' containment reference.
	 * @see #setExporter(Exporter)
	 * @see org.unicase.analyzer.AnalyzerPackage#getAnalyzerConfiguration_Exporter()
	 * @model containment="true"
	 * @generated
	 */
	Exporter getExporter();

	/**
	 * Sets the value of the '{@link org.unicase.analyzer.AnalyzerConfiguration#getExporter <em>Exporter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exporter</em>' containment reference.
	 * @see #getExporter()
	 * @generated
	 */
	void setExporter(Exporter value);

} // AnalyzerConfiguration
