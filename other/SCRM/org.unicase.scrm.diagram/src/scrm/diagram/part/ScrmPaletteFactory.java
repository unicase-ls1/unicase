package scrm.diagram.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PaletteSeparator;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class ScrmPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createDefault1Group());
		paletteRoot.add(createKnowledge2Group());
		paletteRoot.add(createRequirements3Group());
	}

	/**
	 * Creates "Default" palette tool group
	 * @generated
	 */
	private PaletteContainer createDefault1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(
				Messages.Default1Group_title);
		paletteContainer.setId("createDefault1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Default1Group_desc);
		paletteContainer.add(createKnowledgeSpace1CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Knowledge" palette tool group
	 * @generated
	 */
	private PaletteContainer createKnowledge2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Knowledge2Group_title);
		paletteContainer.setId("createKnowledge2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Knowledge2Group_desc);
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
	private PaletteContainer createRequirements3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				Messages.Requirements3Group_title);
		paletteContainer.setId("createRequirements3Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Requirements3Group_desc);
		paletteContainer.add(createFeature1CreationTool());
		paletteContainer.add(createHardware2CreationTool());
		paletteContainer.add(createConstraint3CreationTool());
		paletteContainer.add(createUserInterface4CreationTool());
		paletteContainer.add(createSoftwareInterface5CreationTool());
		paletteContainer.add(createPerformance6CreationTool());
		paletteContainer.add(createDataFlow7CreationTool());
		paletteContainer.add(createDataDefinition8CreationTool());
		paletteContainer.add(createRequirement9CreationTool());
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(createInputDataReading11CreationTool());
		paletteContainer.add(createDataHandling12CreationTool());
		paletteContainer.add(createResultsOutput13CreationTool());
		paletteContainer.add(createErrorHandling14CreationTool());
		paletteContainer.add(createStatusMonitoring15CreationTool());
		paletteContainer.add(createProcess16CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createKnowledgeSpace1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.KnowledgeSpace1CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.KnowledgeSpace_2044));
		entry.setId("createKnowledgeSpace1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.KnowledgeSpace_2044));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createScientificProblem1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ScientificProblem1CreationTool_title, null,
				Collections
						.singletonList(ScrmElementTypes.ScientificProblem_2007));
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
		NodeToolEntry entry = new NodeToolEntry(
				Messages.MathematicalModel2CreationTool_title, null,
				Collections
						.singletonList(ScrmElementTypes.MathematicalModel_2005));
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
		NodeToolEntry entry = new NodeToolEntry(
				Messages.NumericalMethod3CreationTool_title, null,
				Collections
						.singletonList(ScrmElementTypes.NumericalMethod_2006));
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
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Assumption4CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.Assumption_2008));
		entry.setId("createAssumption4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Assumption_2008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createFeature1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Feature1CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.Feature_2009));
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
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Hardware2CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.Hardware_2010));
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
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Constraint3CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.Constraint_2011));
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
		NodeToolEntry entry = new NodeToolEntry(
				Messages.UserInterface4CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.UserInterface_2012));
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
		NodeToolEntry entry = new NodeToolEntry(
				Messages.SoftwareInterface5CreationTool_title, null,
				Collections
						.singletonList(ScrmElementTypes.SoftwareInterface_2013));
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
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Performance6CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.Performance_2015));
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
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DataFlow7CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.DataFlow_2016));
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
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DataDefinition8CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.DataDefinition_2017));
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
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Requirement9CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.Requirement_2034));
		entry.setId("createRequirement9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Requirement_2034));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInputDataReading11CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.InputDataReading11CreationTool_title, null,
				Collections
						.singletonList(ScrmElementTypes.InputDataReading_2036));
		entry.setId("createInputDataReading11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.InputDataReading_2036));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataHandling12CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DataHandling12CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.DataHandling_2037));
		entry.setId("createDataHandling12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.DataHandling_2037));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResultsOutput13CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ResultsOutput13CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.ResultsOutput_2038));
		entry.setId("createResultsOutput13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.ResultsOutput_2038));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createErrorHandling14CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ErrorHandling14CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.ErrorHandling_2039));
		entry.setId("createErrorHandling14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.ErrorHandling_2039));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStatusMonitoring15CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.StatusMonitoring15CreationTool_title, null,
				Collections
						.singletonList(ScrmElementTypes.StatusMonitoring_2040));
		entry.setId("createStatusMonitoring15CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.StatusMonitoring_2040));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProcess16CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Process16CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.Process_2035));
		entry.setId("createProcess16CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Process_2035));
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
