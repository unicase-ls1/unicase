/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.danger.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.model.urml.danger.DangerPackage;
import org.unicase.model.urml.danger.ProceduralMitigation;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Procedural Mitigation</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.unicase.model.urml.danger.impl.ProceduralMitigationImpl#getMitigationProcedure <em>Mitigation Procedure</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProceduralMitigationImpl extends MitigationImpl implements
		ProceduralMitigation {
	/**
	 * The default value of the '{@link #getMitigationProcedure() <em>Mitigation Procedure</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMitigationProcedure()
	 * @generated
	 * @ordered
	 */
	protected static final String MITIGATION_PROCEDURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMitigationProcedure() <em>Mitigation Procedure</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMitigationProcedure()
	 * @generated
	 * @ordered
	 */
	protected String mitigationProcedure = MITIGATION_PROCEDURE_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ProceduralMitigationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DangerPackage.Literals.PROCEDURAL_MITIGATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getMitigationProcedure() {
		return mitigationProcedure;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMitigationProcedure(String newMitigationProcedure) {
		String oldMitigationProcedure = mitigationProcedure;
		mitigationProcedure = newMitigationProcedure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					DangerPackage.PROCEDURAL_MITIGATION__MITIGATION_PROCEDURE,
					oldMitigationProcedure, mitigationProcedure));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case DangerPackage.PROCEDURAL_MITIGATION__MITIGATION_PROCEDURE:
			return getMitigationProcedure();
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
		case DangerPackage.PROCEDURAL_MITIGATION__MITIGATION_PROCEDURE:
			setMitigationProcedure((String) newValue);
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
		case DangerPackage.PROCEDURAL_MITIGATION__MITIGATION_PROCEDURE:
			setMitigationProcedure(MITIGATION_PROCEDURE_EDEFAULT);
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
		case DangerPackage.PROCEDURAL_MITIGATION__MITIGATION_PROCEDURE:
			return MITIGATION_PROCEDURE_EDEFAULT == null ? mitigationProcedure != null
					: !MITIGATION_PROCEDURE_EDEFAULT
							.equals(mitigationProcedure);
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
		result.append(" (mitigationProcedure: ");
		result.append(mitigationProcedure);
		result.append(')');
		return result.toString();
	}

} // ProceduralMitigationImpl
