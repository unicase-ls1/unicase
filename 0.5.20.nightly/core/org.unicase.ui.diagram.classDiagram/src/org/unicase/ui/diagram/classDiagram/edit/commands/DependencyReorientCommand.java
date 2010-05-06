/*
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 *   accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.classDiagram.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.unicase.model.classes.Dependency;
import org.unicase.model.classes.PackageElement;
import org.unicase.model.diagram.MEDiagram;

/**
 * @generated
 */
public class DependencyReorientCommand extends EditElementCommand {

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
	public DependencyReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Dependency) {
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
		if (!(oldEnd instanceof PackageElement && newEnd instanceof PackageElement)) {
			return false;
		}
		PackageElement target = getLink().getTarget();
		if (!(getLink().eContainer() instanceof MEDiagram)) {
			return false;
		}
		MEDiagram container = (MEDiagram) getLink().eContainer();
		return org.unicase.ui.diagram.classDiagram.edit.policies.ModelBaseItemSemanticEditPolicy.LinkConstraints
				.canExistDependency_4006(container, getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof PackageElement && newEnd instanceof PackageElement)) {
			return false;
		}
		PackageElement source = getLink().getSource();
		if (!(getLink().eContainer() instanceof MEDiagram)) {
			return false;
		}
		MEDiagram container = (MEDiagram) getLink().eContainer();
		return org.unicase.ui.diagram.classDiagram.edit.policies.ModelBaseItemSemanticEditPolicy.LinkConstraints
				.canExistDependency_4006(container, source, getNewTarget());
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
		getLink().setSource(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setTarget(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Dependency getLink() {
		return (Dependency) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected PackageElement getOldSource() {
		return (PackageElement) oldEnd;
	}

	/**
	 * @generated
	 */
	protected PackageElement getNewSource() {
		return (PackageElement) newEnd;
	}

	/**
	 * @generated
	 */
	protected PackageElement getOldTarget() {
		return (PackageElement) oldEnd;
	}

	/**
	 * @generated
	 */
	protected PackageElement getNewTarget() {
		return (PackageElement) newEnd;
	}
}
