package org.unicase.ui.diagram.urml.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.urml.goal.Goal;
import org.unicase.model.urml.goal.GoalFactory;
import org.unicase.model.urml.goal.GoalReference;
import org.unicase.ui.diagram.urml.edit.policies.UrmlBaseItemSemanticEditPolicy;
import org.unicase.ui.diagram.urml.providers.UrmlElementTypes;

/**
 * @generated
 */
public class GoalReference3CreateCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final EObject source;

	/**
	 * @generated
	 */
	private final EObject target;

	/**
	 * @generated NOT
	 */
	private/* final */MEDiagram container;

	/**
	 * This constructor should not be used! Because of our use of a single resource we need to know the connections
	 * container at creation time. Please use the constructor below to create this command.
	 * 
	 * @generated NOT
	 */
	public GoalReference3CreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request.getLabel(), null, request);
		/* user code */
		throw new UnsupportedOperationException();
		/* user code */
	}

	/**
	 * @generated NOT
	 */
	public GoalReference3CreateCommand(CreateRelationshipRequest request, EObject source, EObject target,
		EObject eContainer) {
		super(request.getLabel(), null, request);
		this.source = source;
		this.target = target;

		/* user code */
		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = eContainer; element != null; element = element.eContainer()) {
			if (element instanceof MEDiagram) {
				container = (MEDiagram) element;
				super.setElementToEdit(container);
				break;
			}
		}
		/* user code */
		// container = deduceContainer(source, target);
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && false == source instanceof Goal) {
			return false;
		}
		if (target != null && false == target instanceof Goal) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if (getContainer() == null) {
			return false;
		}
		return UrmlBaseItemSemanticEditPolicy.LinkConstraints.canCreateGoalReference_4024(getContainer(), getSource(),
			getTarget());
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}

		GoalReference newElement = GoalFactory.eINSTANCE.createGoalReference();
		getContainer().getNewElements().add(newElement);
		/* user code */
		getContainer().getElements().add(newElement);
		/* user code */
		newElement.setSource(getSource());
		newElement.setTarget(getTarget());
		UrmlElementTypes.init_GoalReference_4024(newElement);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest) getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);

	}

	/**
	 * @generated
	 */
	protected void doConfigure(GoalReference newElement, IProgressMonitor monitor, IAdaptable info)
		throws ExecutionException {
		IElementType elementType = ((CreateElementRequest) getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest) getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		configureRequest.setParameter(CreateRelationshipRequest.SOURCE, getSource());
		configureRequest.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if (configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

	/**
	 * @generated
	 */
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated
	 */
	protected Goal getSource() {
		return (Goal) source;
	}

	/**
	 * @generated
	 */
	protected Goal getTarget() {
		return (Goal) target;
	}

	/**
	 * @generated
	 */
	public MEDiagram getContainer() {
		return container;
	}

	/**
	 * Default approach is to traverse ancestors of the source to find instance of container. Modify with appropriate
	 * logic.
	 * 
	 * @generated
	 */
	private static MEDiagram deduceContainer(EObject source, EObject target) {
		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for (EObject element = source; element != null; element = element.eContainer()) {
			if (element instanceof MEDiagram) {
				return (MEDiagram) element;
			}
		}
		return null;
	}

}
