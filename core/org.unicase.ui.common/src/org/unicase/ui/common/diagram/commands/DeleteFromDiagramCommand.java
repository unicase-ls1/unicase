/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.diagram.commands;
import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.diagram.edit.parts.MEDiagramEditPart;
import org.unicase.ui.common.diagram.util.EditPartUtility;
import org.unicase.ui.common.util.UnicaseUiUtil;

/**
 * Command to remove a model element from the diagram, not from the model, using the EMF action protocol.
 * 
 * @author denglerm
 */
public class DeleteFromDiagramCommand extends DestroyElementCommand {

	/**
	 * The element to be destroyed.
	 */
	private final EObject elementToDestroy;
	/**
	 * The element's EditPart.
	 */
	private final EditPart editPart;

	/**
	 * Constructs a new command to destroy a model element.
	 * 
	 * @param request the destroy element request
	 * @param editPart the editPart of the element to destroy
	 */
	public DeleteFromDiagramCommand(DestroyElementRequest request, EditPart editPart) {
		super(request);
		this.elementToDestroy = request.getElementToDestroy();
		this.editPart = editPart;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		EObject destructee = getElementToDestroy();

		// only destroy attached elements
		if (destructee != null) {
			MEDiagramEditPart me = (MEDiagramEditPart) EditPartUtility.getDiagramEditPart(this.editPart);
			MEDiagram diag = (MEDiagram) ((View) me.getModel()).getElement();
			diag.getElements().remove(this.elementToDestroy);
			// tear down incoming references
			tearDownReferences(destructee);
		}

		return CommandResult.newOKCommandResult();
	}

	/**
	 * Remove references (e.g. associations in class diagram) from the element to other diagram elements.
	 * 
	 * @param destructee the object being destroyed
	 */
	protected void tearDownReferences(EObject destructee) {
		MEDiagramEditPart me = (MEDiagramEditPart) EditPartUtility.getDiagramEditPart(this.editPart);
		MEDiagram diag = (MEDiagram) ((View) me.getModel()).getElement();
		Collection<EObject> diagramNodeReferences = UnicaseUiUtil.getDiagramNodeReferences((ModelElement) destructee);
		for (EObject object : diagramNodeReferences) {
			if (diag.getElements().contains(object)) {
				diag.getElements().remove(object);
			}
		}
	}
}