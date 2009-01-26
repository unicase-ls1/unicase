/**
 * <copyright> </copyright>
 */
package org.unicase.docExport.exportModel.renderers;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.docExport.exportModel.renderers.options.RendererOption;
import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Model Element Renderer</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.ModelElementRenderer#getRendererOptions <em>Renderer Options
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.ModelElementRenderer#getTemplate <em>Template</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.ModelElementRenderer#getAttributeRendererMapping <em>Attribute
 * Renderer Mapping</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage#getModelElementRenderer()
 * @model abstract="true"
 * @generated
 */
public interface ModelElementRenderer extends EObject {
	/**
	 * Returns the value of the '<em><b>Renderer Options</b></em>' containment reference list. The list contents are of
	 * type {@link org.unicase.docExport.exportModel.renderers.options.RendererOption}. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Renderer Options</em>' containment reference list isn't clear, there really should be
	 * more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Renderer Options</em>' containment reference list.
	 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage#getModelElementRenderer_RendererOptions()
	 * @model containment="true"
	 * @generated
	 */
	EList<RendererOption> getRendererOptions();

	/**
	 * Returns the value of the '<em><b>Template</b></em>' reference. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template</em>' reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Template</em>' reference.
	 * @see #setTemplate(Template)
	 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage#getModelElementRenderer_Template()
	 * @model
	 * @generated
	 */
	Template getTemplate();

	/**
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.renderers.ModelElementRenderer#getTemplate
	 * <em>Template</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
	void render(ModelElement modelElement, UCompositeSection parent);

	void setAttributeRenderer(EStructuralFeature feature, AttributeRenderer renderer);

	AttributeRenderer getAttributeRenderer(EStructuralFeature feature);

	AttributeRenderer getAttributeRendererNotNull(EStructuralFeature feature);

	void removeAttributeRenderer(EStructuralFeature feature);
	// end custom code

} // ModelElementRenderer
