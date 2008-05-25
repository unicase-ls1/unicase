package org.unicase.esbrowser.views;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.AbstractTreeViewer;
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
import org.unicase.emfstore.exceptions.ConnectionException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.esmodel.EsmodelFactory;
import org.unicase.esmodel.ProjectInfo;
import org.unicase.esmodel.provider.EsmodelEditPlugin;
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
	private Action checkout;
	private Action addRepository;
	private Action login;
	private Action newProject;
	private HashMap<ProjectInfo, ServerInfo> projectServerMap = new HashMap<ProjectInfo, ServerInfo>();

	/**
	 * Action to be executed on a TreeViewer item.
	 *
	 */
	class EObjectAction extends Action {
		private EObject element;
		
		/**
		 * Sets the EObject for this Action.
		 * @param element the EObject
		 */
		public void setElement(EObject element) {
			this.element = element;
		}

		/**
		 * @return the EObject for this Action.
		 */
		public EObject getElement() {
			return this.element;
		}
	}

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
				Usersession session = serverInfo.getLastUsersession();
				if (session == null || session.getUsername() == null
						|| session.getPersistentPassword() == null) {
					RepositoryLoginDialog dialog = new RepositoryLoginDialog(
							PlatformUI.getWorkbench().getDisplay()
									.getActiveShell(), session);
					session = dialog.open();
				}
				if(session == null){
					return new Object[0];
				}
				try {
					session.logIn();
				} catch (EmfStoreException e) {
					// TODO server timed out
					e.printStackTrace();
				} catch (AccessControlException e) {
					// TODO wrong password/user
					e.printStackTrace();
				}
				try {
					serverInfo.getProjectInfos().addAll(
							session.getRemoteProjectList());
					serverInfo.setLastUsersession(session);
				} catch (EmfStoreException e) {
					e.printStackTrace();
				}
				EList<ProjectInfo> pis = serverInfo.getProjectInfos();
				for (ProjectInfo pi : pis) {
					projectServerMap.put(pi, serverInfo);
				}
				return (ProjectInfo[]) pis.toArray();
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
			manager.add(newProject);
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
		checkout = new EObjectAction() {
			public void run() {
				EObject element = this.getElement(); 
				if(element!=null){
					if(element instanceof ProjectInfo){
						ProjectInfo pi = (ProjectInfo)element;
						try {
							projectServerMap.get(pi).getLastUsersession().checkout(pi);
						} catch (EmfStoreException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		};
		checkout.setText("Checkout");
		checkout.setToolTipText("Click to checkout this project");
		checkout.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOOL_FORWARD));

		login = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				viewer.collapseToLevel(obj, AbstractTreeViewer.ALL_LEVELS);
				viewer.expandToLevel(obj, 1);
			}
		};
		login.setText("Login");
		login.setToolTipText("Click to log on the server");
		login.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT));

		newProject = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
				.getFirstElement();
				if(obj instanceof ServerInfo){
					ServerInfo serverInfo = ((ServerInfo)obj); 
					ProjectInfo newProjectInfo = EsmodelFactory.eINSTANCE.createProjectInfo();
					newProjectInfo.setName("newProject");
					serverInfo.getProjectInfos().add(newProjectInfo);
				}
				viewer.collapseToLevel(obj, AbstractTreeViewer.ALL_LEVELS);
				viewer.expandToLevel(obj, 1);
			}
		};
		newProject.setText("Create new project");
		newProject.setToolTipText("Click to create new project on the server");
		try {
			newProject.setImageDescriptor(ImageDescriptor.createFromURL
			        (new URL(EsmodelEditPlugin.INSTANCE.getImage("full/obj16/ProjectInfo").toString())));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

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
		try {
			addRepository.setImageDescriptor(ImageDescriptor.createFromURL
			        (new URL(WorkspaceEditPlugin.INSTANCE.getImage("full/obj16/ServerInfo").toString())));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				login.run();
			}
		});
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
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
