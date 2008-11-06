/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.unicase.documentexport.documentTemplate.renderers;

import org.eclipse.emf.ecore.EObject;
import org.unicase.documentexport.documentTemplate.Template;
import org.unicase.documentexport.renderers.elements.UCompositeSection;
import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Document Renderer</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.unicase.documentexport.documentTemplate.renderers.RenderersPackage#getDocumentRenderer()
 * @model abstract="true"
 * @generated
 */
public interface DocumentRenderer extends EObject {


	//begin custom code
	UCompositeSection render(ModelElement modelElement, Template template);	
	//end custom code
} // DocumentRenderer
