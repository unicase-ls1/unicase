package org.unicase.ui.diagram.urml.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.unicase.model.urml.feature.Product;
import org.unicase.model.urml.feature.VariationPointInstance;
import org.unicase.ui.diagram.urml.edit.policies.UrmlBaseItemSemanticEditPolicy;

/**
 * @generated
 */
public class ProductVariationPointInstancesReorientCommand extends EditElementCommand {

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
	public ProductVariationPointInstancesReorientCommand(ReorientReferenceRelationshipRequest request) {
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
		if (false == referenceOwner instanceof Product) {
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
		if (!(oldEnd instanceof VariationPointInstance && newEnd instanceof Product)) {
			return false;
		}
		return UrmlBaseItemSemanticEditPolicy.LinkConstraints.canExistProductVariationPointInstances_4032(
			getNewSource(), getOldTarget());
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof VariationPointInstance && newEnd instanceof VariationPointInstance)) {
			return false;
		}
		return UrmlBaseItemSemanticEditPolicy.LinkConstraints.canExistProductVariationPointInstances_4032(
			getOldSource(), getNewTarget());
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
		getOldSource().getVariationPointInstances().remove(getOldTarget());
		getNewSource().getVariationPointInstances().add(getOldTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().getVariationPointInstances().remove(getOldTarget());
		getOldSource().getVariationPointInstances().add(getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected Product getOldSource() {
		return (Product) referenceOwner;
	}

	/**
	 * @generated
	 */
	protected Product getNewSource() {
		return (Product) newEnd;
	}

	/**
	 * @generated
	 */
	protected VariationPointInstance getOldTarget() {
		return (VariationPointInstance) oldEnd;
	}

	/**
	 * @generated
	 */
	protected VariationPointInstance getNewTarget() {
		return (VariationPointInstance) newEnd;
	}
}
