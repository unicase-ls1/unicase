/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.componentDiagram.part;

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
				org.unicase.ui.diagram.componentDiagram.part.Messages.Default1Group_title);
		paletteContainer.setId("createDefault1Group"); //$NON-NLS-1$
		paletteContainer
				.setDescription(org.unicase.ui.diagram.componentDiagram.part.Messages.Default1Group_desc);
		paletteContainer.add(createComponent1CreationTool());
		paletteContainer.add(createNeed2CreationTool());
		paletteContainer.add(createAbility3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComponent1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes.Component_2002);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.diagram.componentDiagram.part.Messages.Component1CreationTool_title,
				null, types);
		entry.setId("createComponent1CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes.Component_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNeed2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes.ComponentConsumedServices_4002);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.diagram.componentDiagram.part.Messages.Need2CreationTool_title,
				org.unicase.ui.diagram.componentDiagram.part.Messages.Need2CreationTool_desc,
				types);
		entry.setId("createNeed2CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.componentDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Usage.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAbility3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.componentDiagram.providers.ModelElementTypes.ComponentOfferedServices_4001);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.diagram.componentDiagram.part.Messages.Ability3CreationTool_title,
				org.unicase.ui.diagram.componentDiagram.part.Messages.Ability3CreationTool_desc,
				types);
		entry.setId("createAbility3CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.componentDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/InterfaceRealization.gif")); //$NON-NLS-1$
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
