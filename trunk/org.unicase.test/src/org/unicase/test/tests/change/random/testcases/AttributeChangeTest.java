package org.unicase.test.tests.change.random.testcases;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.unicase.emfstore.esmodel.versioning.ChangePackage;
import org.unicase.model.ModelElement;
import org.unicase.test.tests.change.ChangeTestHelper;
import org.unicase.test.tests.change.random.ChangePackageTest;
import org.unicase.ui.test.TestProjectParmeters;
import org.unicase.workspace.ProjectSpace;

/**
 * This is a compare test. It takes randomly a ME from test project, changes one
 * of its EAttributes, extract changes from test project, applies changes to
 * compare project. Test succeeds when compare project and test project are
 * identical.
 * 
 * @author Hodaie
 * 
 */
public class AttributeChangeTest extends ChangePackageTest {

	
	
	 private ModelElement me;

	@SuppressWarnings("unused")
	private EAttribute attributeToChange; 
	private Object oldAttrValue;
	private Object newAttrValue;
	
	
	public AttributeChangeTest(ProjectSpace testProjectSpace, String testName,TestProjectParmeters testProjParams) {
		super(testProjectSpace, testName, testProjParams);

	}

	@Override
	public void runTest() {

		TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.unicase.EditingDomain");

		 me = ChangeTestHelper.getRandomME(getTestProject());
		 attributeToChange = ChangeTestHelper.getRandomAttribute(me);
		 

		domain.getCommandStack().execute(new RecordingCommand(domain) {

			@Override
			protected void doExecute() {
				changeAttribute();
			}

		});
		
	}

	protected void changeAttribute() {
		oldAttrValue = me.eGet(attributeToChange);
		ChangeTestHelper.changeSimpleAttribute(me, attributeToChange);
		newAttrValue = me.eGet(attributeToChange);
		
	}

	public int getExpectedNumOfChanges() {
		//expected num of changes is 1 or 0
		// 0 if new value of attribute is equal its old value. (notification is touch)
		if(oldAttrValue == null){
			return 1;
		}
		if(oldAttrValue.equals(newAttrValue)){
			return 0;
		}else{
			return 1;
		}
	}

	

	@Override
	public boolean isSuccessful(ChangePackage changePackage) {
		//temp impl
		return changePackage.getOperations().size() == getExpectedNumOfChanges();
	}

}
