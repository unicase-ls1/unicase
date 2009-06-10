package org.unicase.ui.urmlDiagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.unicase.model.requirement.Scenario;
import org.unicase.model.requirement.UseCase;

/**
 * @generated
 */
public class ScenarioInstantiatedUseCasesReorientCommand extends
		EditElementCommand {

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
	public ScenarioInstantiatedUseCasesReorientCommand(
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
		if (false == referenceOwner instanceof Scenario) {
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
		if (!(oldEnd instanceof UseCase && newEnd instanceof Scenario)) {
			return false;
		}
		return org.unicase.ui.urmlDiagram.edit.policies.ModelBaseItemSemanticEditPolicy.LinkConstraints
				.canExistScenarioInstantiatedUseCases_4002(getNewSource(),
						getOldTarget());
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof UseCase && newEnd instanceof UseCase)) {
			return false;
		}
		return org.unicase.ui.urmlDiagram.edit.policies.ModelBaseItemSemanticEditPolicy.LinkConstraints
				.canExistScenarioInstantiatedUseCases_4002(getOldSource(),
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
		getOldSource().getInstantiatedUseCases().remove(getOldTarget());
		getNewSource().getInstantiatedUseCases().add(getOldTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getOldSource().getInstantiatedUseCases().remove(getOldTarget());
		getOldSource().getInstantiatedUseCases().add(getNewTarget());
		return CommandResult.newOKCommandResult(referenceOwner);
	}

	/**
	 * @generated
	 */
	protected Scenario getOldSource() {
		return (Scenario) referenceOwner;
	}

	/**
	 * @generated
	 */
	protected Scenario getNewSource() {
		return (Scenario) newEnd;
	}

	/**
	 * @generated
	 */
	protected UseCase getOldTarget() {
		return (UseCase) oldEnd;
	}

	/**
	 * @generated
	 */
	protected UseCase getNewTarget() {
		return (UseCase) newEnd;
	}
}
