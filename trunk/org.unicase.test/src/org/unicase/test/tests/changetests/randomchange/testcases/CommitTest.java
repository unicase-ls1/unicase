package org.unicase.test.tests.changetests.randomchange.testcases;

import java.util.Calendar;
import java.util.List;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.accesscontrol.AccessControlException;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.model.Project;
import org.unicase.test.tests.changetests.randomchange.RandomChangeTestCase;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.ServerInfo;
import org.unicase.workspace.Usersession;
import org.unicase.workspace.WorkspaceFactory;

public class CommitTest extends RandomChangeTestCase {

	private List<RandomChangeTestCase> testCases;
	private Usersession userSession;
	private TransactionalEditingDomain domain;

	public CommitTest(String testName, long randomSeed,
			List<RandomChangeTestCase> testCases) {
		super(testName, randomSeed);
		this.testCases = testCases;
		userSession = WorkspaceFactory.eINSTANCE.createUsersession();

		ServerInfo serverInfo = WorkspaceFactory.eINSTANCE.createServerInfo();
		serverInfo.setPort(1099);
		serverInfo.setUrl("127.0.0.1");

		userSession.setServerInfo(serverInfo);
		userSession.setUsername("super");
		userSession.setPassword("super");

	}

	@Override
	public void setTestProjectSpace(ProjectSpace testProjectSpace) {

		super.setTestProjectSpace(testProjectSpace);
		try {
			userSession.logIn();
			domain = TransactionalEditingDomain.Registry.INSTANCE
					.getEditingDomain("org.unicase.EditingDomain");
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmfStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void setTestProject(Project testProject) {
		// TODO Auto-generated method stub
		super.setTestProject(testProject);
	}

	@Override
	public void runTest() {
		CompoundTest compoundTest = new CompoundTest("CompoundTest",
				getRandom().nextLong(), testCases);
		compoundTest.setTestProject(getTestProject());
		compoundTest.runTest();
	}

	@Override
	public void endTestCase() {

		final LogMessage logMessage = VersioningFactory.eINSTANCE
				.createLogMessage();
		logMessage.setAuthor(userSession.getUsername());
		logMessage.setDate(Calendar.getInstance().getTime());
		logMessage.setMessage("some message");
		domain.getCommandStack().execute(new RecordingCommand(domain) {
			@Override
			protected void doExecute() {
				try {
					getTestProjectSpace().commit(logMessage);
				} catch (EmfStoreException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	}

}
