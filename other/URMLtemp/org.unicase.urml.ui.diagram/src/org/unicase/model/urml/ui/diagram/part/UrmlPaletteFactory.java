package org.unicase.model.urml.ui.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.unicase.model.urml.ui.diagram.providers.UrmlElementTypes;

/**
 * @generated
 */
public class UrmlPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createUrml1Group());
	}

	/**
	 * Creates "urml" palette tool group
	 * @generated
	 */
	private PaletteContainer createUrml1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Urml1Group_title);
		paletteContainer.setId("createUrml1Group"); //$NON-NLS-1$
		paletteContainer.add(createStakeholder1CreationTool());
		paletteContainer.add(createStakeholderGoals2CreationTool());
		paletteContainer.add(createGoal3CreationTool());
		paletteContainer.add(createGoalStakeholders4CreationTool());
		paletteContainer.add(createGoalSubGoals5CreationTool());
		paletteContainer.add(createGoalParentGoal6CreationTool());
		paletteContainer.add(createFunctionalRequirement7CreationTool());
		paletteContainer.add(createFeature8CreationTool());
		paletteContainer.add(createRealizes9CreationTool());
		paletteContainer.add(createService10CreationTool());
		paletteContainer.add(createSatisfies11CreationTool());
		paletteContainer.add(createNonFunctionalRequirement12CreationTool());
		paletteContainer.add(createDanger13CreationTool());
		paletteContainer.add(createDetails14CreationTool());
		paletteContainer.add(createActor15CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStakeholder1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.Stakeholder_2002);
		NodeToolEntry entry = new NodeToolEntry(Messages.Stakeholder1CreationTool_title,
			Messages.Stakeholder1CreationTool_desc, types);
		entry.setId("createStakeholder1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.Stakeholder_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStakeholderGoals2CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.StakeholderGoals2CreationTool_title,
			Messages.StakeholderGoals2CreationTool_desc, null, null) {
		};
		entry.setId("createStakeholderGoals2CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGoal3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.Goal_2001);
		NodeToolEntry entry = new NodeToolEntry(Messages.Goal3CreationTool_title, Messages.Goal3CreationTool_desc,
			types);
		entry.setId("createGoal3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.Goal_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGoalStakeholders4CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.GoalStakeholders4CreationTool_title,
			Messages.GoalStakeholders4CreationTool_desc, null, null) {
		};
		entry.setId("createGoalStakeholders4CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGoalSubGoals5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.Stakeholder_4001);
		LinkToolEntry entry = new LinkToolEntry(Messages.GoalSubGoals5CreationTool_title,
			Messages.GoalSubGoals5CreationTool_desc, types);
		entry.setId("createGoalSubGoals5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.Stakeholder_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGoalParentGoal6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.StakeholderGoals_4003);
		LinkToolEntry entry = new LinkToolEntry(Messages.GoalParentGoal6CreationTool_title,
			Messages.GoalParentGoal6CreationTool_desc, types);
		entry.setId("createGoalParentGoal6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.StakeholderGoals_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFunctionalRequirement7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.FunctionalRequirement_2006);
		NodeToolEntry entry = new NodeToolEntry(Messages.FunctionalRequirement7CreationTool_title, null, types);
		entry.setId("createFunctionalRequirement7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.FunctionalRequirement_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFeature8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.Feature_2005);
		NodeToolEntry entry = new NodeToolEntry(Messages.Feature8CreationTool_title, null, types);
		entry.setId("createFeature8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.Feature_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRealizes9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.GoalRealizedFeatures_4004);
		LinkToolEntry entry = new LinkToolEntry(Messages.Realizes9CreationTool_title, null, types);
		entry.setId("createRealizes9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.GoalRealizedFeatures_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createService10CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.Service_2007);
		NodeToolEntry entry = new NodeToolEntry(Messages.Service10CreationTool_title, null, types);
		entry.setId("createService10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.Service_2007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSatisfies11CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.RequirementImplementingServices_4005);
		LinkToolEntry entry = new LinkToolEntry(Messages.Satisfies11CreationTool_title, null, types);
		entry.setId("createSatisfies11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.RequirementImplementingServices_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNonFunctionalRequirement12CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.NonFunctionalRequirement_2008);
		NodeToolEntry entry = new NodeToolEntry(Messages.NonFunctionalRequirement12CreationTool_title, null, types);
		entry.setId("createNonFunctionalRequirement12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.NonFunctionalRequirement_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDanger13CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.Danger_2009);
		NodeToolEntry entry = new NodeToolEntry(Messages.Danger13CreationTool_title, null, types);
		entry.setId("createDanger13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.Danger_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDetails14CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.FeatureDetailingFunctionalRequirements_4006);
		LinkToolEntry entry = new LinkToolEntry(Messages.Details14CreationTool_title, null, types);
		entry.setId("createDetails14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes
			.getImageDescriptor(UrmlElementTypes.FeatureDetailingFunctionalRequirements_4006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActor15CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.Actor_2010);
		NodeToolEntry entry = new NodeToolEntry(Messages.Actor15CreationTool_title, null, types);
		entry.setId("createActor15CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.Actor_2010));
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
		private NodeToolEntry(String title, String description, List elementTypes) {
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
		private LinkToolEntry(String title, String description, List relationshipTypes) {
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
