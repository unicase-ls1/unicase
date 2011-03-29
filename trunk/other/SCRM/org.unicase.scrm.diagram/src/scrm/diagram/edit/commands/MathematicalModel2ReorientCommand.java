package scrm.diagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;

import scrm.diagram.edit.policies.ScrmBaseItemSemanticEditPolicy;
import scrm.knowledge.MathematicalModel;

/**
 * @generated
 */
public class MathematicalModel2ReorientCommand extends EditElementCommand {

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
	public MathematicalModel2ReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof MathematicalModel) {
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
		if (!(oldEnd instanceof MathematicalModel && newEnd instanceof MathematicalModel)) {
			return false;
		}
		if (getLink().getSubMathematicalModels().size() != 1) {
			return false;
		}
		MathematicalModel target = (MathematicalModel) getLink()
				.getSubMathematicalModels().get(0);
		if (!(getLink().eContainer() instanceof MathematicalModel)) {
			return false;
		}
		MathematicalModel container = (MathematicalModel) getLink()
				.eContainer();
		return ScrmBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistMathematicalModel_4010(container, getLink(),
						getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof MathematicalModel && newEnd instanceof MathematicalModel)) {
			return false;
		}
		MathematicalModel source = getLink().getSuperMathematicalModel();
		if (!(getLink().eContainer() instanceof MathematicalModel)) {
			return false;
		}
		MathematicalModel container = (MathematicalModel) getLink()
				.eContainer();
		return ScrmBaseItemSemanticEditPolicy.getLinkConstraints()
				.canExistMathematicalModel_4010(container, getLink(), source,
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
		getLink().setSuperMathematicalModel(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().getSubMathematicalModels().remove(getOldTarget());
		getLink().getSubMathematicalModels().add(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected MathematicalModel getLink() {
		return (MathematicalModel) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected MathematicalModel getOldSource() {
		return (MathematicalModel) oldEnd;
	}

	/**
	 * @generated
	 */
	protected MathematicalModel getNewSource() {
		return (MathematicalModel) newEnd;
	}

	/**
	 * @generated
	 */
	protected MathematicalModel getOldTarget() {
		return (MathematicalModel) oldEnd;
	}

	/**
	 * @generated
	 */
	protected MathematicalModel getNewTarget() {
		return (MathematicalModel) newEnd;
	}
}
