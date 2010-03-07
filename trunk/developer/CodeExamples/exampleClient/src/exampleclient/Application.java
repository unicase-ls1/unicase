package exampleclient;

import java.util.Date;
import java.util.List;

import library.Book;
import library.Library;
import library.LibraryFactory;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.AccessControlException;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.metamodel.Project;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.Workspace;
import org.unicase.workspace.WorkspaceFactory;
import org.unicase.workspace.WorkspaceManager;
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
		WorkspaceManager instance = WorkspaceManager.getInstance();
		Workspace workspace = instance.getCurrentWorkspace();
		
		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setName("localhost");
		serverInfo.setPort(8443);
		serverInfo.setUrl("localhost");
		serverInfo.setCertificateAlias("unicase.org test test(!!!) certificate");
		workspace.getServerInfos().add(serverInfo);
		workspace.save();
		
		Usersession usersession = WorkspaceFactory.eINSTANCE.createUsersession();
		usersession.setServerInfo(serverInfo);
		usersession.setUsername("super");
		usersession.setPassword("super");
		workspace.getUsersessions().add(usersession);
		workspace.save();
		
		usersession.logIn();
		List<ProjectInfo> projectList = usersession.getRemoteProjectList();
		ProjectInfo projectInfo = projectList.iterator().next();
		ProjectSpace projectSpace = usersession.checkout(projectInfo);
		
		Project project = projectSpace.getProject();
		Book book = LibraryFactory.eINSTANCE.createBook();
		book.setTitle("NEW TITLE");
		project.addModelElement(book);
		LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		logMessage.setAuthor("me");
		logMessage.setClientDate(new Date());
		logMessage.setMessage("Commit 1 from test client");
		projectSpace.commit(logMessage);
		
		Library library = LibraryFactory.eINSTANCE.createLibrary();
		project.addModelElement(library);
		library.getBooks().add(book);
		logMessage.setMessage("Commit 2 from test client");
		logMessage.setDate(new Date());
		projectSpace.commit(logMessage);
		System.out.println();
	}

	public void stop() {
		// TODO Auto-generated method stub

	}

}
