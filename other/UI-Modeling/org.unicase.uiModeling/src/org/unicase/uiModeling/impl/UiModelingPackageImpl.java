/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.uiModeling.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.unicase.model.ModelPackage;
import org.unicase.model.diagram.DiagramPackage;
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
import org.unicase.uiModeling.UiModelingFactory;
import org.unicase.uiModeling.UiModelingPackage;
import org.unicase.uiModeling.Widget;
import org.unicase.uiModeling.Window;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class UiModelingPackageImpl extends EPackageImpl implements UiModelingPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass storyboardEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass panelEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass widgetEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass windowEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labelEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textFieldEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass buttonEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass textEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass radioGroupEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass radioButtonEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkboxGroupEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkboxEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dropdownListEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dropdownItemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass imageButtonEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.unicase.uiModeling.UiModelingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UiModelingPackageImpl() {
		super(eNS_URI, UiModelingFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link UiModelingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UiModelingPackage init() {
		if (isInited) return (UiModelingPackage)EPackage.Registry.INSTANCE.getEPackage(UiModelingPackage.eNS_URI);

		// Obtain or create and register package
		UiModelingPackageImpl theUiModelingPackage = (UiModelingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UiModelingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UiModelingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		DiagramPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theUiModelingPackage.createPackageContents();

		// Initialize created meta-data
		theUiModelingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUiModelingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UiModelingPackage.eNS_URI, theUiModelingPackage);
		return theUiModelingPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStoryboard() {
		return storyboardEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getStoryboard_Panels() {
		return (EReference)storyboardEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPanel() {
		return panelEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPanel_Storyboard() {
		return (EReference)panelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPanel_X() {
		return (EAttribute)panelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPanel_Y() {
		return (EAttribute)panelEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPanel_Width() {
		return (EAttribute)panelEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPanel_Height() {
		return (EAttribute)panelEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPanel_Widgets() {
		return (EReference)panelEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPanel_PositioningEnabled() {
		return (EAttribute)panelEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPanel_SizingEnabled() {
		return (EAttribute)panelEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPanel_LayoutEnabled() {
		return (EAttribute)panelEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWidget() {
		return widgetEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidget_X() {
		return (EAttribute)widgetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidget_Y() {
		return (EAttribute)widgetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidget_Width() {
		return (EAttribute)widgetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidget_Height() {
		return (EAttribute)widgetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getWidget_Text() {
		return (EAttribute)widgetEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWidget_Panel() {
		return (EReference)widgetEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWindow() {
		return windowEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getWindow_Widgets() {
		return (EReference)windowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLabel() {
		return labelEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTextField() {
		return textFieldEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getButton() {
		return buttonEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getText() {
		return textEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImage() {
		return imageEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImage_ImageURL() {
		return (EAttribute)imageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRadioGroup() {
		return radioGroupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRadioGroup_Buttons() {
		return (EReference)radioGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRadioGroup_SelectedItem() {
		return (EReference)radioGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRadioButton() {
		return radioButtonEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRadioButton_Text() {
		return (EAttribute)radioButtonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRadioButton_Group() {
		return (EReference)radioButtonEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckboxGroup() {
		return checkboxGroupEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckboxGroup_Boxes() {
		return (EReference)checkboxGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCheckbox() {
		return checkboxEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCheckbox_Group() {
		return (EReference)checkboxEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheckbox_Text() {
		return (EAttribute)checkboxEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCheckbox_Checked() {
		return (EAttribute)checkboxEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDropdownList() {
		return dropdownListEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDropdownList_SelectedIndex() {
		return (EAttribute)dropdownListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDropdownList_Items() {
		return (EReference)dropdownListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDropdownItem() {
		return dropdownItemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDropdownItem_List() {
		return (EReference)dropdownItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImageButton() {
		return imageButtonEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImageButton_ImageURL() {
		return (EAttribute)imageButtonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UiModelingFactory getUiModelingFactory() {
		return (UiModelingFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		storyboardEClass = createEClass(STORYBOARD);
		createEReference(storyboardEClass, STORYBOARD__PANELS);

		panelEClass = createEClass(PANEL);
		createEReference(panelEClass, PANEL__STORYBOARD);
		createEAttribute(panelEClass, PANEL__X);
		createEAttribute(panelEClass, PANEL__Y);
		createEAttribute(panelEClass, PANEL__WIDTH);
		createEAttribute(panelEClass, PANEL__HEIGHT);
		createEReference(panelEClass, PANEL__WIDGETS);
		createEAttribute(panelEClass, PANEL__POSITIONING_ENABLED);
		createEAttribute(panelEClass, PANEL__SIZING_ENABLED);
		createEAttribute(panelEClass, PANEL__LAYOUT_ENABLED);

		widgetEClass = createEClass(WIDGET);
		createEAttribute(widgetEClass, WIDGET__X);
		createEAttribute(widgetEClass, WIDGET__Y);
		createEAttribute(widgetEClass, WIDGET__WIDTH);
		createEAttribute(widgetEClass, WIDGET__HEIGHT);
		createEAttribute(widgetEClass, WIDGET__TEXT);
		createEReference(widgetEClass, WIDGET__PANEL);

		windowEClass = createEClass(WINDOW);
		createEReference(windowEClass, WINDOW__WIDGETS);

		labelEClass = createEClass(LABEL);

		textFieldEClass = createEClass(TEXT_FIELD);

		buttonEClass = createEClass(BUTTON);

		textEClass = createEClass(TEXT);

		imageEClass = createEClass(IMAGE);
		createEAttribute(imageEClass, IMAGE__IMAGE_URL);

		radioGroupEClass = createEClass(RADIO_GROUP);
		createEReference(radioGroupEClass, RADIO_GROUP__BUTTONS);
		createEReference(radioGroupEClass, RADIO_GROUP__SELECTED_ITEM);

		radioButtonEClass = createEClass(RADIO_BUTTON);
		createEAttribute(radioButtonEClass, RADIO_BUTTON__TEXT);
		createEReference(radioButtonEClass, RADIO_BUTTON__GROUP);

		checkboxGroupEClass = createEClass(CHECKBOX_GROUP);
		createEReference(checkboxGroupEClass, CHECKBOX_GROUP__BOXES);

		checkboxEClass = createEClass(CHECKBOX);
		createEReference(checkboxEClass, CHECKBOX__GROUP);
		createEAttribute(checkboxEClass, CHECKBOX__TEXT);
		createEAttribute(checkboxEClass, CHECKBOX__CHECKED);

		dropdownListEClass = createEClass(DROPDOWN_LIST);
		createEAttribute(dropdownListEClass, DROPDOWN_LIST__SELECTED_INDEX);
		createEReference(dropdownListEClass, DROPDOWN_LIST__ITEMS);

		dropdownItemEClass = createEClass(DROPDOWN_ITEM);
		createEReference(dropdownItemEClass, DROPDOWN_ITEM__LIST);

		imageButtonEClass = createEClass(IMAGE_BUTTON);
		createEAttribute(imageButtonEClass, IMAGE_BUTTON__IMAGE_URL);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		DiagramPackage theDiagramPackage = (DiagramPackage)EPackage.Registry.INSTANCE.getEPackage(DiagramPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		ModelPackage theModelPackage = (ModelPackage)EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		storyboardEClass.getESuperTypes().add(theDiagramPackage.getMEDiagram());
		panelEClass.getESuperTypes().add(theDiagramPackage.getMEDiagram());
		widgetEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
		windowEClass.getESuperTypes().add(this.getWidget());
		labelEClass.getESuperTypes().add(this.getWidget());
		textFieldEClass.getESuperTypes().add(this.getWidget());
		buttonEClass.getESuperTypes().add(this.getWidget());
		textEClass.getESuperTypes().add(this.getWidget());
		imageEClass.getESuperTypes().add(this.getWidget());
		radioGroupEClass.getESuperTypes().add(this.getWidget());
		radioButtonEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
		checkboxGroupEClass.getESuperTypes().add(this.getWidget());
		checkboxEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
		dropdownListEClass.getESuperTypes().add(this.getWidget());
		dropdownItemEClass.getESuperTypes().add(theModelPackage.getUnicaseModelElement());
		imageButtonEClass.getESuperTypes().add(this.getButton());

		// Initialize classes and features; add operations and parameters
		initEClass(storyboardEClass, Storyboard.class, "Storyboard", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStoryboard_Panels(), this.getPanel(), this.getPanel_Storyboard(), "panels", null, 0, -1, Storyboard.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(panelEClass, Panel.class, "Panel", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPanel_Storyboard(), this.getStoryboard(), this.getStoryboard_Panels(), "storyboard", null, 0, 1, Panel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPanel_X(), ecorePackage.getEInt(), "x", null, 0, 1, Panel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPanel_Y(), ecorePackage.getEInt(), "y", null, 0, 1, Panel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPanel_Width(), theEcorePackage.getEInt(), "width", null, 0, 1, Panel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPanel_Height(), theEcorePackage.getEInt(), "height", null, 0, 1, Panel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPanel_Widgets(), this.getWidget(), this.getWidget_Panel(), "widgets", null, 0, -1, Panel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPanel_PositioningEnabled(), theEcorePackage.getEBoolean(), "positioningEnabled", "true", 0, 1, Panel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPanel_SizingEnabled(), theEcorePackage.getEBoolean(), "sizingEnabled", "true", 0, 1, Panel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPanel_LayoutEnabled(), theEcorePackage.getEBoolean(), "layoutEnabled", "true", 0, 1, Panel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(widgetEClass, Widget.class, "Widget", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWidget_X(), ecorePackage.getEInt(), "x", "-1", 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWidget_Y(), ecorePackage.getEInt(), "y", "-1", 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWidget_Width(), ecorePackage.getEInt(), "width", "-1", 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWidget_Height(), ecorePackage.getEInt(), "height", "-1", 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWidget_Text(), ecorePackage.getEString(), "text", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getWidget_Panel(), this.getPanel(), this.getPanel_Widgets(), "panel", null, 0, 1, Widget.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(windowEClass, Window.class, "Window", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getWindow_Widgets(), this.getWidget(), null, "widgets", null, 0, -1, Window.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(labelEClass, Label.class, "Label", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(textFieldEClass, TextField.class, "TextField", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(buttonEClass, Button.class, "Button", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(textEClass, Text.class, "Text", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(imageEClass, Image.class, "Image", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImage_ImageURL(), theEcorePackage.getEString(), "imageURL", null, 0, 1, Image.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(radioGroupEClass, RadioGroup.class, "RadioGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRadioGroup_Buttons(), this.getRadioButton(), this.getRadioButton_Group(), "buttons", null, 0, -1, RadioGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRadioGroup_SelectedItem(), this.getRadioButton(), null, "selectedItem", null, 0, 1, RadioGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(radioButtonEClass, RadioButton.class, "RadioButton", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRadioButton_Text(), theEcorePackage.getEString(), "text", null, 0, 1, RadioButton.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRadioButton_Group(), this.getRadioGroup(), this.getRadioGroup_Buttons(), "group", null, 0, 1, RadioButton.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(checkboxGroupEClass, CheckboxGroup.class, "CheckboxGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCheckboxGroup_Boxes(), this.getCheckbox(), this.getCheckbox_Group(), "boxes", null, 0, -1, CheckboxGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(checkboxEClass, Checkbox.class, "Checkbox", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCheckbox_Group(), this.getCheckboxGroup(), this.getCheckboxGroup_Boxes(), "group", null, 0, 1, Checkbox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCheckbox_Text(), theEcorePackage.getEString(), "text", null, 0, 1, Checkbox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCheckbox_Checked(), theEcorePackage.getEBoolean(), "checked", "", 0, 1, Checkbox.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dropdownListEClass, DropdownList.class, "DropdownList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDropdownList_SelectedIndex(), theEcorePackage.getEInt(), "selectedIndex", "-1", 0, 1, DropdownList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDropdownList_Items(), this.getDropdownItem(), this.getDropdownItem_List(), "items", null, 0, -1, DropdownList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dropdownItemEClass, DropdownItem.class, "DropdownItem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDropdownItem_List(), this.getDropdownList(), this.getDropdownList_Items(), "list", null, 0, 1, DropdownItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(imageButtonEClass, ImageButton.class, "ImageButton", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImageButton_ImageURL(), theEcorePackage.getEString(), "imageURL", null, 0, 1, ImageButton.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // UiModelingPackageImpl
