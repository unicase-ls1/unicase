/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.activityDiagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.unicase.model.activity.ActivityFactory;
import org.unicase.model.activity.ActivityObject;
import org.unicase.model.activity.Transition;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;

/**
 * @generated
 */
public class TransitionCreateCommand extends CreateElementCommand {

	/**
	 * @generated
	 */
	private final EObject source;

	/**
	 * @generated
	 */
	private final EObject target;

	/**
	 * @generated
	 */
	private MEDiagram container;

	/**
	 * @generated NOT
	 * @param request The request that caused the creation of this command
	 * @param source The source element of the connection to be created
	 * @param target The target element of the connection to be created
	 */
	public TransitionCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request);
		throw new UnsupportedOperationException();
	}

	/**
	 * @param request The request that caused the creation of this command
	 * @param source The source element of the connection to be created
	 * @param target The target element of the connection to be created
	 * @param eContainer The container element which will contain the connection
	 * @generated NOT
	 */
	public TransitionCreateCommand(CreateRelationshipRequest request, EObject source, EObject target, EObject eContainer) {
		super(request);
		this.source = source;
		this.target = target;
		if (request.getContainmentFeature() == null) {
			setContainmentFeature(DiagramPackage.eINSTANCE.getMEDiagram_NewElements());
		}
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
	}

	/**
	 * @generated
	 */
	@Override
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && false == source instanceof ActivityObject) {
			return false;
		}
		if (target != null && false == target instanceof ActivityObject) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if (getContainer() == null) {
			return false;
		}
		return org.unicase.ui.diagram.activityDiagram.edit.policies.ModelBaseItemSemanticEditPolicy.LinkConstraints
			.canCreateTransition_4001(getContainer(), getSource(), getTarget());
	}

	/**
	 * @generated NOT
	 */
	@Override
	protected EObject doDefaultElementCreation() {
		Transition newElement = ActivityFactory.eINSTANCE.createTransition();
		getContainer().getNewElements().add(newElement);
		getContainer().getElements().add(newElement);
		newElement.setSource(getSource());
		newElement.setTarget(getTarget());
		return newElement;
	}

	/**
	 * @generated
	 */
	@Override
	protected EClass getEClassToEdit() {
		return DiagramPackage.eINSTANCE.getMEDiagram();
	}

	/**
	 * @generated
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		return super.doExecuteWithResult(monitor, info);
	}

	/**
	 * @generated
	 */
	@Override
	protected ConfigureRequest createConfigureRequest() {
		ConfigureRequest request = super.createConfigureRequest();
		request.setParameter(CreateRelationshipRequest.SOURCE, getSource());
		request.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		return request;
	}

	/**
	 * @generated
	 */
	@Override
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated
	 */
	protected ActivityObject getSource() {
		return (ActivityObject) source;
	}

	/**
	 * @generated
	 */
	protected ActivityObject getTarget() {
		return (ActivityObject) target;
	}

	/**
	 * @generated
	 */
	public MEDiagram getContainer() {
		return container;
	}
}
