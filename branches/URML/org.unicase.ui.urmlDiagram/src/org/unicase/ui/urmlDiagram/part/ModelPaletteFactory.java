package org.unicase.ui.urmlDiagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
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
		paletteRoot.add(createUseCase2Group());
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
		paletteContainer.add(createHazardCause1CreationTool());
		paletteContainer.add(createMitigation2CreationTool());
		paletteContainer.add(createFunctionalRequirement3CreationTool());
		paletteContainer.add(createHazard4CreationTool());
		paletteContainer.add(createMitigate5CreationTool());
		paletteContainer.add(createRefineRequirement6CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "UseCase" palette tool group
	 * @generated
	 */
	private PaletteContainer createUseCase2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				org.unicase.ui.urmlDiagram.part.Messages.UseCase2Group_title);
		paletteContainer.add(createUseCase1CreationTool());
		paletteContainer.add(createActor2CreationTool());
		paletteContainer.add(createParticipate3CreationTool());
		paletteContainer.add(createInitiate4CreationTool());
		paletteContainer.add(createInclude5CreationTool());
		paletteContainer.add(createExtend6CreationTool());
		paletteContainer.add(createEndangeredbyHazard7CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createHazardCause1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCause_2001);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.HazardCause1CreationTool_title,
				org.unicase.ui.urmlDiagram.part.Messages.HazardCause1CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.ui.urmlDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCause_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMitigation2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.Mitigation_2002);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.Mitigation2CreationTool_title,
				org.unicase.ui.urmlDiagram.part.Messages.Mitigation2CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.ui.urmlDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.Mitigation_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFunctionalRequirement3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.FunctionalRequirement_2006);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.FunctionalRequirement3CreationTool_title,
				org.unicase.ui.urmlDiagram.part.Messages.FunctionalRequirement3CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.ui.urmlDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.FunctionalRequirement_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createHazard4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.Hazard_2003);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.Hazard4CreationTool_title,
				org.unicase.ui.urmlDiagram.part.Messages.Hazard4CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.ui.urmlDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.Hazard_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMitigate5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(3);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardMitigations_4005);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCauseMitigations_4006);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.FunctionalRequirementMitigations_4008);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.Mitigate5CreationTool_title,
				org.unicase.ui.urmlDiagram.part.Messages.Mitigate5CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Association.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRefineRequirement6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.FunctionalRequirementRefiningRequirements_4007);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.RefineRequirement6CreationTool_title,
				org.unicase.ui.urmlDiagram.part.Messages.RefineRequirement6CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Transition.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUseCase1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.UseCase_2005);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.UseCase1CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.ui.urmlDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.UseCase_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActor2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.Actor_2004);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.Actor2CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.ui.urmlDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.Actor_2004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createParticipate3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.Participate3CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Participate.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInitiate4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.ScenarioInstantiatedUseCases_4002);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.Initiate4CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Initiate.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInclude5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.Include5CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
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
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.Extend6CreationTool_title,
				org.unicase.ui.urmlDiagram.part.Messages.Extend6CreationTool_desc,
				types);
		entry
				.setSmallIcon(org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Extend.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEndangeredbyHazard7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.ActorHazards_4010);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.EndangeredbyHazard7CreationTool_title,
				null, types);
		entry
				.setSmallIcon(org.unicase.ui.urmlDiagram.providers.ModelElementTypes
						.getImageDescriptor(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.ActorHazards_4010));
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
