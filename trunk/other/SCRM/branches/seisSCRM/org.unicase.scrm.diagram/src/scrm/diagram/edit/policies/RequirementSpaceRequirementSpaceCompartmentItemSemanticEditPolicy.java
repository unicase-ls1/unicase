package scrm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import scrm.diagram.edit.commands.ComputationalMesh2CreateCommand;
import scrm.diagram.edit.commands.Constraint2CreateCommand;
import scrm.diagram.edit.commands.ControlParameter2CreateCommand;
import scrm.diagram.edit.commands.DataDefinition2CreateCommand;
import scrm.diagram.edit.commands.DataProcessSpace2CreateCommand;
import scrm.diagram.edit.commands.ErrorHandling2CreateCommand;
import scrm.diagram.edit.commands.Feature2CreateCommand;
import scrm.diagram.edit.commands.Hardware2CreateCommand;
import scrm.diagram.edit.commands.InputDataReading2CreateCommand;
import scrm.diagram.edit.commands.MeshCreation2CreateCommand;
import scrm.diagram.edit.commands.Performance2CreateCommand;
import scrm.diagram.edit.commands.PostProcessing2CreateCommand;
import scrm.diagram.edit.commands.PreProcessing2CreateCommand;
import scrm.diagram.edit.commands.Process2CreateCommand;
import scrm.diagram.edit.commands.Requirement2CreateCommand;
import scrm.diagram.edit.commands.RequirementSpace2CreateCommand;
import scrm.diagram.edit.commands.ResultsOutput2CreateCommand;
import scrm.diagram.edit.commands.SeismicSource2CreateCommand;
import scrm.diagram.edit.commands.SoftwareInterface2CreateCommand;
import scrm.diagram.edit.commands.Solver2CreateCommand;
import scrm.diagram.edit.commands.Station2CreateCommand;
import scrm.diagram.edit.commands.StatusMonitoring2CreateCommand;
import scrm.diagram.edit.commands.SyntheticSeismogram2CreateCommand;
import scrm.diagram.edit.commands.UserInterface2CreateCommand;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class RequirementSpaceRequirementSpaceCompartmentItemSemanticEditPolicy
		extends ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RequirementSpaceRequirementSpaceCompartmentItemSemanticEditPolicy() {
		super(ScrmElementTypes.RequirementSpace_2045);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ScrmElementTypes.Requirement_3012 == req.getElementType()) {
			return getGEFWrapper(new Requirement2CreateCommand(req));
		}
		if (ScrmElementTypes.Feature_3009 == req.getElementType()) {
			return getGEFWrapper(new Feature2CreateCommand(req));
		}
		if (ScrmElementTypes.Hardware_3010 == req.getElementType()) {
			return getGEFWrapper(new Hardware2CreateCommand(req));
		}
		if (ScrmElementTypes.Constraint_3006 == req.getElementType()) {
			return getGEFWrapper(new Constraint2CreateCommand(req));
		}
		if (ScrmElementTypes.UserInterface_3014 == req.getElementType()) {
			return getGEFWrapper(new UserInterface2CreateCommand(req));
		}
		if (ScrmElementTypes.SoftwareInterface_3013 == req.getElementType()) {
			return getGEFWrapper(new SoftwareInterface2CreateCommand(req));
		}
		if (ScrmElementTypes.Performance_3011 == req.getElementType()) {
			return getGEFWrapper(new Performance2CreateCommand(req));
		}
		if (ScrmElementTypes.Process_3025 == req.getElementType()) {
			return getGEFWrapper(new Process2CreateCommand(req));
		}
		if (ScrmElementTypes.InputDataReading_3026 == req.getElementType()) {
			return getGEFWrapper(new InputDataReading2CreateCommand(req));
		}
		if (ScrmElementTypes.ResultsOutput_3024 == req.getElementType()) {
			return getGEFWrapper(new ResultsOutput2CreateCommand(req));
		}
		if (ScrmElementTypes.ErrorHandling_3027 == req.getElementType()) {
			return getGEFWrapper(new ErrorHandling2CreateCommand(req));
		}
		if (ScrmElementTypes.StatusMonitoring_3023 == req.getElementType()) {
			return getGEFWrapper(new StatusMonitoring2CreateCommand(req));
		}
		if (ScrmElementTypes.Solver_3031 == req.getElementType()) {
			return getGEFWrapper(new Solver2CreateCommand(req));
		}
		if (ScrmElementTypes.MeshCreation_3032 == req.getElementType()) {
			return getGEFWrapper(new MeshCreation2CreateCommand(req));
		}
		if (ScrmElementTypes.PreProcessing_3033 == req.getElementType()) {
			return getGEFWrapper(new PreProcessing2CreateCommand(req));
		}
		if (ScrmElementTypes.PostProcessing_3034 == req.getElementType()) {
			return getGEFWrapper(new PostProcessing2CreateCommand(req));
		}
		if (ScrmElementTypes.DataDefinition_3035 == req.getElementType()) {
			return getGEFWrapper(new DataDefinition2CreateCommand(req));
		}
		if (ScrmElementTypes.SeismicSource_3036 == req.getElementType()) {
			return getGEFWrapper(new SeismicSource2CreateCommand(req));
		}
		if (ScrmElementTypes.ComputationalMesh_3037 == req.getElementType()) {
			return getGEFWrapper(new ComputationalMesh2CreateCommand(req));
		}
		if (ScrmElementTypes.SyntheticSeismogram_3038 == req.getElementType()) {
			return getGEFWrapper(new SyntheticSeismogram2CreateCommand(req));
		}
		if (ScrmElementTypes.Station_3039 == req.getElementType()) {
			return getGEFWrapper(new Station2CreateCommand(req));
		}
		if (ScrmElementTypes.ControlParameter_3040 == req.getElementType()) {
			return getGEFWrapper(new ControlParameter2CreateCommand(req));
		}
		if (ScrmElementTypes.RequirementSpace_3015 == req.getElementType()) {
			return getGEFWrapper(new RequirementSpace2CreateCommand(req));
		}
		if (ScrmElementTypes.DataProcessSpace_3029 == req.getElementType()) {
			return getGEFWrapper(new DataProcessSpace2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
