/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.emfstore.jdt.ui.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.presentation.GenModelEditor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.unicase.emfstore.jdt.emf.resource.EMFStoreResourceSet;
import org.unicase.workspace.WorkspaceManager;

/**
 * Modified GenModelEditor which adapts the original GenModelEditor to be able to load the content from the EMFStore.
 * For that the editingDomain has to be overwritten with an appropriate command stack an resource set.
 * 
 * @author Adrian Staudt
 */
public class EMFStoreGenModelEditor extends GenModelEditor {

	private boolean isInEMFStoreMode;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.codegen.ecore.genmodel.presentation.GenModelEditor#init(org.eclipse.ui.IEditorSite,
	 *      org.eclipse.ui.IEditorInput)
	 */
	@Override
	public void init(IEditorSite site, IEditorInput editorInput) throws PartInitException {
		EditorInputDecider editorInputDecider = new EditorInputDecider(editorInput);
		if (editorInputDecider.isSuitableEditorInputEMFStoreCompatible()) {
			editorInput = editorInputDecider.getSuitableEditorInput();

			// reset editingDomain
			EMFStoreResourceSet resourceSet = new EMFStoreResourceSet();

			EditingDomain unicaseEditingDomain = WorkspaceManager.getInstance().getCurrentWorkspace()
				.getEditingDomain();
			CommandStack commandStack = unicaseEditingDomain.getCommandStack();
			editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack, resourceSet);
		}

		super.init(site, editorInput);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.codegen.ecore.genmodel.presentation.GenModelEditor#isDirty()
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
	 * @see org.eclipse.emf.codegen.ecore.genmodel.presentation.GenModelEditor#doSave(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void doSave(IProgressMonitor progressMonitor) {
		super.doSave(progressMonitor);
	}
}
