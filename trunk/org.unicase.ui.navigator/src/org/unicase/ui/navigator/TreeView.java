package org.unicase.ui.navigator;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonNavigator;
import org.unicase.model.ModelElement;
import org.unicase.model.diagram.MEDiagram;
import org.unicase.ui.meeditor.MEEditorInput;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceManager;


public class TreeView extends CommonNavigator {

	@Override
	protected IAdaptable getInitialInput() {

		Workspace workspace = WorkspaceManager.getInstance()
		.getCurrentWorkspace();
		
//		Usersession usersession = WorkspaceFactory.eINSTANCE
//				.createUsersession();
//		usersession.setServerInfo(workspace.getServerInfos().get(0));
//		usersession.setUsername("user");
//		usersession.setPassword("password");
//		usersession.setSavePassword(true);
//		workspace.getUsersessions().add(usersession);
//		
//		if (workspace.getProjectSpaces().size() < 2) {
//
//			ProjectInfo projectInfo;
//			try {
//				try {
//					usersession.logIn();
//				} catch (AccessControlException e) {
//					// MK Auto-generated catch block
//					e.printStackTrace();
//				}
//				projectInfo = usersession.getRemoteProjectList().get(0);
//				usersession.checkout(projectInfo);
//				projectInfo = usersession.getRemoteProjectList().get(0);
//				ProjectSpace checkout = usersession.checkout(projectInfo);
//				
//				
//
//			} catch (EmfStoreException e) {
//				// MK Auto-generated catch block
//				e.printStackTrace();
//				throw new IllegalStateException();
//			}
//		}

		return workspace;

	}
	
	/**.
	 * ({@inheritDoc})
	 * On DoubleClick open the ModelElement in Editor
	 */
	@Override
	protected void handleDoubleClick(DoubleClickEvent anEvent) {
		
		TreeSelection selection = (TreeSelection) anEvent.getSelection();
		Object object = selection.getFirstElement();
		if (object instanceof ModelElement) {
			if (object instanceof MEDiagram) {
				MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),"Problem", "Diagrams are not yet supported");
			} else {
				MEEditorInput input = new MEEditorInput((ModelElement) object);
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage().openEditor(input,
									"org.unicase.ui.meeditor", true);
				} catch (PartInitException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	

}
