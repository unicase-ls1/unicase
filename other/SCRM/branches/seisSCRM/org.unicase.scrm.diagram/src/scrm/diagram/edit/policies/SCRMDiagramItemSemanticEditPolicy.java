package scrm.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import scrm.diagram.edit.commands.AssumptionCreateCommand;
import scrm.diagram.edit.commands.ComputationalMeshCreateCommand;
import scrm.diagram.edit.commands.ConstraintCreateCommand;
import scrm.diagram.edit.commands.ControlParameterCreateCommand;
import scrm.diagram.edit.commands.DataDefinitionCreateCommand;
import scrm.diagram.edit.commands.DataProcessSpaceCreateCommand;
import scrm.diagram.edit.commands.ErrorHandlingCreateCommand;
import scrm.diagram.edit.commands.FeatureCreateCommand;
import scrm.diagram.edit.commands.HardwareCreateCommand;
import scrm.diagram.edit.commands.InputDataReadingCreateCommand;
import scrm.diagram.edit.commands.KnowledgeSpaceCreateCommand;
import scrm.diagram.edit.commands.Mathematical_GeophysicalModelCreateCommand;
import scrm.diagram.edit.commands.MeshCreationCreateCommand;
import scrm.diagram.edit.commands.NumericalMethodCreateCommand;
import scrm.diagram.edit.commands.PerformanceCreateCommand;
import scrm.diagram.edit.commands.PostProcessingCreateCommand;
import scrm.diagram.edit.commands.PreProcessingCreateCommand;
import scrm.diagram.edit.commands.ProcessCreateCommand;
import scrm.diagram.edit.commands.RequirementCreateCommand;
import scrm.diagram.edit.commands.RequirementSpaceCreateCommand;
import scrm.diagram.edit.commands.ResultsOutputCreateCommand;
import scrm.diagram.edit.commands.ScientificProblemCreateCommand;
import scrm.diagram.edit.commands.SeismicSourceCreateCommand;
import scrm.diagram.edit.commands.SoftwareInterfaceCreateCommand;
import scrm.diagram.edit.commands.SolverCreateCommand;
import scrm.diagram.edit.commands.StationCreateCommand;
import scrm.diagram.edit.commands.StatusMonitoringCreateCommand;
import scrm.diagram.edit.commands.SyntheticSeismogramCreateCommand;
import scrm.diagram.edit.commands.UserInterfaceCreateCommand;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class SCRMDiagramItemSemanticEditPolicy extends
		ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public SCRMDiagramItemSemanticEditPolicy() {
		super(ScrmElementTypes.SCRMDiagram_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ScrmElementTypes.ScientificProblem_2007 == req.getElementType()) {
			return getGEFWrapper(new ScientificProblemCreateCommand(req));
		}
		if (ScrmElementTypes.Mathematical_GeophysicalModel_2047 == req
				.getElementType()) {
			return getGEFWrapper(new Mathematical_GeophysicalModelCreateCommand(
					req));
		}
		if (ScrmElementTypes.NumericalMethod_2006 == req.getElementType()) {
			return getGEFWrapper(new NumericalMethodCreateCommand(req));
		}
		if (ScrmElementTypes.Assumption_2008 == req.getElementType()) {
			return getGEFWrapper(new AssumptionCreateCommand(req));
		}
		if (ScrmElementTypes.Requirement_2034 == req.getElementType()) {
			return getGEFWrapper(new RequirementCreateCommand(req));
		}
		if (ScrmElementTypes.Feature_2009 == req.getElementType()) {
			return getGEFWrapper(new FeatureCreateCommand(req));
		}
		if (ScrmElementTypes.Hardware_2010 == req.getElementType()) {
			return getGEFWrapper(new HardwareCreateCommand(req));
		}
		if (ScrmElementTypes.Constraint_2011 == req.getElementType()) {
			return getGEFWrapper(new ConstraintCreateCommand(req));
		}
		if (ScrmElementTypes.UserInterface_2012 == req.getElementType()) {
			return getGEFWrapper(new UserInterfaceCreateCommand(req));
		}
		if (ScrmElementTypes.SoftwareInterface_2013 == req.getElementType()) {
			return getGEFWrapper(new SoftwareInterfaceCreateCommand(req));
		}
		if (ScrmElementTypes.Performance_2015 == req.getElementType()) {
			return getGEFWrapper(new PerformanceCreateCommand(req));
		}
		if (ScrmElementTypes.Process_2035 == req.getElementType()) {
			return getGEFWrapper(new ProcessCreateCommand(req));
		}
		if (ScrmElementTypes.InputDataReading_2036 == req.getElementType()) {
			return getGEFWrapper(new InputDataReadingCreateCommand(req));
		}
		if (ScrmElementTypes.ResultsOutput_2038 == req.getElementType()) {
			return getGEFWrapper(new ResultsOutputCreateCommand(req));
		}
		if (ScrmElementTypes.ErrorHandling_2039 == req.getElementType()) {
			return getGEFWrapper(new ErrorHandlingCreateCommand(req));
		}
		if (ScrmElementTypes.StatusMonitoring_2040 == req.getElementType()) {
			return getGEFWrapper(new StatusMonitoringCreateCommand(req));
		}
		if (ScrmElementTypes.Solver_2048 == req.getElementType()) {
			return getGEFWrapper(new SolverCreateCommand(req));
		}
		if (ScrmElementTypes.MeshCreation_2049 == req.getElementType()) {
			return getGEFWrapper(new MeshCreationCreateCommand(req));
		}
		if (ScrmElementTypes.PreProcessing_2050 == req.getElementType()) {
			return getGEFWrapper(new PreProcessingCreateCommand(req));
		}
		if (ScrmElementTypes.PostProcessing_2051 == req.getElementType()) {
			return getGEFWrapper(new PostProcessingCreateCommand(req));
		}
		if (ScrmElementTypes.DataDefinition_2052 == req.getElementType()) {
			return getGEFWrapper(new DataDefinitionCreateCommand(req));
		}
		if (ScrmElementTypes.SeismicSource_2053 == req.getElementType()) {
			return getGEFWrapper(new SeismicSourceCreateCommand(req));
		}
		if (ScrmElementTypes.ComputationalMesh_2054 == req.getElementType()) {
			return getGEFWrapper(new ComputationalMeshCreateCommand(req));
		}
		if (ScrmElementTypes.SyntheticSeismogram_2055 == req.getElementType()) {
			return getGEFWrapper(new SyntheticSeismogramCreateCommand(req));
		}
		if (ScrmElementTypes.Station_2056 == req.getElementType()) {
			return getGEFWrapper(new StationCreateCommand(req));
		}
		if (ScrmElementTypes.ControlParameter_2057 == req.getElementType()) {
			return getGEFWrapper(new ControlParameterCreateCommand(req));
		}
		if (ScrmElementTypes.KnowledgeSpace_2044 == req.getElementType()) {
			return getGEFWrapper(new KnowledgeSpaceCreateCommand(req));
		}
		if (ScrmElementTypes.RequirementSpace_2045 == req.getElementType()) {
			return getGEFWrapper(new RequirementSpaceCreateCommand(req));
		}
		if (ScrmElementTypes.DataProcessSpace_2046 == req.getElementType()) {
			return getGEFWrapper(new DataProcessSpaceCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}

	}

}
