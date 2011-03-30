/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.server.model.versioning;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.emfstore.server.model.versioning.VersioningFactory
 * @model kind="package"
 * @generated
 */
public interface VersioningPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "versioning";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/emf/emfstore/server/model/versioning";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.emf.emfstore.server.model.versioning";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	VersioningPackage eINSTANCE = org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.versioning.VersionSpec <em>Version Spec</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.versioning.VersionSpec
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getVersionSpec()
	 * @generated
	 */
	int VERSION_SPEC = 3;

	/**
	 * The number of structural features of the '<em>Version Spec</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_SPEC_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.TagVersionSpecImpl <em>Tag Version Spec</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.TagVersionSpecImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getTagVersionSpec()
	 * @generated
	 */
	int TAG_VERSION_SPEC = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_VERSION_SPEC__NAME = VERSION_SPEC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tag Version Spec</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_VERSION_SPEC_FEATURE_COUNT = VERSION_SPEC_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.DateVersionSpecImpl <em>Date Version Spec</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.DateVersionSpecImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getDateVersionSpec()
	 * @generated
	 */
	int DATE_VERSION_SPEC = 1;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_VERSION_SPEC__DATE = VERSION_SPEC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Date Version Spec</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_VERSION_SPEC_FEATURE_COUNT = VERSION_SPEC_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.PrimaryVersionSpecImpl <em>Primary Version Spec</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.PrimaryVersionSpecImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getPrimaryVersionSpec()
	 * @generated
	 */
	int PRIMARY_VERSION_SPEC = 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_VERSION_SPEC__IDENTIFIER = VERSION_SPEC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primary Version Spec</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_VERSION_SPEC_FEATURE_COUNT = VERSION_SPEC_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.LogMessageImpl <em>Log Message</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.LogMessageImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getLogMessage()
	 * @generated
	 */
	int LOG_MESSAGE = 4;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE__AUTHOR = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE__MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE__DATE = 2;

	/**
	 * The feature id for the '<em><b>Client Date</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE__CLIENT_DATE = 3;

	/**
	 * The number of structural features of the '<em>Log Message</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.ChangePackageImpl <em>Change Package</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.ChangePackageImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getChangePackage()
	 * @generated
	 */
	int CHANGE_PACKAGE = 5;

	/**
	 * The feature id for the '<em><b>Operations</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PACKAGE__OPERATIONS = 0;

	/**
	 * The feature id for the '<em><b>Events</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PACKAGE__EVENTS = 1;

	/**
	 * The feature id for the '<em><b>Log Message</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PACKAGE__LOG_MESSAGE = 2;

	/**
	 * The feature id for the '<em><b>Notifications</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PACKAGE__NOTIFICATIONS = 3;

	/**
	 * The feature id for the '<em><b>Version Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PACKAGE__VERSION_PROPERTIES = 4;

	/**
	 * The number of structural features of the '<em>Change Package</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PACKAGE_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.HistoryInfoImpl <em>History Info</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.HistoryInfoImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getHistoryInfo()
	 * @generated
	 */
	int HISTORY_INFO = 6;

	/**
	 * The feature id for the '<em><b>Primery Spec</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_INFO__PRIMERY_SPEC = 0;

	/**
	 * The feature id for the '<em><b>Log Message</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_INFO__LOG_MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Tag Specs</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_INFO__TAG_SPECS = 2;

	/**
	 * The feature id for the '<em><b>Version Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_INFO__VERSION_PROPERTIES = 3;

	/**
	 * The feature id for the '<em><b>Change Package</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_INFO__CHANGE_PACKAGE = 4;

	/**
	 * The number of structural features of the '<em>History Info</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HISTORY_INFO_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.HistoryQueryImpl <em>History Query</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.HistoryQueryImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getHistoryQuery()
	 * @generated
	 */
	int HISTORY_QUERY = 7;

	/**
	 * The feature id for the '<em><b>Source</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HISTORY_QUERY__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HISTORY_QUERY__TARGET = 1;

	/**
	 * The feature id for the '<em><b>Model Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_QUERY__MODEL_ELEMENTS = 2;

	/**
	 * The feature id for the '<em><b>Include Change Package</b></em>' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_QUERY__INCLUDE_CHANGE_PACKAGE = 3;

	/**
	 * The number of structural features of the '<em>History Query</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_QUERY_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.VersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersionImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getVersion()
	 * @generated
	 */
	int VERSION = 8;

	/**
	 * The feature id for the '<em><b>Project State</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__PROJECT_STATE = 0;

	/**
	 * The feature id for the '<em><b>Primary Spec</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__PRIMARY_SPEC = 1;

	/**
	 * The feature id for the '<em><b>Tag Specs</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__TAG_SPECS = 2;

	/**
	 * The feature id for the '<em><b>Next Version</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__NEXT_VERSION = 3;

	/**
	 * The feature id for the '<em><b>Previous Version</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION__PREVIOUS_VERSION = 4;

	/**
	 * The feature id for the '<em><b>Changes</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION__CHANGES = 5;

	/**
	 * The feature id for the '<em><b>Log Message</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__LOG_MESSAGE = 6;

	/**
	 * The number of structural features of the '<em>Version</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.HeadVersionSpecImpl <em>Head Version Spec</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.HeadVersionSpecImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getHeadVersionSpec()
	 * @generated
	 */
	int HEAD_VERSION_SPEC = 9;

	/**
	 * The number of structural features of the '<em>Head Version Spec</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAD_VERSION_SPEC_FEATURE_COUNT = VERSION_SPEC_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.VersionPropertyImpl <em>Version Property</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersionPropertyImpl
	 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getVersionProperty()
	 * @generated
	 */
	int VERSION_PROPERTY = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_PROPERTY__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_PROPERTY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Version Property</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_PROPERTY_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec <em>Tag Version Spec</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag Version Spec</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec
	 * @generated
	 */
	EClass getTagVersionSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.TagVersionSpec#getName()
	 * @see #getTagVersionSpec()
	 * @generated
	 */
	EAttribute getTagVersionSpec_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.versioning.DateVersionSpec <em>Date Version Spec</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Date Version Spec</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.DateVersionSpec
	 * @generated
	 */
	EClass getDateVersionSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.versioning.DateVersionSpec#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.DateVersionSpec#getDate()
	 * @see #getDateVersionSpec()
	 * @generated
	 */
	EAttribute getDateVersionSpec_Date();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec <em>Primary Version Spec</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primary Version Spec</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec
	 * @generated
	 */
	EClass getPrimaryVersionSpec();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec#getIdentifier <em>Identifier</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.PrimaryVersionSpec#getIdentifier()
	 * @see #getPrimaryVersionSpec()
	 * @generated
	 */
	EAttribute getPrimaryVersionSpec_Identifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.versioning.VersionSpec <em>Version Spec</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version Spec</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.VersionSpec
	 * @generated
	 */
	EClass getVersionSpec();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.versioning.LogMessage <em>Log Message</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Log Message</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.LogMessage
	 * @generated
	 */
	EClass getLogMessage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.versioning.LogMessage#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.LogMessage#getMessage()
	 * @see #getLogMessage()
	 * @generated
	 */
	EAttribute getLogMessage_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.versioning.LogMessage#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.LogMessage#getDate()
	 * @see #getLogMessage()
	 * @generated
	 */
	EAttribute getLogMessage_Date();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.LogMessage#getClientDate <em>Client Date</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Client Date</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.LogMessage#getClientDate()
	 * @see #getLogMessage()
	 * @generated
	 */
	EAttribute getLogMessage_ClientDate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.versioning.LogMessage#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.LogMessage#getAuthor()
	 * @see #getLogMessage()
	 * @generated
	 */
	EAttribute getLogMessage_Author();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.versioning.ChangePackage <em>Change Package</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Package</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.ChangePackage
	 * @generated
	 */
	EClass getChangePackage();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.ChangePackage#getOperations <em>Operations</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Operations</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.ChangePackage#getOperations()
	 * @see #getChangePackage()
	 * @generated
	 */
	EReference getChangePackage_Operations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.server.model.versioning.ChangePackage#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Events</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.ChangePackage#getEvents()
	 * @see #getChangePackage()
	 * @generated
	 */
	EReference getChangePackage_Events();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.ChangePackage#getLogMessage <em>Log Message</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Log Message</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.ChangePackage#getLogMessage()
	 * @see #getChangePackage()
	 * @generated
	 */
	EReference getChangePackage_LogMessage();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.ChangePackage#getNotifications <em>Notifications</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Notifications</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.ChangePackage#getNotifications()
	 * @see #getChangePackage()
	 * @generated
	 */
	EReference getChangePackage_Notifications();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.server.model.versioning.ChangePackage#getVersionProperties <em>Version Properties</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Version Properties</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.ChangePackage#getVersionProperties()
	 * @see #getChangePackage()
	 * @generated
	 */
	EReference getChangePackage_VersionProperties();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo <em>History Info</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>History Info</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo
	 * @generated
	 */
	EClass getHistoryInfo();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo#getPrimerySpec <em>Primery Spec</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Primery Spec</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo#getPrimerySpec()
	 * @see #getHistoryInfo()
	 * @generated
	 */
	EReference getHistoryInfo_PrimerySpec();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo#getLogMessage <em>Log Message</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Log Message</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo#getLogMessage()
	 * @see #getHistoryInfo()
	 * @generated
	 */
	EReference getHistoryInfo_LogMessage();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo#getTagSpecs <em>Tag Specs</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tag Specs</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo#getTagSpecs()
	 * @see #getHistoryInfo()
	 * @generated
	 */
	EReference getHistoryInfo_TagSpecs();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo#getVersionProperties <em>Version Properties</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Version Properties</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo#getVersionProperties()
	 * @see #getHistoryInfo()
	 * @generated
	 */
	EReference getHistoryInfo_VersionProperties();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo#getChangePackage <em>Change Package</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Change Package</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.HistoryInfo#getChangePackage()
	 * @see #getHistoryInfo()
	 * @generated
	 */
	EReference getHistoryInfo_ChangePackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery <em>History Query</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>History Query</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery
	 * @generated
	 */
	EClass getHistoryQuery();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Source</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery#getSource()
	 * @see #getHistoryQuery()
	 * @generated
	 */
	EReference getHistoryQuery_Source();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery#getTarget()
	 * @see #getHistoryQuery()
	 * @generated
	 */
	EReference getHistoryQuery_Target();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery#getModelElements <em>Model Elements</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Model Elements</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery#getModelElements()
	 * @see #getHistoryQuery()
	 * @generated
	 */
	EReference getHistoryQuery_ModelElements();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery#isIncludeChangePackage <em>Include Change Package</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Include Change Package</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.HistoryQuery#isIncludeChangePackage()
	 * @see #getHistoryQuery()
	 * @generated
	 */
	EAttribute getHistoryQuery_IncludeChangePackage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.versioning.Version <em>Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.Version
	 * @generated
	 */
	EClass getVersion();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.Version#getProjectState <em>Project State</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Project State</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.Version#getProjectState()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_ProjectState();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.Version#getPrimarySpec <em>Primary Spec</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Primary Spec</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.Version#getPrimarySpec()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_PrimarySpec();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.emfstore.server.model.versioning.Version#getTagSpecs <em>Tag Specs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tag Specs</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.Version#getTagSpecs()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_TagSpecs();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.emfstore.server.model.versioning.Version#getNextVersion <em>Next Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Version</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.Version#getNextVersion()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_NextVersion();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.eclipse.emf.emfstore.server.model.versioning.Version#getPreviousVersion <em>Previous Version</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Previous Version</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.Version#getPreviousVersion()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_PreviousVersion();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.versioning.Version#getChanges <em>Changes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Changes</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.Version#getChanges()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_Changes();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.emfstore.server.model.versioning.Version#getLogMessage <em>Log Message</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Log Message</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.Version#getLogMessage()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_LogMessage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.versioning.HeadVersionSpec <em>Head Version Spec</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Head Version Spec</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.HeadVersionSpec
	 * @generated
	 */
	EClass getHeadVersionSpec();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.emfstore.server.model.versioning.VersionProperty <em>Version Property</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version Property</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.VersionProperty
	 * @generated
	 */
	EClass getVersionProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.versioning.VersionProperty#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.VersionProperty#getName()
	 * @see #getVersionProperty()
	 * @generated
	 */
	EAttribute getVersionProperty_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.emfstore.server.model.versioning.VersionProperty#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.emf.emfstore.server.model.versioning.VersionProperty#getValue()
	 * @see #getVersionProperty()
	 * @generated
	 */
	EAttribute getVersionProperty_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VersioningFactory getVersioningFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.TagVersionSpecImpl <em>Tag Version Spec</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.TagVersionSpecImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getTagVersionSpec()
		 * @generated
		 */
		EClass TAG_VERSION_SPEC = eINSTANCE.getTagVersionSpec();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute TAG_VERSION_SPEC__NAME = eINSTANCE.getTagVersionSpec_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.DateVersionSpecImpl <em>Date Version Spec</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.DateVersionSpecImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getDateVersionSpec()
		 * @generated
		 */
		EClass DATE_VERSION_SPEC = eINSTANCE.getDateVersionSpec();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute DATE_VERSION_SPEC__DATE = eINSTANCE.getDateVersionSpec_Date();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.PrimaryVersionSpecImpl <em>Primary Version Spec</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.PrimaryVersionSpecImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getPrimaryVersionSpec()
		 * @generated
		 */
		EClass PRIMARY_VERSION_SPEC = eINSTANCE.getPrimaryVersionSpec();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMARY_VERSION_SPEC__IDENTIFIER = eINSTANCE.getPrimaryVersionSpec_Identifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.versioning.VersionSpec <em>Version Spec</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.versioning.VersionSpec
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getVersionSpec()
		 * @generated
		 */
		EClass VERSION_SPEC = eINSTANCE.getVersionSpec();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.LogMessageImpl <em>Log Message</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.LogMessageImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getLogMessage()
		 * @generated
		 */
		EClass LOG_MESSAGE = eINSTANCE.getLogMessage();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_MESSAGE__MESSAGE = eINSTANCE.getLogMessage_Message();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_MESSAGE__DATE = eINSTANCE.getLogMessage_Date();

		/**
		 * The meta object literal for the '<em><b>Client Date</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_MESSAGE__CLIENT_DATE = eINSTANCE.getLogMessage_ClientDate();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_MESSAGE__AUTHOR = eINSTANCE.getLogMessage_Author();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.ChangePackageImpl <em>Change Package</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.ChangePackageImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getChangePackage()
		 * @generated
		 */
		EClass CHANGE_PACKAGE = eINSTANCE.getChangePackage();

		/**
		 * The meta object literal for the '<em><b>Operations</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CHANGE_PACKAGE__OPERATIONS = eINSTANCE.getChangePackage_Operations();

		/**
		 * The meta object literal for the '<em><b>Events</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CHANGE_PACKAGE__EVENTS = eINSTANCE.getChangePackage_Events();

		/**
		 * The meta object literal for the '<em><b>Log Message</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CHANGE_PACKAGE__LOG_MESSAGE = eINSTANCE.getChangePackage_LogMessage();

		/**
		 * The meta object literal for the '<em><b>Notifications</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CHANGE_PACKAGE__NOTIFICATIONS = eINSTANCE.getChangePackage_Notifications();

		/**
		 * The meta object literal for the '<em><b>Version Properties</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CHANGE_PACKAGE__VERSION_PROPERTIES = eINSTANCE.getChangePackage_VersionProperties();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.HistoryInfoImpl <em>History Info</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.HistoryInfoImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getHistoryInfo()
		 * @generated
		 */
		EClass HISTORY_INFO = eINSTANCE.getHistoryInfo();

		/**
		 * The meta object literal for the '<em><b>Primery Spec</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HISTORY_INFO__PRIMERY_SPEC = eINSTANCE.getHistoryInfo_PrimerySpec();

		/**
		 * The meta object literal for the '<em><b>Log Message</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HISTORY_INFO__LOG_MESSAGE = eINSTANCE.getHistoryInfo_LogMessage();

		/**
		 * The meta object literal for the '<em><b>Tag Specs</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HISTORY_INFO__TAG_SPECS = eINSTANCE.getHistoryInfo_TagSpecs();

		/**
		 * The meta object literal for the '<em><b>Version Properties</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HISTORY_INFO__VERSION_PROPERTIES = eINSTANCE.getHistoryInfo_VersionProperties();

		/**
		 * The meta object literal for the '<em><b>Change Package</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HISTORY_INFO__CHANGE_PACKAGE = eINSTANCE.getHistoryInfo_ChangePackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.HistoryQueryImpl <em>History Query</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.HistoryQueryImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getHistoryQuery()
		 * @generated
		 */
		EClass HISTORY_QUERY = eINSTANCE.getHistoryQuery();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY_QUERY__SOURCE = eINSTANCE.getHistoryQuery_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY_QUERY__TARGET = eINSTANCE.getHistoryQuery_Target();

		/**
		 * The meta object literal for the '<em><b>Model Elements</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HISTORY_QUERY__MODEL_ELEMENTS = eINSTANCE.getHistoryQuery_ModelElements();

		/**
		 * The meta object literal for the '<em><b>Include Change Package</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute HISTORY_QUERY__INCLUDE_CHANGE_PACKAGE = eINSTANCE.getHistoryQuery_IncludeChangePackage();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.VersionImpl <em>Version</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersionImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getVersion()
		 * @generated
		 */
		EClass VERSION = eINSTANCE.getVersion();

		/**
		 * The meta object literal for the '<em><b>Project State</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VERSION__PROJECT_STATE = eINSTANCE.getVersion_ProjectState();

		/**
		 * The meta object literal for the '<em><b>Primary Spec</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VERSION__PRIMARY_SPEC = eINSTANCE.getVersion_PrimarySpec();

		/**
		 * The meta object literal for the '<em><b>Tag Specs</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VERSION__TAG_SPECS = eINSTANCE.getVersion_TagSpecs();

		/**
		 * The meta object literal for the '<em><b>Next Version</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__NEXT_VERSION = eINSTANCE.getVersion_NextVersion();

		/**
		 * The meta object literal for the '<em><b>Previous Version</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__PREVIOUS_VERSION = eINSTANCE.getVersion_PreviousVersion();

		/**
		 * The meta object literal for the '<em><b>Changes</b></em>' containment reference feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__CHANGES = eINSTANCE.getVersion_Changes();

		/**
		 * The meta object literal for the '<em><b>Log Message</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VERSION__LOG_MESSAGE = eINSTANCE.getVersion_LogMessage();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.HeadVersionSpecImpl <em>Head Version Spec</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.HeadVersionSpecImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getHeadVersionSpec()
		 * @generated
		 */
		EClass HEAD_VERSION_SPEC = eINSTANCE.getHeadVersionSpec();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.emfstore.server.model.versioning.impl.VersionPropertyImpl <em>Version Property</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersionPropertyImpl
		 * @see org.eclipse.emf.emfstore.server.model.versioning.impl.VersioningPackageImpl#getVersionProperty()
		 * @generated
		 */
		EClass VERSION_PROPERTY = eINSTANCE.getVersionProperty();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION_PROPERTY__NAME = eINSTANCE.getVersionProperty_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute VERSION_PROPERTY__VALUE = eINSTANCE.getVersionProperty_Value();

	}

} // VersioningPackage
