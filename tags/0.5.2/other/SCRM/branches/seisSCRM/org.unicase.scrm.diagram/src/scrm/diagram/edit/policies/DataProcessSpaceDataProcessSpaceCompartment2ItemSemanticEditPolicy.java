package scrm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import scrm.diagram.edit.commands.DataProcessSpace3CreateCommand;
import scrm.diagram.edit.commands.ErrorHandling3CreateCommand;
import scrm.diagram.edit.commands.InputDataReading3CreateCommand;
import scrm.diagram.edit.commands.MeshCreation3CreateCommand;
import scrm.diagram.edit.commands.PostProcessing3CreateCommand;
import scrm.diagram.edit.commands.PreProcessing3CreateCommand;
import scrm.diagram.edit.commands.Process3CreateCommand;
import scrm.diagram.edit.commands.ResultsOutput3CreateCommand;
import scrm.diagram.edit.commands.Solver3CreateCommand;
import scrm.diagram.edit.commands.StatusMonitoring3CreateCommand;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class DataProcessSpaceDataProcessSpaceCompartment2ItemSemanticEditPolicy
		extends ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DataProcessSpaceDataProcessSpaceCompartment2ItemSemanticEditPolicy() {
		super(ScrmElementTypes.DataProcessSpace_3029);
	}

	/**
	 * @generated NOT
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ScrmElementTypes.Process_3025 == req.getElementType()) {
			return getGEFWrapper(new Process3CreateCommand(req));
		}
		if (ScrmElementTypes.InputDataReading_3026 == req.getElementType()) {
			return getGEFWrapper(new InputDataReading3CreateCommand(req));
		}
		if (ScrmElementTypes.ResultsOutput_3024 == req.getElementType()) {
			return getGEFWrapper(new ResultsOutput3CreateCommand(req));
		}
		if (ScrmElementTypes.ErrorHandling_3027 == req.getElementType()) {
			return getGEFWrapper(new ErrorHandling3CreateCommand(req));
		}
		if (ScrmElementTypes.StatusMonitoring_3023 == req.getElementType()) {
			return getGEFWrapper(new StatusMonitoring3CreateCommand(req));
		}
		if (ScrmElementTypes.DataProcessSpace_3029 == req.getElementType()) {
			return getGEFWrapper(new DataProcessSpace3CreateCommand(req));
		}
		if (ScrmElementTypes.Solver_3031 == req.getElementType()) {
			return getGEFWrapper(new Solver3CreateCommand(req));
		}
		if (ScrmElementTypes.MeshCreation_3032 == req.getElementType()) {
			return getGEFWrapper(new MeshCreation3CreateCommand(req));
		}
		if (ScrmElementTypes.PreProcessing_3033 == req.getElementType()) {
			return getGEFWrapper(new PreProcessing3CreateCommand(req));
		}
		if (ScrmElementTypes.PostProcessing_3034 == req.getElementType()) {
			return getGEFWrapper(new PostProcessing3CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
