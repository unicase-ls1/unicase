/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.uml.diagram.part;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.papyrus.UMLDiagramType;
import org.unicase.papyrus.diagram.services.UnicaseUMLIconRegistry;

/**
 * Label provider for {@link UMLDiagramTypeSelectionDialog}, providing the appropriate icon and text for each diagram
 * type.
 * 
 * @author mharut
 */
public class UMLDiagramTypeLabelProvider extends LabelProvider {

	/**
	 * {@inheritDoc}
	 */
	public String getText(Object object) {
		if (object instanceof UMLDiagramType) {
			return ((UMLDiagramType) object).getName();
		} else {
			return super.getText(object);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage(Object object) {
		Image result = UnicaseUMLIconRegistry.getInstance().getEditorIcon(object);
		if (result == null) {
			result = super.getImage(object);
		}
		return result;

	};

}
