/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.historybrowserview;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
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
import org.unicase.model.ModelElementId;
import org.unicase.model.util.ModelUtil;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.ui.Activator;
import org.unicase.workspace.ui.commands.ServerRequestCommandHandler;
import org.unicase.workspace.ui.views.changes.ChangePackageVisualizationHelper;
import org.unicase.workspace.ui.views.scm.SCMContentProvider;
import org.unicase.workspace.ui.views.scm.SCMLabelProvider;
import org.unicase.workspace.util.EventUtil;

/**
 * This the History Browser view. 
 * 
 * @author Hodaie
 * @author Wesendonk
 * @author Shterev
 */
public class HistoryBrowserView extends ViewPart {

	private List<HistoryInfo> historyInfos;

	private ProjectSpace activeProjectSpace;

	private int startOffset = 24;

	private int currentEnd;

	private int headVersion;

	private ModelElement modelElement;

	private TreeViewer viewer;
	private Map<Integer, ChangePackage> changePackageCache;

	private ChangePackageVisualizationHelper changePackageVisualizationHelper;

	private SCMContentProvider contentProvider;

	private SCMLabelProvider labelProvider;

	private Action groupByMe;

	private Action showRoots;

	/**
	 * Constructor.
	 */
	public HistoryBrowserView() {
		historyInfos = new ArrayList<HistoryInfo>();
		changePackageCache = new HashMap<Integer, ChangePackage>();
	}

	private void load(final int end) {
		ServerRequestCommandHandler handler = new ServerRequestCommandHandler(){
		
			@Override
			protected Object run() throws EmfStoreException {
				loadContent(end);
				return null;
			}
		};
		try {
			handler.execute(new ExecutionEvent());
		} catch (ExecutionException e) {
			DialogHandler.showErrorDialog(e.getMessage());
		}
	}

	private void loadContent(int end) throws EmfStoreException {
		if (activeProjectSpace == null) {
			historyInfos.clear();
			return;
		}
			HistoryQuery query = getQuery(end);
			List<HistoryInfo> historyInfo = activeProjectSpace.getUsersession().getHistoryInfo(
				activeProjectSpace.getProjectId(), query);

			// Event logging
			ShowHistoryEvent historyEvent = EventsFactory.eINSTANCE.createShowHistoryEvent();
			historyEvent.setSourceVersion(query.getSource());
			historyEvent.setTargetVersion(query.getTarget());
			historyEvent.setTimestamp(new Date());
			EList<ModelElementId> modelElements = query.getModelElements();
			if (modelElements != null) {
				for (ModelElementId modelElementId : modelElements) {
					historyEvent.getModelElement().add(ModelUtil.clone(modelElementId));
				}
			}
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
			for (HistoryInfo hi : historyInfos) {
				if (hi.getChangePackage() != null) {
					changePackageCache.put(hi.getPrimerySpec().getIdentifier(), hi.getChangePackage());
				}
			}
			changePackageVisualizationHelper = new ChangePackageVisualizationHelper(new ArrayList<ChangePackage>(
				changePackageCache.values()), getActiveProjectSpace().getProject());
			labelProvider.setChangePackageVisualizationHelper(changePackageVisualizationHelper);
			contentProvider.setChangePackageVisualizationHelper(changePackageVisualizationHelper);
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

		PrimaryVersionSpec source = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		source.setIdentifier(start);
		PrimaryVersionSpec target = VersioningFactory.eINSTANCE.createPrimaryVersionSpec();
		target.setIdentifier(end);
		query.setSource(source);
		query.setTarget(target);
		query.setIncludeChangePackage(true);
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
		
		GridLayoutFactory.fillDefaults().applyTo(parent);
		viewer = new TreeViewer(parent, SWT.NONE);
		GridDataFactory.fillDefaults().grab(true, true).applyTo(viewer.getControl());
		contentProvider = new SCMContentProvider.Compact(viewer, getActiveProjectSpace().getProject());
		labelProvider = new SCMLabelProvider(getActiveProjectSpace().getProject());
		viewer.setContentProvider(contentProvider);
		viewer.setLabelProvider(labelProvider);
		viewer.setInput(getHistoryInfos());

		
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

		groupByMe = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				boolean showRootsCache = contentProvider.showRootNodes();
				if (isChecked()) {
					contentProvider = new SCMContentProvider.Compact(viewer, getActiveProjectSpace().getProject());
				} else {
					contentProvider = new SCMContentProvider.Detailed(viewer, getActiveProjectSpace().getProject());
				}
				contentProvider.setShowRootNodes(showRootsCache);
				viewer.setContentProvider(contentProvider);
				viewer.refresh();
			}

		};
		groupByMe.setImageDescriptor(Activator.getImageDescriptor("/icons/groupByME.png"));
		groupByMe.setToolTipText("Group by model element");
		groupByMe.setChecked(true);
		menuManager.add(groupByMe);

		showRoots = new Action("", SWT.TOGGLE) {
			@Override
			public void run() {
				if (isChecked()) {
					contentProvider.setShowRootNodes(true);
				} else {
					contentProvider.setShowRootNodes(false);
				}
				viewer.setContentProvider(contentProvider);
				viewer.refresh();
			}

		};
		AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(
			new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		showRoots.setImageDescriptor(ImageDescriptor.createFromImage(adapterFactoryLabelProvider.getImage(VersioningFactory.eINSTANCE
			.createChangePackage())));
		showRoots.setToolTipText("Show package nodes");
		showRoots.setChecked(true);
		menuManager.add(showRoots);

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
	protected void refresh() {
		ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
			.getActiveWorkbenchWindow().getShell());
		progressDialog.open();
		progressDialog.getProgressMonitor().beginTask("Resolving project versions...", 100);
		progressDialog.getProgressMonitor().worked(10);
		load(currentEnd);
		progressDialog.getProgressMonitor().worked(80);
		viewer.setInput(getHistoryInfos());
		progressDialog.getProgressMonitor().done();
		progressDialog.close();
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
			groupByMe.setChecked(false);
			showRoots.setChecked(false);
			contentProvider = new SCMContentProvider.Detailed(viewer, getActiveProjectSpace().getProject());
			contentProvider.setShowRootNodes(false);
		} else {
			label += projectSpace.getProjectName();
			groupByMe.setChecked(true);
			showRoots.setChecked(true);
			contentProvider = new SCMContentProvider.Compact(viewer, getActiveProjectSpace().getProject());
			contentProvider.setShowRootNodes(true);
		}
		setContentDescription(label);
		viewer.setContentProvider(contentProvider);
		refresh();
	}

	/**
	 * @return the changePackageVisualizationHelper
	 */
	public ChangePackageVisualizationHelper getChangePackageVisualizationHelper() {
		return changePackageVisualizationHelper;
	}

}
