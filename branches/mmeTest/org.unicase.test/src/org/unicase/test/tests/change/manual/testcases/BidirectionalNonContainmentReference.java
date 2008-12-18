package org.unicase.test.tests.change.manual.testcases;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.ModelElement;
import org.unicase.model.classes.ClassesFactory;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.classes.Dependency;
import org.unicase.model.classes.Package;
import org.unicase.test.tests.change.manual.ManualChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

public class BidirectionalNonContainmentReference extends ManualChangeTestCase {

	public BidirectionalNonContainmentReference(ProjectSpace testProjectSpace,
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

	protected void doRunTest() {
		Package p = ClassesFactory.eINSTANCE.createPackage();
		getTestProject().addModelElement(p);
		Dependency dependnecy = (Dependency) getTestProject().getModelElementsByClass(ClassesPackage.eINSTANCE.getDependency(), new BasicEList<ModelElement>()).get(0);
		p.getIncomingDependencies().add(dependnecy);
	}

	
	

}
