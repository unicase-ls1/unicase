/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.unicase.ecpemfstorebridge.EMFStoreModelelementContext;
import org.unicase.metamodel.ModelElement;
import org.unicase.model.UnicaseModelElement;
import org.unicase.ui.common.ModelElementContext;
import org.unicase.ui.common.util.ActionHelper;

/**
 * Helper Class for the UNICASE Client.
 * 
 * @author helming
 */
public final class UnicaseActionHelper {

	private UnicaseActionHelper() {
	};

	/**
	 * Opens a model element in ECP with a Context.
	 * 
	 * @param me modelelement to open.
	 * @param sourceView the source view
	 */
	public static void openModelElement(ModelElement me, String sourceView) {
		ActionHelper.openModelElement(me, sourceView, getContext(me));

	}

	/**
	 * Gives a context for the given ME.
	 * 
	 * @param me the model lement
	 * @return the context
	 */
	public static ModelElementContext getContext(ModelElement me) {
		return new EMFStoreModelelementContext(me);
	}

	/**
	 * This extracts active model element. From MEEditor or from any view which is a selection provider.
	 * 
	 * @param event the ExecutionEvent given by caller handler
	 * @return active model element
	 */
	public static UnicaseModelElement getModelElement(ExecutionEvent event) {

		// TODO: redundant, see ActionHelper
		final String meeditorId = "org.unicase.ui.meeditor";
		UnicaseModelElement me = null;

		// ZH: determine the place from which
		// the command is run (UC Navigator context menu or MEEeditor)
		// This decision is should be made to extract the model element
		// for attaching action item accordingly.
		String partId = HandlerUtil.getActivePartId(event);
		if (partId != null && partId.equals(meeditorId)) {
			// extract model element from editor input
			IEditorInput editorInput = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor().getEditorInput();
			Object obj = editorInput.getAdapter(EObject.class);

			if (obj instanceof UnicaseModelElement) {
				me = (UnicaseModelElement) obj;
			}

		} else {
			// extract model element from current selection in navigator

			EObject eObject = ActionHelper.getSelection(event);
			if (!(eObject instanceof UnicaseModelElement)) {
				return null;
			}

			me = (UnicaseModelElement) eObject;
		}

		return me;
	}

}
