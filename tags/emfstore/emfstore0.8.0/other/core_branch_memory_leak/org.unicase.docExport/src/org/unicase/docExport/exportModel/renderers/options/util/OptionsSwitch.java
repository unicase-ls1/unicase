/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;
import org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.BoxModelOption;
import org.unicase.docExport.exportModel.renderers.options.DateAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.docExport.exportModel.renderers.options.ListOption;
import org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;
import org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.ReferenceOption;
import org.unicase.docExport.exportModel.renderers.options.RendererOption;
import org.unicase.docExport.exportModel.renderers.options.SectionOption;
import org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.StringAttributeOption;
import org.unicase.docExport.exportModel.renderers.options.TextOption;
import org.unicase.docExport.exportModel.renderers.options.UColor;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * 
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage
 * @generated
 */
public class OptionsSwitch<T> {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static OptionsPackage modelPackage;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OptionsSwitch() {
		if (modelPackage == null) {
			modelPackage = OptionsPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that
	 * result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that
	 * result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		} else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return eSuperTypes.isEmpty() ? defaultCase(theEObject) : doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that
	 * result. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case OptionsPackage.RENDERER_OPTION: {
			RendererOption rendererOption = (RendererOption) theEObject;
			T result = caseRendererOption(rendererOption);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OptionsPackage.ATTRIBUTE_OPTION: {
			AttributeOption attributeOption = (AttributeOption) theEObject;
			T result = caseAttributeOption(attributeOption);
			if (result == null)
				result = caseRendererOption(attributeOption);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OptionsPackage.SINGLE_REFERENCE_ATTRIBUTE_OPTION: {
			SingleReferenceAttributeOption singleReferenceAttributeOption = (SingleReferenceAttributeOption) theEObject;
			T result = caseSingleReferenceAttributeOption(singleReferenceAttributeOption);
			if (result == null)
				result = caseReferenceAttributeOption(singleReferenceAttributeOption);
			if (result == null)
				result = caseAttributeOption(singleReferenceAttributeOption);
			if (result == null)
				result = caseRendererOption(singleReferenceAttributeOption);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OptionsPackage.MULTI_REFERENCE_ATTRIBUTE_OPTION: {
			MultiReferenceAttributeOption multiReferenceAttributeOption = (MultiReferenceAttributeOption) theEObject;
			T result = caseMultiReferenceAttributeOption(multiReferenceAttributeOption);
			if (result == null)
				result = caseReferenceAttributeOption(multiReferenceAttributeOption);
			if (result == null)
				result = caseAttributeOption(multiReferenceAttributeOption);
			if (result == null)
				result = caseRendererOption(multiReferenceAttributeOption);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OptionsPackage.REFERENCE_OPTION: {
			ReferenceOption referenceOption = (ReferenceOption) theEObject;
			T result = caseReferenceOption(referenceOption);
			if (result == null)
				result = caseRendererOption(referenceOption);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OptionsPackage.STRING_ATTRIBUTE_OPTION: {
			StringAttributeOption stringAttributeOption = (StringAttributeOption) theEObject;
			T result = caseStringAttributeOption(stringAttributeOption);
			if (result == null)
				result = caseAttributeOption(stringAttributeOption);
			if (result == null)
				result = caseRendererOption(stringAttributeOption);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OptionsPackage.LAYOUT_OPTIONS: {
			LayoutOptions layoutOptions = (LayoutOptions) theEObject;
			T result = caseLayoutOptions(layoutOptions);
			if (result == null)
				result = caseRendererOption(layoutOptions);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OptionsPackage.LIST_OPTION: {
			ListOption listOption = (ListOption) theEObject;
			T result = caseListOption(listOption);
			if (result == null)
				result = caseRendererOption(listOption);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OptionsPackage.TEXT_OPTION: {
			TextOption textOption = (TextOption) theEObject;
			T result = caseTextOption(textOption);
			if (result == null)
				result = caseRendererOption(textOption);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OptionsPackage.REFERENCE_ATTRIBUTE_OPTION: {
			ReferenceAttributeOption referenceAttributeOption = (ReferenceAttributeOption) theEObject;
			T result = caseReferenceAttributeOption(referenceAttributeOption);
			if (result == null)
				result = caseAttributeOption(referenceAttributeOption);
			if (result == null)
				result = caseRendererOption(referenceAttributeOption);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OptionsPackage.UCOLOR: {
			UColor uColor = (UColor) theEObject;
			T result = caseUColor(uColor);
			if (result == null)
				result = caseRendererOption(uColor);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OptionsPackage.BOX_MODEL_OPTION: {
			BoxModelOption boxModelOption = (BoxModelOption) theEObject;
			T result = caseBoxModelOption(boxModelOption);
			if (result == null)
				result = caseRendererOption(boxModelOption);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OptionsPackage.SECTION_OPTION: {
			SectionOption sectionOption = (SectionOption) theEObject;
			T result = caseSectionOption(sectionOption);
			if (result == null)
				result = caseRendererOption(sectionOption);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OptionsPackage.BOOLEAN_ATTRIBUTE_OPTION: {
			BooleanAttributeOption booleanAttributeOption = (BooleanAttributeOption) theEObject;
			T result = caseBooleanAttributeOption(booleanAttributeOption);
			if (result == null)
				result = caseAttributeOption(booleanAttributeOption);
			if (result == null)
				result = caseRendererOption(booleanAttributeOption);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case OptionsPackage.DATE_ATTRIBUTE_OPTION: {
			DateAttributeOption dateAttributeOption = (DateAttributeOption) theEObject;
			T result = caseDateAttributeOption(dateAttributeOption);
			if (result == null)
				result = caseAttributeOption(dateAttributeOption);
			if (result == null)
				result = caseRendererOption(dateAttributeOption);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Renderer Option</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Renderer Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRendererOption(RendererOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Option</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeOption(AttributeOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Reference Attribute Option</em>'.
	 * <!-- begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Reference Attribute Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleReferenceAttributeOption(SingleReferenceAttributeOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multi Reference Attribute Option</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multi Reference Attribute Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultiReferenceAttributeOption(MultiReferenceAttributeOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Option</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceOption(ReferenceOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Attribute Option</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Attribute Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringAttributeOption(StringAttributeOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Layout Options</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Layout Options</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLayoutOptions(LayoutOptions object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Option</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListOption(ListOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Option</em>'. <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextOption(TextOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Attribute Option</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Attribute Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceAttributeOption(ReferenceAttributeOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>UColor</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>UColor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUColor(UColor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Box Model Option</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Box Model Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBoxModelOption(BoxModelOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Section Option</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Section Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSectionOption(SectionOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Attribute Option</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Attribute Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanAttributeOption(BooleanAttributeOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Date Attribute Option</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Date Attribute Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDateAttributeOption(DateAttributeOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'. <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch, but this is the last case
	 * anyway. <!-- end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} // OptionsSwitch
