/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.diagram.providers;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.diagram.MEDiagram;

/**
 * @author denglerm serves as a superclass for the specific class of each diagram
 */
public abstract class ModelingAssistantProvider extends
	org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider {

	/**
	 * lets the user chose an element to link with.
	 * 
	 * @param host the host
	 * @param types the types
	 * @return the chosen modelElement
	 */
	@SuppressWarnings("unchecked")
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		Collection elements = new HashSet();
		for (Iterator it = ((MEDiagram) diagram.getElement()).getProject().getAllModelElements().iterator(); it
			.hasNext();) {
			EObject element = (EObject) it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		ModelElement me = (ModelElement) selectElement((EObject[]) elements.toArray(new EObject[elements.size()]));

		return me;
	}

	/**
	 * this method has to be implemented.
	 * 
	 * @param element the element
	 * @param types the types
	 * @return true or false
	 */
	@SuppressWarnings("unchecked")
	protected abstract boolean isApplicableElement(EObject element, Collection types);

	/**
	 * this method has to be implemented to display a selection dialog.
	 * 
	 * @param array the elements to chose from
	 * @return the chosen modelElement
	 */
	protected abstract EObject selectElement(EObject[] array);
}
