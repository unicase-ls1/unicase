/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.wireframe.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.wireframe.Window;
import org.unicase.wireframe.WireframePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Window</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.wireframe.impl.WindowImpl#isHasClose <em>Has Close</em>}</li>
 *   <li>{@link org.unicase.wireframe.impl.WindowImpl#isHasMaximize <em>Has Maximize</em>}</li>
 *   <li>{@link org.unicase.wireframe.impl.WindowImpl#isHasMinimize <em>Has Minimize</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class WindowImpl extends WidgetImpl implements Window {
	/**
	 * The default value of the '{@link #isHasClose() <em>Has Close</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isHasClose()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_CLOSE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasClose() <em>Has Close</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isHasClose()
	 * @generated
	 * @ordered
	 */
	protected boolean hasClose = HAS_CLOSE_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasMaximize() <em>Has Maximize</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isHasMaximize()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_MAXIMIZE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasMaximize() <em>Has Maximize</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isHasMaximize()
	 * @generated
	 * @ordered
	 */
	protected boolean hasMaximize = HAS_MAXIMIZE_EDEFAULT;

	/**
	 * The default value of the '{@link #isHasMinimize() <em>Has Minimize</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isHasMinimize()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_MINIMIZE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasMinimize() <em>Has Minimize</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isHasMinimize()
	 * @generated
	 * @ordered
	 */
	protected boolean hasMinimize = HAS_MINIMIZE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WindowImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WireframePackage.Literals.WINDOW;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasClose() {
		return hasClose;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasClose(boolean newHasClose) {
		boolean oldHasClose = hasClose;
		hasClose = newHasClose;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WireframePackage.WINDOW__HAS_CLOSE, oldHasClose,
				hasClose));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasMaximize() {
		return hasMaximize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasMaximize(boolean newHasMaximize) {
		boolean oldHasMaximize = hasMaximize;
		hasMaximize = newHasMaximize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WireframePackage.WINDOW__HAS_MAXIMIZE,
				oldHasMaximize, hasMaximize));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isHasMinimize() {
		return hasMinimize;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasMinimize(boolean newHasMinimize) {
		boolean oldHasMinimize = hasMinimize;
		hasMinimize = newHasMinimize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WireframePackage.WINDOW__HAS_MINIMIZE,
				oldHasMinimize, hasMinimize));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case WireframePackage.WINDOW__HAS_CLOSE:
			return isHasClose();
		case WireframePackage.WINDOW__HAS_MAXIMIZE:
			return isHasMaximize();
		case WireframePackage.WINDOW__HAS_MINIMIZE:
			return isHasMinimize();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case WireframePackage.WINDOW__HAS_CLOSE:
			setHasClose((Boolean) newValue);
			return;
		case WireframePackage.WINDOW__HAS_MAXIMIZE:
			setHasMaximize((Boolean) newValue);
			return;
		case WireframePackage.WINDOW__HAS_MINIMIZE:
			setHasMinimize((Boolean) newValue);
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
		case WireframePackage.WINDOW__HAS_CLOSE:
			setHasClose(HAS_CLOSE_EDEFAULT);
			return;
		case WireframePackage.WINDOW__HAS_MAXIMIZE:
			setHasMaximize(HAS_MAXIMIZE_EDEFAULT);
			return;
		case WireframePackage.WINDOW__HAS_MINIMIZE:
			setHasMinimize(HAS_MINIMIZE_EDEFAULT);
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
		case WireframePackage.WINDOW__HAS_CLOSE:
			return hasClose != HAS_CLOSE_EDEFAULT;
		case WireframePackage.WINDOW__HAS_MAXIMIZE:
			return hasMaximize != HAS_MAXIMIZE_EDEFAULT;
		case WireframePackage.WINDOW__HAS_MINIMIZE:
			return hasMinimize != HAS_MINIMIZE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (hasClose: ");
		result.append(hasClose);
		result.append(", hasMaximize: ");
		result.append(hasMaximize);
		result.append(", hasMinimize: ");
		result.append(hasMinimize);
		result.append(')');
		return result.toString();
	}

} // WindowImpl
