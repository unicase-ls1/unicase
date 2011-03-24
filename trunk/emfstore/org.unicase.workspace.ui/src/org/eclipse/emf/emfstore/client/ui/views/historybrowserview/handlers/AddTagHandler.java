/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.eclipse.emf.emfstore.client.ui.views.historybrowserview.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.emfstore.client.model.ProjectSpace;
import org.eclipse.emf.emfstore.client.ui.commands.ServerRequestCommandHandler;
import org.eclipse.emf.emfstore.client.ui.views.historybrowserview.HistoryBrowserView;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.TreeNode;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.metamodel.util.ModelUtil;
import org.unicase.ui.util.DialogHandler;

/**
 * Handler for adding a new tag.
 * 
 * @author Shterev
 */
public class AddTagHandler extends AbstractHistoryViewHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object run(ExecutionEvent event, HistoryBrowserView view, TreeNode node) {
		HistoryInfo historyInfo = (HistoryInfo) node.getValue();
		PrimaryVersionSpec versionSpec = ModelUtil.clone(historyInfo.getPrimerySpec());

		InputDialog inputDialog = new InputDialog(view.getSite().getShell(), "Add tag", "Please enter the tag's name.",
			"", null);
		inputDialog.open();
		String str = inputDialog.getValue().trim();
		if (!(str == null || str.equals(""))) {
			TagVersionSpec tag = VersioningFactory.eINSTANCE.createTagVersionSpec();
			tag.setName(str);
			addTag(view.getProjectSpace(), versionSpec, tag);
			view.refresh();
		}
		return null;
	}

	/**
	 * Adds a tag to a version.
	 * 
	 * @param versionSpec the version
	 * @param tag the tag
	 */
	private void addTag(final ProjectSpace projectSpace, final PrimaryVersionSpec versionSpec, final TagVersionSpec tag) {

		ServerRequestCommandHandler handler = new ServerRequestCommandHandler() {

			@Override
			protected Object run() throws EmfStoreException {
				projectSpace.addTag(versionSpec, tag);
				return null;
			}

			@Override
			public String getTaskTitle() {
				return "Resolving project versions...";
			}
		};
		try {
			handler.execute(new ExecutionEvent());
		} catch (ExecutionException e) {
			DialogHandler.showErrorDialog(e.getMessage());
		}
	}
}