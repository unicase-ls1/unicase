/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.meeditor;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	private int titleLimit = 25;

	private ModelElement modelElement;
	private ComposedAdapterFactory adapterFactory;
	private TransactionalEditingDomain editingDomain;
	private MEEditorPage form;

	private Adapter eAdapter;

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
			// JH Auto-generated catch block
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
			final MEEditorInput meInput = (MEEditorInput) input;
			setPartName(getLimitedTitle(input.getName()));
			setTitleImage(input.getImageDescriptor().createImage());

			modelElement = meInput.getModelElement();
			initializeEditingDomain();
			eAdapter = new AdapterImpl() {
				@Override
				public void notifyChanged(Notification msg) {
					if (msg.getFeature() instanceof EAttribute && ((EAttribute)msg.getFeature()).getName().equals("name")) {
						setPartName(getLimitedTitle(msg.getNewStringValue()));
						if(form!=null){
							form.getManagedForm().getForm().setText(msg.getNewStringValue());
						}
					}
					
				}
				
			};			
			this.modelElement.eAdapters().add(eAdapter);
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
			SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss"); 
			StringBuffer stringBuffer = new StringBuffer();
			Date creationDate = modelElement.getCreationDate();
			if(creationDate==null){
				TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						modelElement.setCreator("unicase");
						modelElement.setCreationDate(new Date());
					}
				});
			}
			creationDate = modelElement.getCreationDate();
			stringBuffer.append("Created on ");
			stringBuffer.append(dateFormat.format(creationDate));
			stringBuffer.append(" at ");
			stringBuffer.append(timeFormat.format(creationDate));
			stringBuffer.append(" by ");
			stringBuffer.append(modelElement.getCreator());
			getEditorSite().getActionBars().getStatusLineManager().setMessage(stringBuffer.toString());
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
	
	private String getLimitedTitle(String name){
		if(name.length()>titleLimit){
			name=name.substring(0, titleLimit).concat("...");
		}
		return name;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose(){
		modelElement.eAdapters().remove(eAdapter);
		super.dispose();
	}
}
