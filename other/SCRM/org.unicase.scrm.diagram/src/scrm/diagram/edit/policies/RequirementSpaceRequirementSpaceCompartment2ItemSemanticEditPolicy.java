package scrm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import scrm.diagram.edit.commands.Constraint2CreateCommand;
import scrm.diagram.edit.commands.DataDefinition2CreateCommand;
import scrm.diagram.edit.commands.DataFlow2CreateCommand;
import scrm.diagram.edit.commands.Feature2CreateCommand;
import scrm.diagram.edit.commands.Hardware2CreateCommand;
import scrm.diagram.edit.commands.Performance2CreateCommand;
import scrm.diagram.edit.commands.Requirement2CreateCommand;
import scrm.diagram.edit.commands.RequirementSpace2CreateCommand;
import scrm.diagram.edit.commands.SoftwareInterface2CreateCommand;
import scrm.diagram.edit.commands.UserInterface2CreateCommand;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class RequirementSpaceRequirementSpaceCompartment2ItemSemanticEditPolicy
		extends ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public RequirementSpaceRequirementSpaceCompartment2ItemSemanticEditPolicy() {
		super(ScrmElementTypes.RequirementSpace_3015);
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
		return super.getCreateCommand(req);
	}

}
