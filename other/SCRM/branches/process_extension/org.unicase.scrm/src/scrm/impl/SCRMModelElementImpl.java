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
 *   <li>{@link scrm.impl.SCRMModelElementImpl#getName <em>Name</em>}</li>
 *   <li>{@link scrm.impl.SCRMModelElementImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link scrm.impl.SCRMModelElementImpl#getDisplayingDiagrams <em>Displaying Diagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SCRMModelElementImpl extends EObjectImpl implements
		SCRMModelElement {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

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
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ScrmPackage.SCRM_MODEL_ELEMENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ScrmPackage.SCRM_MODEL_ELEMENT__DESCRIPTION,
					oldDescription, description));
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
		case ScrmPackage.SCRM_MODEL_ELEMENT__NAME:
			return getName();
		case ScrmPackage.SCRM_MODEL_ELEMENT__DESCRIPTION:
			return getDescription();
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
		case ScrmPackage.SCRM_MODEL_ELEMENT__NAME:
			setName((String) newValue);
			return;
		case ScrmPackage.SCRM_MODEL_ELEMENT__DESCRIPTION:
			setDescription((String) newValue);
			return;
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
		case ScrmPackage.SCRM_MODEL_ELEMENT__NAME:
			setName(NAME_EDEFAULT);
			return;
		case ScrmPackage.SCRM_MODEL_ELEMENT__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
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
		case ScrmPackage.SCRM_MODEL_ELEMENT__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT
					.equals(name);
		case ScrmPackage.SCRM_MODEL_ELEMENT__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null
					: !DESCRIPTION_EDEFAULT.equals(description);
		case ScrmPackage.SCRM_MODEL_ELEMENT__DISPLAYING_DIAGRAMS:
			return displayingDiagrams != null && !displayingDiagrams.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //SCRMModelElementImpl
