/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.analyzer.iterator.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.analyzer.iterator.IteratorFactory;
import org.unicase.analyzer.iterator.IteratorPackage;
import org.unicase.analyzer.iterator.TimeIterator;
import org.unicase.analyzer.iterator.VersionIterator;
import org.unicase.analyzer.iterator.VersionSpecQuery;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class IteratorFactoryImpl extends EFactoryImpl implements IteratorFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static IteratorFactory init() {
		try {
			IteratorFactory theIteratorFactory = (IteratorFactory)EPackage.Registry.INSTANCE.getEFactory("http://unicase.org/analyzer/iterator"); 
			if (theIteratorFactory != null) {
				return theIteratorFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new IteratorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IteratorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case IteratorPackage.VERSION_ITERATOR: return createVersionIterator();
			case IteratorPackage.TIME_ITERATOR: return createTimeIterator();
			case IteratorPackage.VERSION_SPEC_QUERY: return createVersionSpecQuery();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VersionIterator createVersionIterator() {
		VersionIteratorImpl versionIterator = new VersionIteratorImpl();
		return versionIterator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TimeIterator createTimeIterator() {
		TimeIteratorImpl timeIterator = new TimeIteratorImpl();
		return timeIterator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VersionSpecQuery createVersionSpecQuery() {
		VersionSpecQueryImpl versionSpecQuery = new VersionSpecQueryImpl();
		return versionSpecQuery;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IteratorPackage getIteratorPackage() {
		return (IteratorPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static IteratorPackage getPackage() {
		return IteratorPackage.eINSTANCE;
	}

} // IteratorFactoryImpl
