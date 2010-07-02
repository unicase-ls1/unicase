/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor;

import java.util.Date;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.URLEvent;
import org.unicase.metamodel.ModelElementId;
import org.unicase.metamodel.Project;
import org.unicase.metamodel.util.ModelElementChangeObserver;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.model.attachment.UrlAttachment;
import org.unicase.ui.meeditor.Activator;
import org.unicase.ui.meeditor.mecontrols.AbstractMEControl;
import org.unicase.ui.unicasecommon.meeditor.mecontrols.AbstractUnicaseMEControl;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.UnicaseCommand;

/**
 * GUI Control for URL hyperlinks.
 * 
 * @author helming
 * @author shterev
 * @author nagel
 */
public class MEURLControl extends AbstractUnicaseMEControl {
	private static final int PRIORITY = 2;

	/**
	 * Recording command to edit a URL.
	 * 
	 * @author helming
	 * @author nagel
	 */
	private final class SetURLCommand extends RecordingCommand {
		private final String newURL;
		private final UrlAttachment urlAttachment;

		public SetURLCommand(TransactionalEditingDomain domain, String newURL, UrlAttachment urlAttachment) {
			super(domain);
			this.newURL = newURL;
			this.urlAttachment = urlAttachment;
		}

		@Override
		protected void doExecute() {
			urlAttachment.setUrl(newURL);
		}
	}

	private Composite linkComposite;
	private Hyperlink hyperlink;
	private ModelElementChangeObserver observer;
	private UrlAttachment urlattachement;

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.meeditor.mecontrols.MEControl#createControl(org.eclipse.swt.widgets.Composite, int)
	 */
	@Override
	public Control createControl(final Composite parent, int style) {
		linkComposite = getToolkit().createComposite(parent, style);
		linkComposite.setLayout(new GridLayout(2, false));
		this.urlattachement = (UrlAttachment) getModelElement();
		observer = new ModelElementChangeObserver() {

			@Override
			protected void onNotify(Notification notification, EObject element) {
				Display.getDefault().asyncExec(new Runnable() {

					public void run() {
						if (!hyperlink.isDisposed()) {
							String url = urlattachement.getUrl();
							if (url == null) {
								url = "";
							}
							hyperlink.setText(url);
							linkComposite.layout(true);
							parent.getParent().layout(true);
						}
					}
				});
			}

			@Override
			protected void onElementDeleted(EObject element) {
				// nothing to do
			}
		};

		ModelUtil.getProject(getModelElement()).addProjectChangeObserver(observer);
		observer.observeElement(getModelElement());

		String url = urlattachement.getUrl();
		if (url == null) {
			url = "";
		}
		hyperlink = getToolkit().createHyperlink(linkComposite, url, style);
		hyperlink.addHyperlinkListener(new HyperlinkAdapter() {
			@Override
			public void linkActivated(HyperlinkEvent event) {
				String url = urlattachement.getUrl();
				if (url == null) {
					return;
				}
				boolean isLaunched = Program.launch(url);
				if (!isLaunched) {
					MessageBox box = new MessageBox(parent.getShell(), SWT.OK | SWT.ICON_ERROR);
					box.setText("Invalid URL");
					box.setMessage(url + " is not a valid URL, browser couldn't be started!");
					box.open();
				}
				EObject modelElement = getModelElement();
				ModelElementId modelElementId = ModelUtil.getProject(modelElement).getModelElementId(modelElement);
				logEvent(modelElementId, modelElementId, WorkspaceManager.getProjectSpace(modelElement),
					"org.unicase.ui.meeditor");
				super.linkActivated(event);

			}
		});

		final Action editURL = new Action("Edit URL", SWT.PUSH) {

			@Override
			public void run() {
				InputDialog input = new InputDialog(parent.getShell(), "Edit URL", "Please enter the URL",
					urlattachement.getUrl(), new URLValidator());
				input.setBlockOnOpen(true);
				int result = input.open();
				if (result == InputDialog.OK) {
					TransactionalEditingDomain domain = Configuration.getEditingDomain();
					domain.getCommandStack().execute(new SetURLCommand(domain, input.getValue(), urlattachement));
				}
			}

		};
		Button button = new Button(linkComposite, SWT.PUSH);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				editURL.run();
			}

		});
		button.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
		button.setImage(Activator.getImageDescriptor("icons/link.png").createImage());

		return linkComposite;
	}

	/**
	 * Logs an URLEvent.
	 * 
	 * @param sourceModelElementId The ID where the widgte was clicked
	 * @param urlID The ID of the URL
	 * @param projectSpace The project space to log the event
	 * @param source The source view
	 */
	public static void logEvent(ModelElementId sourceModelElementId, ModelElementId urlID,
		final ProjectSpace projectSpace, String source) {
		final URLEvent urlEvent = EventsFactory.eINSTANCE.createURLEvent();
		urlEvent.setSourceModelElement(sourceModelElementId);
		urlEvent.setSourceURL(urlID);
		urlEvent.setTimestamp(new Date());
		urlEvent.setSourceView(source);
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				projectSpace.addEvent(urlEvent);
			}
		}.run();

	}

	/**
	 * Disposes the Composite of this {@link MEURLControl}.
	 */
	@Override
	public void dispose() {
		if (getModelElement() != null) {
			Project project = ModelUtil.getProject(getModelElement());
			if (project != null) {
				project.removeProjectChangeObserver(observer);
			}
		}
		if (linkComposite != null) {
			linkComposite.dispose();
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.unicase.ui.meeditor.mecontrols.AbstractMEControl#canRender(org.eclipse.emf.edit.provider.IItemPropertyDescriptor,
	 *      org.unicase.metamodel.ModelElement)
	 */
	@Override
	public int canRender(IItemPropertyDescriptor itemPropertyDescriptor, EObject modelElement) {
		Object feature = itemPropertyDescriptor.getFeature(modelElement);
		if (modelElement instanceof UrlAttachment && feature instanceof EAttribute) {
			if (((EAttribute) feature).getName().equalsIgnoreCase("url")) {
				return PRIORITY;
			}
		}
		return AbstractMEControl.DO_NOT_RENDER;
	}

	/**
	 * Validator class for validating the input of URL Input-Dialog.
	 * 
	 * @author mkagel
	 */
	private class URLValidator implements IInputValidator {

		public String isValid(String newText) {

			if (newText.matches("(((https?|ftp)://)?(www\\.)?(\\w+\\.)?\\w+){1}(/.*)*")) {
				return null;
			} else {
				return "Invalid URL!";
			}
		}
	}
}
