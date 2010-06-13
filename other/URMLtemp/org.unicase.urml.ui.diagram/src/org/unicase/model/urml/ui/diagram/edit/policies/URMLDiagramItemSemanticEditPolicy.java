package org.unicase.model.urml.ui.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.unicase.model.urml.ui.diagram.edit.commands.ActionItemCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.ActorCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.DangerCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.FeatureCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.FunctionalRequirementCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.GoalCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.NonFunctionalRequirementCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.ServiceCreateCommand;
import org.unicase.model.urml.ui.diagram.edit.commands.StakeholderCreateCommand;
import org.unicase.model.urml.ui.diagram.providers.UrmlElementTypes;

/**
 * @generated
 */
public class URMLDiagramItemSemanticEditPolicy extends UrmlBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public URMLDiagramItemSemanticEditPolicy() {
		super(UrmlElementTypes.URMLDiagram_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UrmlElementTypes.Stakeholder_2002 == req.getElementType()) {
			return getGEFWrapper(new StakeholderCreateCommand(req));
		}
		if (UrmlElementTypes.Goal_2001 == req.getElementType()) {
			return getGEFWrapper(new GoalCreateCommand(req));
		}
		if (UrmlElementTypes.FunctionalRequirement_2006 == req.getElementType()) {
			return getGEFWrapper(new FunctionalRequirementCreateCommand(req));
		}
		if (UrmlElementTypes.Feature_2005 == req.getElementType()) {
			return getGEFWrapper(new FeatureCreateCommand(req));
		}
		if (UrmlElementTypes.Service_2007 == req.getElementType()) {
			return getGEFWrapper(new ServiceCreateCommand(req));
		}
		if (UrmlElementTypes.NonFunctionalRequirement_2008 == req.getElementType()) {
			return getGEFWrapper(new NonFunctionalRequirementCreateCommand(req));
		}
		if (UrmlElementTypes.Danger_2009 == req.getElementType()) {
			return getGEFWrapper(new DangerCreateCommand(req));
		}
		if (UrmlElementTypes.Actor_2010 == req.getElementType()) {
			return getGEFWrapper(new ActorCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
