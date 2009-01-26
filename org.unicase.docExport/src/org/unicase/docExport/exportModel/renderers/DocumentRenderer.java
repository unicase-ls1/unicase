/**
 * <copyright> </copyright>
 */
package org.unicase.docExport.exportModel.renderers;

import org.eclipse.emf.ecore.EObject;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.elements.UCompositeSection;
import org.unicase.model.ModelElement;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Document Renderer</b></em>'. <!-- end-user-doc
 * -->
 * 
 * @see org.unicase.docExport.exportModel.renderers.RenderersPackage#getDocumentRenderer()
 * @model abstract="true"
 * @generated
 */
public interface DocumentRenderer extends EObject {

	// begin custom code
	UCompositeSection render(ModelElement modelElement, Template template);
	// end custom code
} // DocumentRenderer
