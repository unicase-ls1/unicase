package org.unicase.model.urml.ui.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
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
	 * 
	 * @generated
	 */
	private PaletteContainer createUrml1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Urml1Group_title);
		paletteContainer.setId("createUrml1Group"); //$NON-NLS-1$
		paletteContainer.add(createStakeholder1CreationTool());
		paletteContainer.add(createGoal2CreationTool());
		paletteContainer.add(createFunctionalRequirement3CreationTool());
		paletteContainer.add(createFeature4CreationTool());
		paletteContainer.add(createService5CreationTool());
		paletteContainer.add(createNonFunctionalRequirement6CreationTool());
		paletteContainer.add(createDanger7CreationTool());
		paletteContainer.add(createActor8CreationTool());
		paletteContainer.add(createProceduralMitigation9CreationTool());
		paletteContainer.add(createVariationPoint10CreationTool());
		paletteContainer.add(createVariationPointInstance11CreationTool());
		paletteContainer.add(createProduct12CreationTool());
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
	private ToolEntry createFunctionalRequirement3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.FunctionalRequirement_2006);
		NodeToolEntry entry = new NodeToolEntry(Messages.FunctionalRequirement3CreationTool_title, null, types);
		entry.setId("createFunctionalRequirement3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.FunctionalRequirement_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFeature4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.Feature_2012);
		NodeToolEntry entry = new NodeToolEntry(Messages.Feature4CreationTool_title, null, types);
		entry.setId("createFeature4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.Feature_2012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createService5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.Service_2007);
		NodeToolEntry entry = new NodeToolEntry(Messages.Service5CreationTool_title, null, types);
		entry.setId("createService5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.Service_2007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNonFunctionalRequirement6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.NonFunctionalRequirement_2008);
		NodeToolEntry entry = new NodeToolEntry(Messages.NonFunctionalRequirement6CreationTool_title, null, types);
		entry.setId("createNonFunctionalRequirement6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.NonFunctionalRequirement_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDanger7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.Danger_2009);
		NodeToolEntry entry = new NodeToolEntry(Messages.Danger7CreationTool_title, null, types);
		entry.setId("createDanger7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.Danger_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createActor8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.Actor_2010);
		NodeToolEntry entry = new NodeToolEntry(Messages.Actor8CreationTool_title, null, types);
		entry.setId("createActor8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.Actor_2010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProceduralMitigation9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.ProceduralMitigation_2011);
		NodeToolEntry entry = new NodeToolEntry(Messages.ProceduralMitigation9CreationTool_title, null, types);
		entry.setId("createProceduralMitigation9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.ProceduralMitigation_2011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVariationPoint10CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.VariationPoint_2013);
		NodeToolEntry entry = new NodeToolEntry(Messages.VariationPoint10CreationTool_title, null, types);
		entry.setId("createVariationPoint10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.VariationPoint_2013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createVariationPointInstance11CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.VariationPointInstance_2014);
		NodeToolEntry entry = new NodeToolEntry(Messages.VariationPointInstance11CreationTool_title, null, types);
		entry.setId("createVariationPointInstance11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.VariationPointInstance_2014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProduct12CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(UrmlElementTypes.Product_2015);
		NodeToolEntry entry = new NodeToolEntry(Messages.Product12CreationTool_title, null, types);
		entry.setId("createProduct12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(UrmlElementTypes.getImageDescriptor(UrmlElementTypes.Product_2015));
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
}
