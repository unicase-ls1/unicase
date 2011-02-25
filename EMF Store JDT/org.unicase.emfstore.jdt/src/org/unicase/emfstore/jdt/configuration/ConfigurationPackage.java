/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.configuration;

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
 * 
 * @see org.unicase.emfstore.jdt.configuration.ConfigurationFactory
 * @model kind="package"
 * @generated
 */
public interface ConfigurationPackage extends EPackage {
	/**
	 * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "configuration";

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://emfstore.org/jdt";

	/**
	 * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.emfstore.jdt.configuration";

	/**
	 * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ConfigurationPackage eINSTANCE = org.unicase.emfstore.jdt.configuration.impl.ConfigurationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.jdt.configuration.impl.EMFStoreJDTConfigurationImpl
	 * <em>EMF Store JDT Configuration</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.jdt.configuration.impl.EMFStoreJDTConfigurationImpl
	 * @see org.unicase.emfstore.jdt.configuration.impl.ConfigurationPackageImpl#getEMFStoreJDTConfiguration()
	 * @generated
	 */
	int EMF_STORE_JDT_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Entry</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMF_STORE_JDT_CONFIGURATION__ENTRY = 0;

	/**
	 * The feature id for the '<em><b>Anyway Commit</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMF_STORE_JDT_CONFIGURATION__ANYWAY_COMMIT = 1;

	/**
	 * The number of structural features of the '<em>EMF Store JDT Configuration</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMF_STORE_JDT_CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.jdt.configuration.impl.EMFStoreLocationImpl
	 * <em>EMF Store Location</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.jdt.configuration.impl.EMFStoreLocationImpl
	 * @see org.unicase.emfstore.jdt.configuration.impl.ConfigurationPackageImpl#getEMFStoreLocation()
	 * @generated
	 */
	int EMF_STORE_LOCATION = 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMF_STORE_LOCATION__HOST = 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMF_STORE_LOCATION__PORT = 1;

	/**
	 * The feature id for the '<em><b>Certificate</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMF_STORE_LOCATION__CERTIFICATE = 2;

	/**
	 * The feature id for the '<em><b>Project ID</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMF_STORE_LOCATION__PROJECT_ID = 3;

	/**
	 * The number of structural features of the '<em>EMF Store Location</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EMF_STORE_LOCATION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.jdt.configuration.impl.EntryImpl <em>Entry</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.jdt.configuration.impl.EntryImpl
	 * @see org.unicase.emfstore.jdt.configuration.impl.ConfigurationPackageImpl#getEntry()
	 * @generated
	 */
	int ENTRY = 2;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' container reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTRY__CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Project Relative Location</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTRY__PROJECT_RELATIVE_LOCATION = 1;

	/**
	 * The feature id for the '<em><b>EObject Location</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTRY__EOBJECT_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Version Mapping</b></em>' containment reference. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTRY__VERSION_MAPPING = 3;

	/**
	 * The feature id for the '<em><b>Marked For Deletion</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTRY__MARKED_FOR_DELETION = 4;

	/**
	 * The number of structural features of the '<em>Entry</em>' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENTRY_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.jdt.configuration.impl.EObjectLocationImpl
	 * <em>EObject Location</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.jdt.configuration.impl.EObjectLocationImpl
	 * @see org.unicase.emfstore.jdt.configuration.impl.ConfigurationPackageImpl#getEObjectLocation()
	 * @generated
	 */
	int EOBJECT_LOCATION = 3;

	/**
	 * The feature id for the '<em><b>EMF Store Location</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EOBJECT_LOCATION__EMF_STORE_LOCATION = 0;

	/**
	 * The feature id for the '<em><b>EObject ID</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EOBJECT_LOCATION__EOBJECT_ID = 1;

	/**
	 * The number of structural features of the '<em>EObject Location</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EOBJECT_LOCATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.jdt.configuration.impl.VersionMappingImpl
	 * <em>Version Mapping</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.jdt.configuration.impl.VersionMappingImpl
	 * @see org.unicase.emfstore.jdt.configuration.impl.ConfigurationPackageImpl#getVersionMapping()
	 * @generated
	 */
	int VERSION_MAPPING = 4;

	/**
	 * The number of structural features of the '<em>Version Mapping</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_MAPPING_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.jdt.configuration.impl.HistoryVersionMappingImpl
	 * <em>History Version Mapping</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.jdt.configuration.impl.HistoryVersionMappingImpl
	 * @see org.unicase.emfstore.jdt.configuration.impl.ConfigurationPackageImpl#getHistoryVersionMapping()
	 * @generated
	 */
	int HISTORY_VERSION_MAPPING = 5;

	/**
	 * The feature id for the '<em><b>Hvm Entry</b></em>' containment reference list. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HISTORY_VERSION_MAPPING__HVM_ENTRY = VERSION_MAPPING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>History Version Mapping</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HISTORY_VERSION_MAPPING_FEATURE_COUNT = VERSION_MAPPING_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.jdt.configuration.impl.HistoryVersionMappingEntryImpl
	 * <em>History Version Mapping Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.jdt.configuration.impl.HistoryVersionMappingEntryImpl
	 * @see org.unicase.emfstore.jdt.configuration.impl.ConfigurationPackageImpl#getHistoryVersionMappingEntry()
	 * @generated
	 */
	int HISTORY_VERSION_MAPPING_ENTRY = 6;

	/**
	 * The feature id for the '<em><b>Team Provider Revision</b></em>' attribute. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HISTORY_VERSION_MAPPING_ENTRY__TEAM_PROVIDER_REVISION = 0;

	/**
	 * The feature id for the '<em><b>EMF Store Revision</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HISTORY_VERSION_MAPPING_ENTRY__EMF_STORE_REVISION = 1;

	/**
	 * The number of structural features of the '<em>History Version Mapping Entry</em>' class. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HISTORY_VERSION_MAPPING_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.jdt.configuration.impl.SimpleVersionMappingImpl
	 * <em>Simple Version Mapping</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.unicase.emfstore.jdt.configuration.impl.SimpleVersionMappingImpl
	 * @see org.unicase.emfstore.jdt.configuration.impl.ConfigurationPackageImpl#getSimpleVersionMapping()
	 * @generated
	 */
	int SIMPLE_VERSION_MAPPING = 7;

	/**
	 * The feature id for the '<em><b>EMF Store Revision</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMPLE_VERSION_MAPPING__EMF_STORE_REVISION = VERSION_MAPPING_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Simple Version Mapping</em>' class. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMPLE_VERSION_MAPPING_FEATURE_COUNT = VERSION_MAPPING_FEATURE_COUNT + 1;

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration
	 * <em>EMF Store JDT Configuration</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EMF Store JDT Configuration</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration
	 * @generated
	 */
	EClass getEMFStoreJDTConfiguration();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration#getEntry <em>Entry</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Entry</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration#getEntry()
	 * @see #getEMFStoreJDTConfiguration()
	 * @generated
	 */
	EReference getEMFStoreJDTConfiguration_Entry();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration#getAnywayCommit <em>Anyway Commit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Anyway Commit</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.EMFStoreJDTConfiguration#getAnywayCommit()
	 * @see #getEMFStoreJDTConfiguration()
	 * @generated
	 */
	EReference getEMFStoreJDTConfiguration_AnywayCommit();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.jdt.configuration.EMFStoreLocation
	 * <em>EMF Store Location</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EMF Store Location</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.EMFStoreLocation
	 * @generated
	 */
	EClass getEMFStoreLocation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.jdt.configuration.EMFStoreLocation#getHost <em>Host</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Host</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.EMFStoreLocation#getHost()
	 * @see #getEMFStoreLocation()
	 * @generated
	 */
	EAttribute getEMFStoreLocation_Host();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.jdt.configuration.EMFStoreLocation#getPort <em>Port</em>}'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.EMFStoreLocation#getPort()
	 * @see #getEMFStoreLocation()
	 * @generated
	 */
	EAttribute getEMFStoreLocation_Port();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.jdt.configuration.EMFStoreLocation#getCertificate <em>Certificate</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Certificate</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.EMFStoreLocation#getCertificate()
	 * @see #getEMFStoreLocation()
	 * @generated
	 */
	EAttribute getEMFStoreLocation_Certificate();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.jdt.configuration.EMFStoreLocation#getProjectID <em>Project ID</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Project ID</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.EMFStoreLocation#getProjectID()
	 * @see #getEMFStoreLocation()
	 * @generated
	 */
	EAttribute getEMFStoreLocation_ProjectID();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.jdt.configuration.Entry <em>Entry</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Entry</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.Entry
	 * @generated
	 */
	EClass getEntry();

	/**
	 * Returns the meta object for the container reference '
	 * {@link org.unicase.emfstore.jdt.configuration.Entry#getConfiguration <em>Configuration</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the container reference '<em>Configuration</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.Entry#getConfiguration()
	 * @see #getEntry()
	 * @generated
	 */
	EReference getEntry_Configuration();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.jdt.configuration.Entry#getProjectRelativeLocation
	 * <em>Project Relative Location</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Project Relative Location</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.Entry#getProjectRelativeLocation()
	 * @see #getEntry()
	 * @generated
	 */
	EAttribute getEntry_ProjectRelativeLocation();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.jdt.configuration.Entry#getEObjectLocation <em>EObject Location</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>EObject Location</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.Entry#getEObjectLocation()
	 * @see #getEntry()
	 * @generated
	 */
	EReference getEntry_EObjectLocation();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.emfstore.jdt.configuration.Entry#getVersionMapping <em>Version Mapping</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Version Mapping</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.Entry#getVersionMapping()
	 * @see #getEntry()
	 * @generated
	 */
	EReference getEntry_VersionMapping();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.jdt.configuration.Entry#isMarkedForDeletion <em>Marked For Deletion</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Marked For Deletion</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.Entry#isMarkedForDeletion()
	 * @see #getEntry()
	 * @generated
	 */
	EAttribute getEntry_MarkedForDeletion();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.jdt.configuration.EObjectLocation
	 * <em>EObject Location</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>EObject Location</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.EObjectLocation
	 * @generated
	 */
	EClass getEObjectLocation();

	/**
	 * Returns the meta object for the containment reference '
	 * {@link org.unicase.emfstore.jdt.configuration.EObjectLocation#getEMFStoreLocation <em>EMF Store Location</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>EMF Store Location</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.EObjectLocation#getEMFStoreLocation()
	 * @see #getEObjectLocation()
	 * @generated
	 */
	EReference getEObjectLocation_EMFStoreLocation();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.jdt.configuration.EObjectLocation#getEObjectID <em>EObject ID</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>EObject ID</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.EObjectLocation#getEObjectID()
	 * @see #getEObjectLocation()
	 * @generated
	 */
	EAttribute getEObjectLocation_EObjectID();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.jdt.configuration.VersionMapping
	 * <em>Version Mapping</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Version Mapping</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.VersionMapping
	 * @generated
	 */
	EClass getVersionMapping();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.jdt.configuration.HistoryVersionMapping
	 * <em>History Version Mapping</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>History Version Mapping</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.HistoryVersionMapping
	 * @generated
	 */
	EClass getHistoryVersionMapping();

	/**
	 * Returns the meta object for the containment reference list '
	 * {@link org.unicase.emfstore.jdt.configuration.HistoryVersionMapping#getHvmEntry <em>Hvm Entry</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Hvm Entry</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.HistoryVersionMapping#getHvmEntry()
	 * @see #getHistoryVersionMapping()
	 * @generated
	 */
	EReference getHistoryVersionMapping_HvmEntry();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry
	 * <em>History Version Mapping Entry</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>History Version Mapping Entry</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry
	 * @generated
	 */
	EClass getHistoryVersionMappingEntry();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry#getTeamProviderRevision
	 * <em>Team Provider Revision</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Team Provider Revision</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry#getTeamProviderRevision()
	 * @see #getHistoryVersionMappingEntry()
	 * @generated
	 */
	EAttribute getHistoryVersionMappingEntry_TeamProviderRevision();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry#getEMFStoreRevision
	 * <em>EMF Store Revision</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>EMF Store Revision</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.HistoryVersionMappingEntry#getEMFStoreRevision()
	 * @see #getHistoryVersionMappingEntry()
	 * @generated
	 */
	EAttribute getHistoryVersionMappingEntry_EMFStoreRevision();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.jdt.configuration.SimpleVersionMapping
	 * <em>Simple Version Mapping</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Simple Version Mapping</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.SimpleVersionMapping
	 * @generated
	 */
	EClass getSimpleVersionMapping();

	/**
	 * Returns the meta object for the attribute '
	 * {@link org.unicase.emfstore.jdt.configuration.SimpleVersionMapping#getEMFStoreRevision
	 * <em>EMF Store Revision</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>EMF Store Revision</em>'.
	 * @see org.unicase.emfstore.jdt.configuration.SimpleVersionMapping#getEMFStoreRevision()
	 * @see #getSimpleVersionMapping()
	 * @generated
	 */
	EAttribute getSimpleVersionMapping_EMFStoreRevision();

	/**
	 * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConfigurationFactory getConfigurationFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.jdt.configuration.impl.EMFStoreJDTConfigurationImpl
		 * <em>EMF Store JDT Configuration</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.jdt.configuration.impl.EMFStoreJDTConfigurationImpl
		 * @see org.unicase.emfstore.jdt.configuration.impl.ConfigurationPackageImpl#getEMFStoreJDTConfiguration()
		 * @generated
		 */
		EClass EMF_STORE_JDT_CONFIGURATION = eINSTANCE.getEMFStoreJDTConfiguration();

		/**
		 * The meta object literal for the '<em><b>Entry</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EMF_STORE_JDT_CONFIGURATION__ENTRY = eINSTANCE.getEMFStoreJDTConfiguration_Entry();

		/**
		 * The meta object literal for the '<em><b>Anyway Commit</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EMF_STORE_JDT_CONFIGURATION__ANYWAY_COMMIT = eINSTANCE.getEMFStoreJDTConfiguration_AnywayCommit();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.jdt.configuration.impl.EMFStoreLocationImpl
		 * <em>EMF Store Location</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.jdt.configuration.impl.EMFStoreLocationImpl
		 * @see org.unicase.emfstore.jdt.configuration.impl.ConfigurationPackageImpl#getEMFStoreLocation()
		 * @generated
		 */
		EClass EMF_STORE_LOCATION = eINSTANCE.getEMFStoreLocation();

		/**
		 * The meta object literal for the '<em><b>Host</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EMF_STORE_LOCATION__HOST = eINSTANCE.getEMFStoreLocation_Host();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EMF_STORE_LOCATION__PORT = eINSTANCE.getEMFStoreLocation_Port();

		/**
		 * The meta object literal for the '<em><b>Certificate</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EMF_STORE_LOCATION__CERTIFICATE = eINSTANCE.getEMFStoreLocation_Certificate();

		/**
		 * The meta object literal for the '<em><b>Project ID</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EMF_STORE_LOCATION__PROJECT_ID = eINSTANCE.getEMFStoreLocation_ProjectID();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.jdt.configuration.impl.EntryImpl <em>Entry</em>}
		 * ' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.jdt.configuration.impl.EntryImpl
		 * @see org.unicase.emfstore.jdt.configuration.impl.ConfigurationPackageImpl#getEntry()
		 * @generated
		 */
		EClass ENTRY = eINSTANCE.getEntry();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' container reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENTRY__CONFIGURATION = eINSTANCE.getEntry_Configuration();

		/**
		 * The meta object literal for the '<em><b>Project Relative Location</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENTRY__PROJECT_RELATIVE_LOCATION = eINSTANCE.getEntry_ProjectRelativeLocation();

		/**
		 * The meta object literal for the '<em><b>EObject Location</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENTRY__EOBJECT_LOCATION = eINSTANCE.getEntry_EObjectLocation();

		/**
		 * The meta object literal for the '<em><b>Version Mapping</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ENTRY__VERSION_MAPPING = eINSTANCE.getEntry_VersionMapping();

		/**
		 * The meta object literal for the '<em><b>Marked For Deletion</b></em>' attribute feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENTRY__MARKED_FOR_DELETION = eINSTANCE.getEntry_MarkedForDeletion();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.jdt.configuration.impl.EObjectLocationImpl
		 * <em>EObject Location</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.jdt.configuration.impl.EObjectLocationImpl
		 * @see org.unicase.emfstore.jdt.configuration.impl.ConfigurationPackageImpl#getEObjectLocation()
		 * @generated
		 */
		EClass EOBJECT_LOCATION = eINSTANCE.getEObjectLocation();

		/**
		 * The meta object literal for the '<em><b>EMF Store Location</b></em>' containment reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EOBJECT_LOCATION__EMF_STORE_LOCATION = eINSTANCE.getEObjectLocation_EMFStoreLocation();

		/**
		 * The meta object literal for the '<em><b>EObject ID</b></em>' attribute feature. <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EOBJECT_LOCATION__EOBJECT_ID = eINSTANCE.getEObjectLocation_EObjectID();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.jdt.configuration.impl.VersionMappingImpl
		 * <em>Version Mapping</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.jdt.configuration.impl.VersionMappingImpl
		 * @see org.unicase.emfstore.jdt.configuration.impl.ConfigurationPackageImpl#getVersionMapping()
		 * @generated
		 */
		EClass VERSION_MAPPING = eINSTANCE.getVersionMapping();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.jdt.configuration.impl.HistoryVersionMappingImpl
		 * <em>History Version Mapping</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.jdt.configuration.impl.HistoryVersionMappingImpl
		 * @see org.unicase.emfstore.jdt.configuration.impl.ConfigurationPackageImpl#getHistoryVersionMapping()
		 * @generated
		 */
		EClass HISTORY_VERSION_MAPPING = eINSTANCE.getHistoryVersionMapping();

		/**
		 * The meta object literal for the '<em><b>Hvm Entry</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference HISTORY_VERSION_MAPPING__HVM_ENTRY = eINSTANCE.getHistoryVersionMapping_HvmEntry();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.jdt.configuration.impl.HistoryVersionMappingEntryImpl
		 * <em>History Version Mapping Entry</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.jdt.configuration.impl.HistoryVersionMappingEntryImpl
		 * @see org.unicase.emfstore.jdt.configuration.impl.ConfigurationPackageImpl#getHistoryVersionMappingEntry()
		 * @generated
		 */
		EClass HISTORY_VERSION_MAPPING_ENTRY = eINSTANCE.getHistoryVersionMappingEntry();

		/**
		 * The meta object literal for the '<em><b>Team Provider Revision</b></em>' attribute feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute HISTORY_VERSION_MAPPING_ENTRY__TEAM_PROVIDER_REVISION = eINSTANCE
			.getHistoryVersionMappingEntry_TeamProviderRevision();

		/**
		 * The meta object literal for the '<em><b>EMF Store Revision</b></em>' attribute feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute HISTORY_VERSION_MAPPING_ENTRY__EMF_STORE_REVISION = eINSTANCE
			.getHistoryVersionMappingEntry_EMFStoreRevision();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.jdt.configuration.impl.SimpleVersionMappingImpl
		 * <em>Simple Version Mapping</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.unicase.emfstore.jdt.configuration.impl.SimpleVersionMappingImpl
		 * @see org.unicase.emfstore.jdt.configuration.impl.ConfigurationPackageImpl#getSimpleVersionMapping()
		 * @generated
		 */
		EClass SIMPLE_VERSION_MAPPING = eINSTANCE.getSimpleVersionMapping();

		/**
		 * The meta object literal for the '<em><b>EMF Store Revision</b></em>' attribute feature. <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SIMPLE_VERSION_MAPPING__EMF_STORE_REVISION = eINSTANCE.getSimpleVersionMapping_EMFStoreRevision();

	}

} // ConfigurationPackage
