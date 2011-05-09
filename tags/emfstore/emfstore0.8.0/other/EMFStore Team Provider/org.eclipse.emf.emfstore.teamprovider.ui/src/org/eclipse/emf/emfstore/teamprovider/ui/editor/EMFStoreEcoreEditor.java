/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.emfstore.teamprovider.ui.editor;

import java.util.EventObject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.emfstore.client.model.WorkspaceManager;
import org.eclipse.emf.emfstore.teamprovider.emf.resource.EMFStoreResourceSet;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorSite;

/**
 * Modified EcoreEditor which adapts the original EcoreEditor to be able to load the content from the EMFStore. For that
 * the editingDomain has to be overwritten with an appropriate command stack an resource set.
 * 
 * @author Adrian Staudt
 */
public class EMFStoreEcoreEditor extends EcoreEditor {

	private boolean isInEMFStoreMode;
	private CommandStackListener commandStackListener;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.presentation.EcoreEditor#init(org.eclipse.ui.IEditorSite, org.eclipse.ui.IEditorInput)
	 */
	@Override
	public void init(IEditorSite site, IEditorInput editorInput) {
		// decide how to handle the input
		EditorInputDecider editorInputDecider = new EditorInputDecider(editorInput);
		if (editorInputDecider.isSuitableEditorInputEMFStoreCompatible()) {
			isInEMFStoreMode = true;
			editorInput = editorInputDecider.getSuitableEditorInput();

			// reset editingDomain
			EMFStoreResourceSet resourceSet = new EMFStoreResourceSet();

			EditingDomain unicaseEditingDomain = WorkspaceManager.getInstance().getCurrentWorkspace()
				.getEditingDomain();
			CommandStack commandStack = unicaseEditingDomain.getCommandStack();
			editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, resourceSet);

			// Add a listener to set the most recent command's affected objects to be the selection of the viewer with
			// focus.
			commandStackListener = new CommandStackListener() {
				public void commandStackChanged(final EventObject event) {
					getContainer().getDisplay().asyncExec(new Runnable() {
						public void run() {
							firePropertyChange(IEditorPart.PROP_DIRTY);

							// Try to select the affected objects.
							Command mostRecentCommand = ((CommandStack) event.getSource()).getMostRecentCommand();
							if (mostRecentCommand != null) {
								setSelectionToViewer(mostRecentCommand.getAffectedObjects());
							}
							if (propertySheetPage != null && !propertySheetPage.getControl().isDisposed()) {
								propertySheetPage.refresh();
							}
						}
					});
				}
			};
			commandStack.addCommandStackListener(commandStackListener);
		}

		super.init(site, editorInput);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.presentation.EcoreEditor#isDirty()
	 */
	@Override
	public boolean isDirty() {
		if (isInEMFStoreMode) {
			return false;

		} else {
			BasicCommandStack commandStack = (BasicCommandStack) editingDomain.getCommandStack();
			return commandStack.isSaveNeeded();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.presentation.EcoreEditor#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		super.doSave(progressMonitor);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.ecore.presentation.EcoreEditor#dispose()
	 */
	@Override
	public void dispose() {
		// otherwise next time editor is opened, we get a widget disposed exception
		if (commandStackListener != null) {
			editingDomain.getCommandStack().removeCommandStackListener(commandStackListener);
		}

		super.dispose();
	}
}
