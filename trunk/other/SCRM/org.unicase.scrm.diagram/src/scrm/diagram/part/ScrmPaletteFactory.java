package scrm.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
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
		paletteRoot.add(createKnowledge1Group());
		paletteRoot.add(createRequirements2Group());
	}

	/**
	 * Creates "Knowledge" palette tool group
	 * @generated
	 */
	private PaletteContainer createKnowledge1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Knowledge1Group_title);
		paletteContainer.setId("createKnowledge1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Knowledge1Group_desc);
		paletteContainer.add(createScientificProblem1CreationTool());
		paletteContainer.add(createMathematicalModel2CreationTool());
		paletteContainer.add(createNumericalMethod3CreationTool());
		paletteContainer.add(createAssumption4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Requirements" palette tool group
	 * @generated
	 */
	private PaletteContainer createRequirements2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Requirements2Group_title);
		paletteContainer.setId("createRequirements2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Requirements2Group_desc);
		paletteContainer.add(createFeature1CreationTool());
		paletteContainer.add(createHardware2CreationTool());
		paletteContainer.add(createConstraint3CreationTool());
		paletteContainer.add(createUserInterface4CreationTool());
		paletteContainer.add(createSoftwareInterface5CreationTool());
		paletteContainer.add(createProcess6CreationTool());
		paletteContainer.add(createPerformance7CreationTool());
		paletteContainer.add(createDataFlow8CreationTool());
		paletteContainer.add(createDataDefinition9CreationTool());
		paletteContainer.add(createInputDataReading10CreationTool());
		paletteContainer.add(createDataHandling11CreationTool());
		paletteContainer.add(createResultsOutput12CreationTool());
		paletteContainer.add(createErrorHandling13CreationTool());
		paletteContainer.add(createStatusMonitoring14CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createScientificProblem1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.ScientificProblem_2007);
		NodeToolEntry entry = new NodeToolEntry(Messages.ScientificProblem1CreationTool_title, null, types);
		entry.setId("createScientificProblem1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.ScientificProblem_2007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMathematicalModel2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.MathematicalModel_2005);
		NodeToolEntry entry = new NodeToolEntry(Messages.MathematicalModel2CreationTool_title, null, types);
		entry.setId("createMathematicalModel2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.MathematicalModel_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNumericalMethod3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.NumericalMethod_2006);
		NodeToolEntry entry = new NodeToolEntry(Messages.NumericalMethod3CreationTool_title, null, types);
		entry.setId("createNumericalMethod3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.NumericalMethod_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssumption4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.Assumption_2008);
		NodeToolEntry entry = new NodeToolEntry(Messages.Assumption4CreationTool_title, null, types);
		entry.setId("createAssumption4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.Assumption_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFeature1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.Feature_2009);
		NodeToolEntry entry = new NodeToolEntry(Messages.Feature1CreationTool_title, null, types);
		entry.setId("createFeature1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.Feature_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createHardware2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.Hardware_2010);
		NodeToolEntry entry = new NodeToolEntry(Messages.Hardware2CreationTool_title, null, types);
		entry.setId("createHardware2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.Hardware_2010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstraint3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.Constraint_2011);
		NodeToolEntry entry = new NodeToolEntry(Messages.Constraint3CreationTool_title, null, types);
		entry.setId("createConstraint3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.Constraint_2011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUserInterface4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.UserInterface_2012);
		NodeToolEntry entry = new NodeToolEntry(Messages.UserInterface4CreationTool_title, null, types);
		entry.setId("createUserInterface4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.UserInterface_2012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSoftwareInterface5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.SoftwareInterface_2013);
		NodeToolEntry entry = new NodeToolEntry(Messages.SoftwareInterface5CreationTool_title, null, types);
		entry.setId("createSoftwareInterface5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.SoftwareInterface_2013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProcess6CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.Process_2014);
		NodeToolEntry entry = new NodeToolEntry(Messages.Process6CreationTool_title,
			Messages.Process6CreationTool_desc, types);
		entry.setId("createProcess6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.Process_2014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPerformance7CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.Performance_2015);
		NodeToolEntry entry = new NodeToolEntry(Messages.Performance7CreationTool_title, null, types);
		entry.setId("createPerformance7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.Performance_2015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataFlow8CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.DataFlow_2016);
		NodeToolEntry entry = new NodeToolEntry(Messages.DataFlow8CreationTool_title, null, types);
		entry.setId("createDataFlow8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.DataFlow_2016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataDefinition9CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.DataDefinition_2017);
		NodeToolEntry entry = new NodeToolEntry(Messages.DataDefinition9CreationTool_title, null, types);
		entry.setId("createDataDefinition9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.DataDefinition_2017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInputDataReading10CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.InputDataReading_2018);
		NodeToolEntry entry = new NodeToolEntry(Messages.InputDataReading10CreationTool_title, null, types);
		entry.setId("createInputDataReading10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.InputDataReading_2018));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataHandling11CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.DataHandling_2019);
		NodeToolEntry entry = new NodeToolEntry(Messages.DataHandling11CreationTool_title, null, types);
		entry.setId("createDataHandling11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.DataHandling_2019));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResultsOutput12CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.ResultsOutput_2020);
		NodeToolEntry entry = new NodeToolEntry(Messages.ResultsOutput12CreationTool_title, null, types);
		entry.setId("createResultsOutput12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.ResultsOutput_2020));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createErrorHandling13CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.ErrorHandling_2021);
		NodeToolEntry entry = new NodeToolEntry(Messages.ErrorHandling13CreationTool_title, null, types);
		entry.setId("createErrorHandling13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.ErrorHandling_2021));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStatusMonitoring14CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(ScrmElementTypes.StatusMonitoring_2022);
		NodeToolEntry entry = new NodeToolEntry(Messages.StatusMonitoring14CreationTool_title, null, types);
		entry.setId("createStatusMonitoring14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes.getImageDescriptor(ScrmElementTypes.StatusMonitoring_2022));
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
