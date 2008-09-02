package org.unicase.model.classDiagram.part;

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
	 * 
	 * @generated
	 */
	private PaletteContainer createDefault1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				org.unicase.model.classDiagram.part.Messages.Default1Group_title);
		paletteContainer
				.setDescription(org.unicase.model.classDiagram.part.Messages.Default1Group_desc);
		paletteContainer.add(createClass1CreationTool());
		paletteContainer.add(createAssociation2CreationTool());
		paletteContainer.add(createAggregation3CreationTool());
		paletteContainer.add(createComposition4CreationTool());
		paletteContainer.add(createDirectedAssociation5CreationTool());
		paletteContainer.add(createAttribute6CreationTool());
		paletteContainer.add(createMethod7CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClass1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_1001);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.model.classDiagram.part.Messages.Class1CreationTool_title,
				org.unicase.model.classDiagram.part.Messages.Class1CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.model.classDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.model.classDiagram.providers.ModelElementTypes.Class_1001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3001);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.model.classDiagram.part.Messages.Association2CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.model.classDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAggregation3CreationTool() {
		ToolEntry entry = new ToolEntry(
				org.unicase.model.classDiagram.part.Messages.Aggregation3CreationTool_title,
				null, null, null) {
		};
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComposition4CreationTool() {
		ToolEntry entry = new ToolEntry(
				org.unicase.model.classDiagram.part.Messages.Composition4CreationTool_title,
				null, null, null) {
		};
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDirectedAssociation5CreationTool() {
		ToolEntry entry = new ToolEntry(
				org.unicase.model.classDiagram.part.Messages.DirectedAssociation5CreationTool_title,
				null, null, null) {
		};
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAttribute6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Attribute_2001);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.model.classDiagram.part.Messages.Attribute6CreationTool_title,
				org.unicase.model.classDiagram.part.Messages.Attribute6CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.model.classDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.model.classDiagram.providers.ModelElementTypes.Attribute_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMethod7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Method_2002);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.model.classDiagram.part.Messages.Method7CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.model.classDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.model.classDiagram.providers.ModelElementTypes.Method_2002));
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
