/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.esbrowser.views;

import java.util.HashMap;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
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
import org.eclipse.jface.viewers.DecoratingLabelProvider;
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
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.part.ViewPart;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.ExceptionDialogHandler;
import org.unicase.ui.esbrowser.Activator;
import org.unicase.ui.esbrowser.dialogs.admin.ManageOrgUnitsDialog;
import org.unicase.workspace.AdminBroker;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.edit.dialogs.LoginDialog;
import org.unicase.workspace.provider.WorkspaceItemProviderAdapterFactory;

/**
 * View containing the remote repositories.
 * 
 * @author shterev
 * 
 */
public class ESBrowserView extends ViewPart {
	private TreeViewer viewer;
	private Action projectCheckout;
	private Action addRepository;
	private Action serverLogin;
	private Action serverAddProject;
	private Action serverChangeSession;
	private Action serverProperties;
	private Action manageOrgUnits;
	private Usersession session;
	private HashMap<ProjectInfo, ServerInfo> projectServerMap = new HashMap<ProjectInfo, ServerInfo>();
	public ServerInfo serverInfo;

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
				final boolean[] noChildren = {false};
				serverInfo = (ServerInfo) object;
				//AS: refactor command to own class with return type
				TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						session = serverInfo.getLastUsersession();

						// if no usersession has been set yet or if the current one is not logged in
						if (session==null || !session.isLoggedIn()) {
							LoginDialog dialog = new LoginDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), session, serverInfo);
							dialog.open();
							if(dialog.getReturnCode()==LoginDialog.CANCELED){
								noChildren[0] = true;
							}
							session = dialog.getSession();
						}
						if (session!=null && session.isLoggedIn()) {
							try {
								serverInfo.getProjectInfos().clear();
								serverInfo.getProjectInfos().addAll(session.getRemoteProjectList());
								WorkspaceManager.getInstance().getCurrentWorkspace().save();
								viewer.refresh();
							} catch (EmfStoreException e) {
								ExceptionDialogHandler.showExceptionDialog(e);
							}
						}
					}
				});
				if(noChildren[0]){
					return new Object[0];
				}
				
				EList<ProjectInfo> pis = serverInfo.getProjectInfos();
				for (ProjectInfo pi : pis) {
					projectServerMap.put(pi, serverInfo);
				}
				return pis.toArray();
			}
			throw new IllegalStateException("Received parent node of unkown type: " + object.getClass());
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
				return getChildren(WorkspaceManager.getInstance().getCurrentWorkspace());
			}
			return new Object[0];
		}

	}

	/**
	 * The constructor.
	 */
	public ESBrowserView() {
		WorkspaceManager.getInstance().getCurrentWorkspace().eAdapters().add(new AdapterImpl() {
			@Override
			public void notifyChanged(Notification msg) {
				if (msg.getNewValue() instanceof ServerInfo) {
					viewer.refresh();
				}
				super.notifyChanged(msg);
			}
		});
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new WorkspaceRootContentProvider());
		AdapterFactoryLabelProvider adapterFactoryLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		viewer.setLabelProvider(new DecoratingLabelProvider(adapterFactoryLabelProvider, ((DecoratingLabelProvider) WorkbenchLabelProvider.getDecoratingWorkbenchLabelProvider()).getLabelDecorator()));

		viewer.setSorter(new ViewerSorter());
		viewer.setInput(getViewSite());

		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "org.unicase.repositoryview.viewer");
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
				ESBrowserView.this.fillContextMenu(manager);
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
				serverChangeSession.setText("Log out");
				manager.add(serverChangeSession);
				manager.add(manageOrgUnits);

			} else if (session != null && !session.isLoggedIn()) {
				serverLogin.setText("Login as " + session.getUsername());
				manager.add(serverLogin);
				serverChangeSession.setText("Login as...");
				manager.add(serverChangeSession);
			} else {
				manager.add(serverLogin);
			}
			manager.add(new Separator());
			manager.add(serverProperties);
		} else if (obj instanceof ProjectInfo) {
			manager.add(projectCheckout);
		}

	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(addRepository);
	}

	private void makeActions() {
		serverLogin = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				viewer.collapseToLevel(obj, -1);
				viewer.expandToLevel(obj, -1);
			}
		};
		serverLogin.setText("Login...");
		serverLogin.setToolTipText("Click to login with the last used username");
		serverLogin.setImageDescriptor(Activator.getImageDescriptor("icons/serverLogin.png"));

		projectCheckout = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				final ProjectInfo element = (ProjectInfo) obj;
				TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");

				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						try {
							projectServerMap.get(element).getLastUsersession().checkout(element);
						} catch (EmfStoreException e) {
							ExceptionDialogHandler.showExceptionDialog(e);
						} catch (RuntimeException e) {
							ExceptionDialogHandler.showExceptionDialog(e);
						}
					}
				});
			}
		};
		projectCheckout.setText("Checkout");
		projectCheckout.setToolTipText("Click to checkout this project");
		projectCheckout.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_FORWARD));

		serverChangeSession = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				final ServerInfo element = (ServerInfo) obj;
				TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
				domain.getCommandStack().execute(new RecordingCommand(domain) {
					@Override
					protected void doExecute() {
						//AS: replace with logout() 
						element.getLastUsersession().setSessionId(null);
						element.setLastUsersession(null);
						WorkspaceManager.getInstance().getCurrentWorkspace().save();
					}
				});
				viewer.refresh(obj);
			}
		};
		serverChangeSession.setToolTipText("Click to login with a different username");
		serverChangeSession.setImageDescriptor(Activator.getImageDescriptor("icons/serverLoginAs.png"));

		serverAddProject = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				ServerInfo serverInfo = ((ServerInfo) obj);
				if (serverInfo.getLastUsersession().isLoggedIn()) {
					CreateProjectDialog dialog = new CreateProjectDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), serverInfo.getLastUsersession());
					dialog.open();
					viewer.refresh(obj);
				}
			}
		};
		serverAddProject.setText("Create new project");
		serverAddProject.setToolTipText("Click to create new project on the server");
		serverAddProject.setImageDescriptor(Activator.getImageDescriptor("icons/projectAdd.png"));

		serverProperties = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				ServerInfo serverInfo = ((ServerInfo) obj);
				AddRepositoryWizard wizard = new AddRepositoryWizard(ESBrowserView.this);
				wizard.init(getSite().getWorkbenchWindow().getWorkbench(), (IStructuredSelection) getSite().getWorkbenchWindow().getSelectionService().getSelection(), serverInfo);
				WizardDialog dialog = new WizardDialog(getSite().getWorkbenchWindow().getShell(), wizard);
				dialog.create();
				dialog.open();
			}
		};
		serverProperties.setText("Server properties");
		serverProperties.setToolTipText("Click to modify the server properties");
		serverProperties.setImageDescriptor(Activator.getImageDescriptor("icons/serverEdit.png"));

		addRepository = new Action() {
			@Override
			public void run() {
				AddRepositoryWizard wizard = new AddRepositoryWizard(ESBrowserView.this);
				wizard.init(getSite().getWorkbenchWindow().getWorkbench(), (IStructuredSelection) getSite().getWorkbenchWindow().getSelectionService().getSelection());
				WizardDialog dialog = new WizardDialog(getSite().getWorkbenchWindow().getShell(), wizard);
				dialog.create();
				dialog.open();
			}
		};
		addRepository.setText("New repository...");
		addRepository.setToolTipText("Click to add new repository");
		addRepository.setImageDescriptor(Activator.getImageDescriptor("icons/serverAdd.png"));

		manageOrgUnits = new Action() {
			public void run() {
				ManageOrgUnitsDialog dialog;
				try {
					ISelection selection = viewer.getSelection();
					Object obj = ((IStructuredSelection) selection).getFirstElement();
					ServerInfo serverInfo = ((ServerInfo) obj);
					session = serverInfo.getLastUsersession();
					AdminBroker adminBroker = session.getAdminBroker();
					dialog = new ManageOrgUnitsDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(), adminBroker);
					dialog.create();
					dialog.open();
				} catch (ConnectionException e) {
					ExceptionDialogHandler.showExceptionDialog(e);
				}
			}
		};
		manageOrgUnits.setText("Manage OrgUnits...");

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
