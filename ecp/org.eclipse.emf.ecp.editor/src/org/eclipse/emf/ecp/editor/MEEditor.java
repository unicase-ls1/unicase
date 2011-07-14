/*******************************************************************************
 * Copyright (c) 2008-2011 Chair for Applied Software Engineering, Technische Universitaet Muenchen. All rights
 * reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public
 * License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 ******************************************************************************/
package org.eclipse.emf.ecp.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecp.common.model.ECPModelelementContext;
import org.eclipse.emf.ecp.common.model.ModelElementContextListener;
import org.eclipse.emf.ecp.common.utilities.ShortLabelProvider;
import org.eclipse.emf.edit.domain.EditingDomain;
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
	public static final String ID = "org.eclipse.emf.ecp.editor";

	private EObject modelElement;
	private EditingDomain editingDomain;
	private MEEditorPage mePage;

	private ILabelProviderListener labelProviderListener;

	private StatusMessageProvider statusMessageProvider;

	private ModelElementChangeListener modelElementChangeListener;

	private ECPModelelementContext modelElementContext;

	private ModelElementContextListener modelElementContextListener;

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
		String editorID = "Edit";
		String editorDesc = "Standard View";
		MEEditorInput editorInput = (MEEditorInput) getEditorInput();

		// add pages from the extension point
		IConfigurationElement[] configTemp = Platform.getExtensionRegistry().getConfigurationElementsFor(
			"org.eclipse.emf.ecp.editor.pages");
		IConfigurationElement[] configIn = null;

		boolean replaceMEEditor = false;
		int counter = 0;

		for (int i = 0; i < configTemp.length; i++) {
			if (configTemp[i].getAttribute("replace") != null && configTemp[i].getAttribute("replace").equals(editorID)) {
				// if a replacement is found, create this page, so it becomes the first one
				replaceMEEditor = true;
				AbstractMEEditorPage newPage;

				try {
					newPage = (AbstractMEEditorPage) configTemp[i].createExecutableExtension("class");
					FormPage createPage = newPage.createPage(this, editingDomain, modelElement);
					if (createPage != null) {
						addPage(createPage);
					}
				} catch (CoreException e1) {
					Activator.logException(e1);
				}

				// put remaining pages into the original configIn array
				configIn = new IConfigurationElement[configTemp.length - 1];
				for (int j = 0, k = 0; j < configTemp.length - 1; j++, k++) {
					if (counter == j) {
						j--;
					} else {
						configIn[j] = configTemp[k];
					}
				}

				break;
			}
			counter++;
		}

		// create original MEEditor standard view if no replacement exists
		// and put remaining pages into the original configIn array
		if (!replaceMEEditor) {
			try {
				if (editorInput.getProblemFeature() != null) {
					mePage = new MEEditorPage(this, editorID, editorDesc, modelElementContext, modelElement,
						editorInput.getProblemFeature());
				} else {
					mePage = new MEEditorPage(this, editorID, editorDesc, modelElementContext, modelElement);
				}

				addPage(mePage);
				configIn = configTemp;
			} catch (PartInitException e) {
				// JH Auto-generated catch block
				Activator.logException(e);
			}
		}

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
				Activator.logException(e1);
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
			modelElementContext = meInput.getModelElementContext();
			initializeEditingDomain();

			modelElementContextListener = new ModelElementContextListener() {

				@Override
				public void onModelElementDeleted(EObject deleted) {
					if (modelElement == deleted) {
						close(false);
					} else {
						if (!modelElementContext.contains(modelElement)) {
							close(false);
						}
					}

				}

				@Override
				public void onContextDeleted() {
					onModelElementDeleted(modelElement);

				}
			};
			modelElementContext.addModelElementContextListener(modelElementContextListener);
			modelElementChangeListener = new ModelElementChangeListener(modelElement) {

				@Override
				public void onChange(Notification notification) {
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
			};

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
			"org.eclipse.emf.ecp.editor.statusmessage");
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
				Activator.logException(e1);
			}
		}
	}

	private void updateCreatorHint() {
		if (statusMessageProvider != null) {
			getEditorSite().getActionBars().getStatusLineManager()
				.setMessage(statusMessageProvider.getMessage(modelElement));
		}
	}

	/**
	 * Initializes the editing domain for this model element.
	 */
	protected void initializeEditingDomain() {
		this.editingDomain = modelElementContext.getEditingDomain();
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
		if (mePage != null) {
			mePage.setFocus();
		}
		updateCreatorHint();

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		modelElementChangeListener.remove();
		modelElementContext.removeModelElementContextListener(modelElementContextListener);
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
				// Catch in case Editor is directly closed after change.
			}
		}
	}

	public ECPModelelementContext getModelElementContext() {
		return modelElementContext;
	}
}
