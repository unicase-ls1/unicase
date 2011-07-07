package scrm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import scrm.diagram.edit.commands.Constraint2CreateCommand;
import scrm.diagram.edit.commands.DataDefinition2CreateCommand;
import scrm.diagram.edit.commands.DataFlow2CreateCommand;
import scrm.diagram.edit.commands.DataHandling3CreateCommand;
import scrm.diagram.edit.commands.DataProcessSpace3CreateCommand;
import scrm.diagram.edit.commands.ErrorHandling3CreateCommand;
import scrm.diagram.edit.commands.Feature2CreateCommand;
import scrm.diagram.edit.commands.Hardware2CreateCommand;
import scrm.diagram.edit.commands.InputDataReading3CreateCommand;
import scrm.diagram.edit.commands.Performance2CreateCommand;
import scrm.diagram.edit.commands.Process3CreateCommand;
import scrm.diagram.edit.commands.Requirement2CreateCommand;
import scrm.diagram.edit.commands.RequirementSpace2CreateCommand;
import scrm.diagram.edit.commands.ResultsOutput3CreateCommand;
import scrm.diagram.edit.commands.SoftwareInterface2CreateCommand;
import scrm.diagram.edit.commands.StatusMonitoring3CreateCommand;
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
		if (ScrmElementTypes.Constraint_3006 == req.getElementType()) {
			return getGEFWrapper(new Constraint2CreateCommand(req));
		}
		if (ScrmElementTypes.DataDefinition_3007 == req.getElementType()) {
			return getGEFWrapper(new DataDefinition2CreateCommand(req));
		}
		if (ScrmElementTypes.DataFlow_3008 == req.getElementType()) {
			return getGEFWrapper(new DataFlow2CreateCommand(req));
		}
		if (ScrmElementTypes.Feature_3009 == req.getElementType()) {
			return getGEFWrapper(new Feature2CreateCommand(req));
		}
		if (ScrmElementTypes.Hardware_3010 == req.getElementType()) {
			return getGEFWrapper(new Hardware2CreateCommand(req));
		}
		if (ScrmElementTypes.Performance_3011 == req.getElementType()) {
			return getGEFWrapper(new Performance2CreateCommand(req));
		}
		if (ScrmElementTypes.Requirement_3012 == req.getElementType()) {
			return getGEFWrapper(new Requirement2CreateCommand(req));
		}
		if (ScrmElementTypes.SoftwareInterface_3013 == req.getElementType()) {
			return getGEFWrapper(new SoftwareInterface2CreateCommand(req));
		}
		if (ScrmElementTypes.UserInterface_3014 == req.getElementType()) {
			return getGEFWrapper(new UserInterface2CreateCommand(req));
		}
		if (ScrmElementTypes.RequirementSpace_3015 == req.getElementType()) {
			return getGEFWrapper(new RequirementSpace2CreateCommand(req));
		}
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
