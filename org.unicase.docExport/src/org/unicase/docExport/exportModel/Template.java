/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;

/**
 * <!-- begin-user-doc --> Stores all information on how any unicase document is rendered. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.Template#getModelElementRendererMapping <em>Model Element Renderer Mapping</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.Template#getLayoutOptions <em>Layout Options</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.Template#getName <em>Name</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.Template#isDefaultTemplate <em>Default Template</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.docExport.exportModel.ExportModelPackage#getTemplate()
 * @model
 * @generated
 */
public interface Template extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Element Renderer Mapping</b></em>' containment reference list. The list
	 * contents are of type {@link org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element Renderer Mapping</em>' containment reference list isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Model Element Renderer Mapping</em>' containment reference list.
	 * @see org.unicase.docExport.exportModel.ExportModelPackage#getTemplate_ModelElementRendererMapping()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelElementRendererMapping> getModelElementRendererMapping();

	/**
	 * Returns the value of the '<em><b>Layout Options</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layout Options</em>' containment reference isn't clear, there really should be more of
	 * a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layout Options</em>' containment reference.
	 * @see #setLayoutOptions(LayoutOptions)
	 * @see org.unicase.docExport.exportModel.ExportModelPackage#getTemplate_LayoutOptions()
	 * @model containment="true"
	 * @generated
	 */
	LayoutOptions getLayoutOptions();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.Template#getLayoutOptions <em>Layout Options</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout Options</em>' containment reference.
	 * @see #getLayoutOptions()
	 * @generated
	 */
	void setLayoutOptions(LayoutOptions value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.unicase.docExport.exportModel.ExportModelPackage#getTemplate_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.Template#getName <em>Name</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Default Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Template</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Template</em>' attribute.
	 * @see #setDefaultTemplate(boolean)
	 * @see org.unicase.docExport.exportModel.ExportModelPackage#getTemplate_DefaultTemplate()
	 * @model
	 * @generated
	 */
	boolean isDefaultTemplate();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.Template#isDefaultTemplate <em>Default Template</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default Template</em>' attribute.
	 * @see #isDefaultTemplate()
	 * @generated
	 */
	void setDefaultTemplate(boolean value);

	// begin custom code
	/**
	 * Returns the ModelElementRenderer for a model element type (EClass). If there is no ModelElementRenderer
	 * registered, a new default ModelElementRenderer will be created and returned. So there is always a renderer!
	 * 
	 * @param eClass the EClass of a unicase model
	 * @param template the template where the renderer is used.
	 */
	ModelElementRenderer getModelElementRendererNotNull(EClass eClass, Template template);

	/**
	 * Set the renderer for a model element type by the name of the EClass of the ModelElement. If there has been
	 * registered a renderer before, the registration will be overwritten.
	 * 
	 * @param eClass the EClass of a unicase model.
	 * @param renderer the ModelElementRenderer which shall be set.
	 */
	void setModelElementRenderer(EClass eClass, ModelElementRenderer renderer);

	/**
	 * Returns the registered ModelElementRenderer for a given model element type by the EClass. This function my return
	 * null, if there isn't any renderer registered for this type.
	 * 
	 * @param modelElementEClass the EClass of a unicase model.
	 */
	ModelElementRenderer getModelElementRenderer(EClass modelElementEClass);

	/**
	 * Removes the registration of a renderer for a model element type. So the default renderer will be used, when this
	 * model element type is rendered.
	 * 
	 * @see #getModelElementRendererNotNull(EClass, Template)
	 * @param modelElementEClass the EClass of a unicase model.
	 */
	void removeModelElementRenderer(EClass modelElementEClass);
	// end custom code
} // Template
