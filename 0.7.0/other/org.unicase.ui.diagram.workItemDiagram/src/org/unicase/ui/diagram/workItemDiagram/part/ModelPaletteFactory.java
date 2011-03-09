package org.unicase.ui.diagram.workItemDiagram.part;

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
				org.unicase.ui.diagram.workItemDiagram.part.Messages.Default1Group_title);
		paletteContainer
				.setDescription(org.unicase.ui.diagram.workItemDiagram.part.Messages.Default1Group_desc);
		paletteContainer.add(createSuccessor1CreationTool());
		paletteContainer.add(createBugReport2CreationTool());
		paletteContainer.add(createActionItem3CreationTool());
		paletteContainer.add(createIssue4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSuccessor1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.WorkItemSuccessors_4003);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.diagram.workItemDiagram.part.Messages.Successor1CreationTool_title,
				org.unicase.ui.diagram.workItemDiagram.part.Messages.Successor1CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.ui.diagram.workItemDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Successor.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createBugReport2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.BugReport_2003);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.diagram.workItemDiagram.part.Messages.BugReport2CreationTool_title,
				org.unicase.ui.diagram.workItemDiagram.part.Messages.BugReport2CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.BugReport_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActionItem3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.ActionItem_2001);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.diagram.workItemDiagram.part.Messages.ActionItem3CreationTool_title,
				org.unicase.ui.diagram.workItemDiagram.part.Messages.ActionItem3CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.ActionItem_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createIssue4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.Issue_2002);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.diagram.workItemDiagram.part.Messages.Issue4CreationTool_title,
				org.unicase.ui.diagram.workItemDiagram.part.Messages.Issue4CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.diagram.workItemDiagram.providers.ModelElementTypes.Issue_2002));
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
