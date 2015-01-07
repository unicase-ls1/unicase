/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.model.diagram.ActivityDiagram;
import org.unicase.model.diagram.ClassDiagram;
import org.unicase.model.diagram.ComponentDiagram;
import org.unicase.model.diagram.DiagramFactory;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MERelativeBendpoints;
import org.unicase.model.diagram.StateDiagram;
import org.unicase.model.diagram.UseCaseDiagram;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class DiagramFactoryImpl extends EFactoryImpl implements DiagramFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static DiagramFactory init() {
		try {
			DiagramFactory theDiagramFactory = (DiagramFactory) EPackage.Registry.INSTANCE
					.getEFactory(DiagramPackage.eNS_URI);
			if (theDiagramFactory != null) {
				return theDiagramFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DiagramFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case DiagramPackage.CLASS_DIAGRAM:
			return createClassDiagram();
		case DiagramPackage.USE_CASE_DIAGRAM:
			return createUseCaseDiagram();
		case DiagramPackage.COMPONENT_DIAGRAM:
			return createComponentDiagram();
		case DiagramPackage.STATE_DIAGRAM:
			return createStateDiagram();
		case DiagramPackage.ACTIVITY_DIAGRAM:
			return createActivityDiagram();
		case DiagramPackage.ME_RELATIVE_BENDPOINTS:
			return createMERelativeBendpoints();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName()
					+ "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
		case DiagramPackage.ME_RELATIVE_BENDPOINT:
			return createMERelativeBendpointFromString(eDataType, initialValue);
		default:
			throw new IllegalArgumentException("The datatype '"
					+ eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
		case DiagramPackage.ME_RELATIVE_BENDPOINT:
			return convertMERelativeBendpointToString(eDataType, instanceValue);
		default:
			throw new IllegalArgumentException("The datatype '"
					+ eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ClassDiagram createClassDiagram() {
		ClassDiagramImpl classDiagram = new ClassDiagramImpl();
		return classDiagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UseCaseDiagram createUseCaseDiagram() {
		UseCaseDiagramImpl useCaseDiagram = new UseCaseDiagramImpl();
		return useCaseDiagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentDiagram createComponentDiagram() {
		ComponentDiagramImpl componentDiagram = new ComponentDiagramImpl();
		return componentDiagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public StateDiagram createStateDiagram() {
		StateDiagramImpl stateDiagram = new StateDiagramImpl();
		return stateDiagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ActivityDiagram createActivityDiagram() {
		ActivityDiagramImpl activityDiagram = new ActivityDiagramImpl();
		return activityDiagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MERelativeBendpoints createMERelativeBendpoints() {
		MERelativeBendpointsImpl meRelativeBendpoints = new MERelativeBendpointsImpl();
		return meRelativeBendpoints;
	}

	/**
	 * Creates a {@link MERelativeBendpoint} from its string representation.
	 * 
	 * @param eDataType the {@link EDataType} corresponding to the bendpoint
	 * @param initialValue the string representation of the bendpoint
	 * @return the newly created bendpoint
	 * @generated NOT
	 */
	public MERelativeBendpoint createMERelativeBendpointFromString(
			EDataType eDataType, String initialValue) {
		String[] coordinates = initialValue.split(",");
		if (coordinates.length == 4) {
			Integer sourceX = Integer.parseInt(coordinates[0]);
			Integer sourceY = Integer.parseInt(coordinates[1]);
			Integer targetX = Integer.parseInt(coordinates[2]);
			Integer targetY = Integer.parseInt(coordinates[3]);
			return new MERelativeBendpoint(sourceX, sourceY, targetX, targetY);
		}
		return (MERelativeBendpoint) super.createFromString(eDataType,
				initialValue);
	}

	/**
	 * Converts a {@link MERelativeBendpoint} into its string representation.
	 * 
	 * @param eDataType the {@link EDataType} corresponding to the bendpoint
	 * @param instanceValue the bendpoint instance to convert
	 * @return the string representation of <code>instanceValue</code>
	 * @generated NOT
	 */
	public String convertMERelativeBendpointToString(EDataType eDataType,
			Object instanceValue) {
		if (instanceValue instanceof MERelativeBendpoint) {
			MERelativeBendpoint point = (MERelativeBendpoint) instanceValue;
			StringBuffer result = new StringBuffer(super.toString());
			result.append(point.getSourceX());
			result.append(",");
			result.append(point.getSourceY());
			result.append(",");
			result.append(point.getTargetX());
			result.append(",");
			result.append(point.getTargetY());
			return result.toString();
		}
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public DiagramPackage getDiagramPackage() {
		return (DiagramPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DiagramPackage getPackage() {
		return DiagramPackage.eINSTANCE;
	}

} // DiagramFactoryImpl
