/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.specialRenderers;

import org.eclipse.emf.ecore.EFactory;
import org.unicase.docExport.exportModel.Template;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each non-abstract class of
 * the model. <!-- end-user-doc -->
 * 
 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage
 * @generated
 */
public interface SpecialRenderersFactory extends EFactory {
	/**
	 * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	SpecialRenderersFactory eINSTANCE = org.unicase.docExport.exportModel.renderers.specialRenderers.impl.SpecialRenderersFactoryImpl
		.init();

	/**
	 * Returns a new object of class '<em>Meeting Renderer</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Meeting Renderer</em>'.
	 * @generated
	 */
	MeetingRenderer createMeetingRenderer();

	/**
	 * Returns a new object of class '<em>Milestone Renderer</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Milestone Renderer</em>'.
	 * @generated
	 */
	MilestoneRenderer createMilestoneRenderer();

	/**
	 * Returns a new object of class '<em>Steps Attribute Renderer</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Steps Attribute Renderer</em>'.
	 * @generated
	 */
	StepsAttributeRenderer createStepsAttributeRenderer();

	/**
	 * Returns a new object of class '<em>Method Renderer</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Method Renderer</em>'.
	 * @generated
	 */
	MethodRenderer createMethodRenderer();

	/**
	 * Returns a new object of class '<em>Package Flat Renderer</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Package Flat Renderer</em>'.
	 * @generated
	 */
	PackageFlatRenderer createPackageFlatRenderer();

	/**
	 * Returns a new object of class '<em>Class Renderer</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Class Renderer</em>'.
	 * @generated
	 */
	ClassRenderer createClassRenderer();

	/**
	 * Returns a new object of class '<em>Class Attributes Renderer</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Class Attributes Renderer</em>'.
	 * @generated
	 */
	ClassAttributesRenderer createClassAttributesRenderer();

	/**
	 * Returns a new object of class '<em>Fhm Meeting Renderer</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Fhm Meeting Renderer</em>'.
	 * @generated
	 */
	FhmMeetingRenderer createFhmMeetingRenderer();

	/**
	 * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	SpecialRenderersPackage getSpecialRenderersPackage();

	// begin custom code
	public MeetingRenderer createMeetingRenderer(Template template);
	// end custom code
} // SpecialRenderersFactory
