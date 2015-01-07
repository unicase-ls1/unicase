/**
 * <copyright> Copyright (c) 2009-2012 Chair of Applied Software Engineering, Technische Universit�t M�nchen (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.unicasecommon.meeditor;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.emfstore.internal.client.model.util.EMFStoreCommand;
import org.eclipse.emf.emfstore.internal.common.model.IdEObjectCollection;
import org.eclipse.emf.emfstore.internal.common.model.util.ModelUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.unicase.model.attachment.UrlAttachment;
import org.unicase.ui.unicasecommon.Activator;
import org.unicase.ui.unicasecommon.meeditor.mecontrols.AbstractUnicaseMEControl;

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
	private final class SetURLCommand extends EMFStoreCommand {
		private final String newURL;
		private final UrlAttachment urlAttachment;

		public SetURLCommand(String newURL, UrlAttachment urlAttachment) {
			super();
			this.newURL = newURL;
			this.urlAttachment = urlAttachment;
		}

		@Override
		protected void doRun() {
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
			}

			public void notify(Notification notification, IdEObjectCollection collection, EObject modelElement) {
			}

			public void modelElementAdded(IdEObjectCollection collection, EObject modelElement) {
			}

			public void modelElementRemoved(IdEObjectCollection collection, EObject modelElement) {
			}
		};

		ModelUtil.getProject(getModelElement()).addIdEObjectCollectionChangeObserver(observer);
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
				boolean isLaunched = ExtProgramFactoryFacade.launchURL(url);
				if (!isLaunched) {
					MessageBox box = new MessageBox(parent.getShell(), SWT.OK | SWT.ICON_ERROR);
					box.setText("Invalid URL");
					box.setMessage(url + " is not a valid URL, browser couldn't be started!");
					box.open();
				}
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
					new SetURLCommand(input.getValue(), urlattachement).run(true);
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
	 * Disposes the Composite of this {@link MEURLControl}.
	 */
	@Override
	public void dispose() {
		if (getModelElement() != null) {
			Project project = ModelUtil.getProject(getModelElement());
			if (project != null) {
				project.removeIdEObjectCollectionChangeObserver(observer);
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
			if (newText.matches("(((https?|ftp)://)?(www\\.)?(\\w+\\.){1,}+\\w+){1}(/.*)*")) {
				return null;
			} else {
				return "Invalid URL!";
			}
		}
	}
}
