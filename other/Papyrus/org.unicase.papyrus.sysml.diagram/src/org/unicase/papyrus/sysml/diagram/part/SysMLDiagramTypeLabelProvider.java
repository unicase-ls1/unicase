/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.sysml.diagram.part;

import java.io.IOException;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.papyrus.SysMLDiagramType;
import org.unicase.papyrus.diagram.services.UnicaseImageUtil;
import org.unicase.papyrus.diagram.services.UnicasePapyrusIconRegistry;

/**
 * Label provider for {@link SysMLDiagramTypeSelectionDialog}, providing the appropriate icon and text for each diagram
 * type.
 * 
 * @author mharut
 */
public class SysMLDiagramTypeLabelProvider extends LabelProvider {

	/**
	 * {@inheritDoc}
	 */
	public String getText(Object object) {
		if (object instanceof SysMLDiagramType) {
			return ((SysMLDiagramType) object).getName();
		} else {
			return super.getText(object);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getImage(Object object) {
		Image result = UnicasePapyrusIconRegistry.getInstance().getEditorIcon(object);
		if (result == null) {
			result = super.getImage(object);
		}
		return result;
	};

}
