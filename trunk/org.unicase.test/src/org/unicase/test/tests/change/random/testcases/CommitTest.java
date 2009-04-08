package org.unicase.test.tests.change.random.testcases;

import java.util.Calendar;
import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.RandomChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;

public class CommitTest extends RandomChangeTestCase {

	private List<RandomChangeTestCase> testCases;
	private Usersession userSession;

	private TransactionalEditingDomain domain;

	public CommitTest(ProjectSpace testProjectSpace, String testName, TestProjectParmeters testProjParams,
		List<RandomChangeTestCase> testCases) {

		super(testProjectSpace, testName, testProjParams);
		this.testCases = testCases;
		userSession = WorkspaceFactory.eINSTANCE.createUsersession();

		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setPort(1099);
		serverInfo.setUrl("127.0.0.1");

		userSession.setServerInfo(serverInfo);
		userSession.setUsername("super");
		userSession.setPassword("super");

		domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
		try {
			userSession.logIn();
			domain.getCommandStack().execute(new RecordingCommand(domain) {
				@Override
				protected void doExecute() {
					try {
						getTestProjectSpace().shareProject(userSession);
					} catch (EmfStoreException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});

		} catch (AccessControlException e) {
			e.printStackTrace();
		} catch (EmfStoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void runTest() {
		CompositeTest compositeTest = new CompositeTest(getTestProjectSpace(), "CompositeTest", getTestProjParams(),
			testCases);
		compositeTest.runTest();
	}

	@Override
	public void outputResults(boolean outputToFile) {

		final LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		logMessage.setAuthor(userSession.getUsername());
		logMessage.setDate(Calendar.getInstance().getTime());
		logMessage.setMessage("some message");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				try {
					System.out.println(ChangeTestHelper.getChangePackage(getTestProjectSpace().getOperations(), true,
						false).getOperations().size()
						+ " operations.");
					getTestProjectSpace().commit(logMessage);
					System.out.println("commit successful!");

				} catch (Exception e) {
					System.out.println("commit failed!");
					e.printStackTrace();
				}
			}
		});

	}

}
