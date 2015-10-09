/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers;

import org.eclipse.emf.ecore.EObject;
import org.unicase.docExport.exportModel.Template;
import org.unicase.docExport.exportModel.renderers.elements.URootCompositeSection;
import org.unicase.model.UnicaseModelElement;

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
	/**
	 * renders a modelElement using a template to the abstract recursive document model with the root element
	 * URootCompositeSection.
	 * 
	 * @param modelElement the model element which shall be rendered.
	 * @param template the template which defines the layout.
	 * @return the root element of the document export internal document structure.
	 */
	URootCompositeSection render(UnicaseModelElement modelElement, Template template);
	// end custom code
} // DocumentRenderer
