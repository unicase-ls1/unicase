/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.diagram.commands;

/******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors: IBM Corporation - initial API and implementation
 ****************************************************************************/
import java.util.Collection;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
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
 * @author ldamus
 * @author Christian W. Damus (cdamus)
 */
public class DeleteFromDiagramCommand extends DestroyElementCommand {

	/**
	 * The element to be destroyed.
	 */
	private final EObject elementToDestroy;
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
		if ((destructee != null) && (destructee.eResource() != null)) {
			MEDiagramEditPart me = (MEDiagramEditPart) EditPartUtility.getDiagramEditPart(this.editPart);
			MEDiagram diag = (MEDiagram) ((View) me.getModel()).getElement();
			diag.getElements().remove(this.elementToDestroy);
			// tear down incoming references
			tearDownReferences(destructee);

			// in case it was cross-resource-contained
			Resource res = destructee.eResource();
			if (res != null) {
				res.getContents().remove(destructee);
			}
		}

		return CommandResult.newOKCommandResult();
	}

	/**
	 * Tears down references to the object that we are destroying, from all other objects in the resource set.
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