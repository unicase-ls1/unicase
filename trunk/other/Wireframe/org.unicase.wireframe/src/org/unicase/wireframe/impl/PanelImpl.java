/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.wireframe.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.diagram.impl.MEDiagramImpl;
import org.unicase.wireframe.Panel;
import org.unicase.wireframe.Storyboard;
import org.unicase.wireframe.Widget;
import org.unicase.wireframe.WireframePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Panel</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.wireframe.impl.PanelImpl#getStoryboard <em>Storyboard</em>}</li>
 *   <li>{@link org.unicase.wireframe.impl.PanelImpl#getX <em>X</em>}</li>
 *   <li>{@link org.unicase.wireframe.impl.PanelImpl#getY <em>Y</em>}</li>
 *   <li>{@link org.unicase.wireframe.impl.PanelImpl#getWidgets <em>Widgets</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PanelImpl extends MEDiagramImpl implements Panel {
	/**
	 * The default value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected static final int X_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getX() <em>X</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getX()
	 * @generated
	 * @ordered
	 */
	protected int x = X_EDEFAULT;

	/**
	 * The default value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected static final int Y_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getY() <em>Y</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getY()
	 * @generated
	 * @ordered
	 */
	protected int y = Y_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWidgets() <em>Widgets</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getWidgets()
	 * @generated
	 * @ordered
	 */
	protected EList<Widget> widgets;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PanelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WireframePackage.Literals.PANEL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Storyboard getStoryboard() {
		if (eContainerFeatureID() != WireframePackage.PANEL__STORYBOARD)
			return null;
		return (Storyboard) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Storyboard basicGetStoryboard() {
		if (eContainerFeatureID() != WireframePackage.PANEL__STORYBOARD)
			return null;
		return (Storyboard) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStoryboard(Storyboard newStoryboard, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newStoryboard, WireframePackage.PANEL__STORYBOARD, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStoryboard(Storyboard newStoryboard) {
		if (newStoryboard != eInternalContainer()
			|| (eContainerFeatureID() != WireframePackage.PANEL__STORYBOARD && newStoryboard != null)) {
			if (EcoreUtil.isAncestor(this, newStoryboard))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newStoryboard != null)
				msgs = ((InternalEObject) newStoryboard).eInverseAdd(this, WireframePackage.STORYBOARD__PANELS,
					Storyboard.class, msgs);
			msgs = basicSetStoryboard(newStoryboard, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WireframePackage.PANEL__STORYBOARD, newStoryboard,
				newStoryboard));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getX() {
		return x;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setX(int newX) {
		int oldX = x;
		x = newX;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WireframePackage.PANEL__X, oldX, x));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getY() {
		return y;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setY(int newY) {
		int oldY = y;
		y = newY;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WireframePackage.PANEL__Y, oldY, y));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Widget> getWidgets() {
		if (widgets == null) {
			widgets = new EObjectContainmentWithInverseEList.Resolving<Widget>(Widget.class, this,
				WireframePackage.PANEL__WIDGETS, WireframePackage.WIDGET__PANEL);
		}
		return widgets;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case WireframePackage.PANEL__STORYBOARD:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetStoryboard((Storyboard) otherEnd, msgs);
		case WireframePackage.PANEL__WIDGETS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getWidgets()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case WireframePackage.PANEL__STORYBOARD:
			return basicSetStoryboard(null, msgs);
		case WireframePackage.PANEL__WIDGETS:
			return ((InternalEList<?>) getWidgets()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case WireframePackage.PANEL__STORYBOARD:
			return eInternalContainer().eInverseRemove(this, WireframePackage.STORYBOARD__PANELS, Storyboard.class,
				msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case WireframePackage.PANEL__STORYBOARD:
			if (resolve)
				return getStoryboard();
			return basicGetStoryboard();
		case WireframePackage.PANEL__X:
			return getX();
		case WireframePackage.PANEL__Y:
			return getY();
		case WireframePackage.PANEL__WIDGETS:
			return getWidgets();
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
		case WireframePackage.PANEL__STORYBOARD:
			setStoryboard((Storyboard) newValue);
			return;
		case WireframePackage.PANEL__X:
			setX((Integer) newValue);
			return;
		case WireframePackage.PANEL__Y:
			setY((Integer) newValue);
			return;
		case WireframePackage.PANEL__WIDGETS:
			getWidgets().clear();
			getWidgets().addAll((Collection<? extends Widget>) newValue);
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
		case WireframePackage.PANEL__STORYBOARD:
			setStoryboard((Storyboard) null);
			return;
		case WireframePackage.PANEL__X:
			setX(X_EDEFAULT);
			return;
		case WireframePackage.PANEL__Y:
			setY(Y_EDEFAULT);
			return;
		case WireframePackage.PANEL__WIDGETS:
			getWidgets().clear();
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
		case WireframePackage.PANEL__STORYBOARD:
			return basicGetStoryboard() != null;
		case WireframePackage.PANEL__X:
			return x != X_EDEFAULT;
		case WireframePackage.PANEL__Y:
			return y != Y_EDEFAULT;
		case WireframePackage.PANEL__WIDGETS:
			return widgets != null && !widgets.isEmpty();
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
		result.append(" (x: ");
		result.append(x);
		result.append(", y: ");
		result.append(y);
		result.append(')');
		return result.toString();
	}

	@Override
	public String getType() {
		return "Wireframe";
	}

} // PanelImpl
