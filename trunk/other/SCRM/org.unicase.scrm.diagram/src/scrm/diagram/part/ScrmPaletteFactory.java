package scrm.diagram.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
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
		paletteRoot.add(createKnowledge1Group());
		paletteRoot.add(createRequirements2Group());
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
	private ToolEntry createProcess6CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Process6CreationTool_title,
				Messages.Process6CreationTool_desc,
				Collections.singletonList(ScrmElementTypes.Process_2014));
		entry.setId("createProcess6CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Process_2014));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createPerformance7CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.Performance7CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.Performance_2015));
		entry.setId("createPerformance7CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.Performance_2015));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataFlow8CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DataFlow8CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.DataFlow_2016));
		entry.setId("createDataFlow8CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.DataFlow_2016));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataDefinition9CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DataDefinition9CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.DataDefinition_2017));
		entry.setId("createDataDefinition9CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.DataDefinition_2017));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createInputDataReading10CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.InputDataReading10CreationTool_title, null,
				Collections
						.singletonList(ScrmElementTypes.InputDataReading_2018));
		entry.setId("createInputDataReading10CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.InputDataReading_2018));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDataHandling11CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.DataHandling11CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.DataHandling_2019));
		entry.setId("createDataHandling11CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.DataHandling_2019));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createResultsOutput12CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ResultsOutput12CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.ResultsOutput_2020));
		entry.setId("createResultsOutput12CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.ResultsOutput_2020));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createErrorHandling13CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.ErrorHandling13CreationTool_title, null,
				Collections.singletonList(ScrmElementTypes.ErrorHandling_2021));
		entry.setId("createErrorHandling13CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.ErrorHandling_2021));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createStatusMonitoring14CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(
				Messages.StatusMonitoring14CreationTool_title, null,
				Collections
						.singletonList(ScrmElementTypes.StatusMonitoring_2022));
		entry.setId("createStatusMonitoring14CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ScrmElementTypes
				.getImageDescriptor(ScrmElementTypes.StatusMonitoring_2022));
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
