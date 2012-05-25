/**
 * <copyright> </copyright> $Id$
 */
package org.unicase.model.urml.impl;

import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.model.urml.*;
import org.unicase.model.urml.Stakeholder;
import org.unicase.model.urml.URMLDiagram;
import org.unicase.model.urml.UrmlFactory;
import org.unicase.model.urml.UrmlPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class UrmlFactoryImpl extends EFactoryImpl implements UrmlFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static UrmlFactory init() {
		try {
			UrmlFactory theUrmlFactory = (UrmlFactory) EPackage.Registry.INSTANCE
					.getEFactory("http://unicase.org/model/urml");
			if (theUrmlFactory != null) {
				return theUrmlFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UrmlFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UrmlFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case UrmlPackage.STAKEHOLDER:
			return createStakeholder();
		case UrmlPackage.URML_DIAGRAM:
			return createURMLDiagram();
		case UrmlPackage.STAKEHOLDER_ROLE:
			return createStakeholderRole();
		case UrmlPackage.SET_ENTRY:
			return (EObject) createSetEntry();
		case UrmlPackage.PHASE_SET_ENTRY:
			return (EObject) createPhaseSetEntry();
		case UrmlPackage.PHASE:
			return createPhase();
		case UrmlPackage.URML_PROJECT_SETTINGS:
			return createUrmlProjectSettings();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Stakeholder createStakeholder() {
		StakeholderImpl stakeholder = new StakeholderImpl();
		return stakeholder;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URMLDiagram createURMLDiagram() {
		URMLDiagramImpl urmlDiagram = new URMLDiagramImpl();
		return urmlDiagram;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StakeholderRole createStakeholderRole() {
		StakeholderRoleImpl stakeholderRole = new StakeholderRoleImpl();
		return stakeholderRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<EClass, EList<EStructuralFeature>> createSetEntry() {
		SetEntryImpl setEntry = new SetEntryImpl();
		return setEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<EClass, EList<EClass>> createPhaseSetEntry() {
		PhaseSetEntryImpl phaseSetEntry = new PhaseSetEntryImpl();
		return phaseSetEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Phase createPhase() {
		PhaseImpl phase = new PhaseImpl();
		return phase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UrmlProjectSettings createUrmlProjectSettings() {
		UrmlProjectSettingsImpl urmlProjectSettings = new UrmlProjectSettingsImpl();
		return urmlProjectSettings;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UrmlPackage getUrmlPackage() {
		return (UrmlPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UrmlPackage getPackage() {
		return UrmlPackage.eINSTANCE;
	}

} // UrmlFactoryImpl
