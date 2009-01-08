package org.unicase.test.tests.change.manual.testcases;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.model.change.ChangePackage;
import org.unicase.model.change.MergingIssue;
import org.unicase.model.classes.ClassesPackage;
import org.unicase.model.classes.Dependency;
import org.unicase.model.classes.PackageElement;
import org.unicase.model.document.DocumentPackage;
import org.unicase.model.document.LeafSection;
import org.unicase.model.rationale.Issue;
import org.unicase.model.rationale.RationalePackage;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.manual.ManualChangeTestCase;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

public class AddSameMEToASingleNonContainmentRef extends ManualChangeTestCase {

	
	PackageElement pe;
	
	
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
		pe = dep.getTarget();
		
		MergingIssue mergingIssue = (MergingIssue)ChangeTestHelper.getRandomMEofType(getTestProject(), ChangePackage.eINSTANCE.getMergingIssue());

		@SuppressWarnings("unused")
		LeafSection leafSection = (LeafSection)ChangeTestHelper.getRandomMEofType(getTestProject(), DocumentPackage.eINSTANCE.getLeafSection());
		mergingIssue.eClass().getEAllGenericSuperTypes();
		mergingIssue.eClass().getEGenericSuperTypes();
		mergingIssue.eClass().getESuperTypes();
		mergingIssue.eClass().getEAllSuperTypes();
		
		Issue issue = (Issue)ChangeTestHelper.getRandomMEofType(getTestProject(),RationalePackage.eINSTANCE.getIssue());
		issue.eClass().getEAllGenericSuperTypes();
		issue.eClass().getEGenericSuperTypes();
		issue.eClass().getESuperTypes();
		issue.eClass().getEAllSuperTypes();
		
		issue.eClass().equals(RationalePackage.eINSTANCE.getIssue());
		
		ChangePackage.eINSTANCE.getMergingIssue().getESuperTypes();
		RationalePackage.eINSTANCE.getIssue().getESuperTypes().get(2).getESuperTypes().get(0).getESuperTypes();
				
		while(pe == null){
			dep = (Dependency)ChangeTestHelper.getRandomMEofType(getTestProject(), ClassesPackage.eINSTANCE.getDependency());
			pe = dep.getTarget();
		}
		
		dep.setTarget(pe);
	}

}
