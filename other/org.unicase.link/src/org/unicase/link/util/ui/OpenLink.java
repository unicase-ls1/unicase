/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.link.util.ui;

import java.net.MalformedURLException;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.emfstore.esmodel.url.ModelElementUrlFragment;
import org.unicase.emfstore.esmodel.url.impl.UrlFactoryImpl;
import org.unicase.link.util.ProjectFacade;
import org.unicase.metamodel.ModelElement;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Utility class for opening model elements. Also acts as a listener for JUnique messages changes, which provide us with
 * UNICASE URLs of model elements to be opened.
 * 
 * @author svetlana, emueller
 */
public class OpenLink implements Observer {

	private static final String EXTERNAL_URL = "EXTERNAL_URL";

	private static OpenLink instance;

	/**
	 * Gets the instance.
	 * 
	 * @return An instance of the OpenLink class.
	 */
	public static OpenLink getInstance() {
		if (instance == null) {
			instance = new OpenLink();
		}
		return instance;
	}

	/**
	 * Given a project space and an URL of a model element, opens the MEEditor in order to display the model with the
	 * given URL.
	 * 
	 * @param projectSpace the project space the model element with the given URL is assumed to be
	 * @param modelElementUrl the URL of the model element to be opened
	 */
	public static void openME(ProjectSpace projectSpace, ModelElementUrlFragment modelElementUrl) {

		final ModelElement me = projectSpace.getProject().getModelElement(modelElementUrl.getModelElementId());

		if (me != null) {
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					ActionHelper.openModelElement(me, EXTERNAL_URL);
					if (Display.getDefault().getShells().length > 0) {
						// force focus
						Display.getDefault().getShells()[0].forceActive();
						Display.getDefault().getShells()[0].forceFocus();
					}
				}
			});
		}
	}

	/**
	 * Opens the model element with the specified URL in the MEEditor view. If the passed URL is invalid a MessageBox
	 * will be shown to the user informing him about the invalid URL.
	 * 
	 * @param url The ModelElementUrl of the model element to be opened.
	 */
	public static void openURL(ModelElementUrl url) {
		ProjectSpace projectSpace = null;

		projectSpace = ProjectFacade.getInstance().getLatestProjectSpace(url);

		if (projectSpace != null) {
			OpenLink.openME(projectSpace, url.getModelElementUrlFragment());
		}
	}

	/**
	 * Opens the model element with the specified URL in the MEEditor view. If the passed URL is invalid a MessageBox
	 * will be shown to the user informing him about the invalid URL.
	 * 
	 * @param url The UNICASE URL of the model element to be opened.
	 */
	public static void openURL(String url) {
		try {
			ModelElementUrl modElmUrl = UrlFactoryImpl.eINSTANCE.createModelElementUrl(url);
			openURL(modElmUrl);
		} catch (final MalformedURLException e) {
			// invalid URL has been passed, inform user
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					MessageDialog.openError(Display.getDefault().getActiveShell(), "Malformed URL",
						"The UNICASE URL you tried to open is not valid.\n" + e.getMessage());
				}
			});
		}
	}

	/**
	 * Callback method for the JUnique library.
	 * 
	 * @param o the observable
	 * @param arg the model element URL to be opened
	 */
	public void update(Observable o, Object arg) {
		try {
			String url = (String) arg;
			openURL(url);
		} catch (ClassCastException e) {
			WorkspaceUtil.logException(arg.getClass().getCanonicalName()
				+ " received where model element URL expected.", e);
		}
	}
}
