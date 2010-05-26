/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.dnd.dropadapters;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.DiagramType;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.unicasecommon.diagram.commands.CommandFactory;

/**
 * Drop adapter for MEDiagrams.
 * 
 * @author Hodaie
 */
public class MEDiagramDropAdapter extends UCDropAdapter {

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.common.dnd.MEDropAdapter#drop(org.eclipse.swt.dnd.DropTargetEvent,
	 *      org.unicase.metamodel.ModelElement, java.util.List)
	 */
	@Override
	public void drop(DropTargetEvent event, EObject target, List<EObject> source) {
		ActionHelper.openModelElement(target, this.getClass().getName());
		UnicaseModelElement dropee = (UnicaseModelElement) source.get(0);
		IEditorPart iep = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (iep instanceof DiagramDocumentEditor) {
			DiagramDocumentEditor dde = (DiagramDocumentEditor) iep;
			DiagramEditPart editPart = dde.getDiagramEditPart();
			editPart.getViewer().getEditDomain().getCommandStack().execute(
				CommandFactory.createDiagramElementAddCommand(dropee, editPart, true));
		}
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
		// TODO : EMFPlainEObjectTransition: diagram type

		DiagramType type = null; // diagram.getType();
		String clientContextID = "ModelClientContext";

		if (type == DiagramType.USECASE_DIAGRAM) {
			clientContextID = "UseCaseClientContext";
		} else if (type == DiagramType.COMPONENT_DIAGRAM) {
			clientContextID = "ComponentClientContext";
		} else if (type == DiagramType.CLASS_DIAGRAM) {
			clientContextID = "ModelClientContext";
		} else if (type == DiagramType.STATE_DIAGRAM) {
			clientContextID = "StateClientContext";
		} else if (type == DiagramType.ACTIVITY_DIAGRAM) {
			clientContextID = "ActivityClientContext";
		} else if (type == DiagramType.WORKITEM_DIAGRAM) {
			clientContextID = "WorkItemClientContext";
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
	 * @see org.unicase.ui.common.dnd.MEDropAdapter#canDrop(org.eclipse.swt.dnd.DropTargetEvent, java.util.List,
	 *      org.unicase.metamodel.UnicaseModelElement, org.unicase.metamodel.UnicaseModelElement)
	 */
	@Override
	public boolean canDrop(int eventFeedback, DropTargetEvent event, List<EObject> source, EObject target,
		EObject dropee) {

		boolean result = super.canDrop(eventFeedback, event, source, target, dropee);
		if (!isElementOfDiagram((MEDiagram) target, dropee) || ((MEDiagram) target).getElements().contains(dropee)) {
			result = false;
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.unicasecommon.dnd.dropadapters.UCDropAdapter#isDropAdapterfor()
	 */
	@Override
	public EClass isDropAdapterfor() {
		return DiagramPackage.eINSTANCE.getMEDiagram();
	}

}
