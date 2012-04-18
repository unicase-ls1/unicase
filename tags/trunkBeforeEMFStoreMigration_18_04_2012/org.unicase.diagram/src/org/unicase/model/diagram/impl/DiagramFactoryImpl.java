/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.model.diagram.ActivityDiagram;
import org.unicase.model.diagram.ClassDiagram;
import org.unicase.model.diagram.ComponentDiagram;
import org.unicase.model.diagram.DiagramFactory;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.StateDiagram;
import org.unicase.model.diagram.UseCaseDiagram;
import org.unicase.model.diagram.WorkItemDiagram;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class DiagramFactoryImpl extends EFactoryImpl implements DiagramFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DiagramFactory init() {
		try {
			DiagramFactory theDiagramFactory = (DiagramFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://unicase.org/model/diagram");
			if (theDiagramFactory != null) {
				return theDiagramFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DiagramFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DiagramFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
		case DiagramPackage.WORK_ITEM_DIAGRAM:
			return createWorkItemDiagram();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ClassDiagram createClassDiagram() {
		ClassDiagramImpl classDiagram = new ClassDiagramImpl();
		return classDiagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public UseCaseDiagram createUseCaseDiagram() {
		UseCaseDiagramImpl useCaseDiagram = new UseCaseDiagramImpl();
		return useCaseDiagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ComponentDiagram createComponentDiagram() {
		ComponentDiagramImpl componentDiagram = new ComponentDiagramImpl();
		return componentDiagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public StateDiagram createStateDiagram() {
		StateDiagramImpl stateDiagram = new StateDiagramImpl();
		return stateDiagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivityDiagram createActivityDiagram() {
		ActivityDiagramImpl activityDiagram = new ActivityDiagramImpl();
		return activityDiagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public WorkItemDiagram createWorkItemDiagram() {
		WorkItemDiagramImpl workItemDiagram = new WorkItemDiagramImpl();
		return workItemDiagram;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DiagramPackage getDiagramPackage() {
		return (DiagramPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DiagramPackage getPackage() {
		return DiagramPackage.eINSTANCE;
	}

} // DiagramFactoryImpl
