/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.documentexport.documentTemplate.renderers.specialRenderers.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.documentexport.documentTemplate.Template;
import org.unicase.documentexport.documentTemplate.renderers.options.OptionsFactory;
import org.unicase.documentexport.documentTemplate.renderers.options.TextOption;
import org.unicase.documentexport.documentTemplate.renderers.specialRenderers.MeetingRenderer;
import org.unicase.documentexport.documentTemplate.renderers.specialRenderers.MilestoneRenderer;
import org.unicase.documentexport.documentTemplate.renderers.specialRenderers.SpecialRenderersFactory;
import org.unicase.documentexport.documentTemplate.renderers.specialRenderers.SpecialRenderersPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SpecialRenderersFactoryImpl extends EFactoryImpl implements SpecialRenderersFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SpecialRenderersFactory init() {
		try {
			SpecialRenderersFactory theSpecialRenderersFactory = (SpecialRenderersFactory)EPackage.Registry.INSTANCE.getEFactory("http://unicase.org/documentExport/documentTemplate/renderers/specialRenderers"); 
			if (theSpecialRenderersFactory != null) {
				return theSpecialRenderersFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SpecialRenderersFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecialRenderersFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SpecialRenderersPackage.MEETING_RENDERER: return createMeetingRenderer();
			case SpecialRenderersPackage.MILESTONE_RENDERER: return createMilestoneRenderer();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeetingRenderer createMeetingRenderer() {
		MeetingRendererImpl meetingRenderer = new MeetingRendererImpl();
		return meetingRenderer;
	}

	/**
	 * @generated NOT
	 */
	public MeetingRenderer createMeetingRenderer(Template template) {
		MeetingRendererImpl meetingRenderer = new MeetingRendererImpl();
		meetingRenderer.setTemplate(template);
		TextOption workItemTextOption = OptionsFactory.eINSTANCE.createTextOption();
		workItemTextOption.setName("workItem");
		meetingRenderer.getRendererOptions().add(workItemTextOption);
		return meetingRenderer;
	}

	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MilestoneRenderer createMilestoneRenderer() {
		MilestoneRendererImpl milestoneRenderer = new MilestoneRendererImpl();
		return milestoneRenderer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecialRenderersPackage getSpecialRenderersPackage() {
		return (SpecialRenderersPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SpecialRenderersPackage getPackage() {
		return SpecialRenderersPackage.eINSTANCE;
	}

} //SpecialRenderersFactoryImpl
