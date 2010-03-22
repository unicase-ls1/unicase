package exampleclient;

import java.util.List;

import library.Book;
import library.Library;
import library.LibraryFactory;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.util.EMFStoreClientUtil;
import org.unicase.workspace.util.UnicaseCommand;

public class Application implements IApplication {

	public Object start(IApplicationContext context) throws Exception {
		
		WorkspaceManager.getInstance();
		new UnicaseCommand() {

			@Override
			protected void doRun() {
				try {
					runClient();
				} catch (AccessControlException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (EmfStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.run();
		
		return IApplication.EXIT_OK;
	}

	private void runClient() throws AccessControlException, EmfStoreException {
		System.out.println("Client starting...");
		
		Usersession usersession = EMFStoreClientUtil.createUsersession();
		
		usersession.logIn();
		List<ProjectInfo> projectList = usersession.getRemoteProjectList();
		ProjectInfo projectInfo = projectList.iterator().next();
		ProjectSpace projectSpace = usersession.checkout(projectInfo);
		
		Project project = projectSpace.getProject();
		Book book = LibraryFactory.eINSTANCE.createBook();
		book.setTitle("NEW TITLE");
		project.addModelElement(book);
		
		projectSpace.commit();
		
		Library library = LibraryFactory.eINSTANCE.createLibrary();
		project.addModelElement(library);
		library.getBooks().add(book);
		
		projectSpace.commit();
		
		System.out.println("Client run completed.");
	}

	public void stop() {
		// TODO Auto-generated method stub

	}

}
