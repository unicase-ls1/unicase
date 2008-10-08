package org.unicase.test.tests.changetests;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.operations.AbstractOperation;
import org.unicase.model.util.ModelUtil;
import org.unicase.test.lib.TestCase;
import org.unicase.test.lib.TestSuite;
import org.unicase.ui.test.TestProjectGenerator;
import org.unicase.workspace.ProjectSpace;
import org.unicase.workspace.WorkspaceManager;
import org.unicase.workspace.impl.WorkspaceImpl;


public class ChangeTest extends TestSuite {

	private ProjectSpace testSpace;
	private ProjectSpace compareSpace;
	private TransactionalEditingDomain domain;



	@Override
	public void initialize() {
		getLogger().info("initializing test projectSpaces");
		testSpace = ChangeTestHelper.createEmptyProjectSpace("test");
		testSpace.setProject(new TestProjectGenerator(5, 123343, 3, 3, 5, 10).generateProject());
		compareSpace = (ProjectSpace) EcoreUtil.copy(testSpace);


		final WorkspaceImpl currentWorkspace = (WorkspaceImpl) WorkspaceManager
				.getInstance().getCurrentWorkspace();

		domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				// TODO Auto-generated method stub
				currentWorkspace.getProjectSpaces().add(testSpace);
				testSpace.initResources(currentWorkspace
						.getWorkspaceResourceSet());
				testSpace.init();

			}

		});

		getLogger().info("adding testcases");
		//DeleteTest
		//DeleteTest deleteTest = new DeleteTest();
		//deleteTest.setParameters();
		
		//MoveTest
		//MoveTest moveTest = new MoveTest();
		//moveTest.setParameters();

		//RenameTest
		RenameTest renameTest = new RenameTest("Rename", 123456);
		//reanmeTest.setParameters();

		//AddTest
		//AddTest addTest = new AddTest();
		//addTest.setParameters();
		
		//this.getTestCases().add(deleteTest);
		//this.getTestCases().add(moveTest);
		this.getTestCases().add(renameTest);
		//this.getTestCases().add(addTest);
		
		for(TestCase test : getTestCases()){
			test.setTestProject(testSpace.getProject());
		}
		
		getLogger().info("adding testcases");
	}

	@Override
	public void initTestCases() {
		// add test cases

	}

	
	
	@Override
	public void compare(String testName) {
		// get changes(testProject)
		List<AbstractOperation> operations = testSpace.getOperations();
		getLogger().info(testName + " test did " + operations.size() + " operations" );
		
		// apply changes(compareProject)
		for(final AbstractOperation op : operations){
			domain.getCommandStack().execute(new RecordingCommand(domain){
				@Override
				protected void doExecute() {
					if(op.canApply(compareSpace.getProject())){
						op.apply(compareSpace.getProject());
					}
				}
			});
		}
				
		// compare(testProejct, compareProject)
		boolean areEqual = ModelUtil.areEqual(testSpace.getProject(), compareSpace.getProject());
		if(areEqual){
			getLogger().info("Test was successful!");
		}else{
			getLogger().info("Test failed!");
		}
	}



	@Override
	public void end() {

	}

}
