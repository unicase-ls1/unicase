package scrm.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import scrm.diagram.edit.commands.Assumption2CreateCommand;
import scrm.diagram.edit.commands.KnowledgeSpace2CreateCommand;
import scrm.diagram.edit.commands.Mathematical_GeophysicalModel2CreateCommand;
import scrm.diagram.edit.commands.NumericalMethod2CreateCommand;
import scrm.diagram.edit.commands.ScientificProblem2CreateCommand;
import scrm.diagram.providers.ScrmElementTypes;

/**
 * @generated
 */
public class KnowledgeSpaceKnowledgeSpaceCompartment2ItemSemanticEditPolicy
		extends ScrmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public KnowledgeSpaceKnowledgeSpaceCompartment2ItemSemanticEditPolicy() {
		super(ScrmElementTypes.KnowledgeSpace_3005);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ScrmElementTypes.ScientificProblem_3001 == req.getElementType()) {
			return getGEFWrapper(new ScientificProblem2CreateCommand(req));
		}
		if (ScrmElementTypes.NumericalMethod_3002 == req.getElementType()) {
			return getGEFWrapper(new NumericalMethod2CreateCommand(req));
		}
		if (ScrmElementTypes.Mathematical_GeophysicalModel_3030 == req
				.getElementType()) {
			return getGEFWrapper(new Mathematical_GeophysicalModel2CreateCommand(
					req));
		}
		if (ScrmElementTypes.Assumption_3004 == req.getElementType()) {
			return getGEFWrapper(new Assumption2CreateCommand(req));
		}
		if (ScrmElementTypes.KnowledgeSpace_3005 == req.getElementType()) {
			return getGEFWrapper(new KnowledgeSpace2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
