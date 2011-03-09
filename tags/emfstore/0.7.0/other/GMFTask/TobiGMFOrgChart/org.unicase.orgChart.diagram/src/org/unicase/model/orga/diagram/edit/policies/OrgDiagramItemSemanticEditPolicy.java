package org.unicase.model.orga.diagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.unicase.model.orga.diagram.edit.commands.EmployeeCreateCommand;
import org.unicase.model.orga.diagram.edit.commands.TeamCreateCommand;
import org.unicase.model.orga.diagram.providers.OrgaElementTypes;

/**
 * @generated
 */
public class OrgDiagramItemSemanticEditPolicy extends
		OrgaBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public OrgDiagramItemSemanticEditPolicy() {
		super(OrgaElementTypes.OrgDiagram_666);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (OrgaElementTypes.Team_2002 == req.getElementType()) {
			return getGEFWrapper(new TeamCreateCommand(req));
		}
		if (OrgaElementTypes.Employee_2001 == req.getElementType()) {
			return getGEFWrapper(new EmployeeCreateCommand(req));
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
