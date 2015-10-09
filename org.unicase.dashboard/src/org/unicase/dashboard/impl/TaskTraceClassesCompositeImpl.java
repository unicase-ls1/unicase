/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.dashboard.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.unicase.dashboard.DashboardPackage;
import org.unicase.dashboard.TaskTraceClassesComposite;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Task Trace Classes Composite</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.dashboard.impl.TaskTraceClassesCompositeImpl#getTaskTraceClasses <em>Task Trace Classes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TaskTraceClassesCompositeImpl extends EObjectImpl implements
		TaskTraceClassesComposite {
	/**
	 * The cached value of the '{@link #getTaskTraceClasses() <em>Task Trace Classes</em>}' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getTaskTraceClasses()
	 * @generated
	 * @ordered
	 */
	protected EList<EObject> taskTraceClasses;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TaskTraceClassesCompositeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DashboardPackage.Literals.TASK_TRACE_CLASSES_COMPOSITE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EObject> getTaskTraceClasses() {
		if (taskTraceClasses == null) {
			taskTraceClasses = new EObjectResolvingEList<EObject>(
					EObject.class,
					this,
					DashboardPackage.TASK_TRACE_CLASSES_COMPOSITE__TASK_TRACE_CLASSES);
		}
		return taskTraceClasses;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DashboardPackage.TASK_TRACE_CLASSES_COMPOSITE__TASK_TRACE_CLASSES:
			return getTaskTraceClasses();
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
		case DashboardPackage.TASK_TRACE_CLASSES_COMPOSITE__TASK_TRACE_CLASSES:
			getTaskTraceClasses().clear();
			getTaskTraceClasses().addAll(
					(Collection<? extends EObject>) newValue);
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
		case DashboardPackage.TASK_TRACE_CLASSES_COMPOSITE__TASK_TRACE_CLASSES:
			getTaskTraceClasses().clear();
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
		case DashboardPackage.TASK_TRACE_CLASSES_COMPOSITE__TASK_TRACE_CLASSES:
			return taskTraceClasses != null && !taskTraceClasses.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // TaskTraceClassesCompositeImpl
