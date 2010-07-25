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

import urml.feature.AbstractFeature;
import urml.feature.VariationPoint;

/**
 * @generated
 */
public class VariationPointVarietyReorientCommand extends EditElementCommand {

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
	public VariationPointVarietyReorientCommand(ReorientReferenceRelationshipRequest request) {
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
		if (false == referenceOwner instanceof VariationPoint) {
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
		if (!(oldEnd instanceof AbstractFeature && newEnd instanceof VariationPoint)) {
			return false;
		}
		return UrmlBaseItemSemanticEditPolicy.LinkConstraints.canExistVariationPointVariety_4042(getNewSource(),
			getOldTarget());
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof AbstractFeature && newEnd instanceof AbstractFeature)) {
			return false;
		}
		return UrmlBaseItemSemanticEditPolicy.LinkConstraints.canExistVariationPointVariety_4042(getOldSource(),
			getNewTarget());
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
		getOldSource().getVariety().remove(getOldTarget());
		getNewSource().getVariety().add(getOldTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().getVariety().remove(getOldTarget());
		getOldSource().getVariety().add(getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected VariationPoint getOldSource() {
		return (VariationPoint) referenceOwner;
	}

	/**
	 * @generated
	 */
	protected VariationPoint getNewSource() {
		return (VariationPoint) newEnd;
	}

	/**
	 * @generated
	 */
	protected AbstractFeature getOldTarget() {
		return (AbstractFeature) oldEnd;
	}

	/**
	 * @generated
	 */
	protected AbstractFeature getNewTarget() {
		return (AbstractFeature) newEnd;
	}
}
