/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.edit.views.historybrowserview;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.versioning.HistoryInfo;
import org.unicase.emfstore.esmodel.versioning.HistoryQuery;
import org.unicase.emfstore.esmodel.versioning.PrimaryVersionSpec;
import org.unicase.emfstore.esmodel.versioning.TagVersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.esmodel.versioning.events.EventsFactory;
import org.unicase.emfstore.esmodel.versioning.events.ShowHistoryEvent;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.ModelElement;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.edit.Activator;
import org.unicase.workspace.edit.views.AbstractSCMView;
import org.unicase.workspace.util.EventUtil;

/**
 * This the History Browser view. It inherits AbstractSCMView and hence has a query tab, where the user can set criteria
 * for view's content. It also has a browser tab (a HistoryComposite).
 * 
 * @author Hodaie
 * @author Wesendonk
 * @author Shterev
 */
public class HistoryBrowserView extends AbstractSCMView {

	private List<HistoryInfo> historyInfos;

	private HistoryComposite historyComposite;

	private ProjectSpace activeProjectSpace;

	private int startOffset = 24;

	private int currentEnd;

	private int headVersion;

	private ModelElement modelElement;

	/**
	 * Constructor.
	 */
	public HistoryBrowserView() {
		historyInfos = new ArrayList<HistoryInfo>();
	}

	private void load(final int end) {
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
			.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				loadContent(end);
			}
		});
	}

	private void loadContent(int end) {
		if (activeProjectSpace == null) {
			historyInfos.clear();
			return;
		}
		try {
			HistoryQuery query = getQuery(end);
			List<HistoryInfo> historyInfo = activeProjectSpace.getUsersession().getHistoryInfo(
				activeProjectSpace.getProjectId(), query);

			// Event logging
			ShowHistoryEvent historyEvent = EventsFactory.eINSTANCE.createShowHistoryEvent();
			historyEvent.setSourceVersion(query.getSource());
			historyEvent.setTargetVersion(query.getTarget());
			historyEvent.setTimestamp(new Date());
			activeProjectSpace.addEvent(historyEvent);

			if (historyInfo != null) {
				for (HistoryInfo hi : historyInfo) {
					if (hi.getPrimerySpec().equals(activeProjectSpace.getBaseVersion())) {
						TagVersionSpec spec = VersioningFactory.eINSTANCE.createTagVersionSpec();
						spec.setName(VersionSpec.BASE);
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

	private ProjectSpace getActiveProjectSpace() {
		ProjectSpace activeProjectSpace = WorkspaceManager.getInstance().getCurrentWorkspace().getActiveProjectSpace();
		if (activeProjectSpace == null) {
			DialogHandler.showErrorDialog("No active project chosen.");
			return null;
		}
		if (activeProjectSpace.getUsersession() == null || !activeProjectSpace.getUsersession().isLoggedIn()) {
			DialogHandler.showErrorDialog("Chosen Project is not logged in.");
			return null;
		}
		return activeProjectSpace;
	}

	private void getHeadVersionIdentifier() throws EmfStoreException {
		PrimaryVersionSpec resolveVersionSpec = activeProjectSpace.resolveVersionSpec(VersionSpec.HEAD_VERSION);
		int identifier = resolveVersionSpec.getIdentifier();
		headVersion = identifier;
	}

	private HistoryQuery getQuery(int end) throws EmfStoreException {
		HistoryQuery query = VersioningFactory.eINSTANCE.createHistoryQuery();

		getHeadVersionIdentifier();
		if (end == -1) {
			end = headVersion;
			currentEnd = headVersion;
		}
		int temp = end - startOffset;
		int start = (temp > 0 ? temp : 0);

		// Query qury = getQueryComposite().getQuery();
		// if (qury.getQueryRangeType().equals(QueryRangeType.VERSION)
		// && qury.getStartVersion() != -1 && qury.getEndVersion() != -1) {
		// start = qury.getStartVersion();
		// end = qury.getEndVersion();
		// } else {
		// PrimaryVersionSpec resolveVersionSpec = activeProjectSpace
		// .resolveVersionSpec(VersionSpec.HEAD_VERSION);
		// end = resolveVersionSpec.getIdentifier();
		// start = (end > 20) ? end - 20 : 0;
		// }

		PrimaryVersionSpec source = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		source.setIdentifier(start);
		PrimaryVersionSpec target = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		target.setIdentifier(end);
		query.setSource(source);
		query.setTarget(target);
		if (modelElement != null) {
			query.getModelElements().add(modelElement.getModelElementId());
		}

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
	 * Adds a tag to a version.
	 * 
	 * @param versionSpec the version
	 * @param tag the tag
	 */
	public void addTag(PrimaryVersionSpec versionSpec, TagVersionSpec tag) {
		try {
			ProjectSpace activeProjectSpace = getActiveProjectSpace();
			if (activeProjectSpace == null) {
				return;
			}
			activeProjectSpace.addTag(versionSpec, tag);
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
	}

	/**
	 * Checks out a specific revision.
	 * 
	 * @param versionSpec the version
	 */
	public void checkout(PrimaryVersionSpec versionSpec) {
		try {
			ProjectSpace activeProjectSpace = getActiveProjectSpace();
			if (activeProjectSpace == null) {
				return;
			}
			WorkspaceManager.getInstance().getCurrentWorkspace().checkout(activeProjectSpace.getUsersession(),
				activeProjectSpace.getProjectInfo(), versionSpec);
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
	}

	/**
	 * Removes a tag to a version.
	 * 
	 * @param versionSpec the version
	 * @param tag the tag
	 */
	public void removeTag(PrimaryVersionSpec versionSpec, TagVersionSpec tag) {
		try {
			ProjectSpace activeProjectSpace = getActiveProjectSpace();
			if (activeProjectSpace == null) {
				return;
			}
			activeProjectSpace.removeTag(versionSpec, tag);
		} catch (EmfStoreException e) {
			DialogHandler.showExceptionDialog(e);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		super.createPartControl(parent);
		getBrowserTab().setText("History");

		IActionBars bars = getViewSite().getActionBars();
		IToolBarManager menuManager = bars.getToolBarManager();

		Action refresh = new Action() {
			@Override
			public void run() {
				refresh();
			}

		};
		refresh.setImageDescriptor(Activator.getImageDescriptor("/icons/refresh.png"));
		refresh.setToolTipText("Refresh");
		menuManager.add(refresh);

		Action prev = new Action() {
			@Override
			public void run() {
				int temp = currentEnd + startOffset;
				if (temp <= headVersion) {
					currentEnd = temp;
				}
				refresh();
			}

		};
		prev.setImageDescriptor(Activator.getImageDescriptor("/icons/prev.png"));
		prev.setToolTipText("Previous " + (startOffset + 1) + " items");
		menuManager.add(prev);

		Action next = new Action() {
			@Override
			public void run() {
				int temp = currentEnd - startOffset;
				if (temp > 0) {
					currentEnd = temp;
				}
				refresh();
			}

		};
		next.setImageDescriptor(Activator.getImageDescriptor("/icons/next.png"));
		next.setToolTipText("Next " + (startOffset + 1) + " items");
		menuManager.add(next);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setFocus() {
		EventUtil.logFocusEvent("org.unicase.ui.repository.views.HistoryView");
	}

	/**
	 * Refreshes the view using the current end point.
	 */
	@Override
	protected void refresh() {
		ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getShell());
		progressDialog.open();
		progressDialog.getProgressMonitor().beginTask("Resolving project versions...", 100);
		progressDialog.getProgressMonitor().worked(10);
		load(currentEnd);
		progressDialog.getProgressMonitor().worked(80);
		historyComposite.updateTable();
		progressDialog.getProgressMonitor().done();
		progressDialog.close();
	}

	/**
	 * This will be called to set contents of browser tab. {@inheritDoc}
	 * 
	 * @see org.unicase.workspace.edit.views.AbstractSCMView#setBrowserTabControl()
	 */
	@Override
	protected Control setBrowserTabControl() {
		historyComposite = new HistoryComposite(this, getTabFolder(), SWT.NONE);
		return historyComposite;
	}

	/**
	 * Set the input for the History Browser.
	 * 
	 * @param projectSpace the input project space
	 */
	public void setInput(ProjectSpace projectSpace) {
		setInput(projectSpace, null);
	}

	/**
	 * Set the input for the History Browser.
	 * 
	 * @param projectSpace the input project space
	 * @param me the input model element
	 */
	public void setInput(ProjectSpace projectSpace, ModelElement me) {
		activeProjectSpace = projectSpace;
		modelElement = me;
		currentEnd = -1;
		String label = "History for ";
		if (me != null) {
			label += me.getName();
		} else {
			label += projectSpace.getProjectName();
		}
		getBrowserTab().setText(label);
		refresh();
	}

}
