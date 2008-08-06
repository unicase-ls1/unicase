package org.unicase.emfstore.test;

import java.util.Date;

import org.unicase.emfstore.EmfStore;
import org.unicase.emfstore.accesscontrol.AuthenticationControl;
import org.unicase.emfstore.connection.ConnectionHandler;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.model.Project;

/**
 * @author wesendonk
 */
public class TestDriver implements ConnectionHandler {

	// PROJECT GENERATOR
	// minimum number of each type of model element
	private int numOfEachME = 5;
	// number of sub-Sections in each composite section
	private int projectWidth = 2;
	// number of levels in project structure
	private int projectDepth = 2;
	// maximum number of references
	private int maxNumOfManyRefs = 5;
	// max number of model elements to show on a LeafSection
	private int maxNumOfMEsInLeafSection = 10;

	// random seed
	private int randomSeed = 1324151235;

	// ------------------------

	private EmfStore emfStore;

	public void init(EmfStore emfStore, AuthenticationControl accessControl)
			throws FatalEmfStoreException {
		this.emfStore = emfStore;

		// TEST

		// createTestProject();
		
		//
	}

	public void createTestProject() throws EmfStoreException {
		// dummy data in order to create a project
		SessionId sessionId = EsmodelFactory.eINSTANCE.createSessionId();
		String name = "a test";
		String description = "a description";
		LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		logMessage.setAuthor(name);
		logMessage.setMessage(description);
		logMessage.setDate(new Date());
		Project project = (new TestProjectGenerator(numOfEachME, randomSeed,
				projectWidth, projectDepth, maxNumOfManyRefs,
				maxNumOfMEsInLeafSection)).generateProject();
		emfStore.createProject(sessionId, name, description, logMessage,
				project);
	}

	public void stop(boolean force) {
		// TODO Auto-generated method stub
	}

	public String getName() {
		// TODO Auto-generated method stub
		return "name";
	}
}
