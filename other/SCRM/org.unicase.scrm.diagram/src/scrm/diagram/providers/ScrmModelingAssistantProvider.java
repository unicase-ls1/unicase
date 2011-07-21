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
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;

import scrm.DiagramType;
import scrm.SCRMDiagram;
import scrm.diagram.edit.parts.Assumption2EditPart;
import scrm.diagram.edit.parts.AssumptionEditPart;
import scrm.diagram.edit.parts.Constraint2EditPart;
import scrm.diagram.edit.parts.ConstraintEditPart;
import scrm.diagram.edit.parts.DataDefinition2EditPart;
import scrm.diagram.edit.parts.DataDefinitionEditPart;
import scrm.diagram.edit.parts.DataFlow2EditPart;
import scrm.diagram.edit.parts.DataFlowEditPart;
import scrm.diagram.edit.parts.DataHandling2EditPart;
import scrm.diagram.edit.parts.DataHandlingEditPart;
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
import scrm.diagram.edit.parts.MathematicalModel2EditPart;
import scrm.diagram.edit.parts.MathematicalModelEditPart;
import scrm.diagram.edit.parts.NumericalMethod2EditPart;
import scrm.diagram.edit.parts.NumericalMethodEditPart;
import scrm.diagram.edit.parts.Performance2EditPart;
import scrm.diagram.edit.parts.PerformanceEditPart;
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
import scrm.diagram.edit.parts.SoftwareInterface2EditPart;
import scrm.diagram.edit.parts.SoftwareInterfaceEditPart;
import scrm.diagram.edit.parts.StatusMonitoring2EditPart;
import scrm.diagram.edit.parts.StatusMonitoringEditPart;
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
			SCRMDiagram scrmDiagram = (SCRMDiagram) ((Diagram) editPart.getModel()).getElement();
			return getAllowedTypes(scrmDiagram.getDiagramType());
			
		}
		if (editPart instanceof KnowledgeSpaceKnowledgeSpaceCompartmentEditPart
				|| editPart instanceof KnowledgeSpaceKnowledgeSpaceCompartment2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(5);
			types.add(ScrmElementTypes.ScientificProblem_3001);
			types.add(ScrmElementTypes.NumericalMethod_3002);
			types.add(ScrmElementTypes.MathematicalModel_3003);
			types.add(ScrmElementTypes.Assumption_3004);
			types.add(ScrmElementTypes.KnowledgeSpace_3005);
			return types;
		}
		if (editPart instanceof RequirementSpaceRequirementSpaceCompartmentEditPart
				|| editPart instanceof RequirementSpaceRequirementSpaceCompartment2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(10);
			types.add(ScrmElementTypes.Constraint_3006);
			types.add(ScrmElementTypes.DataDefinition_3007);
			types.add(ScrmElementTypes.DataFlow_3008);
			types.add(ScrmElementTypes.Feature_3009);
			types.add(ScrmElementTypes.Hardware_3010);
			types.add(ScrmElementTypes.Performance_3011);
			types.add(ScrmElementTypes.Requirement_3012);
			types.add(ScrmElementTypes.SoftwareInterface_3013);
			types.add(ScrmElementTypes.UserInterface_3014);
			types.add(ScrmElementTypes.RequirementSpace_3015);
			types.add(ScrmElementTypes.StatusMonitoring_3016);
			types.add(ScrmElementTypes.ResultsOutput_3017);
			types.add(ScrmElementTypes.Process_3018);
			types.add(ScrmElementTypes.InputDataReading_3019);
			types.add(ScrmElementTypes.ErrorHandling_3020);
			types.add(ScrmElementTypes.DataHandling_3021);
			types.add(ScrmElementTypes.DataProcessSpace_3022);
			return types;
		}
		if (editPart instanceof DataProcessSpaceDataProcessSpaceCompartmentEditPart
				|| editPart instanceof DataProcessSpaceDataProcessSpaceCompartment2EditPart) {
			ArrayList<IElementType> types = new ArrayList<IElementType>(7);
			types.add(ScrmElementTypes.StatusMonitoring_3016);
			types.add(ScrmElementTypes.ResultsOutput_3017);
			types.add(ScrmElementTypes.Process_3018);
			types.add(ScrmElementTypes.InputDataReading_3019);
			types.add(ScrmElementTypes.ErrorHandling_3020);
			types.add(ScrmElementTypes.DataHandling_3021);
			types.add(ScrmElementTypes.DataProcessSpace_3022);
			return types;
		}
		return Collections.emptyList();
	}
	
	/**
	 * Obtains all <code>IElementType</code>s, that are allowed for a certain
	 * diagram type.
	 * @param diagramType the {@link DiagramType} to get types for
	 * @return all types that are allowed for <code>diagramType</code> as a list.
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
	
	private static List<IElementType> getKnowledgeTypes() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(5);
		types.add(ScrmElementTypes.ScientificProblem_2007);
		types.add(ScrmElementTypes.MathematicalModel_2005);
		types.add(ScrmElementTypes.NumericalMethod_2006);
		types.add(ScrmElementTypes.Assumption_2008);
		types.add(ScrmElementTypes.KnowledgeSpace_2044);
		return types;
	}
	
	private static List<IElementType> getRequirementTypes() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(10);
		types.add(ScrmElementTypes.Feature_2009);
		types.add(ScrmElementTypes.Hardware_2010);
		types.add(ScrmElementTypes.Constraint_2011);
		types.add(ScrmElementTypes.UserInterface_2012);
		types.add(ScrmElementTypes.SoftwareInterface_2013);
		types.add(ScrmElementTypes.Performance_2015);
		types.add(ScrmElementTypes.DataFlow_2016);
		types.add(ScrmElementTypes.DataDefinition_2017);
		types.add(ScrmElementTypes.Requirement_2034);
		types.add(ScrmElementTypes.RequirementSpace_2045);
		return types;
	}
	
	private static List<IElementType> getDataProcessTypes() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(7);
		types.add(ScrmElementTypes.InputDataReading_2036);
		types.add(ScrmElementTypes.DataHandling_2037);
		types.add(ScrmElementTypes.ResultsOutput_2038);
		types.add(ScrmElementTypes.ErrorHandling_2039);
		types.add(ScrmElementTypes.StatusMonitoring_2040);
		types.add(ScrmElementTypes.Process_2035);
		types.add(ScrmElementTypes.DataProcessSpace_2046);
		return types;
	}
	
	/**
	 * @generated
	 */
	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ScientificProblemEditPart) {
			return ((ScientificProblemEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof MathematicalModelEditPart) {
			return ((MathematicalModelEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof NumericalMethodEditPart) {
			return ((NumericalMethodEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof FeatureEditPart) {
			return ((FeatureEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ConstraintEditPart) {
			return ((ConstraintEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ProcessEditPart) {
			return ((ProcessEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof PerformanceEditPart) {
			return ((PerformanceEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DataFlowEditPart) {
			return ((DataFlowEditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DataDefinitionEditPart) {
			return ((DataDefinitionEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InputDataReadingEditPart) {
			return ((InputDataReadingEditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DataHandlingEditPart) {
			return ((DataHandlingEditPart) sourceEditPart)
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
		if (sourceEditPart instanceof RequirementEditPart) {
			return ((RequirementEditPart) sourceEditPart)
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
		if (sourceEditPart instanceof MathematicalModel2EditPart) {
			return ((MathematicalModel2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Constraint2EditPart) {
			return ((Constraint2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DataDefinition2EditPart) {
			return ((DataDefinition2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DataFlow2EditPart) {
			return ((DataFlow2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Feature2EditPart) {
			return ((Feature2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Performance2EditPart) {
			return ((Performance2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Requirement2EditPart) {
			return ((Requirement2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof StatusMonitoring2EditPart) {
			return ((StatusMonitoring2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ResultsOutput2EditPart) {
			return ((ResultsOutput2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof Process2EditPart) {
			return ((Process2EditPart) sourceEditPart).getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof InputDataReading2EditPart) {
			return ((InputDataReading2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof ErrorHandling2EditPart) {
			return ((ErrorHandling2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DataHandling2EditPart) {
			return ((DataHandling2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		if (sourceEditPart instanceof DataProcessSpace2EditPart) {
			return ((DataProcessSpace2EditPart) sourceEditPart)
					.getMARelTypesOnSource();
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ScientificProblemEditPart) {
			return ((ScientificProblemEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof MathematicalModelEditPart) {
			return ((MathematicalModelEditPart) targetEditPart)
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
		if (targetEditPart instanceof ProcessEditPart) {
			return ((ProcessEditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof PerformanceEditPart) {
			return ((PerformanceEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InputDataReadingEditPart) {
			return ((InputDataReadingEditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DataHandlingEditPart) {
			return ((DataHandlingEditPart) targetEditPart)
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
		if (targetEditPart instanceof RequirementEditPart) {
			return ((RequirementEditPart) targetEditPart)
					.getMARelTypesOnTarget();
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
		if (targetEditPart instanceof MathematicalModel2EditPart) {
			return ((MathematicalModel2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Assumption2EditPart) {
			return ((Assumption2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Feature2EditPart) {
			return ((Feature2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Hardware2EditPart) {
			return ((Hardware2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Performance2EditPart) {
			return ((Performance2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Requirement2EditPart) {
			return ((Requirement2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof SoftwareInterface2EditPart) {
			return ((SoftwareInterface2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof UserInterface2EditPart) {
			return ((UserInterface2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof StatusMonitoring2EditPart) {
			return ((StatusMonitoring2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ResultsOutput2EditPart) {
			return ((ResultsOutput2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof Process2EditPart) {
			return ((Process2EditPart) targetEditPart).getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof InputDataReading2EditPart) {
			return ((InputDataReading2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof ErrorHandling2EditPart) {
			return ((ErrorHandling2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DataHandling2EditPart) {
			return ((DataHandling2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		if (targetEditPart instanceof DataProcessSpace2EditPart) {
			return ((DataProcessSpace2EditPart) targetEditPart)
					.getMARelTypesOnTarget();
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ScientificProblemEditPart) {
			return ((ScientificProblemEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof MathematicalModelEditPart) {
			return ((MathematicalModelEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof NumericalMethodEditPart) {
			return ((NumericalMethodEditPart) sourceEditPart)
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
		if (sourceEditPart instanceof ProcessEditPart) {
			return ((ProcessEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof PerformanceEditPart) {
			return ((PerformanceEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DataFlowEditPart) {
			return ((DataFlowEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DataDefinitionEditPart) {
			return ((DataDefinitionEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof InputDataReadingEditPart) {
			return ((InputDataReadingEditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DataHandlingEditPart) {
			return ((DataHandlingEditPart) sourceEditPart)
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
		if (sourceEditPart instanceof RequirementEditPart) {
			return ((RequirementEditPart) sourceEditPart)
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
		if (sourceEditPart instanceof MathematicalModel2EditPart) {
			return ((MathematicalModel2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Constraint2EditPart) {
			return ((Constraint2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DataDefinition2EditPart) {
			return ((DataDefinition2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DataFlow2EditPart) {
			return ((DataFlow2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Feature2EditPart) {
			return ((Feature2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Performance2EditPart) {
			return ((Performance2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof Requirement2EditPart) {
			return ((Requirement2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof StatusMonitoring2EditPart) {
			return ((StatusMonitoring2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof ResultsOutput2EditPart) {
			return ((ResultsOutput2EditPart) sourceEditPart)
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
		if (sourceEditPart instanceof ErrorHandling2EditPart) {
			return ((ErrorHandling2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DataHandling2EditPart) {
			return ((DataHandling2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		if (sourceEditPart instanceof DataProcessSpace2EditPart) {
			return ((DataProcessSpace2EditPart) sourceEditPart)
					.getMARelTypesOnSourceAndTarget(targetEditPart);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public List<IElementType> getTypesForSource(IAdaptable target,
			IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target
				.getAdapter(IGraphicalEditPart.class);
		if (targetEditPart instanceof ScientificProblemEditPart) {
			return ((ScientificProblemEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof MathematicalModelEditPart) {
			return ((MathematicalModelEditPart) targetEditPart)
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
		if (targetEditPart instanceof ProcessEditPart) {
			return ((ProcessEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof PerformanceEditPart) {
			return ((PerformanceEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof InputDataReadingEditPart) {
			return ((InputDataReadingEditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DataHandlingEditPart) {
			return ((DataHandlingEditPart) targetEditPart)
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
		if (targetEditPart instanceof RequirementEditPart) {
			return ((RequirementEditPart) targetEditPart)
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
		if (targetEditPart instanceof MathematicalModel2EditPart) {
			return ((MathematicalModel2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Assumption2EditPart) {
			return ((Assumption2EditPart) targetEditPart)
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
		if (targetEditPart instanceof Performance2EditPart) {
			return ((Performance2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof Requirement2EditPart) {
			return ((Requirement2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof SoftwareInterface2EditPart) {
			return ((SoftwareInterface2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof UserInterface2EditPart) {
			return ((UserInterface2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof StatusMonitoring2EditPart) {
			return ((StatusMonitoring2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof ResultsOutput2EditPart) {
			return ((ResultsOutput2EditPart) targetEditPart)
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
		if (targetEditPart instanceof ErrorHandling2EditPart) {
			return ((ErrorHandling2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DataHandling2EditPart) {
			return ((DataHandling2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		if (targetEditPart instanceof DataProcessSpace2EditPart) {
			return ((DataProcessSpace2EditPart) targetEditPart)
					.getMATypesForSource(relationshipType);
		}
		return Collections.emptyList();
	}

	/**
	 * @generated
	 */
	public List<IElementType> getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source
				.getAdapter(IGraphicalEditPart.class);
		if (sourceEditPart instanceof ScientificProblemEditPart) {
			return ((ScientificProblemEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof MathematicalModelEditPart) {
			return ((MathematicalModelEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof NumericalMethodEditPart) {
			return ((NumericalMethodEditPart) sourceEditPart)
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
		if (sourceEditPart instanceof ProcessEditPart) {
			return ((ProcessEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof PerformanceEditPart) {
			return ((PerformanceEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DataFlowEditPart) {
			return ((DataFlowEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DataDefinitionEditPart) {
			return ((DataDefinitionEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof InputDataReadingEditPart) {
			return ((InputDataReadingEditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DataHandlingEditPart) {
			return ((DataHandlingEditPart) sourceEditPart)
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
		if (sourceEditPart instanceof RequirementEditPart) {
			return ((RequirementEditPart) sourceEditPart)
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
		if (sourceEditPart instanceof MathematicalModel2EditPart) {
			return ((MathematicalModel2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Constraint2EditPart) {
			return ((Constraint2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DataDefinition2EditPart) {
			return ((DataDefinition2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DataFlow2EditPart) {
			return ((DataFlow2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Feature2EditPart) {
			return ((Feature2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Performance2EditPart) {
			return ((Performance2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof Requirement2EditPart) {
			return ((Requirement2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof StatusMonitoring2EditPart) {
			return ((StatusMonitoring2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof ResultsOutput2EditPart) {
			return ((ResultsOutput2EditPart) sourceEditPart)
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
		if (sourceEditPart instanceof ErrorHandling2EditPart) {
			return ((ErrorHandling2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DataHandling2EditPart) {
			return ((DataHandling2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		if (sourceEditPart instanceof DataProcessSpace2EditPart) {
			return ((DataProcessSpace2EditPart) sourceEditPart)
					.getMATypesForTarget(relationshipType);
		}
		return Collections.emptyList();
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
	protected EObject selectExistingElement(IAdaptable host, Collection<IElementType> types) {
		if (types.isEmpty()) {
			return null;
		}
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);
		if (editPart == null) {
			return null;
		}
		
		Diagram diagram = (Diagram) editPart.getRoot().getContents().getModel();
//		Project project = ModelUtil.getProject(diagram.getElement());
		HashSet<EObject> elements = new HashSet<EObject>();
//		for (Iterator<EObject> it = project.eAllContents(); it.hasNext();) {
//			EObject element = it.next();
		List<EObject> allElements = getAllElements((SCRMDiagram) diagram.getElement());
		for(EObject element : allElements) {
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

	private List<EObject> getAllElements(SCRMDiagram scrmDiagram) {
		List<EObject> result = new LinkedList<EObject>(scrmDiagram.getElements());
		for(EObject eObject : scrmDiagram.getElements()) {
			for(Iterator<EObject> it = eObject.eAllContents(); it.hasNext();) {
				result.add(it.next());
			}
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isApplicableElement(EObject element, Collection<IElementType> types) {
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
