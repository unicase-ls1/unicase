package org.unicase.ui.urmlDiagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
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
				org.unicase.ui.urmlDiagram.part.Messages.Default1Group_title);
		paletteContainer
				.setDescription(org.unicase.ui.urmlDiagram.part.Messages.Default1Group_desc);
		paletteContainer.add(createHazard1CreationTool());
		paletteContainer.add(createHazardCause2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createHazard1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.Hazard_2001);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.Hazard1CreationTool_title,
				org.unicase.ui.urmlDiagram.part.Messages.Hazard1CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.ui.urmlDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.Hazard_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createHazardCause2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCause_2003);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.HazardCause2CreationTool_title,
				org.unicase.ui.urmlDiagram.part.Messages.HazardCause2CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.ui.urmlDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCause_2003));
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
}
