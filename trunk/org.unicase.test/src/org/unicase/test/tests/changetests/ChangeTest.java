package org.unicase.test.tests.changetests;

import java.util.Calendar;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.emfstore.esmodel.versioning.VersioningFactory;
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
		//getLogger().info("initializing test projectSpaces");
		System.out.println("initializing test projectSpaces");
		testSpace = ChangeTestHelper.createEmptyProjectSpace("test");
		long randomSeed = Calendar.getInstance().getTimeInMillis();
		testSpace.setProject(new TestProjectGenerator(5, randomSeed, 3, 2, 5, 10).generateProject());
		compareSpace = (ProjectSpace) EcoreUtil.copy(testSpace);


		final WorkspaceImpl currentWorkspace = (WorkspaceImpl) WorkspaceManager
				.getInstance().getCurrentWorkspace();

		domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				
				currentWorkspace.getProjectSpaces().add(testSpace);
				testSpace.initResources(currentWorkspace
						.getWorkspaceResourceSet());
				testSpace.init();
				compareSpace.initResources(currentWorkspace
						.getWorkspaceResourceSet());
				compareSpace.init();

			}

		});

		//getLogger().info();
		System.out.println("adding testcases");
		
		//RenameTest
		RenameTest renameTest = new RenameTest("Rename", Calendar.getInstance().getTimeInMillis());
		//reanmeTest.setParameters();
		this.getTestCases().add(renameTest);
		
		
		for(TestCase test : getTestCases()){
			test.setTestProject(testSpace.getProject());
		}
		
		
	}
	
	@Override
	public void compare(String testName) {
		// get changes(testProject)
		final List<AbstractOperation> operations = testSpace.getOperations();
		//getLogger().info( );
		System.out.println(testName + " test did " + operations.size() + " operations");
		final ChangePackage changePackage = VersioningFactory.eINSTANCE.createChangePackage();
		domain.getCommandStack().execute(new RecordingCommand(domain){

			@Override
			protected void doExecute() {
				changePackage.getOperations().addAll(operations);
				changePackage.cannonize();
				
			}
			
		});
		//getLogger().info();
		System.out.println("number of ops after cannonize: "  + changePackage.getOperations().size());
		
		// apply changes(compareProject)
		domain.getCommandStack().execute(new RecordingCommand(domain){
				@Override
				protected void doExecute() {
					System.out.println("applying changes to compareSpace...");
					changePackage.apply(compareSpace.getProject());
				}
			});
						
		// compare(testProejct, compareProject)
		System.out.println("comparing...");
		boolean areEqual = ModelUtil.areEqual(testSpace.getProject(), compareSpace.getProject());
		if(areEqual){
			//getLogger().info();
			System.out.println("Test was successful!");
		}else{
			//getLogger().info();
			System.out.println("Test failed!");
		}
	}



	@Override
	public void initTestCases() {
		// add test cases
		//getLogger().info("adding testcases");
		
		//DeleteTest
		//DeleteTest deleteTest = new DeleteTest();
		//deleteTest.setParameters();
		
		//MoveTest
		//MoveTest moveTest = new MoveTest();
		//moveTest.setParameters();

		//AddTest
		//AddTest addTest = new AddTest();
		//addTest.setParameters();
		
		//this.getTestCases().add(deleteTest);
		//this.getTestCases().add(moveTest);
		//this.getTestCases().add(addTest);
	}

	
	
	

	@Override
	public void end() {

	}

}
