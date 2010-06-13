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
		paletteRoot.add(createDefault1Group());
		paletteRoot.add(createUrml2Group());
	}

	/**
	 * Creates "Default" palette tool group
	 * @generated
	 */
	private PaletteContainer createDefault1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Default1Group_title);
		paletteContainer.setId("createDefault1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Default1Group_desc);
		paletteContainer.add(createConstrains1CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "urml" palette tool group
	 * @generated
	 */
	private PaletteContainer createUrml2Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Urml2Group_title);
		paletteContainer.setId("createUrml2Group"); //$NON-NLS-1$
		paletteContainer.add(createStakeholder1CreationTool());
		paletteContainer.add(createGoal2CreationTool());
		paletteContainer.add(createExpresses3CreationTool());
		paletteContainer.add(createSubGoal4CreationTool());
		paletteContainer.add(createFunctionalRequirement5CreationTool());
		paletteContainer.add(createFeature6CreationTool());
		paletteContainer.add(createRealizes7CreationTool());
		paletteContainer.add(createService8CreationTool());
		paletteContainer.add(createSatisfies9CreationTool());
		paletteContainer.add(createNonFunctionalRequirement10CreationTool());
		paletteContainer.add(createDanger11CreationTool());
		paletteContainer.add(createDetails12CreationTool());
		paletteContainer.add(createActor13CreationTool());
		paletteContainer.add(createProceduralMitigation14CreationTool());
		paletteContainer.add(createServiceProvider15CreationTool());
		paletteContainer.add(createProvides16CreationTool());
		paletteContainer.add(createMitigates17CreationTool());
		paletteContainer.add(createHarms18CreationTool());
		paletteContainer.add(createTriggers19CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstrains1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.FeatureConstrainingNonFunctionalRequirements_4010);
		LinkToolEntry entry = new LinkToolEntry(Messages.Constrains1CreationTool_title, null, types);
		entry.setId("createConstrains1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes
			.getImageDescriptor(UrmlElementTypes.FeatureConstrainingNonFunctionalRequirements_4010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
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
	private ToolEntry createGoal2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.Goal_2001);
		NodeToolEntry entry = new NodeToolEntry(Messages.Goal2CreationTool_title, Messages.Goal2CreationTool_desc,
			types);
		entry.setId("createGoal2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.Goal_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createExpresses3CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.Expresses3CreationTool_title, Messages.Expresses3CreationTool_desc,
			null, null) {
		};
		entry.setId("createExpresses3CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSubGoal4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(UrmlElementTypes.StakeholderGoals_4008);
		types.add(UrmlElementTypes.GoalSubGoals_4009);
		LinkToolEntry entry = new LinkToolEntry(Messages.SubGoal4CreationTool_title,
			Messages.SubGoal4CreationTool_desc, types);
		entry.setId("createSubGoal4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.StakeholderGoals_4008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFunctionalRequirement5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.FunctionalRequirement_2006);
		NodeToolEntry entry = new NodeToolEntry(Messages.FunctionalRequirement5CreationTool_title, null, types);
		entry.setId("createFunctionalRequirement5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.FunctionalRequirement_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFeature6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.Feature_2005);
		NodeToolEntry entry = new NodeToolEntry(Messages.Feature6CreationTool_title, null, types);
		entry.setId("createFeature6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.Feature_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRealizes7CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.Realizes7CreationTool_title, null, null, null) {
		};
		entry.setId("createRealizes7CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createService8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.Service_2007);
		NodeToolEntry entry = new NodeToolEntry(Messages.Service8CreationTool_title, null, types);
		entry.setId("createService8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.Service_2007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSatisfies9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.GoalRealizedFeatures_4004);
		LinkToolEntry entry = new LinkToolEntry(Messages.Satisfies9CreationTool_title, null, types);
		entry.setId("createSatisfies9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.GoalRealizedFeatures_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNonFunctionalRequirement10CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.NonFunctionalRequirement_2008);
		NodeToolEntry entry = new NodeToolEntry(Messages.NonFunctionalRequirement10CreationTool_title, null, types);
		entry.setId("createNonFunctionalRequirement10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.NonFunctionalRequirement_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDanger11CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.Danger_2009);
		NodeToolEntry entry = new NodeToolEntry(Messages.Danger11CreationTool_title, null, types);
		entry.setId("createDanger11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.Danger_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDetails12CreationTool() {
		ToolEntry entry = new ToolEntry(Messages.Details12CreationTool_title, null, null, null) {
		};
		entry.setId("createDetails12CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActor13CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.Actor_2010);
		NodeToolEntry entry = new NodeToolEntry(Messages.Actor13CreationTool_title, null, types);
		entry.setId("createActor13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.Actor_2010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProceduralMitigation14CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.ProceduralMitigation_2011);
		NodeToolEntry entry = new NodeToolEntry(Messages.ProceduralMitigation14CreationTool_title, null, types);
		entry.setId("createProceduralMitigation14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.ProceduralMitigation_2011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createServiceProvider15CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.ServiceProvider_2012);
		NodeToolEntry entry = new NodeToolEntry(Messages.ServiceProvider15CreationTool_title, null, types);
		entry.setId("createServiceProvider15CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.ServiceProvider_2012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProvides16CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.ServiceServiceProvider_4011);
		LinkToolEntry entry = new LinkToolEntry(Messages.Provides16CreationTool_title, null, types);
		entry.setId("createProvides16CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.ServiceServiceProvider_4011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMitigates17CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.MitigationMitigatedDangers_4012);
		LinkToolEntry entry = new LinkToolEntry(Messages.Mitigates17CreationTool_title, null, types);
		entry.setId("createMitigates17CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.MitigationMitigatedDangers_4012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createHarms18CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.DangerHarmedAssets_4013);
		LinkToolEntry entry = new LinkToolEntry(Messages.Harms18CreationTool_title, null, types);
		entry.setId("createHarms18CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.DangerHarmedAssets_4013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTriggers19CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.ActorTriggeredDangers_4014);
		LinkToolEntry entry = new LinkToolEntry(Messages.Triggers19CreationTool_title, null, types);
		entry.setId("createTriggers19CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.ActorTriggeredDangers_4014));
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
