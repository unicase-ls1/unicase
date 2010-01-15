/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.diagram.activityDiagram.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.unicase.model.diagram.DiagramPackage;

/**
 * @generated
 */
public class MEDiagramItemSemanticEditPolicy extends
	org.unicase.ui.diagram.activityDiagram.edit.policies.ModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		if (org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Activity_2002 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(DiagramPackage.eINSTANCE.getMEDiagram_NewElements());
			}
			return getGEFWrapper(new org.unicase.ui.diagram.activityDiagram.edit.commands.ActivityCreateCommand(req));
		}
		if (org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Fork_2003 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(DiagramPackage.eINSTANCE.getMEDiagram_NewElements());
			}
			return getGEFWrapper(new org.unicase.ui.diagram.activityDiagram.edit.commands.ForkCreateCommand(req));
		}
		if (org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.ActivityInitial_2004 == req
			.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(DiagramPackage.eINSTANCE.getMEDiagram_NewElements());
			}
			return getGEFWrapper(new org.unicase.ui.diagram.activityDiagram.edit.commands.ActivityInitialCreateCommand(
				req));
		}
		if (org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.ActivityEnd_2005 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(DiagramPackage.eINSTANCE.getMEDiagram_NewElements());
			}
			return getGEFWrapper(new org.unicase.ui.diagram.activityDiagram.edit.commands.ActivityEndCreateCommand(req));
		}
		if (org.unicase.ui.diagram.activityDiagram.providers.ModelElementTypes.Branch_2006 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(DiagramPackage.eINSTANCE.getMEDiagram_NewElements());
			}
			return getGEFWrapper(new org.unicase.ui.diagram.activityDiagram.edit.commands.BranchCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}

	}

}
