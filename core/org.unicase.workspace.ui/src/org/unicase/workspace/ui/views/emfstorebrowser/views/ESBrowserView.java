/**
 * <copyright> Copyright (c) 2008-2009 Jonas Helming, Maximilian Koegel. All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0 which accompanies this
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.workspace.ui.views.emfstorebrowser.views;

import java.util.ArrayList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.ui.common.exceptions.DialogHandler;
import org.unicase.ui.common.util.ActionHelper;
import org.unicase.ui.common.util.EventUtil;
import org.unicase.workspace.AdminBroker;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.accesscontrol.AccessControlHelper;
import org.unicase.workspace.ui.Activator;
import org.unicase.workspace.ui.views.emfstorebrowser.dialogs.admin.ManageOrgUnitsDialog;
import org.unicase.workspace.ui.views.emfstorebrowser.provider.ESBrowserContentProvider;
import org.unicase.workspace.ui.views.emfstorebrowser.provider.ESBrowserLabelProvider;
import org.unicase.workspace.util.UnicaseCommand;
import org.unicase.workspace.util.WorkspaceUtil;

/**
 * View containing the remote repositories.
 * 
 * @author shterev
 */
public class ESBrowserView extends ViewPart {
	/**
	 * Action to delete project on server.
	 * 
	 * @author koegel
	 */
	private final class DeleteProjectOnServerAction extends Action {
		@Override
		public void run() {
			ISelection selection = viewer.getSelection();
			Object obj = ((IStructuredSelection) selection).getFirstElement();
			ProjectInfo projectInfo = ((ProjectInfo) obj);
			MessageDialogWithToggle dialog = MessageDialogWithToggle.openOkCancelConfirm(PlatformUI.getWorkbench()
				.getDisplay().getActiveShell(), "Delete " + projectInfo.getName(), "Are you sure you want to delete \'"
				+ projectInfo.getName() + "\'", "Delete project contents (cannot be undone)", false, null, null);
			if (dialog.getReturnCode() == MessageDialog.OK) {
				Usersession session = contentProvider.getProjectServerMap().get(projectInfo).getLastUsersession();
				try {
					session.deleteProject(projectInfo.getProjectId(), dialog.getToggleState());
				} catch (EmfStoreException e) {
					DialogHandler.showExceptionDialog(e);
				}
				viewer.refresh();
			}
		}
	}

	/**
	 * Action to show properties.
	 * 
	 * @author helming
	 */
	private final class PropertiesAction extends Action {
		@Override
		public void run() {
			ISelection selection = viewer.getSelection();
			ProjectInfo projectInfo = ((ProjectInfo) ((IStructuredSelection) selection).getFirstElement());
			Usersession session = contentProvider.getProjectServerMap().get(projectInfo).getLastUsersession();
			int revision;
			try {
				revision = session.resolveVersionSpec(VersioningFactory.eINSTANCE.createHeadVersionSpec(),
					projectInfo.getProjectId()).getIdentifier();
				MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Project information",
					"Current revision: " + revision + "\nProjectId: " + projectInfo.getProjectId().getId());
			} catch (EmfStoreException e) {
				DialogHandler.showExceptionDialog(e);
			}
		}
	}

	/**
	 * Action to delete project.
	 * 
	 * @author helming
	 */
	private final class DeleteAction extends Action {
		@Override
		public void run() {
			ISelection selection = viewer.getSelection();
			ServerInfo serverInfo = ((ServerInfo) ((IStructuredSelection) selection).getFirstElement());
			EList<ProjectSpace> projectSpaces = WorkspaceManager.getInstance().getCurrentWorkspace().getProjectSpaces();
			ArrayList<ProjectSpace> usedSpaces = new ArrayList<ProjectSpace>();
			for (ProjectSpace projectSpace : projectSpaces) {
				if (projectSpace.getUsersession().getServerInfo().equals(serverInfo)) {
					usedSpaces.add(projectSpace);
				}
			}
			if (usedSpaces.size() > 0) {
				String message = "";
				for (ProjectSpace pSpace : usedSpaces) {
					message += "\n" + pSpace.getProjectName();
				}
				DialogHandler.showErrorDialog("Cannot delete \'" + serverInfo.getName()
					+ "\' because it is currently used by the following projects: \n" + message);
			} else {
				if (MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), "Confirm deletion",
					"Are you sure you want to delete \'" + serverInfo.getName() + "\'")) {
					TransactionalEditingDomain domain = Configuration.getEditingDomain();
					domain.getCommandStack().execute(DeleteCommand.create(domain, serverInfo));
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
	 */
	private final class ChangeSessionAction extends Action {
		@Override
		public void run() {
			ISelection selection = viewer.getSelection();
			Object obj = ((IStructuredSelection) selection).getFirstElement();
			final ServerInfo element = (ServerInfo) obj;
			new UnicaseCommand() {
				@Override
				protected void doRun() {
					try {
						element.getLastUsersession().logout();
					} catch (EmfStoreException e) {
						WorkspaceUtil.logException(e.getMessage(), e);
					}
					element.getLastUsersession().setSessionId(null);
					// reset the password in the RAM cache
					if (!element.getLastUsersession().isSavePassword()) {
						element.getLastUsersession().setPassword(null);
					}
					element.setLastUsersession(null);
					WorkspaceManager.getInstance().getCurrentWorkspace().save();
				}
			}.run();
			viewer.refresh(obj);
		}
	}

	/**
	 * Action for project checkout.
	 * 
	 * @author helming
	 */
	private final class ProjectCheckoutAction extends Action {
		/**
		 * Command for checkout.
		 * 
		 * @author koegel
		 */
		private final class CheckoutCommand extends UnicaseCommand {
			private final ProgressMonitorDialog progressDialog;
			private final ProjectInfo element;

			private CheckoutCommand(ProgressMonitorDialog progressDialog, ProjectInfo element) {
				this.progressDialog = progressDialog;
				this.element = element;
			}

			@Override
			protected void doRun() {
				try {
					progressDialog.open();
					progressDialog.getProgressMonitor().beginTask("Checkout project...", IProgressMonitor.UNKNOWN);
					ProjectSpace projectSpace = contentProvider.getProjectServerMap().get(element).getLastUsersession()
						.checkout(element);
					WorkspaceUtil.logCheckout(projectSpace, projectSpace.getBaseVersion());
					ActionHelper.openDashboard(projectSpace);
				} catch (EmfStoreException e) {
					DialogHandler.showExceptionDialog(e);
					// BEGIN SUPRESS CATCH EXCEPTION
				} catch (RuntimeException e) {
					DialogHandler.showExceptionDialog(e);
					WorkspaceUtil.logWarning("RuntimeException in " + ESBrowserView.class.getName(), e);
					// END SUPRESS CATCH EXCEPTION
				} finally {
					progressDialog.getProgressMonitor().done();
					progressDialog.close();
				}
			}
		}

		@Override
		public void run() {
			ISelection selection = viewer.getSelection();
			Object obj = ((IStructuredSelection) selection).getFirstElement();
			final ProjectInfo element = (ProjectInfo) obj;
			final ProgressMonitorDialog progressDialog = new ProgressMonitorDialog(PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell());
			new CheckoutCommand(progressDialog, element).run();
		}
	}

	private TreeViewer viewer;
	private Action projectCheckout;
	private Action addRepository;
	private Action serverLogin;
	private Action serverAddProject;
	private Action serverDeleteProject;
	private Action serverChangeSession;
	private Action serverProperties;
	private Action manageOrgUnits;
	private Usersession session;

	private ESBrowserContentProvider contentProvider;
	private Action deleteAction;
	private Action projectProperties;
	private ImportProjectHistoryAction importProjectHistoryAction;
	private ExportProjectHistoryAction exportProjectHistoryAction;

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

		contentProvider = new ESBrowserContentProvider(session);
		viewer.setContentProvider(contentProvider);

		viewer.setLabelProvider(new ESBrowserLabelProvider());

		viewer.setSorter(new ViewerSorter() {

			@Override
			public int compare(Viewer viewer, Object e1, Object e2) {
				if (e1 instanceof ServerInfo && e2 instanceof ServerInfo) {
					return ((ServerInfo) e1).getName().toLowerCase().compareTo(
						((ServerInfo) e2).getName().toLowerCase());
				} else if (e1 instanceof ProjectInfo && e2 instanceof ProjectInfo) {
					return ((ProjectInfo) e1).getName().toLowerCase().compareTo(
						((ProjectInfo) e2).getName().toLowerCase());
				}

				return super.compare(viewer, e1, e2);
			}
		});
		viewer.setInput(getViewSite());

		// This is a trick to show add repository action in context menu
		// whenever user right click on white area of ESBrowser.
		// It checks where has the user just right clicked, and if it is not the
		// tree then set the tree selection to
		// none.
		viewer.getTree().addMouseListener(new MouseListener() {
			public void mouseDoubleClick(MouseEvent e) {
			}

			public void mouseDown(MouseEvent e) {
				if (e.button == 3) {
					Point p = new Point(e.x, e.y);
					TreeItem treeItem = viewer.getTree().getItem(p);
					if (treeItem == null) {
						viewer.setSelection(TreeSelection.EMPTY);
					}
				}
			}

			public void mouseUp(MouseEvent e) {
			}
		});

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
		ESBrowserContentProvider provider = (ESBrowserContentProvider) viewer.getContentProvider();
		AccessControlHelper accessControl = provider.getAccesscontrolHelper();
		ISelection selection = viewer.getSelection();
		Object obj = ((IStructuredSelection) selection).getFirstElement();
		if (obj instanceof ServerInfo) {
			Usersession session = ((ServerInfo) obj).getLastUsersession();
			if (session != null && session.isLoggedIn()) {
				manager.add(new Separator("Userspace"));
				manager.add(serverChangeSession);
				if (accessControl == null) {
					accessControl = new AccessControlHelper(session);
				}
				try {
					accessControl.checkServerAdminAccess();
					manager.add(new Separator("Administrative"));
					manager.add(serverAddProject);
					importProjectHistoryAction.setUsersession(session);
					manager.add(importProjectHistoryAction);
					manager.add(manageOrgUnits);

				} catch (EmfStoreException e) {
					// access denied
				}
				serverChangeSession.setText("Log out");

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
			manager.add(projectCheckout);
			manager.add(projectProperties);
			if (accessControl == null) {
				accessControl = new AccessControlHelper(session);
			}
			try {
				accessControl.checkServerAdminAccess();
				manager.add(new Separator("Administrative"));
				exportProjectHistoryAction.setUsersession(accessControl.getUsersession());
				exportProjectHistoryAction.setProjectInfo((ProjectInfo) obj);
				manager.add(exportProjectHistoryAction);
				manager.add(serverDeleteProject);
			} catch (EmfStoreException e) {
				// access denied
			}
		} else if (obj == null) {
			manager.add(addRepository);
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
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				viewer.collapseToLevel(obj, -1);
				viewer.expandToLevel(obj, -1);
			}
		};
		serverLogin.setText("Login...");
		serverLogin.setToolTipText("Click to login with the last used username");
		serverLogin.setImageDescriptor(Activator.getImageDescriptor("icons/serverLogin.png"));

		projectCheckout = new ProjectCheckoutAction();
		projectCheckout.setText("Checkout");
		projectCheckout.setToolTipText("Click to checkout this project");
		projectCheckout.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(
			ISharedImages.IMG_TOOL_FORWARD));

		serverChangeSession = new ChangeSessionAction();
		serverChangeSession.setToolTipText("Click to login with a different username");
		serverChangeSession.setImageDescriptor(Activator.getImageDescriptor("icons/serverLoginAs.png"));

		serverAddProject = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				ServerInfo serverInfo = ((ServerInfo) obj);
				if (serverInfo.getLastUsersession().isLoggedIn()) {
					CreateProjectDialog dialog = new CreateProjectDialog(PlatformUI.getWorkbench().getDisplay()
						.getActiveShell(), serverInfo.getLastUsersession());
					dialog.open();
					viewer.refresh(obj);
				}
			}
		};
		serverAddProject.setText("Create new project...");
		serverAddProject.setToolTipText("Click to create new project on the server");
		serverAddProject.setImageDescriptor(Activator.getImageDescriptor("icons/projectAdd.png"));

		serverDeleteProject = new DeleteProjectOnServerAction();
		serverDeleteProject.setText("Delete on server");
		serverDeleteProject.setToolTipText("Delete this project on the server");
		serverDeleteProject.setImageDescriptor(org.unicase.ui.common.Activator.getImageDescriptor("icons/delete.gif"));

		serverProperties = new Action() {
			@Override
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				ServerInfo serverInfo = ((ServerInfo) obj);
				NewRepositoryWizard wizard = new NewRepositoryWizard(ESBrowserView.this);
				wizard.init(getSite().getWorkbenchWindow().getWorkbench(), (IStructuredSelection) getSite()
					.getWorkbenchWindow().getSelectionService().getSelection(), serverInfo);
				WizardDialog dialog = new WizardDialog(getSite().getWorkbenchWindow().getShell(), wizard);
				dialog.create();
				dialog.open();
			}
		};
		serverProperties.setText("Edit");
		serverProperties.setToolTipText("Click to modify the server properties");
		serverProperties.setImageDescriptor(Activator.getImageDescriptor("icons/serverEdit.png"));

		addRepository = new Action() {
			@Override
			public void run() {
				NewRepositoryWizard wizard = new NewRepositoryWizard(ESBrowserView.this);
				wizard.init(getSite().getWorkbenchWindow().getWorkbench(), (IStructuredSelection) getSite()
					.getWorkbenchWindow().getSelectionService().getSelection());
				WizardDialog dialog = new WizardDialog(getSite().getWorkbenchWindow().getShell(), wizard);
				dialog.create();
				dialog.open();
			}
		};
		addRepository.setText("New repository...");
		addRepository.setToolTipText("Click to add new repository");
		addRepository.setImageDescriptor(Activator.getImageDescriptor("icons/serverAdd.png"));

		manageOrgUnits = new Action() {
			@Override
			public void run() {
				ManageOrgUnitsDialog dialog;
				try {
					ISelection selection = viewer.getSelection();
					Object obj = ((IStructuredSelection) selection).getFirstElement();
					ServerInfo serverInfo = ((ServerInfo) obj);
					session = serverInfo.getLastUsersession();
					AdminBroker adminBroker = session.getAdminBroker();
					dialog = new ManageOrgUnitsDialog(PlatformUI.getWorkbench().getDisplay().getActiveShell(),
						adminBroker);
					dialog.create();
					dialog.open();
				} catch (EmfStoreException e) {
					DialogHandler.showExceptionDialog(e);
				}
			}
		};
		manageOrgUnits.setText("Manage Users/Groups...");
		manageOrgUnits.setImageDescriptor(Activator.getImageDescriptor("icons/Group.gif"));

		deleteAction = new DeleteAction();
		deleteAction.setText("Delete");
		deleteAction.setImageDescriptor(org.unicase.ui.common.Activator.getImageDescriptor("icons/delete.gif"));

		projectProperties = new PropertiesAction();
		projectProperties.setText("Properties");
		projectProperties.setImageDescriptor(Activator.getImageDescriptor("icons/info.png"));

		createImportExportProjectHistoryActions();

	}

	private void createImportExportProjectHistoryActions() {
		importProjectHistoryAction = new ImportProjectHistoryAction();
		importProjectHistoryAction.setText("Import Project History...");
		importProjectHistoryAction.setImageDescriptor(Activator.getImageDescriptor("icons/import.gif"));

		exportProjectHistoryAction = new ExportProjectHistoryAction();
		exportProjectHistoryAction.setText("Export Project History...");
		exportProjectHistoryAction.setImageDescriptor(Activator.getImageDescriptor("icons/export.gif"));

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
		EventUtil.logFocusEvent("org.unicase.ui.repository.views.RepositoryView");
	}

	/**
	 * @return the {@link TreeViewer} for this view.
	 */
	public TreeViewer getViewer() {
		return viewer;
	}

}
