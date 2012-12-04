/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * @see org.unicase.docExport.exportModel.renderers.options.OptionsPackage
 * @generated
 */
public class OptionsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static OptionsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public OptionsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = OptionsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc --> This
	 * implementation returns <code>true</code> if the object is either the model's package or is an instance object of
	 * the model. <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected OptionsSwitch<Adapter> modelSwitch = new OptionsSwitch<Adapter>() {
			@Override
			public Adapter caseRendererOption(RendererOption object) {
				return createRendererOptionAdapter();
			}
			@Override
			public Adapter caseAttributeOption(AttributeOption object) {
				return createAttributeOptionAdapter();
			}
			@Override
			public Adapter caseSingleReferenceAttributeOption(SingleReferenceAttributeOption object) {
				return createSingleReferenceAttributeOptionAdapter();
			}
			@Override
			public Adapter caseMultiReferenceAttributeOption(MultiReferenceAttributeOption object) {
				return createMultiReferenceAttributeOptionAdapter();
			}
			@Override
			public Adapter caseReferenceOption(ReferenceOption object) {
				return createReferenceOptionAdapter();
			}
			@Override
			public Adapter caseStringAttributeOption(StringAttributeOption object) {
				return createStringAttributeOptionAdapter();
			}
			@Override
			public Adapter caseLayoutOptions(LayoutOptions object) {
				return createLayoutOptionsAdapter();
			}
			@Override
			public Adapter caseListOption(ListOption object) {
				return createListOptionAdapter();
			}
			@Override
			public Adapter caseTextOption(TextOption object) {
				return createTextOptionAdapter();
			}
			@Override
			public Adapter caseReferenceAttributeOption(ReferenceAttributeOption object) {
				return createReferenceAttributeOptionAdapter();
			}
			@Override
			public Adapter caseUColor(UColor object) {
				return createUColorAdapter();
			}
			@Override
			public Adapter caseBoxModelOption(BoxModelOption object) {
				return createBoxModelOptionAdapter();
			}
			@Override
			public Adapter caseSectionOption(SectionOption object) {
				return createSectionOptionAdapter();
			}
			@Override
			public Adapter caseBooleanAttributeOption(BooleanAttributeOption object) {
				return createBooleanAttributeOptionAdapter();
			}
			@Override
			public Adapter caseDateAttributeOption(DateAttributeOption object) {
				return createDateAttributeOptionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.unicase.docExport.exportModel.renderers.options.RendererOption <em>Renderer Option</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.options.RendererOption
	 * @generated
	 */
	public Adapter createRendererOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.unicase.docExport.exportModel.renderers.options.AttributeOption <em>Attribute Option</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.options.AttributeOption
	 * @generated
	 */
	public Adapter createAttributeOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption <em>Single Reference Attribute Option</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so
	 * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.options.SingleReferenceAttributeOption
	 * @generated
	 */
	public Adapter createSingleReferenceAttributeOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption <em>Multi Reference Attribute Option</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so
	 * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.options.MultiReferenceAttributeOption
	 * @generated
	 */
	public Adapter createMultiReferenceAttributeOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.unicase.docExport.exportModel.renderers.options.ReferenceOption <em>Reference Option</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.options.ReferenceOption
	 * @generated
	 */
	public Adapter createReferenceOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.docExport.exportModel.renderers.options.StringAttributeOption <em>String Attribute Option</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.options.StringAttributeOption
	 * @generated
	 */
	public Adapter createStringAttributeOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.unicase.docExport.exportModel.renderers.options.LayoutOptions <em>Layout Options</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.options.LayoutOptions
	 * @generated
	 */
	public Adapter createLayoutOptionsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.docExport.exportModel.renderers.options.ListOption <em>List Option</em>}'.
	 * <!-- begin-user-doc
	 * --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.options.ListOption
	 * @generated
	 */
	public Adapter createListOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.docExport.exportModel.renderers.options.TextOption <em>Text Option</em>}'.
	 * <!-- begin-user-doc
	 * --> This default implementation returns null so that we can easily ignore cases; it's useful to ignore a case
	 * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.options.TextOption
	 * @generated
	 */
	public Adapter createTextOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption <em>Reference Attribute Option</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.options.ReferenceAttributeOption
	 * @generated
	 */
	public Adapter createReferenceAttributeOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.docExport.exportModel.renderers.options.UColor <em>UColor</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.options.UColor
	 * @generated
	 */
	public Adapter createUColorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.unicase.docExport.exportModel.renderers.options.BoxModelOption <em>Box Model Option</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.options.BoxModelOption
	 * @generated
	 */
	public Adapter createBoxModelOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.unicase.docExport.exportModel.renderers.options.SectionOption <em>Section Option</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.options.SectionOption
	 * @generated
	 */
	public Adapter createSectionOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption <em>Boolean Attribute Option</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.options.BooleanAttributeOption
	 * @generated
	 */
	public Adapter createBooleanAttributeOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.docExport.exportModel.renderers.options.DateAttributeOption <em>Date Attribute Option</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.options.DateAttributeOption
	 * @generated
	 */
	public Adapter createDateAttributeOptionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // OptionsAdapterFactory
