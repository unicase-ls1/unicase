package scrm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import scrm.diagram.edit.commands.DataHandling2CreateCommand;
import scrm.diagram.edit.commands.DataProcessSpace2CreateCommand;
import scrm.diagram.edit.commands.ErrorHandling2CreateCommand;
import scrm.diagram.edit.commands.InputDataReading2CreateCommand;
import scrm.diagram.edit.commands.Process2CreateCommand;
import scrm.diagram.edit.commands.ResultsOutput2CreateCommand;
import scrm.diagram.edit.commands.StatusMonitoring2CreateCommand;
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
		super(ScrmElementTypes.DataProcessSpace_2046);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ScrmElementTypes.StatusMonitoring_3016 == req.getElementType()) {
			return getGEFWrapper(new StatusMonitoring2CreateCommand(req));
		}
		if (ScrmElementTypes.ResultsOutput_3017 == req.getElementType()) {
			return getGEFWrapper(new ResultsOutput2CreateCommand(req));
		}
		if (ScrmElementTypes.Process_3018 == req.getElementType()) {
			return getGEFWrapper(new Process2CreateCommand(req));
		}
		if (ScrmElementTypes.InputDataReading_3019 == req.getElementType()) {
			return getGEFWrapper(new InputDataReading2CreateCommand(req));
		}
		if (ScrmElementTypes.ErrorHandling_3020 == req.getElementType()) {
			return getGEFWrapper(new ErrorHandling2CreateCommand(req));
		}
		if (ScrmElementTypes.DataHandling_3021 == req.getElementType()) {
			return getGEFWrapper(new DataHandling2CreateCommand(req));
		}
		if (ScrmElementTypes.DataProcessSpace_3022 == req.getElementType()) {
			return getGEFWrapper(new DataProcessSpace2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
