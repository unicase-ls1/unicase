/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.util;

import java.net.MalformedURLException;
import java.util.Date;
import java.util.HashMap;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.emfstore.esmodel.url.ModelElementUrlFragment;
import org.unicase.emfstore.esmodel.url.UrlFactory;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.ReadEvent;
import org.unicase.metamodel.ModelElementId;
import org.unicase.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.exceptions.MEUrlResolutionException;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * A singleton selection listener that resolves unicase URLs and opens the element in a MEEditor.
 * 
 * @author Shterev
 */
public final class URLSelectionListener implements SelectionListener {

	private ProjectSpace projectSpace;
	private static HashMap<ProjectSpace, URLSelectionListener> map = new HashMap<ProjectSpace, URLSelectionListener>();

	/**
	 * Default constructor.
	 * 
	 * @param projectSpace the project space needed for resolving the urls.
	 */
	private URLSelectionListener(ProjectSpace projectSpace) {
		super();
		this.projectSpace = projectSpace;
	}

	/**
	 * {@inheritDoc}
	 */
	public void widgetDefaultSelected(SelectionEvent e) {
		//

	}

	/**
	 * {@inheritDoc}
	 */
	public void widgetSelected(SelectionEvent e) {
		String text = e.text;
		try {
			ModelElementUrl modelElementUrl = UrlFactory.eINSTANCE.createModelElementUrl(text);
			EObject modelElement = null;
			ModelElementUrlFragment modelElementUrlFragment = modelElementUrl.getModelElementUrlFragment();
			try {
				modelElement = projectSpace.resolve(modelElementUrlFragment);
			} catch (MEUrlResolutionException e1) {
			}
			ActionHelper.openModelElement(modelElement, e.getSource().getClass().getName());
			logEvent(modelElementUrlFragment.getModelElementId(), e.getSource().getClass().getName());
		} catch (MalformedURLException ex) {
			WorkspaceUtil.logException("Invalid unicase URL pattern", ex);
		}

	}

	private void logEvent(ModelElementId modelElementId, String source) {
		final ReadEvent readEvent = EventsFactory.eINSTANCE.createReadEvent();
		readEvent.setModelElement(modelElementId);
		readEvent.setReadView("org.unicase.ui.meeditor");
		readEvent.setSourceView(source);
		readEvent.setTimestamp(new Date());
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				projectSpace.addEvent(readEvent);
			}
		}.run();
	}

	/**
	 * Gets the singleton instance for this project space.
	 * 
	 * @param projectSpace the project space.
	 * @return the singleton instance.
	 */
	public static URLSelectionListener getInstance(ProjectSpace projectSpace) {
		URLSelectionListener instance = map.get(projectSpace);
		if (instance == null) {
			instance = new URLSelectionListener(projectSpace);
			map.put(projectSpace, instance);
		}
		return instance;
	}

}
