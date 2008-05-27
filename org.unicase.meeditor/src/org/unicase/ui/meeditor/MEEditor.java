package org.unicase.ui.meeditor;

import java.util.EventObject;
import java.util.HashMap;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.command.CommandStackListener;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.editor.SharedHeaderFormEditor;
import org.unicase.model.ModelElement;
import org.unicase.model.provider.ModelItemProviderAdapterFactory;


public class MEEditor extends SharedHeaderFormEditor {

	ModelElement modelElement;
	ComposedAdapterFactory adapterFactory;
	EditingDomain editingDomain;
	ILabelProvider labelProvider;
	BasicCommandStack commandStack;
	ControlFactory controlFactory;

	public MEEditor() {
		initializeEditingDomain();
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
		if (pages == null) {
			return;
		}
		monitor.beginTask("Saving...", 1);
		for (Object page : pages) {
			if (page != null) {
				FormPage formPage = (FormPage) page;
				if (formPage.isDirty()) {
					formPage.doSave(monitor);
				}
			}
		}
		editorDirtyStateChanged();
		monitor.done();
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
		commandStack = new BasicCommandStack();

		// Add a listener to set the editor dirty of commands have been executed
		commandStack.addCommandStackListener(new CommandStackListener() {
			public void commandStackChanged(final EventObject event) {
				getContainer().getDisplay().asyncExec(new Runnable() {
					public void run() {
						editorDirtyStateChanged();
					}
				});
			}
		});

		// Create the editing domain with our adapterFactory and command stack.
		this.editingDomain = new AdapterFactoryEditingDomain(adapterFactory,
				commandStack, new HashMap<Resource, Boolean>());
		// These provide access to the model items, their property source and
		// label
		this.labelProvider = new AdapterFactoryLabelProvider(adapterFactory);

	}

	@Override
	public boolean isDirty() {
		if (pages == null) {
			return false;
		}
		for (Object page : pages) {
			if (page != null) {
				FormPage formPage = (FormPage) page;
				if (formPage.isDirty()) {
					return true;
				}
			}
		}
		return false;
	}

}
