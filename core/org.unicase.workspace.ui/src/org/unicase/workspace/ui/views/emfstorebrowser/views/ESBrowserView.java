/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.views;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.WorkspacePackage;
import org.unicase.workspace.observers.LoginObserver;
import org.unicase.workspace.ui.views.emfstorebrowser.provider.ESBrowserContentProvider;
import org.unicase.workspace.ui.views.emfstorebrowser.provider.ESBrowserLabelProvider;
import org.unicase.workspace.ui.views.emfstorebrowser.provider.ESBrowserViewerSorter;

/**
 * View containing the remote repositories.
 * 
 * @author shterev
 */
public class ESBrowserView extends ViewPart implements LoginObserver {

	private TreeViewer viewer;

	private ESBrowserContentProvider contentProvider;
	private MenuManager menuMgr;
	private AdapterImpl workspaceAdapter;
	private AdapterImpl serverInfoAdapter;

	/**
	 * The constructor.
	 */
	public ESBrowserView() {
		Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		for (Usersession u : currentWorkspace.getUsersessions()) {
			u.addLoginObserver(this);
		}
		for (final ServerInfo serverInfo : currentWorkspace.getServerInfos()) {
			serverInfoAdapter = new AdapterImpl() {
				@Override
				public void notifyChanged(final Notification msg) {
					if (msg.getFeature() != null
						&& msg.getFeature().equals(WorkspacePackage.eINSTANCE.getServerInfo_ProjectInfos())) {
						Display.getCurrent().asyncExec(new Runnable() {
							public void run() {
								TreeNode element = new TreeNode(serverInfo);
								if (msg.getEventType() == Notification.REMOVE_MANY
									|| msg.getEventType() == Notification.REMOVE) {
									viewer.collapseToLevel(element, 0);
								}
								viewer.refresh(element, true);
							}
						});
					}
				}
			};
			serverInfo.eAdapters().add(serverInfoAdapter);
		}
		workspaceAdapter = new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getNewValue() instanceof ServerInfo) {
					ServerInfo serverInfo = (ServerInfo) msg.getNewValue();
					serverInfo.eAdapters().add(serverInfoAdapter);
					viewer.refresh();
				} else if (msg.getOldValue() instanceof ServerInfo) {
					ServerInfo serverInfo = (ServerInfo) msg.getOldValue();
					serverInfo.eAdapters().remove(serverInfoAdapter);
					viewer.refresh();
				}
				if (msg.getFeature() != null
					&& msg.getFeature().equals(WorkspacePackage.eINSTANCE.getWorkspace_Usersessions())) {
					if (msg.getEventType() == Notification.ADD) {
						Usersession session = (Usersession) msg.getNewValue();
						session.addLoginObserver(ESBrowserView.this);
					} else if (msg.getEventType() == Notification.REMOVE) {
						Usersession session = (Usersession) msg.getOldValue();
						session.removeLoginObserver(ESBrowserView.this);
					}
				}
				super.notifyChanged(msg);
			}
		};
		currentWorkspace.eAdapters().add(workspaceAdapter);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);

		contentProvider = new ESBrowserContentProvider();
		viewer.setContentProvider(contentProvider);
		IDecoratorManager decoratorManager = PlatformUI.getWorkbench().getDecoratorManager();
		viewer.setLabelProvider(new DecoratingLabelProvider(new ESBrowserLabelProvider(), decoratorManager
			.getLabelDecorator()));
		viewer.setSorter(new ESBrowserViewerSorter());

		viewer.setInput(WorkspaceManager.getInstance().getCurrentWorkspace());

		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "org.unicase.repositoryview.viewer");

		menuMgr = new MenuManager();
		menuMgr.add(new Separator("additions"));
		getSite().registerContextMenu(menuMgr, viewer);
		Control control = viewer.getControl();
		Menu menu = menuMgr.createContextMenu(control);
		control.setMenu(menu);

		getSite().setSelectionProvider(viewer);
		hookDoubleClickAction();

	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				Object firstElement = ((IStructuredSelection) viewer.getSelection()).getFirstElement();
				viewer.refresh(firstElement);
				viewer.expandToLevel(firstElement, 1);
			}
		});
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
		// TODO: ChainSaw event
		// EventUtil.logFocusEvent("org.unicase.workspace.ui.repositorybrowser");
	}

	/**
	 * @return the {@link TreeViewer} for this view.
	 */
	public TreeViewer getViewer() {
		return viewer;
	}

	/**
	 * {@inheritDoc}
	 */
	public void loginCompleted(Usersession session) {
		final TreeNode node = new TreeNode(session.getServerInfo());
		getSite().getShell().getDisplay().asyncExec(new Runnable() {
			public void run() {
				viewer.refresh(node, true);
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void dispose() {
		super.dispose();
		Workspace currentWorkspace = WorkspaceManager.getInstance().getCurrentWorkspace();
		currentWorkspace.eAdapters().remove(workspaceAdapter);
		for (Usersession u : currentWorkspace.getUsersessions()) {
			u.removeLoginObserver(this);
		}
		for (ServerInfo s : currentWorkspace.getServerInfos()) {
			s.eAdapters().remove(serverInfoAdapter);
		}

	}

}
