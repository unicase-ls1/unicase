/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.specialRenderers.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
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
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.SpecialRenderersPackage
 * @generated
 */
public class SpecialRenderersAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static SpecialRenderersPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SpecialRenderersAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SpecialRenderersPackage.eINSTANCE;
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
	protected SpecialRenderersSwitch<Adapter> modelSwitch = new SpecialRenderersSwitch<Adapter>() {
			@Override
			public Adapter caseMeetingRenderer(MeetingRenderer object) {
				return createMeetingRendererAdapter();
			}
			@Override
			public Adapter caseMilestoneRenderer(MilestoneRenderer object) {
				return createMilestoneRendererAdapter();
			}
			@Override
			public Adapter caseStepsAttributeRenderer(StepsAttributeRenderer object) {
				return createStepsAttributeRendererAdapter();
			}
			@Override
			public Adapter caseMethodRenderer(MethodRenderer object) {
				return createMethodRendererAdapter();
			}
			@Override
			public Adapter casePackageFlatRenderer(PackageFlatRenderer object) {
				return createPackageFlatRendererAdapter();
			}
			@Override
			public Adapter caseClassRenderer(ClassRenderer object) {
				return createClassRendererAdapter();
			}
			@Override
			public Adapter caseClassAttributesRenderer(ClassAttributesRenderer object) {
				return createClassAttributesRendererAdapter();
			}
			@Override
			public Adapter caseFhmMeetingRenderer(FhmMeetingRenderer object) {
				return createFhmMeetingRendererAdapter();
			}
			@Override
			public Adapter caseModelElementRenderer(ModelElementRenderer object) {
				return createModelElementRendererAdapter();
			}
			@Override
			public Adapter caseAttributeRenderer(AttributeRenderer object) {
				return createAttributeRendererAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.unicase.docExport.exportModel.renderers.specialRenderers.MeetingRenderer <em>Meeting Renderer</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.MeetingRenderer
	 * @generated
	 */
	public Adapter createMeetingRendererAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.docExport.exportModel.renderers.specialRenderers.MilestoneRenderer <em>Milestone Renderer</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.MilestoneRenderer
	 * @generated
	 */
	public Adapter createMilestoneRendererAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.docExport.exportModel.renderers.specialRenderers.StepsAttributeRenderer <em>Steps Attribute Renderer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.StepsAttributeRenderer
	 * @generated
	 */
	public Adapter createStepsAttributeRendererAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.docExport.exportModel.renderers.specialRenderers.MethodRenderer <em>Method Renderer</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.MethodRenderer
	 * @generated
	 */
	public Adapter createMethodRendererAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.docExport.exportModel.renderers.specialRenderers.PackageFlatRenderer <em>Package Flat Renderer</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.PackageFlatRenderer
	 * @generated
	 */
	public Adapter createPackageFlatRendererAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.unicase.docExport.exportModel.renderers.specialRenderers.ClassRenderer <em>Class Renderer</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.ClassRenderer
	 * @generated
	 */
	public Adapter createClassRendererAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.docExport.exportModel.renderers.specialRenderers.ClassAttributesRenderer <em>Class Attributes Renderer</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we
	 * can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.ClassAttributesRenderer
	 * @generated
	 */
	public Adapter createClassAttributesRendererAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.docExport.exportModel.renderers.specialRenderers.FhmMeetingRenderer <em>Fhm Meeting Renderer</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.specialRenderers.FhmMeetingRenderer
	 * @generated
	 */
	public Adapter createFhmMeetingRendererAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.unicase.docExport.exportModel.renderers.ModelElementRenderer <em>Model Element Renderer</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.ModelElementRenderer
	 * @generated
	 */
	public Adapter createModelElementRendererAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.unicase.docExport.exportModel.renderers.AttributeRenderer <em>Attribute Renderer</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.AttributeRenderer
	 * @generated
	 */
	public Adapter createAttributeRendererAdapter() {
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

} // SpecialRenderersAdapterFactory
