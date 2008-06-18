/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Kšgel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.esbrowser.views;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.provider.EsmodelEditPlugin;
import org.unicase.emfstore.esmodel.provider.EsmodelItemProviderAdapterFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.esbrowser.dialogs.RepositoryCreateProjectDialog;
import org.unicase.ui.esbrowser.dialogs.RepositoryLoginDialog;
import org.unicase.ui.esbrowser.dialogs.RepositoryWizard;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.provider.WorkspaceEditPlugin;
import org.unicase.workspace.provider.WorkspaceItemProviderAdapterFactory;

/**
 * View containing the remote repositories.
 * 
 * @author shterev
 * 
 */
public class RepositoryView extends ViewPart {
	private TreeViewer viewer;
	private Action projectCheckout;
	private Action addRepository;
	private Action serverLogin;
	private Action serverAddProject;
	private Action serverChangeSession;
	private Action serverProperties;
	private Usersession session;
	private HashMap<ProjectInfo, ServerInfo> projectServerMap = new HashMap<ProjectInfo, ServerInfo>();

	/**
	 * Content provider for the tree view.
	 * 
	 * @author shterev
	 * 
	 */
	class WorkspaceRootContentProvider extends AdapterFactoryContentProvider {

		/**
		 * Default constructor.
		 */
		public WorkspaceRootContentProvider() {
			super(new WorkspaceItemProviderAdapterFactory());
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
				session = serverInfo.getLastUsersession();
				if (session == null || session.getPassword() == null) {
					RepositoryLoginDialog dialog = new RepositoryLoginDialog(
							PlatformUI.getWorkbench().getDisplay()
									.getActiveShell(), session, serverInfo);
					session = dialog.open();
				}
				if (session == null) {
					return new Object[0];
				}

				TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
						.getEditingDomain("org.unicase.EditingDomain");
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						try {
							session.logIn();
							serverInfo.getProjectInfos().clear();
							serverInfo.getProjectInfos().addAll(
									session.getRemoteProjectList());
							serverInfo.setLastUsersession(session);
							WorkspaceManager.getInstance()
									.getCurrentWorkspace().save();
						} catch (EmfStoreException e) {
							// TODO server timed out
							//
							//
							e.printStackTrace();
						} catch (AccessControlException e) {
							// TODO wrong password/user
							//
							//
							e.printStackTrace();
						}
					}
				});

				EList<ProjectInfo> pis = serverInfo.getProjectInfos();
				for (ProjectInfo pi : pis) {
					projectServerMap.put(pi, serverInfo);
				}
				return pis.toArray();
			}
			throw new IllegalStateException(
					"Received parent node of unkown type: " + object.getClass());
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
			if (object.equals(getViewSite())) {
				return getChildren(WorkspaceManager.getInstance()
						.getCurrentWorkspace());
			}
			return new Object[0];
		}

	}

	/**
	 * The constructor.
	 */
	public RepositoryView() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new WorkspaceRootContentProvider());
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(
				new EsmodelItemProviderAdapterFactory()));
		//
		// new AdapterFactoryLabelProvider(
		// new ComposedAdapterFactory(
		// ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		viewer.setSorter(new ViewerSorter());
		viewer.setInput(getViewSite());

		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(),
				"org.unicase.repositoryview.viewer");
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				RepositoryView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillContextMenu(IMenuManager manager) {
		ISelection selection = viewer.getSelection();
		Object obj = ((IStructuredSelection) selection).getFirstElement();
		if (obj instanceof ServerInfo) {
			Usersession session = ((ServerInfo) obj).getLastUsersession();
			if (session != null && session.isLoggedIn()) {
				manager.add(serverAddProject);
			}
			manager.add(serverLogin);
			manager.add(serverChangeSession);
			manager.add(new Separator());
			manager.add(serverProperties);
		} else if (obj instanceof ProjectInfo) {
			manager.add(projectCheckout);
		}
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(addRepository);
	}

	// private RepositoryView getViewInstance() {
	// return this;
	// }

	private void makeActions() {
		projectCheckout = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				ProjectInfo element = (ProjectInfo) obj;
				try {
					projectServerMap.get(element).getLastUsersession()
							.checkout(element);
				} catch (EmfStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		projectCheckout.setText("Checkout");
		projectCheckout.setToolTipText("Click to checkout this project");
		projectCheckout.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_TOOL_FORWARD));

		serverLogin = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				viewer.refresh(obj);
			}
		};
		serverLogin.setText("Login [last usersession]");
		serverLogin
				.setToolTipText("Click to login with the last used username");
		serverLogin.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_OBJ_ELEMENT));

		serverChangeSession = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				ServerInfo element = (ServerInfo) obj;
				element.setLastUsersession(null);
				WorkspaceManager.getInstance().getCurrentWorkspace().save();
				serverLogin.run();
			}
		};
		serverChangeSession.setText("Login as...");
		serverChangeSession
				.setToolTipText("Click to login with a different username");
		serverChangeSession.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_OBJ_ELEMENT));

		serverAddProject = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				ServerInfo serverInfo = ((ServerInfo) obj);
				if (serverInfo.getLastUsersession().isLoggedIn()) {
					RepositoryCreateProjectDialog dialog = new RepositoryCreateProjectDialog(
							PlatformUI.getWorkbench().getDisplay()
									.getActiveShell(), serverInfo
									.getLastUsersession());
					dialog.open();
					viewer.refresh(obj);
				}
			}
		};
		serverAddProject.setText("Create new project");
		serverAddProject
				.setToolTipText("Click to create new project on the server");
		try {
			serverAddProject.setImageDescriptor(ImageDescriptor
					.createFromURL(new URL(EsmodelEditPlugin.INSTANCE.getImage(
							"full/obj16/ProjectInfo").toString())));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		serverProperties = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				ServerInfo serverInfo = ((ServerInfo) obj);
				RepositoryWizard wizard = new RepositoryWizard(
						RepositoryView.this);
				wizard.init(getSite().getWorkbenchWindow().getWorkbench(),
						(IStructuredSelection) getSite().getWorkbenchWindow()
								.getSelectionService().getSelection(),
						serverInfo);
				WizardDialog dialog = new WizardDialog(getSite()
						.getWorkbenchWindow().getShell(), wizard);
				dialog.create();
				dialog.open();
			}
		};
		serverProperties.setText("Server properties");
		serverProperties
				.setToolTipText("Click to modify the server properties");
		try {
			serverProperties.setImageDescriptor(ImageDescriptor
					.createFromURL(new URL(WorkspaceEditPlugin.INSTANCE
							.getImage("full/obj16/ServerInfo").toString())));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		addRepository = new Action() {
			@Override
			public void run() {
				RepositoryWizard wizard = new RepositoryWizard(
						RepositoryView.this);
				wizard.init(getSite().getWorkbenchWindow().getWorkbench(),
						(IStructuredSelection) getSite().getWorkbenchWindow()
								.getSelectionService().getSelection());
				WizardDialog dialog = new WizardDialog(getSite()
						.getWorkbenchWindow().getShell(), wizard);
				dialog.create();
				dialog.open();
			}
		};
		addRepository.setText("New repository...");
		addRepository.setToolTipText("Click to add new repository");
		try {
			addRepository.setImageDescriptor(ImageDescriptor
					.createFromURL(new URL(WorkspaceEditPlugin.INSTANCE
							.getImage("full/obj16/ServerInfo").toString())));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				serverLogin.run();
			}
		});
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	/**
	 * @return the {@link TreeViewer} for this view.
	 */
	public TreeViewer getViewer() {
		return viewer;
	}
}
