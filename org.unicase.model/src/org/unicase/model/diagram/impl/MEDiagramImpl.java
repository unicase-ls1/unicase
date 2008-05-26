/**
 * <copyright>
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

import org.eclipse.gmf.runtime.notation.Diagram;
import org.unicase.model.ModelElement;

import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;

import org.unicase.model.impl.ModelElementImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>ME Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.diagram.impl.MEDiagramImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.unicase.model.diagram.impl.MEDiagramImpl#getGmfdiagram <em>Gmfdiagram</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MEDiagramImpl extends ModelElementImpl implements MEDiagram {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<ModelElement> elements;

	/**
	 * The cached value of the '{@link #getGmfdiagram() <em>Gmfdiagram</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGmfdiagram()
	 * @generated
	 * @ordered
	 */
	protected Diagram gmfdiagram;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MEDiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagramPackage.Literals.ME_DIAGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ModelElement> getElements() {
		if (elements == null) {
			elements = new EObjectResolvingEList<ModelElement>(ModelElement.class, this, DiagramPackage.ME_DIAGRAM__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram getGmfdiagram() {
		return gmfdiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGmfdiagram(Diagram newGmfdiagram, NotificationChain msgs) {
		Diagram oldGmfdiagram = gmfdiagram;
		gmfdiagram = newGmfdiagram;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagramPackage.ME_DIAGRAM__GMFDIAGRAM, oldGmfdiagram, newGmfdiagram);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGmfdiagram(Diagram newGmfdiagram) {
		if (newGmfdiagram != gmfdiagram) {
			NotificationChain msgs = null;
			if (gmfdiagram != null)
				msgs = ((InternalEObject)gmfdiagram).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.ME_DIAGRAM__GMFDIAGRAM, null, msgs);
			if (newGmfdiagram != null)
				msgs = ((InternalEObject)newGmfdiagram).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagramPackage.ME_DIAGRAM__GMFDIAGRAM, null, msgs);
			msgs = basicSetGmfdiagram(newGmfdiagram, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagramPackage.ME_DIAGRAM__GMFDIAGRAM, newGmfdiagram, newGmfdiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagramPackage.ME_DIAGRAM__GMFDIAGRAM:
				return basicSetGmfdiagram(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagramPackage.ME_DIAGRAM__ELEMENTS:
				return getElements();
			case DiagramPackage.ME_DIAGRAM__GMFDIAGRAM:
				return getGmfdiagram();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DiagramPackage.ME_DIAGRAM__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends ModelElement>)newValue);
				return;
			case DiagramPackage.ME_DIAGRAM__GMFDIAGRAM:
				setGmfdiagram((Diagram)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DiagramPackage.ME_DIAGRAM__ELEMENTS:
				getElements().clear();
				return;
			case DiagramPackage.ME_DIAGRAM__GMFDIAGRAM:
				setGmfdiagram((Diagram)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DiagramPackage.ME_DIAGRAM__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case DiagramPackage.ME_DIAGRAM__GMFDIAGRAM:
				return gmfdiagram != null;
		}
		return super.eIsSet(featureID);
	}

} //MEDiagramImpl
