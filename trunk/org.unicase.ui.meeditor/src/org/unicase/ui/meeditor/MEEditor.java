package org.unicase.ui.meeditor;

import java.util.EventObject;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.ui.provider.TransactionalAdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.editor.SharedHeaderFormEditor;
import org.unicase.model.ModelElement;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;


public class MEEditor extends SharedHeaderFormEditor {

	ModelElement modelElement;
	ComposedAdapterFactory adapterFactory;
	TransactionalEditingDomain editingDomain;
	ILabelProvider labelProvider;
	CommandStack commandStack;
	ControlFactory controlFactory;
	private boolean dirty = false;

	public MEEditor() {
//		initializeEditingDomain();
	}

	@Override
	protected void addPages() {

		FormPage form = new MEEditorPage(this, "1", "Standard View",
				editingDomain, modelElement);
		try {
			addPage(form);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		
		monitor.beginTask("Saving...", 1);
		editingDomain.getCommandStack().execute(new RecordingCommand(editingDomain){

			@Override
			protected void doExecute() {
				WorkspaceManager.getInstance().getCurrentWorkspace().save();
				
			}
			
		});
		
		commandStack.flush();
		editorDirtyStateChanged();
		monitor.done();
		dirty=false;
	}

	@Override
	public void doSaveAs() {
	}

	/**
	 * Is save is not allowed as the editor can only modify model elements
	 */
	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

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
			// AS: confirm that the method should be placed here.
			initializeEditingDomain();
		} else {
			throw new PartInitException(
					"MEEditor is only appliable for MEEditorInputs");
		}
	}

	protected void initializeEditingDomain() {
		this.adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		adapterFactory.addAdapterFactory(new ModelItemProviderAdapterFactory());
		this.adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		this.adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		// command stack that will notify this editor as commands are executed
		this.editingDomain = TransactionalEditingDomain.Factory.INSTANCE.getEditingDomain(modelElement.eResource().getResourceSet());

		this.commandStack=editingDomain.getCommandStack();
		// Add a listener to set the editor dirty of commands have been executed
//		editingDomain.getCommandStack().addCommandStackListener(new CommandStackListener() {
//			public void commandStackChanged(final EventObject event) {
//				getContainer().getDisplay().asyncExec(new Runnable() {
//					public void run() {
//						dirty = true;
//						editorDirtyStateChanged();
//					}
//				});
//			}
//		});

		// Create the editing domain with our adapterFactory and command stack.
		
		// These provide access to the model items, their property source and
		// label
		this.labelProvider = new TransactionalAdapterFactoryLabelProvider(editingDomain,adapterFactory);

	}

	@Override
	public boolean isDirty() {
		return dirty;
	}

}
