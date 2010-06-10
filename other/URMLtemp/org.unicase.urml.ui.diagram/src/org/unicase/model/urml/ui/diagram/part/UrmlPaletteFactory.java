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
