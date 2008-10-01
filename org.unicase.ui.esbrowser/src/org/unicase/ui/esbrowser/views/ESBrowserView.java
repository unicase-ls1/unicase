/**
 * <copyright> Copyright (c) 2008 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * </copyright>
 *
 * $Id$
 */
package org.unicase.ui.esbrowser.views;

import java.util.ArrayList;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.esbrowser.Activator;
import org.unicase.ui.esbrowser.dialogs.admin.ManageOrgUnitsDialog;
import org.unicase.ui.esbrowser.provider.ESBrowserContentProvider;
import org.unicase.ui.esbrowser.provider.ESBrowserLabelProvider;
import org.unicase.workspace.AdminBroker;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.accesscontrol.AccessControlHelper;

/**
 * View containing the remote repositories.
 * 
 * @author shterev
 * 
 */
public class ESBrowserView extends ViewPart {
	/**
	 * Action to show properties.
	 * 
	 * @author helming
	 * 
	 */
	private final class PropertiesAction extends Action {
		public void run() {
			ISelection selection = viewer.getSelection();
			ProjectInfo projectInfo = ((ProjectInfo) ((IStructuredSelection) selection)
					.getFirstElement());
			Usersession session = contentProvider.getProjectServerMap().get(
					projectInfo).getLastUsersession();
			int revision;
			try {
				revision = session.resolveVersionSpec(
						VersioningFactory.eINSTANCE.createHeadVersionSpec(),
						projectInfo.getProjectId()).getIdentifier();
				MessageDialog.openInformation(Display.getCurrent()
						.getActiveShell(), "Project information",
						"Current revision: " + revision);
			} catch (EmfStoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * Action to delete project.
	 * 
	 * @author helming
	 * 
	 */
	private final class DeleteAction extends Action {
		public void run() {
			ISelection selection = viewer.getSelection();
			ServerInfo serverInfo = ((ServerInfo) ((IStructuredSelection) selection)
					.getFirstElement());
			EList<ProjectSpace> projectSpaces = WorkspaceManager.getInstance()
					.getCurrentWorkspace().getProjectSpaces();
			ArrayList<ProjectSpace> usedSpaces = new ArrayList<ProjectSpace>();
			for (ProjectSpace projectSpace : projectSpaces) {
				if (projectSpace.getUsersession().getServerInfo().equals(
						serverInfo)) {
					usedSpaces.add(projectSpace);
				}
			}
			if (usedSpaces.size() > 0) {
				String message = "";
				for (ProjectSpace pSpace : usedSpaces) {
					message += "\n" + pSpace.getProjectName();
				}
				DialogHandler
						.showErrorDialog("Cannot delete \'"
								+ serverInfo.getName()
								+ "\' because it is currently used by the following projects: \n"
								+ message);
			} else {
				if (MessageDialog.openQuestion(Display.getCurrent()
						.getActiveShell(), "Confirm deletion",
						"Are you sure you want to delete \'"
								+ serverInfo.getName() + "\'")) {
					TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
							.getEditingDomain("org.unicase.EditingDomain");
					domain.getCommandStack().execute(
							DeleteCommand.create(domain, serverInfo));
					WorkspaceManager.getInstance().getCurrentWorkspace().save();
					viewer.refresh();
				}
			}
		}
	}

	/**
	 * Action to change the user session.
	 * 
	 * @author helming
	 * 
	 */
	private final class ChangeSessionAction extends Action {
		@Override
		public void run() {
			ISelection selection = viewer.getSelection();
			Object obj = ((IStructuredSelection) selection).getFirstElement();
			final ServerInfo element = (ServerInfo) obj;
			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain("org.unicase.EditingDomain");
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					// AS: replace with logout()
					element.getLastUsersession().setSessionId(null);
					element.setLastUsersession(null);
					WorkspaceManager.getInstance().getCurrentWorkspace().save();
				}
			});
			viewer.refresh(obj);
		}
	}

	/**
	 * Action for project checkout.
	 * 
	 * @author helming
	 * 
	 */
	private final class ProjectCheckoutAction extends Action {
		@Override
		public void run() {
			ISelection selection = viewer.getSelection();
			Object obj = ((IStructuredSelection) selection).getFirstElement();
			final ProjectInfo element = (ProjectInfo) obj;
			TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain("org.unicase.EditingDomain");

			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					try {
						contentProvider.getProjectServerMap().get(element)
								.getLastUsersession().checkout(element);
					} catch (EmfStoreException e) {
						DialogHandler.showExceptionDialog(e);
						e.printStackTrace();
					}
				}
			});
		}
	}

	private TreeViewer viewer;
	private Action projectCheckout;
	private Action addRepository;
	private Action serverLogin;
	private Action serverAddProject;
	private Action serverChangeSession;
	private Action serverProperties;
	private Action manageOrgUnits;
	private Usersession session;

	private ESBrowserContentProvider contentProvider;
	private Action deleteAction;
	private Action projectProperties;

	/**
	 * The constructor.
	 */
	public ESBrowserView() {
		WorkspaceManager.getInstance().getCurrentWorkspace().eAdapters().add(
				new AdapterImpl() {
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

		contentProvider = new ESBrowserContentProvider(session);
		viewer.setContentProvider(contentProvider);

		viewer.setLabelProvider(new ESBrowserLabelProvider());

		viewer.setSorter(new ViewerSorter() {

            public int compare(Viewer viewer, Object e1, Object e2) {
                if (e1 instanceof ServerInfo && e2 instanceof ServerInfo){
                    return ((ServerInfo)e1).getDisplayName().toLowerCase().compareTo(
                            ((ServerInfo) e2).getDisplayName().toLowerCase());
                }else if(e1 instanceof ProjectInfo && e2 instanceof ProjectInfo){
                	return ((ProjectInfo)e1).getName().toLowerCase().compareTo(
                			((ProjectInfo) e2).getName().toLowerCase());
                }

                return super.compare(viewer, e1, e2);
            }
        });
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
		ESBrowserContentProvider provider = (ESBrowserContentProvider) viewer
				.getContentProvider();
		AccessControlHelper accessControl = provider.getAccesscontrolHelper();
		ISelection selection = viewer.getSelection();
		Object obj = ((IStructuredSelection) selection).getFirstElement();
		if (obj instanceof ServerInfo) {
			Usersession session = ((ServerInfo) obj).getLastUsersession();
			if (session != null && session.isLoggedIn()) {
				manager.add(new Separator("Userspace"));
				manager.add(serverChangeSession);
				try {
					accessControl.checkServerAdminAccess();
					manager.add(new Separator("Administrative"));
					manager.add(serverAddProject);
				} catch (EmfStoreException e) {
					// access denied
				}
				serverChangeSession.setText("Log out");
				manager.add(manageOrgUnits);

			} else if (session != null && !session.isLoggedIn()) {
				manager.add(new Separator("Userspace"));
				serverLogin.setText("Login as " + session.getUsername());
				manager.add(serverLogin);
				serverChangeSession.setText("Login as...");
				manager.add(serverChangeSession);
			} else {
				manager.add(serverLogin);
			}
			manager.add(new Separator());
			manager.add(deleteAction);
			manager.add(serverProperties);
		} else if (obj instanceof ProjectInfo) {
			manager.add(new Separator("Userspace"));
			manager.add(projectCheckout);
			manager.add(projectProperties);
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
				if (selection.isEmpty()) {
					return;
				}
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				viewer.collapseToLevel(obj, -1);
				viewer.expandToLevel(obj, -1);
			}
		};
		serverLogin.setText("Login...");
		serverLogin
				.setToolTipText("Click to login with the last used username");
		serverLogin.setImageDescriptor(Activator
				.getImageDescriptor("icons/serverLogin.png"));

		projectCheckout = new ProjectCheckoutAction();
		projectCheckout.setText("Checkout");
		projectCheckout.setToolTipText("Click to checkout this project");
		projectCheckout.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_TOOL_FORWARD));

		serverChangeSession = new ChangeSessionAction();
		serverChangeSession
				.setToolTipText("Click to login with a different username");
		serverChangeSession.setImageDescriptor(Activator
				.getImageDescriptor("icons/serverLoginAs.png"));

		serverAddProject = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				ServerInfo serverInfo = ((ServerInfo) obj);
				if (serverInfo.getLastUsersession().isLoggedIn()) {
					CreateProjectDialog dialog = new CreateProjectDialog(
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
		serverAddProject.setImageDescriptor(Activator
				.getImageDescriptor("icons/projectAdd.png"));

		serverProperties = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				ServerInfo serverInfo = ((ServerInfo) obj);
				RepositoryWizard wizard = new RepositoryWizard(
						ESBrowserView.this);
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
		serverProperties.setText("Edit");
		serverProperties
				.setToolTipText("Click to modify the server properties");
		serverProperties.setImageDescriptor(Activator
				.getImageDescriptor("icons/serverEdit.png"));

		addRepository = new Action() {
			@Override
			public void run() {
				RepositoryWizard wizard = new RepositoryWizard(
						ESBrowserView.this);
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
		addRepository.setImageDescriptor(Activator
				.getImageDescriptor("icons/serverAdd.png"));

		manageOrgUnits = new Action() {
			@Override
			public void run() {
				ManageOrgUnitsDialog dialog;
				try {
					ISelection selection = viewer.getSelection();
					Object obj = ((IStructuredSelection) selection)
							.getFirstElement();
					ServerInfo serverInfo = ((ServerInfo) obj);
					session = serverInfo.getLastUsersession();
					AdminBroker adminBroker = session.getAdminBroker();
					dialog = new ManageOrgUnitsDialog(PlatformUI.getWorkbench()
							.getDisplay().getActiveShell(), adminBroker);
					dialog.create();
					dialog.open();
				} catch (EmfStoreException e) {
					DialogHandler.showExceptionDialog(e);
				}
			}
		};
		manageOrgUnits.setText("Manage OrgUnits...");

		deleteAction = new DeleteAction();
		deleteAction.setText("Delete");
		deleteAction.setImageDescriptor(org.unicase.ui.common.Activator
				.getImageDescriptor("icons/delete.gif"));

		projectProperties = new PropertiesAction();
		projectProperties.setText("Properties");
		projectProperties.setImageDescriptor(Activator
				.getImageDescriptor("icons/info.png"));

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
