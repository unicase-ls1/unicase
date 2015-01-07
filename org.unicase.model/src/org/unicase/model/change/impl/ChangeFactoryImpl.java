/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.change.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.model.change.ChangeFactory;
import org.unicase.model.change.ChangePackage;
import org.unicase.model.change.MergingIssue;
import org.unicase.model.change.MergingProposal;
import org.unicase.model.change.MergingSolution;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ChangeFactoryImpl extends EFactoryImpl implements ChangeFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static ChangeFactory init() {
		try {
			ChangeFactory theChangeFactory = (ChangeFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://unicase.org/model/change");
			if (theChangeFactory != null) {
				return theChangeFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ChangeFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ChangeFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ChangePackage.MERGING_ISSUE:
			return createMergingIssue();
		case ChangePackage.MERGING_PROPOSAL:
			return createMergingProposal();
		case ChangePackage.MERGING_SOLUTION:
			return createMergingSolution();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MergingIssue createMergingIssue() {
		MergingIssueImpl mergingIssue = new MergingIssueImpl();
		return mergingIssue;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MergingProposal createMergingProposal() {
		MergingProposalImpl mergingProposal = new MergingProposalImpl();
		return mergingProposal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MergingSolution createMergingSolution() {
		MergingSolutionImpl mergingSolution = new MergingSolutionImpl();
		return mergingSolution;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ChangePackage getChangePackage() {
		return (ChangePackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ChangePackage getPackage() {
		return ChangePackage.eINSTANCE;
	}

} // ChangeFactoryImpl
