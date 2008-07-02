package org.unicase.ui.usecaseDiagram.part;

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
				org.unicase.ui.usecaseDiagram.part.Messages.Default1Group_title);
		paletteContainer
				.setDescription(org.unicase.ui.usecaseDiagram.part.Messages.Default1Group_desc);
		paletteContainer.add(createUseCase1CreationTool());
		paletteContainer.add(createActor2CreationTool());
		paletteContainer.add(createInitiate3CreationTool());
		paletteContainer.add(createParticipate4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUseCase1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCase_1001);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.usecaseDiagram.part.Messages.UseCase1CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.ui.usecaseDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.UseCase_1001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActor2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.Actor_1002);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.usecaseDiagram.part.Messages.Actor2CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.ui.usecaseDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.usecaseDiagram.providers.ModelElementTypes.Actor_1002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInitiate3CreationTool() {
		ToolEntry entry = new ToolEntry(
				org.unicase.ui.usecaseDiagram.part.Messages.Initiate3CreationTool_title,
				null, null, null) {
		};
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createParticipate4CreationTool() {
		ToolEntry entry = new ToolEntry(
				org.unicase.ui.usecaseDiagram.part.Messages.Participate4CreationTool_title,
				null, null, null) {
		};
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
