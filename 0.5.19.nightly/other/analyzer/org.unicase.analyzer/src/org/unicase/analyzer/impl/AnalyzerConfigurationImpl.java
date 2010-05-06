/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.unicase.analyzer.AnalyzerConfiguration;
import org.unicase.analyzer.AnalyzerPackage;
import org.unicase.analyzer.exporters.Exporter;
import org.unicase.analyzer.iterator.VersionIterator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Configuration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.analyzer.impl.AnalyzerConfigurationImpl#getIterator <em>Iterator</em>}</li>
 *   <li>{@link org.unicase.analyzer.impl.AnalyzerConfigurationImpl#getAnalyzerNames <em>Analyzer Names</em>}</li>
 *   <li>{@link org.unicase.analyzer.impl.AnalyzerConfigurationImpl#getExporter <em>Exporter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnalyzerConfigurationImpl extends EObjectImpl implements AnalyzerConfiguration {
	/**
	 * The cached value of the '{@link #getIterator() <em>Iterator</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIterator()
	 * @generated
	 * @ordered
	 */
	protected VersionIterator iterator;

	/**
	 * The cached value of the '{@link #getAnalyzerNames() <em>Analyzer Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnalyzerNames()
	 * @generated
	 * @ordered
	 */
	protected EList<String> analyzerNames;

	/**
	 * The cached value of the '{@link #getExporter() <em>Exporter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExporter()
	 * @generated
	 * @ordered
	 */
	protected Exporter exporter;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected AnalyzerConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalyzerPackage.Literals.ANALYZER_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VersionIterator getIterator() {
		return iterator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIterator(VersionIterator newIterator, NotificationChain msgs) {
		VersionIterator oldIterator = iterator;
		iterator = newIterator;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR, oldIterator, newIterator);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setIterator(VersionIterator newIterator) {
		if (newIterator != iterator) {
			NotificationChain msgs = null;
			if (iterator != null)
				msgs = ((InternalEObject)iterator).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR, null, msgs);
			if (newIterator != null)
				msgs = ((InternalEObject)newIterator).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR, null, msgs);
			msgs = basicSetIterator(newIterator, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR, newIterator, newIterator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<String> getAnalyzerNames() {
		if (analyzerNames == null) {
			analyzerNames = new EDataTypeUniqueEList<String>(String.class, this, AnalyzerPackage.ANALYZER_CONFIGURATION__ANALYZER_NAMES);
		}
		return analyzerNames;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Exporter getExporter() {
		return exporter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExporter(Exporter newExporter, NotificationChain msgs) {
		Exporter oldExporter = exporter;
		exporter = newExporter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AnalyzerPackage.ANALYZER_CONFIGURATION__EXPORTER, oldExporter, newExporter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExporter(Exporter newExporter) {
		if (newExporter != exporter) {
			NotificationChain msgs = null;
			if (exporter != null)
				msgs = ((InternalEObject)exporter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AnalyzerPackage.ANALYZER_CONFIGURATION__EXPORTER, null, msgs);
			if (newExporter != null)
				msgs = ((InternalEObject)newExporter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AnalyzerPackage.ANALYZER_CONFIGURATION__EXPORTER, null, msgs);
			msgs = basicSetExporter(newExporter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.ANALYZER_CONFIGURATION__EXPORTER, newExporter, newExporter));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR:
				return basicSetIterator(null, msgs);
			case AnalyzerPackage.ANALYZER_CONFIGURATION__EXPORTER:
				return basicSetExporter(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR:
				return getIterator();
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ANALYZER_NAMES:
				return getAnalyzerNames();
			case AnalyzerPackage.ANALYZER_CONFIGURATION__EXPORTER:
				return getExporter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR:
				setIterator((VersionIterator)newValue);
				return;
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ANALYZER_NAMES:
				getAnalyzerNames().clear();
				getAnalyzerNames().addAll((Collection<? extends String>)newValue);
				return;
			case AnalyzerPackage.ANALYZER_CONFIGURATION__EXPORTER:
				setExporter((Exporter)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR:
				setIterator((VersionIterator)null);
				return;
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ANALYZER_NAMES:
				getAnalyzerNames().clear();
				return;
			case AnalyzerPackage.ANALYZER_CONFIGURATION__EXPORTER:
				setExporter((Exporter)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ITERATOR:
				return iterator != null;
			case AnalyzerPackage.ANALYZER_CONFIGURATION__ANALYZER_NAMES:
				return analyzerNames != null && !analyzerNames.isEmpty();
			case AnalyzerPackage.ANALYZER_CONFIGURATION__EXPORTER:
				return exporter != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (analyzerNames: ");
		result.append(analyzerNames);
		result.append(')');
		return result.toString();
	}

} // AnalyzerConfigurationImpl
