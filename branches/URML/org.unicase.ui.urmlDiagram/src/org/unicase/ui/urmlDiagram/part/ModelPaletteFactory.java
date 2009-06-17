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
		paletteRoot.add(createHazard1Group());
		paletteRoot.add(createFunctionalRequirement2Group());
		paletteRoot.add(createUseCase3Group());
	}

	/**
	 * Creates "Hazard" palette tool group
	 * @generated
	 */
	private PaletteContainer createHazard1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				org.unicase.ui.urmlDiagram.part.Messages.Hazard1Group_title);
		paletteContainer.add(createHazardCause1CreationTool());
		paletteContainer.add(createHazard2CreationTool());
		paletteContainer.add(createMitigation3CreationTool());
		paletteContainer.add(createMitigate4CreationTool());
		paletteContainer.add(createCauses5CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Functional Requirement" palette tool group
	 * @generated
	 */
	private PaletteContainer createFunctionalRequirement2Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				org.unicase.ui.urmlDiagram.part.Messages.FunctionalRequirement2Group_title);
		paletteContainer.add(createFunctionalRequirement1CreationTool());
		paletteContainer.add(createRefineRequirement2CreationTool());
		paletteContainer.add(createProvides3CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "UseCase" palette tool group
	 * @generated
	 */
	private PaletteContainer createUseCase3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				org.unicase.ui.urmlDiagram.part.Messages.UseCase3Group_title);
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
	private ToolEntry createHazard2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.Hazard_2003);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.Hazard2CreationTool_title,
				org.unicase.ui.urmlDiagram.part.Messages.Hazard2CreationTool_desc,
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
	private ToolEntry createMitigation3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.Mitigation_2002);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.Mitigation3CreationTool_title,
				org.unicase.ui.urmlDiagram.part.Messages.Mitigation3CreationTool_desc,
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
	private ToolEntry createMitigate4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.MitigationHazards_4013);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.MitigationCauses_4014);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.Mitigate4CreationTool_title,
				org.unicase.ui.urmlDiagram.part.Messages.Mitigate4CreationTool_desc,
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
	private ToolEntry createCauses5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.HazardCauseHazards_4016);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.Causes5CreationTool_title,
				org.unicase.ui.urmlDiagram.part.Messages.Causes5CreationTool_desc,
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
	private ToolEntry createFunctionalRequirement1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.FunctionalRequirement_2006);
		NodeToolEntry entry = new NodeToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.FunctionalRequirement1CreationTool_title,
				org.unicase.ui.urmlDiagram.part.Messages.FunctionalRequirement1CreationTool_desc,
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
	private ToolEntry createRefineRequirement2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.FunctionalRequirementRefinedRequirement_4015);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.RefineRequirement2CreationTool_title,
				org.unicase.ui.urmlDiagram.part.Messages.RefineRequirement2CreationTool_desc,
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
	private ToolEntry createProvides3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.FunctionalRequirementMitigations_4008);
		LinkToolEntry entry = new LinkToolEntry(
				org.unicase.ui.urmlDiagram.part.Messages.Provides3CreationTool_title,
				org.unicase.ui.urmlDiagram.part.Messages.Provides3CreationTool_desc,
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
				.add(org.unicase.ui.urmlDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_4012);
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
				.setSmallIcon(org.unicase.ui.urmlDiagram.part.ModelDiagramEditorPlugin
						.findImageDescriptor("/org.unicase.model.edit/icons/full/obj16/Hazard.gif")); //$NON-NLS-1$
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
