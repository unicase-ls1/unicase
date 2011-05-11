/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.activityDiagram.part;

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
				org.unicase.ui.diagram.activityDiagram.part.Messages.Default1Group_title);
		paletteContainer.setId("createDefault1Group"); //$NON-NLS-1$
		paletteContainer
				.setDescription(org.unicase.ui.diagram.activityDiagram.part.Messages.Default1Group_desc);
		paletteContainer.add(createActivity1CreationTool());
		paletteContainer.add(createTransition2CreationTool());
		paletteContainer.add(createActivityInitialNode3CreationTool());
		paletteContainer.add(createActivityFinalNode4CreationTool());
		paletteContainer.add(createBranchMerge5CreationTool());
		paletteContainer.add(createForkJoin6CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActivity1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Activity_2002);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.diagram.activityDiagram.part.Messages.Activity1CreationTool_title,
				null, types);
		entry.setId("createActivity1CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Activity_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTransition2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.diagram.activityDiagram.part.Messages.Transition2CreationTool_title,
				null, types);
		entry.setId("createTransition2CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Transition_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActivityInitialNode3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.ActivityInitial_2004);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.diagram.activityDiagram.part.Messages.ActivityInitialNode3CreationTool_title,
				null, types);
		entry.setId("createActivityInitialNode3CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.ActivityInitial_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActivityFinalNode4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.ActivityEnd_2005);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.diagram.activityDiagram.part.Messages.ActivityFinalNode4CreationTool_title,
				null, types);
		entry.setId("createActivityFinalNode4CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.ActivityEnd_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBranchMerge5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Branch_2006);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.diagram.activityDiagram.part.Messages.BranchMerge5CreationTool_title,
				null, types);
		entry.setId("createBranchMerge5CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Branch_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createForkJoin6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Fork_2003);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.diagram.activityDiagram.part.Messages.ForkJoin6CreationTool_title,
				null, types);
		entry.setId("createForkJoin6CreationTool"); //$NON-NLS-1$
		entry
				.setSmallIcon(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Fork_2003));
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
