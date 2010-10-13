/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.esmodel.versioning.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.DateVersionSpec;
import org.unicase.emfstore.esmodel.versioning.HeadVersionSpec;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.Version;
import org.unicase.emfstore.esmodel.versioning.VersionProperty;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.VersioningPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class VersioningFactoryImpl extends EFactoryImpl implements VersioningFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static VersioningFactory init() {
		try {
			VersioningFactory theVersioningFactory = (VersioningFactory)EPackage.Registry.INSTANCE.getEFactory("http://unicase.org/esmodel/versioning"); 
			if (theVersioningFactory != null) {
				return theVersioningFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new VersioningFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VersioningFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case VersioningPackage.TAG_VERSION_SPEC: return createTagVersionSpec();
			case VersioningPackage.DATE_VERSION_SPEC: return createDateVersionSpec();
			case VersioningPackage.PRIMARY_VERSION_SPEC: return createPrimaryVersionSpec();
			case VersioningPackage.LOG_MESSAGE: return createLogMessage();
			case VersioningPackage.CHANGE_PACKAGE: return createChangePackage();
			case VersioningPackage.HISTORY_INFO: return createHistoryInfo();
			case VersioningPackage.HISTORY_QUERY: return createHistoryQuery();
			case VersioningPackage.VERSION: return createVersion();
			case VersioningPackage.HEAD_VERSION_SPEC: return createHeadVersionSpec();
			case VersioningPackage.VERSION_PROPERTY: return createVersionProperty();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TagVersionSpec createTagVersionSpec() {
		TagVersionSpecImpl tagVersionSpec = new TagVersionSpecImpl();
		return tagVersionSpec;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DateVersionSpec createDateVersionSpec() {
		DateVersionSpecImpl dateVersionSpec = new DateVersionSpecImpl();
		return dateVersionSpec;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PrimaryVersionSpec createPrimaryVersionSpec() {
		PrimaryVersionSpecImpl primaryVersionSpec = new PrimaryVersionSpecImpl();
		return primaryVersionSpec;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public LogMessage createLogMessage() {
		LogMessageImpl logMessage = new LogMessageImpl();
		return logMessage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ChangePackage createChangePackage() {
		ChangePackageImpl changePackage = new ChangePackageImpl();
		return changePackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HistoryInfo createHistoryInfo() {
		HistoryInfoImpl historyInfo = new HistoryInfoImpl();
		return historyInfo;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HistoryQuery createHistoryQuery() {
		HistoryQueryImpl historyQuery = new HistoryQueryImpl();
		return historyQuery;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Version createVersion() {
		VersionImpl version = new VersionImpl();
		return version;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public HeadVersionSpec createHeadVersionSpec() {
		HeadVersionSpecImpl headVersionSpec = new HeadVersionSpecImpl();
		return headVersionSpec;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VersionProperty createVersionProperty() {
		VersionPropertyImpl versionProperty = new VersionPropertyImpl();
		return versionProperty;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public VersioningPackage getVersioningPackage() {
		return (VersioningPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static VersioningPackage getPackage() {
		return VersioningPackage.eINSTANCE;
	}

} // VersioningFactoryImpl
