/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.wireframe.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.model.impl.UnicaseModelElementImpl;
import org.unicase.wireframe.Panel;
import org.unicase.wireframe.Widget;
import org.unicase.wireframe.WireframePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Widget</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.wireframe.impl.WidgetImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.unicase.wireframe.impl.WidgetImpl#getX <em>X</em>}</li>
 *   <li>{@link org.unicase.wireframe.impl.WidgetImpl#getY <em>Y</em>}</li>
 *   <li>{@link org.unicase.wireframe.impl.WidgetImpl#getWidth <em>Width</em>}</li>
 *   <li>{@link org.unicase.wireframe.impl.WidgetImpl#getHeight <em>Height</em>}</li>
 *   <li>{@link org.unicase.wireframe.impl.WidgetImpl#getText <em>Text</em>}</li>
 *   <li>{@link org.unicase.wireframe.impl.WidgetImpl#getPanel <em>Panel</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class WidgetImpl extends UnicaseModelElementImpl implements Widget {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final long ID_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected long id = ID_EDEFAULT;

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
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int WIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected int width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected static final int HEIGHT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getHeight() <em>Height</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getHeight()
	 * @generated
	 * @ordered
	 */
	protected int height = HEIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected WidgetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WireframePackage.Literals.WIDGET;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public long getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(long newId) {
		long oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WireframePackage.WIDGET__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WireframePackage.WIDGET__X, oldX, x));
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
			eNotify(new ENotificationImpl(this, Notification.SET, WireframePackage.WIDGET__Y, oldY, y));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(int newWidth) {
		int oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WireframePackage.WIDGET__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setHeight(int newHeight) {
		int oldHeight = height;
		height = newHeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WireframePackage.WIDGET__HEIGHT, oldHeight, height));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WireframePackage.WIDGET__TEXT, oldText, text));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Panel getPanel() {
		if (eContainerFeatureID() != WireframePackage.WIDGET__PANEL)
			return null;
		return (Panel) eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Panel basicGetPanel() {
		if (eContainerFeatureID() != WireframePackage.WIDGET__PANEL)
			return null;
		return (Panel) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPanel(Panel newPanel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newPanel, WireframePackage.WIDGET__PANEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPanel(Panel newPanel) {
		if (newPanel != eInternalContainer()
			|| (eContainerFeatureID() != WireframePackage.WIDGET__PANEL && newPanel != null)) {
			if (EcoreUtil.isAncestor(this, newPanel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPanel != null)
				msgs = ((InternalEObject) newPanel).eInverseAdd(this, WireframePackage.PANEL__WIDGETS, Panel.class,
					msgs);
			msgs = basicSetPanel(newPanel, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WireframePackage.WIDGET__PANEL, newPanel, newPanel));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case WireframePackage.WIDGET__PANEL:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetPanel((Panel) otherEnd, msgs);
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
		case WireframePackage.WIDGET__PANEL:
			return basicSetPanel(null, msgs);
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
		case WireframePackage.WIDGET__PANEL:
			return eInternalContainer().eInverseRemove(this, WireframePackage.PANEL__WIDGETS, Panel.class, msgs);
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
		case WireframePackage.WIDGET__ID:
			return getId();
		case WireframePackage.WIDGET__X:
			return getX();
		case WireframePackage.WIDGET__Y:
			return getY();
		case WireframePackage.WIDGET__WIDTH:
			return getWidth();
		case WireframePackage.WIDGET__HEIGHT:
			return getHeight();
		case WireframePackage.WIDGET__TEXT:
			return getText();
		case WireframePackage.WIDGET__PANEL:
			if (resolve)
				return getPanel();
			return basicGetPanel();
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
		case WireframePackage.WIDGET__ID:
			setId((Long) newValue);
			return;
		case WireframePackage.WIDGET__X:
			setX((Integer) newValue);
			return;
		case WireframePackage.WIDGET__Y:
			setY((Integer) newValue);
			return;
		case WireframePackage.WIDGET__WIDTH:
			setWidth((Integer) newValue);
			return;
		case WireframePackage.WIDGET__HEIGHT:
			setHeight((Integer) newValue);
			return;
		case WireframePackage.WIDGET__TEXT:
			setText((String) newValue);
			return;
		case WireframePackage.WIDGET__PANEL:
			setPanel((Panel) newValue);
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
		case WireframePackage.WIDGET__ID:
			setId(ID_EDEFAULT);
			return;
		case WireframePackage.WIDGET__X:
			setX(X_EDEFAULT);
			return;
		case WireframePackage.WIDGET__Y:
			setY(Y_EDEFAULT);
			return;
		case WireframePackage.WIDGET__WIDTH:
			setWidth(WIDTH_EDEFAULT);
			return;
		case WireframePackage.WIDGET__HEIGHT:
			setHeight(HEIGHT_EDEFAULT);
			return;
		case WireframePackage.WIDGET__TEXT:
			setText(TEXT_EDEFAULT);
			return;
		case WireframePackage.WIDGET__PANEL:
			setPanel((Panel) null);
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
		case WireframePackage.WIDGET__ID:
			return id != ID_EDEFAULT;
		case WireframePackage.WIDGET__X:
			return x != X_EDEFAULT;
		case WireframePackage.WIDGET__Y:
			return y != Y_EDEFAULT;
		case WireframePackage.WIDGET__WIDTH:
			return width != WIDTH_EDEFAULT;
		case WireframePackage.WIDGET__HEIGHT:
			return height != HEIGHT_EDEFAULT;
		case WireframePackage.WIDGET__TEXT:
			return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
		case WireframePackage.WIDGET__PANEL:
			return basicGetPanel() != null;
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
		result.append(" (id: ");
		result.append(id);
		result.append(", x: ");
		result.append(x);
		result.append(", y: ");
		result.append(y);
		result.append(", width: ");
		result.append(width);
		result.append(", height: ");
		result.append(height);
		result.append(", text: ");
		result.append(text);
		result.append(')');
		return result.toString();
	}

} // WidgetImpl
