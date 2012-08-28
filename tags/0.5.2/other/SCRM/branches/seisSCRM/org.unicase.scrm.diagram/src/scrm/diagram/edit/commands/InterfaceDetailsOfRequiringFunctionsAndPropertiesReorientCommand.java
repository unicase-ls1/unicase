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
import scrm.requirements.Interface;
import scrm.requirements.Requirement;

/**
 * @generated
 */
public class InterfaceDetailsOfRequiringFunctionsAndPropertiesReorientCommand
		extends EditElementCommand {

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
	public InterfaceDetailsOfRequiringFunctionsAndPropertiesReorientCommand(
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
		if (false == referenceOwner instanceof Interface) {
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
		if (!(oldEnd instanceof Requirement && newEnd instanceof Interface)) {
			return false;
		}
		return ScrmBaseItemSemanticEditPolicy
				.getLinkConstraints()
				.canExistInterfaceDetailsOfRequiringFunctionsAndProperties_4071(
						getNewSource(), getOldTarget());
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Requirement && newEnd instanceof Requirement)) {
			return false;
		}
		return ScrmBaseItemSemanticEditPolicy
				.getLinkConstraints()
				.canExistInterfaceDetailsOfRequiringFunctionsAndProperties_4071(
						getOldSource(), getNewTarget());
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
		getOldSource().getDetailsOfRequiringFunctionsAndProperties().remove(
				getOldTarget());
		getNewSource().getDetailsOfRequiringFunctionsAndProperties().add(
				getOldTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().getDetailsOfRequiringFunctionsAndProperties().remove(
				getOldTarget());
		getOldSource().getDetailsOfRequiringFunctionsAndProperties().add(
				getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected Interface getOldSource() {
		return (Interface) referenceOwner;
	}

	/**
	 * @generated
	 */
	protected Interface getNewSource() {
		return (Interface) newEnd;
	}

	/**
	 * @generated
	 */
	protected Requirement getOldTarget() {
		return (Requirement) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Requirement getNewTarget() {
		return (Requirement) newEnd;
	}
}
