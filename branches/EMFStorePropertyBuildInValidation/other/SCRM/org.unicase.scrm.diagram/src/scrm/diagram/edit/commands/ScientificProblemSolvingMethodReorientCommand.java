package scrm.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import scrm.diagram.edit.policies.ScrmBaseItemSemanticEditPolicy;
import scrm.knowledge.NumericalMethod;
import scrm.knowledge.ScientificProblem;

/**
 * @generated
 */
public class ScientificProblemSolvingMethodReorientCommand extends EditElementCommand {

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
	public ScientificProblemSolvingMethodReorientCommand(ReorientReferenceRelationshipRequest request) {
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
		if (false == referenceOwner instanceof ScientificProblem) {
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
		if (!(oldEnd instanceof NumericalMethod && newEnd instanceof ScientificProblem)) {
			return false;
		}
		return ScrmBaseItemSemanticEditPolicy.LinkConstraints.canExistScientificProblemSolvingMethod_4007(
			getNewSource(), getOldTarget());
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof NumericalMethod && newEnd instanceof NumericalMethod)) {
			return false;
		}
		return ScrmBaseItemSemanticEditPolicy.LinkConstraints.canExistScientificProblemSolvingMethod_4007(
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
		getOldSource().setSolvingMethod(null);
		getNewSource().setSolvingMethod(getOldTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().setSolvingMethod(getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected ScientificProblem getOldSource() {
		return (ScientificProblem) referenceOwner;
	}

	/**
	 * @generated
	 */
	protected ScientificProblem getNewSource() {
		return (ScientificProblem) newEnd;
	}

	/**
	 * @generated
	 */
	protected NumericalMethod getOldTarget() {
		return (NumericalMethod) oldEnd;
	}

	/**
	 * @generated
	 */
	protected NumericalMethod getNewTarget() {
		return (NumericalMethod) newEnd;
	}
}
