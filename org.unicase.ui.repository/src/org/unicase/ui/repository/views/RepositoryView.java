package org.unicase.ui.repository.views;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.TreeExpansionEvent;
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
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.esmodel.ProjectInfo;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.provider.WorkspaceItemProviderAdapterFactory;

/**
 * View containing the remote repositories.
 * 
 * @author shterev
 * 
 */
public class RepositoryView extends ViewPart implements ITreeViewerListener {
	private TreeViewer viewer;
	private Action checkout;
	private Action addRepository;
	private Action login;
	private Action doubleClickAction;

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
		public Object[] getChildren(Object object) {
			if (object instanceof Workspace) {
				return ((Workspace) object).getServerInfos().toArray();
			} else if (object instanceof ServerInfo) {
				ServerInfo serverInfo = (ServerInfo) object;
				if (serverInfo.getUsersession() == null
						|| serverInfo.getUsersession().getUsername() == null) {
					Usersession session = WorkspaceFactory.eINSTANCE
							.createUsersession();
					session.setServerInfo(serverInfo);
					RepositoryLoginDialog dialog = new RepositoryLoginDialog(
							PlatformUI.getWorkbench().getDisplay()
									.getActiveShell(), session);
					dialog.setBlockOnOpen(true);
					dialog.create();
					dialog.open();
					try {
						serverInfo.getProjectInfos().addAll(
								session.getRemoteProjectList());
						serverInfo.setUsersession(session);
					} catch (EmfStoreException e) {
						e.printStackTrace();
					}
				}
				return (ProjectInfo[]) serverInfo.getProjectInfos().toArray();
			}
			return new Object[0];
		}

		/**
		 * {@inheritDoc}
		 */
		public boolean hasChildren(Object parent) {
			if (parent instanceof ServerInfo) {
				return true;
			}
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
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
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new WorkspaceRootContentProvider());
		viewer.setLabelProvider(new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE)));
		viewer.setSorter(new ViewerSorter());
		viewer.setInput(getViewSite());
		viewer.addTreeListener(this);

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(),
				"org.unicase.repositoryview.viewer");
		makeActions();
		hookContextMenu();
		// hookDoubleClickAction();
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
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(checkout);
	}

	private void fillContextMenu(IMenuManager manager) {
		ISelection selection = viewer.getSelection();
		Object obj = ((IStructuredSelection) selection).getFirstElement();
		if (obj instanceof ServerInfo) {
			manager.add(login);
		} else {
			manager.add(checkout);
		}
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(checkout);
		manager.add(addRepository);
	}

	private RepositoryView getViewInstance() {
		return this;
	}

	private void makeActions() {
		checkout = new Action() {
			public void run() {
				showMessage("Checking out ...");
			}
		};
		checkout.setText("Checkout");
		checkout.setToolTipText("Click to checkout this project");
		checkout.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOOL_FORWARD));

		login = new Action() {
			public void run() {

			}
		};
		login.setText("Login");
		login.setToolTipText("Click to log on the server");
		login.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT));

		addRepository = new Action() {
			public void run() {
				RepositoryWizard wizard = new RepositoryWizard(
						getViewInstance());
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
		addRepository.setImageDescriptor(PlatformUI.getWorkbench()
				.getSharedImages().getImageDescriptor(
						ISharedImages.IMG_TOOL_NEW_WIZARD));

		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				if (obj instanceof ServerInfo) {

				} else {
					checkout.run();
				}
			}
		};
	}

	@SuppressWarnings("unused")
	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}

	private void showMessage(String message) {
		MessageDialog.openInformation(viewer.getControl().getShell(),
				"Project Repositories", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	/**
	 * Actions to be executed when the tree node is collapsed.
	 * 
	 * @param event
	 *            a {@link TreeExpansionEvent}
	 */
	public void treeCollapsed(TreeExpansionEvent event) {
		// TODO Close the connection to the server

	}

	/**
	 * Actions to be executed when the tree node is expanded.
	 * 
	 * @param event
	 *            a {@link TreeExpansionEvent}
	 */
	public void treeExpanded(TreeExpansionEvent event) {
		// already implemented in getChildren() of the ContentProvider  
	}

	/**
	 * @return the {@link TreeViewer} for this view.
	 */
	public TreeViewer getViewer() {
		return viewer;
	}
}
