/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.model.diagram.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.impl.ModelElementImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>ME Diagram</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.diagram.impl.MEDiagramImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.unicase.model.diagram.impl.MEDiagramImpl#getGmfdiagram <em>Gmfdiagram</em>}</li>
 *   <li>{@link org.unicase.model.diagram.impl.MEDiagramImpl#getNewElements <em>New Elements</em>}</li>
 *   <li>{@link org.unicase.model.diagram.impl.MEDiagramImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MEDiagramImpl extends ModelElementImpl implements MEDiagram {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1316169257375326716L;

	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElement> elements;

	/**
	 * The cached value of the '{@link #getGmfdiagram() <em>Gmfdiagram</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getGmfdiagram()
	 * @generated
	 * @ordered
	 */
	protected Diagram gmfdiagram;

	/**
	 * The cached value of the '{@link #getNewElements() <em>New Elements</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getNewElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElement> newElements;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final DiagramType TYPE_EDEFAULT = DiagramType.CLASS_DIAGRAM;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected DiagramType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected MEDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.ME_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElement> getElements() {
		if (elements == null) {
			elements = new EObjectResolvingEList<ModelElement>(
					ModelElement.class, this,
					DiagramPackage.ME_DIAGRAM__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram getGmfdiagram() {
		if (gmfdiagram != null && gmfdiagram.eIsProxy()) {
			InternalEObject oldGmfdiagram = (InternalEObject) gmfdiagram;
			gmfdiagram = (Diagram) eResolveProxy(oldGmfdiagram);
			if (gmfdiagram != oldGmfdiagram) {
				InternalEObject newGmfdiagram = (InternalEObject) gmfdiagram;
				NotificationChain msgs = oldGmfdiagram.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- DiagramPackage.ME_DIAGRAM__GMFDIAGRAM, null,
						null);
				if (newGmfdiagram.eInternalContainer() == null) {
					msgs = newGmfdiagram.eInverseAdd(this,
							EOPPOSITE_FEATURE_BASE
									- DiagramPackage.ME_DIAGRAM__GMFDIAGRAM,
							null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							DiagramPackage.ME_DIAGRAM__GMFDIAGRAM,
							oldGmfdiagram, gmfdiagram));
			}
		}
		return gmfdiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram basicGetGmfdiagram() {
		return gmfdiagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGmfdiagram(Diagram newGmfdiagram,
			NotificationChain msgs) {
		Diagram oldGmfdiagram = gmfdiagram;
		gmfdiagram = newGmfdiagram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this,
					Notification.SET, DiagramPackage.ME_DIAGRAM__GMFDIAGRAM,
					oldGmfdiagram, newGmfdiagram);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setGmfdiagram(Diagram newGmfdiagram) {
		if (newGmfdiagram != gmfdiagram) {
			NotificationChain msgs = null;
			if (gmfdiagram != null)
				msgs = ((InternalEObject) gmfdiagram).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- DiagramPackage.ME_DIAGRAM__GMFDIAGRAM, null,
						msgs);
			if (newGmfdiagram != null)
				msgs = ((InternalEObject) newGmfdiagram).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- DiagramPackage.ME_DIAGRAM__GMFDIAGRAM, null,
						msgs);
			msgs = basicSetGmfdiagram(newGmfdiagram, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DiagramPackage.ME_DIAGRAM__GMFDIAGRAM, newGmfdiagram,
					newGmfdiagram));
	}

	
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return A DiagramNewEelementsList
	 * @generated NOT
	 */
	public EList<ModelElement> getNewElements() {

		// this line is needed in order to avoid exception when
		// initializing Teneo. Otherwise getProjects() throws an exception
		// because eContainer is null. Returning null in this case shouldn't be
		// a problem because getNewElements() is transient anyway.
		if (eContainer == null) {
			return null;
		}

		//MD: Should we cache this instance?
		return new DiagramNewElementsList(getElements(), getProject());
	}

	/**
	 * @generated
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 */
	public DiagramType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(DiagramType newType) {
		DiagramType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DiagramPackage.ME_DIAGRAM__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case DiagramPackage.ME_DIAGRAM__GMFDIAGRAM:
			return basicSetGmfdiagram(null, msgs);
		case DiagramPackage.ME_DIAGRAM__NEW_ELEMENTS:
			return ((InternalEList<?>) getNewElements()).basicRemove(otherEnd,
					msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DiagramPackage.ME_DIAGRAM__ELEMENTS:
			return getElements();
		case DiagramPackage.ME_DIAGRAM__GMFDIAGRAM:
			if (resolve)
				return getGmfdiagram();
			return basicGetGmfdiagram();
		case DiagramPackage.ME_DIAGRAM__NEW_ELEMENTS:
			return getNewElements();
		case DiagramPackage.ME_DIAGRAM__TYPE:
			return getType();
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
		case DiagramPackage.ME_DIAGRAM__ELEMENTS:
			getElements().clear();
			getElements().addAll((Collection<? extends ModelElement>) newValue);
			return;
		case DiagramPackage.ME_DIAGRAM__GMFDIAGRAM:
			setGmfdiagram((Diagram) newValue);
			return;
		case DiagramPackage.ME_DIAGRAM__NEW_ELEMENTS:
			getNewElements().clear();
			getNewElements().addAll(
					(Collection<? extends ModelElement>) newValue);
			return;
		case DiagramPackage.ME_DIAGRAM__TYPE:
			setType((DiagramType) newValue);
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
		case DiagramPackage.ME_DIAGRAM__ELEMENTS:
			getElements().clear();
			return;
		case DiagramPackage.ME_DIAGRAM__GMFDIAGRAM:
			setGmfdiagram((Diagram) null);
			return;
		case DiagramPackage.ME_DIAGRAM__NEW_ELEMENTS:
			getNewElements().clear();
			return;
		case DiagramPackage.ME_DIAGRAM__TYPE:
			setType(TYPE_EDEFAULT);
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
		case DiagramPackage.ME_DIAGRAM__ELEMENTS:
			return elements != null && !elements.isEmpty();
		case DiagramPackage.ME_DIAGRAM__GMFDIAGRAM:
			return gmfdiagram != null;
		case DiagramPackage.ME_DIAGRAM__NEW_ELEMENTS:
			return newElements != null && !newElements.isEmpty();
		case DiagramPackage.ME_DIAGRAM__TYPE:
			return type != TYPE_EDEFAULT;
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
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} // MEDiagramImpl
