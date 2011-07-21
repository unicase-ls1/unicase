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
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.ecp.model.ECPModelelementContext;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.workSpaceModel.util.AssociationClassHelper;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelUtil;

import scrm.SCRMDiagram;
import scrm.diagram.util.EditPartUtility;

// dengler: refactor use of edit part request and variables
/**
 * Command to remove a model element from the diagram elements list, not from the model.
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
	 * @param request the destroy element request
	 * @param editPart the editPart of the element to delete from the diagram
	 */
	public DeleteFromDiagramCommand(DestroyElementRequest request, EditPart editPart) {
		super(request);
		this.editPart = editPart;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		EObject destructee = null;
		destructee = this.getElementToDestroy();
		
		ECPModelelementContext context = ECPWorkspaceManager.getECPProject(destructee);
		
		if (context == null) {
			return CommandResult.newErrorCommandResult("Could not compute association classes to delete.");
		}
		List<EObject> additionalMEs = AssociationClassHelper.getRelatedAssociationClassToDelete(destructee, context.getMetaModelElementContext());
		EditPart diagramEditPart = EditPartUtility.getDiagramEditPart(this.editPart);
		SCRMDiagram diag = (SCRMDiagram) EditPartUtility.getElement(diagramEditPart);
		diag.getElements().remove(destructee);
		for (EObject additionalME : additionalMEs) {
			diag.getElements().remove(additionalME);
		}
		
		final EObject model = ((View) editPart.getModel()).getElement();
		if(!(model.eContainer() instanceof Project)) {
			final Project project = ModelUtil.getProject(diag);
			project.addModelElement(model);
		}

		return CommandResult.newOKCommandResult();
	}
}