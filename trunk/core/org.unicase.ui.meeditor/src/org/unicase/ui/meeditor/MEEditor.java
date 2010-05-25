/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.meeditor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.editor.SharedHeaderFormEditor;
import org.unicase.metamodel.ModelElement;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelElementChangeObserver;
import org.unicase.ui.common.util.ShortLabelProvider;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * GUI view for editing MEs.
 * 
 * @author helming
 * @author naughton
 */
public class MEEditor extends SharedHeaderFormEditor {

	/**
	 * The Id for MEEditor. We need this to open a model element.
	 */
	public static final String ID = "org.unicase.ui.meeditor";

	private ModelElement modelElement;
	private TransactionalEditingDomain editingDomain;
	private MEEditorPage mePage;

	private ILabelProviderListener labelProviderListener;

	private ModelElementChangeObserver modelelementChangeObserver;

	private Project project;

	private StatusMessageProvider statusMessageProvider;

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
		MEEditorInput editorInput = (MEEditorInput) getEditorInput();
		if (editorInput.getProblemFeature() != null) {
			mePage = new MEEditorPage(this, "Edit", "Standard View", editingDomain, modelElement, editorInput
				.getProblemFeature());
		} else {
			mePage = new MEEditorPage(this, "Edit", "Standard View", editingDomain, modelElement);
		}

		try {
			addPage(mePage);
		} catch (PartInitException e) {
			// JH Auto-generated catch block
			WorkspaceUtil.logException(e.getMessage(), e);
		}

		// Add the pages from the extension point
		IConfigurationElement[] configIn = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.meeditor.pages");

		// Sort the pages by the "after" attribute and omit replaced pages
		List<IConfigurationElement> config = PageCandidate.getPages(configIn);
		for (IConfigurationElement e : config) {

			try {
				AbstractMEEditorPage newPage = (AbstractMEEditorPage) e.createExecutableExtension("class");
				FormPage createPage = newPage.createPage(this, editingDomain, modelElement);
				if (createPage != null) {
					addPage(createPage);
				}
			} catch (CoreException e1) {
				WorkspaceUtil.logException("Unable to create a page for MEEditor", e1);
			}
		}
		// commentsPage = new METhreadPage(this, "Discussion", "Discussion", editingDomain, modelElement);
		// descriptionPage = new MEDescriptionPage(this, "Description", "Description", editingDomain, modelElement);
		// addPage(descriptionPage);
		// addPage(commentsPage);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void doSave(IProgressMonitor monitor) {
		// do nothing (Jonas said so)
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
	public void init(IEditorSite site, final IEditorInput input) throws PartInitException {
		super.init(site, input);
		if (input instanceof MEEditorInput) {
			setInput(input);
			final MEEditorInput meInput = (MEEditorInput) input;
			modelElement = meInput.getModelElement();
			setPartName((new ShortLabelProvider()).getText(modelElement));
			setTitleImage(input.getImageDescriptor().createImage());

			initializeEditingDomain();
			project = modelElement.getProject();
			modelelementChangeObserver = new ModelElementChangeObserver() {

				@Override
				protected void onNotify(Notification notification, ModelElement element) {

					Display.getDefault().asyncExec(new Runnable() {
						public void run() {
							updateIcon(input);
							setPartName((new ShortLabelProvider()).getText(modelElement));
							if (mePage != null) {
								mePage.updateSectionTitle();
							}

						}
					});

				}

				@Override
				protected void onElementDeleted(ModelElement element) {
					if (element == modelElement) {
						close(false);
						project.removeProjectChangeObserver(modelelementChangeObserver);
					}

				}
			};
			modelelementChangeObserver.observeElement(modelElement);
			this.modelElement.getProject().addProjectChangeObserver(modelelementChangeObserver);
			initStatusProvider();
			updateCreatorHint();

			labelProviderListener = new ILabelProviderListener() {
				public void labelProviderChanged(LabelProviderChangedEvent event) {
					updateIcon(meInput);
				}
			};
			meInput.getLabelProvider().addListener(labelProviderListener);

		} else {
			throw new PartInitException("MEEditor is only appliable for MEEditorInputs");
		}
	}

	private void initStatusProvider() {
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.unicase.ui.meeditor.statusmessage");
		ArrayList<IConfigurationElement> provider = new ArrayList<IConfigurationElement>();
		provider.addAll(Arrays.asList(configurationElements));
		int priority = 0;
		for (IConfigurationElement e : provider) {
			try {
				StatusMessageProvider statusMessageProvider = (StatusMessageProvider) e
					.createExecutableExtension("class");
				int newpriority = statusMessageProvider.canRender(modelElement);
				if (newpriority > priority) {
					priority = newpriority;
					this.statusMessageProvider = statusMessageProvider;
				}
			} catch (CoreException e1) {
				WorkspaceUtil.logException(e1.getMessage(), e1);
			}
		}
	}

	private void updateCreatorHint() {
		if (statusMessageProvider != null) {
			getEditorSite().getActionBars().getStatusLineManager().setMessage(
				statusMessageProvider.getMessage(modelElement));
		}
	}

	/**
	 * Initializes the editing domain for this model element.
	 */
	protected void initializeEditingDomain() {

		this.editingDomain = Configuration.getEditingDomain();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isDirty() {
		// we do always save immediately so we are never dirty
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {

		super.setFocus();
		mePage.setFocus();
		updateCreatorHint();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		if (modelElement != null && modelElement.getProject() != null) {
			modelElement.getProject().removeProjectChangeObserver(modelelementChangeObserver);
		}

		((MEEditorInput) getEditorInput()).getLabelProvider().removeListener(labelProviderListener);
		super.dispose();
	}

	private void updateIcon(IEditorInput input) {
		Image titleImage = input.getImageDescriptor().createImage();
		setTitleImage(titleImage);
		// TODO AS: Debug why sometimes the page is null - not disposed Adapter?
		if (mePage != null) {
			try {
				mePage.getManagedForm().getForm().setImage(titleImage);
			} catch (SWTException e) {
				// Catch in case Editor is directly closed after Change.
			}
		}
	}

}
