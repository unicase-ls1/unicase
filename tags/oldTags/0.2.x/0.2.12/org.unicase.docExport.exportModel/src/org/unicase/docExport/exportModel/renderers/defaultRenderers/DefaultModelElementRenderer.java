/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.docExport.exportModel.renderers.defaultRenderers;

import org.eclipse.emf.common.util.EList;

import org.unicase.docExport.exportModel.renderers.AttributeRendererMapping;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Default Model Element Renderer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultModelElementRenderer#getAttributeRendererMapping <em>Attribute Renderer Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage#getDefaultModelElementRenderer()
 * @model
 * @generated
 */
public interface DefaultModelElementRenderer extends ModelElementRenderer {
	/**
	 * Returns the value of the '<em><b>Attribute Renderer Mapping</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.docExport.exportModel.renderers.AttributeRendererMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attribute Renderer Mapping</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Renderer Mapping</em>' containment reference list.
	 * @see org.unicase.docExport.exportModel.renderers.defaultRenderers.DefaultRenderersPackage#getDefaultModelElementRenderer_AttributeRendererMapping()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttributeRendererMapping> getAttributeRendererMapping();

} // DefaultModelElementRenderer
