/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 *
 * $Id$
 */
package org.unicase.model.changetracking.git;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.unicase.model.changetracking.ChangetrackingPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.unicase.model.changetracking.git.GitFactory
 * @model kind="package"
 * @generated
 */
public interface GitPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "<copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>\r";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "git";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://unicase.org/changetracking/git";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.unicase.model.changetracking.git";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GitPackage eINSTANCE = org.unicase.model.changetracking.git.impl.GitPackageImpl
			.init();

	/**
	 * The meta object id for the '{@link org.unicase.model.changetracking.git.impl.GitBranchChangePackageImpl <em>Branch Change Package</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.changetracking.git.impl.GitBranchChangePackageImpl
	 * @see org.unicase.model.changetracking.git.impl.GitPackageImpl#getGitBranchChangePackage()
	 * @generated
	 */
	int GIT_BRANCH_CHANGE_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH_CHANGE_PACKAGE__NAME = ChangetrackingPackage.CHANGE_PACKAGE__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH_CHANGE_PACKAGE__DESCRIPTION = ChangetrackingPackage.CHANGE_PACKAGE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH_CHANGE_PACKAGE__ANNOTATIONS = ChangetrackingPackage.CHANGE_PACKAGE__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH_CHANGE_PACKAGE__ATTACHMENTS = ChangetrackingPackage.CHANGE_PACKAGE__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH_CHANGE_PACKAGE__INCOMING_DOCUMENT_REFERENCES = ChangetrackingPackage.CHANGE_PACKAGE__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH_CHANGE_PACKAGE__LEAF_SECTION = ChangetrackingPackage.CHANGE_PACKAGE__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH_CHANGE_PACKAGE__STATE = ChangetrackingPackage.CHANGE_PACKAGE__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH_CHANGE_PACKAGE__APPLIED_STEREOTYPE_INSTANCES = ChangetrackingPackage.CHANGE_PACKAGE__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH_CHANGE_PACKAGE__COMMENTS = ChangetrackingPackage.CHANGE_PACKAGE__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH_CHANGE_PACKAGE__CREATION_DATE = ChangetrackingPackage.CHANGE_PACKAGE__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH_CHANGE_PACKAGE__CREATOR = ChangetrackingPackage.CHANGE_PACKAGE__CREATOR;

	/**
	 * The feature id for the '<em><b>Referring Model Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH_CHANGE_PACKAGE__REFERRING_MODEL_ELEMENTS = ChangetrackingPackage.CHANGE_PACKAGE__REFERRING_MODEL_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Short Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH_CHANGE_PACKAGE__SHORT_DESCRIPTION = ChangetrackingPackage.CHANGE_PACKAGE__SHORT_DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Branch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH_CHANGE_PACKAGE__BRANCH = ChangetrackingPackage.CHANGE_PACKAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Branch Change Package</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH_CHANGE_PACKAGE_FEATURE_COUNT = ChangetrackingPackage.CHANGE_PACKAGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.unicase.model.changetracking.git.impl.GitBranchImpl <em>Branch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.changetracking.git.impl.GitBranchImpl
	 * @see org.unicase.model.changetracking.git.impl.GitPackageImpl#getGitBranch()
	 * @generated
	 */
	int GIT_BRANCH = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH__NAME = ChangetrackingPackage.REPOSITORY_STREAM__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH__DESCRIPTION = ChangetrackingPackage.REPOSITORY_STREAM__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH__ANNOTATIONS = ChangetrackingPackage.REPOSITORY_STREAM__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH__ATTACHMENTS = ChangetrackingPackage.REPOSITORY_STREAM__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH__INCOMING_DOCUMENT_REFERENCES = ChangetrackingPackage.REPOSITORY_STREAM__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH__LEAF_SECTION = ChangetrackingPackage.REPOSITORY_STREAM__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH__STATE = ChangetrackingPackage.REPOSITORY_STREAM__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH__APPLIED_STEREOTYPE_INSTANCES = ChangetrackingPackage.REPOSITORY_STREAM__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH__COMMENTS = ChangetrackingPackage.REPOSITORY_STREAM__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH__CREATION_DATE = ChangetrackingPackage.REPOSITORY_STREAM__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH__CREATOR = ChangetrackingPackage.REPOSITORY_STREAM__CREATOR;

	/**
	 * The feature id for the '<em><b>Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH__LOCATION = ChangetrackingPackage.REPOSITORY_STREAM__LOCATION;

	/**
	 * The feature id for the '<em><b>Revisions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH__REVISIONS = ChangetrackingPackage.REPOSITORY_STREAM__REVISIONS;

	/**
	 * The feature id for the '<em><b>Using Streams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH__USING_STREAMS = ChangetrackingPackage.REPOSITORY_STREAM__USING_STREAMS;

	/**
	 * The feature id for the '<em><b>Referring Change Packages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH__REFERRING_CHANGE_PACKAGES = ChangetrackingPackage.REPOSITORY_STREAM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Branch Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH__BRANCH_NAME = ChangetrackingPackage.REPOSITORY_STREAM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Branch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_BRANCH_FEATURE_COUNT = ChangetrackingPackage.REPOSITORY_STREAM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.model.changetracking.git.impl.GitRevisionImpl <em>Revision</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.changetracking.git.impl.GitRevisionImpl
	 * @see org.unicase.model.changetracking.git.impl.GitPackageImpl#getGitRevision()
	 * @generated
	 */
	int GIT_REVISION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REVISION__NAME = ChangetrackingPackage.REPOSITORY_REVISION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REVISION__DESCRIPTION = ChangetrackingPackage.REPOSITORY_REVISION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REVISION__ANNOTATIONS = ChangetrackingPackage.REPOSITORY_REVISION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REVISION__ATTACHMENTS = ChangetrackingPackage.REPOSITORY_REVISION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REVISION__INCOMING_DOCUMENT_REFERENCES = ChangetrackingPackage.REPOSITORY_REVISION__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REVISION__LEAF_SECTION = ChangetrackingPackage.REPOSITORY_REVISION__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REVISION__STATE = ChangetrackingPackage.REPOSITORY_REVISION__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REVISION__APPLIED_STEREOTYPE_INSTANCES = ChangetrackingPackage.REPOSITORY_REVISION__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REVISION__COMMENTS = ChangetrackingPackage.REPOSITORY_REVISION__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REVISION__CREATION_DATE = ChangetrackingPackage.REPOSITORY_REVISION__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REVISION__CREATOR = ChangetrackingPackage.REPOSITORY_REVISION__CREATOR;

	/**
	 * The feature id for the '<em><b>Repository Stream</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REVISION__REPOSITORY_STREAM = ChangetrackingPackage.REPOSITORY_REVISION__REPOSITORY_STREAM;

	/**
	 * The feature id for the '<em><b>Built With Releases</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REVISION__BUILT_WITH_RELEASES = ChangetrackingPackage.REPOSITORY_REVISION__BUILT_WITH_RELEASES;

	/**
	 * The feature id for the '<em><b>Hash</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REVISION__HASH = ChangetrackingPackage.REPOSITORY_REVISION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Tag Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REVISION__TAG_NAME = ChangetrackingPackage.REPOSITORY_REVISION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Revision</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REVISION_FEATURE_COUNT = ChangetrackingPackage.REPOSITORY_REVISION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.unicase.model.changetracking.git.impl.GitRepositoryImpl <em>Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.unicase.model.changetracking.git.impl.GitRepositoryImpl
	 * @see org.unicase.model.changetracking.git.impl.GitPackageImpl#getGitRepository()
	 * @generated
	 */
	int GIT_REPOSITORY = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REPOSITORY__NAME = ChangetrackingPackage.REPOSITORY_LOCATION__NAME;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REPOSITORY__DESCRIPTION = ChangetrackingPackage.REPOSITORY_LOCATION__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Annotations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REPOSITORY__ANNOTATIONS = ChangetrackingPackage.REPOSITORY_LOCATION__ANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Attachments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REPOSITORY__ATTACHMENTS = ChangetrackingPackage.REPOSITORY_LOCATION__ATTACHMENTS;

	/**
	 * The feature id for the '<em><b>Incoming Document References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REPOSITORY__INCOMING_DOCUMENT_REFERENCES = ChangetrackingPackage.REPOSITORY_LOCATION__INCOMING_DOCUMENT_REFERENCES;

	/**
	 * The feature id for the '<em><b>Leaf Section</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REPOSITORY__LEAF_SECTION = ChangetrackingPackage.REPOSITORY_LOCATION__LEAF_SECTION;

	/**
	 * The feature id for the '<em><b>State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REPOSITORY__STATE = ChangetrackingPackage.REPOSITORY_LOCATION__STATE;

	/**
	 * The feature id for the '<em><b>Applied Stereotype Instances</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REPOSITORY__APPLIED_STEREOTYPE_INSTANCES = ChangetrackingPackage.REPOSITORY_LOCATION__APPLIED_STEREOTYPE_INSTANCES;

	/**
	 * The feature id for the '<em><b>Comments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REPOSITORY__COMMENTS = ChangetrackingPackage.REPOSITORY_LOCATION__COMMENTS;

	/**
	 * The feature id for the '<em><b>Creation Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REPOSITORY__CREATION_DATE = ChangetrackingPackage.REPOSITORY_LOCATION__CREATION_DATE;

	/**
	 * The feature id for the '<em><b>Creator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REPOSITORY__CREATOR = ChangetrackingPackage.REPOSITORY_LOCATION__CREATOR;

	/**
	 * The feature id for the '<em><b>Streams</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REPOSITORY__STREAMS = ChangetrackingPackage.REPOSITORY_LOCATION__STREAMS;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REPOSITORY__URL = ChangetrackingPackage.REPOSITORY_LOCATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Identifying Commit Hash</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REPOSITORY__IDENTIFYING_COMMIT_HASH = ChangetrackingPackage.REPOSITORY_LOCATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GIT_REPOSITORY_FEATURE_COUNT = ChangetrackingPackage.REPOSITORY_LOCATION_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.unicase.model.changetracking.git.GitBranchChangePackage <em>Branch Change Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch Change Package</em>'.
	 * @see org.unicase.model.changetracking.git.GitBranchChangePackage
	 * @generated
	 */
	EClass getGitBranchChangePackage();

	/**
	 * Returns the meta object for the reference '{@link org.unicase.model.changetracking.git.GitBranchChangePackage#getBranch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Branch</em>'.
	 * @see org.unicase.model.changetracking.git.GitBranchChangePackage#getBranch()
	 * @see #getGitBranchChangePackage()
	 * @generated
	 */
	EReference getGitBranchChangePackage_Branch();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.changetracking.git.GitBranch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch</em>'.
	 * @see org.unicase.model.changetracking.git.GitBranch
	 * @generated
	 */
	EClass getGitBranch();

	/**
	 * Returns the meta object for the reference list '{@link org.unicase.model.changetracking.git.GitBranch#getReferringChangePackages <em>Referring Change Packages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Referring Change Packages</em>'.
	 * @see org.unicase.model.changetracking.git.GitBranch#getReferringChangePackages()
	 * @see #getGitBranch()
	 * @generated
	 */
	EReference getGitBranch_ReferringChangePackages();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.changetracking.git.GitBranch#getBranchName <em>Branch Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Branch Name</em>'.
	 * @see org.unicase.model.changetracking.git.GitBranch#getBranchName()
	 * @see #getGitBranch()
	 * @generated
	 */
	EAttribute getGitBranch_BranchName();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.changetracking.git.GitRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Revision</em>'.
	 * @see org.unicase.model.changetracking.git.GitRevision
	 * @generated
	 */
	EClass getGitRevision();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.changetracking.git.GitRevision#getHash <em>Hash</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Hash</em>'.
	 * @see org.unicase.model.changetracking.git.GitRevision#getHash()
	 * @see #getGitRevision()
	 * @generated
	 */
	EAttribute getGitRevision_Hash();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.changetracking.git.GitRevision#getTagName <em>Tag Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tag Name</em>'.
	 * @see org.unicase.model.changetracking.git.GitRevision#getTagName()
	 * @see #getGitRevision()
	 * @generated
	 */
	EAttribute getGitRevision_TagName();

	/**
	 * Returns the meta object for class '{@link org.unicase.model.changetracking.git.GitRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository</em>'.
	 * @see org.unicase.model.changetracking.git.GitRepository
	 * @generated
	 */
	EClass getGitRepository();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.changetracking.git.GitRepository#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see org.unicase.model.changetracking.git.GitRepository#getUrl()
	 * @see #getGitRepository()
	 * @generated
	 */
	EAttribute getGitRepository_Url();

	/**
	 * Returns the meta object for the attribute '{@link org.unicase.model.changetracking.git.GitRepository#getIdentifyingCommitHash <em>Identifying Commit Hash</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifying Commit Hash</em>'.
	 * @see org.unicase.model.changetracking.git.GitRepository#getIdentifyingCommitHash()
	 * @see #getGitRepository()
	 * @generated
	 */
	EAttribute getGitRepository_IdentifyingCommitHash();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GitFactory getGitFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.unicase.model.changetracking.git.impl.GitBranchChangePackageImpl <em>Branch Change Package</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.changetracking.git.impl.GitBranchChangePackageImpl
		 * @see org.unicase.model.changetracking.git.impl.GitPackageImpl#getGitBranchChangePackage()
		 * @generated
		 */
		EClass GIT_BRANCH_CHANGE_PACKAGE = eINSTANCE
				.getGitBranchChangePackage();

		/**
		 * The meta object literal for the '<em><b>Branch</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GIT_BRANCH_CHANGE_PACKAGE__BRANCH = eINSTANCE
				.getGitBranchChangePackage_Branch();

		/**
		 * The meta object literal for the '{@link org.unicase.model.changetracking.git.impl.GitBranchImpl <em>Branch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.changetracking.git.impl.GitBranchImpl
		 * @see org.unicase.model.changetracking.git.impl.GitPackageImpl#getGitBranch()
		 * @generated
		 */
		EClass GIT_BRANCH = eINSTANCE.getGitBranch();

		/**
		 * The meta object literal for the '<em><b>Referring Change Packages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GIT_BRANCH__REFERRING_CHANGE_PACKAGES = eINSTANCE
				.getGitBranch_ReferringChangePackages();

		/**
		 * The meta object literal for the '<em><b>Branch Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GIT_BRANCH__BRANCH_NAME = eINSTANCE
				.getGitBranch_BranchName();

		/**
		 * The meta object literal for the '{@link org.unicase.model.changetracking.git.impl.GitRevisionImpl <em>Revision</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.changetracking.git.impl.GitRevisionImpl
		 * @see org.unicase.model.changetracking.git.impl.GitPackageImpl#getGitRevision()
		 * @generated
		 */
		EClass GIT_REVISION = eINSTANCE.getGitRevision();

		/**
		 * The meta object literal for the '<em><b>Hash</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GIT_REVISION__HASH = eINSTANCE.getGitRevision_Hash();

		/**
		 * The meta object literal for the '<em><b>Tag Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GIT_REVISION__TAG_NAME = eINSTANCE.getGitRevision_TagName();

		/**
		 * The meta object literal for the '{@link org.unicase.model.changetracking.git.impl.GitRepositoryImpl <em>Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.unicase.model.changetracking.git.impl.GitRepositoryImpl
		 * @see org.unicase.model.changetracking.git.impl.GitPackageImpl#getGitRepository()
		 * @generated
		 */
		EClass GIT_REPOSITORY = eINSTANCE.getGitRepository();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GIT_REPOSITORY__URL = eINSTANCE.getGitRepository_Url();

		/**
		 * The meta object literal for the '<em><b>Identifying Commit Hash</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GIT_REPOSITORY__IDENTIFYING_COMMIT_HASH = eINSTANCE
				.getGitRepository_IdentifyingCommitHash();

	}

} //GitPackage
