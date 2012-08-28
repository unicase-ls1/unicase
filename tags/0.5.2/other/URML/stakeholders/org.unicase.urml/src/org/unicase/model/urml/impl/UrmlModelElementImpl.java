/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.unicase.model.impl.UnicaseModelElementImpl;
import org.unicase.model.urml.UrmlModelElement;
import org.unicase.model.urml.UrmlPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Model Element</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.urml.impl.UrmlModelElementImpl#getAssociations <em>Associations</em>}</li>
 *   <li>{@link org.unicase.model.urml.impl.UrmlModelElementImpl#isReviewed <em>Reviewed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class UrmlModelElementImpl extends UnicaseModelElementImpl
		implements UrmlModelElement {
	/**
	 * The cached value of the '{@link #getAssociations() <em>Associations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociations()
	 * @generated
	 * @ordered
	 */
	protected EList<UrmlModelElement> associations;

	/**
	 * The default value of the '{@link #isReviewed() <em>Reviewed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReviewed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REVIEWED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isReviewed() <em>Reviewed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isReviewed()
	 * @generated
	 * @ordered
	 */
	protected boolean reviewed = REVIEWED_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected UrmlModelElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UrmlPackage.Literals.URML_MODEL_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UrmlModelElement> getAssociations() {
		if (associations == null) {
			associations = new EObjectResolvingEList<UrmlModelElement>(
					UrmlModelElement.class, this,
					UrmlPackage.URML_MODEL_ELEMENT__ASSOCIATIONS);
		}
		return associations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isReviewed() {
		return reviewed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReviewed(boolean newReviewed) {
		boolean oldReviewed = reviewed;
		reviewed = newReviewed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					UrmlPackage.URML_MODEL_ELEMENT__REVIEWED, oldReviewed,
					reviewed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case UrmlPackage.URML_MODEL_ELEMENT__ASSOCIATIONS:
			return getAssociations();
		case UrmlPackage.URML_MODEL_ELEMENT__REVIEWED:
			return isReviewed();
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
		case UrmlPackage.URML_MODEL_ELEMENT__ASSOCIATIONS:
			getAssociations().clear();
			getAssociations().addAll(
					(Collection<? extends UrmlModelElement>) newValue);
			return;
		case UrmlPackage.URML_MODEL_ELEMENT__REVIEWED:
			setReviewed((Boolean) newValue);
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
		case UrmlPackage.URML_MODEL_ELEMENT__ASSOCIATIONS:
			getAssociations().clear();
			return;
		case UrmlPackage.URML_MODEL_ELEMENT__REVIEWED:
			setReviewed(REVIEWED_EDEFAULT);
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
		case UrmlPackage.URML_MODEL_ELEMENT__ASSOCIATIONS:
			return associations != null && !associations.isEmpty();
		case UrmlPackage.URML_MODEL_ELEMENT__REVIEWED:
			return reviewed != REVIEWED_EDEFAULT;
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
		result.append(" (reviewed: ");
		result.append(reviewed);
		result.append(')');
		return result.toString();
	}

} // UrmlModelElementImpl
