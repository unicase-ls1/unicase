/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.sysml.diagram.part;

import java.io.IOException;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.unicase.papyrus.SysMLDiagramType;
import org.unicase.papyrus.diagram.services.UnicaseImageUtil;

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
		if (object instanceof SysMLDiagramType) {
			try {
				switch ((SysMLDiagramType) object) {
				case BLOCK_DEFINITION:
					return UnicaseImageUtil.getBlockDefinitionImage();
				case INTERNAL_BLOCK:
					return UnicaseImageUtil.getInternalBlockImage();
				case PARAMETRIC:
					return UnicaseImageUtil.getParametricImage();
				case REQUIREMENT:
					return UnicaseImageUtil.getRequirementImage();
				default:
					throw new IllegalArgumentException("Invalid diagram type!");
				}
			} catch (IOException e) {
				return null;
			}
		}
		return null;
	};

}
