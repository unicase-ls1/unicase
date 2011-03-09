package scrm.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class ScrmPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createSCRM1Group());
	}

	/**
	 * Creates "SCRM" palette tool group
	 * @generated
	 */
	private PaletteContainer createSCRM1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.SCRM1Group_title);
		paletteContainer.setId("createSCRM1Group"); //$NON-NLS-1$
		paletteContainer.add(createMathModel1CreationTool());
		paletteContainer.add(createNumMethod2CreationTool());
		paletteContainer.add(createModelToMethod3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMathModel1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.MathematicalModel_2001);
		NodeToolEntry entry = new NodeToolEntry(Messages.MathModel1CreationTool_title, null, types);
		entry.setId("createMathModel1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.MathematicalModel_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNumMethod2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.NumericalMethod_2002);
		NodeToolEntry entry = new NodeToolEntry(Messages.NumMethod2CreationTool_title, null, types);
		entry.setId("createNumMethod2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.NumericalMethod_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createModelToMethod3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.NumericalMethodMathematicalModel_4003);
		LinkToolEntry entry = new LinkToolEntry(Messages.ModelToMethod3CreationTool_title, null, types);
		entry.setId("createModelToMethod3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.NumericalMethodMathematicalModel_4003));
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
