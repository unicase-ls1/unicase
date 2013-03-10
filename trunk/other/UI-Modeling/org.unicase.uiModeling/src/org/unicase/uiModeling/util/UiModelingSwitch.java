/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.unicase.model.Attachment;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.uiModeling.*;
import org.unicase.uiModeling.Button;
import org.unicase.uiModeling.Checkbox;
import org.unicase.uiModeling.CheckboxGroup;
import org.unicase.uiModeling.DropdownItem;
import org.unicase.uiModeling.DropdownList;
import org.unicase.uiModeling.Image;
import org.unicase.uiModeling.ImageButton;
import org.unicase.uiModeling.Label;
import org.unicase.uiModeling.Panel;
import org.unicase.uiModeling.RadioButton;
import org.unicase.uiModeling.RadioGroup;
import org.unicase.uiModeling.Storyboard;
import org.unicase.uiModeling.Text;
import org.unicase.uiModeling.TextField;
import org.unicase.uiModeling.UiModelingPackage;
import org.unicase.uiModeling.Widget;
import org.unicase.uiModeling.Window;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * @see org.unicase.uiModeling.UiModelingPackage
 * @generated
 */
public class UiModelingSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static UiModelingPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UiModelingSwitch() {
		if (modelPackage == null) {
			modelPackage = UiModelingPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case UiModelingPackage.STORYBOARD: {
				Storyboard storyboard = (Storyboard)theEObject;
				T result = caseStoryboard(storyboard);
				if (result == null) result = caseMEDiagram(storyboard);
				if (result == null) result = caseAttachment(storyboard);
				if (result == null) result = caseUnicaseModelElement(storyboard);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiModelingPackage.PANEL: {
				Panel panel = (Panel)theEObject;
				T result = casePanel(panel);
				if (result == null) result = caseMEDiagram(panel);
				if (result == null) result = caseAttachment(panel);
				if (result == null) result = caseUnicaseModelElement(panel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiModelingPackage.WIDGET: {
				Widget widget = (Widget)theEObject;
				T result = caseWidget(widget);
				if (result == null) result = caseUnicaseModelElement(widget);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiModelingPackage.WINDOW: {
				Window window = (Window)theEObject;
				T result = caseWindow(window);
				if (result == null) result = caseWidget(window);
				if (result == null) result = caseUnicaseModelElement(window);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiModelingPackage.LABEL: {
				Label label = (Label)theEObject;
				T result = caseLabel(label);
				if (result == null) result = caseWidget(label);
				if (result == null) result = caseUnicaseModelElement(label);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiModelingPackage.TEXT_FIELD: {
				TextField textField = (TextField)theEObject;
				T result = caseTextField(textField);
				if (result == null) result = caseWidget(textField);
				if (result == null) result = caseUnicaseModelElement(textField);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiModelingPackage.BUTTON: {
				Button button = (Button)theEObject;
				T result = caseButton(button);
				if (result == null) result = caseWidget(button);
				if (result == null) result = caseUnicaseModelElement(button);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiModelingPackage.TEXT: {
				Text text = (Text)theEObject;
				T result = caseText(text);
				if (result == null) result = caseWidget(text);
				if (result == null) result = caseUnicaseModelElement(text);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiModelingPackage.IMAGE: {
				Image image = (Image)theEObject;
				T result = caseImage(image);
				if (result == null) result = caseWidget(image);
				if (result == null) result = caseUnicaseModelElement(image);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiModelingPackage.RADIO_GROUP: {
				RadioGroup radioGroup = (RadioGroup)theEObject;
				T result = caseRadioGroup(radioGroup);
				if (result == null) result = caseWidget(radioGroup);
				if (result == null) result = caseUnicaseModelElement(radioGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiModelingPackage.RADIO_BUTTON: {
				RadioButton radioButton = (RadioButton)theEObject;
				T result = caseRadioButton(radioButton);
				if (result == null) result = caseUnicaseModelElement(radioButton);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiModelingPackage.CHECKBOX_GROUP: {
				CheckboxGroup checkboxGroup = (CheckboxGroup)theEObject;
				T result = caseCheckboxGroup(checkboxGroup);
				if (result == null) result = caseWidget(checkboxGroup);
				if (result == null) result = caseUnicaseModelElement(checkboxGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiModelingPackage.CHECKBOX: {
				Checkbox checkbox = (Checkbox)theEObject;
				T result = caseCheckbox(checkbox);
				if (result == null) result = caseUnicaseModelElement(checkbox);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiModelingPackage.DROPDOWN_LIST: {
				DropdownList dropdownList = (DropdownList)theEObject;
				T result = caseDropdownList(dropdownList);
				if (result == null) result = caseWidget(dropdownList);
				if (result == null) result = caseUnicaseModelElement(dropdownList);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiModelingPackage.DROPDOWN_ITEM: {
				DropdownItem dropdownItem = (DropdownItem)theEObject;
				T result = caseDropdownItem(dropdownItem);
				if (result == null) result = caseUnicaseModelElement(dropdownItem);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case UiModelingPackage.IMAGE_BUTTON: {
				ImageButton imageButton = (ImageButton)theEObject;
				T result = caseImageButton(imageButton);
				if (result == null) result = caseButton(imageButton);
				if (result == null) result = caseWidget(imageButton);
				if (result == null) result = caseUnicaseModelElement(imageButton);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Storyboard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Storyboard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStoryboard(Storyboard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Panel</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Panel</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePanel(Panel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Widget</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Widget</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWidget(Widget object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Window</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Window</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseWindow(Window object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabel(Label object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text Field</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text Field</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTextField(TextField object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Button</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Button</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseButton(Button object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Text</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Text</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseText(Text object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImage(Image object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Radio Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Radio Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRadioGroup(RadioGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Radio Button</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Radio Button</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRadioButton(RadioButton object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Checkbox Group</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Checkbox Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCheckboxGroup(CheckboxGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Checkbox</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Checkbox</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCheckbox(Checkbox object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dropdown List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dropdown List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDropdownList(DropdownList object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dropdown Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dropdown Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDropdownItem(DropdownItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Image Button</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Image Button</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImageButton(ImageButton object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unicase Model Element</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unicase Model Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnicaseModelElement(UnicaseModelElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attachment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attachment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttachment(Attachment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>ME Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>ME Diagram</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMEDiagram(MEDiagram object) {
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
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} // UiModelingSwitch
