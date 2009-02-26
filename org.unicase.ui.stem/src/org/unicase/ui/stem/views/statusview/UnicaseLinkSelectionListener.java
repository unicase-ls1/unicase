/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.ui.stem.views.statusview;

import java.net.MalformedURLException;
import java.util.Date;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.unicase.emfstore.esmodel.url.ModelElementUrl;
import org.unicase.emfstore.esmodel.url.ModelElementUrlFragment;
import org.unicase.emfstore.esmodel.url.UrlFactory;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.ReadEvent;
import org.unicase.model.ModelElement;
import org.unicase.model.ModelElementId;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.edit.dashboard.DashboardEditor;
import org.unicase.workspace.exceptions.MEUrlResolutionException;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * @author Shterev
 */
public class UnicaseLinkSelectionListener implements SelectionListener {

	private ProjectSpace projectSpace;

	/**
	 * Default constructor.
	 * 
	 * @param projectSpace the project space needed for resolving the urls.
	 */
	public UnicaseLinkSelectionListener(ProjectSpace projectSpace) {
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
			ModelElement modelElement = null;
			ModelElementUrlFragment modelElementUrlFragment = modelElementUrl.getModelElementUrlFragment();
			try {
				modelElement = projectSpace.resolve(modelElementUrlFragment);
			} catch (MEUrlResolutionException e1) {
			}
			ActionHelper.openModelElement(modelElement, DashboardEditor.ID);
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
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				projectSpace.addEvent(readEvent);
			}
		});
	}

}
