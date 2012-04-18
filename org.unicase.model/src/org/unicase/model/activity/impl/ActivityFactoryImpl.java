/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.activity.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.model.activity.*;
import org.unicase.model.activity.Activity;
import org.unicase.model.activity.ActivityEnd;
import org.unicase.model.activity.ActivityFactory;
import org.unicase.model.activity.ActivityInitial;
import org.unicase.model.activity.ActivityPackage;
import org.unicase.model.activity.Branch;
import org.unicase.model.activity.Fork;
import org.unicase.model.activity.Transition;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ActivityFactoryImpl extends EFactoryImpl implements ActivityFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static ActivityFactory init() {
		try {
			ActivityFactory theActivityFactory = (ActivityFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://unicase.org/model/activity");
			if (theActivityFactory != null) {
				return theActivityFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ActivityFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case ActivityPackage.TRANSITION:
			return createTransition();
		case ActivityPackage.ACTIVITY:
			return createActivity();
		case ActivityPackage.FORK:
			return createFork();
		case ActivityPackage.BRANCH:
			return createBranch();
		case ActivityPackage.ACTIVITY_INITIAL:
			return createActivityInitial();
		case ActivityPackage.ACTIVITY_END:
			return createActivityEnd();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Transition createTransition() {
		TransitionImpl transition = new TransitionImpl();
		return transition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Activity createActivity() {
		ActivityImpl activity = new ActivityImpl();
		return activity;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Fork createFork() {
		ForkImpl fork = new ForkImpl();
		return fork;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Branch createBranch() {
		BranchImpl branch = new BranchImpl();
		return branch;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityInitial createActivityInitial() {
		ActivityInitialImpl activityInitial = new ActivityInitialImpl();
		return activityInitial;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityEnd createActivityEnd() {
		ActivityEndImpl activityEnd = new ActivityEndImpl();
		return activityEnd;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityPackage getActivityPackage() {
		return (ActivityPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ActivityPackage getPackage() {
		return ActivityPackage.eINSTANCE;
	}

} // ActivityFactoryImpl
