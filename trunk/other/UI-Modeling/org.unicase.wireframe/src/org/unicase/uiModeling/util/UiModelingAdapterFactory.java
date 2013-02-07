/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.unicase.model.Attachment;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.MEDiagram;
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
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.uiModeling.UiModelingPackage
 * @generated
 */
public class UiModelingAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static UiModelingPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UiModelingAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = UiModelingPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UiModelingSwitch<Adapter> modelSwitch =
		new UiModelingSwitch<Adapter>() {
			@Override
			public Adapter caseStoryboard(Storyboard object) {
				return createStoryboardAdapter();
			}
			@Override
			public Adapter casePanel(Panel object) {
				return createPanelAdapter();
			}
			@Override
			public Adapter caseWidget(Widget object) {
				return createWidgetAdapter();
			}
			@Override
			public Adapter caseWindow(Window object) {
				return createWindowAdapter();
			}
			@Override
			public Adapter caseLabel(Label object) {
				return createLabelAdapter();
			}
			@Override
			public Adapter caseTextField(TextField object) {
				return createTextFieldAdapter();
			}
			@Override
			public Adapter caseButton(Button object) {
				return createButtonAdapter();
			}
			@Override
			public Adapter caseText(Text object) {
				return createTextAdapter();
			}
			@Override
			public Adapter caseImage(Image object) {
				return createImageAdapter();
			}
			@Override
			public Adapter caseRadioGroup(RadioGroup object) {
				return createRadioGroupAdapter();
			}
			@Override
			public Adapter caseRadioButton(RadioButton object) {
				return createRadioButtonAdapter();
			}
			@Override
			public Adapter caseCheckboxGroup(CheckboxGroup object) {
				return createCheckboxGroupAdapter();
			}
			@Override
			public Adapter caseCheckbox(Checkbox object) {
				return createCheckboxAdapter();
			}
			@Override
			public Adapter caseDropdownList(DropdownList object) {
				return createDropdownListAdapter();
			}
			@Override
			public Adapter caseDropdownItem(DropdownItem object) {
				return createDropdownItemAdapter();
			}
			@Override
			public Adapter caseImageButton(ImageButton object) {
				return createImageButtonAdapter();
			}
			@Override
			public Adapter caseUnicaseModelElement(UnicaseModelElement object) {
				return createUnicaseModelElementAdapter();
			}
			@Override
			public Adapter caseAttachment(Attachment object) {
				return createAttachmentAdapter();
			}
			@Override
			public Adapter caseMEDiagram(MEDiagram object) {
				return createMEDiagramAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.uiModeling.Storyboard <em>Storyboard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.uiModeling.Storyboard
	 * @generated
	 */
	public Adapter createStoryboardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.uiModeling.Panel <em>Panel</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.uiModeling.Panel
	 * @generated
	 */
	public Adapter createPanelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.uiModeling.Widget <em>Widget</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.uiModeling.Widget
	 * @generated
	 */
	public Adapter createWidgetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.uiModeling.Window <em>Window</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.uiModeling.Window
	 * @generated
	 */
	public Adapter createWindowAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.uiModeling.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.uiModeling.Label
	 * @generated
	 */
	public Adapter createLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.uiModeling.TextField <em>Text Field</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.uiModeling.TextField
	 * @generated
	 */
	public Adapter createTextFieldAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.uiModeling.Button <em>Button</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.uiModeling.Button
	 * @generated
	 */
	public Adapter createButtonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.uiModeling.Text <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.uiModeling.Text
	 * @generated
	 */
	public Adapter createTextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.uiModeling.Image <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.uiModeling.Image
	 * @generated
	 */
	public Adapter createImageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.uiModeling.RadioGroup <em>Radio Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.uiModeling.RadioGroup
	 * @generated
	 */
	public Adapter createRadioGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.uiModeling.RadioButton <em>Radio Button</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.uiModeling.RadioButton
	 * @generated
	 */
	public Adapter createRadioButtonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.uiModeling.CheckboxGroup <em>Checkbox Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.uiModeling.CheckboxGroup
	 * @generated
	 */
	public Adapter createCheckboxGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.uiModeling.Checkbox <em>Checkbox</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.uiModeling.Checkbox
	 * @generated
	 */
	public Adapter createCheckboxAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.uiModeling.DropdownList <em>Dropdown List</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.uiModeling.DropdownList
	 * @generated
	 */
	public Adapter createDropdownListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.uiModeling.DropdownItem <em>Dropdown Item</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.uiModeling.DropdownItem
	 * @generated
	 */
	public Adapter createDropdownItemAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.uiModeling.ImageButton <em>Image Button</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.uiModeling.ImageButton
	 * @generated
	 */
	public Adapter createImageButtonAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.model.UnicaseModelElement <em>Unicase Model Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.model.UnicaseModelElement
	 * @generated
	 */
	public Adapter createUnicaseModelElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.model.Attachment <em>Attachment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.model.Attachment
	 * @generated
	 */
	public Adapter createAttachmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.model.diagram.MEDiagram <em>ME Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.model.diagram.MEDiagram
	 * @generated
	 */
	public Adapter createMEDiagramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //UiModelingAdapterFactory
