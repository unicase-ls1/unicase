package org.unicase.test.tests.changetests;

import java.util.Calendar;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.Project;
import org.unicase.model.util.ModelUtil;
import org.unicase.test.lib.TestSuite;
import org.unicase.ui.test.TestProjectGenerator;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.impl.WorkspaceImpl;


public class ChangeTestSuite extends TestSuite {

	private ProjectSpace testSpace;
	private ProjectSpace compareSpace;
	private TransactionalEditingDomain domain;



	@Override
	public void initTestSuite() {
		System.out.println("initializing test projectSpaces");
		testSpace = ChangeTestHelper.createEmptyProjectSpace("test");
		compareSpace = ChangeTestHelper.createEmptyProjectSpace("compare");

		Project project = getTestProject();
		Project copiedProject = getCompareProject();
		
		testSpace.setProject(project);
		compareSpace.setProject(copiedProject);
		
		final WorkspaceImpl currentWorkspace = (WorkspaceImpl) WorkspaceManager
				.getInstance().getCurrentWorkspace();

		domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				
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



	private Project getCompareProject() {
		//return ModelUtil.clone(project);
		return null;
	}

	private Project getTestProject() {
		long randomSeed = Calendar.getInstance().getTimeInMillis();
		return new TestProjectGenerator(5, randomSeed, 3, 2, 5, 10).generateProject();
	}
}
