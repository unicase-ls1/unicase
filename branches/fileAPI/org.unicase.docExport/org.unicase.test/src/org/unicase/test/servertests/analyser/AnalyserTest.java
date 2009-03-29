package org.unicase.test.servertests.analyser;

import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.test.TestCase;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.connectionmanager.ConnectionManager;

public class AnalyserTest extends TestCase {

	private ConnectionManager connectionManager;
	private SessionId sessionId;

	public AnalyserTest(String testName, SessionId sessionId) {
		super(testName);

		this.sessionId = sessionId;
		connectionManager = WorkspaceManager.getInstance().getConnectionManager();

	}

	@Override
	public void runTest() {

	}

	@Override
	public void outputResults(boolean outputToFile) {

	}
}
