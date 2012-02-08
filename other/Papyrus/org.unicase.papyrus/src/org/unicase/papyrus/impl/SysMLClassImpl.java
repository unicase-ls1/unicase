/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.uml.internal.impl.ClassImpl;
import org.unicase.papyrus.PapyrusPackage;
import org.unicase.papyrus.SysMLClass;
import org.unicase.papyrus.custom.BendpointsAdapter;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Sys ML Class</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.papyrus.impl.SysMLClassImpl#getGmfDiagram <em>Gmf Diagram</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class SysMLClassImpl extends ClassImpl implements SysMLClass {
	/**
	 * The cached value of the '{@link #getGmfDiagram() <em>Gmf Diagram</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getGmfDiagram()
	 * @generated
	 * @ordered
	 */
	protected Diagram gmfDiagram;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected SysMLClassImpl() {
		super();
		setName("new SysML Diagram");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PapyrusPackage.Literals.SYS_ML_CLASS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Diagram getGmfDiagram() {
		if (gmfDiagram != null && gmfDiagram.eIsProxy()) {
			InternalEObject oldGmfDiagram = (InternalEObject) gmfDiagram;
			gmfDiagram = (Diagram) eResolveProxy(oldGmfDiagram);
			if (gmfDiagram != oldGmfDiagram) {
				InternalEObject newGmfDiagram = (InternalEObject) gmfDiagram;
				NotificationChain msgs = oldGmfDiagram.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- PapyrusPackage.SYS_ML_CLASS__GMF_DIAGRAM, null, null);
				if (newGmfDiagram.eInternalContainer() == null) {
					msgs = newGmfDiagram.eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- PapyrusPackage.SYS_ML_CLASS__GMF_DIAGRAM, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired()) {
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PapyrusPackage.SYS_ML_CLASS__GMF_DIAGRAM,
						oldGmfDiagram, gmfDiagram));
				}
			}
		}
		return gmfDiagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Diagram basicGetGmfDiagram() {
		return gmfDiagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetGmfDiagram(Diagram newGmfDiagram, NotificationChain msgs) {
		Diagram oldGmfDiagram = gmfDiagram;
		gmfDiagram = newGmfDiagram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
				PapyrusPackage.SYS_ML_CLASS__GMF_DIAGRAM, oldGmfDiagram, newGmfDiagram);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setGmfDiagram(Diagram newGmfDiagram) {
		if (newGmfDiagram != gmfDiagram) {
			NotificationChain msgs = null;
			if (gmfDiagram != null)
				msgs = ((InternalEObject) gmfDiagram).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
					- PapyrusPackage.SYS_ML_CLASS__GMF_DIAGRAM, null, msgs);
			if (newGmfDiagram != null)
				msgs = ((InternalEObject) newGmfDiagram).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
					- PapyrusPackage.SYS_ML_CLASS__GMF_DIAGRAM, null, msgs);
			msgs = basicSetGmfDiagram(newGmfDiagram, msgs);
			if (msgs != null)
				msgs.dispatch();
			gmfDiagram.eAdapters().add(new BendpointsAdapter(gmfDiagram));
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PapyrusPackage.SYS_ML_CLASS__GMF_DIAGRAM,
				newGmfDiagram, newGmfDiagram));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case PapyrusPackage.SYS_ML_CLASS__GMF_DIAGRAM:
			return basicSetGmfDiagram(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case PapyrusPackage.SYS_ML_CLASS__GMF_DIAGRAM:
			if (resolve)
				return getGmfDiagram();
			return basicGetGmfDiagram();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case PapyrusPackage.SYS_ML_CLASS__GMF_DIAGRAM:
			setGmfDiagram((Diagram) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case PapyrusPackage.SYS_ML_CLASS__GMF_DIAGRAM:
			setGmfDiagram((Diagram) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case PapyrusPackage.SYS_ML_CLASS__GMF_DIAGRAM:
			return gmfDiagram != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @generated NOT
	 */
	@Override
	public void setName(String newName) {
		super.setName(newName);
		Diagram diagram = getGmfDiagram();
		if (diagram != null) {
			diagram.setName(newName);
		}
	}

} // SysMLClassImpl
