package org.unicase.emfstore.test;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.EList;
import org.unicase.emfstore.EmfStore;
import org.unicase.emfstore.EmfStoreImpl;
import org.unicase.emfstore.accesscontrol.AuthenticationControl;
import org.unicase.emfstore.connection.ConnectionHandler;
import org.unicase.emfstore.esmodel.EsmodelFactory;
import org.unicase.emfstore.esmodel.ProjectInfo;
import org.unicase.emfstore.esmodel.SessionId;
import org.unicase.emfstore.esmodel.versioning.LogMessage;
import org.unicase.emfstore.esmodel.versioning.VersionSpec;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
import org.unicase.emfstore.exceptions.EmfStoreException;
import org.unicase.emfstore.exceptions.FatalEmfStoreException;
import org.unicase.model.ModelElement;
import org.unicase.model.Project;

/**
 * @author wesendonk
 */
public class TestDriver implements ConnectionHandler {


	// PROJECT GENERATOR
	// This configuration generates about 2500 elements
	// minimum number of each type of model element
	private int numOfEachME = 50;
	// number of sub-Sections in each composite section
	private int projectWidth = 2;
	// number of levels in project structure
	private int projectDepth = 3;
	// maximum number of references
	private int maxNumOfManyRefs = 5;
	// max number of model elements to show on a LeafSection
	private int maxNumOfMEsInLeafSection = 10;

	// random seed
	private int randomSeed = 1324151235;
	
	private Random random;

	// ------------------------

	private EmfStore emfStore;

	private static Log logger;

	public TestDriver() {
		logger = LogFactory.getLog(TestDriver.class);
		random = new Random(randomSeed);
		logger.info("initiated TestDriver to simulate connection.");
	}
	
	public void init(EmfStore emfStore, AuthenticationControl accessControl)
			throws FatalEmfStoreException {
		this.emfStore = emfStore;
		try {

			// TEST
			
			createTestProject();

			renameRandomly(4);
			
			renameRandomly(50);
			
			//
		} catch (EmfStoreException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Takes the first project and renames x elements randomly
	 * 
	 * @param x
	 *            elements to get renamed
	 * @throws EmfStoreException
	 *             exception
	 */
	private void renameRandomly(int x) throws EmfStoreException {
		List<ProjectInfo> projectList = emfStore.getProjectList(getSessionId());
		//get first Project
		if (projectList.size() > 0) {
			Project project = emfStore.getProject(getSessionId(), projectList.get(0)
					.getProjectId(), VersionSpec.HEAD_VERSION);
			//rename
			EList<ModelElement> allModelElements = project.getAllModelElements();
			for(int i = 0; i < x; i++) {
				int next = random.nextInt(allModelElements.size());
				ModelElement me = allModelElements.get(next);
				//me.setName(UUID.randomUUID().toString());
				me.setName("00rename test");
			
			}
			StopWatch watch = new StopWatch("Saving after renamed "+x+" elements.",true);
			((EmfStoreImpl) emfStore).save();
			watch.stop();
//			project.getAllModelElements().get()
		} else {
			logger.info("no projects on server.");
		}
	}

	/**
	 * Generates a project and saves it.
	 * 
	 * @throws EmfStoreException
	 *             exception
	 */
	public void createTestProject() throws EmfStoreException {
		StopWatch watch = new StopWatch("createTestProject", true);
		// dummy data in order to create a project
		SessionId sessionId = getSessionId();
		String name = "a test";
		String description = "a description";
		LogMessage logMessage = VersioningFactory.eINSTANCE.createLogMessage();
		logMessage.setAuthor(name);
		logMessage.setMessage(description);
		logMessage.setDate(new Date());
		Project project = (new TestProjectGenerator(numOfEachME, randomSeed,
				projectWidth, projectDepth, maxNumOfManyRefs,
				maxNumOfMEsInLeafSection)).generateProject();
		watch.setName("craeteTestProject with "+project.getAllModelElements().size()+" elements");
		watch.stopNgo();
		watch.setName("savingTestProject");
		emfStore.createProject(sessionId, name, description, logMessage,
				project);
		watch.stop();
	}

	private SessionId getSessionId() {
		SessionId sessionId = EsmodelFactory.eINSTANCE.createSessionId();
		return sessionId;
	}

	public void stop(boolean force) {
		// TODO Auto-generated method stub
	}

	public String getName() {
		// TODO Auto-generated method stub
		return "name";
	}

	private class StopWatch {

		private long timer;

		private String name;

		public StopWatch(String name, boolean start) {
			setName(name);
			if (start)
				start();
		}

		public void stopNgo() {
			stop();
			start();
		}

		public void start() {
			timer = System.nanoTime();
		}

		public void stop() {
			if (timer == 0)
				logger.info("start first.");
			logger.info("'" + name + "' took " + getTime() + " s");
			timer = 0;
		}

		private double getTime() {
			return Math.pow(10, -9) * ((double) (System.nanoTime() - timer));
		}

		public void setName(String name) {
			this.name = name;
		}
	}
}
