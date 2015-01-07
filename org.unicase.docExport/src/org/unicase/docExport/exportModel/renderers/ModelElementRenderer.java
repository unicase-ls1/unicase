/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.options.RendererOption;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Model Element Renderer</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.ModelElementRenderer#getRendererOptions <em>Renderer Options</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.ModelElementRenderer#getTemplate <em>Template</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.ModelElementRenderer#getAttributeRendererMapping <em>Attribute Renderer Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage#getModelElementRenderer()
 * @model abstract="true"
 * @generated
 */
public interface ModelElementRenderer extends EObject {
	/**
	 * Returns the value of the '<em><b>Renderer Options</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.docExport.exportModel.renderers.options.RendererOption}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Renderer Options</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Renderer Options</em>' containment reference list.
	 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage#getModelElementRenderer_RendererOptions()
	 * @model containment="true"
	 * @generated
	 */
	EList<RendererOption> getRendererOptions();

	/**
	 * Returns the value of the '<em><b>Template</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template</em>' reference.
	 * @see #setTemplate(Template)
	 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage#getModelElementRenderer_Template()
	 * @model
	 * @generated
	 */
	Template getTemplate();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.ModelElementRenderer#getTemplate <em>Template</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template</em>' reference.
	 * @see #getTemplate()
	 * @generated
	 */
	void setTemplate(Template value);

	/**
	 * Returns the value of the '<em><b>Attribute Renderer Mapping</b></em>' containment reference list. The list
	 * contents are of type {@link org.unicase.docExport.exportModel.renderers.AttributeRendererMapping}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Renderer Mapping</em>' containment reference list isn't clear, there really
	 * should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Attribute Renderer Mapping</em>' containment reference list.
	 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage#getModelElementRenderer_AttributeRendererMapping()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttributeRendererMapping> getAttributeRendererMapping();

	// begin custom code
	/**
	 * Renders an EObject into another section.
	 * 
	 * @param eObject the EObject which shall be rendered.
	 * @param parent the parent section of the document tree.
	 */
	void render(EObject eObject, UCompositeSection parent);

	/**
	 * Sets a AttributeRenderer for a feature of a modelElement.
	 * 
	 * @param feature the feature of the modelElement.
	 * @param renderer the new AttributeRenderer to set.
	 */
	void setAttributeRenderer(EStructuralFeature feature, AttributeRenderer renderer);

	/**
	 * Get the AttributeRenderer which shall be used rendering the feature of the ModelElement type registered with this
	 * ModelElementRenderer.
	 * 
	 * @param feature the feature of the ModelElement
	 * @return the AttributeRenderer which shall be used for rendering. May be null.
	 */
	AttributeRenderer getAttributeRenderer(EStructuralFeature feature);

	/**
	 * @see #getAttributeRenderer(EStructuralFeature)
	 * @param feature the feature of the ModelElement
	 * @return the AttributeRenderer which shall be used for rendering. May not be null.
	 */
	AttributeRenderer getAttributeRendererNotNull(EStructuralFeature feature);

	/**
	 * Defines whether the structural lines shall be shown or not.
	 * 
	 * @return true if the structural lines shall be hidden, else false.
	 */
	boolean hideStructuralLines();

	/**
	 * Removes the AttributeRenderer registered for a feature. If there is no AttributeRenderer for this feature,
	 * nothing will happen.
	 * 
	 * @param feature a feature of the ModelElement
	 */
	void removeAttributeRenderer(EStructuralFeature feature);
	// end custom code

} // ModelElementRenderer
