package scrm.diagram.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import scrm.DiagramType;
import scrm.SCRMDiagram;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class ScrmPaletteFactory {

	/**
	 * @generated NOT
	 */
	private final DiagramType diagramType;

	/**
	 * Creates a palette factory for a certain <code>scrmDiagram</code> of its type.
	 * @param scrmDiagram the SCRMDiagram the palette is created for
	 * @generated NOT
	 */
	public ScrmPaletteFactory(SCRMDiagram scrmDiagram) {
		diagramType = scrmDiagram.getDiagramType();
	}

	/**
	 * @generated NOT: take diagram type into account
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		switch (diagramType) {
		case KNOWLEDGE_DIAGRAM:
			paletteRoot.add(createKnowledge1Group());
			break;
		case DEFAULT_DIAGRAM:
			paletteRoot.add(createKnowledge1Group());
		case REQUIREMENTS_DIAGRAM:
			paletteRoot.add(createRequirements2Group());
			break;
		case DATA_PROCESS_DIAGRAM:
			PaletteContainer requirementsGroup = createRequirements2Group();
			requirementsGroup.setLabel(Messages.DataProcessSteps3Group_title);
			requirementsGroup
					.setDescription(Messages.DataProcessSteps3Group_desc);
			List nonDataProcessRequirements = new ArrayList(requirementsGroup
					.getChildren().subList(0, 10));
			requirementsGroup.getChildren().removeAll(
					nonDataProcessRequirements);
			paletteRoot.add(requirementsGroup);
		}

	}

	/**
	 * Creates "Knowledge" palette tool group
	 * @generated
	 */
	private PaletteContainer createKnowledge1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Knowledge1Group_title);
		paletteContainer.setId("createKnowledge1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Knowledge1Group_desc);
		paletteContainer.add(createScientificProblem1CreationTool());
		paletteContainer.add(createMathematicalModel2CreationTool());
		paletteContainer.add(createNumericalMethod3CreationTool());
		paletteContainer.add(createAssumption4CreationTool());
		paletteContainer.add(createKnowledgeSpace5CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Requirements" palette tool group
	 * @generated
	 */
	private PaletteContainer createRequirements2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Requirements2Group_title);
		paletteContainer.setId("createRequirements2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Requirements2Group_desc);
		paletteContainer.add(createFeature1CreationTool());
		paletteContainer.add(createHardware2CreationTool());
		paletteContainer.add(createConstraint3CreationTool());
		paletteContainer.add(createUserInterface4CreationTool());
		paletteContainer.add(createSoftwareInterface5CreationTool());
		paletteContainer.add(createPerformance6CreationTool());
		paletteContainer.add(createDataFlow7CreationTool());
		paletteContainer.add(createDataDefinition8CreationTool());
		paletteContainer.add(createRequirement9CreationTool());
		paletteContainer.add(createRequirementSpace10CreationTool());
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(createInputDataReading12CreationTool());
		paletteContainer.add(createDataHandling13CreationTool());
		paletteContainer.add(createResultsOutput14CreationTool());
		paletteContainer.add(createErrorHandling15CreationTool());
		paletteContainer.add(createStatusMonitoring16CreationTool());
		paletteContainer.add(createProcess17CreationTool());
		paletteContainer.add(createDataProcessSpace18CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createScientificProblem1CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.ScientificProblem_2007);
		types.add(ScrmElementTypes.ScientificProblem_3001);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ScientificProblem1CreationTool_title, null, types);
		entry.setId("createScientificProblem1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.ScientificProblem_2007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMathematicalModel2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.MathematicalModel_2005);
		types.add(ScrmElementTypes.MathematicalModel_3003);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.MathematicalModel2CreationTool_title, null, types);
		entry.setId("createMathematicalModel2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.MathematicalModel_2005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createNumericalMethod3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.NumericalMethod_2006);
		types.add(ScrmElementTypes.NumericalMethod_3002);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.NumericalMethod3CreationTool_title, null, types);
		entry.setId("createNumericalMethod3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.NumericalMethod_2006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssumption4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.Assumption_2008);
		types.add(ScrmElementTypes.Assumption_3004);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Assumption4CreationTool_title, null, types);
		entry.setId("createAssumption4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Assumption_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createKnowledgeSpace5CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.KnowledgeSpace_2044);
		types.add(ScrmElementTypes.KnowledgeSpace_3005);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.KnowledgeSpace5CreationTool_title, null, types);
		entry.setId("createKnowledgeSpace5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.KnowledgeSpace_2044));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFeature1CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.Feature_2009);
		types.add(ScrmElementTypes.Feature_3009);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Feature1CreationTool_title, null, types);
		entry.setId("createFeature1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Feature_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createHardware2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.Hardware_2010);
		types.add(ScrmElementTypes.Hardware_3010);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Hardware2CreationTool_title, null, types);
		entry.setId("createHardware2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Hardware_2010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstraint3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.Constraint_2011);
		types.add(ScrmElementTypes.Constraint_3006);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Constraint3CreationTool_title, null, types);
		entry.setId("createConstraint3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Constraint_2011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUserInterface4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.UserInterface_2012);
		types.add(ScrmElementTypes.UserInterface_3014);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.UserInterface4CreationTool_title, null, types);
		entry.setId("createUserInterface4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.UserInterface_2012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSoftwareInterface5CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.SoftwareInterface_2013);
		types.add(ScrmElementTypes.SoftwareInterface_3013);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SoftwareInterface5CreationTool_title, null, types);
		entry.setId("createSoftwareInterface5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.SoftwareInterface_2013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPerformance6CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.Performance_2015);
		types.add(ScrmElementTypes.Performance_3011);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Performance6CreationTool_title, null, types);
		entry.setId("createPerformance6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Performance_2015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataFlow7CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.DataFlow_2016);
		types.add(ScrmElementTypes.DataFlow_3008);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DataFlow7CreationTool_title, null, types);
		entry.setId("createDataFlow7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.DataFlow_2016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataDefinition8CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.DataDefinition_2017);
		types.add(ScrmElementTypes.DataDefinition_3007);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DataDefinition8CreationTool_title, null, types);
		entry.setId("createDataDefinition8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.DataDefinition_2017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRequirement9CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.Requirement_2034);
		types.add(ScrmElementTypes.Requirement_3012);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Requirement9CreationTool_title, null, types);
		entry.setId("createRequirement9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Requirement_2034));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRequirementSpace10CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.RequirementSpace_2045);
		types.add(ScrmElementTypes.RequirementSpace_3015);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.RequirementSpace10CreationTool_title, null, types);
		entry.setId("createRequirementSpace10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.RequirementSpace_2045));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInputDataReading12CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.InputDataReading_2036);
		types.add(ScrmElementTypes.InputDataReading_3026);
		types.add(ScrmElementTypes.InputDataReading_3019);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.InputDataReading12CreationTool_title, null, types);
		entry.setId("createInputDataReading12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.InputDataReading_2036));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataHandling13CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.DataHandling_2037);
		types.add(ScrmElementTypes.DataHandling_3028);
		types.add(ScrmElementTypes.DataHandling_3021);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DataHandling13CreationTool_title, null, types);
		entry.setId("createDataHandling13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.DataHandling_2037));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResultsOutput14CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.ResultsOutput_2038);
		types.add(ScrmElementTypes.ResultsOutput_3024);
		types.add(ScrmElementTypes.ResultsOutput_3017);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ResultsOutput14CreationTool_title, null, types);
		entry.setId("createResultsOutput14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.ResultsOutput_2038));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createErrorHandling15CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.ErrorHandling_2039);
		types.add(ScrmElementTypes.ErrorHandling_3027);
		types.add(ScrmElementTypes.ErrorHandling_3020);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ErrorHandling15CreationTool_title, null, types);
		entry.setId("createErrorHandling15CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.ErrorHandling_2039));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStatusMonitoring16CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.StatusMonitoring_2040);
		types.add(ScrmElementTypes.StatusMonitoring_3023);
		types.add(ScrmElementTypes.StatusMonitoring_3016);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.StatusMonitoring16CreationTool_title, null, types);
		entry.setId("createStatusMonitoring16CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.StatusMonitoring_2040));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProcess17CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.Process_2035);
		types.add(ScrmElementTypes.Process_3025);
		types.add(ScrmElementTypes.Process_3018);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Process17CreationTool_title, null, types);
		entry.setId("createProcess17CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Process_2035));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataProcessSpace18CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.DataProcessSpace_3029);
		types.add(ScrmElementTypes.DataProcessSpace_3022);
		types.add(ScrmElementTypes.DataProcessSpace_2046);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DataProcessSpace18CreationTool_title, null, types);
		entry.setId("createDataProcessSpace18CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.DataProcessSpace_3029));
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
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description,
				List<IElementType> elementTypes) {
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
