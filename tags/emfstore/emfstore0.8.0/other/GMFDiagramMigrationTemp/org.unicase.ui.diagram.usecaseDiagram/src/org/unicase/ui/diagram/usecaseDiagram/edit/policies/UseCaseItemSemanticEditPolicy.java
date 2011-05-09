/*
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 *   accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 *   distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.usecaseDiagram.edit.policies;

import java.util.Iterator;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class UseCaseItemSemanticEditPolicy
		extends
		org.unicase.ui.diagram.usecaseDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public UseCaseItemSemanticEditPolicy() {
		super(
				org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCase_2002);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		View view = (View) getHost().getModel();
		CompositeTransactionalCommand cmd = new CompositeTransactionalCommand(
				getEditingDomain(), null);
		cmd.setTransactionNestingEnabled(false);
		for (Iterator it = view.getTargetEdges().iterator(); it.hasNext();) {
			Edge incomingLink = (Edge) it.next();
			if (org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
					.getVisualID(incomingLink) == org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
					.getVisualID(incomingLink) == org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorInitiatedUseCasesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
					.getVisualID(incomingLink) == org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
			if (org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
					.getVisualID(incomingLink) == org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						incomingLink.getSource().getElement(), null,
						incomingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), incomingLink));
				continue;
			}
		}
		for (Iterator it = view.getSourceEdges().iterator(); it.hasNext();) {
			Edge outgoingLink = (Edge) it.next();
			if (org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
					.getVisualID(outgoingLink) == org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
			if (org.unicase.ui.diagram.usecaseDiagram.part.ModelVisualIDRegistry
					.getVisualID(outgoingLink) == org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID) {
				DestroyReferenceRequest r = new DestroyReferenceRequest(
						outgoingLink.getSource().getElement(), null,
						outgoingLink.getTarget().getElement(), false);
				cmd.add(new DestroyReferenceCommand(r));
				cmd.add(new DeleteCommand(getEditingDomain(), outgoingLink));
				continue;
			}
		}
		EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
		if (annotation == null) {
			// there are indirectly referenced children, need extra commands: false
			addDestroyShortcutsCommand(cmd, view);
			// delete host element
			cmd.add(new DestroyElementCommand(req));
		} else {
			cmd.add(new DeleteCommand(getEditingDomain(), view));
		}
		return getGEFWrapper(cmd.reduce());
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		Command command = req.getTarget() == null ? getStartCreateRelationshipCommand(req)
				: getCompleteCreateRelationshipCommand(req);
		return command != null ? command : super
				.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getStartCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001 == req
				.getElementType()) {
			return null;
		}
		if (org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_4002 == req
				.getElementType()) {
			return null;
		}
		if (org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.diagram.usecaseDiagram.edit.commands.UseCaseIncludedUseCasesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.diagram.usecaseDiagram.edit.commands.UseCaseExtendedUseCasesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected Command getCompleteCreateRelationshipCommand(
			CreateRelationshipRequest req) {
		if (org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorParticipatedUseCases_4001 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.diagram.usecaseDiagram.edit.commands.ActorParticipatedUseCasesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.ActorInitiatedUseCases_4002 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.diagram.usecaseDiagram.edit.commands.ActorInitiatedUseCasesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseIncludedUseCases_4003 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.diagram.usecaseDiagram.edit.commands.UseCaseIncludedUseCasesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		if (org.unicase.ui.diagram.usecaseDiagram.providers.ModelElementTypes.UseCaseExtendedUseCases_4004 == req
				.getElementType()) {
			return getGEFWrapper(new org.unicase.ui.diagram.usecaseDiagram.edit.commands.UseCaseExtendedUseCasesCreateCommand(
					req, req.getSource(), req.getTarget()));
		}
		return null;
	}

	/**
	 * Returns command to reorient EReference based link. New link target or source
	 * should be the domain model element associated with this node.
	 * 
	 * @generated
	 */
	protected Command getReorientReferenceRelationshipCommand(
			ReorientReferenceRelationshipRequest req) {
		switch (getVisualID(req)) {
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorParticipatedUseCasesEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.usecaseDiagram.edit.commands.ActorParticipatedUseCasesReorientCommand(
					req));
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.ActorInitiatedUseCasesEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.usecaseDiagram.edit.commands.ActorInitiatedUseCasesReorientCommand(
					req));
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseIncludedUseCasesEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.usecaseDiagram.edit.commands.UseCaseIncludedUseCasesReorientCommand(
					req));
		case org.unicase.ui.diagram.usecaseDiagram.edit.parts.UseCaseExtendedUseCasesEditPart.VISUAL_ID:
			return getGEFWrapper(new org.unicase.ui.diagram.usecaseDiagram.edit.commands.UseCaseExtendedUseCasesReorientCommand(
					req));
		}
		return super.getReorientReferenceRelationshipCommand(req);
	}

}
