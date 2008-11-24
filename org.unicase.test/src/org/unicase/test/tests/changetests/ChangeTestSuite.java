package org.unicase.test.tests.changetests;

import java.util.Calendar;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.Project;
import org.unicase.test.lib.TestSuite;
import org.unicase.ui.test.TestProjectGenerator;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.impl.ProjectSpaceImpl;
import org.unicase.workspace.impl.WorkspaceImpl;


public abstract class ChangeTestSuite extends TestSuite {

	private Project testProject;
	private Project compareProject;
	
	private ProjectSpace testSpace;
	private ProjectSpace compareSpace;
	
	private Long randomSeed = Calendar.getInstance().getTimeInMillis();
	private TestProjectParmeters params;
	
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
		((ProjectSpaceImpl)compareSpace).stopChangeRecording();
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

	public Project getCompareProject(){
		
		if(testProject == null){
			testProject = getTestProject();
		}
		if(compareProject == null){
			System.out.println("coping test project");
			compareProject = (Project)EcoreUtil.copy(testProject);
			System.out.println("test project copied");
		}
		return compareProject;
	}
	

	public Project getTestProject(){
		if(testProject == null){
			System.out.println("creating test project");
			params = new TestProjectParmeters(5, randomSeed, 3, 2, 3, 10);
			testProject = new TestProjectGenerator(params).generateProject();
			System.out.println("test project created");
		}
		return testProject;
	}
	
	
	public long getRandomSeed(){
		return randomSeed;
	}
	
	public TestProjectParmeters getTestProjectPrams(){
		return params;
	}
	
}
