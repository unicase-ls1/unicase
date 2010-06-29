/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.dnd.dropadapters;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.model.diagram.ActivityDiagram;
import org.unicase.model.diagram.ClassDiagram;
import org.unicase.model.diagram.ComponentDiagram;
import org.unicase.model.diagram.DiagramPackage;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.model.diagram.StateDiagram;
import org.unicase.model.diagram.UseCaseDiagram;
import org.unicase.model.diagram.WorkItemDiagram;
import org.unicase.ui.unicasecommon.UnicaseActionHelper;
import org.unicase.workspace.util.UnicaseCommand;

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
	public void drop(DropTargetEvent event, final ModelElement target, List<ModelElement> source) {
		final UnicaseModelElement dropee = (UnicaseModelElement) source.get(0);
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				((MEDiagram) target).getElements().add(dropee);

			}
		}.run();
		UnicaseActionHelper.openModelElement(target, this.getClass().getName());
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

		String clientContextID = "ModelClientContext";
		if (diagram instanceof UseCaseDiagram) {
			clientContextID = "org.unicase.ui.diagram.usecaseDiagram.TypeContext";
		} else if (diagram instanceof ComponentDiagram) {
			clientContextID = "org.unicase.ui.diagram.componentDiagram.TypeContext";
		} else if (diagram instanceof ClassDiagram) {
			clientContextID = "org.unicase.ui.diagram.classDiagram.TypeContext";
		} else if (diagram instanceof StateDiagram) {
			clientContextID = "org.unicase.ui.diagram.stateDiagram.TypeContext";
		} else if (diagram instanceof ActivityDiagram) {
			clientContextID = "org.unicase.ui.diagram.activityDiagram.TypeContext";
		} else if (diagram instanceof WorkItemDiagram) {
			clientContextID = "WorkItemClientContext";
		}
		Set clientContexts = ClientContextManager.getInstance().getClientContexts();
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
	public boolean canDrop(int eventFeedback, DropTargetEvent event, final List<ModelElement> source,
		final ModelElement target, ModelElement dropee) {

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
