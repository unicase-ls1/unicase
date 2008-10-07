package org.unicase.test.tests.changetests;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.unicase.test.lib.TestSuite;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.impl.WorkspaceImpl;

public class ChangeTest extends TestSuite {

	ProjectSpace testSpace;
	ProjectSpace compareSpace;
	
	private static Log logger = LogFactory.getLog(ChangeTest.class);
	
	@Override
	public void initialize() {
		logger.info("initializing test projectSpaces");
		testSpace = ChangeTestHelper.createEmptyProjectSpace("test");
		compareSpace = (ProjectSpace) EcoreUtil.copy(testSpace);
		
		WorkspaceImpl currentWorkspace = (WorkspaceImpl) WorkspaceManager.getInstance().getCurrentWorkspace();
		currentWorkspace.getProjectSpaces().add(testSpace);
		testSpace.initResources(currentWorkspace.getWorkspaceResourceSet());
		
		testSpace.init();
		
		logger.info("adding testcases");
		// add test cases
	}

	@Override
	public void end() {
		//getchanges
		//applychanges
		//compare
	}

	
}
