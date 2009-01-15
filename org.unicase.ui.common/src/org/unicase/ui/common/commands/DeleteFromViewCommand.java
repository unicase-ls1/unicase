package org.unicase.ui.common.commands;

/******************************************************************************
 * Copyright (c) 2005, 2006 IBM Corporation and others. All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors: IBM Corporation - initial API and implementation
 ****************************************************************************/
import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.unicase.model.ModelElement;
import org.unicase.model.classes.Association;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.diagram.MEDiagramEditPart;
import org.unicase.ui.common.util.UnicaseUiUtil;

/**
 * Command to remove a model element from the diagram, not from the model, using the EMF action protocol.
 * 
 * @author denglerm
 * @author ldamus
 * @author Christian W. Damus (cdamus)
 */
public class DeleteFromViewCommand extends org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand {

	/**
	 * The element to be destroyed.
	 */
	private final EObject elementToDestroy;
	private final EditPart editpart;

	/**
	 * Constructs a new command to destroy a model element.
	 * 
	 * @param request the destroy element request
	 * @param editpart the editpart of the view
	 */
	public DeleteFromViewCommand(DestroyElementRequest request, EditPart editpart) {

		super(request.getLabel(), request.getContainer(), request);
		this.elementToDestroy = request.getElementToDestroy();
		this.editpart = editpart;
	}

	/**
	 * Convenience method for destroying the specified object by executing a <code>DestroyElementCommand</code> on it,
	 * if it is attached to a resource. Detached elements cannot be destroyed.
	 * <p>
	 * <b>Note</b> that the command will not be executed on the operation history.
	 * 
	 * @param eObject an element to destroy
	 */
	/*
	 * public static void destroy(EObject eObject) { Resource resource = eObject.eResource(); if (resource != null) {
	 * DestroyElementRequest destroy = new DestroyElementRequest( TransactionUtil.getEditingDomain(resource), eObject,
	 * false); IElementType context = ElementTypeRegistry.getInstance().getElementType( destroy.getEditHelperContext());
	 * ICommand command = context.getEditCommand(destroy); if (command != null && command.canExecute()) { try {
	 * command.execute(new NullProgressMonitor(), null); } catch (ExecutionException e) {
	 * Trace.catching(EMFTypePlugin.getPlugin(), EMFTypeDebugOptions.EXCEPTIONS_CATCHING, DeleteFromViewCommand.class,
	 * "destroy(EObject)", e); //$NON-NLS-1$ Log.error(EMFTypePlugin.getPlugin(),
	 * EMFTypePluginStatusCodes.COMMAND_FAILURE, NLS.bind(EMFTypeCoreMessages.destroyCommandFailed,
	 * context.getDisplayName()), e); } } } }
	 */
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		EObject destructee = getElementToDestroy();

		// only destroy attached elements
		if ((destructee != null) && (destructee.eResource() != null)) {
			MEDiagramEditPart me = (MEDiagramEditPart) editpart.getParent();
			MEDiagram diag = (MEDiagram) ((View) me.getModel()).getElement();
			diag.getElements().remove(destructee);

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
		MEDiagramEditPart me = (MEDiagramEditPart) editpart.getParent();
		MEDiagram diag = (MEDiagram) ((View) me.getModel()).getElement();
		ArrayList<Association> assocs = UnicaseUiUtil.getDiagramNodeReferences((ModelElement) destructee);
		for (Association assoc : assocs) {
			if (diag.getElements().contains(assoc)) {
				diag.getElements().remove(assoc);
			}
		}
	}

	/**
	 * Gets the element to be destroyed.
	 * 
	 * @return the element to be destroyed
	 */
	protected EObject getElementToDestroy() {
		return elementToDestroy;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean canExecute() {
		return (elementToDestroy != null) && (elementToDestroy.eResource() != null);
	}

}