/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.papyrus.diagram.services;

import java.io.IOException;

import org.eclipse.emf.emfstore.client.model.util.WorkspaceUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.core.editorsfactory.IPageIconsRegistry;
import org.eclipse.swt.graphics.Image;
import org.unicase.papyrus.SysMLDiagramType;
import org.unicase.papyrus.SysMLModel;
import org.unicase.papyrus.UMLDiagramType;
import org.unicase.papyrus.UMLModel;

/**
 * Registry for Papyrus UML icons in unicase. There can always only be one instance.
 * 
 * @author mharut
 */
public final class UnicasePapyrusIconRegistry implements IPageIconsRegistry {

	private static UnicasePapyrusIconRegistry instance;

	private UnicasePapyrusIconRegistry() {
		// nothing to do
	}

	/**
	 * {@inheritDoc}
	 */
	public Image getEditorIcon(Object object) {
		if (object instanceof Diagram) {
			// use the parent of the diagram in the following steps
			object = ((Diagram) object).getElement();
			// no return on purpose
		}
		if (object instanceof UMLModel) {
			return getUMLIcon(((UMLModel) object).getDiagramType());
		}
		if (object instanceof UMLDiagramType) {
			return getUMLIcon((UMLDiagramType) object);
		}
		if (object instanceof SysMLModel) {
			return getSysMLIcon(((SysMLModel) object).getDiagramType());
		}
		if (object instanceof SysMLDiagramType) {
			return getSysMLIcon((SysMLDiagramType) object);
		}
		return null;
	}

	private Image getSysMLIcon(SysMLDiagramType diagramType) {
		try {
			switch (diagramType) {
			case BLOCK_DEFINITION:
				return UnicaseImageUtil.getBlockDefinitionImage();
			case INTERNAL_BLOCK:
				return UnicaseImageUtil.getInternalBlockImage();
			case PARAMETRIC:
				return UnicaseImageUtil.getParametricImage();
			case REQUIREMENT:
				return UnicaseImageUtil.getRequirementImage();
			default:
				return null;
			}
		} catch (IOException e) {
			WorkspaceUtil.logException("Failed to load Papyrus icons", e);
			return null;
		}
	}

	private Image getUMLIcon(UMLDiagramType diagramType) {
		try {
			switch (diagramType) {
			case ACTIVITY:
				return UnicaseImageUtil.getActivityImage();
			case CLASS:
				return UnicaseImageUtil.getClassImage();
			case COMMUNICATION:
				return UnicaseImageUtil.getCommunicationImage();
			case COMPOSITE:
				return UnicaseImageUtil.getCompositeImage();
			case SEQUENCE:
				return UnicaseImageUtil.getSequenceImage();
			case STATE_MACHINE:
				return UnicaseImageUtil.getStateMachineImage();
			case USE_CASE:
				return UnicaseImageUtil.getUseCaseImage();
			case PACKAGE:
				return UnicaseImageUtil.getPackageImage();
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
	public static UnicasePapyrusIconRegistry getInstance() {
		if (instance == null) {
			instance = new UnicasePapyrusIconRegistry();
		}
		return instance;
	}

}
