package org.unicase.model.orga.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.unicase.model.orga.diagram.providers.OrgaElementTypes;

/**
 * @generated
 */
public class OrgaPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createOrga1Group());
	}

	/**
	 * Creates "orga" palette tool group
	 * @generated
	 */
	private PaletteContainer createOrga1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Orga1Group_title);
		paletteContainer.setId("createOrga1Group"); //$NON-NLS-1$
		paletteContainer.add(createTeam1CreationTool());
		paletteContainer.add(createTeamHasOrgUnit2CreationTool());
		paletteContainer.add(createEmployee3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTeam1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(OrgaElementTypes.Team_2002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Team1CreationTool_title,
				Messages.Team1CreationTool_desc, types);
		entry.setId("createTeam1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(OrgaElementTypes
				.getImageDescriptor(OrgaElementTypes.Team_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createTeamHasOrgUnit2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(OrgaElementTypes.TeamHasOrgUnit_4001);
		LinkToolEntry entry = new LinkToolEntry(
				Messages.TeamHasOrgUnit2CreationTool_title,
				Messages.TeamHasOrgUnit2CreationTool_desc, types);
		entry.setId("createTeamHasOrgUnit2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(OrgaElementTypes
				.getImageDescriptor(OrgaElementTypes.TeamHasOrgUnit_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEmployee3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(OrgaElementTypes.Employee_2001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Employee3CreationTool_title,
				Messages.Employee3CreationTool_desc, types);
		entry.setId("createEmployee3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(OrgaElementTypes
				.getImageDescriptor(OrgaElementTypes.Employee_2001));
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
