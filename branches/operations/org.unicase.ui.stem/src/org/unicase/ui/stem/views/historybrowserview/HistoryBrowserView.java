/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.stem.views.historybrowserview;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.stem.views.AbstractSCMView;
import org.unicase.ui.stem.views.Query;
import org.unicase.ui.stem.views.Query.QueryRangeType;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;

/**
 * . This the History Browser view. It inherits AbstractSCMView and hence has a
 * query tab, where the user can set criteria for view's content. It also has a
 * browser tab (a HistoryComposite).
 * 
 * @author Hodaie
 * @author wesendonk
 * 
 */
public class HistoryBrowserView extends AbstractSCMView {

	// temporarily used to show dialogs.
	private Composite parent;

	private List<HistoryInfo> historyInfos;

	private HistoryComposite historyComposite;

	/**
	 * . Constructor
	 */
	public HistoryBrowserView() {
		historyInfos = new ArrayList<HistoryInfo>();
	}

	private void reload() {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			protected void doExecute() {
				ProjectSpace activeProjectSpace = WorkspaceManager
						.getInstance().getCurrentWorkspace()
						.getActiveProjectSpace();
				if (activeProjectSpace == null) {
					DialogHandler.showErrorDialog("No active project chosen.");
					historyInfos.clear();
					return;
				}
				if (activeProjectSpace.getUsersession() == null || !activeProjectSpace.getUsersession().isLoggedIn()) {
					DialogHandler.showErrorDialog("Chosen Project is not logged in.");
					historyInfos.clear();
					return;
				}
				try {
					List<HistoryInfo> historyInfo = activeProjectSpace
							.getUsersession().getHistoryInfo(
									activeProjectSpace.getProjectId(),
									getQuery(activeProjectSpace));
					if (historyInfo != null) {
						for(HistoryInfo hi : historyInfo) {
							if(hi.getPrimerySpec().equals(activeProjectSpace.getBaseVersion())) {
								TagVersionSpec spec = VersioningFactory.eINSTANCE.createTagVersionSpec();
								spec.setName("BASE");
								hi.getTagSpecs().add(spec);
								break;
							}
						}
						historyInfos.clear();
						historyInfos.addAll(historyInfo);
					}
				} catch (EmfStoreException e) {
					DialogHandler.showExceptionDialog(e);
				}
			}
		});
	}

	private HistoryQuery getQuery(ProjectSpace activeProjectSpace)
			throws EmfStoreException {
		System.out.println("getQuery");
		HistoryQuery query = VersioningFactory.eINSTANCE.createHistoryQuery();

		int start = 0;
		int end = 0;

		Query qury = queryComposite.getQuery();
		if (qury.getQueryRangeType().equals(QueryRangeType.VERSION)
				&& qury.getStartVersion() != -1 && qury.getEndVersion() != -1) {
			start = qury.getStartVersion();
			end = qury.getEndVersion();
		} else {
			// if query not set default query 0 to HEAD
			PrimaryVersionSpec resolveVersionSpec = activeProjectSpace
					.resolveVersionSpec(VersionSpec.HEAD_VERSION);
			start = 0;
			end = resolveVersionSpec.getIdentifier();
		}

		PrimaryVersionSpec source = VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec();
		source.setIdentifier(start);
		PrimaryVersionSpec target = VersioningFactory.eINSTANCE
				.createPrimaryVersionSpec();
		target.setIdentifier(end);
		query.setSource(source);
		query.setTarget(target);

		System.out.println(start + " " + end);

		return query;
	}

	/**
	 * Returns a list of history infos.
	 * 
	 * @return a list of history infos
	 */
	public List<HistoryInfo> getHistoryInfos() {
		return historyInfos;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		browserTab.setText("History");
		this.parent = parent;
	}

	/**
	 * . {@inheritDoc}
	 */
	@Override
	public void setFocus() {

	}

	/**
	 * . TODO final implementation
	 */
	@Override
	protected void refreshClicked() {
		reload();
		historyComposite.updateTable();
		// lblCriteria.setText(queryComposite.getQuery().getDescription());

		// ************************************************
		// //these were just used to show different dialogs.
		// //because i did not know how should the dialogs be shown.
		// CommitDialog commitDialog = new CommitDialog(parent.getShell());
		// commitDialog.create();
		// commitDialog.open();

		// UpdateDialog updateDialog = new UpdateDialog(parent.getShell());
		// updateDialog.create();
		// updateDialog.open();

		// MergeDialog mergeDialog = new MergeDialog(parent.getShell());
		// mergeDialog.create();
		// mergeDialog.open();
		// ************************************************
	}

	/**
	 * . this will be called to set contents of browser tab.
	 * 
	 */
	@Override
	protected Control setBrowserTabControl() {
		historyComposite = new HistoryComposite(this, tabFolder, SWT.NONE);
		return historyComposite;
	}

}
