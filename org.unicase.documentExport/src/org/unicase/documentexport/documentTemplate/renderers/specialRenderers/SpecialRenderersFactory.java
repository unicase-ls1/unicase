/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.documentexport.documentTemplate.renderers.specialRenderers;

import org.eclipse.emf.ecore.EFactory;
import org.unicase.documentexport.documentTemplate.Template;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.documentexport.documentTemplate.renderers.specialRenderers.SpecialRenderersPackage
 * @generated
 */
public interface SpecialRenderersFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SpecialRenderersFactory eINSTANCE = org.unicase.documentexport.documentTemplate.renderers.specialRenderers.impl.SpecialRenderersFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Meeting Renderer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Meeting Renderer</em>'.
	 * @generated
	 */
	MeetingRenderer createMeetingRenderer();

	/**
	 * Returns a new object of class '<em>Milestone Renderer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Milestone Renderer</em>'.
	 * @generated
	 */
	MilestoneRenderer createMilestoneRenderer();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SpecialRenderersPackage getSpecialRenderersPackage();

	//begin custom code
	public MeetingRenderer createMeetingRenderer(Template template);
	//end custom code
} //SpecialRenderersFactory
