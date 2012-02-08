/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.diagram.services;

import java.io.IOException;

import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.swt.graphics.Image;
import org.unicase.papyrus.UMLDiagramType;
import org.unicase.papyrus.UMLModel;
import org.unicase.papyrus.diagram.part.UMLImageUtil;

/**
 * Registry for Papyrus UML icons in unicase. There can always only be one instance.
 * 
 * @author mharut
 */
public final class UnicaseUMLIconRegistry implements IPageIconsRegistry {

	private static UnicaseUMLIconRegistry instance;

	private UnicaseUMLIconRegistry() {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getEditorIcon(Object object) {
		if (object instanceof Diagram) {
			UMLModel model = (UMLModel) ((Diagram) object).getElement();
			return getIcon(model.getDiagramType());
		}
		if (object instanceof UMLModel) {
			return getIcon(((UMLModel) object).getDiagramType());
		}
		if (object instanceof UMLDiagramType) {
			return getIcon((UMLDiagramType) object);
		}
		return null;
	}

	private Image getIcon(UMLDiagramType diagramType) {
		try {
			switch (diagramType) {
			case ACTIVITY:
				return UMLImageUtil.getActivityImage();
			case CLASS:
				return UMLImageUtil.getClassImage();
			case COMMUNICATION:
				return UMLImageUtil.getCommunicationImage();
			case COMPOSITE:
				return UMLImageUtil.getCompositeImage();
			case SEQUENCE:
				return UMLImageUtil.getSequenceImage();
			case STATE_MACHINE:
				return UMLImageUtil.getStateMachineImage();
			case USE_CASE:
				return UMLImageUtil.getUseCaseImage();
			case PACKAGE:
				return UMLImageUtil.getPackageImage();
			default:
				return null;
			}
		} catch (IOException e) {
			WorkspaceUtil.logException("Failed to load Papyrus icons", e);
			return null;
		}
	}

	/**
	 * Retrieves the singleton registry instance.
	 * 
	 * @return the singleton instance
	 */
	public static UnicaseUMLIconRegistry getInstance() {
		if (instance == null) {
			instance = new UnicaseUMLIconRegistry();
		}
		return instance;
	}

}
