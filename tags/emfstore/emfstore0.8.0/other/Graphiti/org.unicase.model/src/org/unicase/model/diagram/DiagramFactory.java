/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.model.diagram;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * @see org.unicase.model.diagram.DiagramPackage
 * @generated
 */
public interface DiagramFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	DiagramFactory eINSTANCE = org.unicase.model.diagram.impl.DiagramFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Class Diagram</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Diagram</em>'.
	 * @generated
	 */
	ClassDiagram createClassDiagram();

	/**
	 * Returns a new object of class '<em>Use Case Diagram</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Use Case Diagram</em>'.
	 * @generated
	 */
	UseCaseDiagram createUseCaseDiagram();

	/**
	 * Returns a new object of class '<em>Component Diagram</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Diagram</em>'.
	 * @generated
	 */
	ComponentDiagram createComponentDiagram();

	/**
	 * Returns a new object of class '<em>State Diagram</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>State Diagram</em>'.
	 * @generated
	 */
	StateDiagram createStateDiagram();

	/**
	 * Returns a new object of class '<em>Activity Diagram</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Activity Diagram</em>'.
	 * @generated
	 */
	ActivityDiagram createActivityDiagram();

	/**
	 * Returns a new object of class '<em>Work Item Diagram</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Work Item Diagram</em>'.
	 * @generated
	 */
	WorkItemDiagram createWorkItemDiagram();

	/**
	 * Returns a new object of class '<em>Org Chart Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Org Chart Diagram</em>'.
	 * @generated
	 */
	OrgChartDiagram createOrgChartDiagram();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DiagramPackage getDiagramPackage();

} // DiagramFactory
