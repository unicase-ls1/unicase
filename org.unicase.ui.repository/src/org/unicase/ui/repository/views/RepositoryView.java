package org.unicase.ui.repository.views;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.ITreeViewerListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeExpansionEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.unicase.esmodel.ProjectInfo;
import org.unicase.workspace.Configuration;
import org.unicase.workspace.ConnectionException;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;

/**
 * View containing the remote repositories.
 * @author shterev
 *
 */
public class RepositoryView extends ViewPart implements ITreeViewerListener{
	private TreeViewer viewer;
	private Action checkout;
	private Action addRepository;
	private ServerAction login;
	private Action doubleClickAction;

	/**
	 * Definition of a ProjectNode in the TreeViewer.
	 * @author shterev
	 */
	class ProjectNode implements IAdaptable {
		private String name;
		private ServerNode parent;

		/**
		 * Default constructor.
		 * @param name the name of the node
		 */
		public ProjectNode(String name) {
			this.name = name;
		}

		/**
		 * @return the name of the node.
		 */
		public String getName() {
			return name;
		}

		/**
		 * Sets the parenting ServerNode.
		 * @param parent the parent
		 */
		public void setParent(ServerNode parent) {
			this.parent = parent;
		}

		/**
		 * @return the parent node.
		 */
		public ServerNode getParent() {
			return parent;
		}
		
		/**
		 * {@inheritDoc}
		 */
		public String toString() {
			return getName();
		}

		/**
		 * Auto generated.
		 */
		public Object getAdapter(Class key) {
			return null;
		}
	}
	
	/**
	 * Definition for the ServerNode in the TreeViewer. 
	 * @author shterev
	 *
	 */
	class ServerNode extends ProjectNode {
		private ArrayList<ProjectNode> children;
		private ServerInfo serverInfo;
		
		/**
		 * Default constructor. 
		 * @param serverInfo the ServerInfo that the node is based upon
		 */
		public ServerNode(ServerInfo serverInfo) {
			super(serverInfo.getName());
			children = new ArrayList<ProjectNode>();
			this.serverInfo = serverInfo;
		}

		/**
		 * Method for adding a ProjectNode.
		 * @param child the child node
		 */
		public void addChild(ProjectNode child) {
			children.add(child);
			child.setParent(this);
		}

		/**
		 * Removes specific ProjectNode from the Tree.
		 * @param child the ProjectNode
		 */
		public void removeChild(ProjectNode child) {
			children.remove(child);
			child.setParent(null);
		}

		/**
		 * @return the children of the ServerNode.
		 */
		public ProjectNode[] getChildren() {
			return (ProjectNode[]) children.toArray(new ProjectNode[children
					.size()]);
		}

		/**
		 * @return if the ServerNode has children.
		 */
		public boolean hasChildren() {
			return children.size() > 0;
		}
		
		/**
		 * Removes all children.
		 */
		public void removeAll(){
			children.clear();
		}
	}

	/**
	 * Content provider for the tree view.
	 * @author shterev
	 *
	 */
	class ViewContentProvider implements IStructuredContentProvider,
			ITreeContentProvider {
		private ServerNode invisibleRoot;

		/**
		 * .
		 */
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}

		/**
		 * .
		 */
		public void dispose() {
		}

		/**
		 * @param parent the parent node.
		 * @return an array containing all nodes of the tree.
		 */
		public Object[] getElements(Object parent) {
			if (parent.equals(getViewSite())) {
				if (invisibleRoot == null){
					initialize();
				}
				return getChildren(invisibleRoot);
			}
			return getChildren(parent);
		}

		/**
		 * @return the parent of a given child
		 * @param child the child.
		 */
		public Object getParent(Object child) {
			if (child instanceof ProjectNode) {
				return ((ProjectNode) child).getParent();
			}
			return null;
		}

		/**
		 * @return the children of a given parent
		 * @param parent the parent
		 */
		public Object[] getChildren(Object parent) {
			if (parent instanceof ServerNode) {
				return ((ServerNode) parent).getChildren();
			}
			return new Object[0];
		}

		/**
		 * @return if the parent has children
		 * @param parent the parent
		 */
		public boolean hasChildren(Object parent) {
			if (parent instanceof ServerNode){
				return true;
			}
			return false;
		}

		/*
		 * We will set up a dummy model to initialize tree hierarchy. In a real
		 * code, you will connect to a real model and expose its hierarchy.
		 */
		private void initialize() {
			invisibleRoot = new ServerNode(Configuration.getDefaultServerInfo());
			invisibleRoot.children.clear();
			List<ServerInfo> servers = WorkspaceManager.getInstance().getCurrentWorkspace().getServerInfos();
			for (ServerInfo server : servers){
				invisibleRoot.addChild(new ServerNode(server));
			}
		}
	}
	
	// TODO: To be replaced with the EMF LabelProvider.
	class ViewLabelProvider extends LabelProvider {

		public String getText(Object obj) {
			return obj.toString();
		}

		public Image getImage(Object obj) {
			String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
			if (obj instanceof ServerNode)
				imageKey = ISharedImages.IMG_OBJ_FOLDER;
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					imageKey);
		}
	}

	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public RepositoryView() {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize.
	 * it.
	 * @param parent the parent
	 */
	public void createPartControl(Composite parent) {
		viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		viewer.addTreeListener(this);

		// Create the help context id for the viewer's control
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
		if (obj instanceof ServerNode) {
			manager.add(login);
		} else {
			manager.add(checkout);
		}
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(checkout);
		manager.add(addRepository);
	}
	
	/**
	 * Custom Action to contain the ServerNode.
	 * @author shterev
	 *
	 */
	private class ServerAction extends Action{
		protected ServerNode serverNode;
		public void setServerNode(ServerNode serverNode){
			this.serverNode = serverNode;
		}
	}
	
	private RepositoryView getViewInstance(){
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

		login = new ServerAction() {
			public void run() {
				try{
					Usersession session = WorkspaceFactory.eINSTANCE.createUsersession();
					session.setServerInfo(serverNode.serverInfo);
					RepositoryLoginDialog dialog = new RepositoryLoginDialog(getSite().getShell(), getViewInstance());
					dialog.setBlockOnOpen(true);
					List<ProjectInfo> projectInfos;
					try {
						projectInfos = session.getRemoteProjectList();
						serverNode.removeAll();
						for (ProjectInfo projectInfo : projectInfos){
							serverNode.addChild(new ProjectNode(projectInfo.getName()));
						}
						viewer.refresh();
					} catch (ConnectionException e) {e.printStackTrace();}
				}catch(NullPointerException e){
					showMessage("ServerInfo is not set for this ServerNode!");
				}
			}};
		login.setText("Login");
		login.setToolTipText("Click to log on the server");
		login.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJ_ELEMENT));

		
		addRepository = new Action() {
			public void run() {
				 RepositoryWizard wizard = new RepositoryWizard();
				  wizard.init(getSite().getWorkbenchWindow().getWorkbench(),
				            (IStructuredSelection)getSite().getWorkbenchWindow().getSelectionService().getSelection());
				  WizardDialog dialog = new WizardDialog(getSite().getWorkbenchWindow().getShell(), wizard);
				  dialog.create();
				  dialog.open();
			}
		};
		addRepository.setText("New repository...");
		addRepository.setToolTipText("Click to add new repository");
		addRepository.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_TOOL_NEW_WIZARD));
		
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection)
						.getFirstElement();
				if (obj instanceof ServerNode) {
					login.setServerNode((ServerNode)obj);
					login.run();
				} else {
					checkout.run();
				}
			}
		};
	}

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
	
//	/**
//	 * Adds new repository to the local model.
//	 * @param serverInfo the new repository
//	 */
//	public void addRepository(ServerInfo serverInfo){
//		ServerInfo newServer = WorkspaceFactory.eINSTANCE.createServerInfo();
//		newServer = serverInfo;
//		//TODO: Save locally the repository 
//	}

	/**
	 * Actions to be executed when the tree node is collapsed.
	 * @param event a {@link TreeExpansionEvent}
	 */
	public void treeCollapsed(TreeExpansionEvent event) {
		// TODO Close the connection to the server
		
	}

	/**
	 * Actions to be executed when the tree node is expanded.
	 * @param event a {@link TreeExpansionEvent}
	 */
	public void treeExpanded(TreeExpansionEvent event) {
		login.setServerNode(((ServerNode)event.getElement()));
		login.run();
	}
}
