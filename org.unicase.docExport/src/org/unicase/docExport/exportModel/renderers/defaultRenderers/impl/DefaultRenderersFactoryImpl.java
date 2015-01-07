/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.defaultRenderers.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultAttributeRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultDocumentRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersFactory;
import org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class DefaultRenderersFactoryImpl extends EFactoryImpl implements DefaultRenderersFactory {
	/**
	 * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static DefaultRenderersFactory init() {
		try {
			DefaultRenderersFactory theDefaultRenderersFactory = (DefaultRenderersFactory) EPackage.Registry.INSTANCE
				.getEFactory("http://unicase.org/docExport/exportModel/renderers/defaultRenderers");
			if (theDefaultRenderersFactory != null) {
				return theDefaultRenderersFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DefaultRenderersFactoryImpl();
	}

	/**
	 * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DefaultRenderersFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
		case DefaultRenderersPackage.DEFAULT_MODEL_ELEMENT_RENDERER:
			return createDefaultModelElementRenderer();
		case DefaultRenderersPackage.DEFAULT_ATTRIBUTE_RENDERER:
			return createDefaultAttributeRenderer();
		case DefaultRenderersPackage.DEFAULT_DOCUMENT_RENDERER:
			return createDefaultDocumentRenderer();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DefaultModelElementRenderer createDefaultModelElementRenderer() {
		DefaultModelElementRendererImpl defaultModelElementRenderer = new DefaultModelElementRendererImpl();
		return defaultModelElementRenderer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DefaultAttributeRenderer createDefaultAttributeRenderer() {
		DefaultAttributeRendererImpl defaultAttributeRenderer = new DefaultAttributeRendererImpl();
		return defaultAttributeRenderer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DefaultDocumentRenderer createDefaultDocumentRenderer() {
		DefaultDocumentRendererImpl defaultDocumentRenderer = new DefaultDocumentRendererImpl();
		return defaultDocumentRenderer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public DefaultRenderersPackage getDefaultRenderersPackage() {
		return (DefaultRenderersPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DefaultRenderersPackage getPackage() {
		return DefaultRenderersPackage.eINSTANCE;
	}

} // DefaultRenderersFactoryImpl
