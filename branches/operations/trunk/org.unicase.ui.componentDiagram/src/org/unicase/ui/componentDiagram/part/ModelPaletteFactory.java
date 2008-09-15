package org.unicase.ui.componentDiagram.part;

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
				org.unicase.ui.componentDiagram.part.Messages.Default1Group_title);
		paletteContainer
				.setDescription(org.unicase.ui.componentDiagram.part.Messages.Default1Group_desc);
		paletteContainer.add(createComponent1CreationTool());
		paletteContainer.add(createProvidedService2CreationTool());
		paletteContainer.add(createRequiredServiceLink3CreationTool());
		paletteContainer.add(createProvidedServiceLink4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComponent1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.componentDiagram.providers.ModelElementTypes.Component_1002);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.componentDiagram.part.Messages.Component1CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.ui.componentDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.componentDiagram.providers.ModelElementTypes.Component_1002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidedService2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.componentDiagram.providers.ModelElementTypes.ComponentService_1001);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.componentDiagram.part.Messages.ProvidedService2CreationTool_title,
				org.unicase.ui.componentDiagram.part.Messages.ProvidedService2CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.ui.componentDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.componentDiagram.providers.ModelElementTypes.ComponentService_1001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRequiredServiceLink3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.componentDiagram.providers.ModelElementTypes.ComponentConsumedServices_3002);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.componentDiagram.part.Messages.RequiredServiceLink3CreationTool_title,
				org.unicase.ui.componentDiagram.part.Messages.RequiredServiceLink3CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.ui.componentDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.componentDiagram.providers.ModelElementTypes.ComponentConsumedServices_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvidedServiceLink4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.componentDiagram.providers.ModelElementTypes.ComponentOfferedServices_3001);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.componentDiagram.part.Messages.ProvidedServiceLink4CreationTool_title,
				org.unicase.ui.componentDiagram.part.Messages.ProvidedServiceLink4CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.ui.componentDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.componentDiagram.providers.ModelElementTypes.ComponentOfferedServices_3001));
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
