/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.accesscontrol.AccessControlHelper;
import org.unicase.workspace.provider.WorkspaceItemProviderAdapterFactory;
import org.unicase.workspace.ui.dialogs.LoginDialog;
import org.unicase.workspace.util.UnicaseCommandWithResult;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * Content provider for the tree view.
 * 
 * @author shterev
 */
public class ESBrowserContentProvider extends AdapterFactoryContentProvider {

	private Usersession session;
	private HashMap<ProjectInfo, ServerInfo> projectServerMap = new HashMap<ProjectInfo, ServerInfo>();
	private AccessControlHelper accessControl;

	/**
	 * Default constructor.
	 * 
	 * @param usersession
	 *            the usersession used for logging in
	 */
	public ESBrowserContentProvider(Usersession usersession) {
		super(new WorkspaceItemProviderAdapterFactory());
		this.session = usersession;
	}

	/**
	 * @return the HashMap mapping ProjectInfos with their corresponding
	 *         ServerInfo parents
	 */
	public HashMap<ProjectInfo, ServerInfo> getProjectServerMap() {
		return projectServerMap;
	}

	/**
	 * Getter for the AccesscontrolHelper.
	 * 
	 * @return the AccesscontrolHelper
	 */
	public AccessControlHelper getAccesscontrolHelper() {
		return accessControl;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof Workspace) {
			return ((Workspace) object).getServerInfos().toArray();
		} else if (object instanceof ServerInfo) {
			final ServerInfo serverInfo = (ServerInfo) object;

			List<ProjectInfo> pis = new ContentProviderRecordingCommand(
					session, serverInfo).run();
			Display.getDefault().asyncExec(new Runnable() {
				public void run() {
					PlatformUI.getWorkbench().getDecoratorManager().update(
							"org.unicase.ui.esbrowser.LoginDecorator");
				}
			});
			for (ProjectInfo pi : pis) {
				projectServerMap.put(pi, serverInfo);
			}
			return pis.toArray();
		}
		throw new IllegalStateException("Received parent node of unkown type: "
				+ object.getClass());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasChildren(Object parent) {
		if (parent instanceof ServerInfo) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Object[] getElements(Object object) {
		return getChildren(WorkspaceManager.getInstance().getCurrentWorkspace());
	}

	/**
	 * The {@link UnicaseCommandWithResult} for the ContentProvider.
	 * 
	 * @author shterev
	 */
	private class ContentProviderRecordingCommand extends
			UnicaseCommandWithResult<List<ProjectInfo>> {

		private ServerInfo serverInfo;
		private Usersession session;
		private List<ProjectInfo> result = new ArrayList<ProjectInfo>();

		public ContentProviderRecordingCommand(Usersession usersession,
				ServerInfo serverInfo) {
			this.serverInfo = serverInfo;
			this.session = usersession;
		}

		@Override
		protected List<ProjectInfo> doRun() {
			session = serverInfo.getLastUsersession();

			// if no usersession has been set yet or if the current one is not
			// logged in
			if (session == null || !session.isLoggedIn()) {
				LoginDialog dialog = new LoginDialog(PlatformUI.getWorkbench()
						.getDisplay().getActiveShell(), session, serverInfo);
				dialog.open();

				// the login has been canceled and the project list should be
				// cleared since the user is no longer logged
				// in
				if (dialog.getReturnCode() == Window.CANCEL) {
					return result;
				}
				session = dialog.getSession();
				try {
					session.updateACUser();
				} catch (EmfStoreException e) {
					WorkspaceUtil.logException(e.getMessage(), e);
				}
			}
			if (session != null && session.isLoggedIn()) {
				try {
					serverInfo.getProjectInfos().clear();
					serverInfo.getProjectInfos().addAll(
							session.getRemoteProjectList());
					WorkspaceManager.getInstance().getCurrentWorkspace().save();
					result = serverInfo.getProjectInfos();
					accessControl = new AccessControlHelper(session);
				} catch (EmfStoreException e) {
					DialogHandler.showExceptionDialog(e);
				}
			}
			return result;
		}

		/**
		 * {@inheritDoc}
		 * 
		 * @see org.eclipse.emf.common.command.AbstractCommand#getResult()
		 */
		@Override
		public List<ProjectInfo> getResult() {
			return result;
		}

	}

}