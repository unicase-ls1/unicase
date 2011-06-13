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
import scrm.requirements.DataFlow;

/**
 * @generated
 */
public class DataFlowSpecifiedProcessReorientCommand extends EditElementCommand {

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
	public DataFlowSpecifiedProcessReorientCommand(
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
		if (false == referenceOwner instanceof DataFlow) {
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
		if (!(oldEnd instanceof scrm.requirements.dataProcess.Process && newEnd instanceof DataFlow)) {
			return false;
		}
		return ScrmBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistDataFlowSpecifiedProcess_4056(getNewSource(),
						getOldTarget());
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof scrm.requirements.dataProcess.Process && newEnd instanceof scrm.requirements.dataProcess.Process)) {
			return false;
		}
		return ScrmBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistDataFlowSpecifiedProcess_4056(getOldSource(),
						getNewTarget());
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException(
					"Invalid arguments in reorient link command"); //$NON-NLS-1$
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
		getOldSource().setSpecifiedProcess(null);
		getNewSource().setSpecifiedProcess(getOldTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().setSpecifiedProcess(getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected DataFlow getOldSource() {
		return (DataFlow) referenceOwner;
	}

	/**
	 * @generated
	 */
	protected DataFlow getNewSource() {
		return (DataFlow) newEnd;
	}

	/**
	 * @generated
	 */
	protected scrm.requirements.dataProcess.Process getOldTarget() {
		return (scrm.requirements.dataProcess.Process) oldEnd;
	}

	/**
	 * @generated
	 */
	protected scrm.requirements.dataProcess.Process getNewTarget() {
		return (scrm.requirements.dataProcess.Process) newEnd;
	}
}
