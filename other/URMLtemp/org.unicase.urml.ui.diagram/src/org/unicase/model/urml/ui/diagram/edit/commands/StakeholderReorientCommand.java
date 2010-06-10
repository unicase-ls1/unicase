package org.unicase.model.urml.ui.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.unicase.model.Annotation;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.urml.Stakeholder;
import org.unicase.model.urml.ui.diagram.edit.policies.UrmlBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class StakeholderReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public StakeholderReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Stakeholder) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof MEDiagram && newEnd instanceof MEDiagram)) {
			return false;
		}
		if (getLink().getAnnotations().size() != 1) {
			return false;
		}
		Annotation target = (Annotation) getLink().getAnnotations().get(0);
		return UrmlBaseItemSemanticEditPolicy.LinkConstraints.canExistStakeholder_4001(getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Annotation && newEnd instanceof Annotation)) {
			return false;
		}
		if (!(getLink().eContainer() instanceof MEDiagram)) {
			return false;
		}
		MEDiagram source = (MEDiagram) getLink().eContainer();
		return UrmlBaseItemSemanticEditPolicy.LinkConstraints.canExistStakeholder_4001(source, getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getOldSource().getNewElements().remove(getLink());
		getNewSource().getNewElements().add(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().getAnnotations().remove(getOldTarget());
		getLink().getAnnotations().add(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Stakeholder getLink() {
		return (Stakeholder) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected MEDiagram getOldSource() {
		return (MEDiagram) oldEnd;
	}

	/**
	 * @generated
	 */
	protected MEDiagram getNewSource() {
		return (MEDiagram) newEnd;
	}

	/**
	 * @generated
	 */
	protected Annotation getOldTarget() {
		return (Annotation) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Annotation getNewTarget() {
		return (Annotation) newEnd;
	}
}
