package org.unicase.test.tests.changetests;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.Project;
import org.unicase.test.lib.TestSuite;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.impl.WorkspaceImpl;


public abstract class ChangeTestSuite extends TestSuite {

	private ProjectSpace testSpace;
	private ProjectSpace compareSpace;
	private TransactionalEditingDomain domain;



	public ProjectSpace getTestProjectSpace() {
		return testSpace;
	}

	public ProjectSpace getCompareProjectSpace() {
		return compareSpace;
	}

	@Override
	public void initTestSuite() {
		System.out.println("initializing test projectSpaces");
		testSpace = ChangeTestHelper.createEmptyProjectSpace("test");
		compareSpace = ChangeTestHelper.createEmptyProjectSpace("compare");
		
		final WorkspaceImpl currentWorkspace = (WorkspaceImpl) WorkspaceManager
				.getInstance().getCurrentWorkspace();

		domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				getTestProjectSpace().setProject(getTestProject());
				getCompareProjectSpace().setProject(getCompareProject());
				testSpace.initResources(currentWorkspace
						.getWorkspaceResourceSet());
				compareSpace.initResources(currentWorkspace
						.getWorkspaceResourceSet());
				EList<ProjectSpace> projectSpaces = currentWorkspace.getProjectSpaces();
				projectSpaces.add(testSpace);
				projectSpaces.add(compareSpace);
				
				currentWorkspace.save();

			}

		});
	}

	abstract public Project getCompareProject();

	abstract public Project getTestProject(); 
}
