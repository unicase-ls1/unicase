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
	 * Creates a palette factory for a certain <code>scrmDiagram</code> of its
	 * type.
	 * 
	 * @param scrmDiagram
	 *            the SCRMDiagram the palette is created for
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
	 * 
	 * @generated
	 */
	private PaletteContainer createKnowledge1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Knowledge1Group_title);
		paletteContainer.setId("createKnowledge1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Knowledge1Group_desc);
		paletteContainer.add(createScientificProblem1CreationTool());
		paletteContainer
				.add(createMathematical_GeophysicalModel2CreationTool());
		paletteContainer.add(createNumericalMethod3CreationTool());
		paletteContainer.add(createAssumption4CreationTool());
		paletteContainer.add(createKnowledgeSpace5CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Requirements" palette tool group
	 * 
	 * @generated
	 */
	private PaletteContainer createRequirements2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Requirements2Group_title);
		paletteContainer.setId("createRequirements2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Requirements2Group_desc);
		paletteContainer.add(createRequirement1CreationTool());
		paletteContainer.add(createFeature2CreationTool());
		paletteContainer.add(createHardware3CreationTool());
		paletteContainer.add(createConstraint4CreationTool());
		paletteContainer.add(createUserInterface5CreationTool());
		paletteContainer.add(createSoftwareInterface6CreationTool());
		paletteContainer.add(createPerformance7CreationTool());
		paletteContainer.add(createRequirementSpace8CreationTool());
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(createProcess10CreationTool());
		paletteContainer.add(createInputDataReading11CreationTool());
		paletteContainer.add(createResultsOutput12CreationTool());
		paletteContainer.add(createErrorHandling13CreationTool());
		paletteContainer.add(createStatusMonitoring14CreationTool());
		paletteContainer.add(createSolver15CreationTool());
		paletteContainer.add(createMeshCreation16CreationTool());
		paletteContainer.add(createPreProcessing17CreationTool());
		paletteContainer.add(createPostProcessing18CreationTool());
		paletteContainer.add(createDataProcessSpace19CreationTool());
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(createDataDefinition21CreationTool());
		paletteContainer.add(createSeismicSource22CreationTool());
		paletteContainer.add(createComputationalMesh23CreationTool());
		paletteContainer.add(createSyntheticSeismogram24CreationTool());
		paletteContainer.add(createStation25CreationTool());
		paletteContainer.add(createControlParameter26CreationTool());
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
	private ToolEntry createMathematical_GeophysicalModel2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.Mathematical_GeophysicalModel_2047);
		types.add(ScrmElementTypes.Mathematical_GeophysicalModel_3030);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Mathematical_GeophysicalModel2CreationTool_title,
				null, types);
		entry.setId("createMathematical_GeophysicalModel2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Mathematical_GeophysicalModel_2047));
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
	private ToolEntry createRequirement1CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.Requirement_2034);
		types.add(ScrmElementTypes.Requirement_3012);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Requirement1CreationTool_title, null, types);
		entry.setId("createRequirement1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Requirement_2034));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFeature2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.Feature_2009);
		types.add(ScrmElementTypes.Feature_3009);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Feature2CreationTool_title, null, types);
		entry.setId("createFeature2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Feature_2009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createHardware3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.Hardware_2010);
		types.add(ScrmElementTypes.Hardware_3010);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Hardware3CreationTool_title, null, types);
		entry.setId("createHardware3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Hardware_2010));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createConstraint4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.Constraint_2011);
		types.add(ScrmElementTypes.Constraint_3006);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Constraint4CreationTool_title, null, types);
		entry.setId("createConstraint4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Constraint_2011));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createUserInterface5CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.UserInterface_2012);
		types.add(ScrmElementTypes.UserInterface_3014);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.UserInterface5CreationTool_title, null, types);
		entry.setId("createUserInterface5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.UserInterface_2012));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSoftwareInterface6CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.SoftwareInterface_2013);
		types.add(ScrmElementTypes.SoftwareInterface_3013);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SoftwareInterface6CreationTool_title, null, types);
		entry.setId("createSoftwareInterface6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.SoftwareInterface_2013));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPerformance7CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.Performance_2015);
		types.add(ScrmElementTypes.Performance_3011);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Performance7CreationTool_title, null, types);
		entry.setId("createPerformance7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Performance_2015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRequirementSpace8CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.RequirementSpace_2045);
		types.add(ScrmElementTypes.RequirementSpace_3015);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.RequirementSpace8CreationTool_title, null, types);
		entry.setId("createRequirementSpace8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.RequirementSpace_2045));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProcess10CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.Process_2035);
		types.add(ScrmElementTypes.Process_3025);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Process10CreationTool_title, null, types);
		entry.setId("createProcess10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Process_2035));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInputDataReading11CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.InputDataReading_2036);
		types.add(ScrmElementTypes.InputDataReading_3026);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.InputDataReading11CreationTool_title, null, types);
		entry.setId("createInputDataReading11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.InputDataReading_2036));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResultsOutput12CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.ResultsOutput_2038);
		types.add(ScrmElementTypes.ResultsOutput_3024);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ResultsOutput12CreationTool_title, null, types);
		entry.setId("createResultsOutput12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.ResultsOutput_2038));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createErrorHandling13CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.ErrorHandling_2039);
		types.add(ScrmElementTypes.ErrorHandling_3027);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ErrorHandling13CreationTool_title, null, types);
		entry.setId("createErrorHandling13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.ErrorHandling_2039));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStatusMonitoring14CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.StatusMonitoring_2040);
		types.add(ScrmElementTypes.StatusMonitoring_3023);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.StatusMonitoring14CreationTool_title, null, types);
		entry.setId("createStatusMonitoring14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.StatusMonitoring_2040));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSolver15CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.Solver_2048);
		types.add(ScrmElementTypes.Solver_3031);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Solver15CreationTool_title, null, types);
		entry.setId("createSolver15CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Solver_2048));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createMeshCreation16CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.MeshCreation_2049);
		types.add(ScrmElementTypes.MeshCreation_3032);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.MeshCreation16CreationTool_title, null, types);
		entry.setId("createMeshCreation16CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.MeshCreation_2049));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPreProcessing17CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.PreProcessing_2050);
		types.add(ScrmElementTypes.PreProcessing_3033);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.PreProcessing17CreationTool_title, null, types);
		entry.setId("createPreProcessing17CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.PreProcessing_2050));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPostProcessing18CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.PostProcessing_2051);
		types.add(ScrmElementTypes.PostProcessing_3034);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.PostProcessing18CreationTool_title, null, types);
		entry.setId("createPostProcessing18CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.PostProcessing_2051));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataProcessSpace19CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ScrmElementTypes.DataProcessSpace_3029);
		types.add(ScrmElementTypes.DataProcessSpace_2046);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DataProcessSpace19CreationTool_title, null, types);
		entry.setId("createDataProcessSpace19CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.DataProcessSpace_3029));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataDefinition21CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.DataDefinition_2052);
		types.add(ScrmElementTypes.DataDefinition_3035);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DataDefinition21CreationTool_title, null, types);
		entry.setId("createDataDefinition21CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.DataDefinition_2052));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSeismicSource22CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.SeismicSource_2053);
		types.add(ScrmElementTypes.SeismicSource_3036);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SeismicSource22CreationTool_title, null, types);
		entry.setId("createSeismicSource22CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.SeismicSource_2053));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createComputationalMesh23CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.ComputationalMesh_2054);
		types.add(ScrmElementTypes.ComputationalMesh_3037);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ComputationalMesh23CreationTool_title, null, types);
		entry.setId("createComputationalMesh23CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.ComputationalMesh_2054));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSyntheticSeismogram24CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.SyntheticSeismogram_2055);
		types.add(ScrmElementTypes.SyntheticSeismogram_3038);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SyntheticSeismogram24CreationTool_title, null, types);
		entry.setId("createSyntheticSeismogram24CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.SyntheticSeismogram_2055));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStation25CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.Station_2056);
		types.add(ScrmElementTypes.Station_3039);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Station25CreationTool_title, null, types);
		entry.setId("createStation25CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Station_2056));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createControlParameter26CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ScrmElementTypes.ControlParameter_2057);
		types.add(ScrmElementTypes.ControlParameter_3040);
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ControlParameter26CreationTool_title, null, types);
		entry.setId("createControlParameter26CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.ControlParameter_2057));
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
