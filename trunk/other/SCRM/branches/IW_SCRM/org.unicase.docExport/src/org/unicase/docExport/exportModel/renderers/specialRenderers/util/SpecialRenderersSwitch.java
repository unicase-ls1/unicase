/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.specialRenderers.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.ClassAttributesRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.ClassRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.FhmMeetingRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MeetingRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MethodRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.MilestoneRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.PackageFlatRenderer;
import org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage;
import org.unicase.docExport.exportModel.renderers.specialRenderers.StepsAttributeRenderer;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage
 * @generated
 */
public class SpecialRenderersSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static SpecialRenderersPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SpecialRenderersSwitch() {
		if (modelPackage == null) {
			modelPackage = SpecialRenderersPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SpecialRenderersPackage.MEETING_RENDERER: {
				MeetingRenderer meetingRenderer = (MeetingRenderer)theEObject;
				T result = caseMeetingRenderer(meetingRenderer);
				if (result == null) result = caseModelElementRenderer(meetingRenderer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpecialRenderersPackage.MILESTONE_RENDERER: {
				MilestoneRenderer milestoneRenderer = (MilestoneRenderer)theEObject;
				T result = caseMilestoneRenderer(milestoneRenderer);
				if (result == null) result = caseModelElementRenderer(milestoneRenderer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpecialRenderersPackage.STEPS_ATTRIBUTE_RENDERER: {
				StepsAttributeRenderer stepsAttributeRenderer = (StepsAttributeRenderer)theEObject;
				T result = caseStepsAttributeRenderer(stepsAttributeRenderer);
				if (result == null) result = caseAttributeRenderer(stepsAttributeRenderer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpecialRenderersPackage.METHOD_RENDERER: {
				MethodRenderer methodRenderer = (MethodRenderer)theEObject;
				T result = caseMethodRenderer(methodRenderer);
				if (result == null) result = caseAttributeRenderer(methodRenderer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpecialRenderersPackage.PACKAGE_FLAT_RENDERER: {
				PackageFlatRenderer packageFlatRenderer = (PackageFlatRenderer)theEObject;
				T result = casePackageFlatRenderer(packageFlatRenderer);
				if (result == null) result = caseModelElementRenderer(packageFlatRenderer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpecialRenderersPackage.CLASS_RENDERER: {
				ClassRenderer classRenderer = (ClassRenderer)theEObject;
				T result = caseClassRenderer(classRenderer);
				if (result == null) result = caseModelElementRenderer(classRenderer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpecialRenderersPackage.CLASS_ATTRIBUTES_RENDERER: {
				ClassAttributesRenderer classAttributesRenderer = (ClassAttributesRenderer)theEObject;
				T result = caseClassAttributesRenderer(classAttributesRenderer);
				if (result == null) result = caseAttributeRenderer(classAttributesRenderer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SpecialRenderersPackage.FHM_MEETING_RENDERER: {
				FhmMeetingRenderer fhmMeetingRenderer = (FhmMeetingRenderer)theEObject;
				T result = caseFhmMeetingRenderer(fhmMeetingRenderer);
				if (result == null) result = caseMeetingRenderer(fhmMeetingRenderer);
				if (result == null) result = caseModelElementRenderer(fhmMeetingRenderer);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Meeting Renderer</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Meeting Renderer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeetingRenderer(MeetingRenderer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Milestone Renderer</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Milestone Renderer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMilestoneRenderer(MilestoneRenderer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Steps Attribute Renderer</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Steps Attribute Renderer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStepsAttributeRenderer(StepsAttributeRenderer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Renderer</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Renderer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodRenderer(MethodRenderer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Package Flat Renderer</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Package Flat Renderer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePackageFlatRenderer(PackageFlatRenderer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Renderer</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Renderer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassRenderer(ClassRenderer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Attributes Renderer</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Attributes Renderer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassAttributesRenderer(ClassAttributesRenderer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fhm Meeting Renderer</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fhm Meeting Renderer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFhmMeetingRenderer(FhmMeetingRenderer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Element Renderer</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Element Renderer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModelElementRenderer(ModelElementRenderer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Renderer</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Renderer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeRenderer(AttributeRenderer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch, but this is the last case
	 * anyway. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} // SpecialRenderersSwitch
