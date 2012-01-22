/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package humanbodymodel.impl;

import humanbodymodel.HumanContainer;
import humanbodymodel.HumanLink;
import humanbodymodel.HumanbodymodelPackage;
import humanbodymodel.PositionedElement;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Human Container</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link humanbodymodel.impl.HumanContainerImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link humanbodymodel.impl.HumanContainerImpl#getLinks <em>Links</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HumanContainerImpl extends EObjectImpl implements HumanContainer {
	/**
	 * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElements()
	 * @generated
	 * @ordered
	 */
	protected EList<PositionedElement> elements;

	/**
	 * The cached value of the '{@link #getLinks() <em>Links</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLinks()
	 * @generated
	 * @ordered
	 */
	protected EList<HumanLink> links;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HumanContainerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return HumanbodymodelPackage.Literals.HUMAN_CONTAINER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PositionedElement> getElements() {
		if (elements == null) {
			elements = new EObjectContainmentEList<PositionedElement>(PositionedElement.class, this, HumanbodymodelPackage.HUMAN_CONTAINER__ELEMENTS);
		}
		return elements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<HumanLink> getLinks() {
		if (links == null) {
			links = new EObjectResolvingEList<HumanLink>(HumanLink.class, this, HumanbodymodelPackage.HUMAN_CONTAINER__LINKS);
		}
		return links;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case HumanbodymodelPackage.HUMAN_CONTAINER__ELEMENTS:
				return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
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
			case HumanbodymodelPackage.HUMAN_CONTAINER__ELEMENTS:
				return getElements();
			case HumanbodymodelPackage.HUMAN_CONTAINER__LINKS:
				return getLinks();
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
			case HumanbodymodelPackage.HUMAN_CONTAINER__ELEMENTS:
				getElements().clear();
				getElements().addAll((Collection<? extends PositionedElement>)newValue);
				return;
			case HumanbodymodelPackage.HUMAN_CONTAINER__LINKS:
				getLinks().clear();
				getLinks().addAll((Collection<? extends HumanLink>)newValue);
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
			case HumanbodymodelPackage.HUMAN_CONTAINER__ELEMENTS:
				getElements().clear();
				return;
			case HumanbodymodelPackage.HUMAN_CONTAINER__LINKS:
				getLinks().clear();
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
			case HumanbodymodelPackage.HUMAN_CONTAINER__ELEMENTS:
				return elements != null && !elements.isEmpty();
			case HumanbodymodelPackage.HUMAN_CONTAINER__LINKS:
				return links != null && !links.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //HumanContainerImpl
