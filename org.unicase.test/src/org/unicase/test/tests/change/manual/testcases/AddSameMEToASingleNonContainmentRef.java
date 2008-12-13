package org.unicase.test.tests.change.manual.testcases;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.classes.Dependency;
import org.unicase.model.classes.PackageElement;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.manual.ManualChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

public class AddSameMEToASingleNonContainmentRef extends ManualChangeTestCase {

	public AddSameMEToASingleNonContainmentRef(ProjectSpace testProjectSpace,
			String testName, TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);
		
	}

	@Override
	public void runTest() {
		
		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE.getEditingDomain("org.unicase.EditingDomain");
		domain.getCommandStack().execute(new RecordingCommand(domain){
			@Override
			public void doExecute(){ 
				doRunTest();
			}
		});
		
		

	}

	public void doRunTest() {

		Dependency dep = (Dependency)ChangeTestHelper.getRandomMEofType(getTestProject(), ClassesPackage.eINSTANCE.getDependency());
		PackageElement pe = dep.getTarget();
		while(pe == null){
			dep = (Dependency)ChangeTestHelper.getRandomMEofType(getTestProject(), ClassesPackage.eINSTANCE.getDependency());
			pe = dep.getTarget();
		}
		
		dep.setTarget(pe);
	}

}
