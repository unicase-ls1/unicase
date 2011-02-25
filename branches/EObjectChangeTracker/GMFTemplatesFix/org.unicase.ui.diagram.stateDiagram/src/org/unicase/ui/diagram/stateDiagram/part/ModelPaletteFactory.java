/*
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 *   accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.stateDiagram.part;

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
				org.unicase.ui.diagram.stateDiagram.part.Messages.Default1Group_title);
		paletteContainer.setId("createDefault1Group"); //$NON-NLS-1$
		paletteContainer
				.setDescription(org.unicase.ui.diagram.stateDiagram.part.Messages.Default1Group_desc);
		paletteContainer.add(createState1CreationTool());
		paletteContainer.add(createTransition2CreationTool());
		paletteContainer.add(createStateInitialNode3CreationTool());
		paletteContainer.add(createStateFinalNode4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createState1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.State_2001);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.diagram.stateDiagram.part.Messages.State1CreationTool_title,
				null, types);
		entry.setId("createState1CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.State_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTransition2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.Transition_4001);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.diagram.stateDiagram.part.Messages.Transition2CreationTool_title,
				null, types);
		entry.setId("createTransition2CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.Transition_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStateInitialNode3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.StateInitial_2002);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.diagram.stateDiagram.part.Messages.StateInitialNode3CreationTool_title,
				null, types);
		entry.setId("createStateInitialNode3CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.StateInitial_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStateFinalNode4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.StateEnd_2003);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.diagram.stateDiagram.part.Messages.StateFinalNode4CreationTool_title,
				null, types);
		entry.setId("createStateFinalNode4CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.diagram.stateDiagram.providers.ModelElementTypes.StateEnd_2003));
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
