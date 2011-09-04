/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package traceRecovery.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.impl.UnicaseModelElementImpl;

import traceRecovery.Query;
import traceRecovery.TraceRecoveryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Query</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link traceRecovery.impl.QueryImpl#getModelElement <em>Model Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QueryImpl extends UnicaseModelElementImpl implements Query {
	/**
	 * The cached value of the '{@link #getModelElement() <em>Model Element</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelElement()
	 * @generated
	 * @ordered
	 */
	protected EList<UnicaseModelElement> modelElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QueryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TraceRecoveryPackage.Literals.QUERY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnicaseModelElement> getModelElements() {
		if (modelElements == null) {
			modelElements = new EObjectResolvingEList<UnicaseModelElement>(UnicaseModelElement.class, this, TraceRecoveryPackage.QUERY__MODEL_ELEMENT);
		}
		return modelElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TraceRecoveryPackage.QUERY__MODEL_ELEMENT:
				return getModelElements();
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
			case TraceRecoveryPackage.QUERY__MODEL_ELEMENT:
				getModelElements().clear();
				getModelElements().addAll((Collection<? extends UnicaseModelElement>)newValue);
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
			case TraceRecoveryPackage.QUERY__MODEL_ELEMENT:
				getModelElements().clear();
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
			case TraceRecoveryPackage.QUERY__MODEL_ELEMENT:
				return modelElements != null && !modelElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //QueryImpl
