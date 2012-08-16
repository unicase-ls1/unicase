/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package scrm.diagram.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.ecp.model.ECPModelelementContext;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.workSpaceModel.util.AssociationClassHelper;

import scrm.SCRMDiagram;
import scrm.SCRMModelElement;
import scrm.SCRMSpace;
import scrm.diagram.util.EditPartUtility;

// dengler: refactor use of edit part request and variables
/**
 * Command to remove a model element from the diagram elements list, not from
 * the model.
 * 
 * @author denglerm
 */
public class DeleteFromDiagramCommand extends DestroyElementCommand {

	/**
	 * The element's EditPart.
	 */
	private final EditPart editPart;

	/**
	 * Constructs a new command to delete an element from the diagram.
	 * 
	 * @param request
	 *            the destroy element request
	 * @param editPart
	 *            the editPart of the element to delete from the diagram
	 */
	public DeleteFromDiagramCommand(DestroyElementRequest request,
			EditPart editPart) {
		super(request);
		this.editPart = editPart;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {

		EObject destructee = null;
		destructee = this.getElementToDestroy();

		ECPModelelementContext context = ECPWorkspaceManager
				.getECPProject(destructee);

		if (context == null) {
			return CommandResult
					.newErrorCommandResult("Could not compute association classes to delete.");
		}
		List<EObject> additionalMEs = AssociationClassHelper
				.getRelatedAssociationClassToDelete(destructee,
						context.getMetaModelElementContext());
		EditPart diagramEditPart = EditPartUtility
				.getDiagramEditPart(this.editPart);
		SCRMDiagram scrmDiagram = (SCRMDiagram) EditPartUtility
				.getElement(diagramEditPart);
		List<SCRMModelElement> elements = scrmDiagram.getElements();
		elements.remove(destructee);
		for (EObject additionalME : additionalMEs) {
			elements.remove(additionalME);
		}

		EObject model = ((View) editPart.getModel()).getElement();
		EObject container = model.eContainer();
		EObject containee = model;

		while (container instanceof SCRMSpace) {
			containee = container;
			container = container.eContainer();
		}

		if (containee != model) {
			addToParent(container, containee, model);
		}

		return CommandResult.newOKCommandResult();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void addToParent(EObject container, EObject containee, EObject model) {
		EStructuralFeature containingFeature = containee.eContainingFeature();
		List containedObjects = (List) container.eGet(containingFeature);
		containedObjects.add(model);
	}

}