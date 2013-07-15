/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.common.util;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.jface.dialogs.MessageDialog;
import org.unicase.ecp.model.ECPModelelementContext;
import org.unicase.ecp.model.ECPWorkspaceManager;
import org.unicase.ecp.model.NoWorkspaceException;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.diagram.MEDiagram;

/**
 * Helper class for DND.
 * 
 * @author Michael Haeger
 */
public final class DNDHelper {

	private DNDHelper() {
	}

	/**
	 * Return whether the drop on a diagram is allowed or not.
	 * 
	 * @param elements all elements to drop
	 * @param diagram the diagram
	 * @param allowedElements elements that are allowed to drop (empty list thats going to be filled)
	 * @return {@code true} if drop is allowed
	 */
	public static boolean canDrop(List<EObject> elements, MEDiagram diagram, List<EObject> allowedElements) {
		if (!elements.isEmpty()) {
			for (EObject me : elements) {
				// do not add elements that are already added and check if they are allowed for the diagram
				if (!diagram.getElements().contains(me) && DNDHelper.isAllowedType(diagram, me)) {
					allowedElements.add(me);
				}
			}
			if (!allowedElements.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	private static boolean isAllowedType(MEDiagram diagram, EObject dropee) {
		// get all registered contexts
		Set<IClientContext> clientContexts = ClientContextManager.getInstance().getClientContexts();
		for (IClientContext clientContext : clientContexts) {
			IElementType[] containedTypes = ElementTypeRegistry.getInstance().getElementTypes(clientContext);
			IElementType diagramType = ElementTypeRegistry.getInstance().getElementType(diagram, clientContext);
			IElementType dropeeType = ElementTypeRegistry.getInstance().getElementType(dropee, clientContext);
			boolean containedDropee = false;
			boolean containedDiagram = false;
			// checks all types in a given context if they contain the diagram and the dropped element
			for (IElementType containedType : containedTypes) {
				if (containedType.equals(diagramType)) {
					containedDiagram = true;
				}
				if (containedType.equals(dropeeType)) {
					containedDropee = true;
				}
			}
			if (containedDiagram && containedDropee) {
				return true;
			}
		}
		return false;
	}

	/**
	 * If not all elements could be dropped the user is asked whether to drop a part of them.
	 * 
	 * @param elements all elements to drop
	 * @param allowedElements allowed elements to drop
	 * @return {@code true} if the should be performed
	 */
	public static boolean dropMessageCheck(List<EObject> elements, List<EObject> allowedElements) {
		if (allowedElements.size() != elements.size()) {
			// if not all elements could be added
			MessageDialog dialog = new MessageDialog(null, "Confirmation", null, "Only " + allowedElements.size()
				+ " of " + elements.size() + " item(s) could be added. Add item(s)?", MessageDialog.QUESTION,
				new String[] { "Yes", "No" }, 0);
			return dialog.open() == MessageDialog.OK;
		} else {
			return true;
		}
	}

	/**
	 * Returns the ModelElementContext.
	 * 
	 * @return returns {@code ModelElementContext}, {@code null} if exception is thrown
	 */
	public static ECPModelelementContext getECPModelelementContext() {
		try {
			return ECPWorkspaceManager.getInstance().getWorkSpace().getActiveProject();
		} catch (NoWorkspaceException e) {
			ModelUtil.logException(e);
			return null;
		}
	}
}
