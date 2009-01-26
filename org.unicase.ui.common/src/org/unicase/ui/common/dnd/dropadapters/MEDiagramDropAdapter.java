/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.common.dnd.dropadapters;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.diagram.commands.DiagramElementAddCommand;
import org.unicase.ui.common.util.ActionHelper;

/**
 * Drop adapter for MEDiagrams.
 * 
 * @author Hodaie
 */
public class MEDiagramDropAdapter extends MEDropAdapter {

	/**
	 * Constructor.
	 * 
	 * @param domain TransactionalEditingDomain
	 * @param viewer viewer
	 */
	public MEDiagramDropAdapter(TransactionalEditingDomain domain, StructuredViewer viewer) {
		super(domain, viewer);

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.dnd.dropadapters.MEDropAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent,
	 *      org.unicase.model.ModelElement, java.util.List)
	 */
	@Override
	public void drop(DropTargetEvent event, ModelElement target, List<ModelElement> source) {
		ModelElement dropee = source.get(0);
		IEditorPart iep = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (iep instanceof DiagramDocumentEditor) {
			CreateElementRequest req = new CreateElementRequest(target, ElementTypeRegistry.getInstance()
				.getElementType(dropee));
			req.setNewElement(dropee);
			DiagramDocumentEditor dde = (DiagramDocumentEditor) iep;
			dde.getDiagramEditPart().getViewer().getEditDomain().getCommandStack().execute(
				new ICommandProxy(new DiagramElementAddCommand(req)));
		}
		ActionHelper.openModelElement(target, this.getClass().getName());
	}

	/**
	 * @param diagram
	 * @param dropee
	 * @return
	 */
	private boolean isElementOfDiagram(MEDiagram diagram, EObject dropee) {
		if (dropee instanceof MEDiagram) {
			return false;
		}
		DiagramType type = diagram.getType();
		String clientContextID = "ModelClientContext";
		if (type == DiagramType.USECASE_DIAGRAM) {
			clientContextID = "UseCaseClientContext";
		} else if (type == DiagramType.COMPONENT_DIAGRAM) {
			clientContextID = "ComponentClientContext";
		} else if (type == DiagramType.CLASS_DIAGRAM) {
			clientContextID = "ClassClientContext";
		} else if (type == DiagramType.STATE_DIAGRAM) {
			clientContextID = "StateClientContext";
		}

		IClientContext cc = ClientContextManager.getInstance().getClientContext(clientContextID);
		if (cc == null) {
			return false;
		}
		IElementType[] containedTypes = ElementTypeRegistry.getInstance().getElementTypes(cc);
		IElementType dropeeType = ElementTypeRegistry.getInstance().getElementType(dropee, cc);
		boolean contains = false;
		for (int i = 0; i < containedTypes.length; i++) {
			contains |= containedTypes[i].equals(dropeeType);
		}
		return contains;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.dnd.dropadapters.MEDropAdapter#canDrop(org.eclipse.swt.dnd.DropTargetEvent,
	 *      java.util.List, org.unicase.model.ModelElement, org.unicase.model.ModelElement)
	 */
	@Override
	public boolean canDrop(int eventFeedback, DropTargetEvent event, List<ModelElement> source, ModelElement target,
		ModelElement dropee) {

		boolean result = super.canDrop(eventFeedback, event, source, target, dropee);
		if (!isElementOfDiagram((MEDiagram) target, dropee) || ((MEDiagram) target).getElements().contains(dropee)) {
			result = false;
		}

		return result;
	}

}
