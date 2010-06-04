package org.unicase.test.servertests;

import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.test.TestSuite;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;

public class ServerTestSuite extends TestSuite {

	private ConnectionManager connectionManager;
	private String USERNAME = "super";

	public SessionId getLogIn() {
		return logIn;
	}

	private String PASSWORD = "test";
	private SessionId logIn;

	@Override
	protected void initTestCases() {
		if (logIn != null) {
			getTestCases().add(new ProjectStateTest("projectstate", logIn));
		}
	}

	@Override
	protected void initTestSuite() {
		try {
			connectionManager = WorkspaceManager.getInstance().getConnectionManager();
			initConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void initConnection() throws EmfStoreException {
		logIn = connectionManager.logIn(USERNAME, PASSWORD, ServerTestUtil.createServerInfo(), ServerTestUtil
			.createClientVersionInfo());
	}

	@Override
	protected void endTestSuite() {
	}
}
