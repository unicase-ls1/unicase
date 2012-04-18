/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.unicase.docExport.exportModel.renderers.AttributeRenderer;
import org.unicase.docExport.exportModel.renderers.AttributeRendererMapping;
import org.unicase.docExport.exportModel.renderers.DocumentRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping;
import org.unicase.docExport.exportModel.renderers.RenderersPackage;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * 
 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage
 * @generated
 */
public class RenderersAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static RenderersPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RenderersAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = RenderersPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc --> This
	 * implementation returns <code>true</code> if the object is either the model's package or is an instance object of
	 * the model. <!-- end-user-doc -->
	 * 
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RenderersSwitch<Adapter> modelSwitch = new RenderersSwitch<Adapter>() {
		@Override
		public Adapter caseModelElementRenderer(ModelElementRenderer object) {
			return createModelElementRendererAdapter();
		}

		@Override
		public Adapter caseAttributeRenderer(AttributeRenderer object) {
			return createAttributeRendererAdapter();
		}

		@Override
		public Adapter caseDocumentRenderer(DocumentRenderer object) {
			return createDocumentRendererAdapter();
		}

		@Override
		public Adapter caseModelElementRendererMapping(ModelElementRendererMapping object) {
			return createModelElementRendererMappingAdapter();
		}

		@Override
		public Adapter caseAttributeRendererMapping(AttributeRendererMapping object) {
			return createAttributeRendererMappingAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
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
	 * Creates a new adapter for an object of class '
	 * {@link org.unicase.docExport.exportModel.renderers.DocumentRenderer <em>Document Renderer</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.DocumentRenderer
	 * @generated
	 */
	public Adapter createDocumentRendererAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping
	 * <em>Model Element Renderer Mapping</em>}'. <!-- begin-user-doc --> This default implementation returns null so
	 * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping
	 * @generated
	 */
	public Adapter createModelElementRendererMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '
	 * {@link org.unicase.docExport.exportModel.renderers.AttributeRendererMapping <em>Attribute Renderer Mapping</em>}
	 * '. <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see org.unicase.docExport.exportModel.renderers.AttributeRendererMapping
	 * @generated
	 */
	public Adapter createAttributeRendererMappingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case. <!-- begin-user-doc --> This default implementation returns null.
	 * <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // RenderersAdapterFactory
