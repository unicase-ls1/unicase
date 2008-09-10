/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.SharedHeaderFormEditor;
import org.unicase.model.ModelElement;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;
import org.unicase.workspace.WorkspaceManager;

/**
 * GUI view for editing MEs.
 * 
 * @author helming
 * 
 */
public class MEEditor extends SharedHeaderFormEditor {

	/**
	 * The Id for MEEditor. We need this to open a model element.
	 */
	public static final String ID = "org.unicase.ui.meeditor";
	
	

	private ModelElement modelElement;
	private ComposedAdapterFactory adapterFactory;
	private TransactionalEditingDomain editingDomain;
	private MEEditorPage form;

	/**
	 * Default constructor.
	 */
	public MEEditor() {

	}
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void addPages() {

		form = new MEEditorPage(this, "1", "Standard View", editingDomain,
				modelElement);
		try {
			addPage(form);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		//FIXME JH: can we remove this method?
		monitor.beginTask("Saving...", 1);
		editingDomain.getCommandStack().execute(
				new RecordingCommand(editingDomain) {

					@Override
					protected void doExecute() {
						WorkspaceManager.getProjectSpace(modelElement).save();

					}

				});
		editorDirtyStateChanged();
		monitor.done();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSaveAs() {
	}

	/**
	 * Save is not allowed as the editor can only modify model elements.
	 * 
	 * @return false
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		super.init(site, input);
		if (input instanceof MEEditorInput) {
			setInput(input);
			MEEditorInput meInput = (MEEditorInput) input;
			setPartName(input.getName());
			setTitleImage(input.getImageDescriptor().createImage());

			modelElement = meInput.getModelElement();
			initializeEditingDomain();
			Adapter eAdapter = new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					if (msg.getFeature() instanceof EAttribute && ((EAttribute)msg.getFeature()).getName().equals("name")) {
						setPartName(msg.getNewStringValue());
					}
					
				}
				
			};
			this.modelElement.eAdapters().add(eAdapter);
		} else {
			throw new PartInitException(
					"MEEditor is only appliable for MEEditorInputs");
		}
	}

	/**
	 * Initializes the editing domain for this model element.
	 */
	protected void initializeEditingDomain() {
		this.adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ModelItemProviderAdapterFactory());
		this.adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		this.adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// command stack that will notify this editor as commands are executed
		this.editingDomain = TransactionalEditingDomain.Factory.INSTANCE
				.getEditingDomain(modelElement.eResource().getResourceSet());

//		this.commandStack = editingDomain.getCommandStack();
//		// Add a listener to set the editor dirty of commands have been executed
//		editingDomain.getCommandStack().execute(
//				new RecordingCommand(editingDomain) {
//
//					@Override
//					protected void doExecute() {
//						editingDomain.getCommandStack()
//								.addCommandStackListener(
//										new CommandStackListener() {
//
//											public void commandStackChanged(
//													EventObject event) {
//												//JH: Fix Hack
//												if (!checkingDirty) {
//													editorDirtyStateChanged();
//												}
//											}
//										});
//
//					}
//
//				});

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDirty() {
		//we do always save immediately so we are never dirty
		return false;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {

		super.setFocus();
		form.setFocus();

	}
	
	


}
