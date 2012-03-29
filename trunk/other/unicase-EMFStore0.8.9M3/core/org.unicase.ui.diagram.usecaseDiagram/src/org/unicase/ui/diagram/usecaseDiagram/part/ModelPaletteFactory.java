/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universität München (TUM).
* All rights reserved. This program and the accompanying materials are made available under the terms of
* the Eclipse Public License v1.0 which accompanies this distribution,
* and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.usecaseDiagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

/**
 * @generated
 */
public class ModelPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createDefault1Group());
	}

	/**
	 * Creates "Default" palette tool group
	 * @generated
	 */
	private PaletteContainer createDefault1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				org.unicase.ui.diagram.usecaseDiagram.part.Messages.Default1Group_title);
		paletteContainer.setId("createDefault1Group"); //$NON-NLS-1$
		paletteContainer
				.setDescription(org.unicase.ui.diagram.usecaseDiagram.part.Messages.Default1Group_desc);
		paletteContainer.add(createUseCase1CreationTool());
		paletteContainer.add(createActor2CreationTool());
		paletteContainer.add(createInitiate3CreationTool());
		paletteContainer.add(createParticipate4CreationTool());
		paletteContainer.add(createInclude5CreationTool());
		paletteContainer.add(createExtend6CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUseCase1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCase_2002);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.diagram.usecaseDiagram.part.Messages.UseCase1CreationTool_title,
				null, types);
		entry.setId("createUseCase1CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCase_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActor2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.Actor_2001);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.diagram.usecaseDiagram.part.Messages.Actor2CreationTool_title,
				null, types);
		entry.setId("createActor2CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.Actor_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInitiate3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_4002);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.diagram.usecaseDiagram.part.Messages.Initiate3CreationTool_title,
				org.unicase.ui.diagram.usecaseDiagram.part.Messages.Initiate3CreationTool_desc,
				types);
		entry.setId("createInitiate3CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Initiate.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createParticipate4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.diagram.usecaseDiagram.part.Messages.Participate4CreationTool_title,
				null, types);
		entry.setId("createParticipate4CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Participate.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInclude5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.diagram.usecaseDiagram.part.Messages.Include5CreationTool_title,
				null, types);
		entry.setId("createInclude5CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Include.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExtend6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.diagram.usecaseDiagram.part.Messages.Extend6CreationTool_title,
				null, types);
		entry.setId("createExtend6CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.usecaseDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Extend.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description,
				List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}
