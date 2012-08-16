package scrm.diagram.providers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import scrm.DiagramType;
import scrm.SCRMDiagram;
import scrm.diagram.edit.parts.Assumption2EditPart;
import scrm.diagram.edit.parts.AssumptionEditPart;
import scrm.diagram.edit.parts.ComputationalMesh2EditPart;
import scrm.diagram.edit.parts.ComputationalMeshEditPart;
import scrm.diagram.edit.parts.Constraint2EditPart;
import scrm.diagram.edit.parts.ConstraintEditPart;
import scrm.diagram.edit.parts.ControlParameter2EditPart;
import scrm.diagram.edit.parts.ControlParameterEditPart;
import scrm.diagram.edit.parts.DataDefinition2EditPart;
import scrm.diagram.edit.parts.DataDefinitionEditPart;
import scrm.diagram.edit.parts.DataProcessSpace2EditPart;
import scrm.diagram.edit.parts.DataProcessSpaceDataProcessSpaceCompartment2EditPart;
import scrm.diagram.edit.parts.DataProcessSpaceDataProcessSpaceCompartmentEditPart;
import scrm.diagram.edit.parts.DataProcessSpaceEditPart;
import scrm.diagram.edit.parts.ErrorHandling2EditPart;
import scrm.diagram.edit.parts.ErrorHandlingEditPart;
import scrm.diagram.edit.parts.Feature2EditPart;
import scrm.diagram.edit.parts.FeatureEditPart;
import scrm.diagram.edit.parts.Hardware2EditPart;
import scrm.diagram.edit.parts.HardwareEditPart;
import scrm.diagram.edit.parts.InputDataReading2EditPart;
import scrm.diagram.edit.parts.InputDataReadingEditPart;
import scrm.diagram.edit.parts.KnowledgeSpaceKnowledgeSpaceCompartment2EditPart;
import scrm.diagram.edit.parts.KnowledgeSpaceKnowledgeSpaceCompartmentEditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModel2EditPart;
import scrm.diagram.edit.parts.Mathematical_GeophysicalModelEditPart;
import scrm.diagram.edit.parts.MeshCreation2EditPart;
import scrm.diagram.edit.parts.MeshCreationEditPart;
import scrm.diagram.edit.parts.NumericalMethod2EditPart;
import scrm.diagram.edit.parts.NumericalMethodEditPart;
import scrm.diagram.edit.parts.Performance2EditPart;
import scrm.diagram.edit.parts.PerformanceEditPart;
import scrm.diagram.edit.parts.PostProcessing2EditPart;
import scrm.diagram.edit.parts.PostProcessingEditPart;
import scrm.diagram.edit.parts.PreProcessing2EditPart;
import scrm.diagram.edit.parts.PreProcessingEditPart;
import scrm.diagram.edit.parts.Process2EditPart;
import scrm.diagram.edit.parts.ProcessEditPart;
import scrm.diagram.edit.parts.Requirement2EditPart;
import scrm.diagram.edit.parts.RequirementEditPart;
import scrm.diagram.edit.parts.RequirementSpaceRequirementSpaceCompartment2EditPart;
import scrm.diagram.edit.parts.RequirementSpaceRequirementSpaceCompartmentEditPart;
import scrm.diagram.edit.parts.ResultsOutput2EditPart;
import scrm.diagram.edit.parts.ResultsOutputEditPart;
import scrm.diagram.edit.parts.SCRMDiagramEditPart;
import scrm.diagram.edit.parts.ScientificProblem2EditPart;
import scrm.diagram.edit.parts.ScientificProblemEditPart;
import scrm.diagram.edit.parts.SeismicSource2EditPart;
import scrm.diagram.edit.parts.SeismicSourceEditPart;
import scrm.diagram.edit.parts.SoftwareInterface2EditPart;
import scrm.diagram.edit.parts.SoftwareInterfaceEditPart;
import scrm.diagram.edit.parts.Solver2EditPart;
import scrm.diagram.edit.parts.SolverEditPart;
import scrm.diagram.edit.parts.Station2EditPart;
import scrm.diagram.edit.parts.StationEditPart;
import scrm.diagram.edit.parts.StatusMonitoring2EditPart;
import scrm.diagram.edit.parts.StatusMonitoringEditPart;
import scrm.diagram.edit.parts.SyntheticSeismogram2EditPart;
import scrm.diagram.edit.parts.SyntheticSeismogramEditPart;
import scrm.diagram.edit.parts.UserInterface2EditPart;
import scrm.diagram.edit.parts.UserInterfaceEditPart;
import scrm.diagram.part.Messages;
import scrm.diagram.part.ScrmDiagramEditorPlugin;

/**
 * @generated
 */
public class ScrmModelingAssistantProvider extends ModelingAssistantProvider {

	/**
	 * @generated NOT
	 */
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart instanceof SCRMDiagramEditPart) {
			SCRMDiagram scrmDiagram = (SCRMDiagram) ((Diagram) editPart
					.getModel()).getElement();
			return getAllowedTypes(scrmDiagram.getDiagramType());
		}
		if (editPart instanceof KnowledgeSpaceKnowledgeSpaceCompartmentEditPart
				|| editPart instanceof KnowledgeSpaceKnowledgeSpaceCompartment2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(5);
			types.add(ScrmElementTypes.ScientificProblem_3001);
			types.add(ScrmElementTypes.NumericalMethod_3002);
			types.add(ScrmElementTypes.Mathematical_GeophysicalModel_3030);
			types.add(ScrmElementTypes.Assumption_3004);
			types.add(ScrmElementTypes.KnowledgeSpace_3005);
			return types;
		}
		if (editPart instanceof RequirementSpaceRequirementSpaceCompartmentEditPart
				|| editPart instanceof RequirementSpaceRequirementSpaceCompartment2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(24);
			types.add(ScrmElementTypes.Requirement_3012);
			types.add(ScrmElementTypes.Feature_3009);
			types.add(ScrmElementTypes.Hardware_3010);
			types.add(ScrmElementTypes.Constraint_3006);
			types.add(ScrmElementTypes.UserInterface_3014);
			types.add(ScrmElementTypes.SoftwareInterface_3013);
			types.add(ScrmElementTypes.Performance_3011);
			types.add(ScrmElementTypes.Process_3025);
			types.add(ScrmElementTypes.InputDataReading_3026);
			types.add(ScrmElementTypes.ResultsOutput_3024);
			types.add(ScrmElementTypes.ErrorHandling_3027);
			types.add(ScrmElementTypes.StatusMonitoring_3023);
			types.add(ScrmElementTypes.Solver_3031);
			types.add(ScrmElementTypes.MeshCreation_3032);
			types.add(ScrmElementTypes.PreProcessing_3033);
			types.add(ScrmElementTypes.PostProcessing_3034);
			types.add(ScrmElementTypes.DataDefinition_3035);
			types.add(ScrmElementTypes.SeismicSource_3036);
			types.add(ScrmElementTypes.ComputationalMesh_3037);
			types.add(ScrmElementTypes.SyntheticSeismogram_3038);
			types.add(ScrmElementTypes.Station_3039);
			types.add(ScrmElementTypes.ControlParameter_3040);
			types.add(ScrmElementTypes.RequirementSpace_3015);
			types.add(ScrmElementTypes.DataProcessSpace_3029);
			return types;
		}
		if (editPart instanceof DataProcessSpaceDataProcessSpaceCompartmentEditPart
				|| editPart instanceof DataProcessSpaceDataProcessSpaceCompartment2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(10);
			types.add(ScrmElementTypes.Process_3025);
			types.add(ScrmElementTypes.InputDataReading_3026);
			types.add(ScrmElementTypes.ResultsOutput_3024);
			types.add(ScrmElementTypes.ErrorHandling_3027);
			types.add(ScrmElementTypes.StatusMonitoring_3023);
			types.add(ScrmElementTypes.DataProcessSpace_3029);
			types.add(ScrmElementTypes.Solver_3031);
			types.add(ScrmElementTypes.MeshCreation_3032);
			types.add(ScrmElementTypes.PreProcessing_3033);
			types.add(ScrmElementTypes.PostProcessing_3034);
			return types;
		}
		return Collections.emptyList();
	}

	/**
	 * Obtains all <code>IElementType</code>s, that are allowed for a certain
	 * diagram type.
	 * 
	 * @param diagramType
	 *            the {@link DiagramType} to get types for
	 * @return all types that are allowed for <code>diagramType</code> as a
	 *         list.
	 */
	public static List<IElementType> getAllowedTypes(DiagramType diagramType) {
		List<IElementType> types = new LinkedList<IElementType>();
		switch (diagramType) {
		case KNOWLEDGE_DIAGRAM:
			types.addAll(getKnowledgeTypes());
			break;
		case DEFAULT_DIAGRAM:
			types.addAll(getKnowledgeTypes());
		case REQUIREMENTS_DIAGRAM:
			types.addAll(getRequirementTypes());
		case DATA_PROCESS_DIAGRAM:
			types.addAll(getDataProcessTypes());
		}
		return types;
	}

	private static List<IElementType> getRequirementTypes() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(14);
		types.add(ScrmElementTypes.Requirement_2034);
		types.add(ScrmElementTypes.Feature_2009);
		types.add(ScrmElementTypes.Hardware_2010);
		types.add(ScrmElementTypes.Constraint_2011);
		types.add(ScrmElementTypes.UserInterface_2012);
		types.add(ScrmElementTypes.SoftwareInterface_2013);
		types.add(ScrmElementTypes.Performance_2015);
		types.add(ScrmElementTypes.DataDefinition_2052);
		types.add(ScrmElementTypes.SeismicSource_2053);
		types.add(ScrmElementTypes.ComputationalMesh_2054);
		types.add(ScrmElementTypes.SyntheticSeismogram_2055);
		types.add(ScrmElementTypes.Station_2056);
		types.add(ScrmElementTypes.ControlParameter_2057);
		types.add(ScrmElementTypes.RequirementSpace_2045);
		return types;
	}

	private static List<IElementType> getDataProcessTypes() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(10);
		types.add(ScrmElementTypes.Process_2035);
		types.add(ScrmElementTypes.InputDataReading_2036);
		types.add(ScrmElementTypes.ResultsOutput_2038);
		types.add(ScrmElementTypes.ErrorHandling_2039);
		types.add(ScrmElementTypes.StatusMonitoring_2040);
		types.add(ScrmElementTypes.Solver_2048);
		types.add(ScrmElementTypes.MeshCreation_2049);
		types.add(ScrmElementTypes.PreProcessing_2050);
		types.add(ScrmElementTypes.PostProcessing_2051);
		types.add(ScrmElementTypes.DataProcessSpace_2046);
		return types;
	}

	private static List<IElementType> getKnowledgeTypes() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(5);
		types.add(ScrmElementTypes.ScientificProblem_2007);
		types.add(ScrmElementTypes.NumericalMethod_2006);
		types.add(ScrmElementTypes.Mathematical_GeophysicalModel_2047);
		types.add(ScrmElementTypes.Assumption_2008);
		types.add(ScrmElementTypes.KnowledgeSpace_2044);
		return types;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ScientificProblemEditPart) {
			return ((ScientificProblemEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Mathematical_GeophysicalModelEditPart) {
			return ((Mathematical_GeophysicalModelEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof NumericalMethodEditPart) {
			return ((NumericalMethodEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof RequirementEditPart) {
			return ((RequirementEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FeatureEditPart) {
			return ((FeatureEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof UserInterfaceEditPart) {
			return ((UserInterfaceEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SoftwareInterfaceEditPart) {
			return ((SoftwareInterfaceEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PerformanceEditPart) {
			return ((PerformanceEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ProcessEditPart) {
			return ((ProcessEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InputDataReadingEditPart) {
			return ((InputDataReadingEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ResultsOutputEditPart) {
			return ((ResultsOutputEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ErrorHandlingEditPart) {
			return ((ErrorHandlingEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof StatusMonitoringEditPart) {
			return ((StatusMonitoringEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SolverEditPart) {
			return ((SolverEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof MeshCreationEditPart) {
			return ((MeshCreationEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PreProcessingEditPart) {
			return ((PreProcessingEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PostProcessingEditPart) {
			return ((PostProcessingEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DataDefinitionEditPart) {
			return ((DataDefinitionEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SeismicSourceEditPart) {
			return ((SeismicSourceEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ComputationalMeshEditPart) {
			return ((ComputationalMeshEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SyntheticSeismogramEditPart) {
			return ((SyntheticSeismogramEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof StationEditPart) {
			return ((StationEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ControlParameterEditPart) {
			return ((ControlParameterEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DataProcessSpaceEditPart) {
			return ((DataProcessSpaceEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ScientificProblem2EditPart) {
			return ((ScientificProblem2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof NumericalMethod2EditPart) {
			return ((NumericalMethod2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Mathematical_GeophysicalModel2EditPart) {
			return ((Mathematical_GeophysicalModel2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Requirement2EditPart) {
			return ((Requirement2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Feature2EditPart) {
			return ((Feature2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Constraint2EditPart) {
			return ((Constraint2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof UserInterface2EditPart) {
			return ((UserInterface2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SoftwareInterface2EditPart) {
			return ((SoftwareInterface2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Performance2EditPart) {
			return ((Performance2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Process2EditPart) {
			return ((Process2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InputDataReading2EditPart) {
			return ((InputDataReading2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ResultsOutput2EditPart) {
			return ((ResultsOutput2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ErrorHandling2EditPart) {
			return ((ErrorHandling2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof StatusMonitoring2EditPart) {
			return ((StatusMonitoring2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Solver2EditPart) {
			return ((Solver2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof MeshCreation2EditPart) {
			return ((MeshCreation2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PreProcessing2EditPart) {
			return ((PreProcessing2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PostProcessing2EditPart) {
			return ((PostProcessing2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DataDefinition2EditPart) {
			return ((DataDefinition2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SeismicSource2EditPart) {
			return ((SeismicSource2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ComputationalMesh2EditPart) {
			return ((ComputationalMesh2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof SyntheticSeismogram2EditPart) {
			return ((SyntheticSeismogram2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Station2EditPart) {
			return ((Station2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ControlParameter2EditPart) {
			return ((ControlParameter2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DataProcessSpace2EditPart) {
			return ((DataProcessSpace2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ScientificProblemEditPart) {
			return ((ScientificProblemEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Mathematical_GeophysicalModelEditPart) {
			return ((Mathematical_GeophysicalModelEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof NumericalMethodEditPart) {
			return ((NumericalMethodEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof AssumptionEditPart) {
			return ((AssumptionEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof RequirementEditPart) {
			return ((RequirementEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof FeatureEditPart) {
			return ((FeatureEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof HardwareEditPart) {
			return ((HardwareEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof UserInterfaceEditPart) {
			return ((UserInterfaceEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof SoftwareInterfaceEditPart) {
			return ((SoftwareInterfaceEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PerformanceEditPart) {
			return ((PerformanceEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ProcessEditPart) {
			return ((ProcessEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InputDataReadingEditPart) {
			return ((InputDataReadingEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ResultsOutputEditPart) {
			return ((ResultsOutputEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ErrorHandlingEditPart) {
			return ((ErrorHandlingEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof StatusMonitoringEditPart) {
			return ((StatusMonitoringEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof SolverEditPart) {
			return ((SolverEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof MeshCreationEditPart) {
			return ((MeshCreationEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PreProcessingEditPart) {
			return ((PreProcessingEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PostProcessingEditPart) {
			return ((PostProcessingEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DataDefinitionEditPart) {
			return ((DataDefinitionEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof SeismicSourceEditPart) {
			return ((SeismicSourceEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ComputationalMeshEditPart) {
			return ((ComputationalMeshEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof SyntheticSeismogramEditPart) {
			return ((SyntheticSeismogramEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof StationEditPart) {
			return ((StationEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DataProcessSpaceEditPart) {
			return ((DataProcessSpaceEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ScientificProblem2EditPart) {
			return ((ScientificProblem2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof NumericalMethod2EditPart) {
			return ((NumericalMethod2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Mathematical_GeophysicalModel2EditPart) {
			return ((Mathematical_GeophysicalModel2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Assumption2EditPart) {
			return ((Assumption2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Requirement2EditPart) {
			return ((Requirement2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Feature2EditPart) {
			return ((Feature2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Hardware2EditPart) {
			return ((Hardware2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof UserInterface2EditPart) {
			return ((UserInterface2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof SoftwareInterface2EditPart) {
			return ((SoftwareInterface2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Performance2EditPart) {
			return ((Performance2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Process2EditPart) {
			return ((Process2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InputDataReading2EditPart) {
			return ((InputDataReading2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ResultsOutput2EditPart) {
			return ((ResultsOutput2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ErrorHandling2EditPart) {
			return ((ErrorHandling2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof StatusMonitoring2EditPart) {
			return ((StatusMonitoring2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Solver2EditPart) {
			return ((Solver2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof MeshCreation2EditPart) {
			return ((MeshCreation2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PreProcessing2EditPart) {
			return ((PreProcessing2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PostProcessing2EditPart) {
			return ((PostProcessing2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DataDefinition2EditPart) {
			return ((DataDefinition2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof SeismicSource2EditPart) {
			return ((SeismicSource2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ComputationalMesh2EditPart) {
			return ((ComputationalMesh2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof SyntheticSeismogram2EditPart) {
			return ((SyntheticSeismogram2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Station2EditPart) {
			return ((Station2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DataProcessSpace2EditPart) {
			return ((DataProcessSpace2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ScientificProblemEditPart) {
			return ((ScientificProblemEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Mathematical_GeophysicalModelEditPart) {
			return ((Mathematical_GeophysicalModelEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof NumericalMethodEditPart) {
			return ((NumericalMethodEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof RequirementEditPart) {
			return ((RequirementEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof FeatureEditPart) {
			return ((FeatureEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof UserInterfaceEditPart) {
			return ((UserInterfaceEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SoftwareInterfaceEditPart) {
			return ((SoftwareInterfaceEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PerformanceEditPart) {
			return ((PerformanceEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ProcessEditPart) {
			return ((ProcessEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InputDataReadingEditPart) {
			return ((InputDataReadingEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ResultsOutputEditPart) {
			return ((ResultsOutputEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ErrorHandlingEditPart) {
			return ((ErrorHandlingEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof StatusMonitoringEditPart) {
			return ((StatusMonitoringEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SolverEditPart) {
			return ((SolverEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof MeshCreationEditPart) {
			return ((MeshCreationEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PreProcessingEditPart) {
			return ((PreProcessingEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PostProcessingEditPart) {
			return ((PostProcessingEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DataDefinitionEditPart) {
			return ((DataDefinitionEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SeismicSourceEditPart) {
			return ((SeismicSourceEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ComputationalMeshEditPart) {
			return ((ComputationalMeshEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SyntheticSeismogramEditPart) {
			return ((SyntheticSeismogramEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof StationEditPart) {
			return ((StationEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ControlParameterEditPart) {
			return ((ControlParameterEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DataProcessSpaceEditPart) {
			return ((DataProcessSpaceEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ScientificProblem2EditPart) {
			return ((ScientificProblem2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof NumericalMethod2EditPart) {
			return ((NumericalMethod2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Mathematical_GeophysicalModel2EditPart) {
			return ((Mathematical_GeophysicalModel2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Requirement2EditPart) {
			return ((Requirement2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Feature2EditPart) {
			return ((Feature2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Constraint2EditPart) {
			return ((Constraint2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof UserInterface2EditPart) {
			return ((UserInterface2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SoftwareInterface2EditPart) {
			return ((SoftwareInterface2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Performance2EditPart) {
			return ((Performance2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Process2EditPart) {
			return ((Process2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InputDataReading2EditPart) {
			return ((InputDataReading2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ResultsOutput2EditPart) {
			return ((ResultsOutput2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ErrorHandling2EditPart) {
			return ((ErrorHandling2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof StatusMonitoring2EditPart) {
			return ((StatusMonitoring2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Solver2EditPart) {
			return ((Solver2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof MeshCreation2EditPart) {
			return ((MeshCreation2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PreProcessing2EditPart) {
			return ((PreProcessing2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PostProcessing2EditPart) {
			return ((PostProcessing2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DataDefinition2EditPart) {
			return ((DataDefinition2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SeismicSource2EditPart) {
			return ((SeismicSource2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ComputationalMesh2EditPart) {
			return ((ComputationalMesh2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof SyntheticSeismogram2EditPart) {
			return ((SyntheticSeismogram2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Station2EditPart) {
			return ((Station2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ControlParameter2EditPart) {
			return ((ControlParameter2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DataProcessSpace2EditPart) {
			return ((DataProcessSpace2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ScientificProblemEditPart) {
			return ((ScientificProblemEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Mathematical_GeophysicalModelEditPart) {
			return ((Mathematical_GeophysicalModelEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof NumericalMethodEditPart) {
			return ((NumericalMethodEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof AssumptionEditPart) {
			return ((AssumptionEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof RequirementEditPart) {
			return ((RequirementEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof FeatureEditPart) {
			return ((FeatureEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof HardwareEditPart) {
			return ((HardwareEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof UserInterfaceEditPart) {
			return ((UserInterfaceEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof SoftwareInterfaceEditPart) {
			return ((SoftwareInterfaceEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PerformanceEditPart) {
			return ((PerformanceEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ProcessEditPart) {
			return ((ProcessEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InputDataReadingEditPart) {
			return ((InputDataReadingEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ResultsOutputEditPart) {
			return ((ResultsOutputEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ErrorHandlingEditPart) {
			return ((ErrorHandlingEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof StatusMonitoringEditPart) {
			return ((StatusMonitoringEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof SolverEditPart) {
			return ((SolverEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof MeshCreationEditPart) {
			return ((MeshCreationEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PreProcessingEditPart) {
			return ((PreProcessingEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PostProcessingEditPart) {
			return ((PostProcessingEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DataDefinitionEditPart) {
			return ((DataDefinitionEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof SeismicSourceEditPart) {
			return ((SeismicSourceEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ComputationalMeshEditPart) {
			return ((ComputationalMeshEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof SyntheticSeismogramEditPart) {
			return ((SyntheticSeismogramEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof StationEditPart) {
			return ((StationEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DataProcessSpaceEditPart) {
			return ((DataProcessSpaceEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ScientificProblem2EditPart) {
			return ((ScientificProblem2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof NumericalMethod2EditPart) {
			return ((NumericalMethod2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Mathematical_GeophysicalModel2EditPart) {
			return ((Mathematical_GeophysicalModel2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Assumption2EditPart) {
			return ((Assumption2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Requirement2EditPart) {
			return ((Requirement2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Feature2EditPart) {
			return ((Feature2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Hardware2EditPart) {
			return ((Hardware2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof UserInterface2EditPart) {
			return ((UserInterface2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof SoftwareInterface2EditPart) {
			return ((SoftwareInterface2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Performance2EditPart) {
			return ((Performance2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Process2EditPart) {
			return ((Process2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InputDataReading2EditPart) {
			return ((InputDataReading2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ResultsOutput2EditPart) {
			return ((ResultsOutput2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ErrorHandling2EditPart) {
			return ((ErrorHandling2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof StatusMonitoring2EditPart) {
			return ((StatusMonitoring2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Solver2EditPart) {
			return ((Solver2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof MeshCreation2EditPart) {
			return ((MeshCreation2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PreProcessing2EditPart) {
			return ((PreProcessing2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PostProcessing2EditPart) {
			return ((PostProcessing2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DataDefinition2EditPart) {
			return ((DataDefinition2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof SeismicSource2EditPart) {
			return ((SeismicSource2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ComputationalMesh2EditPart) {
			return ((ComputationalMesh2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof SyntheticSeismogram2EditPart) {
			return ((SyntheticSeismogram2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Station2EditPart) {
			return ((Station2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DataProcessSpace2EditPart) {
			return ((DataProcessSpace2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public List getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ScientificProblemEditPart) {
			return ((ScientificProblemEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Mathematical_GeophysicalModelEditPart) {
			return ((Mathematical_GeophysicalModelEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof NumericalMethodEditPart) {
			return ((NumericalMethodEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof RequirementEditPart) {
			return ((RequirementEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof FeatureEditPart) {
			return ((FeatureEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof UserInterfaceEditPart) {
			return ((UserInterfaceEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SoftwareInterfaceEditPart) {
			return ((SoftwareInterfaceEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PerformanceEditPart) {
			return ((PerformanceEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ProcessEditPart) {
			return ((ProcessEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InputDataReadingEditPart) {
			return ((InputDataReadingEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ResultsOutputEditPart) {
			return ((ResultsOutputEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ErrorHandlingEditPart) {
			return ((ErrorHandlingEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof StatusMonitoringEditPart) {
			return ((StatusMonitoringEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SolverEditPart) {
			return ((SolverEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof MeshCreationEditPart) {
			return ((MeshCreationEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PreProcessingEditPart) {
			return ((PreProcessingEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PostProcessingEditPart) {
			return ((PostProcessingEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DataDefinitionEditPart) {
			return ((DataDefinitionEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SeismicSourceEditPart) {
			return ((SeismicSourceEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ComputationalMeshEditPart) {
			return ((ComputationalMeshEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SyntheticSeismogramEditPart) {
			return ((SyntheticSeismogramEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof StationEditPart) {
			return ((StationEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ControlParameterEditPart) {
			return ((ControlParameterEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DataProcessSpaceEditPart) {
			return ((DataProcessSpaceEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ScientificProblem2EditPart) {
			return ((ScientificProblem2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof NumericalMethod2EditPart) {
			return ((NumericalMethod2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Mathematical_GeophysicalModel2EditPart) {
			return ((Mathematical_GeophysicalModel2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Requirement2EditPart) {
			return ((Requirement2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Feature2EditPart) {
			return ((Feature2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Constraint2EditPart) {
			return ((Constraint2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof UserInterface2EditPart) {
			return ((UserInterface2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SoftwareInterface2EditPart) {
			return ((SoftwareInterface2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Performance2EditPart) {
			return ((Performance2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Process2EditPart) {
			return ((Process2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InputDataReading2EditPart) {
			return ((InputDataReading2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ResultsOutput2EditPart) {
			return ((ResultsOutput2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ErrorHandling2EditPart) {
			return ((ErrorHandling2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof StatusMonitoring2EditPart) {
			return ((StatusMonitoring2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Solver2EditPart) {
			return ((Solver2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof MeshCreation2EditPart) {
			return ((MeshCreation2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PreProcessing2EditPart) {
			return ((PreProcessing2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PostProcessing2EditPart) {
			return ((PostProcessing2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DataDefinition2EditPart) {
			return ((DataDefinition2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SeismicSource2EditPart) {
			return ((SeismicSource2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ComputationalMesh2EditPart) {
			return ((ComputationalMesh2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof SyntheticSeismogram2EditPart) {
			return ((SyntheticSeismogram2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Station2EditPart) {
			return ((Station2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ControlParameter2EditPart) {
			return ((ControlParameter2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DataProcessSpace2EditPart) {
			return ((DataProcessSpace2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForSource(IAdaptable target,
			IElementType relationshipType) {
		return selectExistingElement(target,
				getTypesForSource(target, relationshipType));
	}

	/**
	 * @generated
	 */
	public EObject selectExistingElementForTarget(IAdaptable source,
			IElementType relationshipType) {
		return selectExistingElement(source,
				getTypesForTarget(source, relationshipType));
	}

	/**
	 * @generated
	 */
	protected EObject selectExistingElement(IAdaptable host, Collection types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
		HashSet<EObject> elements = new HashSet<EObject>();
		for (Iterator<EObject> it = diagram.getElement().eAllContents(); it
				.hasNext();) {
			EObject element = it.next();
			if (isApplicableElement(element, types)) {
				elements.add(element);
			}
		}
		if (elements.isEmpty()) {
			return null;
		}
		return selectElement((EObject[]) elements.toArray(new EObject[elements
				.size()]));
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection types) {
		IElementType type = ElementTypeRegistry.getInstance().getElementType(
				element);
		return types.contains(type);
	}

	/**
	 * @generated
	 */
	protected EObject selectElement(EObject[] elements) {
		Shell shell = Display.getCurrent().getActiveShell();
		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(
				ScrmDiagramEditorPlugin.getInstance()
						.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(
				shell, labelProvider);
		dialog.setMessage(Messages.ScrmModelingAssistantProviderMessage);
		dialog.setTitle(Messages.ScrmModelingAssistantProviderTitle);
		dialog.setMultipleSelection(false);
		dialog.setElements(elements);
		EObject selected = null;
		if (dialog.open() == Window.OK) {
			selected = (EObject) dialog.getFirstResult();
		}
		return selected;
	}
}
