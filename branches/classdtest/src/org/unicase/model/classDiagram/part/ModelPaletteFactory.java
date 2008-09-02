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
		paletteContainer.add(createAttribute2CreationTool());
		paletteContainer.add(createMethod3CreationTool());
		paletteContainer.add(createAssociation4CreationTool());
		paletteContainer.add(createGeneralization5CreationTool());
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
	private ToolEntry createAttribute2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Attribute_2001);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.model.classDiagram.part.Messages.Attribute2CreationTool_title,
				org.unicase.model.classDiagram.part.Messages.Attribute2CreationTool_desc,
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
	private ToolEntry createMethod3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Method_2002);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.model.classDiagram.part.Messages.Method3CreationTool_title,
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
	private ToolEntry createAssociation4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.Association_3001);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.model.classDiagram.part.Messages.Association4CreationTool_title,
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
	private ToolEntry createGeneralization5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.model.classDiagram.providers.ModelElementTypes.ClassSubClasses_3002);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.model.classDiagram.part.Messages.Generalization5CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.model.classDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.model.classDiagram.providers.ModelElementTypes.ClassSubClasses_3002));
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
