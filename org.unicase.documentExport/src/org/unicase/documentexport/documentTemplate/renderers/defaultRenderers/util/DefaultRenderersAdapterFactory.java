/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.documentexport.documentTemplate.renderers.defaultRenderers.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.unicase.documentexport.documentTemplate.renderers.AttributeRenderer;
import org.unicase.documentexport.documentTemplate.renderers.DocumentRenderer;
import org.unicase.documentexport.documentTemplate.renderers.ModelElementRenderer;

import org.unicase.documentexport.documentTemplate.renderers.defaultRenderers.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.unicase.documentexport.documentTemplate.renderers.defaultRenderers.DefaultRenderersPackage
 * @generated
 */
public class DefaultRenderersAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DefaultRenderersPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultRenderersAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DefaultRenderersPackage.eINSTANCE;
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
	protected DefaultRenderersSwitch<Adapter> modelSwitch =
		new DefaultRenderersSwitch<Adapter>() {
			@Override
			public Adapter caseDefaultModelElementRenderer(DefaultModelElementRenderer object) {
				return createDefaultModelElementRendererAdapter();
			}
			@Override
			public Adapter caseDefaultAttributeRenderer(DefaultAttributeRenderer object) {
				return createDefaultAttributeRendererAdapter();
			}
			@Override
			public Adapter caseDefaultDocumentRenderer(DefaultDocumentRenderer object) {
				return createDefaultDocumentRendererAdapter();
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
			public Adapter caseDocumentRenderer(DocumentRenderer object) {
				return createDocumentRendererAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.unicase.documentexport.documentTemplate.renderers.defaultRenderers.DefaultModelElementRenderer <em>Default Model Element Renderer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.documentexport.documentTemplate.renderers.defaultRenderers.DefaultModelElementRenderer
	 * @generated
	 */
	public Adapter createDefaultModelElementRendererAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.documentexport.documentTemplate.renderers.defaultRenderers.DefaultAttributeRenderer <em>Default Attribute Renderer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.documentexport.documentTemplate.renderers.defaultRenderers.DefaultAttributeRenderer
	 * @generated
	 */
	public Adapter createDefaultAttributeRendererAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.documentexport.documentTemplate.renderers.defaultRenderers.DefaultDocumentRenderer <em>Default Document Renderer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.documentexport.documentTemplate.renderers.defaultRenderers.DefaultDocumentRenderer
	 * @generated
	 */
	public Adapter createDefaultDocumentRendererAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.documentexport.documentTemplate.renderers.ModelElementRenderer <em>Model Element Renderer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.documentexport.documentTemplate.renderers.ModelElementRenderer
	 * @generated
	 */
	public Adapter createModelElementRendererAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.documentexport.documentTemplate.renderers.AttributeRenderer <em>Attribute Renderer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.documentexport.documentTemplate.renderers.AttributeRenderer
	 * @generated
	 */
	public Adapter createAttributeRendererAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.unicase.documentexport.documentTemplate.renderers.DocumentRenderer <em>Document Renderer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.unicase.documentexport.documentTemplate.renderers.DocumentRenderer
	 * @generated
	 */
	public Adapter createDocumentRendererAdapter() {
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

} //DefaultRenderersAdapterFactory
