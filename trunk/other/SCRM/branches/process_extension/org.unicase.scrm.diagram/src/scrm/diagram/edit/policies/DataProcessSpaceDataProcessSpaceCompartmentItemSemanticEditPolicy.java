package scrm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import scrm.diagram.edit.commands.DataHandling2CreateCommand;
import scrm.diagram.edit.commands.DataHandling3CreateCommand;
import scrm.diagram.edit.commands.DataProcessSpace2CreateCommand;
import scrm.diagram.edit.commands.DataProcessSpace3CreateCommand;
import scrm.diagram.edit.commands.ErrorHandling2CreateCommand;
import scrm.diagram.edit.commands.ErrorHandling3CreateCommand;
import scrm.diagram.edit.commands.InputDataReading2CreateCommand;
import scrm.diagram.edit.commands.InputDataReading3CreateCommand;
import scrm.diagram.edit.commands.Process2CreateCommand;
import scrm.diagram.edit.commands.Process3CreateCommand;
import scrm.diagram.edit.commands.ResultsOutput2CreateCommand;
import scrm.diagram.edit.commands.ResultsOutput3CreateCommand;
import scrm.diagram.edit.commands.StatusMonitoring2CreateCommand;
import scrm.diagram.edit.commands.StatusMonitoring3CreateCommand;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class DataProcessSpaceDataProcessSpaceCompartmentItemSemanticEditPolicy
		extends ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DataProcessSpaceDataProcessSpaceCompartmentItemSemanticEditPolicy() {
		super(ScrmElementTypes.DataProcessSpace_3029);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ScrmElementTypes.StatusMonitoring_3016 == req.getElementType()) {
			return getGEFWrapper(new StatusMonitoring3CreateCommand(req));
		}
		if (ScrmElementTypes.ResultsOutput_3017 == req.getElementType()) {
			return getGEFWrapper(new ResultsOutput3CreateCommand(req));
		}
		if (ScrmElementTypes.Process_3018 == req.getElementType()) {
			return getGEFWrapper(new Process3CreateCommand(req));
		}
		if (ScrmElementTypes.InputDataReading_3019 == req.getElementType()) {
			return getGEFWrapper(new InputDataReading3CreateCommand(req));
		}
		if (ScrmElementTypes.ErrorHandling_3020 == req.getElementType()) {
			return getGEFWrapper(new ErrorHandling3CreateCommand(req));
		}
		if (ScrmElementTypes.DataHandling_3021 == req.getElementType()) {
			return getGEFWrapper(new DataHandling3CreateCommand(req));
		}
		if (ScrmElementTypes.DataProcessSpace_3022 == req.getElementType()) {
			return getGEFWrapper(new DataProcessSpace3CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
