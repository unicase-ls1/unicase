/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 * 
 */
package org.unicase.model.changetracking.git.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.unicase.model.Attachment;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.changetracking.ChangePackage;
import org.unicase.model.changetracking.RepositoryLocation;
import org.unicase.model.changetracking.RepositoryRevision;
import org.unicase.model.changetracking.RepositoryStream;
import org.unicase.model.changetracking.git.*;
import org.unicase.model.changetracking.git.GitBranch;
import org.unicase.model.changetracking.git.GitBranchChangePackage;
import org.unicase.model.changetracking.git.GitPackage;
import org.unicase.model.changetracking.git.GitRepository;
import org.unicase.model.changetracking.git.GitRevision;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.model.changetracking.git.GitPackage
 * @generated
 */
public class GitAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static GitPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GitAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = GitPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GitSwitch<Adapter> modelSwitch = new GitSwitch<Adapter>() {
		@Override
		public Adapter caseGitBranchChangePackage(GitBranchChangePackage object) {
			return createGitBranchChangePackageAdapter();
		}

		@Override
		public Adapter caseGitBranch(GitBranch object) {
			return createGitBranchAdapter();
		}

		@Override
		public Adapter caseGitRevision(GitRevision object) {
			return createGitRevisionAdapter();
		}

		@Override
		public Adapter caseGitRepository(GitRepository object) {
			return createGitRepositoryAdapter();
		}

		@Override
		public Adapter caseUnicaseModelElement(UnicaseModelElement object) {
			return createUnicaseModelElementAdapter();
		}

		@Override
		public Adapter caseAttachment(Attachment object) {
			return createAttachmentAdapter();
		}

		@Override
		public Adapter caseChangePackage(ChangePackage object) {
			return createChangePackageAdapter();
		}

		@Override
		public Adapter caseRepositoryStream(RepositoryStream object) {
			return createRepositoryStreamAdapter();
		}

		@Override
		public Adapter caseRepositoryRevision(RepositoryRevision object) {
			return createRepositoryRevisionAdapter();
		}

		@Override
		public Adapter caseRepositoryLocation(RepositoryLocation object) {
			return createRepositoryLocationAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.model.changetracking.git.GitBranchChangePackage <em>Branch Change Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.model.changetracking.git.GitBranchChangePackage
	 * @generated
	 */
	public Adapter createGitBranchChangePackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.model.changetracking.git.GitBranch <em>Branch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.model.changetracking.git.GitBranch
	 * @generated
	 */
	public Adapter createGitBranchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.model.changetracking.git.GitRevision <em>Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.model.changetracking.git.GitRevision
	 * @generated
	 */
	public Adapter createGitRevisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.model.changetracking.git.GitRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.model.changetracking.git.GitRepository
	 * @generated
	 */
	public Adapter createGitRepositoryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.model.UnicaseModelElement <em>Unicase Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.model.UnicaseModelElement
	 * @generated
	 */
	public Adapter createUnicaseModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.model.Attachment <em>Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.model.Attachment
	 * @generated
	 */
	public Adapter createAttachmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.model.changetracking.ChangePackage <em>Change Package</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.model.changetracking.ChangePackage
	 * @generated
	 */
	public Adapter createChangePackageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.model.changetracking.RepositoryStream <em>Repository Stream</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.model.changetracking.RepositoryStream
	 * @generated
	 */
	public Adapter createRepositoryStreamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.model.changetracking.RepositoryRevision <em>Repository Revision</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.model.changetracking.RepositoryRevision
	 * @generated
	 */
	public Adapter createRepositoryRevisionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.model.changetracking.RepositoryLocation <em>Repository Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.model.changetracking.RepositoryLocation
	 * @generated
	 */
	public Adapter createRepositoryLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //GitAdapterFactory
