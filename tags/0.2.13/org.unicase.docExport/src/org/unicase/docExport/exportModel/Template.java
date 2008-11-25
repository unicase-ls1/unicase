/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.docExport.exportModel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.unicase.docExport.exportModel.renderers.ModelElementRenderer;
import org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping;
import org.unicase.docExport.exportModel.renderers.options.AttributeOption;
import org.unicase.docExport.exportModel.renderers.options.LayoutOptions;
import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.unicase.docExport.exportModel.Template#getModelElementRendererMapping <em>Model Element Renderer Mapping</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.Template#getLayoutOptions <em>Layout Options</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.Template#getGlobalRendererOptions <em>Global Renderer Options</em>}</li>
 *   <li>{@link org.unicase.docExport.exportModel.Template#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.unicase.docExport.exportModel.ExportModelPackage#getTemplate()
 * @model
 * @generated
 */
public interface Template extends EObject {
	/**
	 * Returns the value of the '<em><b>Model Element Renderer Mapping</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.docExport.exportModel.renderers.ModelElementRendererMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Model Element Renderer Mapping</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
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
	 * If the meaning of the '<em>Layout Options</em>' containment reference isn't clear,
	 * there really should be more of a description here...
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layout Options</em>' containment reference.
	 * @see #getLayoutOptions()
	 * @generated
	 */
	void setLayoutOptions(LayoutOptions value);

	/**
	 * Returns the value of the '<em><b>Global Renderer Options</b></em>' containment reference list.
	 * The list contents are of type {@link org.unicase.docExport.exportModel.renderers.options.AttributeOption}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Renderer Options</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Renderer Options</em>' containment reference list.
	 * @see org.unicase.docExport.exportModel.ExportModelPackage#getTemplate_GlobalRendererOptions()
	 * @model containment="true"
	 * @generated
	 */
	EList<AttributeOption> getGlobalRendererOptions();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
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
	 * Sets the value of the '{@link org.unicase.docExport.exportModel.Template#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	//begin custom code
	AttributeOption getGlobalAttributeRendererOption(Class<? extends AttributeOption> clazz);
	
	boolean hasAlreadyBeenRendered(ModelElement me);
	
	void initiateRenderedModelElements();

	void addRenderedModelElement(ModelElement me);
	void setModelElementRenderer(String eClassName, ModelElementRenderer renderer);
	ModelElementRenderer getModelElementRenderer(EClass modelElementEClass);
	void removeModelElementRenderer(EClass modelElementEClass);
	//end custom code
} // Template
