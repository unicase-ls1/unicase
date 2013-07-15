/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scrm.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.unicase.model.impl.UnicaseModelElementImpl;
import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
import scrm.ScrmPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>SCRM Model Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link scrm.impl.SCRMModelElementImpl#getDisplayingDiagrams <em>Displaying Diagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SCRMModelElementImpl extends UnicaseModelElementImpl
		implements SCRMModelElement {
	/**
	 * The cached value of the '{@link #getDisplayingDiagrams() <em>Displaying Diagrams</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDisplayingDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<SCRMDiagram> displayingDiagrams;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT: added name initialization
	 */
	protected SCRMModelElementImpl() {
		super();
		name = "new " + eClass().getName();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ScrmPackage.Literals.SCRM_MODEL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SCRMDiagram> getDisplayingDiagrams() {
		if (displayingDiagrams == null) {
			displayingDiagrams = new EObjectWithInverseResolvingEList.ManyInverse<SCRMDiagram>(
					SCRMDiagram.class, this,
					ScrmPackage.SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS,
					ScrmPackage.SCRM_DIAGRAM__ELEMENTS);
		}
		return displayingDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ScrmPackage.SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getDisplayingDiagrams())
					.basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case ScrmPackage.SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS:
			return ((InternalEList<?>) getDisplayingDiagrams()).basicRemove(
					otherEnd, msgs);
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
		case ScrmPackage.SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS:
			return getDisplayingDiagrams();
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
		case ScrmPackage.SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS:
			getDisplayingDiagrams().clear();
			getDisplayingDiagrams().addAll(
					(Collection<? extends SCRMDiagram>) newValue);
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
		case ScrmPackage.SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS:
			getDisplayingDiagrams().clear();
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
		case ScrmPackage.SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS:
			return displayingDiagrams != null && !displayingDiagrams.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SCRMModelElementImpl
