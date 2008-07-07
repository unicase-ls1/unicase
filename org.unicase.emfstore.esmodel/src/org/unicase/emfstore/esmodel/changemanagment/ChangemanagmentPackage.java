/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.emfstore.esmodel.changemanagment;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.emfstore.esmodel.changemanagment.ChangemanagmentFactory
 * @model kind="package"
 * @generated
 */
public interface ChangemanagmentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "changemanagment";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/esmodel/changemanagment";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.emfstore.esmodel.changemanagment";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	ChangemanagmentPackage eINSTANCE = org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.changemanagment.impl.TagVersionSpecImpl <em>Tag Version Spec</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.changemanagment.impl.TagVersionSpecImpl
	 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getTagVersionSpec()
	 * @generated
	 */
	int TAG_VERSION_SPEC = 0;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.changemanagment.impl.DateVersionSpecImpl <em>Date Version Spec</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.changemanagment.impl.DateVersionSpecImpl
	 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getDateVersionSpec()
	 * @generated
	 */
	int DATE_VERSION_SPEC = 1;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.changemanagment.impl.PrimaryVersionSpecImpl <em>Primary Version Spec</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.changemanagment.impl.PrimaryVersionSpecImpl
	 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getPrimaryVersionSpec()
	 * @generated
	 */
	int PRIMARY_VERSION_SPEC = 2;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.emfstore.esmodel.changemanagment.VersionSpec
	 * <em>Version Spec</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.unicase.emfstore.esmodel.changemanagment.VersionSpec
	 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getVersionSpec()
	 * @generated
	 */
	int VERSION_SPEC = 3;

	/**
	 * The number of structural features of the '<em>Version Spec</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION_SPEC_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TAG_VERSION_SPEC__NAME = VERSION_SPEC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Tag Version Spec</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_VERSION_SPEC_FEATURE_COUNT = VERSION_SPEC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATE_VERSION_SPEC__DATE = VERSION_SPEC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Date Version Spec</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATE_VERSION_SPEC_FEATURE_COUNT = VERSION_SPEC_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIMARY_VERSION_SPEC__IDENTIFIER = VERSION_SPEC_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primary Version Spec</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMARY_VERSION_SPEC_FEATURE_COUNT = VERSION_SPEC_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.emfstore.esmodel.changemanagment.impl.LogMessageImpl
	 * <em>Log Message</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.unicase.emfstore.esmodel.changemanagment.impl.LogMessageImpl
	 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getLogMessage()
	 * @generated
	 */
	int LOG_MESSAGE = 4;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE__MESSAGE = 0;

	/**
	 * The feature id for the '<em><b>Date</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE__DATE = 1;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE__AUTHOR = 2;

	/**
	 * The number of structural features of the '<em>Log Message</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_MESSAGE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.changemanagment.impl.ChangePackageImpl <em>Change Package</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangePackageImpl
	 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getChangePackage()
	 * @generated
	 */
	int CHANGE_PACKAGE = 5;

	/**
	 * The feature id for the '<em><b>Foward Delta</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PACKAGE__FOWARD_DELTA = 0;

	/**
	 * The feature id for the '<em><b>Backward Delta</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PACKAGE__BACKWARD_DELTA = 1;

	/**
	 * The feature id for the '<em><b>Project State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PACKAGE__PROJECT_STATE = 2;

	/**
	 * The number of structural features of the '<em>Change Package</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHANGE_PACKAGE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '
	 * {@link org.unicase.emfstore.esmodel.changemanagment.impl.HistoryInfoImpl
	 * <em>History Info</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.unicase.emfstore.esmodel.changemanagment.impl.HistoryInfoImpl
	 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getHistoryInfo()
	 * @generated
	 */
	int HISTORY_INFO = 6;

	/**
	 * The feature id for the '<em><b>Primery Spec</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HISTORY_INFO__PRIMERY_SPEC = 0;

	/**
	 * The feature id for the '<em><b>Log Message</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HISTORY_INFO__LOG_MESSAGE = 1;

	/**
	 * The number of structural features of the '<em>History Info</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HISTORY_INFO_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.changemanagment.impl.VersionImpl <em>Version</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.changemanagment.impl.VersionImpl
	 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getVersion()
	 * @generated
	 */
	int VERSION = 7;

	/**
	 * The feature id for the '<em><b>Project State</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__PROJECT_STATE = 0;

	/**
	 * The feature id for the '<em><b>Primary Spec</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__PRIMARY_SPEC = 1;

	/**
	 * The feature id for the '<em><b>Tag Specs</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__TAG_SPECS = 2;

	/**
	 * The feature id for the '<em><b>Next Version</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION__NEXT_VERSION = 3;

	/**
	 * The feature id for the '<em><b>Previous Version</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION__PREVIOUS_VERSION = 4;

	/**
	 * The feature id for the '<em><b>Changes</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__CHANGES = 5;

	/**
	 * The feature id for the '<em><b>Log Message</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSION__LOG_MESSAGE = 6;

	/**
	 * The number of structural features of the '<em>Version</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERSION_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link org.unicase.emfstore.esmodel.changemanagment.impl.HeadVersionSpecImpl <em>Head Version Spec</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see org.unicase.emfstore.esmodel.changemanagment.impl.HeadVersionSpecImpl
	 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getHeadVersionSpec()
	 * @generated
	 */
	int HEAD_VERSION_SPEC = 8;

	/**
	 * The number of structural features of the '<em>Head Version Spec</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEAD_VERSION_SPEC_FEATURE_COUNT = VERSION_SPEC_FEATURE_COUNT + 0;

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.emfstore.esmodel.changemanagment.TagVersionSpec
	 * <em>Tag Version Spec</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Tag Version Spec</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.TagVersionSpec
	 * @generated
	 */
	EClass getTagVersionSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.changemanagment.TagVersionSpec#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.TagVersionSpec#getName()
	 * @see #getTagVersionSpec()
	 * @generated
	 */
	EAttribute getTagVersionSpec_Name();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.emfstore.esmodel.changemanagment.DateVersionSpec
	 * <em>Date Version Spec</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Date Version Spec</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.DateVersionSpec
	 * @generated
	 */
	EClass getDateVersionSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.changemanagment.DateVersionSpec#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.DateVersionSpec#getDate()
	 * @see #getDateVersionSpec()
	 * @generated
	 */
	EAttribute getDateVersionSpec_Date();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec <em>Primary Version Spec</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for class '<em>Primary Version Spec</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec
	 * @generated
	 */
	EClass getPrimaryVersionSpec();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.PrimaryVersionSpec#getIdentifier()
	 * @see #getPrimaryVersionSpec()
	 * @generated
	 */
	EAttribute getPrimaryVersionSpec_Identifier();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.changemanagment.VersionSpec <em>Version Spec</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version Spec</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.VersionSpec
	 * @generated
	 */
	EClass getVersionSpec();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.changemanagment.LogMessage <em>Log Message</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Log Message</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.LogMessage
	 * @generated
	 */
	EClass getLogMessage();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.changemanagment.LogMessage#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.LogMessage#getMessage()
	 * @see #getLogMessage()
	 * @generated
	 */
	EAttribute getLogMessage_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.changemanagment.LogMessage#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.LogMessage#getAuthor()
	 * @see #getLogMessage()
	 * @generated
	 */
	EAttribute getLogMessage_Author();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.emfstore.esmodel.changemanagment.LogMessage#getDate <em>Date</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Date</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.LogMessage#getDate()
	 * @see #getLogMessage()
	 * @generated
	 */
	EAttribute getLogMessage_Date();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.changemanagment.ChangePackage <em>Change Package</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Change Package</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.ChangePackage
	 * @generated
	 */
	EClass getChangePackage();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.changemanagment.ChangePackage#getFowardDelta <em>Foward Delta</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Foward Delta</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.ChangePackage#getFowardDelta()
	 * @see #getChangePackage()
	 * @generated
	 */
	EReference getChangePackage_FowardDelta();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.changemanagment.ChangePackage#getBackwardDelta <em>Backward Delta</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Backward Delta</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.ChangePackage#getBackwardDelta()
	 * @see #getChangePackage()
	 * @generated
	 */
	EReference getChangePackage_BackwardDelta();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.emfstore.esmodel.changemanagment.ChangePackage#getProjectState <em>Project State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Project State</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.ChangePackage#getProjectState()
	 * @see #getChangePackage()
	 * @generated
	 */
	EReference getChangePackage_ProjectState();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.changemanagment.HistoryInfo <em>History Info</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>History Info</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.HistoryInfo
	 * @generated
	 */
	EClass getHistoryInfo();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.emfstore.esmodel.changemanagment.HistoryInfo#getPrimerySpec <em>Primery Spec</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primery Spec</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.HistoryInfo#getPrimerySpec()
	 * @see #getHistoryInfo()
	 * @generated
	 */
	EReference getHistoryInfo_PrimerySpec();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.emfstore.esmodel.changemanagment.HistoryInfo#getLogMessage <em>Log Message</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Log Message</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.HistoryInfo#getLogMessage()
	 * @see #getHistoryInfo()
	 * @generated
	 */
	EReference getHistoryInfo_LogMessage();

	/**
	 * Returns the meta object for class '{@link org.unicase.emfstore.esmodel.changemanagment.Version <em>Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Version</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.Version
	 * @generated
	 */
	EClass getVersion();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.changemanagment.Version#getProjectState <em>Project State</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Project State</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.Version#getProjectState()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_ProjectState();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.changemanagment.Version#getPrimarySpec <em>Primary Spec</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Primary Spec</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.Version#getPrimarySpec()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_PrimarySpec();

	/**
	 * Returns the meta object for the containment reference list '{@link org.unicase.emfstore.esmodel.changemanagment.Version#getTagSpecs <em>Tag Specs</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tag Specs</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.Version#getTagSpecs()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_TagSpecs();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.emfstore.esmodel.changemanagment.Version#getNextVersion <em>Next Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Version</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.Version#getNextVersion()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_NextVersion();

	/**
	 * Returns the meta object for the reference '
	 * {@link org.unicase.emfstore.esmodel.changemanagment.Version#getPreviousVersion
	 * <em>Previous Version</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference '<em>Previous Version</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.Version#getPreviousVersion()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_PreviousVersion();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.changemanagment.Version#getChanges <em>Changes</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Changes</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.Version#getChanges()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_Changes();

	/**
	 * Returns the meta object for the containment reference '{@link org.unicase.emfstore.esmodel.changemanagment.Version#getLogMessage <em>Log Message</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Log Message</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.Version#getLogMessage()
	 * @see #getVersion()
	 * @generated
	 */
	EReference getVersion_LogMessage();

	/**
	 * Returns the meta object for class '
	 * {@link org.unicase.emfstore.esmodel.changemanagment.HeadVersionSpec
	 * <em>Head Version Spec</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Head Version Spec</em>'.
	 * @see org.unicase.emfstore.esmodel.changemanagment.HeadVersionSpec
	 * @generated
	 */
	EClass getHeadVersionSpec();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ChangemanagmentFactory getChangemanagmentFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
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
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.changemanagment.impl.TagVersionSpecImpl <em>Tag Version Spec</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.changemanagment.impl.TagVersionSpecImpl
		 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getTagVersionSpec()
		 * @generated
		 */
		EClass TAG_VERSION_SPEC = eINSTANCE.getTagVersionSpec();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TAG_VERSION_SPEC__NAME = eINSTANCE.getTagVersionSpec_Name();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.changemanagment.impl.DateVersionSpecImpl <em>Date Version Spec</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.changemanagment.impl.DateVersionSpecImpl
		 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getDateVersionSpec()
		 * @generated
		 */
		EClass DATE_VERSION_SPEC = eINSTANCE.getDateVersionSpec();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATE_VERSION_SPEC__DATE = eINSTANCE
				.getDateVersionSpec_Date();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.changemanagment.impl.PrimaryVersionSpecImpl <em>Primary Version Spec</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.changemanagment.impl.PrimaryVersionSpecImpl
		 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getPrimaryVersionSpec()
		 * @generated
		 */
		EClass PRIMARY_VERSION_SPEC = eINSTANCE.getPrimaryVersionSpec();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMARY_VERSION_SPEC__IDENTIFIER = eINSTANCE
				.getPrimaryVersionSpec_Identifier();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.changemanagment.VersionSpec <em>Version Spec</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.changemanagment.VersionSpec
		 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getVersionSpec()
		 * @generated
		 */
		EClass VERSION_SPEC = eINSTANCE.getVersionSpec();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.changemanagment.impl.LogMessageImpl <em>Log Message</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.changemanagment.impl.LogMessageImpl
		 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getLogMessage()
		 * @generated
		 */
		EClass LOG_MESSAGE = eINSTANCE.getLogMessage();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_MESSAGE__MESSAGE = eINSTANCE.getLogMessage_Message();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_MESSAGE__AUTHOR = eINSTANCE.getLogMessage_Author();

		/**
		 * The meta object literal for the '<em><b>Date</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOG_MESSAGE__DATE = eINSTANCE.getLogMessage_Date();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.changemanagment.impl.ChangePackageImpl <em>Change Package</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangePackageImpl
		 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getChangePackage()
		 * @generated
		 */
		EClass CHANGE_PACKAGE = eINSTANCE.getChangePackage();

		/**
		 * The meta object literal for the '<em><b>Foward Delta</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference CHANGE_PACKAGE__FOWARD_DELTA = eINSTANCE
				.getChangePackage_FowardDelta();

		/**
		 * The meta object literal for the '<em><b>Backward Delta</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference CHANGE_PACKAGE__BACKWARD_DELTA = eINSTANCE
				.getChangePackage_BackwardDelta();

		/**
		 * The meta object literal for the '<em><b>Project State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHANGE_PACKAGE__PROJECT_STATE = eINSTANCE
				.getChangePackage_ProjectState();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.changemanagment.impl.HistoryInfoImpl <em>History Info</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.changemanagment.impl.HistoryInfoImpl
		 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getHistoryInfo()
		 * @generated
		 */
		EClass HISTORY_INFO = eINSTANCE.getHistoryInfo();

		/**
		 * The meta object literal for the '<em><b>Primery Spec</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY_INFO__PRIMERY_SPEC = eINSTANCE
				.getHistoryInfo_PrimerySpec();

		/**
		 * The meta object literal for the '<em><b>Log Message</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference HISTORY_INFO__LOG_MESSAGE = eINSTANCE
				.getHistoryInfo_LogMessage();

		/**
		 * The meta object literal for the '
		 * {@link org.unicase.emfstore.esmodel.changemanagment.impl.VersionImpl
		 * <em>Version</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.unicase.emfstore.esmodel.changemanagment.impl.VersionImpl
		 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getVersion()
		 * @generated
		 */
		EClass VERSION = eINSTANCE.getVersion();

		/**
		 * The meta object literal for the '<em><b>Project State</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference VERSION__PROJECT_STATE = eINSTANCE.getVersion_ProjectState();

		/**
		 * The meta object literal for the '<em><b>Primary Spec</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference VERSION__PRIMARY_SPEC = eINSTANCE.getVersion_PrimarySpec();

		/**
		 * The meta object literal for the '<em><b>Tag Specs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference VERSION__TAG_SPECS = eINSTANCE.getVersion_TagSpecs();

		/**
		 * The meta object literal for the '<em><b>Next Version</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__NEXT_VERSION = eINSTANCE.getVersion_NextVersion();

		/**
		 * The meta object literal for the '<em><b>Previous Version</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__PREVIOUS_VERSION = eINSTANCE
				.getVersion_PreviousVersion();

		/**
		 * The meta object literal for the '<em><b>Changes</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSION__CHANGES = eINSTANCE.getVersion_Changes();

		/**
		 * The meta object literal for the '<em><b>Log Message</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference VERSION__LOG_MESSAGE = eINSTANCE.getVersion_LogMessage();

		/**
		 * The meta object literal for the '{@link org.unicase.emfstore.esmodel.changemanagment.impl.HeadVersionSpecImpl <em>Head Version Spec</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.unicase.emfstore.esmodel.changemanagment.impl.HeadVersionSpecImpl
		 * @see org.unicase.emfstore.esmodel.changemanagment.impl.ChangemanagmentPackageImpl#getHeadVersionSpec()
		 * @generated
		 */
		EClass HEAD_VERSION_SPEC = eINSTANCE.getHeadVersionSpec();

	}

} // ChangemanagmentPackage
