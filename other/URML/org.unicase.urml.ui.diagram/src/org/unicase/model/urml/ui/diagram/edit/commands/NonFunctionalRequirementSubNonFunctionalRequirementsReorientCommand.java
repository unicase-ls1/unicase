package org.unicase.model.urml.ui.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.unicase.model.urml.ui.diagram.edit.policies.UrmlBaseItemSemanticEditPolicy;

import urml.requirement.NonFunctionalRequirement;

/**
 * @generated
 */
public class NonFunctionalRequirementSubNonFunctionalRequirementsReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject referenceOwner;

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
	public NonFunctionalRequirementSubNonFunctionalRequirementsReorientCommand(
		ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		reorientDirection = request.getDirection();
		referenceOwner = request.getReferenceOwner();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == referenceOwner instanceof NonFunctionalRequirement) {
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
		if (!(oldEnd instanceof NonFunctionalRequirement && newEnd instanceof NonFunctionalRequirement)) {
			return false;
		}
		return UrmlBaseItemSemanticEditPolicy.LinkConstraints
			.canExistNonFunctionalRequirementSubNonFunctionalRequirements_4043(getNewSource(), getOldTarget());
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof NonFunctionalRequirement && newEnd instanceof NonFunctionalRequirement)) {
			return false;
		}
		return UrmlBaseItemSemanticEditPolicy.LinkConstraints
			.canExistNonFunctionalRequirementSubNonFunctionalRequirements_4043(getOldSource(), getNewTarget());
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
		getOldSource().getSubNonFunctionalRequirements().remove(getOldTarget());
		getNewSource().getSubNonFunctionalRequirements().add(getOldTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().getSubNonFunctionalRequirements().remove(getOldTarget());
		getOldSource().getSubNonFunctionalRequirements().add(getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected NonFunctionalRequirement getOldSource() {
		return (NonFunctionalRequirement) referenceOwner;
	}

	/**
	 * @generated
	 */
	protected NonFunctionalRequirement getNewSource() {
		return (NonFunctionalRequirement) newEnd;
	}

	/**
	 * @generated
	 */
	protected NonFunctionalRequirement getOldTarget() {
		return (NonFunctionalRequirement) oldEnd;
	}

	/**
	 * @generated
	 */
	protected NonFunctionalRequirement getNewTarget() {
		return (NonFunctionalRequirement) newEnd;
	}
}
